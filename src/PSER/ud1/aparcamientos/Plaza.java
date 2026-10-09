package pser.ud1.aparcamientos;

public class Plaza {
    private boolean posicionOcupada;
    private String condcutorOcupa;

    public void aparcar(String condcutorOcupa) {
        posicionOcupada = true;
        this.condcutorOcupa = condcutorOcupa;
    }

    public void salir() {
        posicionOcupada = false;
    }

    public synchronized boolean isPosicionOcupada() {
        return posicionOcupada;
    }

}
