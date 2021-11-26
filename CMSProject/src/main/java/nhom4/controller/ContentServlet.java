package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.dao.ContentDAO;
import nhom4.dao.MemberDAO;
import nhom4.models.Content;
import nhom4.models.Member;
import nhom4.utilities.Common;

/**
 * Servlet implementation class ContentServlet
 */

@WebServlet(name = "ContentServlet", value = "/")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;
	private MemberDAO memberDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContentServlet() {
		// super();
		// TODO Auto-generated constructor stub
		contentDAO = new ContentDAO();
		memberDAO = new MemberDAO();
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
			case "/editmember":
				showEditMemberForm(request, response);
				break;
			case "/updatemember":
				updateMember(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertContent(request, response);
				break;
			case "/delete":
				deleteContent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateContent(request, response);
				break;
			case "/login":
				login(request, response);
				break;
			case "/home":
				listContent(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.PROFILE_TILES);
		request.setAttribute("member", existingMember);
		dispatcher.forward(request, response);
	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String des = request.getParameter("description");

		Member editMember = new Member(id, firstname, lastname, phone, des);
		memberDAO.updateMember(editMember);
		response.sendRedirect("home");
	}

	private void listContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String textsearch = request.getParameter("search");
		if(textsearch == null) {
			textsearch = "";
		}
		int page = 1;
		if (request.getParameter("page") != null && request.getParameter("page") != "") {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;
		int total = ContentDAO.count(textsearch);
		System.out.println(total);
		int totalPage = (int) Math.ceil((float) total / (float) limit);
		System.out.println(totalPage);
		
		List<Content> listcontent = contentDAO.searchContents(textsearch, limit, page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("listcontent", listcontent);
		request.setAttribute("page", page);
		request.setAttribute("idglobal", Common.idGlobal);
		request.setAttribute("textsearch", textsearch);

		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.HOME_TILES);
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.CONTENT_TILES);
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Content existingContent = contentDAO.selectContent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.CONTENT_TILES);
		request.setAttribute("content", existingContent);
		dispatcher.forward(request, response);
	}

	private void insertContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");

		Content newContent = new Content(title, brief, content, Common.idGlobal);
		contentDAO.insertContent(newContent);
		response.sendRedirect("home");
	}

	private void updateContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");

		Content editContent = new Content(id, title, brief, content, Common.idGlobal);
		contentDAO.updateContent(editContent);
		response.sendRedirect("home");
	}

	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.sendRedirect("home");
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	}

}
