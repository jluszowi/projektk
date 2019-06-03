package pl.edu.wszib.projektk.book;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "selected_books")

public class SelectedBook {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String book;
    private Date ctime;

    public SelectedBook() {
    }

    public SelectedBook(String book, Date ctime) {
        this.book = book;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}

