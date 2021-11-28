package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.models.Content;
import nhom4.dao.ContentDAO;
import nhom4.utilities.Common;

/**
 * Servlet implementation class CreateContentCtrler
 */
@WebServlet(name = "CreateContentCtrler", urlPatterns = {"/newContent", "/insertContent"})
public class CreateContentCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateContentCtrler() {
		super();
		contentDAO = new ContentDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		// String action = request.getPathInfo();
		System.out.println(action);
		try {
			switch (action) {			
			case "/newContent":
				showNewForm(request, response);
				break;
			case "/insertContent":
				insertContent(request, response);
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

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("idglobal", Common.idGlobal);
		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.CONTENT_TILES);
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
}
