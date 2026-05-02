package net.etfbl.controller;
import net.etfbl.beans.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.beans.UserAccountBean;
import net.etfbl.dto.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/login.jsp";
		String action = request.getParameter("action");
		System.out.println(action != null?action:"Nula");
		if (action == null || action.equals("")) {
			address = "/WEB-INF/pages/login.jsp";
			}
		else if(action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserAccount user = new UserAccount();
			user.setUsername(username);
			user.setPassword(password);
			user.setIsActivated(0);
			UserAccountBean bean = new UserAccountBean();
			if(bean.login(user)) {
				address = "/WEB-INF/pages/categorys.jsp";
			}
			
		}
		else if(action.equals("categorys")) {
			System.out.println(request.getParameter("update") != null);
			if(request.getParameter("update") != null) {
				address = "/WEB-INF/pages/updateCategory.jsp";
				String id = request.getParameter("id");
				String category = request.getParameter("category");
				String attributes = request.getParameter("attributes");
				request.setAttribute("id", id);
				request.setAttribute("category", category);
				request.setAttribute("attributes", attributes);
				
			}
			else if(request.getParameter("delete") != null) {
				System.out.println("Brisanje nije moguce!!!");
				/*String id = request.getParameter("id");
				String category = request.getParameter("category");
				String attributes = request.getParameter("attributes");
				
				Category cat = new Category();
				cat.setId(Integer.valueOf(id));
				cat.setName(category);
				cat.setAttributes(attributes);
				
				CategoryBean bean = new CategoryBean();
				bean.delete(cat);*/
				address = "/WEB-INF/pages/categorys.jsp";
			}
		}
		else if(action.equals("updateCategory")) {
			String id = request.getParameter("id");
			String category = request.getParameter("category");
			String attributes = request.getParameter("attributes");
			
			Category cat = new Category();
			cat.setId(Integer.valueOf(id));
			cat.setName(category);
			cat.setAttributes(attributes);
			
			CategoryBean bean = new CategoryBean();
			bean.update(cat);
			address = "/WEB-INF/pages/categorys.jsp";
		}
		else if(action.equals("createProgramm")) {
			address = "/WEB-INF/pages/createProgramm.jsp";
			if(request.getParameter("create") != null) {
				String name = request.getParameter("name");
				String attributes = request.getParameter("attributes");
				
				Category category = new Category();
				category.setName(name);
				category.setAttributes(attributes);
				
				CategoryBean bean = new CategoryBean();
				bean.create(category);
			}
		}
		else if(action.equals("users")) {
			address = "/WEB-INF/pages/users.jsp";
			if(request.getParameter("update") != null) {
				address = "/WEB-INF/pages/userUpdate.jsp";
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String city = request.getParameter("city");
				String mail = request.getParameter("mail");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String isActivated = request.getParameter("isActivated");
				
				request.setAttribute("id", id);
				request.setAttribute("name", name);
				request.setAttribute("surname", surname);
				request.setAttribute("city", city);
				request.setAttribute("mail", mail);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("isActivated", isActivated);
			}
		}
		else if(action.equals("userUpdate")) {
			address = "/WEB-INF/pages/userUpdate.jsp";
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String city = request.getParameter("city");
			String mail = request.getParameter("mail");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String isActivated = request.getParameter("isActivated");
			
			User user = new User();
			user.setId(Integer.valueOf(id));
			user.setName(name);
			user.setSurname(surname);
			user.setCity(city);
			user.setMail(mail);
			UserAccount userAcc = new UserAccount();
			userAcc.setIsActivated(Integer.valueOf(isActivated));
			userAcc.setUsername(username);
			userAcc.setPassword(password);
			user.setUserAccount(userAcc);
			System.out.println("Aktivacija "+password);
			UserBean bean = new UserBean();
			bean.update(user);
		}
		else if(action.equals("createUser")) {
			address = "/WEB-INF/pages/createUser.jsp";
			
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String city = request.getParameter("city");
			String mail = request.getParameter("mail");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = new User();
			user.setName(name);
			user.setSurname(surname);
			user.setCity(city);
			user.setMail(mail);
			UserAccount userAcc = new UserAccount();
			userAcc.setIsActivated(1);
			userAcc.setUsername(username);
			userAcc.setPassword(password);
			user.setUserAccount(userAcc);
			
			UserBean bean = new UserBean();
			bean.create(user);
		}
		else if(action.equals("loggs")) {
			address = "/WEB-INF/pages/loggs.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
