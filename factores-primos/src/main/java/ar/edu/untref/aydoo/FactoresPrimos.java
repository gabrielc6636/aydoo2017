package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

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


    public static void main(String[]args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero: ");

        int vIntNumero=Integer.parseInt(br.readLine());

        FactoresPrimos factoresPrimos=new FactoresPrimos();

        System.out.println("Los factores primos son:");
        List<Integer> lstFactores =factoresPrimos.CalcularFactores(vIntNumero);

        for (Integer factor : lstFactores) {
            System.out.print(factor + " ");
        }

    }

}
