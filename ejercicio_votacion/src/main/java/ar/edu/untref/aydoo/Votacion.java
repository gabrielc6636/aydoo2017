package ar.edu.untref.aydoo;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<Candidato, Long> t=
                votos.stream().collect(
                        Collectors.groupingBy(Voto::getCandidato, Collectors.counting()));

        Candidato candidatoGanador = new Candidato();
        long vContador = 0;



        for (Map.Entry<Candidato, Long> e: t.entrySet()) {
            //System.out.println("["+e.getKey().getNombre() + "=" + e.getValue()+"]");
            if(candidatoGanador.getNombre().isEmpty()) {
                candidatoGanador = e.getKey();
                vContador = e.getValue();
            }
            if(candidatoGanador != e.getKey() && vContador < e.getValue()){
                candidatoGanador = e.getKey();
                vContador = e.getValue();
            }
        }

        System.out.println("Candidato ganador a nivel nacional: "+candidatoGanador.getNombre() + " con " + vContador + " votos");

    }

    public void RecuentoVotosProvincial(){

        /*System.out.println("Votos:"+votos.size());

        for (Voto voto: votos) {
            System.out.println(voto.getCandidato().getNombre());
            System.out.println(voto.getCandidato().getPartido().toString());
            System.out.println(voto.getProvincia().toString());
        }

        for (Voto voto: votos) {
            System.out.println(voto.getCandidato().getNombre());
            System.out.println(voto.getCandidato().getPartido().toString());
            System.out.println(voto.getProvincia().toString());
        }*/



        Map<Candidato, Long> colCandidato=
                votos.stream().collect(
                        Collectors.groupingBy(Voto::getCandidato, Collectors.counting()));

        Map<Provincia, Long> colProvincia=
                votos.stream().collect(
                        Collectors.groupingBy(Voto::getProvincia, Collectors.counting()));

        Set<Candidato> candidatoes = colCandidato.keySet();

        Map<String,Long> colPartido = candidatoes.stream().collect(Collectors.groupingBy(Candidato::getPartido,Collectors.counting()));

        Provincia provincia = Provincia.BUENOS_AIRES;




        //Itero por Provincia
        for (Map.Entry<Provincia, Long> vProvincia: colProvincia.entrySet()) {

            //System.out.println("["+vProvincia.getKey().toString() + "=" + vProvincia.getValue()+"]");

            int vContadorPartidoProvincia = 0 ;
            String strPartido = "";

            //Itero por Partido
            for (Map.Entry<String, Long> vPartido: colPartido.entrySet()) {

                if(vContadorPartidoProvincia==0){
                    strPartido = vPartido.getKey();
                }

                int vContadorPartido = 0;

                //Itero los votos totales
                for (Voto voto: votos) {

                    if(voto.getProvincia().equals(vProvincia.getKey())) {
                        if(voto.getCandidato().getPartido().equals(strPartido)){
                            vContadorPartido++;
                        }

                    }


                }

                if(vContadorPartidoProvincia<vContadorPartido){
                    strPartido = vPartido.getKey();
                    vContadorPartidoProvincia = vContadorPartido;
                }

            }

            System.out.println("Candidato ganador a nivel provincial: "+vProvincia.getKey().toString() + " el partido:" + strPartido + " con " + vContadorPartidoProvincia + " votos");
        }

    }
}
