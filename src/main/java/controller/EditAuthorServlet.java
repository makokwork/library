package controller;

import dao.AuthorDAO;
import domain.Author;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editauthor")
public class EditAuthorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        AuthorDAO dao = new AuthorDAO();
        Author author = dao.findById(id);

        request.setAttribute("authorEdit", author);

        try {
            request.getRequestDispatcher("/views/editauthor.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");

        Author a = new Author(id, lastName, firstName);

        AuthorDAO dao = new AuthorDAO();
        dao.update(a);

        response.sendRedirect("author");
    }
}