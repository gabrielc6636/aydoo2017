package ar.edu.untref.aydoo.club;

/**
 * Created by gabriel on 16/04/17.
 */
public class Producto  implements Comparable<Producto>  {
    private double importe = 0;
    private String nombre;

    public Producto(double importe,String nombre){
        this.importe = importe;
        this.nombre = nombre;
    }

    public double obtenerImporte(){
        return this.importe;
    }

    @Override
    public int compareTo(Producto o) {
        if (importe < o.importe) {
            return -1;
        }
        if (importe > o.importe) {
            return 1;
        }
        return 0;
    }
}
