package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 08/04/17.
 */
public class Partido {

    String strNombrePartido;

    public Partido(String strNombrePartido){
        this.strNombrePartido = strNombrePartido;

    }

    public String obtenerNombre(){
        return this.strNombrePartido;
    }
}
