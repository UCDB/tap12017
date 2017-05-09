package helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Cliente;
import model.Usuario;

public class JsonHelper {

	public String gerarJsonLista(List<?> lista) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		StringBuffer json = new StringBuffer("[");

		for (int i = 0; i < lista.size(); i++) {

			json.append(gerarJson(lista.get(i)));
			if (i < lista.size() - 1)
				json.append(",");
		}
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
		
		
		Usuario u2 = new Usuario();
		u2.setNome("Jao");
		u2.setEmail("jao@gmail");
		
		
		//List<Object> lista= Arrays.asList(u,u2);
		
		List<Object> listaUsuarios = new ArrayList();
		listaUsuarios.add(u);
		listaUsuarios.add(u2);
		
		
		
		
		
		
		Cliente c = new Cliente();
		c.setCpf("8778787");
		
		Cliente c2 = new Cliente();
		c2.setCpf("77777777");
		
		
		List<Object> listaClientes= Arrays.asList(c,c2);
		
		
		
		List<Object> listaMista = Arrays.asList(u,u2,c,c2);
		
		
		
		JsonHelper helper = new JsonHelper();
		//System.out.println(helper.gerarJsonLista(listaUsuarios));
		//System.out.println(helper.gerarJsonLista(listaClientes));
	
		System.out.println(helper.gerarJsonLista(listaMista));
		
		//System.out.println(helper.gerarJson(c));

	}
	
	

}
