package Ej7;

import Ej7.Espectadores.Config;
import Ej7.Espectadores.Entrada;
import Ej7.Estadio.Orientacion;
import Ej7.Estadio.Posicion;
import Ej7.Estadio.Zona;
import Ej7.Partidos.Afluencia;
import Ej7.Partidos.GestionEntradas;
import Ej7.Partidos.Partido;
import lib.ConsoleMenu;
import lib.Fechas;
import lib.IO;

import java.time.LocalDate;

public class Main {
    private final static ConsoleMenu c = new ConsoleMenu("App Gestion Partidos");
    private final static ConsoleMenu e = new ConsoleMenu("Gestion entradas", true);
    private final static GestionEntradas g = new GestionEntradas();

    public static void main(String[] args) {
        c.addOption("Nuevo Partido", Main::crearPartido);
        c.addSubMenu("Gestion de Entradas", e);
        e.addOption("Venta de entradas", Main::ventaEntradas);
        e.addOption("Devolver entrada", Main::devolverEntrada);
        e.addOption("Ver estadio", Main::mostrarEstadoZonas);
        e.addOption("Recaudado", Main::mostrarRecaudado);
        c.addOption("Cargar partido de prueba", Main::crearPartidoFalso);
        c.show();
    }


    private static void crearPartido() {
        LocalDate fecha = Fechas.parsearFecha(IO.readString("Dime la fecha"));
        Afluencia afluencia = Afluencia.valueOf(IO.readString("Dime la afluencia Alta/Media/Baja").toUpperCase());
        String nombreLocales = IO.readString("Dime el nombre del equipo local");
        String nombreVisitantes = IO.readString("Dime el nombre del equipo visitante");
        Partido nuevoPartido = new Partido(fecha, afluencia, nombreLocales, nombreVisitantes);
        g.setPartido(nuevoPartido);
    }

    private static void ventaEntradas() {
        try {
            Orientacion zona = Orientacion.valueOf(IO.readString("Dime la zona").toUpperCase());
            int fila = IO.readInt("Dime la fila");
            int columna = IO.readInt("Dime el numero de asiento");

            Posicion p = new Posicion(fila, columna);
            Entrada entrada = g.venderEntrada(p, zona);

            if (entrada != null) {
                System.out.println(" Entrada vendida: " + entrada.getNumero());
            } else {
                System.out.println(" Entrada no disponible.");
            }

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }


    private static void devolverEntrada() {
        String id = IO.readString("Dime el id de tu entrada");
        if (g.devolverEntrada(id)) {
            IO.readString("Entrada devuelta con exito");
        } else {
            IO.readString("Entrada no encontrada");
        }
    }

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private static void mostrarEstadoZonas() {
        System.out.println("\n📍 ESTADO DEL ESTADIO:");

        for (Orientacion orientacion : g.getPartido().getZonas().keySet()) {
            Zona zona = g.getPartido().getZonas().get(orientacion);
            System.out.println("\n🧭 Zona: " + orientacion);

            for (int fila = 1; fila <= Config.MAX_FILAS; fila++) {
                System.out.printf("Fila %2d: ", fila);
                for (int col = 1; col <= Config.MAX_ASIENTOS; col++) {
                    Posicion pos = new Posicion(fila, col);
                    if (zona.estaOcupado(pos)) {
                        System.out.print(RED + "[X]" + RESET);
                    } else {
                        System.out.print(GREEN + "[ ]" + RESET);
                    }
                }
                System.out.println();
            }
        }
    }

    private static void mostrarRecaudado() {
        System.out.println(g.getPartido().getRecaudado());
    }

    private static void crearPartidoFalso() {
        Partido p = new Partido(LocalDate.now(), Afluencia.MEDIA, "Tortilla FC", "Chorizos CF");
        g.setPartido(p);

        g.venderEntrada(new Posicion(1, 1), Orientacion.NORTE);
        g.venderEntrada(new Posicion(1, 2), Orientacion.SUR);
        g.venderEntrada(new Posicion(1, 3), Orientacion.SUR);
        g.venderEntrada(new Posicion(2, 1), Orientacion.ESTE);
        g.venderEntrada(new Posicion(2, 2), Orientacion.OESTE);
        g.venderEntrada(new Posicion(2, 3), Orientacion.OESTE);

        System.out.println(" Partido de prueba creado con entradas vendidas.");
    }


}
