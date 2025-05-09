package Ej7.Partidos;

import Ej7.Espectadores.Entrada;
import Ej7.Espectadores.EntradaNormal;
import Ej7.Espectadores.EntradaVip;
import Ej7.Estadio.*;
import lib.GeneradorDatos;

import java.util.ArrayList;
import java.util.List;

public class GestionEntradas {
    private final static GeneradorDatos g = new GeneradorDatos();

    private final List<Partido> listaPartidos;
    private Partido partido;

    public GestionEntradas() {
        this.listaPartidos = new ArrayList<>();
        this.partido = null;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
        listaPartidos.add(partido);
        inicializarZonas();
    }

    public Entrada venderEntrada(Posicion posicion, Orientacion orientacion) {
        Zona zonaVenta = determinarZonaEstadio(orientacion);
        if (zonaVenta == null) {
            throw new IllegalStateException("La zona " + orientacion + " no existe en el partido.");
        }
        if (zonaVenta.estaOcupado(posicion)) {
            throw new IllegalStateException("El asiento en " + posicion + " ya está ocupado.");
        }

        Entrada entrada = crearEntrada(zonaVenta, posicion);
        zonaVenta.venderEntrada(posicion, entrada); // guarda en zona
        partido.addEntrada(entrada.getNumero(), entrada); // guarda en partido
        return entrada; // devolvemos la entrada recién creada

    }

    public boolean devolverEntrada(String id) {
        Entrada borrada = partido.removeEntrada(id);
        if (borrada == null) {
            throw new IllegalStateException("No existe una entrada con ID: " + id);
        }
        borrada.getZona().borrarEntrada(borrada.getPosicion());
        return true;
    }


    public Entrada crearEntrada(Zona zona, Posicion posicion) {
        if (zona instanceof ZonaVip) {
            return new EntradaVip(g.generarAlfanumerico(5), partido, zona, posicion, g.generarPassword());
        } else {
            return new EntradaNormal(g.generarAlfanumerico(5), partido, zona, posicion, g.generarNumeroEntero(1, 900));
        }
    }

    public List<Entrada> listadoOcupadas() {
        return partido.totalVendidas();
    }

    public List<Posicion> listadoLibres() {
        List<Posicion> libres = new ArrayList<>();
        for (Zona z : partido.getZonas().values()) {
            libres.addAll(z.entradasLibres());
        }
        return libres;
    }

    public float recaudacionPartido() {
        return partido.getRecaudado();

    }

    public Zona determinarZonaEstadio(Orientacion orientacion) {
        return partido.getZonas().get(orientacion);
    }

    private void inicializarZonas() {
        partido.getZonas().put(Orientacion.NORTE, new ZonaVip());
        partido.getZonas().put(Orientacion.SUR, new ZonaGeneral());
        partido.getZonas().put(Orientacion.ESTE, new ZonaGeneral());
        partido.getZonas().put(Orientacion.OESTE, new ZonaGeneral());
    }



}
