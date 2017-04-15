package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gabriel on 02/04/17.
 */
public class LibreriaTest {

    private Producto revistaBarcelona;
    private Producto revistaElGrafico;
    private Producto elHobbit;
    private Producto lapicera;
    private Producto diarioPagina12;
    private Producto diarioClarin;

    @Before
    public void precarga(){
        this.revistaBarcelona = new Producto("Revista Barcelona",20.0, Frecuencia.QUINCENAL, Categoria.REVISTAS);
        this.revistaElGrafico = new Producto("Revista El Grafico",30.0, Frecuencia.MENSUAL, Categoria.REVISTAS);
        this.elHobbit = new Producto("El Hobbit",50.0, Frecuencia.UNICO, Categoria.LIBROS);
        this.lapicera = new Producto("Lapicera",5.0, Frecuencia.UNICO, Categoria.ARTICULOS);
        this.diarioPagina12 = new Producto("Diario Pagina 12",12.0, Frecuencia.DIARIO, Categoria.PERIODICOS);
        this.diarioClarin = new Producto("Diario Clarin",13.0, Frecuencia.DIARIO, Categoria.PERIODICOS);
    }

    @Test
    public void compraAgostoClienteJuanTest()
    {
        System.out.println("Ejecuto compraAgostoClienteJuanTest");

        /*PREPARO EL CASO DE TEST*/
        /*Caso 1, en agosto Juan compra:

        1 ejemplar del Hobbit,
        2 lapiceras
        un ejemplar del gráfico (ejemplar suelto, no suscripción)
        => Monto a cobrarle por agosto: 50 + 12,1 + 30 = $92.1*/

        Cliente juan = new Cliente("Juan","Av Siempre Viva 742");

        juan.AgregarProductoCompra(Mes.AGOSTO,elHobbit);
        juan.AgregarProductoCompra(Mes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(Mes.AGOSTO,lapicera);
        juan.AgregarProductoCompra(Mes.AGOSTO,revistaElGrafico);

        AdministracionLibreria libreria = new AdministracionLibreria();
        Double valorACobrar = libreria.calcularMontoACobrar(Mes.AGOSTO,juan);

        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 92.1;

        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

    @Test
    public void compraEneroClienteMariaTest()
    {
        System.out.println("Ejecuto compraAgostoClienteMariaTest");

        /*PREPARO EL CASO DE TEST*/
        /*Caso 2, en enero Maria compra:

            1 suscripción anual a la Revista Barcelona
            un ejemplar del diario Página12
            => Monto a cobrarle por enero: 32 + 12 = $44
        */

        Cliente maria = new Cliente("Maria","Av Siempre Viva 742");

        maria.AgregarProductoSuscripcion(revistaBarcelona);
        maria.AgregarProductoCompra(Mes.ENERO,diarioPagina12);


        AdministracionLibreria libreria = new AdministracionLibreria();

        Double valorACobrar = libreria.calcularMontoACobrar(Mes.ENERO,maria);
        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 44.0;
        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

    @Test
    public void compraEneroClienteGabrielTest()
    {
        System.out.println("Ejecuto compraEneroClienteGabrielTest");


        /*PREPARO EL CASO DE TEST*/
        /*Caso 3, en Agosto Gabriel compra:

            2 lapicera
            un ejemplar de revista ElGrafico

            => Monto a cobrarle por enero: 0 ya que no realiza compras
        */

        Cliente gabriel = new Cliente("Gabriel","Av Siempre Viva 742");

        gabriel.AgregarProductoCompra(Mes.AGOSTO,lapicera);
        gabriel.AgregarProductoCompra(Mes.AGOSTO,lapicera);
        gabriel.AgregarProductoCompra(Mes.AGOSTO,revistaElGrafico);


        AdministracionLibreria libreria = new AdministracionLibreria();

        Double valorACobrar = libreria.calcularMontoACobrar(Mes.ENERO,gabriel);
        System.out.println("El valor a cobrar es:"+valorACobrar);

        Double valorPrevistoACobrar = 0.0;
        System.out.println("El valor previsto a cobrar es:"+valorPrevistoACobrar);

        Assert.assertEquals (valorPrevistoACobrar, valorACobrar);

    }

}
