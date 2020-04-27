package demopack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public boolean getuser(String uname,String pwd) {
		
		Connection con=null;
		boolean validuser;
		 validuser=false;
		PreparedStatement ps=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			ps=con.prepareStatement("select username,password from petuser where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				validuser=true;
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		return validuser;
		
	}

}
