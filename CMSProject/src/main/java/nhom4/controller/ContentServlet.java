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
import nhom4.models.Content;
import nhom4.utilities.Common;

/**
 * Servlet implementation class ContentServlet
 */
/* @WebServlet(name = "ContentServlet", value = "/Content/*") */
@WebServlet("/")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContentServlet() {
		// super();
		// TODO Auto-generated constructor stub
		contentDAO = new ContentDAO();
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
		System.out.println(action);
		try {
			switch (action) {
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
			default:
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

	private void listContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
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
		// int authorid = Integer.parseInt(request.getParameter("authorid"));
		// Content newContent = new Content(title, brief, content, authorid);
		Content newContent = new Content(title, brief, content, 5);
		contentDAO.insertContent(newContent);
		response.sendRedirect("home");
	}

	private void updateContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		/*
		 * int authorid = Integer.parseInt(request.getParameter("authorid"));
		 * 
		 * Content book = new Content(id, title, brief, content, authorid);
		 */
		Content editContent = new Content(id, title, brief, content, 5);
		contentDAO.updateContent(editContent);
		response.sendRedirect("home");
	}

	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		response.sendRedirect("home");
	}
}
