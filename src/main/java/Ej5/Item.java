package Ej5;

import java.util.UUID;

public abstract class Item {
    protected final int stackMaximo;
    protected final String uuid;
    protected final String nombre;


    protected Item(String nombre, int stackMaximo) {
        this.uuid = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.stackMaximo = stackMaximo;
    }


    protected Item(String uuid, String nombre, int stackMaximo) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.stackMaximo = stackMaximo;
    }



}