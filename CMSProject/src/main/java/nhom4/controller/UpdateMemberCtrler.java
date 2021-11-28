package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.dao.MemberDAO;
import nhom4.models.Member;
import nhom4.utilities.Common;

/**
 * Servlet implementation class UpdateMemberCtrler
 */
@WebServlet(name = "UpdateMemberCtrler", urlPatterns = { "/editMember", "/updateMember" })
public class UpdateMemberCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMemberCtrler() {
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
			case "/editMember":
				showEditMemberForm(request, response);
				break;
			case "/updateMember":
				updateMember(request, response);
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

	private void showEditMemberForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Member existingMember = memberDAO.selectMember(id);
		request.setAttribute("member", existingMember);
		request.setAttribute("idglobal", Common.idGlobal);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.PROFILE_TILES);
		dispatcher.forward(request, response);
	}
	
	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String des = request.getParameter("description");

		Member editMember = new Member(id, firstname, lastname, phone, des);
		memberDAO.updateMember(editMember);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.PROFILE_TILES);
		Member existingMember = memberDAO.selectMember(id);
		request.setAttribute("member", existingMember);
		dispatcher.forward(request, response);
	}
}
