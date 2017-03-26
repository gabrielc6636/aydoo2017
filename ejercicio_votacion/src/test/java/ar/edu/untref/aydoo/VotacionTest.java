package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 25/03/17.
 */
public class VotacionTest {
    @Test
    public void TestVotacion1()
    {
        Candidato candidato1 = new Candidato("Candidato1",Partido.PartidoA);
        Candidato candidato2 = new Candidato("Candidato2",Partido.PartidoA);

        Candidato candidato3 = new Candidato("Candidato3",Partido.PartidoB);

        Candidato candidato4 = new Candidato("Candidato4",Partido.PartidoC);

        Votacion votacion    = new Votacion();

        Voto voto1 = new Voto();
        voto1.EmitirVoto(candidato1,Provincia.BUENOS_AIRES);

        Voto voto2 = new Voto();
        voto2.EmitirVoto(candidato2,Provincia.BUENOS_AIRES);

        Voto voto3 = new Voto();
        voto3.EmitirVoto(candidato3,Provincia.BUENOS_AIRES);

        Voto voto4 = new Voto();
        voto4.EmitirVoto(candidato4,Provincia.BUENOS_AIRES);

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

        votacion.Votos();
        Assert.assertEquals("foo", "foo");

    }
}
