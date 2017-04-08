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

    public void EmitirVoto(Voto voto){
        votos.add(voto);
    }

    public Map<Candidato, Long> RecuentoVotosNacional(){

        Map<Candidato, Long> mapCandidatoVotos=
                votos.stream().collect(
                        Collectors.groupingBy(Voto::obtenerCandidato, Collectors.counting()));

        Map<Candidato, Long> mapCandidatoGanador = new HashMap<Candidato,Long>();

        Candidato candidatoGanador = new Candidato();

        long lngContador = 0;

        for (Map.Entry<Candidato, Long> registroVotos: mapCandidatoVotos.entrySet()) {

            if(candidatoGanador.obtenerNombre().isEmpty()) {
                candidatoGanador = registroVotos.getKey();
                lngContador = registroVotos.getValue();
            }
            if(candidatoGanador != registroVotos.getKey() && lngContador < registroVotos.getValue()){
                candidatoGanador = registroVotos.getKey();
                lngContador = registroVotos.getValue();
            }
        }

        mapCandidatoGanador.put(candidatoGanador,lngContador);

        return mapCandidatoGanador;

    }

    public Map<Partido, Long> RecuentoVotosProvincial(Provincia provincia){

        Map<Partido, Long> mapVotosProvinciales = new HashMap<Partido,Long>();

        for (Voto voto: votos) {
            if(voto.obtenerProvincia().equals(provincia)){
                Partido partidoVoto = voto.obtenerCandidato().obtenerPartido();
                long lngVotos = 0;
                if(mapVotosProvinciales.containsKey(partidoVoto)) {
                    lngVotos=mapVotosProvinciales.get(partidoVoto);
                }
                mapVotosProvinciales.put(partidoVoto,lngVotos+1);
            }
        }

        Partido partidoGanador = new Partido("");

        long lngContador = 0;

        for (Map.Entry<Partido, Long> registroVotos: mapVotosProvinciales.entrySet()) {

            if(partidoGanador.obtenerNombre().isEmpty()) {
                partidoGanador = registroVotos.getKey();
                lngContador = registroVotos.getValue();
            }
            if(partidoGanador != registroVotos.getKey() && lngContador < registroVotos.getValue()){
                partidoGanador = registroVotos.getKey();
                lngContador = registroVotos.getValue();
            }
        }

        mapVotosProvinciales.clear();
        mapVotosProvinciales.put(partidoGanador,lngContador);

        return mapVotosProvinciales;
    }

    public List<Voto> ResumenVotos(){
        return this.votos;
    }
}
