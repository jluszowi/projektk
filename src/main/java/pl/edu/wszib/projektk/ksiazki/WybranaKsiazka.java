package pl.edu.wszib.projektk.ksiazki;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lista_ksiazek")

public class WybranaKsiazka {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ksiazka;
    private Date ctime;

    public WybranaKsiazka() {
    }

    public WybranaKsiazka(String ksiazka, Date ctime) {
        this.ksiazka = ksiazka;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(String ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}

