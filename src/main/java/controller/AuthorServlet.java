package controller;

import dao.AuthorDAO;
import domain.Author;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/author")
public class AuthorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private AuthorDAO dao = new AuthorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Author> authors = dao.findAll();
        request.setAttribute("authors", authors);

        request.getRequestDispatcher("/views/authors.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");

        Author author = new Author(lastName, firstName);
        dao.insert(author);

        response.sendRedirect(request.getContextPath() + "/author");
    }
}