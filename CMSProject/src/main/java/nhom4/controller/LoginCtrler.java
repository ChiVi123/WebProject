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
import nhom4.utilities.Common;

/**
 * Servlet implementation class LoginCtrler
 */
@WebServlet(name = "LoginCtrler", urlPatterns = { "/login" })
public class LoginCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrler() {
		super();
		memberDAO = new MemberDAO();
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
			case "/login":
				login(request, response);
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

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		Member loginMember = memberDAO.login(email, pass);

		if (loginMember == null) {
			request.setAttribute("mess", "Wrong email or password");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			Common.idGlobal = loginMember.getId();
			response.sendRedirect("home");
		}
		// request.getRequestDispatcher(Common.HOME_TILES).forward(request, response);
	}

}
