package dao;

import domain.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    private DbConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    private static final String SELECT_ALL = "SELECT id, lastname, firstname FROM authors ORDER BY lastname";
    private static final String SELECT_BY_ID = "SELECT id, lastname, firstname FROM authors WHERE id = ?";
    private static final String INSERT = "INSERT INTO authors(lastname, firstname) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE authors SET lastname = ?, firstname = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM authors WHERE id = ?";

    public Long insert(Author author) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, author.getLastName());
            ps.setString(2, author.getFirstName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getLong(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public void update(Author author) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, author.getLastName());
            ps.setString(2, author.getFirstName());
            ps.setLong(3, author.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Author findById(Long id) {
        Author author = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                author = new Author(
                        rs.getLong("id"),
                        rs.getString("lastname"),
                        rs.getString("firstname")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return author;
    }

    public List<Author> findAll() {
        List<Author> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Author(
                        rs.getLong("id"),
                        rs.getString("lastname"),
                        rs.getString("firstname")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}