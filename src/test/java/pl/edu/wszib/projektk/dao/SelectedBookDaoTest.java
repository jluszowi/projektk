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
public class SelectedBookDaoTest {

    public static final String Book1 = "Wiedźmin, Andrzej Sapkowski";
    public static final String Book2 = "Ja diablica, Katarzyna Miszczuk";

    @Autowired
    SelectedBookDao selectedBookDao;


    @Before
    public void setUp() throws Exception {
        SelectedBook selectedBook1 = new SelectedBook("Wiedźmin, Andrzej Sapkowski",new Date());
        SelectedBook selectedBook2 = new SelectedBook("Ja diablica, Katarzyna Miszczuk",new Date());

        assertNull(selectedBook1.getId());
        assertNull(selectedBook2.getId());

        selectedBookDao.save(selectedBook1);
        selectedBookDao.save(selectedBook2);

        assertNotNull(selectedBook1.getId());
        assertNotNull(selectedBook2.getId());

        System.out.println("----------");
        }

    @Test
    public void testFetchAllData() {

    Iterable<SelectedBook> selectedBooks = selectedBookDao.findAll();
    int counter = 0;
    for (SelectedBook selectedBook : selectedBooks) {
        counter++;
    }
    assertTrue(counter >= 2);
    }

    @Test
    public void testFindBook() {

        List<SelectedBook> selectedBooks = selectedBookDao.findByBook("Wiedźmin, Andrzej Sapkowski");
        System.out.println("--------------");
        assertEquals("Wiedźmin, Andrzej Sapkowski", selectedBooks.get(0).getBook());
    }

}