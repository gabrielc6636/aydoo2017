package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 25/03/17.
 */
public class Candidato {

    public Partido getPartido() {
        return vPartido;
    }

    private void setPartido(Partido pPartido) {
        this.vPartido = vPartido;
    }

    Partido vPartido;
    String vNombre;

    public String getNombre() {
        return vNombre;
    }

    private void setNombre(String pNombre) {
        this.vNombre = pNombre;
    }



    public Candidato (String pNombre,Partido pPartido){

        setPartido(pPartido);
        setNombre(pNombre);

    }



}
