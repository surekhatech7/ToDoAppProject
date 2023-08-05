<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New ToDo Page</title>
<%@ include file="link.jsp"%>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<br>

	<div class="container">
		<h1>Please fill your Todo details.....</h1>
		<form action="SaveServlet" method="post">
		<div class="form-group">
			<label for="task">Add Task</label> 
			<input type="text" class="form-control" id="task" name="tname" placeholder="Enter New Task"> 
		</div>
		<div class="form-group">
			<label for="details">Task Details</label> 
			<textarea style="height:300px" id="details" name="details" class="form-control" placeholder="Enter Task details here..."></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Add New Task</button>
	</form>
	</div>

</body>
</html>