package nhom4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nhom4.models.Content;
import nhom4.dao.ConnectDB;

public class ContentDAO {
	private static final String INSERT_CONTENT = "INSERT INTO Content"
			+ "  (Title, Brief, Content, CreateDate, UpdateTime, AuthorId) VALUES " + " (?, ?, ?, now(), now(), ?);";
	private static final String SELECT_CONTENT = "SELECT * FROM Content WHERE id = ?;";
	//private static final String SELECT_CONTENTS = "SELECT COUNT(*) FROM content WHERE LIMIT ";
	private static final String COUNT_CONTENT = "SELECT COUNT(*) as total FROM content ORDER BY id DESC";
	private static final String DELETE_CONTENT = "DELETE FROM Content WHERE id = ?;";
	private static final String UPDATE_CONTENT = "UPDATE Content "
			+ " SET Title = ?, Brief = ?, Content = ?, UpdateTime = now() WHERE id = ? AND AuthorId = ?;";
	
	/*private static final String SEARCH_CONTENT = "SELECT * From Content Where  Title LIKE   ? OR Brief LIKE ? OR Content LIKE ?;";*/
	
	public ContentDAO() {
	}

	static ConnectDB connect = new ConnectDB();
	
	public List<Content> searchContents(String textsearch,int limit, int page) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Content> listcontents = new ArrayList<>();
		// Step 1: Establishing a Connection
		int offset=(page - 1) * limit;
		String SEARCH_CONTENTS="SELECT * From Content Where  Title LIKE   ? OR Brief LIKE ? OR Content LIKE ?" +"LIMIT "  + Integer.toString(limit) + " OFFSET " + Integer.toString(offset);
		System.out.println(SEARCH_CONTENTS);
		
	
		try (Connection connection = connect.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(SEARCH_CONTENTS);) {
			statement.setString(1, '%'+textsearch +'%');
			statement.setString(2,'%' +textsearch+'%');
			statement.setString(3, textsearch);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				String brief = rs.getString("Brief");
				String content = rs.getString("Content");
				String createdate = rs.getString("CreateDate");
				int authorid = rs.getInt("AuthorId");
				listcontents.add(new Content(id,title, brief, content, createdate,authorid));
			}
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return listcontents;
	}

	
	public void insertContent(Content content) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_CONTENT)) {
			statement.setString(1, content.getTitle());
			statement.setString(2, content.getBrief());
			statement.setString(3, content.getContent());
			statement.setInt(4, content.getAuthorId());
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
	public List<Content> selectContents(int limit, int page) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Content> listcontents = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		int offset=(page - 1) * limit;
		String SELECT_CONTENTS="SELECT * FROM content LIMIT " + Integer.toString(limit) + " OFFSET " + Integer.toString(offset);
		System.out.println(SELECT_CONTENTS);

		try (Connection connection = connect.getConnection(); 
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_CONTENTS);) {
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				String brief = rs.getString("Brief");
				String content = rs.getString("Content");
				String createdate = rs.getString("CreateDate");
				int authorid = rs.getInt("AuthorId");
				listcontents.add(new Content(id, title, brief, content, createdate, authorid));
			}
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return listcontents;
	}
	public static int count() {
		// Step 1: Establishing a Connection
		try (Connection connection = connect.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement statement = connection.prepareStatement(COUNT_CONTENT);) {
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			// Step 4: Process the ResultSet object.
			rs.next();
			return rs.getInt("total");
		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return 0;
	}
	public void deleteContent(int id) throws SQLException {
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT);) {
			statement.setInt(1, id);
			//System.out.println(statement);
			statement.executeUpdate();
		}catch (SQLException e) {
			connect.printSQLException(e);
		}
	}

	public boolean updateContent(Content content) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CONTENT);) {
			statement.setString(1, content.getTitle());
			statement.setString(2, content.getBrief());
			statement.setString(3, content.getContent());
			statement.setInt(4, content.getId());
			statement.setInt(5, content.getAuthorId());
			
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
