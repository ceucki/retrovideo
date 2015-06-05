<%@page contentType='text/html' pageEncoding='UTF-8' session='false'
	trimDirectiveWhitespaces="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<link rel='stylesheet' href='/retrovideo/styles/default.css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrovideo</title>
</head>
<body>

	<h1>Problemen bij het ophalen van data</h1>
	<img src='<c:url value="/images/datafout.jpg"/>' alt='data fout'>
	<p>
		We kunnen de gevraagde data niet ophalen wegens een technische
		storing.<br> Gelieve de helpdesk te contacteren.
	</p>
</body>
</html>