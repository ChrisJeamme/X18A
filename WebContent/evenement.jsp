<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<jsp:useBean id="tmp" class="donnees.Evenement"></jsp:useBean>

<!--  Afficher les dépenses et tout le bordel ici -->

<header>
	<h1>${ evenement.nomEvenement }</h1>
</header>

 	<nav id="bloc_navigation">
		<a class="btn btn-success btn-lg nav nav-tabs nav-left" href="AccueilConnecte"><span class="glyphicon glyphicon-chevron-left"></span>  Accueil  </a>
	</nav>

<section>
	<h2><span class="glyphicon glyphicon-user"></span> Participants</h2>
	<ul class="list-group">
	<c:forEach var="util" items="${  utilisateurs  }">
	    <li class="list-group-item list-group-item-info">${ util.pseudo }</li>
	</c:forEach>
	</ul>
	
	<h2><span class="glyphicon glyphicon-euro"></span> Dépenses</h2>
	<ul class="list-group">
	<c:forEach var="dep" items="${  depenses  }">
		<li class="list-group-item list-group-item-warning">
		    <span class="glyphicon glyphicon-calendar"></span> <b>${ dep.key.date }</b>
		    <br/>
		    <span class="glyphicon glyphicon-arrow-right"></span> ${ dep.key.description }
		    <br/>
		    <span class="glyphicon glyphicon-euro"></span>  ${ dep.key.montant } €
		    <br/>
		    <span class="glyphicon glyphicon-user"></span> ${ dep.value.pseudo }
		</li>
	</c:forEach>
	</ul>

	
	<div id="Global">
		<div id="Gauche">
			<h2>Ajouter une dépense</h2>
			<c:if test="${ not empty erreurMontant }">
				<div class="alert alert-danger" role="alert">${ erreurMontant }</div>
			</c:if>
			<form method="post" action="ajoutDepense">
				<label for="description">Description :</label><br />
				<input type="text" name="description" id="description" />
				<br/>
				
				<label for="montant">Montant :</label>
				<br/>
				<input type="text" name="montant" id="montant" />
				<br/>
				<input class="btn btn-default" value="Ajouter la dépense" type="submit">	
			</form>
		</div>
		<div id="Droite">
			<c:if test="${ not empty erreur }">
			 <span class="alert alert-danger">${ erreur }</span>
			</c:if>
			<c:if test="${ not empty utilisateurParticipe }">
			 <span class="alert alert-danger">${ utilisateurParticipe }</span>
			</c:if>
			<br/>
			<h2>Ajouter un participant :</h2>
			<form method="post" action="ajoutParticipant">
				<label for="nom">Pseudo du participant :</label><br />
				<input type="text" name="nom" id="nom" />
				<br/>
				
				<input class="btn btn-default" value="Ajouter ce participant" type="submit">
			</form>
		</div>
	</div>
</section>

</body>
</html>