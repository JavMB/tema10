package Ej5;



public class Inventario {
    private final Casilla[] items;

    public Inventario(int capacidad) {
        items = new Casilla[capacidad];

    }

    public boolean add(Item item) {
        for (Casilla casilla : items) {
            if (casilla.getCantidad() == 0) {
                casilla.setItem(item);
                return true;
            }
        }
        return false;
    }

    public boolean remove(int position) {
        for (int i = 0; i < items.length; i++) {
            if (i == position || items[i].getCantidad() <= 0) {
                items[i] = null;
                return true;
            }

        }
        return false;
    }

//    public boolean remove(Item item) {
//
//    }


}
