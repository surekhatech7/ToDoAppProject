package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entities.ToDo;
import com.provider.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("todo_id"));
		String task = request.getParameter("task");
		String detail = request.getParameter("details");
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		ToDo todo = s.get(ToDo.class, id);
		todo.setTask(task);
		todo.setDetail(detail);
		tx.commit();
		s.close();
		response.sendRedirect("show_todo.jsp");
	}
}
