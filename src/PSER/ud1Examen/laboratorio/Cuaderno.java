package pser.ud1Examen.laboratorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cuaderno {

    private Map<String, Entrada> mapa;

    private String quimicoGanador;
    private String formulaGanadora;

    public Cuaderno() {
        mapa = new HashMap<>();
    }

    public synchronized String getHash(String formula) {
        String hash = null;

        if (mapa.containsKey(formula)) {
            Entrada entrada = mapa.get(formula);
            entrada.aumentarConsultas();
            hash = entrada.getHash();
        }

        return hash;
    }

    public synchronized void guardar(String formula, String hash) {

        if (getHash(formula) == null) {
            mapa.put(formula, new Entrada(hash, 1));
        }
    }

    public synchronized String getMasConsultada() {
        String formulaMasUsada = "";
        int masConstuldo = 0;
        Set<Entry<String, Entrada>> entrada = mapa.entrySet();

        for (Entry<String, Entrada> entry : entrada) {
            int consultaActual = entry.getValue().getNumConsultas();
            if (consultaActual > masConstuldo) {
                masConstuldo = consultaActual;
                formulaMasUsada = entry.getKey();
            }

        }

        return "La formula más consultada fue " + formulaMasUsada + " con " + masConstuldo + " científicos usandola";
    }

    public String mostrarGanador() {
        return "Ha ganado el químico " + quimicoGanador + " con la formula " + formulaGanadora;
    }

    public void setQuimicoGanador(String nombreQuimico, String formulaPropuesta) {
        this.quimicoGanador = nombreQuimico;
        this.formulaGanadora = formulaPropuesta;
    }

}
