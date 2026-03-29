package controller;

import dao.AuthorDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteauthor")
public class DeleteAuthorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        AuthorDAO dao = new AuthorDAO();
        dao.delete(id);

        response.sendRedirect("author");
    }
}