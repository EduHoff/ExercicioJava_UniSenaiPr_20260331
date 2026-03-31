package exercises;

import java.util.Scanner;

import entities.ex1.Estoque;
import entities.ex1.Produto;

/* 
Desenvolva um programa em Java para gerenciar os produtos de uma loja de
conveniência, utilizando um ArrayList como estrutura de dados. Cada produto deve
ter, no mínimo, nome, preço de venda e quantidade em estoque. Para facilitar o uso
pelos funcionários, o programa precisa permitir consultas rápidas a um produto
pelo seu código (equivalente à posição no ArrayList), exibindo as informações
essenciais: nome, preço e quantidade disponível.
Quando ocorre uma venda, o sistema deve localizar o produto no ArrayList e
verificar se há estoque suficiente para atender ao pedido. Em caso positivo, deve
descontar a quantidade vendida do estoque e atualizar as informações no ArrayList.
Se o estoque for insuficiente, é importante exibir um aviso informando que a venda
não pode ser concluída.
A gerência também precisa de um mecanismo para alterar o valor de venda de
qualquer produto, a fim de aplicar promoções ou ajustar preços. Isso implica
encontrar o produto no ArrayList e redefinir seu preço de acordo com as instruções
recebidas.
Por fim, o programa deve exibir relatórios que mostrem todos os produtos
armazenados no ArrayList, apresentando as informações-chave de cada item para
auxiliar em conferências e decisões de compra.
*/

public class Ex1 implements Exercise {

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Estudo de caso 1 ---\n");

    Estoque estoque = new Estoque();
    Produto p1 = new Produto("Steam Frame", 12000.00, 15);
    Produto p2 = new Produto("Container", 200000.00, 20);
    Produto p3 = new Produto("Lampada", 20.00, 100);
    estoque.adicionarProduto(p1);
    estoque.adicionarProduto(p2);
    estoque.adicionarProduto(p3);

    System.out.println("\n--- Realizando Vendas ---");
    estoque.venderProduto(2, 30); 
    estoque.venderProduto(1, 100); 
    estoque.venderProduto(99, 1);

    System.out.println("\n--- Aplicando Reajustes ---");
    estoque.atualizarPreco(0, 10500.00); 
    estoque.atualizarPreco(2, -5.00); 

    System.out.println("\n--- Situação Final do Estoque ---");
    estoque.gerarRelatorio();
    }
}