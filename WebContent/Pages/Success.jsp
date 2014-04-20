<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Success</title>
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
<c:if test="${requestScope.createdReqId != null}">
<P align=center><FONT face="Bookman Old Style"><FONT
		color=blue size=5><STRONG>Successfully created a Request!</STRONG></FONT></FONT></P>
<P align=center><FONT face="Bookman Old Style"><FONT
		color=mediumslateblue size=5><STRONG>Your Req ID - ${requestScope.createdReqId }</STRONG></FONT></FONT></P>
		</c:if>
<c:if test="${requestScope.updation == 1}">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
    	<tr align="center" >
			  <td class="tableHeader" align="center" colspan=4>
			  <b>Updated Request Details</b>
			  </td>
    	</tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request ID
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.updatedReq.reqID}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		 </tr>
			  <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Location
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.updatedReq.location}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
	    <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Cubical No.
			  </td>
			  <td align="left" class="mainLabel">
			  ${requestScope.updatedReq.cubicalNo}
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
					Department
				  </td>
				  <td align="left" class="mainLabel">
				  ${requestScope.updatedReq.department}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
		  	 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Required By
				  </td>
				  <td align="left" class="mainLabel">
				  ${requestScope.updatedReq.requiredByDate} 
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 		 <tr>
			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
			  <td align="left" class="mainLabel"  width="20%">
			  Request Type
			  </td>
			  <td align="left" class="mainLabel">
			  <c:if test="${requestScope.updatedReq.reqTypeID == 1}"><c:out value="Job Request"/></c:if>
			  <c:if test="${requestScope.updatedReq.reqTypeID == 2}"><c:out value="Software Request"/></c:if>
			  <c:if test="${requestScope.updatedReq.reqTypeID == 3}"><c:out value="Hardware Request"/></c:if>
			  </td>
			  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
	  	 </tr>
		 <tr>
		 			  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
		 			  <td align="left" class="mainLabel"  width="20%">
		 			  Justification
		 			  </td>
		 			  <td align="left" class="mainLabel">
		 			  ${requestScope.updatedReq.justification}
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
 <tr align="center" >
				  <td class="errorHeader" align="center" colspan=4>
				  <b>${requestScope.updateSuccess}</b>
				  </td>
			  </tr>
			  <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Status
				  </td>
				  <td align="left" class="mainLabel">
				   ${requestScope.updatedReq.statusID}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Committed Date
				  </td>
				  <td align="left" class="mainLabel">
				   ${requestScope.updatedReq.committedDate}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
 			<tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Completed Date
				  </td>
				  <td align="left" class="mainLabel">
				   ${requestScope.updatedReq.completedDate}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Rejection Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				${requestScope.updatedReq.rejectionReason}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
			 <tr>
				  <td align="right" class="mainLabel" width="30%">&nbsp;</td>
				  <td align="left" class="mainLabel"  width="20%">
				  Cancellation Reason
				  </td>
				  <td align="left" class="mainLabel">&nbsp;
 				${requestScope.updatedReq.cancellationReason}
				  </td>
				  <td align="right" class="mainLabel" width="20%">&nbsp;</td>
			 </tr>
    	</table>
    </td>
  </tr>
  
  </table>
  </c:if>
  <form>
  <table width="60%" align="center" border="0" cellpadding="6" cellspacing="4">
  <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="menu" title="menu" onClick="form.action='Menu.jsp';">Menu</BUTTON>&nbsp;
				<input type="button" value="Logout" onclick="gotoLogout()" class="back">
				</div>
				</td>
  		  </tr></table>
  </form>
</body>
</html>