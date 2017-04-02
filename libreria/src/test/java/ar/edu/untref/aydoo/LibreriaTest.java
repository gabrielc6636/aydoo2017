package ar.edu.untref.aydoo;

import cucumber.api.java.is.En;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 02/04/17.
 */
public class LibreriaTest {
    @Test
    public void compraAgostoClienteJuanTest()
    {

        /*Dados los datos:

        Revista Barcelona $20 cada ejemplar, frecuencia 15 quicenal

        Revista El Gráfico, $30 cada ejemplar, frecuencia mensual

        Libro El Hobbit $50

        Lapicera $5 (al precio de venta hay que sumarle 21% de IVA)

        Diario Página12,  $12 cada ejemplar, frecuencia diaria

        Diario Clarín $13 cada ejemplar, frecuencia diaria*/

        Producto revistaBarcelona = new Producto("Revista Barcelona",20,EnumFrecuencia.QUINCENAL,EnumCategoria.REVISTAS);
        Producto revistaElGrafico = new Producto("Revista El Grafico",30,EnumFrecuencia.MENSUAL,EnumCategoria.REVISTAS);
        Producto elHobbit = new Producto("El Hobbit",50,EnumFrecuencia.UNICO,EnumCategoria.LIBROS);
        Producto lapicera = new Producto("Lapicera",5,EnumFrecuencia.UNICO,EnumCategoria.ARTICULOS);
        Producto diarioPagina12 = new Producto("Diario Pagina 12",12,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);
        Producto diarioClarin = new Producto("Diario Clarin",13,EnumFrecuencia.DIARIO,EnumCategoria.PERIODICOS);

        AdministracionLibreria libreria = new AdministracionLibreria();
        libreria.AgregarProducto(revistaBarcelona);
        libreria.AgregarProducto(revistaElGrafico);
        libreria.AgregarProducto(elHobbit);
        libreria.AgregarProducto(lapicera);
        libreria.AgregarProducto(diarioPagina12);
        libreria.AgregarProducto(diarioClarin);

        /*Caso 1, en agosto Juan compra:

        1 ejemplar del Hobbit,
        2 lapiceras
        un ejemplar del gráfico (ejemplar suelto, no suscripción)
        => Monto a cobrarle por agosto: 50 + 12,1 + 30 = $90*/

        Cliente juan = new Cliente("Juan","Av Siempre Viva 742");

        juan.AgregarProductoCompra(EnumMes.AGOSTO,elHobbit);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(EnumMes.AGOSTO,revistaElGrafico);

        double valorACobrar = libreria.calcularMontoACobrar(EnumMes.AGOSTO,juan);

        double valorPrevistoACobrar = 90;

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }
}
