<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function editDetail(customerNo)
{
	var url = "EditCustomerDetail.do?customerNo="+customerNo;
	document.getElementById("customerInfoForm").action = url;	
    document.customerInfoForm.submit();
	
}

function addNewVehicle(customerNo)
{	
	var url = "AddNewVehicle.do?customerNo="+customerNo;
	document.getElementById("customerInfoForm").action = url;
	document.getElementById("customerInfoForm").method = "post";
    document.customerInfoForm.submit();
	
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Customer Info</title>
</head>
<body>
	<h1 align="center"><font color="blue">Welcome to Insurance Operation System</font></h1>
	<h3 align="center"><font color="blue">All Customer Info</font></h3>
	<form action = "EditCustomerDetail.do" method="post" id="customerInfoForm">
  	<table align="center">
        <tr>
        	<th></th>
            <th style="color:blue">Customer No</th>
            <th style="color:blue">First Name</th>
            <th style="color:blue">Last Name</th>
            <th style="color:blue">Sex</th>
            <th style="color:blue">Birth</th>
            <th style="color:blue">Email</th>
            <th style="color:blue">Mobile</th>
            <th style="color:blue">AAA member</th>
            <th style="color:blue">Edit Detail</th>
            <th style="color:blue">Add Vehicle</th>
        </tr>
    
       <c:forEach var="item" items="${resultList}">
            <tr>
            <td><input type="hidden" ></td>
            <td>${item.customerNo}</td>
			<td>${item.firstName}</td>
			<td>${item.lastName}</td>
			<td>${item.sex}</td>			
			<td>${item.birth}</td>
			<td>${item.email}</td>
			<td>${item.mobile}</td>
			<td>${item.isAAAmember}</td>
			
			<td><button onclick='editDetail("${item.customerNo}")'>Edit Detail</button></td><!--  -->
			<td><button onclick='addNewVehicle("${item.customerNo}")'>Add New Vehicle</button></td>
            </tr>
    	</c:forEach>
	    <tr>
	    <td colspan="10" align="right">
	    	<a href="AddNewPerson.do">Add New Person</a></td>
	    <td colspan="1" align="right">
	    	<a href="index.jsp">Return</a>
	    </td></tr>
</table>
</form>
</body>
</html>