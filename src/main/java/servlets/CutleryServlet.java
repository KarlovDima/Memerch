package servlets;

import dao.DAOFactory;
import models.Cutlery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/cutlery", name = "CutleryServlet")
public class CutleryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cutlery> cutleryList = DAOFactory.getInstance().getCutleryDAO().getAll();

        request.setAttribute("goods", cutleryList);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }
}
