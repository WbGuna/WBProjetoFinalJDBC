package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entidade.User;

@WebServlet("/ServletPF")
public class ServletPF extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;
   
    public ServletPF() {
        super();
        dao = new UserDAO(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String pais = request.getParameter("pais");
		String id = request.getParameter("id");
		String option = request.getParameter("option");
		
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			if ((nome != null) && (email!= null) && (telefone != null) && (pais != null)) {
				if (!nome.equals("")){
					 dao = new UserDAO();
					 User user = new User(nome, email, telefone, pais);
					 dao.addUser(user);
				}
			}
			
		}				
		request.setAttribute("lista", dao.getListUser());
		
		request.getRequestDispatcher("/").forward(request, response);			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);		
	}
	
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		User userBuscar=  dao.buscarUser(id1);
		request.setAttribute("user", userBuscar);
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String pais = request.getParameter("pais");
		String id = request.getParameter("id");
		
		if ((nome != null) && (email != null) && (telefone != null) && (pais != null) && (id != null)) {
			if (!nome.equals("")){
				dao = new UserDAO();
				Integer id1 = Integer.parseInt(id);
				User user1 = new User(nome, email, telefone, pais);
				user1.setId(id1);
				dao.updateUser(user1);		
			}
		} 		
	}
	
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			dao = new UserDAO();
			dao.removeUser(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String pais = request.getParameter("pais");
		
		if ((nome != null) && (email!= null) && (telefone != null) && (pais != null)) {
			if (!nome.equals("")){
				 dao = new UserDAO();
				 User user = new User(nome, email, telefone, pais);
				 dao.addUser(user);
			}
		}	
	}
	
}


