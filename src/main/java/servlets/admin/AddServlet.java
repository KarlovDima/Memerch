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

@WebServlet(value = "/add", name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("name") != null) {
            createGoodByRequest(request);
            response.sendRedirect("admin");
        } else {
            request.setAttribute("parameterName", getParameter(request.getParameter("category")));
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }

    private String getParameter(String category) {
        switch (category) {
            case "clothes":
                return "Size";
            case "cutlery":
                return "Volume";
            case "trifle":
                return "Amount";
            default:
                return "";
        }
    }

    private void createGoodByRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        float price = Float.parseFloat(request.getParameter("price"));
        String mem = request.getParameter("mem");
        String material = request.getParameter("material");
        String parameter = request.getParameter("parameter");
        switch (request.getParameter("category")) {
            case "clothes":
                Clothes clothes = new Clothes(name, producer, price, mem, material, parameter);
                DAOFactory.getInstance().getClothesDAO().create(clothes);
                break;
            case "cutlery":
                Cutlery cutlery = new Cutlery(name, producer, price, mem, material, parameter);
                DAOFactory.getInstance().getCutleryDAO().create(cutlery);
                break;
            case "trifle":
                Trifle trifle = new Trifle(name, producer, price, mem, material, Integer.parseInt(parameter));
                DAOFactory.getInstance().getTrifleDAO().create(trifle);
                break;
        }
    }
}
