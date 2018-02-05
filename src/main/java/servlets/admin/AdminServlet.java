package servlets.admin;

import dao.DAOFactory;
import models.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/admin", name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("entered") != null && (boolean)request.getSession().getAttribute("entered")) {
            List<Good> goods = new ArrayList<>();
            goods.addAll(DAOFactory.getInstance().getClothesDAO().getAll());
            goods.addAll(DAOFactory.getInstance().getCutleryDAO().getAll());
            goods.addAll(DAOFactory.getInstance().getTrifleDAO().getAll());

            request.setAttribute("goods", goods);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else request.getRequestDispatcher("authorization.html").include(request, response);
    }
}
