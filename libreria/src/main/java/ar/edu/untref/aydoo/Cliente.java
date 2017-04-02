package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */
public class Cliente {

    String strNombreCliente;
    String strDireccion;

    HashMap<EnumMes,ItemCompra> comprasClientes;

    LinkedList<Producto> lstSuscripciones;

    public Cliente(String pNombre,String pDireccion){
        this.strDireccion = pDireccion;
        this.strNombreCliente = pNombre;

        comprasClientes = new HashMap<EnumMes,ItemCompra>();
        lstSuscripciones = new LinkedList<Producto>();
    }

    public void AgregarProductoCompra(EnumMes pmes, Producto pProducto){

        ItemCompra item = comprasClientes.get(pmes);

        item.AgregarItem(pProducto);

        comprasClientes.put(pmes,item);
    }

    public void AgregarProductoSuscripcion(Producto pProducto){

        lstSuscripciones.add(pProducto);

    }
}
