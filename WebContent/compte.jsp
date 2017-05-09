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

<jsp:useBean id="tmp" class="donnees.Utilisateur"></jsp:useBean>

	<header>
		<h1>Deal With It !</h1>
		<div class="bloc_connexion">
			<a class="btn btn-default" href="deconnexion"> <span class="glyphicon glyphicon-log-out"></span> Déconnexion</a>
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