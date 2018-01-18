package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.generation.jwd.p1.beans.LoginBean;
import com.generation.jwd.p1.beans.Task;
import com.generation.jwd.p1.beans.User;



@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Context initContext = null;
		Context envContext = null;
		DataSource datasource = null;
		
		try {
			
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			datasource = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			connection = (Connection) datasource.getConnection();
			
		} catch(NamingException e) {
			
			System.out.println("Naming Exception: " + e.getMessage()W);		
		}
		
		try {
			
			connection = datasource.getConnection();
			stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM user WHERE id_user = ?");
//			int user_id = 1;//hardcodeado
//			stmt.setInt(1,user_id );
			rs = stmt.executeQuery();		
				 			
			while(rs.next()) {
				
			}			
			
			rs.close();
			stmt.close();
			connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}	
			
			
		}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doGet(request, response);
//	}

}
	}
}