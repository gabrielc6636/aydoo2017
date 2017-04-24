package ar.edu.untref.aydoo;
/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosParametros {

    private String numeroAFactorizar = "";
    private String formatoDeSalida = "";
    private String formatoDeOrden = "";
    private String nombreDeArchivo = "";

    private final Integer numeroTres = 3;

    public FactoresPrimosParametros(final String[] args) {

        String parametroAEvaluar;

        if (args.length > 0) {
            this.numeroAFactorizar = args[0];
            for (int i = 1; i < args.length; i++) {

                if (!args[i].isEmpty()) {
                    parametroAEvaluar = args[i]
                            .substring(0, numeroTres)
                            .toUpperCase();

                    switch (parametroAEvaluar) {
                        case "--F":
                            this.formatoDeSalida = args[i];
                            break;
                        case "--S":
                            this.formatoDeOrden = args[i];
                            break;
                        case "--O":
                            this.nombreDeArchivo = args[i];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public Integer obtenerNumeroAFactorizar() {
        Integer numeroARetornar = 0;
        if (this.numeroAFactorizar != "") {
            numeroARetornar = Integer.parseInt(this.numeroAFactorizar);
        }
        return numeroARetornar;

    }

    public String obtenerFormatoDeSalida() {
        return formatoDeSalida;
    }

    public String obtenerFormatoDeOrden() {
        return formatoDeOrden;
    }

    public String obtenerNombreDeArchivo() {
        return nombreDeArchivo;
    }

}
