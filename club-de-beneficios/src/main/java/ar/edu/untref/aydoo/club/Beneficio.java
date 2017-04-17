package ar.edu.untref.aydoo.club;

public class Beneficio {

    protected Tarjeta tarjeta;
    protected int valor;

    public Beneficio(Tarjeta tarjeta, int valor) throws BeneficioException {
        this.tarjeta = tarjeta;
        if(valor>5) {
            this.valor = valor;
        }
        else{
            throw new BeneficioException();
        }
    }
    
    public Tarjeta obtenerTarjeta(){
        return this.tarjeta;
    }

    public double obtenerValorBeneficio(double importeOriginal) {
        return importeOriginal-(((100-this.valor)*importeOriginal) / 100.0);
    }

}
