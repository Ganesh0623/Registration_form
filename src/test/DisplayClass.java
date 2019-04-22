package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayClass extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		
		
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	
	pw.println("<strong>Registered members are :</strong>");
	
	pw.println("<table border='2'><thead><tr><th>Name    </th> <th>College Name    </th> <th>Student ID</th></tr></thead>");
	
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system","Maisamma2306");
	
	Statement st = con.createStatement();
	String sql= "Select * from Member";
	
	ResultSet rs= st.executeQuery(sql);
	while(rs.next())
	{
	pw.println("<tbody><tr><td>");
		pw.print(rs.getString(1));
		pw.println("</td><td>");
		pw.print(rs.getString(3));
		pw.println("</td><td>");
		
		pw.print(rs.getString(4));
		pw.println("</td></tr>");
		
		
		
		
		
		
		
		
	}
	
	
	con.close();
	
	
	
	
	
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
	
	
	
	pw.println("</br></br><a href='index.html'> main page</a>");
	
	
	
	}
	
	
	
	
	
	
	

}
