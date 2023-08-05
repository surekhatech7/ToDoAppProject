package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.ToDo;
import com.provider.FactoryProvider;

public class DeleteServlet extends HttpServlet { 
	  
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	   

		int id = Integer.parseInt(request.getParameter("todo_id"));
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		ToDo t = s.get(ToDo.class, id);
		s.delete(t);
		tx.commit();
		s.close();
		response.sendRedirect("show_todo.jsp");
	}

}
