class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, String endereco, String rg, String cpf, String telefone, String matricula) {
        super(nome, endereco, rg, cpf, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}