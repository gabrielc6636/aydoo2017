package ar.edu.untref.aydoo.club;

/**
 * Created by gabriel on 16/04/17.
 */
public class Producto {
    private double importe = 0;
    private String nombre;

    public Producto(double importe,String nombre){
        this.importe = importe;
        this.nombre = nombre;
    }

    public double obtenerImporte(){
        return this.importe;
    }
}
