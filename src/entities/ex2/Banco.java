package entities.ex2;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    List<ContaBancaria> lista_contas = new ArrayList<>();
    private static int contador_geral = 1001;

    private ContaBancaria buscarObjetoConta(int num_conta) {
        for (ContaBancaria c : lista_contas) {
            if (c.getNum_conta() == num_conta) {
                return c;
            }
        }
        return null;
    }

    public void cadastrarCliente(String titular, double saldo) {
        ContaBancaria conta = new ContaBancaria(titular, contador_geral, saldo);
        lista_contas.add(conta);
        System.out.println("Conta criada! Número: " + contador_geral);
        contador_geral++;
    }

    public void depositarConta(int num_conta, double valor) {
        ContaBancaria conta = buscarObjetoConta(num_conta);
        if (conta == null) {
            System.out.println("Erro: Número de conta " + num_conta + " não encontrado!");
            return;
        }
        System.out.println("=== DEPÓSITO CONTA ===");
        conta.depositar(valor);
    }

    public void sacarConta(int num_conta, double valor) {
        ContaBancaria conta = buscarObjetoConta(num_conta);
        if (conta == null) {
            System.out.println("Erro: Número de conta " + num_conta + " não encontrado!");
            return;
        }
        System.out.println("=== SAQUE CONTA ===");
        conta.sacar(valor);
    }

    public void consultarConta(int num_conta) {
        ContaBancaria conta = buscarObjetoConta(num_conta);
        if (conta == null) {
            System.out.println("Erro: Número de conta " + num_conta + " não encontrado!");
            return;
        }
        System.out.println("=== CONSULTA CONTA ===");
        System.out.println(conta);
    }

    public void listarContas() {
        System.out.println("=== LISTA DAS CONTAS ===");
        for (ContaBancaria c : lista_contas) {
            System.out.println(c);
        }
    }
}
