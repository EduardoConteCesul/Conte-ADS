package VerificarNumeroPrimo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        double num = scanner.nextDouble();

        boolean isPrimo = true;

        if (num <= 1){
            System.out.println("Não é primo!");
        }

        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                isPrimo = false;
                System.out.println("Não é primo!");
                break;
            }
        }
        if (isPrimo){
            System.out.println("É primo!");
        }
    }

    /*

    Para saber se um numero é primo é preciso pegar a raiz quadrada e verificar de 2 até o valor
    da raiz quadrada se o resto da divisão do valor passado pelo valor do for é 0, se for é primo.

    */
}
