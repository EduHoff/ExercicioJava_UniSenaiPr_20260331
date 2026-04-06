package entities.ex3;

import java.util.ArrayList;

public class Aluno {

    private String nome;
    private int matricula;

    private ArrayList<Disciplina> disciplinas = new ArrayList<>();;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void adicionarDisciplina(Disciplina d) {
    
        if(disciplinas.size() >= 4){
            throw new IndexOutOfBoundsException("Limite de 4 disciplinas atingido para o aluno " + nome);
        }

        disciplinas.add(d);
    }

    public void adicionarNotaEmDisciplina(String nomeDisciplina, double nota) {

        for (Disciplina d : disciplinas) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                d.adicionarNota(nota);
                return;
            }
        }
        
        throw new IllegalArgumentException("Disciplina '" + nomeDisciplina + "' não encontrada para este aluno.");
    }

    @Override
    public String toString() { 
        String resumoDisciplinas = disciplinas.stream()
                .map(d -> d.getNome() + ": " + (d.estaAprovado() ? "Aprovado" : "Reprovado"))
                .toList()
                .toString();

        return String.format("%d | Nome: %s | %s", 
                matricula, 
                nome, 
                resumoDisciplinas);
    }

    public String gerarRelatorioDetalhado() {
    String detalhesDisciplinas = disciplinas.stream()
            .map(d -> String.format("%s%s, media=%.2f]", 
                    d.getNome(), 
                    d.getNotas().toString(),
                    d.calcularMedia()))
            .collect(java.util.stream.Collectors.joining(", "));

    return String.format("%d | %s | %s", 
            matricula, 
            nome, 
            detalhesDisciplinas);
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }
}
