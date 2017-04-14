package ar.edu.untref.aydoo.club;

public class Operacion {

    private double importe;
    private Beneficio beneficio;
    private EnumMes mes;
    
    public Operacion(Beneficio beneficio, int importeOriginal,EnumMes mes) {
        this.beneficio = beneficio;
        this.importe = ( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0;
        this.mes = mes;
    }
    
    public double obtenerImporte(){
        return this.importe;
    }
    
}