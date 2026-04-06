package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.ex1.Estoque;
import entities.ex1.Produto;
import utils.ConsoleUtils;

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

        Estoque estoque = new Estoque();

        while (true) {
            try {
                System.out.println("""
                ================================================
                            GERENCIADOR DE ESTOQUE
                ================================================
                1 - Adicionar produto
                2 - Remover produto
                3 - Vender produto
                4 - Atualizar preço
                5 - Gerar relatório
                0 - Sair
                ================================================
                """);

                System.out.print("||");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 0) {
                    return;
                }

                switch (opcao) {
                    case 1 -> {
                        ConsoleUtils.clear();
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();
                        
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        
                        System.out.print("Quantidade inicial: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();

                        Produto p = new Produto(nome, preco, qtd);
                        estoque.adicionarProduto(p);
                        System.out.println("Produto adicionado com sucesso!");
                    }
                    case 2 -> {
                        ConsoleUtils.clear();
                        System.out.print("\nDigite o código do produto para remover: ");
                        int index = sc.nextInt();
                        sc.nextLine();

                        estoque.removerProduto(index);
                        System.out.println("Produto removido!");
                    }
                    case 3 -> {
                        ConsoleUtils.clear();
                        System.out.print("\nDigite o código do produto: ");
                        int index = sc.nextInt();
                        
                        System.out.print("Quantidade da venda: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();

                        estoque.venderProduto(index, qtd);
                        System.out.println("Venda realizada!");
                    }
                    case 4 -> {
                        ConsoleUtils.clear();
                        System.out.print("\nDigite o código do produto para atualizar preço: ");
                        int index = sc.nextInt();
                        
                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();
                        sc.nextLine();

                        estoque.atualizarPreco(index, novoPreco);
                        System.out.println("Preço atualizado!");
                    }
                    case 5 -> {
                        ConsoleUtils.clear();
                        estoque.gerarRelatorio();
                    }
                    default -> {
                        ConsoleUtils.clear();
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                }

            } catch (InputMismatchException e) {
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            } catch (Exception e) {
                ConsoleUtils.clear();
                e.printStackTrace(); 
            }
        }
    }
}