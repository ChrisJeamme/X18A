<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="donnees.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="UTF-8">
	<title>Deal With It !</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="http://anthony.jeamme.fr/css/resume_impress.css" media="print">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="style.css">
</head>

<body>

<header>
	<h1>Mes évenements</h1>
</header>

<section>
	<jsp:useBean id="tmp" class="donnees.Evenement"></jsp:useBean>
	
	<ul class="list-group">
	<c:forEach var="event" items="${  evenements  }">
		<li class="list-group-item list-group-item-sucess">
			<a href="evenement?ev=${ event.id }">	
			    <span class="glyphicon glyphicon-arrow-right"></span> ${ event.nomEvenement }
			    <br/>
			    <span class="glyphicon glyphicon-euro"></span> ${ event.budget }
			    <br/>
			    <br/>
			</a>
		</div>
	</c:forEach>
	</ul>
</section>

</body>
</html>