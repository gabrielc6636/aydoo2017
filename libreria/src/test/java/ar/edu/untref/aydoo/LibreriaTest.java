package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 02/04/17.
 */
public class LibreriaTest {
    @Test
    public void compraAgostoClienteJuanTest()
    {
        System.out.println("Ejecuto compraAgostoClienteJuanTest");

        /*Dados los datos:

        Revista Barcelona $20 cada ejemplar, frecuencia 15 quicenal

        Revista El Gráfico, $30 cada ejemplar, frecuencia mensual

        Libro El Hobbit $50

        Lapicera $5 (al precio de venta hay que sumarle 21% de IVA)

        Diario Página12,  $12 cada ejemplar, frecuencia diaria

        Diario Clarín $13 cada ejemplar, frecuencia diaria*/

        Producto revistaBarcelona = new Producto("Revista Barcelona",20.0,EnumFrecuencia.QUINCENAL,EnumCategoria.REVISTAS);
        Producto revistaElGrafico = new Producto("Revista El Grafico",30.0,EnumFrecuencia.MENSUAL,EnumCategoria.REVISTAS);

        Producto elHobbit = new Producto("El Hobbit",50.0,EnumFrecuencia.UNICO,EnumCategoria.LIBROS);

        Producto lapicera = new Producto("Lapicera",5.0,EnumFrecuencia.UNICO,EnumCategoria.ARTICULOS);

        Producto diarioPagina12 = new Producto("Diario Pagina 12",12.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);
        Producto diarioClarin = new Producto("Diario Clarin",13.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);

        /*PREPARO EL CASO DE TEST*/
        /*Caso 1, en agosto Juan compra:

        1 ejemplar del Hobbit,
        2 lapiceras
        un ejemplar del gráfico (ejemplar suelto, no suscripción)
        => Monto a cobrarle por agosto: 50 + 12,1 + 30 = $92.1*/

        Cliente juan = new Cliente("Juan","Av Siempre Viva 742");

        juan.AgregarProductoCompra(EnumMes.AGOSTO,elHobbit);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,revistaElGrafico);

        AdministracionLibreria libreria = new AdministracionLibreria();
        Double valorACobrar = libreria.calcularMontoACobrar(EnumMes.AGOSTO,juan);

        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 92.1;

        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

    @Test
    public void compraEneroClienteMariaTest()
    {
        System.out.println("Ejecuto compraAgostoClienteMariaTest");

        /*Dados los datos:

        Revista Barcelona $20 cada ejemplar, frecuencia 15 quicenal

        Revista El Gráfico, $30 cada ejemplar, frecuencia mensual

        Libro El Hobbit $50

        Lapicera $5 (al precio de venta hay que sumarle 21% de IVA)

        Diario Página12,  $12 cada ejemplar, frecuencia diaria

        Diario Clarín $13 cada ejemplar, frecuencia diaria*/

        Producto revistaBarcelona = new Producto("Revista Barcelona",20.0,EnumFrecuencia.QUINCENAL,EnumCategoria.REVISTAS);
        Producto revistaElGrafico = new Producto("Revista El Grafico",30.0,EnumFrecuencia.MENSUAL,EnumCategoria.REVISTAS);

        Producto elHobbit = new Producto("El Hobbit",50.0,EnumFrecuencia.UNICO,EnumCategoria.LIBROS);

        Producto lapicera = new Producto("Lapicera",5.0,EnumFrecuencia.UNICO,EnumCategoria.ARTICULOS);

        Producto diarioPagina12 = new Producto("Diario Pagina 12",12.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);
        Producto diarioClarin = new Producto("Diario Clarin",13.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);

        /*PREPARO EL CASO DE TEST*/
        /*Caso 2, en enero Maria compra:

            1 suscripción anual a la Revista Barcelona
            un ejemplar del diario Página12
            => Monto a cobrarle por enero: 32 + 12 = $44
        */

        Cliente maria = new Cliente("Maria","Av Siempre Viva 742");

        maria.AgregarProductoSuscripcion(revistaBarcelona);
        maria.AgregarProductoCompra(EnumMes.ENERO,diarioPagina12);


        AdministracionLibreria libreria = new AdministracionLibreria();

        Double valorACobrar = libreria.calcularMontoACobrar(EnumMes.ENERO,maria);
        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 44.0;
        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

    @Test
    public void compraEneroClienteGabrielTest()
    {
        System.out.println("Ejecuto compraEneroClienteGabrielTest");

        /*Dados los datos:

        Revista Barcelona $20 cada ejemplar, frecuencia 15 quicenal

        Revista El Gráfico, $30 cada ejemplar, frecuencia mensual

        Libro El Hobbit $50

        Lapicera $5 (al precio de venta hay que sumarle 21% de IVA)

        Diario Página12,  $12 cada ejemplar, frecuencia diaria

        Diario Clarín $13 cada ejemplar, frecuencia diaria*/

        Producto revistaBarcelona = new Producto("Revista Barcelona",20.0,EnumFrecuencia.QUINCENAL,EnumCategoria.REVISTAS);
        Producto revistaElGrafico = new Producto("Revista El Grafico",30.0,EnumFrecuencia.MENSUAL,EnumCategoria.REVISTAS);

        Producto elHobbit = new Producto("El Hobbit",50.0,EnumFrecuencia.UNICO,EnumCategoria.LIBROS);

        Producto lapicera = new Producto("Lapicera",5.0,EnumFrecuencia.UNICO,EnumCategoria.ARTICULOS);

        Producto diarioPagina12 = new Producto("Diario Pagina 12",12.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);
        Producto diarioClarin = new Producto("Diario Clarin",13.0,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);

        /*PREPARO EL CASO DE TEST*/
        /*Caso 3, en Agosto Gabriel compra:

            2 lapicera
            un ejemplar de revista ElGrafico

            => Monto a cobrarle por enero: 0 ya que no realiza compras
        */

        Cliente gabriel = new Cliente("Gabriel","Av Siempre Viva 742");

        gabriel.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        gabriel.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        gabriel.AgregarProductoCompra(EnumMes.AGOSTO,revistaElGrafico);


        AdministracionLibreria libreria = new AdministracionLibreria();

        Double valorACobrar = libreria.calcularMontoACobrar(EnumMes.ENERO,gabriel);
        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 0.0;
        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

}
