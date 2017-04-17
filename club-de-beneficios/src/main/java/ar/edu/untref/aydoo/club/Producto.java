package ar.edu.untref.aydoo.club;

/**
 * Created by gabriel on 16/04/17.
 */
public class Producto  implements Comparable<Producto>  {
    private double importe = 0;
    private double importeBeneficio = 0;
    private String nombre;

    public Producto(double importe,String nombre){
        this.importe = importe;
        this.nombre = nombre;
    }

    public double obtenerImporte(){
        return this.importe;
    }

    public void asignarBeneficio(double importe){
        this.importeBeneficio = importe;
    }

    public double obtenerBeneficioImporte(){
        return this.importeBeneficio;
    }

    public String obtenerNombre(){
        return this.nombre;
    }

    @Override
    public int compareTo(Producto producto) {
        if (importe < producto.importe) {
            return -1;
        }
        if (importe > producto.importe) {
            return 1;
        }
        return 0;
    }
}
