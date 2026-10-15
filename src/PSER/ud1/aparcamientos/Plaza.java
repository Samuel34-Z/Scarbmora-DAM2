package pser.ud1.aparcamientos;

public class Plaza {
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
