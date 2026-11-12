package pser.ud1.hackers;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        final int MAX_CHARS = 4;
        final int NUM_HACKS = 3;
        final int NUM_GRUPOS = 3;
        int CantHackNum = NUM_HACKS / NUM_GRUPOS;
        int CantHacksAlfa = NUM_HACKS / NUM_GRUPOS;
        int CantHacksAlfanum = NUM_HACKS / NUM_GRUPOS;

        Scanner sc = new Scanner(System.in);
        boolean caracterAceptado = true;
        String contrasenha;
        do {
            System.out.print("Introduce una contraseña de " + MAX_CHARS + " caracteres : ");
            contrasenha = sc.nextLine();
            if (contrasenha.length() > MAX_CHARS) {
                System.out.println("Contraseña no aceptada");
                caracterAceptado = false;
            } else {
                caracterAceptado = true;
            }
        } while (!caracterAceptado);

        Hacker[] hackers = new Hacker[NUM_HACKS];
        ThreadGroup grupoHackers = new ThreadGroup("hackers");
        // TODO añadir desfase aleatorio
        for (int i = 0; i < hackers.length; i++) {
            if (CantHacksAlfa > 0) {
                hackers[i] = new Hacker(grupoHackers, TipoHacker.Alfabético, MAX_CHARS, contrasenha, "" + i);
                CantHacksAlfa--;
            } else if (CantHackNum > 0) {
                hackers[i] = new Hacker(grupoHackers, TipoHacker.Numérico, MAX_CHARS, contrasenha, "" + i);
                CantHackNum--;

            } else if (CantHacksAlfanum > 0) {
                hackers[i] = new Hacker(grupoHackers, TipoHacker.Alfanumérico, MAX_CHARS, contrasenha, "" + i);
                CantHacksAlfanum--;
            }

            hackers[i].start();

        }

    }

}
