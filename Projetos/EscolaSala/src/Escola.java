import java.util.*;

// Escola vai gerenciar o cadastro de alunos,
// cursos e matrículas
public class Escola {
    public ArrayList<Aluno> alunos;
    public ArrayList<Curso> cursos;
    public ArrayList<Matricula> matriculas;

    public Escola(){
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno){
        for(Aluno a : alunos){
            if(a.matricula.equals(aluno.matricula)){
                System.out.println("Já tem aluno com esta matrícula");
                return;
            }
        }
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso");
    }

    public void cadastrarCurso(Curso curso){
        for(Curso c : cursos){
            if(c.codigo.equals(curso.codigo)){
                System.out.println("Já tem curso com esta codigo");
                return;
            }
        }
        cursos.add(curso);
        System.out.println("Curso cadastrado com sucesso");
    }

    public void matricularAluno(Matricula matricula){
        for(Matricula m : matriculas){
            if(m.aluno.matricula.equals(matricula.aluno.matricula) &&
            m.curso.codigo.equals(matricula.curso.codigo)) {
                System.out.println("Aluno ja esta matriculado neste curso.");
                return;
            }
        }

        matriculas.add(matricula);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    // Remover a matricula de um aluno.matricula em um curso.codigo
    // Regra: Se a matrícula não for encontrada, printe erro
    public void removerMatriculaDoAluno(String matriculaAluno, String codigoCurso){

        for (Matricula c : matriculas){
            if (c.aluno.matricula.equals(matriculaAluno) && c.curso.codigo.equals(codigoCurso)){
                matriculas.remove(c);
                System.out.print("Matricula removida com sucesso! \n");
                return;
            }
            System.out.println("Error");
        }
    }




    // Lista todos os alunos matriculados em um curso especifico
    public void listarAlunosPorCurso(Curso curso){

        for (Matricula a : matriculas){
            if (a.curso.equals(curso)){
                System.out.printf(a.aluno.nome + "\n");
            }
        }
    }

    //Calcula a media de notas dos alunos em um curso
    //Regra: Considere apenas matriculas com nota valida (>=0)
    public void calcularMediaNotasPorCurso(Curso curso){

        double somaNotas = 0;
        int quantidadeAlunos = 0;

        for (Matricula m : matriculas){
            if (m.curso.equals(curso)){
                somaNotas += m.nota;
            }
            quantidadeAlunos++;
        }


        System.out.println("A média dos alunos do curso " + curso.nome + " é: " + (somaNotas / quantidadeAlunos));

    }

    //Atribui uma nota a uma matricula especifica
    //Regra: A nota deve ser entre 0 e 10; caso contrario, msg de erro
    public void atribuirNota(Matricula matricula, double nota){
        matricula.setNota(nota);
    }

    //Busca alunos pelo nome (case insensitive)
    public void buscarAlunoPorNome(String nome){
        for (Aluno a : alunos){
            if (a.nome.equals(nome)){
                System.out.printf("Aluno: " + a.nome + " Matricula: " + a.matricula);
                return;
            }
        }
        System.out.printf("Aluno não matriculado");
    }

    //Lista todos os cursos com media de notas
    // acima de um determinado valor (parametro)
    public void listarCursosComMediaAcima(double notaMediaDeCorte){

        List<String> cursosComMediaMaiorQueRecebido = new ArrayList<>();

        for (Curso c: cursos){
            double somaNotas = 0;
            int quantidadeCursos = 0;

            for (Matricula m : matriculas){
                if (m.curso.equals(c)){
                   somaNotas += m.nota;
                    quantidadeCursos++;
                }
            }

            if (somaNotas / quantidadeCursos > notaMediaDeCorte){
                cursosComMediaMaiorQueRecebido.add(c.nome);
            }
        }

        System.out.println(cursosComMediaMaiorQueRecebido);
    }

    // EXIBE um ranking de alunos baseado na media das notas de todas as matriculas
    // Ordene a lista de forma decrescente pela media
    public void rankearAlunos(){

        List<MediaAluno> mediaAlunos = new ArrayList<>();


        for (Aluno a : alunos){

            MediaAluno mediaAluno = new MediaAluno();

            double somaNotas = 0;
            int quantidadeMatriculasDoAluno = 0;

            for (Matricula m : matriculas){
                if (a.equals(m.aluno)){
                    somaNotas += m.nota;
                    quantidadeMatriculasDoAluno++;
                }
            }

            mediaAluno.setAluno(a);
            mediaAluno.setMediaAluno( somaNotas / quantidadeMatriculasDoAluno);

            mediaAlunos.add(mediaAluno);
        }

        mediaAlunos.sort(Collections.reverseOrder());

    }


    // Exibe um relatorio geral com as info do sistema
    // (mostre todas as info nos prints)
    public void gerarRelatorioGeral(){

    }
}
