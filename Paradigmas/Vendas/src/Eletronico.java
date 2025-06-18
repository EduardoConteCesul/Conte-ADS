public class Eletronico extends Produto implements Promocional{

    private String marca;

    public Eletronico(String nome, double preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public Eletronico(String nome, String marca){
        super(nome);
        this.marca = marca;
    }

    @Override
    public double calcularFrete(){
        return 20 + (0.05 * getPreco());
    }

    @Override
    public boolean aplicarDesconto(double porcentagem){

        if (porcentagem <= 0.1){
            setPreco((1 - porcentagem) * getPreco());
            System.out.println("Desconto de: " + (porcentagem * 100) + "% aplicado.");
            return true;
        }

        System.out.println("O valor de desconto excedeo máximo.");
        return false;
    }

    @Override
    public void exibirInfo(){
        System.out.println("Eletronico: " + getNome());
    }
}
