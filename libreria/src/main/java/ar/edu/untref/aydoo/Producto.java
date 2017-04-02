package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 02/04/17.
 */
public class Producto {

    Double dblPrecio;
    EnumCategoria categoria;

    public Producto(String pNombre,Double pPrecio,EnumFrecuencia pFrecuencia,EnumCategoria pCategoria){
        this.dblPrecio = pPrecio;
        this.categoria = pCategoria;
    }

    public Double ObtenerPrecio(Boolean pEsSuscripcion){

        Double precioRetorno = this.dblPrecio;

        if(this.categoria.equals(EnumCategoria.ARTICULOS)){
            precioRetorno = precioRetorno*1.21;
        }

        if(pEsSuscripcion.equals(true)){
            precioRetorno = precioRetorno*0.8;
        }

        return precioRetorno;
    }
}
