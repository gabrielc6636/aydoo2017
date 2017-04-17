package ar.edu.untref.aydoo.club;

/**
 * Created by gabriel on 16/04/17.
 */
public class BeneficioExtendido extends Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public BeneficioExtendido(Tarjeta tarjeta, int valor) throws BeneficioException {
        super(tarjeta,valor);
    }

    public double obtenerValorBeneficio(double importeOriginal) {
        return importeOriginal-(((100-this.valor)*importeOriginal) / 100.0);
    }
}
