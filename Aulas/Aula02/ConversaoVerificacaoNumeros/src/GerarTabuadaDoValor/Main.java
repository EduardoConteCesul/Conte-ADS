package GerarTabuadaDoValor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = scanner.nextInt();

        for (int i = 0; i < 11; i++){
            int valorMultiplicado = num * i;
            System.out.println(num + "x" + i + " = " + valorMultiplicado);
        }

        scanner.close();
    }
}
