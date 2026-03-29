package controller;

import dao.BookDAO;
import dao.AuthorDAO;
import dao.PublisherDAO;
import domain.Book;
import domain.Author;
import domain.Publisher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BookDAO bookDAO = new BookDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private PublisherDAO publisherDAO = new PublisherDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books = bookDAO.findAll();
        List<Author> authors = authorDAO.findAll();
        List<Publisher> publishers = publisherDAO.findAll();

        request.setAttribute("books", books);
        request.setAttribute("authors", authors);
        request.setAttribute("publishers", publishers);

        request.getRequestDispatcher("/views/books.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long authorId = Long.parseLong(request.getParameter("authorId"));
        Long publisherId = Long.parseLong(request.getParameter("publisherId"));
        String title = request.getParameter("title");
        String code = request.getParameter("code");
        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer pages = Integer.parseInt(request.getParameter("pages"));
        Boolean hardcover = request.getParameter("hardcover") != null;
        String abstractText = request.getParameter("abstract");
        Boolean status = request.getParameter("status") != null;

        Book b = new Book(title, code, year, pages, hardcover, abstractText, status, authorId, publisherId);
        bookDAO.insert(b);

        response.sendRedirect(request.getContextPath() + "/book");
    }
}