<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'
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
	<a href="/retrovideo">Reserveren</a>
	<a href="/retrovideo/klant.htm">Klant</a>
	<h1>Mandje</h1>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th>Film</th>
					<th>Prijs</th>
					<th><input type="submit" value="Verwijderen"
						name="Verwijderen" /></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Totaal: </th>
					<th>€ <fmt:formatNumber value="${totalePrijs}"/></th>
					<th></th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var='film' items='${filmsInMandje}'>
					<tr>
						<th><c:out value='${film.titel}' /></th>
						<th>€ <fmt:formatNumber value="${film.prijs}"/></th>
						<th><input type="checkbox" name="id" value="${film.id}"/></th>
					</tr>
				</c:forEach>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>