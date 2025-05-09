package Ej7.Espectadores;

import Ej7.Estadio.Posicion;
import Ej7.Estadio.Zona;
import Ej7.Partidos.Partido;

public class EntradaNormal extends Entrada {
    private final Integer boleto;

    public EntradaNormal(String numero, Partido partido, Zona zona, Posicion posicion, Integer boleto) {
        super(numero, partido, zona, posicion);
        this.boleto = boleto;
    }

}
