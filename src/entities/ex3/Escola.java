package entities.ex3;

import java.util.ArrayList;

public class Escola {

    private ArrayList<Aluno> lista_alunos= new ArrayList<>();
    private static int contador_geral = 1001;

    public void cadastrarAluno(String nome){
        Aluno novo_aluno = new Aluno(nome, contador_geral);
        contador_geral += 1;
        lista_alunos.add(novo_aluno);
    }

    public void adicionarDisciplinaAoAluno(int matricula, String nomeDisciplina) {
        for (Aluno a : lista_alunos) {
            if (a.getMatricula() == matricula) {
                a.adicionarDisciplina(new Disciplina(nomeDisciplina));
                return;
            }
        }

        throw new IllegalArgumentException("Erro: Aluno com matrícula " + matricula + " não encontrado.");
    }

    public void adicionarNotaAoAluno(int matricula, String nomeDisciplina, double nota) {
        for (Aluno a : lista_alunos) {
            if (a.getMatricula() == matricula) {
                a.adicionarNotaEmDisciplina(nomeDisciplina, nota);
                return;
            }
        }
        
        throw new IllegalArgumentException("Erro: Matrícula " + matricula + " não encontrada.");
    }

    public void localizarAluno(int matricula){

        System.out.println("\n--- BOLETIM DETALHADO ---");

        for (Aluno a : lista_alunos) {
            if(a.getMatricula() == matricula){
                System.out.println(a.gerarRelatorioDetalhado());
                return;
            }
        }

        System.out.println("Nenhum aluno cadastrado!");
    }

    public void listagemGeral(){

        System.out.println("\n--- RELATÓRIO GERAL DE NOTAS ---");

        if(lista_alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        for (Aluno a : lista_alunos) {
            System.out.println(a.toString());
        }
    }

}
