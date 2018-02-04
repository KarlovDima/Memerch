package servlets.user;

import dao.DAOFactory;
import models.Cutlery;
import models.Trifle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/trifles", name = "TrifleServlet")
public class TrifleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("category") != null)
            request.getRequestDispatcher("good").forward(request, response);

        List<Trifle> trifleList = DAOFactory.getInstance().getTrifleDAO().getAll();

        request.setAttribute("goods", trifleList);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }
}
