package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {

	private int id = 1;
	private List<Usuario> lista = new ArrayList<>();

	public void cadastrar(Usuario usuario) {
		usuario.setId(id++);
		lista.add(usuario);
	}

	public List<Usuario> buscarTodos() {
		return lista;
	}

	public void alterar(Usuario usuario) {

		// Busca usuario
		Usuario usuBuscado = buscarPorId(usuario.getId());

		// Atualiza os dados
		usuBuscado.setNome(usuario.getNome());
		usuBuscado.setEmail(usuario.getEmail());

	}

	private Usuario buscarPorId(Integer id) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				return lista.get(i);
			}
		}

		return null;

	}

	public void excluir(int id) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				lista.remove(i);
				return;
			}

		}

	}

}
