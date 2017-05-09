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
	<div class="progress">
	  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
	    Saisies des informations
	  </div>
	</div>
	
	<div class="alert alert-danger" role="alert">${ message }</div>
	
	<ul class="list-group">
	
		<form method="post" action="inscription">
			<div class="panel panel-primary">
			  <div class="panel-heading">Nom</div>
			  <div class="panel-body">
			    <input type="text" name="nom" id="nom" />
			  </div>
			</div>
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