<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../CSS/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request List</title>
</head>
<script type="text/javascript">
function gotoLogout(){
	window.location="Logout.SReq";
}
</script>
<body class="background" text="#000000" onload=>
<form action="ViewRequest.SReq" method ="post" name="frmRequestList">
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
<table width="100%" border="0" cellspacing="0" cellpadding="4">
	<tr>
		<td>
		<table width="100%" align="center" border="0" cellpadding="6"
			cellspacing="4" bgcolor="#ccffcc" class=outerTable>
			<tr align="center">
				<td class="tableHeader" align="center" colspan=4><b>Request
				Details</b></td>
			</tr>
			<tr>
				<td align="right" class="mainLabel">
				<table width="85%" border="2" cellspacing="2" cellpadding="2"
					class=outerTable align="center" id=TABLE1>
					<tr>
						<td class="tblHeader" width="10%" height="10">Request #</td>
						<td class="tblHeader" width="10%" height="10">User ID</td>
						<td class="tblHeader" width="10%" height="10">Request Type</td>
						<td class="tblHeader" width="10%" height="10">Requested Date</td>
						<td class="tblHeader" width="10%" height="10">Assigned Date</td>
						<td class="tblHeader" width="10%" height="10">Committed Date</td>
						<td class="tblHeader" width="10%" height="10">Completed Date</td>
						<td class="tblHeader" width="15%" height="10">Status</td>

					</tr>
					<c:if test="${ sessionScope.user.rollId == 1}">
						<c:forEach var="reqD" items="${requestScope.allReq }">
							<c:set var="id" value="${reqD.reqTypeID }"></c:set>
							<tr>
								<td class="tblDataText"> <a href="ViewRequest.SReq?reqId=<c:out
									value="${reqD.reqID}"/>" id="link"><c:out
									value="#${reqD.reqID}"/></a></td>
									<td class="tblDataText"><c:out value="${reqD.userID}"></c:out></td>
								<td class="tblDataText"> 
								<c:if test="${reqD.reqTypeID == 1}"><c:out value="Job Request"/></c:if>
								<c:if test="${reqD.reqTypeID == 2}"><c:out value="Software Request"/></c:if>
								<c:if test="${reqD.reqTypeID == 3}"><c:out value="Hardware Request"/></c:if>
								</td>
								<td class="tblDataText"><c:out
									value="${reqD.requestedDate}"></c:out></td>
								<td class="tblDataText"><c:out value="${reqD.assigndeDate}"></c:out></td>
								<td class="tblDataText"><c:out
									value="${reqD.committedDate}"></c:out></td>
								<td class="tblDataText"><c:out
									value="${reqD.completedDate}"></c:out></td>
								<td class="tblDataText">
								<c:if test="${reqD.statusID == 1}"><c:out value="Requested"/></c:if>
								<c:if test="${reqD.statusID == 2}"><c:out value="Cancelled"/></c:if>
								<c:if test="${reqD.statusID == 3}"><c:out value="Assigned"/></c:if>
								<c:if test="${reqD.statusID == 4}"><c:out value="Completed"/></c:if>
								<c:if test="${reqD.statusID == 5}"><c:out value="Rejected"/></c:if>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${ sessionScope.user.rollId == 2}">
						<c:forEach var="uReq" items="${requestScope.userReq }">
							<tr>
								<td class="tblDataText"><a href="ViewRequest.SReq?reqId=<c:out
									value="${uReq.reqID}"/>" id="link"><c:out
									value="#${uReq.reqID}"></c:out></a></td>
								<td class="tblDataText"><c:out value="${uReq.userID}"></c:out></td>
								<td class="tblDataText">
								<c:if test="${uReq.reqTypeID == 1}"><c:out value="Job Request"/></c:if>
								<c:if test="${uReq.reqTypeID == 2}"><c:out value="Software Request"/></c:if>
								<c:if test="${uReq.reqTypeID == 3}"><c:out value="Hardware Request"/></c:if>
								</td>
								<td class="tblDataText"><c:out
									value="${uReq.requestedDate}"></c:out></td>
								<td class="tblDataText"><c:out value="${uReq.assigndeDate}"></c:out></td>
								<td class="tblDataText"><c:out
									value="${uReq.committedDate}"></c:out></td>
								<td class="tblDataText"><c:out
									value="${uReq.completedDate}"></c:out></td>
								<td class="tblDataText">
								<c:if test="${uReq.statusID == 1}"><c:out value="Requested"/></c:if>
								<c:if test="${uReq.statusID == 2}"><c:out value="Cancelled"/></c:if>
								<c:if test="${uReq.statusID == 3}"><c:out value="Assigned"/></c:if>
								<c:if test="${uReq.statusID == 4}"><c:out value="Completed"/></c:if>
								<c:if test="${uReq.statusID == 5}"><c:out value="Rejected"/></c:if>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				</td>
			</tr>
		</table>
		<table align="center">
			<tr align="center">

				<td align="center">
				<div>
				<input type="button" value="Back" onclick="history.go(-1)" class="back">
				</div>
				</td>
				<td align="center">
				<div>
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