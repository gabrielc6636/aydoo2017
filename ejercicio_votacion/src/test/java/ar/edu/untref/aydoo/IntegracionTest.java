package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by gabriel on 25/03/17.
 */
public class IntegracionTest {

    @Test
    public void TestEmisionVotos()
    {

        System.out.println("TestEmisionVotos");

        Partido partidoA = new Partido("PartidoA");
        Partido partidoB = new Partido("PartidoB");
        Partido partidoC = new Partido("PartidoC");


        Candidato candidato1 = new Candidato("Candidato1",partidoA);
        Candidato candidato2 = new Candidato("Candidato2",partidoA);

        Candidato candidato3 = new Candidato("Candidato3",partidoB);

        Candidato candidato4 = new Candidato("Candidato4",partidoC);

        Votacion votacion    = new Votacion();

        Voto voto1 = new Voto();
        voto1.EmitirVoto(candidato1,Provincia.BUENOS_AIRES);

        Voto voto2 = new Voto();
        voto2.EmitirVoto(candidato2,Provincia.SALTA);

        Voto voto3 = new Voto();
        voto3.EmitirVoto(candidato3,Provincia.RIO_NEGRO);

        Voto voto4 = new Voto();
        voto4.EmitirVoto(candidato4,Provincia.LA_PAMPA);

        Voto voto5 = new Voto();
        voto5.EmitirVoto(candidato3,Provincia.TIERRA_DEL_FUEGO);

        Voto voto6 = new Voto();
        voto6.EmitirVoto(candidato3,Provincia.BUENOS_AIRES);

        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);

        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);

        votacion.EmitirVoto(voto3);
        votacion.EmitirVoto(voto3);

        votacion.EmitirVoto(voto4);

        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);

        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);

        List<Voto> votos = votacion.ResumenVotos();

        System.out.println("Votos:"+votos.size());

        for (Voto voto: votos) {
            System.out.println(voto.obtenerCandidato().obtenerNombre().toString() + " " + voto.obtenerCandidato().obtenerPartido().obtenerNombre() + " " + voto.obtenerProvincia().toString());

        }

        Assert.assertEquals(20, votos.size());

    }

    @Test
    public void TestVotacionXPais()
    {

        System.out.println("TestVotacionXPais");

        Partido partidoA = new Partido("PartidoA");
        Partido partidoB = new Partido("PartidoB");
        Partido partidoC = new Partido("PartidoC");


        Candidato candidato1 = new Candidato("Candidato1",partidoA);
        Candidato candidato2 = new Candidato("Candidato2",partidoA);

        Candidato candidato3 = new Candidato("Candidato3",partidoB);

        Candidato candidato4 = new Candidato("Candidato4",partidoC);

        Votacion votacion    = new Votacion();

        Voto voto1 = new Voto();
        voto1.EmitirVoto(candidato1,Provincia.BUENOS_AIRES);

        Voto voto2 = new Voto();
        voto2.EmitirVoto(candidato2,Provincia.SALTA);

        Voto voto3 = new Voto();
        voto3.EmitirVoto(candidato3,Provincia.RIO_NEGRO);

        Voto voto4 = new Voto();
        voto4.EmitirVoto(candidato4,Provincia.LA_PAMPA);

        Voto voto5 = new Voto();
        voto5.EmitirVoto(candidato3,Provincia.TIERRA_DEL_FUEGO);

        Voto voto6 = new Voto();
        voto6.EmitirVoto(candidato3,Provincia.BUENOS_AIRES);

        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);

        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);

        votacion.EmitirVoto(voto3);
        votacion.EmitirVoto(voto3);

        votacion.EmitirVoto(voto4);

        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);

        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);

        Map<Candidato, Long> mapCandidatoGanador = votacion.RecuentoVotosNacional();

        Candidato candidatoGanador = new Candidato();

        for (Map.Entry<Candidato, Long> registroVotos: mapCandidatoGanador.entrySet()) {
            candidatoGanador = registroVotos.getKey();
            System.out.println("Candidato ganador a nivel nacional: "+candidatoGanador.obtenerNombre() + " con " + registroVotos.getValue() + " votos");
        }

        Assert.assertEquals("Candidato3", candidatoGanador.obtenerNombre());

    }

    @Test
    public void TestVotacionXProvinciaYPartido()
    {

        System.out.println("TestVotacionXProvinciaYPartido");

        Partido partidoA = new Partido("PartidoA");
        Partido partidoB = new Partido("PartidoB");
        Partido partidoC = new Partido("PartidoC");


        Candidato candidato1 = new Candidato("Candidato1",partidoA);
        Candidato candidato2 = new Candidato("Candidato2",partidoA);

        Candidato candidato3 = new Candidato("Candidato3",partidoB);

        Candidato candidato4 = new Candidato("Candidato4",partidoC);

        Votacion votacion    = new Votacion();

        Voto voto1 = new Voto();
        voto1.EmitirVoto(candidato1,Provincia.BUENOS_AIRES);

        Voto voto2 = new Voto();
        voto2.EmitirVoto(candidato2,Provincia.SALTA);

        Voto voto3 = new Voto();
        voto3.EmitirVoto(candidato3,Provincia.RIO_NEGRO);

        Voto voto4 = new Voto();
        voto4.EmitirVoto(candidato4,Provincia.LA_PAMPA);

        Voto voto5 = new Voto();
        voto5.EmitirVoto(candidato3,Provincia.TIERRA_DEL_FUEGO);

        Voto voto6 = new Voto();
        voto6.EmitirVoto(candidato3,Provincia.BUENOS_AIRES);

        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);
        votacion.EmitirVoto(voto1);

        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);
        votacion.EmitirVoto(voto2);

        votacion.EmitirVoto(voto3);
        votacion.EmitirVoto(voto3);

        votacion.EmitirVoto(voto4);

        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);
        votacion.EmitirVoto(voto5);

        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);
        votacion.EmitirVoto(voto6);

        Map<Partido, Long> mapPartidoGanador = votacion.RecuentoVotosProvincial(Provincia.BUENOS_AIRES);

        Partido partidoGanador = new Partido("");

        for (Map.Entry<Partido, Long> registroVotos: mapPartidoGanador.entrySet()) {
            partidoGanador = registroVotos.getKey();
            System.out.println("Candidato ganador a nivel provincial : "+ Provincia.BUENOS_AIRES.toString() + " el partido:" + partidoGanador.obtenerNombre() + " con " + registroVotos.getValue() + " votos");
        }

        Assert.assertEquals("PartidoA", partidoGanador.obtenerNombre());

    }
}
