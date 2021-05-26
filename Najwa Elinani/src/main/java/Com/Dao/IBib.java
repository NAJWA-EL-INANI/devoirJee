package Com.Dao;

import java.util.List;


import Com.Model.BibU;
import Com.Model.BibB;


public interface IBib {
	
	public int addUser(BibU u);
	public int addUser(String email, String password);
	public BibU authentification(String email,String password);
	
	/**//**/
	

	public BibB findBookByauteur(String Authorname);
	public BibB findBookBycategorie(String Booktype);
	public List<BibB> allBibB();
	
}
