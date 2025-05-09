package Ej7.Espectadores;

import Ej7.Estadio.Posicion;
import Ej7.Estadio.Zona;
import Ej7.Partidos.Partido;

public class EntradaVip extends Entrada {
    private final String contraVip;

    public EntradaVip(String numero, Partido partido, Zona zona, Posicion posicion, String contraVip) {
        super(numero, partido, zona, posicion);
        this.contraVip = contraVip;
    }
}
