package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoresPrimos {

    int vIntNumero;

    public FactoresPrimos(){
        vIntNumero=2; //divisor
    }

    public void factores(int pIntNumeroFactor){

        vIntNumero = pIntNumeroFactor;

        for(int i=2;i<pIntNumeroFactor;i++){

            while(vIntNumero%i==0){

                vIntNumero=vIntNumero/i;

                System.out.print(i+"  ");


                if(vIntNumero==1){
                    System.exit(0);
                }
            }
        }

    }


    public static void main(String[]args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero: ");

        int vIntNumero=Integer.parseInt(br.readLine());

        FactoresPrimos factoresPrimos=new FactoresPrimos();

        System.out.println("Los factores primos son:");
        factoresPrimos.factores(vIntNumero);

    }

}
