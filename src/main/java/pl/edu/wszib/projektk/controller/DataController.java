package pl.edu.wszib.projektk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.projektk.book.SelectedBook;
import pl.edu.wszib.projektk.dao.SelectedBookDao;

@Controller
public class DataController {

    @Value("${app.header.data}")
    private String title;

    @Autowired
    SelectedBookDao selectedBookDao;

    @GetMapping("/data")
    public String dataPage(Model model) {
        Iterable<SelectedBook> selectedBooks = selectedBookDao.findAll();

        model.addAttribute("title", title);
        model.addAttribute("books", selectedBooks);

        return "data";

    }
}
