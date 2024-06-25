import java.util.ArrayList;
import java.util.List;


public class Gerente {
    private String nome;
    private String cpf;
    private List<Cliente> clientes;
    
        public Gerente(String nome) {
            this.nome = nome;
            this.clientes = new ArrayList<>();
        }
    
        // Método para adicionar um cliente à lista de clientes do gerente
        public void adicionarCliente(Cliente cliente) {
            clientes.add(cliente);
        }

    public Gerente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    // Outros métodos necessários...
}
