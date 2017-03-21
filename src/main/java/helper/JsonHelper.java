package helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import model.Cliente;
import model.Usuario;

public class JsonHelper {

	public String gerarJsonLista(List<?> lista) {
		StringBuffer json = new StringBuffer("[");

		/*for (int i = 0; i < lista.size(); i++) {

			json.append("{ nome:" + lista.get(i).getNome() + "  , email: " + lista.get(i).getEmail() + "  }");
			if (i < lista.size() - 1)
				json.append(",");
		}*/
		json.append("]");
		return json.toString();

	}

	public String gerarJson(Object o) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		Class clazz = o.getClass();
				
		Method[] metodos = clazz.getDeclaredMethods();
		
		StringBuffer json=new StringBuffer("{");
		
		int qtdGetter=0;
		for (int i = 0; i < metodos.length; i++) {
			
			//se tem a palavra get no nome do metodo
			if (metodos[i].getName().indexOf("get")!=-1  ){
				//quantidade de getter
				qtdGetter++;
				
				String propriedade = metodos[i].getName().substring(3);
				
				Object valor =  metodos[i].invoke(o);
			
				json.append(propriedade.toLowerCase());
				json.append(":");
				json.append(valor);
				
				if (qtdGetter  <  metodos.length-qtdGetter )
					json.append(",");
				
			}
		}
		
		json.append("}");
		return json.toString();
		
	}
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Usuario u = new Usuario();
		u.setNome("Ze");
		u.setEmail("Ze@gmail");
		
		Cliente c = new Cliente();
		c.setCpf("8778787");
		
		
		JsonHelper helper = new JsonHelper();
		System.out.println(helper.gerarJson(u));
	}
	

}
