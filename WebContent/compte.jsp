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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon Compte</title>
<link rel="stylesheet" href="style.css">
</head>

<body>

<jsp:useBean id="tmp" class="donnees.Utilisateur"></jsp:useBean>

	<header>
		<h1>Deal With It !</h1>
		<div class="bloc_connexion">
			<a class="boutton" href="deconnexion">Déconnexion</a>
		</div>
	</header>

	<section>
		<h1>Mon Compte</h1>
		<div>
			<ul>
				<li>Pseudo : <b>${ utilisateur.pseudo }</b></li>
				<li>Prénom : <b>${ utilisateur.prenom }</b></li>
				<li>Nom : <b>${ utilisateur.nom }</b></li>
				<li>email : <b>${ utilisateur.email }</b></li>
			</ul>
		</div>
	</section>


</body>
</html>