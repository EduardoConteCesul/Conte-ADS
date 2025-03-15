public class Aluno {
    public String nome;
    public String matricula;

    // Construtor padrão
    public Aluno(){
        this.nome = "Nome padrão";
        this.matricula = "0000";
    }

    // Construtor com parametros obrigatorios
    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    // Getters
    public String getNome() { return nome;}
    public String getMatricula() { return matricula;}

    // Setters
    public void setNome(String nome){this.nome = nome;}
    public void setMatricula(String matricula){this.matricula = matricula;}

    public void exibirInfo(){
        System.out.println("Nome: " + nome +
                " | Matrícula: "+ matricula);
    }
}
