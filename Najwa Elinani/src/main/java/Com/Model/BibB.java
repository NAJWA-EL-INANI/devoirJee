package Com.Model;

public class BibB {
	
	int idBook;
	String Bookname;
	String Booktype;
	String Authorname;


	public int getidBook() {
		return idBook;
	}
	
	
	public void setidBook(int idBook) {
		this.idBook = idBook;
	}


	public String getBookname() {
		return Bookname;
	}


	public void setBookname(String Bookname) {
		this.Bookname = Bookname;
	}
	
	
	public String getBooktype() {
		return Booktype;
	}
	
	
	public void setBooktype(String Booktype) {
		this.Booktype = Booktype;
	}
	
	
	public String getAuthorname() {
		return Authorname;
	}
	
	
	public void setAuthorname(String Authorname) {
		this.Authorname = Authorname;
	}
	
	public BibB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BibB(int idBook, String Bookname , String Booktype, String Authorname) {
		super();
		this.idBook = idBook;
		this.Bookname = Bookname;
		this.Booktype = Booktype;
		this.Authorname = Authorname;

	}
	public BibB(String Bookname , String Booktype, String Authorname) {
		super();
		this.Bookname = Bookname;
		this.Booktype= Booktype;
		this.Authorname = Authorname;

	}
	
	public String Affiche(){
		return this.Bookname+" | "+this.Booktype+" | "+this.Authorname ;
	}
	
}


