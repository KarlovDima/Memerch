package servlets.user;

import dao.DAOFactory;
import models.Clothes;
import models.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/good", name = "GoodServlet")
public class GoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String category = request.getParameter("category");
        switch (category) {
            case "clothes":
                request.setAttribute("good", DAOFactory.getInstance().getClothesDAO().getEntityById(id));
                break;
            case "cutlery":
                request.setAttribute("good", DAOFactory.getInstance().getCutleryDAO().getEntityById(id));
                break;
            case "trifle":
                request.setAttribute("good", DAOFactory.getInstance().getTrifleDAO().getEntityById(id));
                break;
        }
        request.getRequestDispatcher("good.jsp").forward(request, response);
    }
}
