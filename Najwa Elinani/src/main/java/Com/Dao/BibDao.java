package Com.Dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Com.Model.BibB;
import Com.Model.BibU;
import Com.Util.DBinteraction;

public class BibDao implements IBib {

@Override
public int addUser(BibU u) {
		DBinteraction.connect();
		int nb=DBinteraction.Maj("INSERT INTO user VALUES(null',"+u.getemail()+"','"+u.getpassword()+"')");
		DBinteraction.disconnect();
		return nb;
  }

@Override
	public int addUser(String email, String password) {
		DBinteraction.connect();
		int nb=DBinteraction.Maj("INSERT INTO user VALUES(null','"+email+"','"+password+"')");
		DBinteraction.disconnect();
		return nb;
	}

@Override	
	public BibU authentification(String email, String password) {
		BibU u=null;

		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("SELECT * FROM user WHERE email='"+email+"' and password='"+password+"'");
		try {
			

			if(rs.next())
			{
				u=new BibU(rs.getInt(1),rs.getString(2) ,rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return u;
	}
	
	/**/
	/**/
	/**/

@Override
public BibB findBookByauteur(String Authorname) {
	BibB b=null;
	DBinteraction.connect();
	ResultSet rs = DBinteraction.select("SELECT * FROM book WHERE Authorname="+Authorname);
	try {
		if(rs.next())
		{
			b=new BibB(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return b;
}

@Override
public BibB findBookBycategorie(String Booktype) {
	BibB b=null;
	DBinteraction.connect();
	ResultSet rs = DBinteraction.select("SELECT * FROM book WHERE Booktype="+Booktype);
	try {
		if(rs.next())
		{
			b=new BibB(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return b;
}



@Override
public List<BibB> allBibB() {
	List<BibB>  Book=new ArrayList<BibB>();
	DBinteraction.connect();
	ResultSet rs = DBinteraction.select("SELECT * FROM book ");
	try {
		while(rs.next())
		{
			BibB b=new BibB(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
			Book.add(b);	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Book;
}
	
	
}

