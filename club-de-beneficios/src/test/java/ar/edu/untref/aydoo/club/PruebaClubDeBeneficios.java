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

    private ClubDeBeneficios club;

    @Before
    public void inicializar() {

        /*Carlos tiene tarjeta Classic.
        Juan tiene tarjeta Premium.

        La heladería A ofrece un 10% de descuento con tarjeta Classic y 20% de descuento con tarjeta Premium.
        La heladería A tiene las sucursales S1 y S2.

        El restaurant B ofrece un 20% de descuento con ambas tarjetas.
        El restaurant B tiene una sola sucursal: S3.*/

        this.club = new ClubDeBeneficios();

        this.juan = new Cliente(Tarjeta.PREMIUM,"juan@a.com");
        this.carlos  =new Cliente(Tarjeta.CLASSIC,"carlos@b.com");

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

        this.club.agregarEstablecimiento(heladeriaA);
        this.club.agregarEstablecimiento(restaurantB);

    }

    @Test
    public void devuelveJuanComoUnicoBeneficiadoEnElMes() {
        
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 10);
        
        Operacion operacion = new Operacion(beneficio, 1000,EnumMes.ENERO);
        
        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(900, juan.calcularDineroAbonado(), 0.005);
    }

    @Test
    public void siTengoUnaOperacionElEstablecimientoQueMasBeneficiosTieneQueSerElDeLaOperacion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        sucursalS1.comprar(juan, 100,EnumMes.ENERO);

        Establecimiento establecimientoConMasBeneficios = club.obtenerEstablecimientoAFelicitar();

        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficios);
    }


    @Test
    public void laHeladeriaEsElEstablecimientoQueDeboFelicitar() throws BeneficioException{
        /*Durante Enero, la sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta Premium.
         Carlos y Juan utilizaron los beneficios con sus tarjetas, una vez cada uno.

         La sucursal S2 no realiza beneficios.
         La sucursal S3 atendió a 6 clientes y les realizó el beneficio ofrecido.
         Carlos utilizó su tarjeta Classic para hacer uso del beneficio.*/

        Cliente clienteClassic = new Cliente(Tarjeta.CLASSIC,"clienteClassic@classic");
        Cliente clientePremium = new Cliente(Tarjeta.PREMIUM,"clientePremium@premium");

        //OPERACIONES CLASSIC
        sucursalS1.comprar(carlos,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS1.comprar(juan,500,EnumMes.ENERO);
        sucursalS1.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS1.comprar(clientePremium,500,EnumMes.ENERO);

        //OPERACIONES CLASSIC
        sucursalS3.comprar(carlos,500,EnumMes.ENERO);
        sucursalS3.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS3.comprar(clienteClassic,500,EnumMes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);

        Establecimiento establecimientoConMasBeneficios = club.obtenerEstablecimientoAFelicitar();
        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficios);
    }

    @Test
    public void siTengoUnaOperacionLaSucursalQueMasBeneficiosTieneQueSerElDeLaOperacion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        sucursalS1.comprar(juan, 100,EnumMes.ENERO);

        Sucursal sucursalGanadora = club.obtenerSucursalAFelicitar();

        Assert.assertEquals(sucursalS1, sucursalGanadora);
    }

    @Test
    public void laSucursalS3esLaQueMasBeneficiosRealizo() throws BeneficioException{
        /*Durante Enero, la sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta Premium.
         Carlos y Juan utilizaron los beneficios con sus tarjetas, una vez cada uno.

         La sucursal S2 no realiza beneficios.
         La sucursal S3 atendió a 6 clientes y les realizó el beneficio ofrecido.
         Carlos utilizó su tarjeta Classic para hacer uso del beneficio.*/

        Cliente clienteClassic = new Cliente(Tarjeta.CLASSIC,"clienteClassic@classic");
        Cliente clientePremium = new Cliente(Tarjeta.PREMIUM,"clientePremium@premium");

        //OPERACIONES CLASSIC
        sucursalS1.comprar(carlos,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS1.comprar(clienteClassic,500,EnumMes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS1.comprar(juan,500,EnumMes.ENERO);
        sucursalS1.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS1.comprar(clientePremium,500,EnumMes.ENERO);

        //OPERACIONES CLASSIC
        sucursalS3.comprar(carlos,500,EnumMes.ENERO);
        sucursalS3.comprar(clienteClassic,500,EnumMes.ENERO);
        sucursalS3.comprar(clienteClassic,500,EnumMes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);
        sucursalS3.comprar(clientePremium,500,EnumMes.ENERO);

        Sucursal sucursalGanadora = club.obtenerSucursalAFelicitar();
        Assert.assertEquals(sucursalS1, sucursalGanadora);
    }

}