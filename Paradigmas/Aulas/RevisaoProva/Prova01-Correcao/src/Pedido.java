import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pedido {
    private int id;
    private int mesa;
    private List<Produto> itens = new ArrayList<>();
    private boolean finalizado = false;

    public Pedido(int id, int mesa){
        if (mesa <= 0)throw new IllegalArgumentException("Mesa deve ser positiva");
        this.id = id;
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public int getMesa() {
        return mesa;
    }

    public List<Produto> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void adicionarItem(String nome, double preco, int kcal){

    }
}
