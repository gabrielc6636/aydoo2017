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

    public Producto(String pNombre, Double pPrecio, Frecuencia pFrecuencia, Categoria pCategoria){
        this.dblPrecio = pPrecio;
        this.categoria = pCategoria;
        this.frecuencia = pFrecuencia;
        this.strNombre = pNombre;
    }

    public Double ObtenerPrecio(Boolean pEsSuscripcion){

        Double precioRetorno = this.dblPrecio;

        if(this.categoria.equals(Categoria.ARTICULOS)){
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

        System.out.println(strNombre + " " + precioRetorno);

        return precioRetorno;
    }
}
