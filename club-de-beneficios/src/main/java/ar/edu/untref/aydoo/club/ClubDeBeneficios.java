package ar.edu.untref.aydoo.club;

import java.util.*;

public class ClubDeBeneficios {

    private List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {

        this.establecimientos.add(establecimiento);
    }

    public void agregarCliente(Cliente cliente) {

        this.clientes.add(cliente);
    }

    public Establecimiento obtenerEstablecimientoAFelicitar() {

        Establecimiento establecimientoGanador = new Establecimiento();
        int cantidadDeOperaciones = 0;

        for(Establecimiento establecimiento: establecimientos){
            List<Sucursal> sucursales = establecimiento.obtenerSucursales();
            int operaciones = 0;

            for(Sucursal sucursal:sucursales){
                operaciones = operaciones+sucursal.obtenerOperaciones().size();
            }

            if(operaciones>cantidadDeOperaciones){
                cantidadDeOperaciones = operaciones;
                establecimientoGanador = establecimiento;
            }
        }

        return establecimientoGanador;
    }

    public Sucursal obtenerSucursalAFelicitar(){

        Sucursal sucursalGanadora = new Sucursal("SucursalGanadora");
        int cantidadDeOperaciones = 0;

        for(Establecimiento establecimiento: establecimientos){
            List<Sucursal> sucursales = establecimiento.obtenerSucursales();

            for(Sucursal sucursal:sucursales){
                int operaciones = 0;
                operaciones = operaciones+sucursal.obtenerOperaciones().size();

                if(operaciones>cantidadDeOperaciones){
                    cantidadDeOperaciones = operaciones;
                    sucursalGanadora = sucursal;
                }
            }
        }

        return sucursalGanadora;
    }

    public Map<Cliente,Double> obtenerClientesParaEnviarEmail(Mes mes){
        Map<Cliente,Double> listaDeClientes = new HashMap<Cliente, Double>();

        for(Cliente cliente : clientes){
            double importeAhorrado = 0;

            for(Operacion operacion: cliente.obtenerOperaciones()){
                if(operacion.obtenerMes().equals(mes)){
                    importeAhorrado = importeAhorrado + operacion.obtenerImporteAhorrado();
                }
            }

            if(importeAhorrado>0) {
                listaDeClientes.put(cliente, importeAhorrado);
            }
        }

        return listaDeClientes;
    }

    public void imprimirReporteDeAhorros(Mes mes){
        Map<Cliente,Double> listaDeClientes =obtenerClientesParaEnviarEmail(mes);

        for(Cliente cliente:listaDeClientes.keySet()){
            List<Operacion> operacionesCliente = cliente.obtenerOperaciones();
            for(Operacion operacion: operacionesCliente){
                //Establecimiento | Producto comprado | Precio habitual (sin beneficio) | Beneficio obtenido

            }
        }
    }

}