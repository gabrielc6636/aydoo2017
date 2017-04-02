package ar.edu.untref.aydoo;

import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */
public class AdministracionLibreria {
    public AdministracionLibreria(){

    }

    public void AgregarProducto(Producto pProducto){

    }

    public Double calcularMontoACobrar(EnumMes pmes,Cliente pCliente){
        Double montoARetornar = 0.0;

        LinkedList<Producto> productosCompra = pCliente.ObtenerItemsCompra(pmes);

        LinkedList<Producto> productosSuscripcion = pCliente.ObtenerSuscripciones();

        for(Producto producto : productosCompra){

        }

        for(Producto producto : productosSuscripcion){

        }

        return montoARetornar;
    }
}
