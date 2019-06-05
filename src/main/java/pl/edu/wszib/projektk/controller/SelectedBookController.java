
package pl.edu.wszib.projektk.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.projektk.book.SelectedBook;
import pl.edu.wszib.projektk.dao.SelectedBookDao;

import java.util.Date;


@Controller
public class SelectedBookController {

    @Value("${app.header.select_book}")
    private String title;

    @Autowired
    SelectedBookDao selectedBookDao;

    @GetMapping({"/select", "/select/{book}"})
    public String selectBookPage(@PathVariable(required = false) String book, Model model) {

        if (!StringUtils.isEmpty(book)) {
            selectedBookDao.save(new SelectedBook(book, new Date()));
        }

        String[][] books = {
                {"jedna", "druga"},
                {"trzecia", "czwarta"},
                {"piata", "szosta"}
        };

        model.addAttribute("title", title);
        model.addAttribute("books", books);
        return "select";
    }



    }