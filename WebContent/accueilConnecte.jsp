<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<jsp:useBean id="tmp" class="donnees.Utilisateur"></jsp:useBean>

	<header>
		<h1>Deal With It !</h1>
		<div class="bloc_connexion">
			<a class="btn btn-default" href="compte"><span class="glyphicon glyphicon-user"></span> Mon compte</a>
			<a class="btn btn-default" href="deconnexion"><span class="glyphicon glyphicon-log-out"></span> Déconnexion</a>
		</div>
	</header>

	<nav id="bloc_navigation">
		<a class="btn btn-success btn-lg nav nav-tabs nav-justified" href="mesEvenements"><span class="glyphicon glyphicon-glass"></span>  Mes événements</a>
		<a class="btn btn-warning btn-lg nav nav-tabs nav-justified" href="creationEvenement.jsp"><span class="glyphicon glyphicon-plus"></span>  Créer un évenement</a>
		<a class="btn btn-info btn-lg nav nav-tabs nav-justified" href="mesDepenses"><span class="glyphicon glyphicon-euro"></span>  Mes opérations</a>
	</nav>

	<section>
	
	<div>
		<h4>${ message } ${ utilisateur.prenom } !</h4>
	</div>
	
	<h2> Mes dernières opérations</h2>	
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