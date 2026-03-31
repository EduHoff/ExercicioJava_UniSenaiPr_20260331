package exercises;

import java.util.Scanner;

import entities.ex2.Banco;

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

        banco.cadastrarCliente("Eduardo", 10000.0);
        banco.cadastrarCliente("Flávio", 1000000.0);
        banco.cadastrarCliente("Madu", 300000.0);
        
        banco.listarContas();

        System.out.println("\n--- Testando Operações ---");
        banco.depositarConta(1001, 500.0);

        banco.sacarConta(1003, 50.0); 
        banco.sacarConta(1001, 20000.0);

        banco.consultarConta(1002);
        banco.consultarConta(9999);


        System.out.println("\n--- Estado Final do Banco ---");
        banco.listarContas();
    }
}