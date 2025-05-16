public abstract class Produto implements Calculavel {
    private String descricao;
    private double preco;

    public Produto(String descricao, double preco) {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("Descrição inválida");
        if (preco < 0) throw new IllegalArgumentException("Preço invalido");
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(String descricao) {
        this(descricao, 0.0);
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public double calcularPreco(){
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f", descricao, preco);
    }
}
