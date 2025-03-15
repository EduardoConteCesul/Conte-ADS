public class Main {
    public static void main(String[] args) {

        Aluno aluno =  new Aluno("Eduardo", "12345");
        Aluno aluno2 =  new Aluno("Vito", "54321");

        Curso curso = new Curso("0000", "ADS", 180);
        Curso curso2 = new Curso("1111", "Direito", 300);

        Matricula matricula = new Matricula(aluno, curso);
        matricula.setNota(8);
        Matricula matricula2 = new Matricula(aluno2, curso);
        matricula2.setNota(4);

        Escola escola = new Escola();

        escola.cadastrarAluno(aluno);
        escola.cadastrarAluno(aluno2);

        escola.cadastrarCurso(curso);
        escola.cadastrarCurso(curso2);

        escola.matricularAluno(matricula);
        escola.matricularAluno(matricula2);

        escola.listarAlunosPorCurso(curso);

        escola.removerMatriculaDoAluno("12345", "0000");

        escola.listarAlunosPorCurso(curso);

        escola.calcularMediaNotasPorCurso(curso);
        escola.calcularMediaNotasPorCurso(curso2);
    }
}