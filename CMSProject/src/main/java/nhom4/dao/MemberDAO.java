package nhom4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nhom4.models.Content;
import nhom4.models.Member;
import nhom4.dao.ConnectDB;

public class MemberDAO {
	private static final String UPDATE_MEMBER = "UPDATE Member "
			+ " SET Firstname = ?, Lastname = ?, Phone = ?, Description = ? WHERE id = ?;";
	private static final String SELECT_MEMBER = "SELECT Firstname,Lastname, Email, Phone, Description  FROM Member WHERE id = ?;";
	private static final String SELECT_MEMBERLOGIN ="SELECT Username, Password FROM Member;";

	public MemberDAO() {

	}
	
	public static Member findMemberLogin(String userName, String password) {
		Member select = null;
		// Step 1: Establishing a Connection
		try (Connection connection = connect.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_MEMBER);) {
			statement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String firstname = rs.getString("Firstname");
				String lastname = rs.getString("Lastname");
				String email = rs.getString("Email");
				String phone = rs.getString("Phone");
				String desciption = rs.getString("Description");
				select = new Member(id, firstname, lastname, email, phone, desciption);
			}

		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return select;
	}

	public Member selectMember(int id) {
		Member select = null;
		// Step 1: Establishing a Connection
		try (Connection connection = connect.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(SELECT_MEMBER);) {
			statement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String firstname = rs.getString("Firstname");
				String lastname = rs.getString("Lastname");
				String email = rs.getString("Email");
				String phone = rs.getString("Phone");
				String desciption = rs.getString("Description");
				select = new Member(id, firstname, lastname, email, phone, desciption);
			}

		} catch (SQLException e) {
			connect.printSQLException(e);
		}
		return select;
	}

	ConnectDB connect = new ConnectDB();

	public boolean updateMember(Member member) throws SQLException {
		boolean rowUpdated;

		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBER);) {
			statement.setString(1, member.getFirstname());
			statement.setString(2, member.getLastname());
			statement.setString(3, member.getPhone());
			statement.setString(4, member.getDescription());
			statement.setInt(5, member.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public static Member findMember(Connection conn, int id) throws SQLException {
		String sql = "SELECT Firstname,Lastname, Email, Phone, Description  FROM Member WHERE id = ?;";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String firstname = rs.getString("Firstname");
			String lastname = rs.getString("Lastname");
			String email = rs.getString("Email");
			String phone = rs.getString("Phone");
			String desciption = rs.getString("Description");
			Member member = new Member(id, firstname, lastname, email, phone, desciption);
			return member;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Member member) throws SQLException {
		String sql = "UPDATE Member " + " SET Firstname = ?, Lastname = ?, Phone = ?, Description = ? WHERE id = ;";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, member.getFirstname());
		pstm.setString(2, member.getLastname());
		pstm.setString(3, member.getPhone());
		pstm.setString(2, member.getDescription());

		pstm.setInt(4, member.getId());
		pstm.executeUpdate();
	}
}
