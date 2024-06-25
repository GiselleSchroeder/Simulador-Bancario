import java.util.ArrayList;
import java.util.List;


class Diretor extends Funcionario {
    private List<Gerente> gerentes;

    public Diretor(String nome, String endereco, String rg, String cpf, String telefone, String matricula) {
        super(nome, endereco, rg, cpf, telefone, matricula);
        this.gerentes = new ArrayList<>();
    }

    public void cadastrarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public void deletarGerente(Gerente gerente) {
        gerentes.remove(gerente);
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }
}
