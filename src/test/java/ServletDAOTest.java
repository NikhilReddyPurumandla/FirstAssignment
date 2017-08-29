import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import DAO.ServletDAO;
import model.SignupBean;

public class ServletDAOTest {


	

	@Test
	public void testInsert() throws SQLException, IOException {
		ServletDAO b=new ServletDAO();
		SignupBean expected=new SignupBean();
		expected.setName("venkat");
		expected.setGender("Male");
		expected.setDob("1990-10-10");
		expected.setEmail("nikhil2@gmail.com");
		expected.setPassword("venkat");
		expected.setEducation("B.Tech");
		 b.insert(expected);
		// b.getDetails("ramesh@gmail.com");
		 
	        SignupBean actual = b.getDetails("nikhil2@gmail.com");
	        System.out.println(actual);
	        assertEquals(expected.getEmail(), actual.getEmail());
	        assertEquals(expected.getEducation(), actual.getEducation());
	        assertNotSame(expected.getDob(), actual.getDob());
	        
	
    try {
       ServletDAO.deleteSignupBean("nikhil2@gmail.com");
    } catch (Exception e) {
    e.printStackTrace();
    }
}
	@Test
	public void testLogin() throws SQLException, IOException {
		ServletDAO b=new ServletDAO();
		SignupBean expected=new SignupBean();
		expected.setEmail("mamatha@gmail.com");
		expected.setPassword("mamatha");
		b.login(expected);
		 SignupBean actual = b.getDetails("mamatha@gmail.com");
	        System.out.println(actual);
	        assertEquals(expected.getEmail(), actual.getEmail());
	        assertEquals(expected.getPassword(), actual.getPassword());
		
		
	}
	}

