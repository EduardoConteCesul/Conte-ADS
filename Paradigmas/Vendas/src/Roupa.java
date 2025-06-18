public class Roupa extends Produto implements Promocional{

    private String tamanho;

    public Roupa(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

    @Override
    public double calcularFrete(){
        return 10.0;
    }

    @Override
    public boolean aplicarDesconto(double porcentagem){
        if (porcentagem > 0.3){
            System.out.printf("Desconto excedeu o máximo");
            return false;
        }
        setPreco(getPreco() - (porcentagem * getPreco()));
        System.out.println("Desconto de: "+ (porcentagem * 100)+"% aplicado.");

        return true;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + getNome() + "| Preço: " + getPreco() + "| Tamanho: " + this.tamanho);
    }
}
