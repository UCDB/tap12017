package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepositoryBanco implements UsuarioRepository {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	@Override
	public void cadastrar(Usuario usuario) {
		String sql="insert into usuario (nome,email) values (?,?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		
		List<Usuario> lista = new ArrayList<>();
		
		try {
			
			String sql ="select * from usuario order by nome";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			ResultSet result = prepareStatement.executeQuery();

		
			
			while(result.next()){
				int id = result.getInt("id");
				String nome =  result.getString("nome");
				String email = result.getString("email");
				
				Usuario u = new Usuario();
				u.setId(id);
				u.setNome(nome);
				u.setEmail(email);
				
				lista.add(u);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
