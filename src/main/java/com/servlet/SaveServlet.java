package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.ToDo;
import com.provider.FactoryProvider;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("tname");
		String detail = request.getParameter("details");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ToDo t = new ToDo(task,detail,new Date()); 
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(t);
		
		tx.commit();
		s.close();
		
		out.println("<h1 style='text-align:center'>Your Task is Successfully Added</h1>");
		out.println("<h1><a href='show_todo.jsp'>View All Todo</a></h1>");
	}

}
