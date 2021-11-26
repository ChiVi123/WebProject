package nhom4.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom4.dao.ContentDAO;

/**
 * Servlet implementation class DeleteContentCtrler
 */
@WebServlet(name = "DeleteContentCtrler", urlPatterns = { "/delete" })
public class DeleteContentCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteContentCtrler() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		// String action = request.getPathInfo();
		System.out.println(action);
		try {
			switch (action) {
			case "/delete":
				deleteContent(request, response);
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

	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// response.sendRedirect("home");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		contentDAO.deleteContent(id);
		response.sendRedirect("home");
	}
}
