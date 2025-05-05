package Ej3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coche c;

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una matricula");
        String matricula = sc.nextLine().trim();
        System.out.println("Es manual?");
        boolean manual = sc.nextLine().contains("si");


        double[] velocidadesMarchas = {20, 40, 60, 80, 120, 180};

        if (manual) {
            c = new CocheManual(matricula, velocidadesMarchas);
        } else {
            c = new CocheAutomatico(matricula, velocidadesMarchas);
        }

        for (int i = 0; i < 20; i++) {
            c.acelerar(true);
            System.out.println(c.getVelocidadActual());
            System.out.println(c.getMarchaActual());

            if (i == 4) {
                c.cambiarMarcha(Coche.Marcha.SEGUNDA);
            }

        }

    }
}