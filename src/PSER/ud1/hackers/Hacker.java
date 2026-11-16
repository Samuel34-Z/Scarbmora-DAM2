package pser.ud1.hackers;

import java.util.Random;

public class Hacker extends Thread {
    private TipoHacker tipoHacker;
    private int maxChars;
    private static String caracteresAlfabeticos = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
    private static int numCaracteresNumericos = 10;
    private static String contrasenhaCorrecta;
    private TablaRainbow tablaRainbow;

    public Hacker(ThreadGroup grupoHackers, TipoHacker tipoHacker, int maxChars, String contrasenhaCorrecta,
            String nombre) {
        super(grupoHackers, nombre);
        this.tipoHacker = tipoHacker;
        this.maxChars = maxChars;
        Hacker.contrasenhaCorrecta = contrasenhaCorrecta;
        this.tablaRainbow = TablaRainbow.getTablaRainbow();
    }

    @Override
    public void run() {
        while (!interrupted()) {
            String clave = generarClave(tipoHacker, maxChars);
            System.out.println(this.getName() + " " + clave);
            String hash = tablaRainbow.obtenerHash(clave);
            if (hash == null) {
                hash = Utiles.generateHash(clave);
                tablaRainbow.agregarHash(clave, hash);
            }
            if (probarClave(hash)) {
                this.getThreadGroup().interrupt();
            }
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

        while (builder.length() < maxChars) {
            switch (tipoHacker) {
                case TipoHacker.Alfabético:
                    caracter = rd.nextInt(caracteresAlfabeticos.length());
                    builder.append(caracteresAlfabeticos.charAt(caracter));
                    break;

                case TipoHacker.Numérico:
                    builder.append(rd.nextInt(numCaracteresNumericos));
                    break;

                case TipoHacker.Alfanumérico:
                    boolean siguienteEsLetra = rd.nextBoolean();
                    if (siguienteEsLetra) {
                        caracter = rd.nextInt(caracteresAlfabeticos.length());
                    } else {
                        builder.append(rd.nextInt(numCaracteresNumericos));
                    }

                    break;
                default:
                    break;
            }

        }

        return builder.toString();

    }

}
