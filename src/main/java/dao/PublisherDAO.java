package dao;

import domain.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {

    private DbConnectionBuilder builder = new DbConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    private static final String SELECT_ALL = "SELECT * FROM publishers ORDER BY namepublisher";
    private static final String SELECT_BY_ID = "SELECT * FROM publishers WHERE id = ?";
    private static final String INSERT = "INSERT INTO publishers(namepublisher, address, site) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE publishers SET namepublisher=?, address=?, site=? WHERE id=?";
    private static final String DELETE = "DELETE FROM publishers WHERE id=?";

    public Long insert(Publisher p) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNamePublisher());
            ps.setString(2, p.getAddress());
            ps.setString(3, p.getSite());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getLong(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public void update(Publisher p) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setString(1, p.getNamePublisher());
            ps.setString(2, p.getAddress());
            ps.setString(3, p.getSite());
            ps.setLong(4, p.getId());
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

    public Publisher findById(Long id) {
        Publisher p = null;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Publisher(
                        rs.getLong("id"),
                        rs.getString("namepublisher"),
                        rs.getString("address"),
                        rs.getString("site")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    public List<Publisher> findAll() {
        List<Publisher> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Publisher(
                        rs.getLong("id"),
                        rs.getString("namepublisher"),
                        rs.getString("address"),
                        rs.getString("site")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}