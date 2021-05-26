package Com.Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.BibDao;
import Com.Model.BibU;


/**
 * Servlet implementation class test
 */
@WebServlet("/ServletU")
public class ServletU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BibDao em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletU() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		em=new BibDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		BibU u = em.authentification(email,password);
		if(u!=null)
		{
			HttpSession ses = request.getSession(true);
			ses.setAttribute("BibU", u);
			response.sendRedirect("BibU");
		}else
		{
			
			request.setAttribute("msg", "email ou password incorrect");
	RequestDispatcher
			 dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
	//		response.sendRedirect("indx.jsp");
			
		}
		
	}

}
