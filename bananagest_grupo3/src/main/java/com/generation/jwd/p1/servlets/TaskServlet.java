package com.generation.jwd.p1.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import com.generation.jwd.p1.beans.*;


@WebServlet("/createtask")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	private Context initContext;
	private Context envContext;
	private DataSource ds;	
       
    public TaskServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		Context initContext = null;
		Context envContext = null;
		ArrayList<Integer> users = new ArrayList<Integer>();
		
		try {
			
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();
			stmt = (PreparedStatement)conn.prepareStatement("SELECT id FROM user order by id asc");	
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				users.add((Integer)rs.getInt("id"));
			}		
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userList", users);
		request.getRequestDispatcher("createtask.jsp").forward(request, response);
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Task task = new Task();
		 
		 task.setName(request.getParameter("name"));
	     task.setDescription(request.getParameter("description"));
	     task.setDate_start(request.getParameter("date_start"));
	     task.setState(request.getParameter("state"));
	     task.setHours(Integer.parseInt(request.getParameter("hours")));
	     task.setId_user(Integer.parseInt(request.getParameter("id_user")));
	  
	     String q = "INSERT INTO task"
					+ "(id, name, date_start, description, state, hours, id_user)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	     
	     try {
		
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
			conn = (Connection) ds.getConnection();			
			stmt = (PreparedStatement)conn.prepareStatement(q);				
			stmt.setInt(1, task.getId());
			stmt.setString(2, task.getName());
			stmt.setString(3, task.getDate_start());
			stmt.setString(4, task.getDescription());
			stmt.setString(5, task.getState());
			stmt.setInt(6, task.getHours());
			stmt.setInt(7, task.getId_user());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
				
	     } catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{
	    	 
	    }
	     response.sendRedirect("homeuser");
//	     request.getRequestDispatcher("homeuser");	
	 }
}