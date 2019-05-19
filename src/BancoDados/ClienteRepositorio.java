package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Objetos.Cliente;

public class ClienteRepositorio {
	private Connection connection = null;
	private Statement statement = null;
	
	public ClienteRepositorio() {
		String servidor = "jdbc:mysql://localhost:3306/trabalho?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) { }
	}
	
	public ArrayList<Cliente> listarClientes() {
		try {
			
			String query = "SELECT * FROM cadastro_cliente ORDER BY nome";
			ResultSet resultSet = this.statement.executeQuery(query);
			
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			while(resultSet.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				
				clientes.add(cliente);
				
			}
			return clientes;
			
		} catch (Exception e) { 
			return null;
		}
	}
	
	public Cliente buscarCliente(int id) {
		try {
			
			String query = "SELECT * FROM cadastro_cliente WHERE id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				
				return cliente;
				
			}
			
		} catch (Exception e) { 
			return null;
		}
		
		return null;
	}
	
	public boolean adicionarCliente(Cliente cliente) {
		try {
			
			String query = "INSERT INTO cadastro_cliente (nome, email) VALUES (?, ?)";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			
			return preparedStatement.execute();
			
		} catch (Exception e) { 
			return false;
		}
	}
	
	public boolean apagarCliente(int id) {
		try {
			
			String query = "DELETE FROM cadastro_cliente WHERE id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			return preparedStatement.execute();
			
		} catch (Exception e) { 
			return false;
		}
	}
	
	public boolean atualizarCliente(Cliente cliente) {
		try {
			
			String query = "UPDATE cadastro_cliente SET nome = ?, email = ? WHERE id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setInt(3, cliente.getId());
			
			return preparedStatement.execute();
			
		} catch (Exception e) { 
			return false;
		}
	}
}
