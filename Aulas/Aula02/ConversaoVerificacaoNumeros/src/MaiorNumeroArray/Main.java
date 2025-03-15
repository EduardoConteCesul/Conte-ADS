package MaiorNumeroArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] numeros = scanner.nextLine().split(" ");

        int[] listaNumeros = {1, 30, 29, 4, 45, 2, 90};
        int maiorValor = 0;

        for (int listaNumero : listaNumeros) {

            if (maiorValor < listaNumero) {

                maiorValor = listaNumero;
            }
        }

        System.out.println(maiorValor);

    }
}
