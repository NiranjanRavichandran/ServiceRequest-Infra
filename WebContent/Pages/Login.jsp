<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
 

<title>Service Request Login</title>
</head>
<script type="text/javascript">
window.history.forward();
	function validateLogin() {
		var isValidated = true;
		var userName = document.getElementById("uname").value;
		var password = document.getElementById("pass").value;
		if (userName.length == 0) {
	document.getElementById("unameError").innerText = "User ID is Empty";
		isValidated = false;
		
		}else{
			document.getElementById("unameError").innerText =" ";
		}
		if (password.length == 0) {
			document.getElementById("passError").innerText = "Password is Empty";
				isValidated = false;
				}else{
					document.getElementById("passError").innerText =" ";
				}
		return isValidated;
	}
	function onlyNumbers(evt) {
		var e = event || evt; // for trans-browser compatibility
		var charCode = e.which || e.keyCode;

		if (charCode > 31 && (charCode < 48 || charCode > 57)){
			alert("User Id contains only numbers!");
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
	<!-- <tr height="13%" align="left">
		<td colspan="3" class="blueBackGround"></td>
	</tr>
	<tr height="13%" align="left" valign="top">
		<td colspan="3" class="orangeBackGround"></td>
	</tr>-->
</table>
<hr size="3" color="#00008b"/>
<hr size="3" color="#DAECFF"/>
<form action="Login.SReq" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="3" height="15">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td></td>
				<td></td>
				<td width="10">&nbsp;</td>
			</tr>

			<tr>
				<td width="10">&nbsp;</td>
				<td colspan="2" align="center">
				<table border="0" cellpadding="6" cellspacing="4" bgcolor="#ccffcc"
					class=outerTable>
					<tr align="center">
						<td class="tableHeader" align="center" colspan=2>
						<c:if
							test="${requestScope.validated == false }">
							<span id="error" style="color: red;">Invalid Id or
							password </span>
						</c:if></td>
					</tr>
					<tr align="center">
						<td class="tableHeader" align="center" colspan=2><b>Enter
						Login Information</b></td>
					</tr>
					<tr>
						<td align="center" class="mainLabel">USER ID :</td>

						<td><input type="text" name="uname" id="uname"
							class="txbEnabledText" onkeypress="return onlyNumbers();"></td>
						<td><span id="unameError" style="color: red;"></span></td>
					</tr>
					<tr>
						<td align="center" class="mainLabel">PASSWORD :</td>

						<td><input type="password" name="pass" id="pass"
							class="txbEnabledText"></td>
						<td><span id="passError" style="color: red;"></span></td>
					</tr>
					<tr>
						<td align="right" colspan=2>
						<div align="center">
						<BUTTON type="submit" value="Login"
							onclick=" return validateLogin()">Login</BUTTON>
						&nbsp;
						<BUTTON name="btnClose" title="Close" onClick="window.close();">Close</BUTTON>
						</div>
						</td>
					</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td colspan=4>&nbsp;</td>
			</tr>
		</table>
</TABLE>
<table>
</table>

</form>
</body>
</html>