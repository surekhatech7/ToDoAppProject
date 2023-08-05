<%@page import="com.provider.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page import="java.util.List" %>
<%@page import="com.entities.ToDo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show ToDo page</title>
<%@ include file="link.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>
<br>

<div class="container text-center">
	<h1>Show ToDo Page</h1>
	<%
		Session session1 = FactoryProvider.getFactory().openSession();
			List<ToDo> list = session1.createQuery("from ToDo",ToDo.class).list();
			for(ToDo t:list)
			{
	%>
		<div class="card" style="width:500px; margin-left:310px">
			<img class="card-img-top mx-auto mt-3" style="width:100px" src="image/todo.png" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title"><%= t.getTask() %></h5>
				<p class="card-text"><%= t.getDetail() %></p>
				<div class="container">
					<a href="DeleteServlet?todo_id=<%=t.getId() %>" class="btn btn-danger">Delete</a>
					<a href="update_todo.jsp?todo_id=<%=t.getId() %>" class="btn btn-primary">Update</a>
				</div>
			</div>
		</div>
	<%
		}
		session1.close();
	%>
</div>

</body>
</html>