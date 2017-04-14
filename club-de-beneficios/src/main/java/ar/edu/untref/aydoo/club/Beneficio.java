package ar.edu.untref.aydoo.club;

public class Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public Beneficio(Tarjeta tarjeta, int valor) {
        this.tarjeta = tarjeta;
        this.valor = valor;
    }
    
    public Tarjeta obtenerTarjeta(){
        return this.tarjeta;
    }

    public int obtenerValorBeneficio() {

        return this.valor;
    }

}
