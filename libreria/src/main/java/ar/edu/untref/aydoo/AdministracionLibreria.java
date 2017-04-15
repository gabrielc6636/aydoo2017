package ar.edu.untref.aydoo;

import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */

//SERVICES
public class AdministracionLibreria {
    public AdministracionLibreria(){

    }

    public Double calcularMontoACobrar(Mes pmes, Cliente pCliente){
        Double montoARetornar = 0.0;

        LinkedList<Producto> productosCompra = pCliente.ObtenerItemsCompra(pmes);

        LinkedList<Producto> productosSuscripcion = pCliente.ObtenerSuscripciones();

        for(Producto producto : productosCompra){
            montoARetornar = montoARetornar + producto.ObtenerPrecio(false);
        }

        for(Producto producto : productosSuscripcion){
            montoARetornar = montoARetornar + producto.ObtenerPrecio(true);
        }

        return montoARetornar;
    }
}
