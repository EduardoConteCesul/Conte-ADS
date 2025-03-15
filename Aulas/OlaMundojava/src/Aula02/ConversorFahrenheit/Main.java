package Aula02.ConversorFahrenheit;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite em celsius: ");
        double tempC = scanner.nextDouble();

        double tempF = (tempC * 9 / 5) + 32;

        System.out.println(tempC + "ºC em farenheint é: " + tempF + "ºF");
    }
}
