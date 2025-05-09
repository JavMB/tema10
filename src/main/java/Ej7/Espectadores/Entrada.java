package Ej7.Espectadores;

import Ej7.Estadio.Posicion;
import Ej7.Estadio.Zona;
import Ej7.Estadio.ZonaVip;
import Ej7.Partidos.Partido;

public abstract class Entrada {
    private final String numero;
    private final Partido partido;
    private final Zona zona;
    private final Posicion posicion;
    private float precio;

    protected Entrada(String numero, Partido partido, Zona zona, Posicion posicion) {
        this.numero = numero;
        this.partido = partido;
        this.zona = zona;
        this.posicion = posicion;
        this.precio = calcularPrecio();
    }

    public String getNumero() {
        return numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public Zona getZona() {
        return zona;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public float getPrecio() {
        return precio;
    }

    private float calcularPrecio() {
        if (zona instanceof ZonaVip) {
            return Config.P_BASE_VIP * partido.getAfluencia().factorPrecio;
        } else {
            return Config.P_BASE_NORMAL * partido.getAfluencia().factorPrecio;
        }
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "numero='" + numero + '\'' +
                ", partido=" + partido +
                ", zona=" + zona +
                ", posicion=" + posicion +
                ", precio=" + precio +
                '}';
    }
}
