package PacoteServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BancoDados.ClienteRepositorio;
import Objetos.Cliente;

@WebServlet("/ListarClientes")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarClientesServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
		ArrayList<Cliente> clientes = clienteRepositorio.listarClientes();
		
		request.setAttribute("clientes", clientes);
		request.getRequestDispatcher("ListarClientes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
