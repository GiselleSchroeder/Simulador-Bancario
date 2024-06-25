public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String agencia, String numeroConta, double saldoInicial) {
        super(agencia, numeroConta, saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public String toString() {
        return "Conta Corrente: " + super.toString();
    }
}
