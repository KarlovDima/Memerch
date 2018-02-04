package servlets.user;

import dao.DAOFactory;
import models.Good;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/homepage", name = "HomepageServlet")
public class HomepageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if (request.getParameter("category") != null)
            request.getRequestDispatcher("good").forward(request, response);

        List<Good> goods = new ArrayList<>();
        goods.addAll(DAOFactory.getInstance().getClothesDAO().getAll());
        goods.addAll(DAOFactory.getInstance().getCutleryDAO().getAll());
        goods.addAll(DAOFactory.getInstance().getTrifleDAO().getAll());

        Collections.shuffle(goods);

        request.setAttribute("goods", goods);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }
}
