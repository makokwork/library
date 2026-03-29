package dao;

import domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private DbConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    private static final String SELECT_ALL = "SELECT * FROM books ORDER BY title";
    private static final String SELECT_BY_ID = "SELECT * FROM books WHERE id=?";
    private static final String INSERT = "INSERT INTO books(authorid, publishid, title, code, yearpublish, countpage, hardcover, abstract, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE books SET authorid=?, publishid=?, title=?, code=?, yearpublish=?, countpage=?, hardcover=?, abstract=?, status=? WHERE id=?";
    private static final String DELETE = "DELETE FROM books WHERE id=?";

    public Long insert(Book b) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, b.getAuthorId());
            ps.setLong(2, b.getPublishId());
            ps.setString(3, b.getTitle());
            ps.setString(4, b.getCode());
            ps.setInt(5, b.getYearPublish());
            ps.setInt(6, b.getCountPage());
            ps.setBoolean(7, b.getHardcover());
            ps.setString(8, b.getAbstractText());
            ps.setBoolean(9, b.getStatus());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getLong(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public void update(Book b) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setLong(1, b.getAuthorId());
            ps.setLong(2, b.getPublishId());
            ps.setString(3, b.getTitle());
            ps.setString(4, b.getCode());
            ps.setInt(5, b.getYearPublish());
            ps.setInt(6, b.getCountPage());
            ps.setBoolean(7, b.getHardcover());
            ps.setString(8, b.getAbstractText());
            ps.setBoolean(9, b.getStatus());
            ps.setLong(10, b.getId());

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

    public Book findById(Long id) {
        Book b = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                b = new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("code"),
                        rs.getInt("yearpublish"),
                        rs.getInt("countpage"),
                        rs.getBoolean("hardcover"),
                        rs.getString("abstract"),
                        rs.getBoolean("status"),
                        rs.getLong("authorid"),
                        rs.getLong("publishid")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("code"),
                        rs.getInt("yearpublish"),
                        rs.getInt("countpage"),
                        rs.getBoolean("hardcover"),
                        rs.getString("abstract"),
                        rs.getBoolean("status"),
                        rs.getLong("authorid"),
                        rs.getLong("publishid")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}