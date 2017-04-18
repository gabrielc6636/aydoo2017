package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClubDeBeneficios {

    private List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    public void agregarEstablecimiento(final Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }

    public void agregarCliente(final Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Establecimiento obtenerEstablecimientoAFelicitar() {

        Establecimiento establecimientoGanador = new Establecimiento("");
        int cantidadDeOperaciones = 0;

        for (Establecimiento establecimiento: establecimientos) {
            List<Sucursal> sucursales = establecimiento.obtenerSucursales();
            int operaciones = 0;

            for (Sucursal sucursal:sucursales) {
                operaciones = operaciones + sucursal.obtenerOperaciones().size();
            }

            if (operaciones > cantidadDeOperaciones) {
                cantidadDeOperaciones = operaciones;
                establecimientoGanador = establecimiento;
            }
        }

        return establecimientoGanador;
    }

    public Sucursal obtenerSucursalAFelicitar(final Mes mes) {

        Sucursal sucursalGanadora = new Sucursal("SucursalGanadora");
        int cantidadDeOperaciones = 0;

        for (Establecimiento establecimiento: establecimientos) {
            List<Sucursal> sucursales = establecimiento.obtenerSucursales();

            for (Sucursal sucursal:sucursales) {
                int operaciones = 0;

                for (Operacion operacion : sucursal.obtenerOperaciones()) {
                    if (operacion.obtenerMes().equals(mes)) {
                        operaciones = operaciones + 1;
                    }
                }

                if (operaciones > cantidadDeOperaciones) {
                    cantidadDeOperaciones = operaciones;
                    sucursalGanadora = sucursal;
                }
            }
        }

        return sucursalGanadora;
    }

    public Map<Cliente, Double> obtenerClientesParaEnviarEmail(final Mes mes) {
        Map<Cliente, Double> listaDeClientes = new HashMap<Cliente, Double>();

        for (Cliente cliente : clientes) {
            double importeAhorrado = 0;

            for (Operacion operacion: cliente.obtenerOperaciones()) {
                if (operacion.obtenerMes().equals(mes)) {
                    importeAhorrado = importeAhorrado + operacion.obtenerImporteAhorrado();
                }
            }

            if (importeAhorrado > 0) {
                listaDeClientes.put(cliente, importeAhorrado);
            }
        }

        return listaDeClientes;
    }

    public void imprimirReporteDeAhorros(final Mes mes) {
        Map<Cliente, Double> listaDeClientes = obtenerClientesParaEnviarEmail(mes);

        for (Cliente cliente:listaDeClientes.keySet()) {
            System.out.println("Cliente: " + cliente.obtenerNombre());
            List<Operacion> operacionesCliente = cliente.obtenerOperaciones();
            for (Operacion operacion: operacionesCliente) {
                for (Producto producto:operacion.obtenerProductos()) {
                    System.out.println("Establecimiento: " + operacion.obtenerSucursal().obtenerEstablecimiento().obtenerNombre() + " | Producto: " + producto.obtenerNombre() + " | precio habitual (sin beneficio): " + producto.obtenerImporte() + " | beneficio obtenido: " + producto.obtenerBeneficioImporte());
                }
            }
        }
    }

}
