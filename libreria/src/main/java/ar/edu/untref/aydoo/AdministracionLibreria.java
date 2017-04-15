package ar.edu.untref.aydoo;

import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */

//SERVICES
public class AdministracionLibreria {

    public Double calcularMontoACobrar(Mes mes, Cliente cliente){
        Double montoARetornar = 0.0;

        LinkedList<Producto> productosCompra = cliente.ObtenerItemsCompra(mes);

        LinkedList<Producto> productosSuscripcion = cliente.ObtenerSuscripciones();

        for(Producto producto : productosCompra){
            montoARetornar = montoARetornar + producto.ObtenerPrecio(false);
        }

        for(Producto producto : productosSuscripcion){
            montoARetornar = montoARetornar + producto.ObtenerPrecio(true);
        }

        return montoARetornar;
    }
}
