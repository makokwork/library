package controller;

import dao.BookDAO;
import dao.AuthorDAO;
import dao.PublisherDAO;
import domain.Book;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editbook")
public class EditBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        BookDAO dao = new BookDAO();
        Book book = dao.findById(id);

        request.setAttribute("bookEdit", book);
        request.setAttribute("authors", new AuthorDAO().findAll());
        request.setAttribute("publishers", new PublisherDAO().findAll());

        try {
            request.getRequestDispatcher("/views/editbook.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Long authorId = Long.parseLong(request.getParameter("authorId"));
        Long publisherId = Long.parseLong(request.getParameter("publisherId"));

        String title = request.getParameter("title");
        String code = request.getParameter("code");
        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer pages = Integer.parseInt(request.getParameter("pages"));
        Boolean hardcover = request.getParameter("hardcover") != null;
        String abstractText = request.getParameter("abstract");
        Boolean status = request.getParameter("status") != null;

        Book b = new Book(id, title, code, year, pages, hardcover, abstractText, status, authorId, publisherId);

        BookDAO dao = new BookDAO();
        dao.update(b);

        response.sendRedirect("book");
    }
}