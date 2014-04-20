<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Create New Request</title>
</head>
<script type="text/javascript">
	function validate(){
		var isValid=true;
		var loc = document.getElementById("location").value;
		var dept =document.getElementById("dept").value;
		var reqT = document.getElementById("reqTy").value;
		var rbd = document.getElementById("rbd").value;
		var justy = document.getElementById("justy").value;
		var cube = document.getElementById("cube").value;
		if (loc == 0) {
			document.getElementById("locError").innerText = "*Select Location";
			isValid = false;
		}else{
			document.getElementById("locError").innerText=" ";
		}
		if (dept == 0) {
			document.getElementById("deptError").innerText = "*Select department";
			isValid = false;
		}else{
			document.getElementById("deptError").innerText=" ";
		}
		if (reqT == 0) {
			document.getElementById("reqTyError").innerText = "*Select request type";
			isValid = false;
		}else{
			document.getElementById("reqTyError").innerText=" ";
		}
		if (rbd.length == 0) {
			document.getElementById("rbdError").innerText = "*Enter date";
			isValid = false;
		}else{
			document.getElementById("rbdError").innerText=" ";
		}
		if (justy.length == 0) {
			document.getElementById("justyError").innerText = "*Enter justification";
			isValid = false;
		}else{
			document.getElementById("justyError").innerText=" ";
		}
		if (cube.length == 0) {
			document.getElementById("cubeError").innerText = "*Enter cubicle No.";
			isValid = false;
		}else{
			document.getElementById("cubeError").innerText=" ";
		}
		return isValid;
	}
	function date_validation(field){
		var checkstr = "0123456789";
		var DateField = field;
		var Datevalue = "";
		var DateTemp = "";
		var seperator = "-";
		var day;
		var month;
		var year;
		var leap = 0;
		var err = 0;
		var i;
		   err = 0;
		   DateValue = DateField.value;
		   
		   for (i = 0; i < DateValue.length; i++) {
			  if (checkstr.indexOf(DateValue.substr(i,1)) >= 0) {
			     DateTemp = DateTemp + DateValue.substr(i,1);
			  }
		   }
		   DateValue = DateTemp;
		  
		   if (DateValue.length == 6) {
		      DateValue = DateValue.substr(0,4) + '20' + DateValue.substr(4,2); }
		   if (DateValue.length != 8) {
		      err = 19;}
		   
		   year = DateValue.substr(4,4);
		   if (year == 0) {
		      err = 20;
		   }
		  
		   month = DateValue.substr(2,2);
		   if ((month < 1) || (month > 12)) {
		      err = 21;
		   }
		  
		   day = DateValue.substr(0,2);
		   if (day < 1) {
		     err = 22;
		   }
		  
		   if ((year % 4 == 0) || (year % 100 == 0) || (year % 400 == 0)) {
		      leap = 1;
		   }
		   if ((month == 2) && (leap == 1) && (day > 29)) {
		      err = 23;
		   }
		   if ((month == 2) && (leap != 1) && (day > 28)) {
		      err = 24;
		   }
		  
		   if ((day > 31) && ((month == "01") || (month == "03") || (month == "05") || (month == "07") || (month == "08") || (month == "10") || (month == "12"))) {
		      err = 25;
		   }
		   if ((day > 30) && ((month == "04") || (month == "06") || (month == "09") || (month == "11"))) {
		      err = 26;
		   }
		  
		   if ((day == 0) && (month == 0) && (year == 00)) {
		      err = 0; day = ""; month = ""; year = ""; seperator = "";
		   }
		   //write the completed date to Input-Field
		   if (err == 0) {
			   if(year >= (new Date().getFullYear()) && ((month-1)>= (new Date().getMonth()))&& (day > (new Date().getDate()))){
		      DateField.value = day + seperator + month + seperator + year;
			   }else{
				   alert("Date should be atleast one day away from today!");
			   }
		   }
		   //Error-message
		   else {
		      alert("Enter date in following format DD-MM-YYYY");
		      DateField.select();
			  DateField.focus();
		   }
		}
	function onlyNumbers(evt) {
		var e = event || evt; // for trans-browser compatibility
		var charCode = e.which || e.keyCode;

		if (charCode > 31 && (charCode < 48 || charCode > 57)){
			alert("Cubicle No. should be numerical!");
			return false;
			
		}

		return true;

	}
