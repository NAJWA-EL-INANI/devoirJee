package Com.Model;


public class BibU{
	
	int iduser;
	String email,password;

	
	public int getiduser() {
		return iduser;
	}
	
	public void setiduser(int iduser) {
		this.iduser = iduser;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	

	public BibU(String email , String password) {
		super();
		
		this.email = email;
		this.password = password;
		
	}


	public BibU(int iduser, String email,String password) {
		super();
		this.iduser = iduser;
		this.email = email;
		this.password = password;

	}


}
