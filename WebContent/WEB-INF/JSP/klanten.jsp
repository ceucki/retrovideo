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
	<a href="/retrovideo">Reserveren</a>
	<a href="/retrovideo/reservaties/filmbestellen.htm">Mandje</a>
	<h1>Klant</h1>
	<form>
		<label>Familienaam bevat: <span>${fout}</span><br /> <input
			type="text" name="zoekKlant" value="${param.zoekKlant}" required
			autofocus />
		</label><br /> <input type="submit" value="Zoeken" />
	</form>
	<form method="post">
		<c:if test='${not empty klanten }'>
			<table>
				<thead>
					<tr>
						<th>Naam</th>
						<th>Straat - Huisnummer</th>
						<th>Postcode</th>
						<th>Gemeente</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="klant" items="${klanten}">
						<tr>
							<th><c:url value='/bevestigen.htm' var='detailURL'>
									<c:param name='id' value="${klant.id}" />								

								</c:url><a href="<c:out value='${detailURL}'/>"><c:out
										value='${klant.familienaam} ' /> <c:out
										value='${klant.voornaam}' /></a></th>
							<th><c:out value='${klant.straatNummer}' /></th>
							<th><c:out value='${klant.postcode}' /></th>
							<th><c:out value='${klant.gemeente}' /></th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</form>
</body>
</html>