package pl.edu.wszib.projektk.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.wszib.projektk.book.SelectedBook;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectedBooksDaoTest {

    public static final String Book1 = "Book1";
    public static final String Book2 = "Book2";

    @Autowired
    SelectedBooksDao selectedBooksDao;

    @Before
    public void setUp() throws Exception {
        SelectedBook selectedBook1 = new SelectedBook(Book1, new Date());
        SelectedBook selectedBook2 = new SelectedBook(Book2, new Date());

        assertNull(selectedBook1.getId());
        assertNull(selectedBook2.getId());

        selectedBooksDao.save(selectedBook1);
        selectedBooksDao.save(selectedBook2);

        assertNotNull(selectedBook1.getId());
        assertNotNull(selectedBook2.getId());

        System.out.println("----------");
        }

    @Test
    public void testFetchAllData() {

    Iterable<SelectedBook> selectedBooks = selectedBooksDao.findAll();
    int counter = 0;
    for (SelectedBook selectedBook : selectedBooks) {
        counter++;
    }
    assertTrue(counter >= 2);
    }

    @Test
    public void testFindByBook() {

        List<SelectedBook> selectedBooks = selectedBooksDao.findByBook(Book1);
        System.out.println("--------------");
        assertEquals(Book1, selectedBooks.get(0).getBook());
    }
}