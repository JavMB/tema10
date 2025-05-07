package Ej6;

import java.time.LocalDate;

public class Pelicula extends Multimedia {
    private final int duracion;
    private final String actorPrincipal;
    private final String actrizPrincipal;

    public Pelicula(String titulo, String autor, Formato formato, LocalDate year, int duracion, String actorPrincipal, String actrizPrincipal) {
        super(titulo, autor, formato, year);

        this.duracion = duracion;
        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s", "{" + "duracion=" + duracion + ", actorPrincipal='" + actorPrincipal + '\'' + ", actrizPrincipal='" + actrizPrincipal + '\'' + '}');
    }

}
