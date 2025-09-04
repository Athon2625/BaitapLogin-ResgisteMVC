package Controller;

import Model.Category;
import Service.CategoryService;
import ServiceImplement.CategoryServiceImpl;
import com.mongodb.client.MongoDatabase;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryEditController extends HttpServlet {
    private CategoryService cateService;

    @Override
    public void init() throws ServletException {
        MongoDatabase database = (MongoDatabase) getServletContext().getAttribute("MONGO_DB");
        cateService = new CategoryServiceImpl(database);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = cateService.getById(id);
        req.setAttribute("category", category);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editcategory.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("cate_name");
        String icon = req.getParameter("icons");

        Category category = new Category(id, name, icon);
        cateService.update(category);

        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
