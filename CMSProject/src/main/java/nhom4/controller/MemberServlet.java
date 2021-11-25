package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.dao.ContentDAO;
import nhom4.dao.MemberDAO;
import nhom4.models.Member;
import nhom4.utilities.Common;
import nhom4.models.MemberLogin;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {
		super();
		memberDAO = new MemberDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/editnewmember":
				showEditForm(request, response);
				break;
			case "/login":
				showEditForm(request, response);
				break;
			case "/register":
				showEditForm(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @throws SQLException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("repass");
		if (!pass.equals(re_pass)) {
			response.sendRedirect("index.jsp");
		} else {
			//MemberDAO member = new MemberDAO();
			// Member a=member.checkMember(email);
			/*
			 * if(a == null) {
			 * 
			 * Member acc = new Member(user, email, pass); member.register(acc);
			 * response.sendRedirect("index.titles");
			 * 
			 * 
			 * }else { response.sendRedirect("register.titles"); }
			 */
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		/*
		 * String email= request.getParameter("email"); String pass=
		 * request.getParameter("pass"); MemberDAO member= new MemberDAO(); Member a=
		 * member.login(email, pass);
		 */
		/*
		 * if(a == null) { request.setAttribute("mess", "Wrong email or password");
		 * request.getRequestDispatcher("index.jsp").forward(request, response); }else {
		 * //request.getRequestDispatcher(Common.HOME_TILES).forward(request, response);
		 * response.sendRedirect(Common.HOME_TILES); }
		 */

	}

	private void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.PROFILE_TILES);
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		/*
		 * Member existingMember = memberDAO.selectMember(id);
		 * 
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher(Common.PROFILE_TILES);
		 * request.setAttribute("member", existingMember); dispatcher.forward(request,
		 * response);
		 */
	}

	

}
