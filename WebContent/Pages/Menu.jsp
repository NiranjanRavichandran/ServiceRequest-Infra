<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<title>Menu</title>
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
<P align=center><FONT face="Bookman Old Style"><FONT
	color=mediumslateblue size=5><STRONG>Welcome
${sessionScope.user.name}!</STRONG></FONT></FONT></P>
<c:set var="roleId" value="${sessionScope.user.rollId}"></c:set>
<c:if test="${roleId == 1}">
	<P align=center><FONT face="Bookman Old Style"><FONT
		color=mediumslateblue size=5><STRONG>SERVICES OFFERED</STRONG></FONT></FONT></P>
	<P align=center><FONT color=mediumslateblue><FONT
		face="Bookman Old Style"><FONT size=5><STRONG><A
		HREF="RequestList.SReq">View Service Requests</A></STRONG></FONT></FONT></FONT></P>
</c:if>
<c:if test="${roleId == 2}">
	<P align=center><FONT face="Bookman Old Style"><FONT
		color=mediumslateblue size=5><STRONG>SERVICES OFFERED</STRONG></FONT></FONT></P>
	<P align=center><FONT color=mediumslateblue><FONT
		face="Bookman Old Style"><FONT size=5><STRONG><A
		HREF="RequestList.SReq">View Service Requests</A></STRONG><br>
	<STRONG><A HREF="ReqType.SReq">Create New Request</A></STRONG> </FONT></FONT></FONT></P>
</c:if>
<table align="center">
			<tr align="center">
				<td align="center">
				<div>
				<input type="button" value="Logout" onclick="gotoLogout()" class="back">
				</div>
				</td>
			</tr>
		</table>
</body>
</html>