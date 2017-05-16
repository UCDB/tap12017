package repository;

import java.util.List;

import model.Usuario;

public class TestUsuarioRepository {

	static UsuarioRepository ur =  new UsuarioRepositoryBanco();
	
	public static void main(String[] args) {
		//deveCadastrar();
		deveBuscarTodos();

	}

	
	public static void deveCadastrar(){
		
		Usuario usu = new Usuario();
		usu.setEmail("ze@gmail.com");
		usu.setNome("ze");
		
		
		ur.cadastrar(usu);
		
	}
	
	public static void deveBuscarTodos(){
		
		List<Usuario> todos = ur.buscarTodos();
		System.out.println(todos);
	}
	
	
}
