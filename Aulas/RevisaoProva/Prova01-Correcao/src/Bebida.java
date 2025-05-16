public class Bebida extends Produto {

    private double ml;

    public Bebida(String descricao, double preco, double ml) {
        super(descricao, preco);
        if (ml < 0) throw new IllegalArgumentException("MLs não podem ser negativas. ");
        this.ml = ml;
    }

    public Bebida(String descricao, double preco) {
        this(descricao, preco, 300);
    }

    public double getMl() {
        return ml;
    }

    public String toString(){
        return String.format("[Bebida] %s - %.2f", super.toString(), ml);
    }

}
