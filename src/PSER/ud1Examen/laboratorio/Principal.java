package pser.ud1Examen.laboratorio;

import java.util.Scanner;

import pser.ud1Examen.Utiles;

public class Principal {
    public static void main(String[] args) {
        final int MAX_ELEMENTOS = 4;
        final int NUM_QUIMICOS = 5;
        int investigadores = NUM_QUIMICOS * 3;
        boolean formulaCorrecta = true;
        Scanner sc = new Scanner(System.in);
        String formula;
        final String STR_FIN = "fin";
        do {
            do {

                System.out.print("Introduce una formula compuesta por estos elementos [C,H,O,N,S,P] de un máximo de "
                        + MAX_ELEMENTOS + " o '" + STR_FIN + "' para finalizar :");

                formula = sc.nextLine();

                if (formula.length() > MAX_ELEMENTOS && (!formula.equals(STR_FIN))) {
                    System.out.println("Formula introducida supera la máxima cantidad de elementos");
                    formulaCorrecta = false;
                } else {
                    formulaCorrecta = true;
                }

            } while (!formulaCorrecta);

            if (!formula.equals(STR_FIN)) {
                sc.close();
                Quimico[] quimicos = new Quimico[investigadores];
                Cuaderno cuaderno = new Cuaderno();
                formula = Utiles.generateHash(formula);
                ThreadGroup grupo = new ThreadGroup("cientificos");

                for (int i = 0; i < quimicos.length; i++) {
                    if (i < NUM_QUIMICOS) {
                        quimicos[i] = new Quimico(grupo, "Cientifico " + i, TipoQuimico.Básico, formula, MAX_ELEMENTOS,
                                cuaderno);

                    } else if (i < NUM_QUIMICOS * 2) {
                        quimicos[i] = new Quimico(grupo, "Cientifico " + i, TipoQuimico.Reactivo, formula,
                                MAX_ELEMENTOS,
                                cuaderno);
                    } else {
                        quimicos[i] = new Quimico(grupo, "Cientifico " + i, TipoQuimico.General, formula, MAX_ELEMENTOS,
                                cuaderno);
                    }
                    quimicos[i].start();
                }

                for (Quimico quimico : quimicos) {
                    try {
                        quimico.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(cuaderno.mostrarGanador());
                System.out.println(cuaderno.getMasConsultada());
            } else {
                System.out.println("Saliendo del programa...");
            }
        } while (!formula.equals(STR_FIN));

    }
}
