package Com.Web;

import java.io.IOException;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.BibDao;
import Com.Model.BibB;




/**
 * Servlet implementation class ServletB
 */
@WebServlet("/FindByType")
public class FindByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BibDao bm;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		bm=new BibDao();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Bookname=request.getParameter("Bookname");
		String Booktype=request.getParameter("Booktype");
		String Authorname=request.getParameter("Authorname");
		
		BibB b = bm.findBookBycategorie( Booktype);
		
		if(b != null)
		{
			HttpSession ses = request.getSession(true);
			ses.setAttribute("BibB", b);
			response.sendRedirect("BibB");
			((BibB) response).Affiche();
			
			
	
		}else
			{
			request.setAttribute("msg", " categorie n'existe pas ");
			response.sendRedirect("index.jsp");
			}
			
		response.sendRedirect("BibB");
		
	}

}
