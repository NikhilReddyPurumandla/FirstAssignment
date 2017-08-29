package controller;

import java.io.IOException;
import util.DbConnection;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ServletDAO;
import model.SignupBean;

import java.sql.*;
/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Name=request.getParameter("name");
		String DateofBirth=request.getParameter("DateOfBirth");
		String Gender=request.getParameter("gender");
		String Mail=request.getParameter("mail");
		String Password=request.getParameter("password");
		String Education=request.getParameter("education");
		String Job=request.getParameter("job");
		SignupBean ob=new SignupBean();
		ob.setName(Name);
		ob.setDob(DateofBirth);
		ob.setGender(Gender);
		ob.setEmail(Mail);
		ob.setPassword(Password);
		ob.setEducation(Education);
	
	
		try {
			 /*con = util.DbConnection.getConnection();
				PreparedStatement st=con.prepareStatement("insert into User values(?,?,?,?,?,?)");
				st.setString(1, ob.getName());
				st.setString(2, ob.getDob());
				st.setString(3, ob.getGender());
				st.setString(4, ob.getEmail());
				st.setString(5, ob.getPassword());
				st.setString(6, ob.getEducation());
				st.executeUpdate();*/
			ServletDAO sd=new ServletDAO();
			if(sd.insert(ob))
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Success</title>");
			    out.println("<body>");
			    out.println("<fieldset>");
			    out.println("<legend align='center'>Success</legend><br/>");
			    out.println("<h1> Your Resitration is successful!</h1>");
			    out.println("<a href=login.jsp>Go to login page</a>");
			    out.println("</fieldset>");
			    out.println("</form>");
			    out.println("</body>");
			    out.println("</html>");  
			/* RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response); */

			
		}
		catch(Exception e) {
			 
			System.out.println(e);
			System.out.println("failed to store details!!! \n try again");
			
			/*RequestDispatcher rd=request.getRequestDispatcher("Signup.html");
			rd.forward(request, response);
			
*/
			out.print("<head>");
			out.print("<body>");
			out.print("<h5>Failed to store data</h5>");
			out.print("<a href=signup.html>Click here to register again</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
