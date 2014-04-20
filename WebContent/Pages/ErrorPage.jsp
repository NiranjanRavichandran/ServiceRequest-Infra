<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../Pages/style.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.history.forward();
function gotoLogout(){
	window.location="Logout.SReq";
}
</script>
<body>
<h2 style="color: red;">${requestScope.message}!</h2>
<table width="60%" align="center" border="0" cellpadding="6" cellspacing="4">
  <tr >
				<td align="center" colspan=4>
				<div align="center">
				<BUTTON name="menu" title="menu" onClick="form.action='Menu.jsp';">Menu</BUTTON>&nbsp;
				<input type="button" value="Logout" onclick="gotoLogout()" class="back">
				</div>
				</td>
  		  </tr></table>
</body>
</html>