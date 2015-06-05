<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'
	trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html>
<html lang='nl'>
<head>
<link rel='stylesheet' href='/retrovideo/styles/default.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrovideo</title>
</head>
<body>
	<a href="/retrovideo">Reserveren</a>
	<h1>Rapport</h1>
	<p>
		<c:forEach var="reservatie" items='${ReservatieGeluktMislukt}'>			
			<li>De reservatie is ${reservatie}</li>
		</c:forEach>


	</p>
</body>
</html>