import java.util.HashMap;
import java.util.Map;

public class GerenciadoPedidos {

   private Map<Integer, Pedido> pedidos = new HashMap<>();
   private int proxId = 0;

    public void criarPedidoMesa(int mesa){
        Pedido pedido = new PedidoMesa(proxId++, mesa);
        pedidos.put(pedido.getId(), pedido);
        System.out.println("Pedido de mesa criado com ID: ", pedido.getId());
    }

    public void criarPedidoDelivery(int mesa){
        Pedido pedido = new PedidoDelivery(proxId++, mesa);
        pedidos.put(pedido.getId(), pedido);
        System.out.println("Pedido delivery criado com ID: ", pedido.getId());
    }

    public void adicionarItem(int id, String nome, double preco, int kcal){

        if (pedidos.containsKey(id)){
            Pedido pedido = pedidos.get(id);
            pedido.adicionarItem(nome, preco, kcal);
            System.out.println("Comida adicionada ao pedido. ");
        }else {
            System.out.println("Pedido não existe. ");
        }
    }
    public void adicionarBebida(int id, String nome, double preco, double ml){

        if (pedidos.containsKey(id)){
            Pedido pedido = pedidos.get(id);
            pedido.adicionarItem(nome, preco, kcal);
            System.out.println("Bebida adicionada ao pedido. ");
        }else {
            System.out.println("Pedido não existe. ");
        }
    }

    public void finalizarPedido(int id){
        if (pedidos.containsKey(id)){
            Pedido pedido = pedidos.get(id);
            pedido.finalizarPedido();
            System.out.println("Pedido " + id + " foi finalizado");
        }else {
            System.out.println("Pedido não existe. ");
        }
    }

    public void exibirRelatorioDiario(){

    }
}
