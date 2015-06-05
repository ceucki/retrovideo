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
	<a href="/retrovideo/klant.htm">Klant</a>

	<h1>Bevestigen</h1>
	<p>${aantalFilms} film(s) voor ${volledigeNaam}</p>
	<form method="post">
		<input type="submit" value="Bevestigen" id="bevestigen" />
	</form>

	<script>
		document.getElementById('bevestigen').onsubmit = function() {
			document.getElementById('bevestigen').disabled = true;
		};
	</script>
</body>
</html>