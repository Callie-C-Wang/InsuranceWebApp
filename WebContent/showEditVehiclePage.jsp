<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Vehicle Info</title>
</head>
<body>
<h1 align="center"><font color="blue">Welcome to Insurance Operation System</font></h1>
<h3 align="center"><font color="blue">Edit Vehicle Info</font></h3>
<form action = "SaveVehicleDetail.do" method="post" id="vehicleInfoForm">
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
	<tr><td><input type="hidden" name="policyNo" value="${policyInfo.policyNo }"></td></tr>
	<tr>
		<td style="color:blue">Policy No</td>
		<td>${policyInfo.policyNo}</td>
	</tr>
	<tr>
		<td style="color:blue">VIN</td>
		<td>${policyInfo.vin }</td>
	</tr>
	<tr>
		<td style="color:blue">Coverage Amount</td>
		<td><input type = "text" id="coverageAmt" name = "coverageAmt" value = "${policyInfo.coverageAmt }"></td>
	</tr>
	<tr>
		<td style="color:blue">Producer</td>
		<td><input type = "text" id="make" name = "make" value = "${policyInfo.make }"></td>
	</tr>
	<tr>
		<td style="color:blue">Model</td>
		<td><input type = "text" id="model" name = "model" value = "${ policyInfo.model}"></td>
	</tr>
	<tr>
		<td style="color:blue">Type</td>
		<td><input type = "text" id="type" name = "type" value = "${policyInfo.type }"></td>
	</tr>
	<tr>
		<td style="color:blue">Year Of Make</td>
		<td><input type = "text" id="yearOfMake" name = "yearOfMake" value = "${policyInfo.yearOfMake }"></td>
	</tr>
	<tr>
		<td colspan="2"><button type = "submit" >Save</button></td>
	</tr>
	<tr>
		<td colspan="2"><button onclick='editCustomerDetail("${basciInfo.customerNo}")'>Return</button></td>
	</tr>
</table>
</form>

</body>
</html>