package pl.edu.wszib.projektk.ksiazki;

import javax.persistence.*;

@Entity
@Table(name = "lista_ksiazek")

public class Ksiazka {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tytul;
    private String gatunek;
    private String autor;

    public Ksiazka() {
    }

    public Ksiazka(int id, String tytul, String gatunek, String autor) {
        this.id = id;
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
