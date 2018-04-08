package servlets.user;

import dao.DAOFactory;
import models.Good;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        if (request.getParameter("sort") != null)
            goods = sort(goods, request.getParameter("sort"));

        request.setAttribute("goods", goods);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }

    private List<Good> sort(List<Good> goods, String sortingType) {
        switch (sortingType) {
            case "lowToHigh":
                return goods.stream().sorted((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice())).collect(Collectors.toList());
            case "highToLow":
                return goods.stream().sorted((o1, o2) -> Float.compare(o2.getPrice(), o1.getPrice())).collect(Collectors.toList());
            case "aToZ":
                return goods.stream().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).collect(Collectors.toList());
            case "zToA":
                return goods.stream().sorted((o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName())).collect(Collectors.toList());
            default:
                return goods;
        }
    }
}
