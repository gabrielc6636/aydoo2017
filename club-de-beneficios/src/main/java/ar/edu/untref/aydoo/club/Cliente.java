package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Tarjeta tarjeta;
    private List<Operacion> operaciones = new ArrayList<Operacion>();
    private String email;

    public Cliente(Tarjeta tarjeta,String email) {
        this.tarjeta = tarjeta;
        this.email = email;
    }

    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public Tarjeta obtenerTarjeta() {

        return this.tarjeta;
    }

    public double calcularDineroAbonado() {

        double ahorro = 0;
        
        for(Operacion operacion : operaciones){
            ahorro = ahorro + operacion.obtenerImporte();
        }
        
        return ahorro;
    }

    public double calcularAhorro() {

        double ahorro = 0;

        for(Operacion operacion : operaciones){
            ahorro = ahorro + operacion.obtenerImporteAhorrado();
        }

        return ahorro;
    }
    
    public void registrarOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }

}