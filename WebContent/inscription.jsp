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
	<h1>Inscription</h1>
</header>


<section>
	
	<c:if test="${ not empty message }">
		<div class="alert alert-danger" role="alert">${ message }</div>
	</c:if>
	<ul class="list-group">
	
		<form method="post" action="inscription">
		<li class="list-group-item">
			<label for="nom">Nom :</label>
			<input type="text" name="nom" id="nom" />
			<br/>
		</li>
		<li class="list-group-item">
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" id="prenom" />
			<br/>
		</li>
		<li class="list-group-item">
			<label for="email">Mail :</label>
			<input type="text" name="email" id="email" />
			<br/>
			
		</li>
		<li class="list-group-item">
			<label for="pseudo">Choisissez un pseudo :</label>
			<input type="text" name="pseudo" id="pseudo" />
			<br/>
			
		</li>
		<li class="list-group-item">
			<label for="pass">Entrez un mot de passe :</label>
			<input type="password" name="pass" id="pass" />
			<br/>
		</li>
			<input class="btn btn-default" value="Inscription" type="submit">
		</form>
		
	</ul>
</section>

</body>
</html>