package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 02/04/17.
 */
public class Producto {

    Double dblPrecio;
    EnumCategoria categoria;
    EnumFrecuencia frecuencia;

    public Producto(String pNombre,Double pPrecio,EnumFrecuencia pFrecuencia,EnumCategoria pCategoria){
        this.dblPrecio = pPrecio;
        this.categoria = pCategoria;
        this.frecuencia = pFrecuencia;
    }

    public Double ObtenerPrecio(Boolean pEsSuscripcion){

        Double precioRetorno = this.dblPrecio;

        if(this.categoria.equals(EnumCategoria.ARTICULOS)){
            precioRetorno = precioRetorno*1.21;
        }

        if(pEsSuscripcion.equals(true)){
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

        return precioRetorno;
    }
}
