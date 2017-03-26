package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 25/03/17.
 */
public class Votacion {
    List<Voto> votos;

    public Votacion(){
        votos = new ArrayList<Voto>();

    }

    public void EmitirVoto(Voto pVoto){
        votos.add(pVoto);
    }

    public void RecuentoVotosNacional(){

    }

    public void RecuentoVotosProvincial(){

    }

    public void Votos(){

        System.out.println("Votos:"+votos.size());

        for (Voto voto: votos) {
            System.out.println(voto.getCandidato().getNombre());
            System.out.println(voto.getCandidato().getPartido().toString());
            System.out.println(voto.getProvincia().toString());
        }
    }
}
