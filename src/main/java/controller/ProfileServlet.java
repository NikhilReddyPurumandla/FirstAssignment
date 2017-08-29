package controller;

import controller.LoginServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DbConnection;
import model.SignupBean;

//import service.LoginServlet;
import java.sql.*;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
    //TODO Enable https for your app. set httOnly and secure flags for jsession cookie
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader ("Expires", 0);
	
		  HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }

		 String id2=request.getParameter("id1");
		 String email= (String) request.getSession(false).getAttribute("user");
		 System.out.println("hiiii email is:"+email);
		 System.out.println("your id is:"+id2);
		 
		  
     		
		 try {
             con = util.DbConnection.getConnection();
		 
         out.print("<html>");
         
         out.print("<head>");
         out.print("<body background=https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGp25MOfvTKpR18RKfSx7vbF4A3HayFaPrEBatJCZi5skpdR9FSQ>");
         out.print("<style>\n" + 
         		".navbar\n" + 
         		"{\n" + 
         		"width:100%; background-color:skyblue; height:55px;\n" + 
         		"}\n" + 
         		".dropbtn {\n" + 
         		"    background-color:grey;\n" + 
         		"    color: white;\n" + 
         		"    padding: 16px;\n" + 
         		"    font-size: 16px;\n" + 
         		"}\n" + 
         		"body{\n" + 
         		"background-repeat:repeat;\n" + 
         		"\n" + 
         		"background-size:100%;\n" + 
         		"}"+
         		"</style>\n" + 
         		"<div class=\"navbar\"> \n" + 
         		"<a href=\"index.jsp\"><button class=\"dropbtn\">Home</button></a>\n" + 
         		"<a href=\"ProfileServlet\"><button class=\"dropbtn\">Profile</button></a>\n" + 
         		"<a href=\"LogoutServlet\"><button class=\"dropbtn\">Logout</button></a>\n" + 
         		"</div>");
         out.print("<table width=25% border=1>");
         out.print("<center><h1>Result:</h1></center>");

         PreparedStatement ps=con.prepareStatement("select * from User where Mail=?");
         ps.setString(1,email);
         ResultSet rs1=ps.executeQuery();                
         ResultSetMetaData rsmd=rs1.getMetaData();
         while(rs1.next())
            {
            out.print("<tr>");
            out.print("<td>"+rsmd.getColumnName(1)+"</td>");
            out.print("<td>"+rs1.getString(1)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
            out.print("<td>"+rs1.getString(2)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
            out.print("<td>"+rs1.getString(3)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
            out.print("<td>"+rs1.getString(4)+"</td></tr>");   
            out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
            out.print("<td>"+rs1.getString(5)+"</td></tr>");  
            out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
            out.print("<td>"+rs1.getString(6)+"</td></tr>");  

         }

         out.print("</table>");
         out.print("</body>");
         
         out.print("</html>");
   

		 }
		 catch(Exception e) {
			
			 
			 System.out.println(e);
			 
		 }
     		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	
	}

}