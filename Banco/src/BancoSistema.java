import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoSistema extends JFrame {

    private Connection conn;

    private JPanel mainPanel;
    private JPanel telaCadastroCliente;
    private JPanel telaCadastroGerente;

    private Map<Integer, ContaBancaria> contas;
    private List<Gerente> gerentes;

    public BancoSistema() {
        // Configurações do JFrame
        setTitle("Sistema Bancário");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        contas = new HashMap<>();
        gerentes = new ArrayList<>();

        // Initialize database connection
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "@espadasaojorge14";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }

        // Tela inicial
        JPanel telaInicial = new JPanel(new GridBagLayout());
        GridBagConstraints gbcInicial = new GridBagConstraints();
        gbcInicial.insets = new Insets(10, 10, 10, 10);

        JButton clienteButton = new JButton("Cliente");
        JButton gerenteButton = new JButton("Gerente");
        JButton diretorButton = new JButton("Diretor"); // Novo botão

        gbcInicial.gridx = 0;
        gbcInicial.gridy = 0;
        telaInicial.add(clienteButton, gbcInicial);

        gbcInicial.gridx = 1;
        telaInicial.add(gerenteButton, gbcInicial);

        gbcInicial.gridx = 2; // Posicionando o botão "Diretor"
        telaInicial.add(diretorButton, gbcInicial);

        mainPanel.add(telaInicial, "Tela Inicial");

        // Tela do Cliente
        JPanel telaCliente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(10, 10, 10, 10);

        JButton consultarContaClienteButton = new JButton("Consultar Conta");
        JButton voltarClienteButton = new JButton("Voltar");

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;
        telaCliente.add(consultarContaClienteButton, gbcCliente);

        gbcCliente.gridx = 1;
        telaCliente.add(voltarClienteButton, gbcCliente);

        mainPanel.add(telaCliente, "Tela Cliente");

        // Tela do Gerente
        JPanel telaGerente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcGerente = new GridBagConstraints();
        gbcGerente.insets = new Insets(10, 10, 10, 10);

        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        JButton cadastrarContaButton = new JButton("Cadastrar Conta");
        JButton voltarGerenteButton = new JButton("Voltar");

        gbcGerente.gridx = 0;
        gbcGerente.gridy = 0;
        telaGerente.add(cadastrarClienteButton, gbcGerente);

        gbcGerente.gridx = 1;
        gbcGerente.gridy = 0;
        telaGerente.add(cadastrarContaButton, gbcGerente);

        gbcGerente.gridx = 2;
        gbcGerente.gridy = 0;
        telaGerente.add(voltarGerenteButton, gbcGerente);

        mainPanel.add(telaGerente, "Tela Gerente");

        // Tela de Cadastro de Cliente
        telaCadastroCliente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCadastroCliente = new GridBagConstraints();
        gbcCadastroCliente.insets = new Insets(10, 10, 10, 10);

        JLabel nomeClienteLabel = new JLabel("Nome:");
        JTextField nomeClienteField = new JTextField(20);

        JLabel enderecoLabel = new JLabel("Endereço:");
        JTextField enderecoField = new JTextField(20);

        JLabel rgLabel = new JLabel("RG:");
        JTextField rgField = new JTextField(20);

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(20);

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(20);

        JLabel gerenteLabel = new JLabel("Gerente:");
        JComboBox<String> gerenteComboBox = new JComboBox<>();

        for (Gerente gerente : gerentes) {
            gerenteComboBox.addItem(gerente.getNome());
        }

        JButton cadastrarClienteFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroClienteButton = new JButton("Voltar");

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 0;
        telaCadastroCliente.add(nomeClienteLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 0;
        telaCadastroCliente.add(nomeClienteField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 1;
        telaCadastroCliente.add(enderecoLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 1;
        telaCadastroCliente.add(enderecoField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 2;
        telaCadastroCliente.add(rgLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 2;
        telaCadastroCliente.add(rgField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 3;
        telaCadastroCliente.add(cpfLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 3;
        telaCadastroCliente.add(cpfField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 4;
        telaCadastroCliente.add(telefoneLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 4;
        telaCadastroCliente.add(telefoneField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 5;
        telaCadastroCliente.add(gerenteLabel, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 5;
        telaCadastroCliente.add(gerenteComboBox, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 6;
        telaCadastroCliente.add(cadastrarClienteFinalButton, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        gbcCadastroCliente.gridy = 6;
        telaCadastroCliente.add(voltarCadastroClienteButton, gbcCadastroCliente);

        mainPanel.add(telaCadastroCliente, "Tela Cadastro Cliente");

        // Tela de Cadastro de Conta
        JPanel telaCadastroConta = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCadastroConta = new GridBagConstraints();
        gbcCadastroConta.insets = new Insets(10, 10, 10, 10);

        JLabel clienteLabel = new JLabel("Cliente:");
        JComboBox<String> clienteContaComboBox = new JComboBox<>();

        for (Integer clienteId : contas.keySet()) {
            clienteContaComboBox.addItem(clienteId.toString());
}

        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        JComboBox<String> tipoContaComboBox = new JComboBox<>();
        tipoContaComboBox.addItem("Corrente");
        tipoContaComboBox.addItem("Poupança");

        JLabel agenciaLabel = new JLabel("Agência:");
        JTextField agenciaField = new JTextField(20);

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        JTextField numeroContaField = new JTextField(20);

        JLabel saldoLabel = new JLabel("Saldo:");
        JTextField saldoField = new JTextField(20);

        JButton cadastrarContaFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroContaButton = new JButton("Voltar");

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 0;
        telaCadastroConta.add(clienteLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 0;
        telaCadastroConta.add(clienteContaComboBox, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 1;
        telaCadastroConta.add(tipoContaLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 1;
        telaCadastroConta.add(tipoContaComboBox, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 2;
        telaCadastroConta.add(agenciaLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 2;
        telaCadastroConta.add(agenciaField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 3;
        telaCadastroConta.add(numeroContaLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 3;
        telaCadastroConta.add(numeroContaField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 4;
        telaCadastroConta.add(saldoLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 4;
        telaCadastroConta.add(saldoField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 5;
        telaCadastroConta.add(cadastrarContaFinalButton, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        gbcCadastroConta.gridy = 5;
        telaCadastroConta.add(voltarCadastroContaButton, gbcCadastroConta);

        mainPanel.add(telaCadastroConta, "Tela Cadastro Conta");

        // Tela do Diretor
        JPanel telaDiretor = new JPanel(new GridBagLayout());
        GridBagConstraints gbcDiretor = new GridBagConstraints();
        gbcDiretor.insets = new Insets(10, 10, 10, 10);

JButton consultarContaDiretorButton = new JButton("Consultar Conta");
        JButton voltarDiretorButton = new JButton("Voltar");

        gbcDiretor.gridx = 0;
        gbcDiretor.gridy = 0;
        telaDiretor.add(consultarContaDiretorButton, gbcDiretor);

        gbcDiretor.gridx = 1;
        gbcDiretor.gridy = 0;
        telaDiretor.add(voltarDiretorButton, gbcDiretor);

        mainPanel.add(telaDiretor, "Tela Diretor");

        // Adiciona os action listeners
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cliente");
            }
        });

        gerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        diretorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Diretor");
            }
        });

        consultarContaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica para consultar a conta do cliente
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cadastro Cliente");
            }
        });

        cadastrarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cadastro Conta");
            }
        });

        cadastrarClienteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String nome = nomeClienteField.getText();
                String endereco = enderecoField.getText();
                String rg = rgField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();
                String gerente = (String) gerenteComboBox.getSelectedItem();

                // Create a prepared statement to insert the data into the database
                String query = "INSERT INTO clientes (nome, endereco, rg, cpf, telefone, gerente) VALUES (?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, nome);
                    pstmt.setString(2, endereco);
                    pstmt.setString(3, rg);
                    pstmt.setString(4, cpf);
                    pstmt.setString(5, telefone);
                    pstmt.setString(6, gerente);

                    pstmt.executeUpdate();
                    System.out.println("Cliente cadastrado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("Error inserting data into database: " + ex.getMessage());
                }
            }
        });

        cadastrarContaFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String cliente = (String) clienteContaComboBox.getSelectedItem();
                String tipoConta = (String) tipoContaComboBox.getSelectedItem();
                String agencia = agenciaField.getText();
                String numeroConta = numeroContaField.getText();
                String saldo = saldoField.getText();

                // Create a prepared statement to insert the data into the database
                String query = "INSERT INTO contas (cliente, tipo_conta, agencia, numero_conta, saldo) VALUES (?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, cliente);
                    pstmt.setString(2, tipoConta);
                    pstmt.setString(3, agencia);
                    pstmt.setString(4, numeroConta);
                    pstmt.setString(5, saldo);

                    pstmt.executeUpdate();
                    System.out.println("Conta cadastrada com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("Error inserting data into database: " + ex.getMessage());
                }
            }
        });

        voltarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Inicial");
            }
        });

        voltarGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Inicial");
            }
        });

        voltarCadastroClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        voltarCadastroContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        voltarDiretorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Inicial");
            }
        });

        add(mainPanel);
        setVisible(true);
    }
}