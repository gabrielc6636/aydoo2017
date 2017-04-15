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

    public Cliente(String nombre,String direccion){
        this.strDireccion = direccion;
        this.strNombreCliente = nombre;
        comprasClientes = new HashMap<Mes,ItemCompra>();
        lstSuscripciones = new LinkedList<Producto>();
    }

    public void AgregarProductoCompra(Mes mes, Producto producto){
        ItemCompra item = comprasClientes.get(mes);
        if(item ==null){
            item = new ItemCompra();
        }
        item.AgregarItem(producto);
        comprasClientes.put(mes,item);
    }

    public void AgregarProductoSuscripcion(Producto producto){
        lstSuscripciones.add(producto);
    }

    public LinkedList<Producto> ObtenerItemsCompra(Mes mes){
        ItemCompra itemCompra = comprasClientes.get(mes);

        if(itemCompra==null){
            return new LinkedList<Producto>();
        }
        return itemCompra.ObtenerItems();
    }

    public LinkedList<Producto> ObtenerSuscripciones(){
        return lstSuscripciones;
    }
}
