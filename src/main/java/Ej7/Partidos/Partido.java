package Ej7.Partidos;

import Ej7.Espectadores.Entrada;
import Ej7.Estadio.Orientacion;
import Ej7.Estadio.Zona;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partido {
    private final LocalDate fecha;
    private final Afluencia afluencia;
    private final String nombreLocales;
    private final String nombreVisitantes;
    private float recaudado;

    private final Map<Orientacion, Zona> zonas;
    private final Map<String, Entrada> entradasPorId;


    public Partido(LocalDate fecha, Afluencia afluencia, String nombreLocales, String nombreVisitantes) {
        this.fecha = fecha;
        this.afluencia = afluencia;
        this.nombreLocales = nombreLocales;
        this.nombreVisitantes = nombreVisitantes;
        this.entradasPorId = new HashMap<>();
        this.zonas = new HashMap<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Afluencia getAfluencia() {
        return afluencia;
    }

    public String getNombreLocales() {
        return nombreLocales;
    }

    public String getNombreVisitantes() {
        return nombreVisitantes;
    }

    public float getRecaudado() {
        return recaudado;
    }


    public Map<Orientacion, Zona> getZonas() {
        return zonas;
    }

    public void addEntrada(String id, Entrada entrada) {
        entradasPorId.put(id, entrada);
        recaudado += entrada.getPrecio();

    }

    public Entrada removeEntrada(String id) {
        recaudado -= entradasPorId.get(id).getPrecio();
        return entradasPorId.remove(id);
    }

    public List<Entrada> totalVendidas() {
        return (List<Entrada>) entradasPorId.values();
    }

}
