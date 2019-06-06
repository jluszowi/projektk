package pl.edu.wszib.projektk.helper;

import javax.swing.text.html.StyleSheet;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookHelper {
    public static List<String> convertBooks(Collection<String> strBooks) {

        StyleSheet styleSheet = new StyleSheet();
        List<String> books = new ArrayList<>();

        for (String strBook : strBooks) {
            Book book = new Book();
            books.add("book");
        }
        return books;
    }
}

