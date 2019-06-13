package pl.edu.wszib.projektk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.projektk.book.SelectedBook;
import pl.edu.wszib.projektk.dao.SelectedBooksDao;
import java.util.Date;

@Controller
public class SelectedBooksController {

    @Value("${app.header.select_book}")
    private String title;

    @Autowired
    SelectedBooksDao selectedBooksDao;

    @GetMapping({"/select", "/select/{book}"})
    public String selectBookPage(@PathVariable(required = false) String book, Model model) {

        if (!StringUtils.isEmpty(book)) {
            selectedBooksDao.save(new SelectedBook(book, new Date()));
        }

        String[][] books = {
                {"Nowe przygody Mikołajka, Goscinny Sempe", "Magiczne drzewo, Maleszka Andrzej"},
                {"Ja diablica, Katarzyna Miszczuk", "Igrzyska Śmierci, Suzanne Collins"},
                {"Wiedźmin, Andrzej Sapkowski", "Xanth, Piers Anthony"},
                {"Drapieżcy, Graham Masterton", "Miasteczko Salem, Stephen King"}
        };

        model.addAttribute("title", title);
        model.addAttribute("books", books);
        return "select";
    }
}