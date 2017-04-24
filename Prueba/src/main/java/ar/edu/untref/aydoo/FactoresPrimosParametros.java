package ar.edu.untref.aydoo;
/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosParametros {

    private String numeroAFactorizar = "";
    private String formatoDeSalida = "";
    private String formatoDeOrden = "";
    private String nombreDeArchivo = "";

    public FactoresPrimosParametros(String[] args) {

        String parametroAEvaluar;

        if (args.length > 0) {
            this.numeroAFactorizar = args[0];
            for (int i = 1; i < args.length; i++){

                if(!args[i].isEmpty()) {
                    parametroAEvaluar = args[i].substring(0, 3).toUpperCase();

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
                    }
                }
            }
        }
    }

    public Integer obtenerNumeroAFactorizar() {
        Integer numeroAFactorizar = 0;
        if (this.numeroAFactorizar != "") {
            numeroAFactorizar = Integer.parseInt(this.numeroAFactorizar);
        }
        return numeroAFactorizar;

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