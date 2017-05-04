package bdd;

import java.sql.*;

public class MysqlCon
{

	public static void main(String args[]) throws Exception, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_test", "root" ,"daoudi");
		// ici jdbc_test est le nom de la BD, root est le "user" et daoudi est
		// le mot de passe

		Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement("UPDATE emp SET id = ? WHERE name = ? ");

			ResultSet rs = stmt.executeQuery("select * from emp");

			ResultSetMetaData mdata = rs.getMetaData();
			System.out.println(mdata.getColumnCount());
			System.out.println(mdata.getColumnName(1));
			System.out.println(mdata.getTableName(1));

			while (rs.next()){
				System.out.println(rs.getInt("id") + "  " + rs.getString("name") + "  " + rs.getInt("age"));
			}
		
			
			pstmt.setInt(1, 10); 
			pstmt.setString(2, "jm");
			int i = pstmt.executeUpdate();
			
			ResultSet rs2 = stmt.executeQuery("select * from emp");
			while (rs2.next()){
				System.out.println(rs2.getInt("id") + "  " + rs2.getString("name") + "  " + rs2.getInt("age"));
			}
			
			rs.close();
			rs2.close();
			stmt.close();
			pstmt.close();
			con.close();
			
	
	}

}
