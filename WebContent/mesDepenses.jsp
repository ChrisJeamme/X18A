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

<jsp:useBean id="tmp1" class="donnees.Depense"></jsp:useBean>
<jsp:useBean id="tmp2" class="donnees.Evenement"></jsp:useBean>

<header>
	<h2> Mes opérations</h2>	
</header>
<section>
	<ul class="list-group">
	<c:forEach var="dep" items="${  depenses  }">
		<li class="list-group-item list-group-item-sucess">
		    <span class="glyphicon glyphicon-calendar"></span> ${ dep.key.date }
		    <br/>
		    <span class="glyphicon glyphicon-arrow-right"></span> ${ dep.value.nomEvenement }
		    <br/>
		    <span class="glyphicon glyphicon-info-sign"></span> ${ dep.key.description }
		    <br/>
		    <span class="glyphicon glyphicon-euro"></span> ${ dep.key.montant }&euro;
		    <br/>
		</li>
	</c:forEach>
	</ul>
</section>

</body>
</html>