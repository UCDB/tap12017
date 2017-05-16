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
		String sql = "insert into usuario (nome,email) values (?,?)";

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

			String sql = "select * from usuario order by nome";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String nome = result.getString("nome");
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
		String sql = "update usuario set nome=?,email=? where id=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setInt(3, usuario.getId());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Usuario buscarPorId(Integer id) {

		

		try {

			String sql = "select * from usuario where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet result = prepareStatement.executeQuery();

			if (result.next()) {
				int idusu = result.getInt("id");
				String nome = result.getString("nome");
				String email = result.getString("email");

				Usuario u = new Usuario();
				u.setId(idusu);
				u.setNome(nome);
				u.setEmail(email);
				
				return u;
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void excluir(int id) {
		try {
			String sql = "delete from usuario where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			cadastrar(usuario);
		} else {
			alterar(usuario);
		}

	}

}
