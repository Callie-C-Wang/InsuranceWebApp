<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Vehicle</title>
</head>
<body>
<h1 align="center"><font color="blue">Welcome to Insurance Operation System</font></h1>
<h3 align="center"><font color="blue">Add New Vehicle Info</font></h3>
<form action = "InsertNewVehicle.do" method = "post" name="insertNewVehicleForm">
<table align = "center">
	<tr><td><input type="hidden" name="customerNo" value="${basciInfo.customerNo }"></td></tr>
	<tr>
		<td style="color:blue">Customer No</td>
		<td>${basciInfo.customerNo }</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td style="color:blue">Last Name</td>
		<td>${basciInfo.lastName }</td>
		<td style="color:blue">First Name</td>
		<td>${basciInfo.firstName }</td>
	</tr>
</table>
<table align = "center">
	<tr>
		<td style="color:blue">Policy No</td>
		<td><input type = "text" id="policyNo" name = "policyNo"></td>
	</tr>
	<tr>
		<td style="color:blue">VIN</td>
		<td><input type = "text" id="vin" name = "vin"></td>
	</tr>
	<tr>
		<td style="color:blue">Coverage Amount</td>
		<td><input type = "text" id="coverageAmt" name = "coverageAmt"></td>
	</tr>
	<tr>
		<td style="color:blue">Producer</td>
		<td><input type = "text" id="make" name = "make"></td>
	</tr>
	<tr>
		<td style="color:blue">Model</td>
		<td><input type = "text" id="make" name = "model"></td>
	</tr>
	<tr>
		<td style="color:blue">Type</td>
		<td><input type = "text" id="type" name = "type"></td>
	</tr>
	<tr>
		<td style="color:blue">Year Of Make</td>
		<td><input type = "text" id="yearOfMake" name = "yearOfMake"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><button type = "submit" >Save</button></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><a href="QueryAllCustomer.do">Return</a><td>
	</tr>
</table>
</form>
</body>
</html>