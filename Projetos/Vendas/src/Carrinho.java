import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos = new ArrayList<>();

    public Carrinho(){

    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        System.out.println("Produto adicionado.");
    }

    public void removerProduto(Produto produto){
        if(produtos.remove(produto)){
            System.out.println("Produto removido com sucesso.");
        }else {
            System.out.println("Produto não encontrado.");
        }
    }

}
