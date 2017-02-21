package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/usucontroller")
public class UsuarioController extends  HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Capturando o que vem do client
		String email = req.getParameter("email");
		//Respondendo ao client
		resp.getWriter().print("Olá "  + email  );
	}

}
