package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimos {
    int vIntNumero;

    public FactoresPrimos(){
        vIntNumero=2; //divisor
    }


    public List<Integer> CalcularFactores(int pIntNumero){


        int vIntNumero = pIntNumero;

        int vIntNumeroFactor = 2;

        List<Integer> lstFactores = new LinkedList<Integer>();

        if(Integer.class.isInstance(vIntNumero)) {
            if(vIntNumero>1) {
                while(vIntNumero!=1)
                {
                    while(vIntNumero%vIntNumeroFactor==0)
                    {
                        vIntNumero /= vIntNumeroFactor;
                        lstFactores.add(vIntNumeroFactor);
                    }

                    vIntNumeroFactor++;
                }
            }
            else {
                System.out.println("El valor debe ser mayor a 1");
            }

        }

        return lstFactores;
    }

    public void DevolverFactoresPrimos(int pIntNumero, String formato){

        if(formato.equals("quiet")||formato.equals("pretty")) {

            List<Integer> lstFactores = CalcularFactores(pIntNumero);

            switch (formato) {
                case "pretty":
                    for (Integer factor : lstFactores) {
                        System.out.print(factor + " ");
                    }
                    break;
                case "quiet":
                    Collections.sort(lstFactores, Collections.reverseOrder());
                    for (Integer factor : lstFactores) {
                        System.out.println(factor + " ");
                    }
                    break;
                default:
                    break;
            }
        }
        else
        {
            System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
        }

    }

    public static void main(String[]args)throws IOException {

        String formatoPrimos = "";

        if(args.length>0) {
            formatoPrimos = args[0].replaceAll("--format=", "").trim().toLowerCase();
        }

        System.out.println("Formato: "+formatoPrimos);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero: ");

        int vIntNumero=Integer.parseInt(br.readLine());

        FactoresPrimos factoresPrimos=new FactoresPrimos();


        System.out.println("Los factores primos son:");
        factoresPrimos.DevolverFactoresPrimos(vIntNumero,formatoPrimos);

    }
}
