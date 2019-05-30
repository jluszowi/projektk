package pl.edu.wszib.projektk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.projektk.ksiazki.Ksiazka;

import java.util.List;

public interface KsiazkaDao extends CrudRepository<Ksiazka, Integer> {
    List<Ksiazka> findByTytul(String tytul);
}
