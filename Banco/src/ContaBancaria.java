public class ContaBancaria {
    private String agencia;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String agencia, String numeroConta, double saldoInicial) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    // Métodos getters e setters
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Outros métodos da conta bancária (depósito, transferência, etc)
}
