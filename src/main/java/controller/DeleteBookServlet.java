package controller;

import dao.BookDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        BookDAO dao = new BookDAO();
        dao.delete(id);

        response.sendRedirect("book");
    }
}