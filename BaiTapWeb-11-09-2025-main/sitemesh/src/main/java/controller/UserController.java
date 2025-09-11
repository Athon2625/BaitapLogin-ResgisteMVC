package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/user/profile")
@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*10)
public class UserController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long defaultUserId = 1L; // lấy user mặc định
        User user = userService.getById(defaultUserId);

        if(user == null){
            response.getWriter().println("User not found!");
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("/common/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long defaultUserId = 1L;
        User user = userService.getById(defaultUserId);

        user.setFullname(request.getParameter("fullname"));
        user.setPhone(request.getParameter("phone"));

        Part filePart = request.getPart("image");
        if(filePart != null && filePart.getSize() > 0){
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString()
                              .replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");

            String uploadDir = getServletContext().getRealPath("/uploads");
            File dir = new File(uploadDir);
            if(!dir.exists()) dir.mkdirs();

            File file = new File(dir, fileName);
            try(InputStream in = filePart.getInputStream();
                FileOutputStream out = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int len;
                while((len = in.read(buffer)) != -1){
                    out.write(buffer, 0, len);
                }
            }

            user.setImage(fileName);
        }

        userService.save(user);

        request.setAttribute("user", user);
        request.setAttribute("success", "Profile updated successfully!");
        request.getRequestDispatcher("/common/profile.jsp").forward(request, response);
    }
}
