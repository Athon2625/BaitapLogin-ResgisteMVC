package Controller;

import Model.Category;
import Service.CategoryService;
import ServiceImplement.CategoryServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/category/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward đến trang addcategory.jsp
        request.getRequestDispatcher("/addcategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String name = request.getParameter("cateName");
        String icon = request.getParameter("icons");

        // Tạo object Category
        Category category = new Category();
        category.setCateName(name);
        category.setIcons(icon);

        // Gọi service lưu vào DB
        categoryService.insert(category);

        // Sau khi thêm xong -> quay lại list category
        response.sendRedirect(request.getContextPath() + "/admin/category/list");
    }
}
