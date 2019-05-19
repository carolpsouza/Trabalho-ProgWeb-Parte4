package PacoteServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BancoDados.ClienteRepositorio;
import Objetos.Cliente;

@WebServlet("/EditarCliente")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarClienteServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		Cliente cliente = clienteRepositorio.buscarCliente(id);
		
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("EditarCliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setEmail(email);
		
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		clienteRepositorio.atualizarCliente(cliente);
		
		request.getRequestDispatcher("EditarClienteConcluido.jsp").forward(request, response);
	}

}
