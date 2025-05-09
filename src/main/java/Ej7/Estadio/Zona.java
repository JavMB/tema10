package Ej7.Estadio;

import Ej7.Espectadores.Config;
import Ej7.Espectadores.Entrada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Zona {

    protected final Map<Posicion, Entrada> entradasPorPosicion;

    protected Zona() {
        this.entradasPorPosicion = new HashMap<>();
    }

    public Map<Posicion, Entrada> getEntradasPorPosicion() {
        return entradasPorPosicion;
    }

    public Entrada venderEntrada(Posicion p, Entrada entrada) {
        if (validarEspacio(p)) {
            return entradasPorPosicion.put(p, entrada);
        } else throw new IllegalArgumentException("Posición fuera de rango: " + p);

    }

    public boolean validarEspacio(Posicion p) {
        return (p.fila() <= Config.MAX_FILAS && p.fila() >= 1) && (p.columna() <= Config.MAX_ASIENTOS && p.columna() >= 1);
    }


    public boolean estaOcupado(Posicion posicion) {
        return entradasPorPosicion.containsKey(posicion);
    }

    public void borrarEntrada(Posicion p) {
        entradasPorPosicion.remove(p);
    }

    public List<Posicion> entradasLibres() {
        List<Posicion> libres = new ArrayList<>();
        for (int i = 1; i <= Config.MAX_FILAS; i++) {
            for (int j = 1; j <= Config.MAX_ASIENTOS; j++) {
                Posicion p = new Posicion(i, j);
                if (!entradasPorPosicion.containsKey(p)) {
                    libres.add(p);
                }
            }
        }
        return libres;
    }


}
