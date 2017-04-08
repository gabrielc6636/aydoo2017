package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 25/03/17.
 */
public class Candidato {

    Partido partido;
    String nombre;

    public Partido obtenerPartido() {
        return this.partido;
    }

    private void asignarPartido(Partido partido) {
        this.partido = partido;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    private void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public Candidato (String nombre,Partido partido){
        asignarPartido(partido);
        asignarNombre(nombre);
    }

    public Candidato (){

        asignarNombre("");

    }
}
