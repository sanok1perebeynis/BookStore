<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page session="false"%>
<html>
<head>
<title>Spring Template App</title>
<%@include file="imports.jsp"%>

</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<div class="page-header">
			<h1>Application bookstore</h1>
			<p class="lead">This app also uses mysql and bootstrap.</p>
		</div>

		<table class="table table-striped">
			<tr>
				<th>Action</th>
				<th>book ID</th>
				<th>bookname</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Price</th>
				<th>Email to contact</th>
			</tr>

			<c:forEach items="${bookList}" var="book" varStatus="ps">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/book/${book.bookname}"><button
								type="submit" class="btn btn-default">Open</button></a></td>
					<td><c:out value="${book.bookId}" /></td>
					<td><c:out value="${book.bookname}" /></td>
					<td><c:out value="${book.firstname}" /></td>
					<td><c:out value="${book.lastname}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><c:out value="${book.email}" /></td>
				</tr>
			</c:forEach>
		</table>

		<form class="form col-md-4" method="POST"
			action="${pageContext.request.contextPath}/createBook">


			<h4>Create book</h4>
			<div class="form-group">
				<input class="form-control" type="text" name="bookname"
					placeholder="Bookname">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="firstname"
					placeholder="Firstname">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="lastname"
					placeholder="Lastname">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="price" placeholder="Price">
			</div>


			<div class="form-group">
				<input class="form-control" type="text" name="email"
					placeholder="Email">
			</div>



			<button type="submit" class="btn btn-success">Submit</button>
		</form>


	</div>

</body>
</html>
