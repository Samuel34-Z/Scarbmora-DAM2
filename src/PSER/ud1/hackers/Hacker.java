package pser.ud1.hackers;

import java.util.Random;

public class Hacker extends Thread {
    private TipoHacker tipoHacker;
    private int maxChars;
    private static String caracteresAlfabeticos = "qwertyuiopasdfghjklñzxcvbnm";
    private static String caracteresNumericos = "1234567890";
    private static String contrasenhaCorrecta;

    public Hacker(ThreadGroup grupoHackers, TipoHacker tipoHacker, int maxChars, String contrasenhaCorrecta,
            String nombre) {
        super(grupoHackers, nombre);
        this.tipoHacker = tipoHacker;
        this.maxChars = maxChars;
        Hacker.contrasenhaCorrecta = contrasenhaCorrecta;

    }

    @Override
    public void run() {
        String clave = generarClave(tipoHacker, maxChars);
        // TODO buscar en la tabla rainbow si ese hash ya existe
        if (probarClave(clave)) {
            this.getThreadGroup().interrupt();
        }

    }

    private static boolean probarClave(String clave) {
        return clave.equals(contrasenhaCorrecta);

    }

    private static String generarClave(TipoHacker tipoHacker, int maxChars) {
        // String clave = "";
        Random rd = new Random();
        int caracter;
        StringBuilder builder = new StringBuilder(maxChars);

        while (builder.length() > maxChars) {
            switch (tipoHacker) {
                case TipoHacker.Alfabético:
                    caracter = rd.nextInt(caracteresAlfabeticos.length());
                    // clave += caracteresAlfabeticos.charAt(caracter);
                    builder.append(caracteresAlfabeticos.charAt(caracter));
                    break;

                case TipoHacker.Numérico:
                    caracter = rd.nextInt(caracteresNumericos.length());
                    // clave += caracteresNumericos.charAt(caracter);
                    builder.append(caracteresNumericos.charAt(caracter));
                    break;

                case TipoHacker.Alfanumérico:
                    boolean siguienteEsLetra = rd.nextBoolean();
                    if (siguienteEsLetra) {
                        caracter = rd.nextInt(caracteresAlfabeticos.length());
                        // clave += caracteresAlfabeticos.charAt(caracter);
                    } else {
                        caracter = rd.nextInt(caracteresNumericos.length());
                        // clave += caracteresNumericos.charAt(caracter);
                        builder.append(caracteresNumericos.charAt(caracter));
                    }

                    break;
                default:
                    break;
            }

        }

        return builder.toString();

    }

}
