package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebaClubDeBeneficios {

    private Cliente juan;
    private Cliente carlos;

    private Establecimiento heladeriaA;
    private Establecimiento restaurantB;

    private Sucursal sucursalS1;
    private Sucursal sucursalS2;
    private Sucursal sucursalS3;

    @Before
    public void inicializar() {

        /*Carlos tiene tarjeta Classic.

        Juan tiene tarjeta Premium.


        La heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de descuento con tarjeta Premium.

        La heladería A tiene las sucursales S1 y S2.


                El restaurant B ofrece un 20% de descuento con ambas tarjetas.

        El restaurant B tiene una sola sucursal: S3.*/

        this.juan = new Cliente(Tarjeta.PREMIUM);
        this.carlos  =new Cliente(Tarjeta.CLASSIC);

        this.heladeriaA = new Establecimiento();
        this.heladeriaA.agregarBeneficio(new Beneficio(Tarjeta.CLASSIC,10));
        this.heladeriaA.agregarBeneficio(new Beneficio(Tarjeta.PREMIUM,20));

        this.sucursalS1=new Sucursal("S1");
        this.sucursalS2 = new Sucursal("S2");

        this.heladeriaA.agregarSucursal(sucursalS1);
        this.sucursalS1.asignarEstablecimiento(heladeriaA);
        this.heladeriaA.agregarSucursal(sucursalS2);
        this.sucursalS2.asignarEstablecimiento(heladeriaA);

        this.restaurantB = new Establecimiento();
        this.restaurantB.agregarBeneficio(new Beneficio(Tarjeta.CLASSIC,20));
        this.restaurantB.agregarBeneficio(new Beneficio(Tarjeta.PREMIUM,20));
        this.sucursalS3 = new Sucursal("S3");

        this.restaurantB.agregarSucursal(sucursalS3);
        this.sucursalS3.asignarEstablecimiento(restaurantB);

    }

    @Test
    public void devuelveJuanComoUnicoBeneficiadoEnElMes() {
        
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 10);
        
        Operacion operacion = new Operacion(beneficio, 1000);
        
        juan.getOperaciones().add(operacion);
        
        Assert.assertEquals(900, juan.calcularAhorro(), 0.005);
    }

}