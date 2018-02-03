package servlets;

import dao.DAOFactory;
import models.Clothes;
import models.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/clothes", name = "ClothesServlet")
public class ClothesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("category") != null)
            request.getRequestDispatcher("good").forward(request, response);

        List<Clothes> clothesList = DAOFactory.getInstance().getClothesDAO().getAll();

        request.setAttribute("goods", clothesList);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }
}
