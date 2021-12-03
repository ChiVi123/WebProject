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
 * Servlet implementation class ReadContentCrtler
 */
@WebServlet(name = "ReadContentCtrler", urlPatterns = { "/home" })
public class HomeCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeCtrler() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getServletPath();
		// String action = request.getPathInfo();
		System.out.println(action);
		try {
			switch (action) {
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

	private void listContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String find;
		if (request.getParameter("search") == null) {
			if (request.getParameter("textsearch") != "" && request.getParameter("textsearch") != null) {
				find = request.getParameter("textsearch");
			} else {
				find = "";
			}
		} else {
			find = request.getParameter("search");
		}

		int page = 1;
		if (request.getParameter("page") != null && request.getParameter("page") != "") {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;

		int total = contentDAO.count(find);
		int totalPage = (int) Math.ceil((float) total / (float) limit);

		List<Content> listcontent = contentDAO.searchContents(find, limit, page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("listcontent", listcontent);
		request.setAttribute("page", page);
		request.setAttribute("idglobal", Common.idGlobal);
		request.setAttribute("textsearch", find);

		RequestDispatcher dispatcher = request.getRequestDispatcher(Common.HOME_TILES);
		dispatcher.forward(request, response);
	}

}
