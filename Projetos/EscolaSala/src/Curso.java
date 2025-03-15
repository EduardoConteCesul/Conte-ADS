public class Curso {
    public String codigo;
    public String nome;
    public int cargaHoraria;

    // Construtor padrão
    public Curso(){
        this.codigo = "000";
        this.nome = "Curso Padrão";
        this.cargaHoraria = 0;
    }

    // Construtor parametrizado
    public Curso(String codigo, String nome, int cargaHoraria){
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters e setters
    public String getCodigo(){return codigo;}
    public String getNome(){return nome;}
    public int getCargaHoraria(){return cargaHoraria;}

    public void setCodigo(String codigo){this.codigo = codigo;}
    public void setNome(String nome){this.nome = nome;}
    public void setCargaHoraria(int carga){this.cargaHoraria = carga;}

    // ExibirInfo
    public void exibirInfo(){
        System.out.println("Codigo: " + codigo + " | Curso: " + nome +
                " | Carga horária: " + cargaHoraria);
    }
}
