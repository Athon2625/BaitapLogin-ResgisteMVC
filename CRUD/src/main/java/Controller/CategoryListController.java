package Controller;

import Model.Category;
import Service.CategoryService;
import ServiceImplement.CategoryServiceImpl;
import com.mongodb.client.MongoDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/category/list"})
public class CategoryListController extends HttpServlet {
    private CategoryService cateService;

    @Override
    public void init() throws ServletException {
        MongoDatabase database = (MongoDatabase) getServletContext().getAttribute("MONGO_DB");
        cateService = new CategoryServiceImpl(database);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Category> cateList = cateService.getAll();
        req.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/listcategory.jsp");
        dispatcher.forward(req, resp);
    }
}