</script>
<body class="background" text="#000000">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="266" align="right" valign="top"><img
			src="../images/caritor.jpg" alt="SR" width="7%" height="100">
		</td>
	</tr>
	<tr>
		<td class="lblTitle" width="100%">
		<div id='DIVPageTitle'><b>Service Request System</b></div>
		</td>
	</tr>
</table>
<hr size="3" color="#00008b">
<hr size="3" color="#DAECFF">
<form method="post" name="frmCreateRequest" action="CreateRequest.SReq">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Create Service Request</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  <Select  name= "location" class="txbEnabledText" id ="location">
			   <Option value="0" selected="selected" disabled="disabled">--Select--</Option>
			   <Option value="CHN-DLF1">CHN-DLF1</Option>
			   <Option value="CHN-DLF2">CHN-DLF2</Option>
			   <Option value="CHN-DLF3">CHN-DLF3</Option>
			   <Option value="CHN-DLF4">CHN-DLF4</Option>
			   <Option value="CHN-PGR1">CHN-PGR1</Option>
			   <Option value="CHN-PGR2">CHN-PGR2</Option>
			   <Option value="CHN-PGR3">CHN-PGR3</Option>
			  </Select><span id="locError" style="color: red;"></span>
			  </td>
			  <td align="right" class="mainLabel" width="20%"></td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  <input type="text" name="cubicalNo" class="txbEnabledText" id="cube" onkeypress="return onlyNumbers();">
			  <span id="cubeError" style="color: red;"></span>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				  <Select  name= "department" class="txbEnabledText" id ="dept"> 
				  			   <Option value="0" selected="selected" disabled="disabled">--Select--</Option>
				  			   <Option value="Training">Training</Option>
				  			   <Option value="HR">HR</Option>
				  			   <Option value="Infrastructure">Infrastructure</Option>
				  			   <Option value="Delivery">Delivery</Option>
			  		</Select>
			  		<span id="deptError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  <input type="text" name="reqByDate" class="txbEnabledText" id="rbd" onblur="return date_validation(this)">
				  <span id="rbdError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
			   <Select name="reqType" class="txbEnabledText" id="reqTy">
			  				<Option value="0" selected="selected" disabled="disabled">--Select--</option>
			  				<c:forEach var="types" items="${sessionScope.reqTypes}">
			  				<Option value="${types.id }"><c:out value="${types.desc}"/></option>
			  				</c:forEach>
			  				<!-- <Option value="1">Job Request</option>
			  				<Option value="2">Software Request</option>
			  				<Option value="3">Hardware Request</option>-->
			  </select>
			  <span id="reqTyError" style="color: red;"></span>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		<!--  <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Description
			  </td>
			  <td align="left" class="mainLabel">
			   <textarea name="txtaDescription" class="txbEnabledText"></textarea>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr> -->
 
		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Justification
			  </td>
			  <td align="left" class="mainLabel">
			   <input type="text" name="just" class="txbEnabledText" id="justy">
			   <span id="justyError" style="color: red;"></span>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
 
		 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<input type="submit" name="btnSave" title="Login"
				onClick="return validate()" class="back" value="Create">&nbsp;
				<input type="button" value="Cancel" onclick="history.go(-1)" class="back">
				</div>
				</td>
  		  </tr>
		  <tr>
		  <td colspan=4 class="mainLabel">
		  <!-- Display the SR number here. This should be displayed only on
		  successful creation of the Request-->
		  <!-- Display error message here, In case of unsuccessful creation
		  of Request-->
		  </td>
		  </tr>
    	</table>
    </td>
  </tr>
  </table>
</form>
</body>
</html>