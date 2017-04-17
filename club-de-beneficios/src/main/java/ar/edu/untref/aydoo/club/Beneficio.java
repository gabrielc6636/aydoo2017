package ar.edu.untref.aydoo.club;

public class Beneficio {

    private Tarjeta tarjeta;
    private int valor;

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

    public int obtenerValorBeneficio() {
        return this.valor;
    }

}
