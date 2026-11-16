package pser.ud1Examen.laboratorio;

import java.util.Random;

import pser.ud1Examen.Utiles;

public class Quimico extends Thread {
    private final String POSIBLES_ELEMENTOS_GENERAL = "CHONSP";
    private final String POSIBLES_ELEMENTOS_BASICOS = "CHO";
    private final String POSIBLES_ELEMENTOS_REACTIVOS = "NSP";
    private TipoQuimico tipoQuimico;
    private String formula;
    // private String formulaCandidata;
    private StringBuilder formulaCandidata;
    private final int MAX_ELEMENTOS;
    private final int MIN_ElEMENETOS = 1;
    private Cuaderno cuaderno;

    public Quimico(ThreadGroup grupo, String nombre, TipoQuimico tipoQuimico, String formula, int maxElementos,
            Cuaderno cuaderno) {
        super(grupo, nombre);
        this.tipoQuimico = tipoQuimico;
        this.formula = formula;
        // formulaCandidata = "";
        formulaCandidata = new StringBuilder();
        MAX_ELEMENTOS = maxElementos + 1;
        this.cuaderno = cuaderno;
    }

    @Override
    public void run() {
        Random rd = new Random();
        do {
            boolean formulaGenerada = false;
            int longitud = rd.nextInt(MIN_ElEMENETOS, MAX_ELEMENTOS);
            do {
                if (tipoQuimico.equals(TipoQuimico.Básico)) {
                    // formulaCandidata +=
                    // POSIBLES_ELEMENTOS_BASICOS.charAt(rd.nextInt(POSIBLES_ELEMENTOS_BASICOS.length()));
                    formulaCandidata.append(POSIBLES_ELEMENTOS_BASICOS
                            .charAt(rd.nextInt(POSIBLES_ELEMENTOS_BASICOS.length())));
                } else if (tipoQuimico.equals(TipoQuimico.Reactivo)) {
                    // formulaCandidata +=
                    // POSIBLES_ELEMENTOS_REACTIVOS.charAt(rd.nextInt(POSIBLES_ELEMENTOS_REACTIVOS.length()));
                    formulaCandidata.append(
                            POSIBLES_ELEMENTOS_REACTIVOS.charAt(rd.nextInt(POSIBLES_ELEMENTOS_REACTIVOS.length())));
                } else {
                    // formulaCandidata +=
                    // POSIBLES_ELEMENTOS_GENERAL.charAt(rd.nextInt(POSIBLES_ELEMENTOS_GENERAL.length()));
                    formulaCandidata
                            .append(POSIBLES_ELEMENTOS_GENERAL.charAt(rd.nextInt(POSIBLES_ELEMENTOS_GENERAL.length())));
                }

                if (formulaCandidata.length() == longitud) {
                    formulaGenerada = true;
                }
            } while (!formulaGenerada);

            System.out.println(formulaCandidata.toString());

            String hash = cuaderno.getHash(formulaCandidata.toString());

            if (hash == null) {
                hash = Utiles.generateHash(formulaCandidata.toString());
                cuaderno.guardar(formulaCandidata.toString(), hash);
            }

            if (hash.equals(formula)) {
                cuaderno.setQuimicoGanador(getName(), formulaCandidata.toString());
                getThreadGroup().interrupt();
            } else {
                formulaCandidata = new StringBuilder();
            }

        } while (!interrupted());

    }
}
