public class Comida extends Produto{
    private int calorias;

    public Comida(String descricao, double preco, int calorias) {
        super(descricao, preco);
        if (calorias < 0) throw new IllegalArgumentException("Calorias não podem ser negativas. ");
        this.calorias = calorias;
    }

    public Comida(String descricao, double preco) {
        this(descricao, preco, 0);
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public String toString(){
        return String.format("[Comida] %s - %d kcal", super.toString(), calorias);
    }
}
