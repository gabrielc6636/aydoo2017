package ar.edu.untref.aydoo;

/**
 * Created by gabriel on 25/03/17.
 */
public class Voto {
    public Candidato getCandidato() {
        return candidato;
    }

    public String getCandidato_Nombre() {
        return getCandidato().getNombre();
    }

    private void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    Candidato candidato;

    public Provincia getProvincia() {
        return provincia;
    }

    private void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    Provincia provincia;

    public Voto (){

    }

    public Voto EmitirVoto (Candidato pCandidato,Provincia pProvincia){
        setCandidato(pCandidato);
        setProvincia(pProvincia);

        return this;
    }
}
