package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 25/03/17.
 */
public class Candidato {

    public String getPartido() {
        return vPartido;
    }

    private void setPartido(String pPartido) {
        this.vPartido = pPartido;
    }

    String vPartido;
    String vNombre;

    public String getNombre() {
        return vNombre;
    }

    private void setNombre(String pNombre) {
        this.vNombre = pNombre;
    }



    public Candidato (String pNombre,String pPartido){

        setPartido(pPartido);
        setNombre(pNombre);

    }

    public Candidato (){

        setNombre("");

    }



}
