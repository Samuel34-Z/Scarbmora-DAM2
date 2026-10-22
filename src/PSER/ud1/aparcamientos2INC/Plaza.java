package pser.ud1.aparcamientos2INC;

public class Plaza {/*
                     * TODO
                     * al aparcar y salir haz que se añaden o quiten posiciones en la lista de
                     * plazas libres, cambia la funcion a la clase parking para poder gestionarla
                     * mejor (crea una funcion que llame a la de la clase plaza o modifica la de la
                     * clase plaza para que este en parking)
                     */
    private boolean plazaOcupada;
    private String condcutorOcupa = "L";

    public synchronized void aparcar(String condcutorOcupa) {
        plazaOcupada = true;
        this.condcutorOcupa = condcutorOcupa;
    }

    public void salir() {
        plazaOcupada = false;
        condcutorOcupa = "L";
    }

    public synchronized boolean isPlazaOcupada() {
        return plazaOcupada;
    }

    @Override
    public String toString() {
        return condcutorOcupa;
    }

}
