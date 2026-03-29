package dao;

import domain.Author;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorDAOTest {

    @Test
    public void testFindAll() {
        AuthorDAO dao = new AuthorDAO();

        List<Author> authors = dao.findAll();

        assertNotNull(authors);
    }

    @Test
    public void testInsert() {
        AuthorDAO dao = new AuthorDAO();

        Author a = new Author("TestLast", "TestFirst");
        dao.insert(a);

        List<Author> authors = dao.findAll();

        boolean found = false;

        for (Author author : authors) {
            if ("TestLast".equals(author.getLastName())) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }
}