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
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(value = "/admin", name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("entered") != null && (boolean) request.getSession().getAttribute("entered")) {
            List<Good> goods = new ArrayList<>();
            goods.addAll(DAOFactory.getInstance().getClothesDAO().getAll());
            goods.addAll(DAOFactory.getInstance().getCutleryDAO().getAll());
            goods.addAll(DAOFactory.getInstance().getTrifleDAO().getAll());

            if (request.getParameter("searching") != null)
                goods = search(goods, request.getParameter("searching"));

            if (request.getParameter("sorting") != null)
                goods = sort(goods, request.getParameter("sorting"));

            request.setAttribute("goods", goods);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else request.getRequestDispatcher("authorization.html").include(request, response);
    }

    private List<Good> search(List<Good> goods, String sortingType) {
        return goods.stream().filter(good -> good.getName().toLowerCase().contains(sortingType.toLowerCase())).collect(Collectors.toList());
    }

    private List<Good> sort(List<Good> goods, String sortingType) {
        if (sortingType.equals("ascending"))
            return goods.stream().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).collect(Collectors.toList());
        else
            return goods.stream().sorted((o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName())).collect(Collectors.toList());
    }
}
