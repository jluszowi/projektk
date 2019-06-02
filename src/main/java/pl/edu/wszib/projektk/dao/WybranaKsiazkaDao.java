package pl.edu.wszib.projektk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.projektk.ksiazki.WybranaKsiazka;

import java.util.List;

public interface WybranaKsiazkaDao extends CrudRepository<WybranaKsiazka, Integer> {
    List<WybranaKsiazka> findByKsiazka(String ksiazka);
}
