package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.dao.MemberDAO;
import nhom4.models.Member;

/**
 * Servlet implementation class RegisterCtrler
 */
@WebServlet(name = "RegisterCtrler", urlPatterns = { "/register" })
public class RegisterCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCtrler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		// String action = request.getPathInfo();
		System.out.println(action);
		try {
			switch (action) {
			case "/register":
				register(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		MemberDAO member = new MemberDAO();
		// Member a=member.checkMember(email);
		/*
		 * if(a == null) { request.setAttribute("mess",
		 * "That email is taken. Please try another one");
		 * request.getRequestDispatcher("register.jsp").forward(request, response); }
		 * else
		 */if (!pass.equals(re_pass)) {
			request.setAttribute("mess", "Those passwords didn't match. Please try another one");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			// response.sendRedirect("register.jsp");
		} else {
			Member acc = new Member(user, email, pass);
			member.register(acc);
			response.sendRedirect("index.jsp");
		}
	}

}
