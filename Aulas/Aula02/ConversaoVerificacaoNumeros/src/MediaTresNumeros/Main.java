package MediaTresNumeros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        double num1 = sc.nextDouble();

        System.out.println("Digite um valor: ");
        double num2 = sc.nextDouble();

        System.out.println("Digite um valor: ");
        double num3 = sc.nextDouble();

        double media = (num1 + num2 + num3) / 3;
        System.out.println("A média é: " + media);
    }
}
