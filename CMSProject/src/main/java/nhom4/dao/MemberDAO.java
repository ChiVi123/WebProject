package nhom4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nhom4.models.Member;
import nhom4.dao.ConnectDB;

public class MemberDAO {
	private static final String UPDATE_MEMBER = "UPDATE Member "
			+ " SET Firstname = ?, Lastname = ?, Phone = ?, Description = ? WHERE id = ;";

	public MemberDAO() {
	}

	ConnectDB connect = new ConnectDB();
	public boolean updateContent(Member member) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connect.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBER);) {
		/*	statement.setString(1, member.getFirstname());
			statement.setString(2, member.getLastname());
			statement.setString(3, member.getPhone());
		   statement.setString(2, member.getDescription());
			*/
			statement.setInt(4, member.getId());
			;
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
