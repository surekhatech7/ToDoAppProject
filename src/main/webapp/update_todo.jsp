<%@page import="org.hibernate.Transaction"%>
<%@page import="com.entities.ToDo"%>
<%@page import="java.util.List"%>
<%@page import="com.provider.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>
<%@ include file="link.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<br>
		<%
			int id = Integer.parseInt(request.getParameter("todo_id"));
			Session session1 = FactoryProvider.getFactory().openSession();
			Transaction tx = session1.beginTransaction();

			ToDo todo = session1.get(ToDo.class, id);
		%>
		<h3 class="text-center text-uppercase text-primary">Update your
			details</h3>

		<br>
		<hr>

		<form action="UpdateServlet" method="post">

			<input type="hidden" value="<%=todo.getId()%>" name="todo_id">
			<div class="form-group">

				<label for="task">Add Task</label> <input type="text" name="task"
					class="form-control" id="task" placeholder="Enter Your task"
					value="<%=todo.getTask()%>">

			</div>
			<div class="form-group">
				<label for="details">Task Details</label>
				<textarea rows="5" id="details" name="details" class="form-control"
					placeholder="Enter Task Details here"><%=todo.getDetail()%></textarea>
			</div>

			<button type="submit" class="btn btn-success">Update Task</button>
		</form>
		<%
			session1.close();
		%>

	</div>

</body>
</html>
