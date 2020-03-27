<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New User</h1>
<form:form method="post" action="save">
	<table>
		<tr>
			<td>Firstname :</td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
		<tr>
			<td>Lastname</td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td>Username :</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:input path="password" /></td>
		</tr>


		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
