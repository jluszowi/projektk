package pl.edu.wszib.projektk.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KsiazkaDaoTest {

    @Autowired
    KsiazkaDao ksiazkaDao;


    @Before
    public void setUp() throws Exception {
        KsiazkaDao ksiazkaDao1 = new KsiazkaDao("Xanth", "fantasy", "Piers Anthony") {
        }
    }


/*    @Test
    public void findByTytul() {
    }
    */

}