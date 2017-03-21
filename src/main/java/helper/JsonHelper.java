package helper;

import java.util.List;

import model.Cliente;
import model.Usuario;

public class JsonHelper {

	public String gerarJsonListaUsuario(List<Usuario> lista) {
		StringBuffer json = new StringBuffer("[");

		for (int i = 0; i < lista.size(); i++) {

			json.append("{ nome:" + lista.get(i).getNome() + "  , email: " + lista.get(i).getEmail() + "  }");
			if (i < lista.size() - 1)
				json.append(",");
		}
		json.append("]");
		return json.toString();

	}

	public String gerarJsonUsuario(Usuario usu) {
		return "{ nome:" + usu.getNome() + "  , email: " + usu.getEmail() + "  } ";

	}
	
	
	
	public String gerarJsonListaCliente(List<Cliente> lista) {
		StringBuffer json = new StringBuffer("[");

		for (int i = 0; i < lista.size(); i++) {

			json.append("{ cpf:" + lista.get(i).getCpf()+ "  }");
			if (i < lista.size() - 1)
				json.append(",");
		}
		json.append("]");
		return json.toString();

	}

	public String gerarJsonCliente(Cliente usu) {
		return "{ cpf:" + usu.getCpf() + "  } ";

	}

}
