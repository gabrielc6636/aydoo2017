package ar.edu.untref.aydoo;
/**
 * Created by gabriel on 22/04/17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FactoresPrimosIO {

    private FileWriter archivoSalida;
    private String ruta;
    private Scanner scanner;

    public FactoresPrimosIO(
            final String rutaArchivo)
            throws IOException {
        this.ruta = rutaArchivo;
    }

    public void escribirFactorizacion(
            final String factorizacion)
            throws IOException {
        archivoSalida = new FileWriter(this.ruta);
        archivoSalida.write(factorizacion);
        archivoSalida.close();
    }

    public String leerFactorizacion()
            throws FileNotFoundException {

        String factorizacion = "";
        File archivoSalidaParaLeer = new File(this.ruta);
        scanner = new Scanner(archivoSalidaParaLeer);

        while (scanner.hasNextLine()) {
            factorizacion = factorizacion + scanner.nextLine() + "\n";
        }
        scanner.close();
        return factorizacion;
    }

}
