package controller;

import dao.PublisherDAO;
import domain.Publisher;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editpublisher")
public class EditPublisherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        PublisherDAO dao = new PublisherDAO();
        Publisher p = dao.findById(id);

        request.setAttribute("publisherEdit", p);

        try {
            request.getRequestDispatcher("/views/editpublisher.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String site = request.getParameter("site");

        Publisher p = new Publisher(id, name, address, site);

        PublisherDAO dao = new PublisherDAO();
        dao.update(p);

        response.sendRedirect("publisher");
    }
}