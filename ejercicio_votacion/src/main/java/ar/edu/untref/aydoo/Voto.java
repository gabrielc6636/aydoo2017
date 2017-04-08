package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 25/03/17.
 */
public class Voto {

    Provincia provincia;
    Candidato candidato;

    public Candidato obtenerCandidato() {
        return this.candidato;
    }

    private void asignarCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Provincia obtenerProvincia() {
        return provincia;
    }

    private void asignarProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Voto (){

    }

    public Voto EmitirVoto (Candidato candidato,Provincia provincia){
        asignarCandidato(candidato);
        asignarProvincia(provincia);

        return this;
    }
}
