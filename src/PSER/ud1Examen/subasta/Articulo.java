package pser.ud1Examen.subasta;

public class Articulo {
    private String nombreArticulo;
    private double precioObjetivo;
    private String maximoPostor;
    private double precioActual = 0.0;

    public Articulo(String nombreArticulo, double precioObjetivo) {
        this.nombreArticulo = nombreArticulo;
        this.precioObjetivo = precioObjetivo;
        maximoPostor = null;
    }

    public static void main(String[] args) {

    }

    public double getPrecioActual() {
        return precioActual;
    }

    public String getMaximoPostor() {
        return maximoPostor;
    }

    public boolean aumentarPrecio(double cantidad, String nombre) {
        precioActual += cantidad;
        maximoPostor = nombre;
        return precioActual > precioObjetivo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    @Override
    public String toString() {
        return "Ha ganado " + maximoPostor + " con " + precioActual;
    }

}
