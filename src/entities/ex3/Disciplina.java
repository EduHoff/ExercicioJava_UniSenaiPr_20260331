package entities.ex3;

import java.util.ArrayList;

public class Disciplina {

    private String nome;
    private ArrayList<Double> notas = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void adicionarNota(double nota){
        notas.add(nota);
    }

    public double calcularMedia() {
     
       return notas.stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
    }

    public boolean estaAprovado(){
        return calcularMedia() > 7;
    }

    public String getNome() {
        return nome;
    }
}
