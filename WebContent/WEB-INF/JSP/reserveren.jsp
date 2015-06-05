<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' 
	trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<link rel='stylesheet' href='/retrovideo/styles/default.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrovideo</title>
</head>
<body>

	<h1>Reserveren</h1>
	<c:choose>
		<c:when test='${empty film}'>
			<div>Titel niet gevonden</div>
		</c:when>
		<c:otherwise>
			<h1>${film.titel}</h1>
			<img src="../images/${film.id}.jpg" title="${film.titel}">
			<dl>
				<dt>Prijs</dt>
				<dd>€&nbsp; <fmt:formatNumber value="${film.prijs}"/></dd>
				<dt>Voorraad</dt>
				<dd><fmt:formatNumber value="${film.voorraad}"/></dd>
				<dt>Gereserveerd</dt>
				<dd><fmt:formatNumber value="${film.gereserveerd}"/></dd>
				<dt>Beschikbaar</dt>
				<dd><fmt:formatNumber value="${film.beschikbaar}"/></dd>
			</dl>
		</c:otherwise>
	</c:choose>
	
	
	<c:if test="${film.beschikbaar >0}">
	<form method="post">
		<input type="submit" id="mandje" value="In mandje" />
	</form>
	</c:if>
	
	<script>
		document.getElementById('mandje').onsubmit = function() {
			
			document.getElementById('mandje').disabled = true;
		};
	</script>
</body>
</html>