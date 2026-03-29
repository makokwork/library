package controller;

import dao.PublisherDAO;
import domain.Publisher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/publisher")
public class PublisherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PublisherDAO dao = new PublisherDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Publisher> publishers = dao.findAll();
        request.setAttribute("publishers", publishers);

        request.getRequestDispatcher("/views/publishers.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String site = request.getParameter("site");

        Publisher p = new Publisher(name, address, site);
        dao.insert(p);

        response.sendRedirect(request.getContextPath() + "/publisher");
    }
}