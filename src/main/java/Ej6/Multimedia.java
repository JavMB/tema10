package Ej6;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Multimedia {

    private  String titulo;
    private  String autor;
    private  Formato formato;
    private final LocalDate year;


    protected Multimedia(String titulo, String autor, Formato formato, LocalDate year) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public LocalDate getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +"{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", formato=" + formato +
                ", year=" + year;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
}
