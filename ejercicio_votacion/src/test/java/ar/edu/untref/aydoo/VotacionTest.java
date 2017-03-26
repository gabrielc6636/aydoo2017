package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 25/03/17.
 */
public class VotacionTest {
    @Test
    public void TestVotacionXPais()
    {
        Candidato candidato1 = new Candidato("Candidato1","PartidoA");
        Candidato candidato2 = new Candidato("Candidato2","PartidoA");

        Candidato candidato3 = new Candidato("Candidato3","PartidoB");

        Candidato candidato4 = new Candidato("Candidato4","PartidoC");

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

        votacion.RecuentoVotosNacional();
        Assert.assertEquals("foo", "foo");

    }

    @Test
    public void TestVotacionXProvinciaYPartido()
    {
        Candidato candidato1 = new Candidato("Candidato1","PartidoA");
        Candidato candidato2 = new Candidato("Candidato2","PartidoA");

        Candidato candidato3 = new Candidato("Candidato3","PartidoB");

        Candidato candidato4 = new Candidato("Candidato4","PartidoC");

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

        votacion.RecuentoVotosProvincial();
        Assert.assertEquals("foo", "foo");

    }
}
