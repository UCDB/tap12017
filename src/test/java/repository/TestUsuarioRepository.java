package repository;

import java.util.List;

import model.Usuario;

public class TestUsuarioRepository {

	static UsuarioRepository ur =  new UsuarioRepositoryBanco();
	
	public static void main(String[] args) {
		//deveCadastrar();
		//deveBuscarTodos();
		//deveAlterar();
		//deveBuscarPorId();
		//deveExcluir();
	}

	
	public static void deveCadastrar(){
		
		Usuario usu = new Usuario();
		usu.setEmail("ze@gmail.com");
		usu.setNome("ze");
		
		
		ur.cadastrar(usu);
		
	}
	
	
	public static void deveAlterar(){
		
		Usuario usu = new Usuario();
		usu.setEmail("maria@gmail.com");
		usu.setNome("maria");
		usu.setId(2);
		
		ur.alterar(usu);
		
	}

	public static void deveBuscarTodos(){
		
		List<Usuario> todos = ur.buscarTodos();
		System.out.println(todos);
	}
	
	public static void deveBuscarPorId(){
		
		Usuario  u = ur.buscarPorId(1);
		System.out.println(u);
	}
	
	public static void deveExcluir(){
	
		ur.excluir(1);
	}
	
}
