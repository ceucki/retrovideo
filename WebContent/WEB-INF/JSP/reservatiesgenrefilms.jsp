<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8'
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
	<h1>Reservaties</h1>
	<nav>
		<c:forEach var="genre" items="${genres}">
			<li><c:url value='/reservaties/films.htm' var='detailURL'>
					<c:param name='id' value="${genre.id}" />
				</c:url><a href="<c:out value='${detailURL}'/>">${genre.naam}</a></li>
		</c:forEach>
	</nav>

	<c:forEach var="film" items="${films}">
		<li><c:url value='/reservaties/reserveren.htm' var='detailURL'>
				<c:param name='id' value="${film.id}" />
			</c:url><a href="<c:out value='${detailURL}'/>"> <c:choose>
					<c:when test="${film.beschikbaar==0}">
						<img src="../images/${film.id}.jpg"
							title="${film.titel}&nbsp; Reserveren niet mogelijk">
					</c:when>
					<c:otherwise>
						<img src="../images/${film.id}.jpg"
							title="${film.titel}&nbsp; Reserveren mogelijk">
					</c:otherwise>
				</c:choose>
		</a></li>
	</c:forEach>
</body>
</html>