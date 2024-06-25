// DatabaseConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection conn;

    public DatabaseConnection(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }

    public void insertCliente(String nome, String endereco, String rg, String cpf, String telefone, String gerente) {
        String query = "INSERT INTO clientes (nome, endereco, rg, cpf, telefone, gerente) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, endereco);
            pstmt.setString(3, rg);
            pstmt.setString(4, cpf);
            pstmt.setString(5, telefone);
            pstmt.setString(6, gerente);

            pstmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Error inserting data into database: " + e.getMessage());
        }
    }

    public void insertConta(String cliente, String tipoConta, String agencia, String numeroConta, String saldo) {
        String query = "INSERT INTO contas (cliente, tipo_conta, agencia, numero_conta, saldo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, cliente);
            pstmt.setString(2, tipoConta);
            pstmt.setString(3, agencia);
            pstmt.setString(4, numeroConta);
            pstmt.setString(5, saldo);

            pstmt.executeUpdate();
            System.out.println("Conta cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Error inserting data into database: " + e.getMessage());
        }
    }

    // Add more methods for other database operations (e.g. select, update, delete)
}