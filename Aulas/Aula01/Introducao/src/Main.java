public class Main {
    public static void main(String[] args) {
        variaveis();
        conversoes();
    }

    public static void variaveis(){
        System.out.println("------ Variaveis------");

        int integer = 10;
        double decimal = 10.5;
        char caractere = 'A';
        boolean logico = true;

        System.out.println("Inteiro: " + integer);
        System.out.println("Double" + decimal);
        System.out.println("Char" + caractere);
        System.out.println("boolean" + logico);
    }

    public static void conversoes(){
        int inteiro = 100;
        double decimal = 99.99;

        double conversaoImplicita = inteiro;
        System.out.println("Conversao implicita de int para double " + conversaoImplicita);

        int conversaoExplicita = (int) decimal;
        System.out.println("Conversao explicita de double para int " + conversaoExplicita);

        try{
            String numComTexto = "1s3";
            int numConvertido = Integer.parseInt(numComTexto);
        }catch (Exception e) {
            System.out.println("Erro na conversao");
        }
    }

    public static void demonstrarAtribuicoes(){
        System.out.println("----- Atribuições em Java -----");

        int a = 5;
        int b;

        b = a;

    }
}