package Ej6;

import lib.Fechas;

import java.time.LocalDate;
import java.util.Objects;

public class Socio {
    private final String nif;
    private final String nombre;
    private final LocalDate fechaNac;
    private String poblacion;
    private boolean vetado = false;


    public Socio(String nif, String nombre, String fechaNac) {
        this.nif = nif;
        this.nombre = nombre;
        if (Fechas.esFechaValida(fechaNac) && Fechas.calcularEdad(fechaNac) >= 18) {
            this.fechaNac = Fechas.parsearFecha(fechaNac);
        } else throw new IllegalArgumentException();
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setVetado(boolean vetado) {
        this.vetado = vetado;
    }

    public boolean isVetado() {
        return vetado;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(nif, socio.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nif);
    }
}
