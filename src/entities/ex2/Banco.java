package entities.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Banco {

    private List<ContaBancaria> lista_contas = new ArrayList<>();
    private static int contador_geral = 1001;

    private ContaBancaria buscarObjetoConta(int num_conta) {
        for (ContaBancaria c : lista_contas) {
            if (c.getNum_conta() == num_conta) {
                return c;
            }
        }

        throw new NoSuchElementException("Erro: Conta número " + num_conta + " não encontrada.");
    }

    public int cadastrarCliente(String titular, double saldo) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do titular é obrigatório.");
        }
        
        ContaBancaria conta = new ContaBancaria(titular, contador_geral, saldo);
        lista_contas.add(conta);
        
        int numeroGerado = contador_geral;
        contador_geral++;
        
        return numeroGerado;
    }

    public void depositarConta(int num_conta, double valor) {
        ContaBancaria conta = buscarObjetoConta(num_conta); 
        conta.depositar(valor);
    }

    public void sacarConta(int num_conta, double valor) {
        ContaBancaria conta = buscarObjetoConta(num_conta);
        conta.sacar(valor);
    }

    public ContaBancaria consultarConta(int num_conta) {
        return buscarObjetoConta(num_conta);
    }

    public void listarContas() {
        System.out.println("=== LISTA DAS CONTAS ===");
        if (lista_contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        }
        for (ContaBancaria c : lista_contas) {
            System.out.println(c);
        }
    }
}