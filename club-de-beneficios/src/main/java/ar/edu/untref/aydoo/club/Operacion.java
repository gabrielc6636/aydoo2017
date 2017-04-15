package ar.edu.untref.aydoo.club;

public class Operacion {

    private double importe;
    private double importeAhorrado;
    private Beneficio beneficio;
    private Mes mes;
    
    public Operacion(Beneficio beneficio, int importeOriginal,Mes mes) {
        this.beneficio = beneficio;
        this.importe = ( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0;
        this.importeAhorrado = importeOriginal-(( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0);
        this.mes = mes;
    }
    
    public double obtenerImporte(){
        return this.importe;
    }

    public double obtenerImporteAhorrado(){
        return this.importeAhorrado;
    }

    public Mes obtenerMes(){
        return this.mes;
    }
    
}