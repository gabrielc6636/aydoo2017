package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClubDeBeneficiosTest {

    private Cliente juan;
    private Cliente carlos;

    private Establecimiento heladeriaA;
    private Establecimiento restaurantB;

    private Sucursal sucursalS1;
    private Sucursal sucursalS2;
    private Sucursal sucursalS3;

    private ClubDeBeneficios club;

    @Before
    public void inicializar() throws BeneficioException {

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

        this.club.agregarCliente(juan);
        this.club.agregarCliente(carlos);

    }

    @Test
    public void devuelveJuanComoUnicoBeneficiadoEnElMes() throws BeneficioException {
        
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 10);

        Producto productoTest = new Producto(1000,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        Operacion operacion = new Operacion(beneficio, productos, Mes.ENERO);
        
        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(900, juan.calcularDineroAbonado(), 0.005);
    }

    @Test
    public void siTengoUnaOperacionElEstablecimientoQueMasBeneficiosTieneQueSerElDeLaOperacion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        Producto productoTest = new Producto(100,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        sucursalS1.comprar(juan, productos, Mes.ENERO);

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

        Producto productoTest = new Producto(500.0,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        //OPERACIONES CLASSIC
        sucursalS1.comprar(carlos,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS1.comprar(juan,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);

        //OPERACIONES CLASSIC
        sucursalS3.comprar(carlos,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);

        Establecimiento establecimientoConMasBeneficios = club.obtenerEstablecimientoAFelicitar();
        Assert.assertEquals(heladeriaA, establecimientoConMasBeneficios);
    }

    @Test
    public void siTengoUnaOperacionLaSucursalQueMasBeneficiosTieneQueSerElDeLaOperacion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        Producto productoTest = new Producto(100,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        sucursalS1.comprar(juan, productos, Mes.ENERO);

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

        Producto productoTest = new Producto(500.0,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        //OPERACIONES CLASSIC
        sucursalS1.comprar(carlos,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS1.comprar(juan,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);

        //OPERACIONES CLASSIC
        sucursalS3.comprar(carlos,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);

        Sucursal sucursalGanadora = club.obtenerSucursalAFelicitar();
        Assert.assertEquals(sucursalS1, sucursalGanadora);
    }

    @Test
    public void siJuanHizoOperacionEnEneroTengoQueEnviarleEmail() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        club.agregarCliente(juan);

        Producto productoTest = new Producto(100,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        sucursalS1.comprar(juan, productos, Mes.ENERO);

        Map<Cliente,Double> clientesParaEmail = club.obtenerClientesParaEnviarEmail(Mes.ENERO);

        double valorAhorrado = clientesParaEmail.get(juan);

        Assert.assertTrue(clientesParaEmail.containsKey(juan));
        Assert.assertEquals(20.0,valorAhorrado, 0.005);
    }

    @Test
    public void siNadieHizoOperacionEnEneroNoTengoQueEnviarleEmail() throws BeneficioException {

        Map<Cliente,Double> clientesParaEmail = club.obtenerClientesParaEnviarEmail(Mes.ENERO);

        int cantidadDeClientesANotificar = clientesParaEmail.size();

        Assert.assertEquals(0,cantidadDeClientesANotificar);

    }

    @Test
    public void siJuan_Carlos_ClienteClassic_ClientePremiumHicieronComprasTengoQueNotificarlos() throws BeneficioException{
        /*Durante Enero, la sucursal S1 realiza 4 beneficios con tarjeta Classic y 3 con tarjeta Premium.
         Carlos y Juan utilizaron los beneficios con sus tarjetas, una vez cada uno.

         La sucursal S2 no realiza beneficios.
         La sucursal S3 atendió a 6 clientes y les realizó el beneficio ofrecido.
         Carlos utilizó su tarjeta Classic para hacer uso del beneficio.*/

        Cliente clienteClassic = new Cliente(Tarjeta.CLASSIC,"clienteClassic@classic");
        Cliente clientePremium = new Cliente(Tarjeta.PREMIUM,"clientePremium@premium");

        this.club.agregarCliente(clienteClassic);
        this.club.agregarCliente(clientePremium);

        Producto productoTest = new Producto(500.0,"Producto de Test");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        //OPERACIONES CLASSIC
        sucursalS1.comprar(carlos,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS1.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS1.comprar(juan,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS1.comprar(clientePremium,productos, Mes.ENERO);

        //OPERACIONES CLASSIC
        sucursalS3.comprar(carlos,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);
        sucursalS3.comprar(clienteClassic,productos, Mes.ENERO);

        //OPERACIONES PREMIUM
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);
        sucursalS3.comprar(clientePremium,productos, Mes.ENERO);

        Map<Cliente,Double> clientesParaEmail = club.obtenerClientesParaEnviarEmail(Mes.ENERO);

        Assert.assertTrue(clientesParaEmail.containsKey(this.juan));
        Assert.assertTrue(clientesParaEmail.containsKey(this.carlos));
        Assert.assertTrue(clientesParaEmail.containsKey(clienteClassic));
        Assert.assertTrue(clientesParaEmail.containsKey(clientePremium));

    }

    @Test
    public void siMateoCompra2ProductosCon2x1TengoQueCobrarleSoloUno() throws BeneficioException{
        /*Ejemplo #2:
        Mateo compra con su tarjeta classic el libro "Martín Fierro" ($100) en la librería la librería "El altillo" (sucursal única).
        Esta librería está asociada al club y ofrece el beneficio 2x1.
        Entonces Mateo elige como segundo libro "El Cantar del Cid" ($80) pero como tiene el beneficio este segundo libro le resultar gratis.
        O sea que Mateo se lleva estos dos libros por $100 (el beneficio 2x1 tomo como referencia el  precio del libro más alto)*/

        Establecimiento libreria = new Establecimiento();
        Sucursal sucursal = new Sucursal("Sucursal Unica");
        Cliente mateo = new Cliente(Tarjeta.CLASSIC,"mateo@classic");

        libreria.agregarSucursal(sucursal);
        libreria.agregarBeneficio(new BeneficioExtendido(Tarjeta.CLASSIC,50));
        this.club.agregarCliente(mateo);

        Producto martinFierro = new Producto(100.0,"Martin Fierro");
        Producto elCantarDelCid = new Producto(80.0,"El Cantar del Cid");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(martinFierro);
        productos.add(elCantarDelCid);

        sucursal.comprar(mateo,productos,Mes.ENERO);

        Assert.assertEquals(100, mateo.calcularDineroAbonado(), 0.005);
    }

}