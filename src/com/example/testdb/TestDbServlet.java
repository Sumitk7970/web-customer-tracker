package com.example.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mariadb://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "org.mariadb.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Database");
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Success");
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	
	}

}
