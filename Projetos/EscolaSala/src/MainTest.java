public class MainTest {
    public static void main(String[] args) {
        Aluno aluno1 =  new Aluno("Eduardo", "12345");
        Curso curso1 = new Curso("0000", "ADS", 180);
        Matricula matricula1 = new Matricula(aluno1, curso1);

        Escola escola = new Escola();

        escola.cadastrarAluno(aluno1);
    }
}
