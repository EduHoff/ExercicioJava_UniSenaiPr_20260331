package entities.ex1;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> estoque = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        if (!estoque.contains(p)) {
            estoque.add(p);
        }
    }

    public void removerProduto(Produto p) {
        estoque.remove(p);
    }

    public void removerProduto(int index) {
        validarIndice(index);
        estoque.remove(index);
    }

    public void venderProduto(int index, int qtd) {
        validarIndice(index);

        if (qtd <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        Produto produto = estoque.get(index);

        if (produto.getQtd_estoque() < qtd) {
            throw new IllegalStateException("Saldo insuficiente: " + produto.getNome() + " possui apenas " + produto.getQtd_estoque() + " unidades.");
        }

        produto.setQtd_estoque(produto.getQtd_estoque() - qtd);
    }

    public void atualizarPreco(int index, double preco) {
        validarIndice(index);

        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }

        estoque.get(index).setPreco(preco);
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= estoque.size()) {
            throw new IndexOutOfBoundsException("Erro: Código de produto " + index + " é inválido!");
        }
    }

    public void gerarRelatorio() {
        System.out.println("=== RELATÓRIO DE PRODUTOS ===");
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println("Cód: " + i + " | " + estoque.get(i).toString());
        }
    }
}