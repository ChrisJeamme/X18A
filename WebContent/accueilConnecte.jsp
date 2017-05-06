<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deal With It !</title>
<link rel="stylesheet" href="style.css">
</head>

<body>

<jsp:useBean id="tmp" class="donnees.Utilisateur"></jsp:useBean>

	<div id="bloc_connexion">
		<a class="boutton" href="compte">Mon compte</a>
		<a class="boutton" href="deconnexion">Déconnexion</a>
	</div>

Bonjour ${ utilisateur.prenom }

	<div id="bloc_navigation">
		<a class="boutton" href="mesEvenements">Mes événements</a>
		<a class="boutton" href="creerEvenement">Créer un évenement</a>
		<a class="boutton" href="mesDepenses">Mes opérations</a>
	</div>



</body>
</html>