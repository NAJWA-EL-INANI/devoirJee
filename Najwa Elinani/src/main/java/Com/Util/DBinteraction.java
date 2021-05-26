package Com.Util;

import java.sql.DriverManager;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBinteraction {
	private static String url="jdbc:mysql://localhost:3306/gestionbibliotheque";
	private static Connection conn;
	private static Statement stat;
	static ResultSet rs;
public static void connect()
	{
		
		try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, "root", "jannat2015");
			stat=conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public static int Maj(String sql)

	{
	
	
		int nb=0;
		try {
			
			nb=stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}

public static ResultSet select(String sql)
	{
		
		try {
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
public static void disconnect()

{
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}

