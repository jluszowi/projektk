package pl.edu.wszib.projektk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.projektk.book.SelectedBook;


import java.util.List;

public interface SelectedBookDao extends CrudRepository<SelectedBook, Integer> {
    List<SelectedBook> findByBook(String book);
}
