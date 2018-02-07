package servlets.admin;

import dao.DAOFactory;
import models.User;
import utils.PasswordEncryptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        password = PasswordEncryptor.encrypt(password);
        User user = DAOFactory.getInstance().getUserDAO().getEntityByLoginAndPassword(login, password);
        if (user == null) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>Try again!</br></br>");
            request.getRequestDispatcher("authorization.html").include(request, response);
            printWriter.println("</body></html>");
        } else
            request.getSession().setAttribute("entered", true);
            response.sendRedirect("admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("entered", false);
        request.getRequestDispatcher("authorization.html").forward(request,response);
    }
}
