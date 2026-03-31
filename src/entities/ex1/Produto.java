package entities.ex1;

public class Produto {

    private String nome;
    private double preco;
    private int qtd_estoque;

    public Produto(String nome, double preco, int qtd_estoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
    }

    public Produto(){}

    @Override
    public String toString() {
        return nome + " | R$ " + preco + " (Qtd: " + qtd_estoque + ")";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
}
