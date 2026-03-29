package controller;

import dao.PublisherDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deletepublisher")
public class DeletePublisherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        PublisherDAO dao = new PublisherDAO();
        dao.delete(id);

        response.sendRedirect("publisher");
    }
}