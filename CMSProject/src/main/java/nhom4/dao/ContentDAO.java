package nhom4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nhom4.models.Content;
import nhom4.dao.ConnectDB;

public class ContentDAO {
	private static final String INSERT_CONTENT = "INSERT INTO Content"
			+ "  (Title, Brief, Content, CreateDate, Sort, AuthorId) VALUES " + " (?, ?, ?, now(), ?, ?);";

	private static final String SELECT_CONTENT = "select id, Title, Brief, Content, CreateDate, UpdateTime, Sort, AuthorId from Content where id =?";
	private static final String SELECT_CONTENTS = "select * from Content";
	private static final String DELETE_CONTENT = "delete from Content where id = ?;";
	private static final String UPDATE_CONTENT = "update Content set Title = ?, Brief= ?, Content =?, UpdateTime =?, Sort =? where id = ?;";

	public ContentDAO() {
	}

	ConnectDB connect = new ConnectDB();

	public void insertCONTENT(Content content) throws SQLException {
		System.out.println(INSERT_CONTENT);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_CONTENT)) {
			statement.setString(1, content.getTitle());
			statement.setString(2, content.getBrief());
			statement.setString(3, content.getContent());
			/*
			 * preparedStatement.setTimestamp(4, content.getCreateDate());
			 * preparedStatement.setString(5, content.getUpdateTime());
			 */
			statement.setString(5, content.getSort());
			statement.setInt(6, content.getAuthorId());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
	}

	public Content selectContent(int id) {
		Content select = null;
		// Step 1: Establishing a Connection
		try (Connection connection = connect.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_CONTENT);) {
			statement.setInt(1, id);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			/* Title, Brief, Content, CreateDate, UpdateTime, Sort, AuthorId */
			while (rs.next()) {
				String title = rs.getString("Title");
				String brief = rs.getString("Brief");
				String content = rs.getString("Content");
				int authorid = rs.getInt("AuthorId");

				select = new Content(id, title, brief, content, authorid);
			}
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return select;
	}

	public List<Content> selectContents() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Content> contents = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = connect.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_CONTENTS);) {
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				String brief = rs.getString("Brief");
				String content = rs.getString("Content");
				int authorid = rs.getInt("AuthorId");
				contents.add(new Content(id, title, brief, content, authorid));
			}
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return contents;
	}

	public boolean deleteContent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateContent(Content content) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CONTENT);) {
			statement.setString(1, content.getTitle());
			statement.setString(2, content.getBrief());
			statement.setString(3, content.getContent());
			/* statement.setString(4, content.getUpdateTime()); */
			statement.setString(5, content.getSort());
			statement.setInt(6, content.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
