<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Customer</title>
</head>
<body>
<h1 align="center"><font color="blue">Welcome to Insurance Operation System</font></h1>
<h3 align="center"><font color="blue">Add New Customer Info</font></h3>
	
<form action="AddNewCustomerBasic.do" method = "get" id="newCustomerInfoForm">
<table align="center">
	<tr>
		<td style="color:blue">Customer No</td>
		<td><input type = "text" id="customerNo" name = "customerNo"></td>
	</tr>
	
	<tr>
		<td style="color:blue">Last Name</td>
		<td><input type = "text" id="lastName" name = "lastName"></td>
	</tr>
	<tr>
		<td style="color:blue">First Name</td>
		<td><input type = "text" id="firstName" name = "firstName"></td>
	</tr>
	<tr>
		<td style="color:blue">Sex</td>
		<td><input type = "text" id="sex" name = "sex"></td>
	</tr>
	<tr>
		<td style="color:blue">Birth</td>
		<td><input type = "text" id="birth" name = "birth"></td>
	</tr>
	<tr>
		<td style="color:blue">Email</td>
		<td><input type = "text" id="email" name = "email"></td>
	</tr>
	<tr>
		<td style="color:blue">Mobile</td>
		<td><input type = "text" id="mobile" name = "mobile"></td>
	</tr>
	<tr>
		<td style="color:blue">AAA Member</td>
		<td><input type = "text" id="mobile" name = "isAAAmember"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><button type="submit">Save</button></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><a href="QueryAllCustomer.do">Return</a></td>
	</tr>
</table>

</form>
</body>
</html>