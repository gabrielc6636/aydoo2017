package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gabriel on 02/04/17.
 */

//REPOSITORY
public class ItemCompra {

    LinkedList<Producto> lstProductos;

    public ItemCompra(){
        lstProductos = new LinkedList<Producto>();
    }

    public void AgregarItem(Producto pProducto){
        lstProductos.add(pProducto);
    }

    public LinkedList<Producto> ObtenerItems(){
        return lstProductos;
    }
}
