package controller;
import DAO.ServletDAO;
import model.SignupBean;

import util.DbConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out=response.getWriter();
		
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		HttpSession session1 = request.getSession(false);
		 if (session1 != null)
	        {
	        	
	        	session1.invalidate(); 
	     
	         
	       
			}
		String email=request.getParameter("email");
		String Password=request.getParameter("pass");
	    SignupBean sb=new SignupBean();
	    sb.setEmail(email);
        sb.setPassword(Password);
        
        try {
			ServletDAO sd=new ServletDAO();
			  if(sd.login(sb))
	            {
				  HttpSession session = request.getSession(true);
					session.setAttribute("user", email);
				
					session.setMaxInactiveInterval(25*60);
			
					session.setAttribute("authenticated", true); 
					Cookie userName = new Cookie("user", email);
					userName.setHttpOnly(true);
					userName.setMaxAge(25*60);
					response.addCookie(userName);
			        String x=request.getRequestedSessionId();
					String encodedURL = response.encodeRedirectURL("FirstServlet/index.jsp?id="+x);
					response.sendRedirect(encodedURL);
					
	            }
			  else
		      {
		      	out.print("<html>");
		      	out.print("<body>");
		        out.print("<h3>Username or Password incorrect</h3>");
		        out.print("<a href=login.jsp>click here to go to login page</a>");
		        out.print("</body>");
		        out.print("</html>");
		         //RequestDispatcher rs = request.getRequestDispatcher("/login");
		         //rs.include(request, response);
		      }
	            }
			
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	  
			
	}

	private Object getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

}
