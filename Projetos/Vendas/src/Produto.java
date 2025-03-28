public abstract class Produto {
    private String nome;
    private double preco;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0){
            this.preco = preco;
        }else {
            System.out.println("Preco invalido.");
        }
    }


    public void exibirInfo() {
        System.out.println("Livro: " + getNome() + "| Preço: " + getPreco());
    }

    public abstract double calcularFrete();
}
