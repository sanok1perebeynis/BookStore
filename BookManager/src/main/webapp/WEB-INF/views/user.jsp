<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Book</title>
<%@include file="imports.jsp"%>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<div class="page-header">
			<h1>Book</h1>
		</div>

		<form method="POST"
			action="${pageContext.request.contextPath}/updateBook">
			<h4>Update Book</h4>
			<input type="hidden" name="bookId" value="${book.bookId}">
			<div class="form-group">
				<input class="form-control" type="text" name="bookname"
					placeholder="Bookname" value="${book.bookname}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="firstname"
					placeholder="Firstname" value="${book.firstname}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="lastname"
					placeholder="Lastname" value="${book.lastname}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="price" placeholder="Price"
					value="${book.price}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="email"
					placeholder="Email" value="${book.email}">
			</div>
			<button type="submit" class="btn btn-warning">Update</button>
		</form>

		<form method="POST" action="${pageContext.request.contextPath}/deleteBook">
			<input type="hidden" name="bookId" value="${book.bookId}">
			<button type="submit" class="btn btn-danger">Delete</button>
		</form>


	</div>

</body>
</html>
