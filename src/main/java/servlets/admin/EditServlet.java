package servlets.admin;

import dao.DAOFactory;
import dao.GenericDAO;
import models.Clothes;
import models.Cutlery;
import models.Good;
import models.Trifle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit", name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("entered") != null && (boolean) request.getSession().getAttribute("entered")) {
            String category = request.getParameter("category");

            if (request.getParameter("name") != null)
                editGood(request, category);

            forwardToEditPage(request, response, category);

        } else request.getRequestDispatcher("authorization.html").include(request, response);
    }

    private void editGood(HttpServletRequest request, String category) throws ServletException, IOException {
        getGoodDAO(category).update(createGoodByRequest(request, category));
    }

    private Good createGoodByRequest(HttpServletRequest request, String category) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        float price = Float.parseFloat(request.getParameter("price"));
        String mem = request.getParameter("mem");
        String material = request.getParameter("material");
        String parameter = request.getParameter("parameter");

        switch (category) {
            case "clothes":
                return new Clothes(id, name, producer, price, mem, material, parameter);
            case "cutlery":
                return new Cutlery(id, name, producer, price, mem, material, parameter);
            default:
                return new Trifle(id, name, producer, price, mem, material, Integer.parseInt(parameter));
        }
    }

    private void forwardToEditPage(HttpServletRequest request, HttpServletResponse response, String category) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("good", getGoodDAO(category).getEntityById(id));
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private GenericDAO getGoodDAO(String category) {
        switch (category) {
            case "clothes":
                return DAOFactory.getInstance().getClothesDAO();
            case "cutlery":
                return DAOFactory.getInstance().getCutleryDAO();
            default:
                return DAOFactory.getInstance().getTrifleDAO();
        }
    }
}
