<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add company</title>
</head>
<body>
	This is add company .jsp page!
	<br /> ${action}

	<form action="${pageContext.request.contextPath}/companies/save" method="post">
		<table>
			<tbody>
				<tr>
					<td>Company name:</td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" id="address" name="address"></td>
				</tr>
				<tr>
					<td>
						<button id="save">Save</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form action="${pageContext.request.contextPath}/Welcome" method="post">
		<table>
				<tr>
					<td>
						<button id="save" "${pageContext.request.contextPath}/Welcome" >Home</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	
	
</body>
</html>