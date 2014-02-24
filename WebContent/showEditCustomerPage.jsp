<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function saveDetail(customerNo)
{	alert ("haha");
	var url = "SaveCustomerBasicInfo.do?customerNo="+customerNo;
	document.getElementById("customerInfoForm").action = url;	
	document.getElementById("customerInfoForm").method = get;	
    document.customerInfoForm.submit();
	
}


function addNewVehical(customerNo)
{	
	var url = "AddNewVehicle.do?customerNo="+customerNo;
	document.getElementById("customerInfoForm").action = url;	
	document.getElementById("customerInfoForm").method = "post";	
    document.customerInfoForm.submit();
	
}


function editVehicleDetail(policyNo,customerNo)
{	
	var url = "EditVehicleDetail.do?policyNo="+policyNo+"&customerNo="+customerNo;
	document.getElementById("customerInfoForm").action = url;	
	document.getElementById("customerInfoForm").method = "post";	
    document.customerInfoForm.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Customer Info</title>
</head>
<body>
	<h1 align="center"><font color="blue">Welcome to Insurance Operation System</font></h1>
  	<form action = "SaveCustomerBasicInfo.do" method="get" id="customerInfoForm">
  	<table align="center">	
		<tr>
			<td style="color:blue" colspan = "4" align ="left">
				<h3>Customer Info</h3>
	    	</td>
	  	</tr>
	  	<tr>
	  		<td style="color:blue" align = "left">Customer No</td>
	  		<td>${basciInfo.customerNo}</td>
	  		<td><input type="hidden" name="customerNo" id="customerNo" value="${basciInfo.customerNo}" type = "hidden"></td>
	  		<td></td>	  	
	  	</tr>
	  	<tr>
	  		<td style="color:blue" align = "left">First Name</td>
	  		<td><input type="text" name="firstName" id="firstName" value="${basciInfo.firstName}"></td>
	  		<td style="color:blue" align = "left">Last Name</td>
	  		<td><input type="text" name="lastName" id="lastName" value="${basciInfo.lastName}"></td>
	  	</tr>
	  	<tr>
	  		<td style="color:blue" align = "left">Sex</td>
	  		<td><input type="text" name="sex" id="sex" value="${basciInfo.sex}"></td>
	  		<td style="color:blue" align = "left">Date of Birth</td>
	  		<td><input  type="text" name="birth" id="birth" value="${basciInfo.birth}"></td>
	  	</tr>
	  	<tr>
	  		<td style="color:blue" align = "left">Email</td>
	  		<td><input type="text" name="email" id="email" value="${basciInfo.email}"></td>
	  		<td style="color:blue" align = "left">Mobile</td>
	  		<td><input type="text" name="mobile" id="mobile" value="${basciInfo.mobile}"></td>
	  	</tr>
	  	<tr>
	  		<td style="color:blue" align = "left">AAA Member</td>
	  		<td><input type="text" name="isAAAmember" id="isAAAmember" value="${basciInfo.isAAAmember}"></td>
	  		<td></td>
	  		<td></td>
	  	</tr>
	  	<tr>
	  		<!-- when value =000001,give to JS than change to 1,why? need quoto -->
	  		<td colspan="3"></td>
	  		<td align = "right"><button onclick='saveDetail(\"${basciInfo.customerNo}\")'>Save</button></td>
	  	</tr>
	  	<tr>
	  		<td colspan="3"></td>
	 	 	<td align = "right"><a href="QueryAllCustomer.do">Return</a></td>
	  	</tr>
	</table>
  	
  	<table align="center">    
		<tr>
		<td style="color:blue" colspan = "9" align ="left">
				<h3>Policy Info</h3>
	    </td>
	  	</tr>
        <tr>
        	<th></th>
            <th  style="color:blue">Policy No</th>
            <th  style="color:blue">Vehicle No</th>
            <th  style="color:blue">Producer</th>
            <th  style="color:blue">Type</th>
            <th  style="color:blue">Model</th>
            <th  style="color:blue">Year of Make</th>
            <th  style="color:blue">Coverage Amount</th>
            <th  style="color:blue">Edit Vehicle Detail</th>
        </tr>
    
       <c:forEach var="item" items="${policyInfoList}">
            <tr>
            <td><input type="hidden" name="customerNo" value="${item.policyNo}" ></td>
            <td>${item.policyNo}</td>
			<td>${item.vin}</td>
			<td>${item.make}</td>
			<td>${item.type}</td>			
			<td>${item.model}</td>
			<td>${item.yearOfMake}</td>
			<td>${item.coverageAmt}</td>
			<td>
				<button onclick='editVehicleDetail("${item.policyNo}","${basciInfo.customerNo}")'>Edit Vehicle Detail</button>
			</td>
            </tr>
    	</c:forEach>
	    <tr><td colspan="9" align="right">
	    	<button onclick='addNewVehical("${basciInfo.customerNo}")'>Add New Vehicle</button>
			<!--  <a href="AddNewVehicle.do">Add New Vehicle</a>  为什么就是不行呢-->
	    </td></tr>
</table>
</form>
</body>
</html>