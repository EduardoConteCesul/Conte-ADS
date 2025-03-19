public class Main {
    public static void main(String[] args) {

        Aluno aluno1 =  new Aluno("Eduardo", "12345");
        Aluno aluno2 =  new Aluno("Vito", "54321");

        Curso curso1 = new Curso("0000", "ADS", 180);
        Curso curso2 = new Curso("1111", "Direito", 440);
        Curso curso3 = new Curso("2222", "ADM", 260);

        Matricula matricula1 = new Matricula(aluno1, curso1);
        matricula1.setNota(4);

        Matricula matricula2 = new Matricula(aluno2, curso1);
        matricula2.setNota(4);

        Matricula matricula3 = new Matricula(aluno1, curso2);
        matricula3.setNota(4);

        Matricula matricula4 = new Matricula(aluno2, curso2);
        matricula4.setNota(4);

        Matricula matricula5 = new Matricula(aluno1, curso3);
        matricula5.setNota(4);

        Matricula matricula6 = new Matricula(aluno2, curso3);
        matricula6.setNota(8);

        Escola escola = new Escola();

        escola.cadastrarAluno(aluno1);
        escola.cadastrarAluno(aluno2);

        escola.cadastrarCurso(curso1);
        escola.cadastrarCurso(curso2);
        escola.cadastrarCurso(curso3);

        escola.matricularAluno(matricula1);
        escola.matricularAluno(matricula2);
        escola.matricularAluno(matricula3);
        escola.matricularAluno(matricula4);
        escola.matricularAluno(matricula5);
        escola.matricularAluno(matricula6);
        escola.atribuirNota(matricula1, 8);
        System.out.println("--------------------");

        System.out.println(matricula1.nota);

        escola.listarCursosComMediaAcima(6);
        escola.rankearAlunos();
    }
}