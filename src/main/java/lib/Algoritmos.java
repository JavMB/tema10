package lib; /**
 * Algoritmos.java
 * ------------------------------------------------------------
 * Clase utilitaria con implementaciones sencillas de búsqueda y
 * ordenación pensadas para un examen. Incluye:
 *   • Métodos para arrays de primitivos (`int[]`, `double[]`).
 *   • Versiones genéricas sobre `T[]` (requieren `Comparable`).
 *   • Nuevas sobrecargas que trabajan directamente con `java.util.List` / `ArrayList`.
 *   • Variantes con `Comparator` para ordenar según cualquier criterio.
 *
 * Todos los métodos son `static`: importa la clase y llama directamente.
 * ------------------------------------------------------------
 */
import java.time.*;
import java.util.*;

public final class Algoritmos {

    /* Evitamos instancias */
    private Algoritmos() {}

    /* =========================================================
     * ORDENACIÓN (ARRAYS)
     * ========================================================= */

    /* ---------- Burbuja ---------- */

    /** Ordena un array genérico mediante burbuja. */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        boolean swapped;
        int n = a.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1].compareTo(a[i]) > 0) {
                    T tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                    swapped = true;
                }
            }
            n--; // cada pasada coloca el mayor al final
        } while (swapped);
    }

    /** Burbuja para int[] */
    public static void bubbleSort(int[] a) {
        boolean swapped;
        int n = a.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    int tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    /** Burbuja para double[] */
    public static void bubbleSort(double[] a) {
        boolean swapped;
        int n = a.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    double tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    /* ---------- Inserción ---------- */

    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void insertionSort(double[] a) {
        for (int i = 1; i < a.length; i++) {
            double key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    /* ---------- QuickSort genérico ---------- */

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int l, int r) {
        T pivot = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                i++;
                T tmp = a[i]; a[i] = a[j]; a[j] = tmp;
            }
        }
        T tmp = a[i + 1]; a[i + 1] = a[r]; a[r] = tmp;
        return i + 1;
    }

    /* =========================================================
     * ORDENACIÓN (LISTAS)
     * ========================================================= */

    /** Burbuja sobre `List` (útil para ArrayList). */
    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        boolean swapped;
        int n = list.size();
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    Collections.swap(list, i - 1, i);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    /** Inserción sobre `List`. */
    public static <T extends Comparable<? super T>> void insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /** QuickSort para List: convierte internamente a array y vuelve. */
    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        @SuppressWarnings("unchecked")
        T[] a = list.toArray((T[]) new Comparable[0]);
        quickSort(a);
        for (int i = 0; i < a.length; i++) list.set(i, a[i]);
    }

    /** Ordena con Comparator (usa Collections.sort). */
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c); // uso estándar de la librería
    }

    /* =========================================================
     * BÚSQUEDA (ARRAYS)
     * ========================================================= */

    public static <T> int linearSearch(T[] a, T key) {
        for (int i = 0; i < a.length; i++) {
            if (Objects.equals(a[i], key)) return i;
        }
        return -1;
    }

    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) if (a[i] == key) return i;
        return -1;
    }

    public static int linearSearch(double[] a, double key) {
        for (int i = 0; i < a.length; i++) if (a[i] == key) return i;
        return -1;
    }

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            int cmp = key.compareTo(a[m]);
            if (cmp == 0) return m;
            else if (cmp < 0) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static int binarySearch(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a[m] == key) return m;
            else if (key < a[m]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    public static int binarySearch(double[] a, double key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a[m] == key) return m;
            else if (key < a[m]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    /* =========================================================
     * BÚSQUEDA (LISTAS)
     * ========================================================= */

    public static <T> int linearSearch(List<T> list, T key) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), key)) return i;
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T key) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            int cmp = key.compareTo(list.get(m));
            if (cmp == 0) return m;
            else if (cmp < 0) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    /* =========================================================
     * DEMO RÁPIDA
     * ========================================================= */
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(List.of("sol", "luna", "estrella"));
        bubbleSort(palabras);
        System.out.println("Ordenadas: " + palabras);
        System.out.println("Posición 'luna': " + binarySearch(palabras, "luna"));

        LocalDate[] fechas = { LocalDate.of(2022, 5, 1), LocalDate.of(2021, 1, 20) };
        quickSort(fechas);
        System.out.println("Fechas: " + Arrays.toString(fechas));
    }
}