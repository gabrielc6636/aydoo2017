package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Operacion {

    private double importe;
    private double importeAhorrado;
    private Beneficio beneficio;
    private Mes mes;
    private List<Producto> productos = new ArrayList<Producto>();
    
    public Operacion(Beneficio beneficio, List<Producto>,Mes mes) {
        this.beneficio = beneficio;

        double importeOriginal = obtenerImporteInicial(beneficio);

        this.importe = ( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0;
        this.importeAhorrado = importeOriginal-(( (100-beneficio.obtenerValorBeneficio() )*importeOriginal) / 100.0);
        this.mes = mes;
    }

    public double obtenerImporteInicial(Beneficio beneficio){
        double importeInicial = 0;
        
        return importeInicial;
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