import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static  final GerenciadoPedidos gerenciador = new GerenciadoPedidos();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== RESTAURANTE ===");
            System.out.println("1 – Novo pedido");
            System.out.println("2 – Adicionar comida");
            System.out.println("3 – Adicionar bebida");
            System.out.println("4 – Finalizar pedido");
            System.out.println("5 – Relatório Diário");
            System.out.println("0 – Sair");
            System.out.print("Opção: ");
            int op = Integer.parseInt(sc.nextLine());
            if (op == 0) break;

            switch (op) {
                case 1:
                    System.out.print("Mesa (número): ");
                    int mesa = Integer.parseInt(sc.nextLine());
                    System.out.println("Tipo (1 = Mesa, 2 = Delivery)");
                    int tipo = Integer.parseInt(sc.nextLine());

                    if (tipo == 2) gerenciador.criarPedidoDelivery(mesa);
                    else gerenciador.criarPedidoMesa(mesa);

                case 2:
                    System.out.print("ID do pedido: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.println("Nome da comida: ");
                    String nomeComida = sc.nextLine();

                    System.out.println("Preço da comida: ");
                    double precoComida = Double.parseDouble(sc.nextLine());

                    System.out.println("Caloria da comida: ");
                    int kcalComida = Integer.parseInt(sc.nextLine());

                    gerenciador.adicionarItem(id, nomeComida, precoComida, kcalComida);

                case 3:

                    System.out.print("ID do pedido: ");
                    int idBebida = Integer.parseInt(sc.nextLine());

                    System.out.println("Nome da comida: ");
                    String nomeBebida = sc.nextLine();

                    System.out.println("Preço da comida: ");
                    double precoBebida = Double.parseDouble(sc.nextLine());

                    System.out.println("Caloria da comida: ");
                    int kcalBebida = Integer.parseInt(sc.nextLine());

                    gerenciador.adicionarBebida(idBebida, nomeBebida, precoBebida, kcalBebida);
                case 4:
                    System.out.print("ID do pedido: ");
                    int idPedidoFinalizar = Integer.parseInt(sc.nextLine());
                    gerenciador.finalizarPedido(idPedidoFinalizar);

                case 5:
                    gerenciador.exibirRelatorioDiario();

                default: System.out.println("Opção inválida");
            }
        }
        sc.close();
    }
}