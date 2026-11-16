package pser.ud1Examen.subasta;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce el nombre de un artículo  o 'fin' para finalizar: ");
            String nombreArticulo = sc.nextLine();
            if (nombreArticulo.equals("fin")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Introduce el precio objetivo del artículo: ");
            double precioObjetivoArticulo = sc.nextDouble();
            sc.nextLine();

            Articulo articulo = new Articulo(nombreArticulo, precioObjetivoArticulo);

            final int NUM_PUJADORES = 5;

            Pujador[] pujadores = new Pujador[NUM_PUJADORES];
            ThreadGroup grupoPujadores = new ThreadGroup("pujadores");

            for (int i = 0; i < pujadores.length; i++) {
                pujadores[i] = new Pujador(grupoPujadores, articulo, "pujador " + i);

                pujadores[i].start();
            }

            for (Pujador pujador : pujadores) {
                try {
                    pujador.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(articulo);

        } while (true);
        sc.close();

    }
}
