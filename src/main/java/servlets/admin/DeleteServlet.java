package servlets.admin;

import dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete", name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String category = request.getParameter("category");
        switch (category) {
            case "clothes":
                DAOFactory.getInstance().getClothesDAO().delete(id);
                break;
            case "cutlery":
                DAOFactory.getInstance().getCutleryDAO().delete(id);
                break;
            case "trifle":
                DAOFactory.getInstance().getTrifleDAO().delete(id);
                break;
        }
        response.sendRedirect("admin");
    }
}
