package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class UsuarioJava extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DaoUsuario daoUsuario = new DaoUsuario();
	
    public UsuarioJava() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			
			if(acao.equalsIgnoreCase("deletarUsuario")) {
				daoUsuario.deletarUsuario(user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listarUsuario());
				dispatcher.forward(request, response);
			}else if(acao.equalsIgnoreCase("editarUsuario")) {
				BeanCursoJsp beanCursoJsp = daoUsuario.consultarUsuario(user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				dispatcher.forward(request, response);
			}else if(acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listarUsuario());
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("password");
			
			BeanCursoJsp usuario = new BeanCursoJsp();
			usuario.setId(!id.isEmpty()? Long.parseLong(id) : 0);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			
			if(id == null || id.isEmpty()) {
				daoUsuario.cadastrarUsuario(usuario);
			}else {
				daoUsuario.editarUsuario(usuario);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listarUsuario());
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
