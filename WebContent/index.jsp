<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<!-- Header contient la barre du haut avec titre, bouttons connexion etc. -->
	<header>
		<h1>Deal With It !</h1>
		<div class="bloc_connexion">
			<a class="btn btn-default" href="connexion.jsp"> <span class="glyphicon glyphicon-log-in"></span> Connexion</a>
			<a class="btn btn-default" href="inscription.jsp"> <span class="glyphicon glyphicon-plus"></span> Inscription</a>
		</div>
	</header>
	
	 <!-- Nav contient les liens vers toutes les pages (Chat, board etc.) -->
	<nav></nav>
	
	<!-- Section est la grosse partie centrale de la page qui contient tout contenu -->
	<section> 
		<div class="jumbotron">
			<h2> Bienvenue sur <b>DealWithIt</b></h2>
			<p> Vous pourrez gérer ici les dépenses de vos évenements de groupe</p>
			
			<p><a class="btn btn-sucess btn-lg" href="inscription.jsp" role="button">Inscrivez-vous</a></p>
		</div>

	</section>
	
	
	
	<!-- Footer, le pied de page -->
	<footer> 
	
	</footer>
</body>
</html>