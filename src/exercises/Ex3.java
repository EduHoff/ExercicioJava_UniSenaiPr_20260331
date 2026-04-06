package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.ex3.Escola;
import utils.ConsoleUtils;

public class Ex3 implements Exercise {

/*
    Você está encarregado de desenvolver um programa em Java para gerenciar os
alunos de uma pequena escola. Cada aluno deve possuir, no mínimo, nome
completo e número de matrícula (uma identificação), e o sistema armazenará um
conjunto de alunos em um ArrayList<Aluno>. Nesse contexto, será preciso criar
funcionalidades para cadastrar novos alunos, já que cada um pode cursar até
quatro disciplinas. Além disso, o programa deve permitir inserir diversas notas para
cada disciplina. Quando for necessário consultar as informações de um aluno
específico, será possível localizá-lo por meio do número de matrícula, obtendo
assim seus dados cadastrais e as notas de cada disciplina cursada.
Ao final do processo, haverá um recurso de listagem completa que exibirá todos os
alunos armazenados, o que facilitará a conferência geral e o acompanhamento do
desempenho. Como parte do encerramento de período letivo, o programa também
deve gerar um relatório final indicando se cada aluno está aprovado ou não. Para
isso, cada disciplina de um aluno terá sua média aritmética simples calculada com
base nas notas cadastradas, e o critério de aprovação será nota acima de sete.
Dessa forma, a aplicação deve informar, de maneira clara, quais alunos atingiram a
média necessária e quais precisam de recuperação ou retomada de estudos.
*/

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Estudo de caso 3 ---\n");
        
        Escola escola = new Escola();

        while (true) {
            try {
                System.out.println("""
                ================================================
                            SISTEMA DE GESTÃO ESCOLAR
                ================================================
                1 - Cadastrar Aluno
                2 - Adicionar Disciplina a um Aluno
                3 - Lançar Nota em Disciplina
                4 - Consultar Aluno (Detalhado)
                5 - Listagem Geral (Status de Aprovação)
                0 - Sair
                ================================================
                """);

                System.out.print("||");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 0) {
                    ConsoleUtils.clear();
                    System.out.println("Encerrando sistema escolar...");
                    return;
                }

                switch (opcao) {
                    case 1 -> {
                        ConsoleUtils.clear();
                        System.out.print("Nome completo do aluno: ");
                        String nome = sc.nextLine();
                        
                        escola.cadastrarAluno(nome);
                        System.out.println("Sucesso! Aluno cadastrado.");
                    }
                    case 2 -> {
                        ConsoleUtils.clear();
                        System.out.print("Digite a Matrícula do aluno: ");
                        int mat = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Nome da Disciplina: ");
                        String disc = sc.nextLine();

                        escola.adicionarDisciplinaAoAluno(mat, disc);
                        System.out.println("Disciplina vinculada ao aluno!");
                    }
                    case 3 -> {
                        ConsoleUtils.clear();
                        System.out.print("Digite a Matrícula: ");
                        int mat = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Nome da Disciplina: ");
                        String disc = sc.nextLine();
                        
                        System.out.print("Valor da Nota: ");
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        escola.adicionarNotaAoAluno(mat, disc, nota);
                        System.out.println("Nota lançada com sucesso!");
                    }
                    case 4 -> {
                        ConsoleUtils.clear();
                        System.out.print("Digite a Matrícula para consulta detalhada: ");
                        int mat = sc.nextInt();
                        sc.nextLine();
                        
                        escola.localizarAluno(mat);
                    }
                    case 5 -> {
                        ConsoleUtils.clear();
                        escola.listagemGeral();
                    }
                    default -> {
                        ConsoleUtils.clear();
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                }

            } catch (InputMismatchException e) {
                ConsoleUtils.clear();
                System.out.println("Erro: Digite apenas números válidos!\n");
                sc.nextLine();
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                ConsoleUtils.clear();
                System.out.println("AVISO: " + e.getMessage());
            } catch (Exception e) {
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }
    }
}
