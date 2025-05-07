package Ej6;

import java.time.LocalDate;

public class Alquiler {
    private final static int MAX_DIAS = 3;
    private final static int PRECIO_BASE = 4;


    private final Socio socio;
    private final Multimedia multimedia;
    private final float precio;
    private final LocalDate fechaInicio;
    private final LocalDate fechaEntrega;
    private boolean entregado;


    public Alquiler(Socio socio, Multimedia multimedia, LocalDate fechaInicio, LocalDate fechaEntrega) {
        this.socio = socio;
        this.multimedia = multimedia;
        this.precio = setPrecioAlquiler(multimedia) + PRECIO_BASE;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.entregado = false;
    }

    public Socio getSocio() {
        return socio;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public int setPrecioAlquiler(Multimedia m) {
        int precioAnadido = 0;

        if (
                (m instanceof Pelicula && m.getYear().isBefore(LocalDate.of(2012, 1, 1))) ||
                        (m instanceof Videojuego && m.getYear().isBefore(LocalDate.of(2010, 1, 1)))
        ) {
            precioAnadido += 1;
        }

        return precioAnadido;
    }

}
