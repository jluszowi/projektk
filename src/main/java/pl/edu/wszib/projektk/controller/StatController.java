
package pl.edu.wszib.projektk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.projektk.book.SelectedBook;
import pl.edu.wszib.projektk.dao.SelectedBookDao;
import pl.edu.wszib.projektk.helper.BookHelper;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Value("${app.header.stat}")
    private String title;

    @Autowired
    SelectedBookDao selectedBookDao;

    @GetMapping("/stat")
    public String statPage(Model model) {

        Iterable<SelectedBook> selectedBooks = selectedBookDao.findAll();
        Collection<SelectedBook> selectedBookCollection = (Collection<SelectedBook>) selectedBooks;

        Map<String, Long> dataMap = selectedBookCollection.stream().collect(Collectors.groupingBy
                (SelectedBook::getBook, Collectors.counting()));

        List<String> labels = BookHelper.convertBooks(dataMap.keySet());

        model.addAttribute("title", title);
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("labels", labels);



        return "stat";
    }

}

