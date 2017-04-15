package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 02/04/17.
 */

//ENTITY
public class Producto {

    Double dblPrecio;
    Categoria categoria;
    Frecuencia frecuencia;
    String strNombre;

    public Producto(String nombre, Double precio, Frecuencia frecuencia, Categoria categoria){
        this.dblPrecio = precio;
        this.categoria = categoria;
        this.frecuencia = frecuencia;
        this.strNombre = nombre;
    }

    public Double ObtenerPrecio(Boolean esSuscripcion){

        Double precioRetorno = this.dblPrecio;

        if(this.categoria.equals(Categoria.ARTICULOS)){
            precioRetorno = precioRetorno*1.21;
        }

        if(esSuscripcion.equals(true)){
            precioRetorno = precioRetorno*0.8;

            switch (this.frecuencia){
                case DIARIO:
                    precioRetorno = precioRetorno*(4*7);
                    break;
                case QUINCENAL:
                    precioRetorno = precioRetorno*2;
                    break;
            }
        }

        System.out.println(strNombre + " " + precioRetorno);

        return precioRetorno;
    }
}
