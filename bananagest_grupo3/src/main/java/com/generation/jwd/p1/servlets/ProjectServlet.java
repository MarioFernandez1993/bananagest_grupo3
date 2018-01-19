package com.generation.jwd.p1.servlets;

import com.generation.jwd.p1.beans.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProjectServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("projects.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = "0";
		int id_int = Integer.parseInt(id);
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Timestamp ts = Timestamp.valueOf(request.getParameter("date_start"));
		String date_start = request.getParameter("date_start");
		ts = Timestamp.valueOf(date_start);
		
		Timestamp ts2 = Timestamp.valueOf(request.getParameter("date_end"));
		String date_end = request.getParameter("date_end");
		ts2 = Timestamp.valueOf(date_end);
		
		String id_user = request.getParameter("id_user");
		
		if(name.isEmpty() || description.isEmpty() || date_start.isEmpty() || date_end.isEmpty() || id_user.isEmpty()) {
			
			//Si el formulario está vacío, manda un mensaje de error
			request.setAttribute("error", "Hay campos que están vacíos. Por favor, introduzca los datos correctos");
			request.getRequestDispatcher("/project").forward(request, response);
			
		} 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		Connection conn;
		PreparedStatement stmt;
		Context initContext;
		Context envContext;
		DataSource ds;
		
		try {	
			
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();
			stmt = (PreparedStatement)conn.prepareStatement("INSERT INTO proyect WHERE id = ?, name = ?, date_start = ?, date_end = ?, description = ?, id_user = ?");				
			stmt.setInt(1, id_int);
			stmt.setString(2, name);
			stmt.setTimestamp(3, ts);
			stmt.setTimestamp(4, ts2);
			stmt.setString(5, description);
			stmt.setString(6, id_user);
			stmt.executeUpdate();
				
							
		}catch(SQLException e) {
            
            System.out.println("Exception SQL: " + e.getMessage());
            
        } catch (NamingException e) {
           
           e.printStackTrace();
       }
	}

}
