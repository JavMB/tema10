package Ej6;


import lib.Algoritmos;

import java.time.LocalDate;
import java.util.*;


public class Tienda {
    private final Map<String, Socio> socios;
    private final Map<String, List<Alquiler>> alquileres;
    private final Map<String, Multimedia> multimedia;

    public Tienda() {
        this.socios = new HashMap<>();
        this.alquileres = new HashMap<>();
        this.multimedia = new HashMap<>();
    }


    public void altaPelicula(String titulo, String autor, Formato formato, LocalDate year, int duracion, String actorPrincipal, String actrizPrincipal) {
        if (!multimedia.containsKey(titulo)) {
            Multimedia nueva = new Pelicula(titulo, autor, formato, year, duracion, actorPrincipal, actrizPrincipal);
            multimedia.put(titulo, nueva);
        }

    }

    public void altaVideojuego(String titulo, String autor, Formato formato, LocalDate year, String plataforma) {
        if (!multimedia.containsKey(titulo)) {
            Multimedia nueva = new Videojuego(titulo, autor, formato, year, plataforma);
            multimedia.put(titulo, nueva);
        }

    }

    public void altaSocio(String nif, String nombre, String fechaNac) {
        Socio socio = new Socio(nif, nombre, fechaNac);
        if (!socios.containsKey(nif)) {
            socios.put(nif, socio);
        }
    }

    public boolean alquilarMultimediaSocio(String nif, String nombre, String fechaNac, Multimedia m) {
        Socio socio = socios.get(nif);


        if (socio == null) {
            socio = new Socio(nif, nombre, fechaNac);
            socios.put(nif, socio);
        }

        if (socio.isVetado()) return false;


        if (!multimedia.containsKey(m.getTitulo())) return false;

        // asegurar que el socio tiene lista de alquileres
        alquileres.putIfAbsent(nif, new ArrayList<>());


        alquileres.get(nif).add(new Alquiler(socio, m, LocalDate.now(), LocalDate.now().plusDays(3)));

        return true;

    }

    public boolean devolverMultimediaSocio(String nif, Multimedia m) {


        List<Alquiler> alquiler = alquileres.get(nif);
        for (Alquiler a : alquiler) {
            if (a.getMultimedia().equals(m) && a.getFechaEntrega().isAfter(a.getFechaInicio().plusDays(3))
            ) {
                a.getSocio().setVetado(true);
                a.setPrecioRecarga(a.calcularPrecioRecarga(a.getFechaEntrega(), LocalDate.now()));
                return false;
            } else if (a.getMultimedia().equals(m)) {
                return true;
            }
        }
        return false;
    }

    public String generarListadoGeneral() {
        return multimedia.values().toString();
    }

    public String generarListadoPeliculasTitulo() {
        List<Pelicula> lista = new ArrayList<>();
        for (Multimedia m : multimedia.values()) {
            if (m instanceof Pelicula p) {
                lista.add(p); // Cast implícito en Java 16+
            }
        }
        lista.sort(Comparator.comparing(Pelicula::getTitulo));

        return lista.toString();
    }

    public String generarListadoVideojuegos() {
        List<Videojuego> video = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Multimedia m : multimedia.values()) {
            if (m instanceof Videojuego) {
                video.add((Videojuego) m);
            }
        }
        Videojuego tmp;
        for (int i = 1; i < video.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                LocalDate lc = video.get(j).getYear();
                if (lc.isBefore(video.get(j + 1).getYear())) {
                    tmp = video.get(j + 1);
                    video.set(j + 1, video.get(j));
                    video.set(j, tmp);
                }
            }
        }

        return video.toString();
    }


    public String getListadoAlquileresSocio(String nif) {
        return alquileres.get(nif).toString();
    }

    public String getListadoAlquileresActivos(String nif) {
        StringBuilder sb = new StringBuilder();

        for (Alquiler a : alquileres.get(nif)) {
            if (LocalDate.now().isBefore(a.getFechaEntrega().plusDays(3))) {
                sb.append(a).append("\n");
            }
        }
        return sb.toString();
    }

    public String getSociosPendientes() {
        StringBuilder sb = new StringBuilder();

        for (Socio a : socios.values()) {
            if (a.isVetado()) {
                sb.append(a).append("\n");
            }
        }
        return sb.toString();

    }


}
