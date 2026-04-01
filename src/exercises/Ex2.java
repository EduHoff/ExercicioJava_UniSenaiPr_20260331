package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.ex2.Banco;
import utils.ConsoleUtils;

/* 
Você precisa criar um programa em Java para representar contas bancárias de
forma simples, mas desta vez o sistema deve ser capaz de gerenciar múltiplas
contas simultaneamente, armazenando-as em um ArrayList. Cada conta ainda
precisa conter informações básicas, como nome do titular, número da conta e
saldo atual. Além de criar essas contas, o programa deve permitir operações típicas
de um banco, como realizar depósitos e saques, e exibir dados para conferência.
Para isso, você deve implementar um método que cadastre novas contas
bancárias, inserindo-as no ArrayList. Em seguida, outro método deve consultar
uma conta específica com base em algum identificador (por exemplo, o número da
conta), retornando mensagens apropriadas caso essa conta não exista. Na hora de
depositar ou sacar, o sistema deve localizar a conta no ArrayList e efetuar a
operação, garantindo que valores inválidos ou saldo insuficiente sejam tratados
corretamente. Por fim, para acompanhar o estado atual do sistema, você pode criar
uma função que liste todas as contas armazenadas, exibindo de forma clara os
dados de cada uma (titular, número e saldo).
*/

public class Ex2 implements Exercise {

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Estudo de caso 2 ---\n");

        Banco banco = new Banco();

        while (true) {
            try{

                System.out.print("""
                ================================================
                                    BANCO
                ================================================
                1 - Cadastrar
                2 - Depositar
                3 - Sacar
                4 - Consultar
                5 - Listar
                0 - Sair
                ================================================
                """);

                System.out.print("||");
                int opcao  = sc.nextInt();
                sc.nextLine();

                if (opcao  == 0) {
                    ConsoleUtils.clear();
                    return;
                }


                switch (opcao) {
                    case 1 -> {
                        ConsoleUtils.clear();
                        System.out.print("Nome do titular: ");
                        String nome = sc.nextLine();
                        
                        System.out.print("Saldo inicial: ");
                        double saldo = sc.nextDouble();
                        sc.nextLine();

                        int num = banco.cadastrarCliente(nome, saldo);
                        System.out.println("Sucesso! Conta criada com número: " + num);
                    }
                    case 2 -> {
                        ConsoleUtils.clear();
                        System.out.print("Número da conta: ");
                        int num = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Valor do depósito: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        banco.depositarConta(num, valor);
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    case 3 -> {
                        ConsoleUtils.clear();
                        System.out.print("Número da conta: ");
                        int num = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Valor do saque: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        banco.sacarConta(num, valor);
                        System.out.println("Saque realizado com sucesso!");
                    }
                    case 4 -> {
                        ConsoleUtils.clear();
                        System.out.print("Número da conta para consulta: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.println("\nDados da Conta:");
                        System.out.println(banco.consultarConta(num));
                    }
                    case 5 -> {
                        ConsoleUtils.clear();
                        banco.listarContas();
                    }
                    default -> {
                        ConsoleUtils.clear();
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                }

            
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            } 
        }
    }
}