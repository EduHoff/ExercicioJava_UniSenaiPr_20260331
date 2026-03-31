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

    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("Valor do depósito precisa ser maior que zero!");
        }else{
            saldo += valor;
            System.out.println("Depósito de R$"+valor+" realizado com sucesso!");
        }
    }

    public void sacar(double valor){
        if(valor <= 0){
            System.out.println("Valor do saque precisa ser maior que zero!");
        }else if(valor > saldo){
            System.out.println("Valor do saque não pode utrapssar o saldo da conta!");
        }else{
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
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
