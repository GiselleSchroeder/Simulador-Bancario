class Pessoa {
    private String nome;
    private String endereco;
    private String rg;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String endereco, String rg, String cpf, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}

class ContaBancaria {
    private int id;
    private String tipoConta;
    private Cliente cliente;
    private String numeroAgencia;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(int id, String tipoConta, Cliente cliente, String numeroAgencia, String numeroConta, double saldo) {
        this.id = id;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
