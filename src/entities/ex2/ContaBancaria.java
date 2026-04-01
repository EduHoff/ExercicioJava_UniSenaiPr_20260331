package entities.ex2;

public class ContaBancaria {

    private String titular;
    private int num_conta;
    private double saldo;
    

    public ContaBancaria(String titular, int num_conta, double saldo) {
        this.titular = titular;
        this.num_conta = num_conta;
        this.saldo = saldo;
    }

    public ContaBancaria(){}

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente para realizar o saque.");
        }
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + " | Número:" + num_conta + " | R$ " + saldo;
    }

    public String getTitular() {
        return titular;
    }

    public int getNum_conta() {
        return num_conta;
    }


    public double getSaldo() {
        return saldo;
    }
}
