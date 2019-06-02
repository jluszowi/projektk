package pl.edu.wszib.projektk.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.wszib.projektk.ksiazki.WybranaKsiazka;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WybranaKsiazkaDaoTest {

    public static final String Ksiazka1 = "Wiedźmin, Andrzej Sapkowski";
    public static final String Ksiazka2 = "Ja diablica, Katarzyna Miszczuk";

    @Autowired
    WybranaKsiazkaDao wybranaKsiazkaDao;


    @Before
    public void setUp() throws Exception {
        WybranaKsiazka wybranaKsiazka1 = new WybranaKsiazka("Wiedźmin, Andrzej Sapkowski",new Date());
        WybranaKsiazka wybranaKsiazka2 = new WybranaKsiazka("Ja diablica, Katarzyna Miszczuk",new Date());

        assertNull(wybranaKsiazka1.getId());
        assertNull(wybranaKsiazka2.getId());

        wybranaKsiazkaDao.save(wybranaKsiazka1);
        wybranaKsiazkaDao.save(wybranaKsiazka2);

        assertNotNull(wybranaKsiazka1.getId());
        assertNotNull(wybranaKsiazka2.getId());

        System.out.println("----------");
        }

    @Test
    public void testPobierzDane() {

    Iterable<WybranaKsiazka> wybranaKsiazkas = wybranaKsiazkaDao.findAll();
    int licz = 0;
    for (WybranaKsiazka wybranaKsiazka : wybranaKsiazkas) {
        licz++;
    }
    assertTrue(licz >= 2);
    }

    @Test
    public void testZnajdzKsiazke() {

        List<WybranaKsiazka> wybranaKsiazkas = wybranaKsiazkaDao.findByKsiazka("Wiedźmin, Andrzej Sapkowski");
        System.out.println("--------------");
        assertEquals("Wiedźmin, Andrzej Sapkowski", wybranaKsiazkas.get(0).getKsiazka());
    }

}