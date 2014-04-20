<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Request Details</title>
</head>
<script type="text/javascript">
function gotoLogout(){
	window.location="Logout.SReq";
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
<c:set var="srObj" value="${requestScope.srDetails}"></c:set>
<form method="post" action="Update.jsp">
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
				   <c:if test="${srDetails.statusID == 1}"><c:out value="Requested"/></c:if>
				   <c:if test="${srDetails.statusID == 2}"><c:out value="Cancelled"/></c:if>
				   <c:if test="${srDetails.statusID == 3}"><c:out value="Assigned"/></c:if>
				   <c:if test="${srDetails.statusID == 4}"><c:out value="Completed"/></c:if>
				   <c:if test="${srDetails.statusID == 5}"><c:out value="Rejected"/></c:if>
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Rejection Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				${srDetails.rejectionReason}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Cancellation Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				${srDetails.cancellationReason}
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
 			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Completed Date
				  </td>
				  <td align="left" class="mainLabel">
				   ${srDetails.completedDate}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="btnSave" title="SaveSR">Update</BUTTON>&nbsp;
				<input type="button" value="Back" onclick="history.go(-1)" class="back">&nbsp;
				<input type="button" value="Logout" onclick="gotoLogout()" class="back">
				</div>
				</td>
  		  </tr>
 
    	</table>
    </td>
  </tr>
  </table>
</form>

</body>
</html>