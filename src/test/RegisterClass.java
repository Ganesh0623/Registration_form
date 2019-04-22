package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterClass extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		
		
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String fname=req.getParameter("first");
		String lname=req.getParameter("last");
		String cname=req.getParameter("clg");
		String ids=req.getParameter("sid");
int id=Integer.parseInt(ids);
		//pw.println("Enterd Student id is " +id);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system","Maisamma2306");
		
		Statement st = con.createStatement();
		String sql= String.format("Insert into Member Values('%s','%s','%s',%d)",fname,lname,cname,id);
		
		int i=st.executeUpdate(sql);
		System.out.println("Record Inserted"+i);
		pw.println("<h1>Congratulations, You are Successfully Registerd</h1>");
		
		
		pw.println("<a href='index.html'> main page</a>");
		
		con.close();
		
		
		
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
