<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Update</title>
</head>
<script type="text/javascript">

function disable(){
	var val = document.getElementById("selectBox").value;
	if (val == 5) {
		document.getElementById("reject").disabled="";
	}else{
		document.getElementById("reject").disabled="disabled";
	}
	
}
function validate(){
	
	var submit = true;
	var rej = document.getElementById("reject").value;
	var val = document.getElementById("selectBox").value;
	if (val == 0) {
		submit = false;
		document.getElementById("selectError").innerText = "*Select an option";
	}else{
		document.getElementById("selectError").innerText = "";
	}
	if (val == 5) {
		if (rej.length == 0) {
			submit = false;
			document.getElementById("rjError").innerText = "*Enter rejection reason";
		}else{
			document.getElementById("rjError").innerText = "";
		}
	}
	return submit;
}
function cancelVal(){
	var valid = true;
	var select = document.getElementById("userSelect").value;
	var cancel = document.getElementById("cancel").value;
	if (select == 0) {
		document.getElementById("canError").innerText = "*Select a choice";
		valid = false;
	}else{
		document.getElementById("canError").innerText = "";
	}
	if (cancel.length == 0) {
		valid = false;
		document.getElementById("cancelError").innerText = "*Enter cancellation reason";
	}else{
		document.getElementById("cancelError").innerText = "";
	}
	return valid;
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
<c:set var="roleId" value="${sessionScope.user.rollId}"></c:set>
<c:if test="${roleId == 1}">
<form action="SaveRequest.SReq" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Service Request Details</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request ID
			  </td>
			  <td align="left" class="mainLabel">
			  ${sessionScope.srDetails.reqID}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		 </tr>
			  <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  ${srDetails.location}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  ${srDetails.cubicalNo}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				  ${srDetails.department}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  ${srDetails.requiredByDate} 
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
			  <c:if test="${srDetails.reqTypeID == 1}"><c:out value="Job Request"/></c:if>
			  <c:if test="${srDetails.reqTypeID == 2}"><c:out value="Software Request"/></c:if>
			  <c:if test="${srDetails.reqTypeID == 3}"><c:out value="Hardware Request"/></c:if>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		 <tr>
		 			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
		 			  <td align="left" class="mainLabel"  width="20%">
		 			  Justification
		 			  </td>
		 			  <td align="left" class="mainLabel">
		 			  ${srDetails.justification}
		 			  </td>
		 			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	  </table>
	  <BR>
 
 
	  	<table  width="55%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
 <tr align="center" >
				  <td class="errorHeader" align="center" colspan=4>
				  <b>${requestScope.updateFail}</b>
				  </td>
			  </tr>
			  <tr align="center" >
				  <td class="tableHeader" align="center" colspan=4>
				  <b>Status Details</b>
				  </td>
			  </tr>
 
			  <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Status
				  </td>
				  <td align="left" class="mainLabel">
				   <select name="newStatus" onchange="disable()" id="selectBox">
				   <option selected="selected" disabled="disabled">--Select--</option>
				   <option value="3">Assigned</option>
				   <option value="4">Completed</option>
				   <option value="5">Rejected</option>
				   </select>
				   <span id="selectError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="10%">
				  Rejection Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				<input type="text" name="rejection" id="reject">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 				
 				<span id="rjError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="10%"></td>
			 </tr>
 
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Committed Date
				  </td>
				  <td align="left" class="mainLabel">
				   ${srDetails.committedDate}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 
 
			 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="btnSave" title="SaveSR" onclick="return validate()">Save</BUTTON>&nbsp;
				<input type="button" value="Back" onclick="history.go(-1)" class="back">
				</div>
				</td>
  		  </tr>
 
    	</table>
    </td>
  </tr>
  </table>
</form>
</c:if>
<!--    -----------For Employee---------------   -->
<c:if test="${roleId == 2}">
<form action="SaveRequest.SReq" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Service Request Details</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request ID
			  </td>
			  <td align="left" class="mainLabel">
			  ${sessionScope.srDetails.reqID}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		 </tr>
			  <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  ${srDetails.location}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  ${srDetails.cubicalNo}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				  ${srDetails.department}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  ${srDetails.requiredByDate} 
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
			  <c:if test="${srDetails.reqTypeID == 1}"><c:out value="Job Request"/></c:if>
			  <c:if test="${srDetails.reqTypeID == 2}"><c:out value="Software Request"/></c:if>
			  <c:if test="${srDetails.reqTypeID == 3}"><c:out value="Hardware Request"/></c:if>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		 <tr>
		 			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
		 			  <td align="left" class="mainLabel"  width="20%">
		 			  Justification
		 			  </td>
		 			  <td align="left" class="mainLabel">
		 			  ${srDetails.justification}
		 			  </td>
		 			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	  </table>
	  <BR>
 
 
	  	<table  width="55%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
 <tr align="center" >
				  <td class="errorHeader" align="center" colspan=4>
				  <b>${requestScope.updateFail}</b>
				  </td>
			  </tr>
			  <tr align="center" >
				  <td class="tableHeader" align="center" colspan=4>
				  <b>Status Details</b>
				  </td>
			  </tr>
 
			  <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Status
				  </td>
				  <td align="left" class="mainLabel">
				   <select name="newStatus" id="userSelect">
				   <option selected="selected" disabled="disabled" value="0">--Select--</option>
				   <option value="2">Cancelled</option>
				   </select>
				   <span id="canError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Cancellation Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				<input type="text" name="cancellation" id="cancel">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 				
 				<span id="cancelError" style="color: red;"></span>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Committed Date
				  </td>
				  <td align="left" class="mainLabel">
				   ${srDetails.committedDate}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 
 
			 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="btnSave" title="SaveSR" onclick="return cancelVal()">Save</BUTTON>&nbsp;
				<input type="button" value="Back" onclick="history.go(-1)" class="back">
				</div>
				</td>
  		  </tr>
 
    	</table>
    </td>
  </tr>
  </table>
</form>
</c:if>
</body>
</html>