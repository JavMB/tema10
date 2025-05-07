package Ej6;

import java.time.LocalDate;

public class Videojuego extends Multimedia {
    private final String plataforma;

    protected Videojuego(String titulo, String autor, Formato formato, LocalDate year, String plataforma) {
        super(titulo, autor, formato, year);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s", ", plataforma='" + plataforma + '\'' + '}');
    }
}
