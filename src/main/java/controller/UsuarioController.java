package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Usuario;

@WebServlet(urlPatterns = "/usucontroller")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<Usuario> lista = new ArrayList<>();
	
	private JsonHelper jsonHelper =  new JsonHelper();
			

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Capturando o que vem do client
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		// Instanciando objeto
		Usuario usu = new Usuario(nome, email);

		// Inserir na lista
		lista.add(usu);

		
		
		resp.getWriter().println(jsonHelper.gerarJsonUsuario(usu));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json = jsonHelper.gerarJsonListaUsuario(lista);
		resp.getWriter().print(json);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturando o indice do objeto a ser alterado
		Integer i = Integer.parseInt(req.getParameter("i"));

		// Capturando dados a serem alterados
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		// Acessando o objeto e alterando os dados
		Usuario usu = lista.get(i);
		usu.setNome(nome);
		usu.setEmail(email);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturando o indice do objeto a ser excluido
		int i = Integer.parseInt(req.getParameter("i"));
		// removendo objeto do array
		lista.remove(i);

	}

	

}
