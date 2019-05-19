package PacoteServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BancoDados.ClienteRepositorio;
import Objetos.Cliente;

@WebServlet("/AdicionarCliente")
public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarClienteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AdicionarCliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		clienteRepositorio.adicionarCliente(cliente);
		
		request.getRequestDispatcher("AdicionarClienteConcluido.jsp").forward(request, response);
	}

}
