package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */

//AGGREGATE
public class Cliente {

    String strNombreCliente;
    String strDireccion;

    HashMap<Mes,ItemCompra> comprasClientes;

    LinkedList<Producto> lstSuscripciones;

    public Cliente(String pNombre,String pDireccion){
        this.strDireccion = pDireccion;
        this.strNombreCliente = pNombre;

        comprasClientes = new HashMap<Mes,ItemCompra>();
        lstSuscripciones = new LinkedList<Producto>();
    }

    public void AgregarProductoCompra(Mes pmes, Producto pProducto){

        ItemCompra item = comprasClientes.get(pmes);

        if(item ==null){
            item = new ItemCompra();
        }

        item.AgregarItem(pProducto);

        comprasClientes.put(pmes,item);
    }

    public void AgregarProductoSuscripcion(Producto pProducto){

        lstSuscripciones.add(pProducto);

    }

    public LinkedList<Producto> ObtenerItemsCompra(Mes pMes){
        ItemCompra itemCompra = comprasClientes.get(pMes);

        if(itemCompra==null){
            return new LinkedList<Producto>();
        }

        return itemCompra.ObtenerItems();
    }

    public LinkedList<Producto> ObtenerSuscripciones(){

        return lstSuscripciones;
    }
}
