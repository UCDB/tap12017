package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Usuario;
import repository.UsuarioRepository;
import repository.UsuarioRepositoryBanco;

@WebServlet(urlPatterns = "/usucontroller")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UsuarioRepository usuarioRepository = new UsuarioRepositoryBanco();

	private JsonHelper jsonHelper = new JsonHelper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Capturando o que vem do client
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		// Instanciando objeto
		Usuario usu = new Usuario(nome, email);

		// Inserir na lista
		usuarioRepository.cadastrar(usu);
		try {
			resp.getWriter().println(jsonHelper.gerarJson(usu));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String json;
		try {
			json = jsonHelper.gerarJsonLista(usuarioRepository.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idUsu = req.getParameter("id");
		// capturando o indice do objeto a ser alterado
		Integer id = Integer.parseInt(idUsu);

		// Capturando dados a serem alterados
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		// Colocando dados da tela em objeto usuario
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setEmail(email);

		usuarioRepository.alterar(usuario);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// capturando o indice do objeto a ser excluido
		int id = Integer.parseInt(req.getParameter("id"));
		// removendo objeto do array
		usuarioRepository.excluir(id);

	}

}
