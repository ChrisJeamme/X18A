<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Deal With It !</title>
	<link rel="stylesheet" href="style.css">
</head>

<body>

	<jsp:useBean id="tmp" class="donnees.Utilisateur"></jsp:useBean>

	<header>
		<h1>Deal With It !</h1>
		<div class="bloc_connexion">
			<a class="boutton" href="compte">Mon compte</a>
			<a class="boutton" href="deconnexion">Déconnexion</a>
		</div>
	</header>

	<nav id="bloc_navigation">
		<a class="boutton" href="mesEvenements">Mes événements</a>
		<a class="boutton" href="creationEvenement.jsp">Créer un évenement</a>
		<a class="boutton" href="mesDepenses">Mes opérations</a>
	</nav>

	<div>
		${ message } ${ utilisateur.prenom } !
	</div>


	<section class="dernieres_depenses">
	<h2>Mes dernières opérations</h2>	
		<c:forEach var="dep" items="${  depenses  }">
			<div id="evenement">
			    <span>${ dep.key.date }</span>
			    <br/>
			    <span>${ dep.value.nomEvenement }</span>
			    <br/>
			    <span>${ dep.key.description }</span>
			    <br/>
			    <span>${ dep.key.montant }&euro;</span>
			    <br/>
			</div>
		</c:forEach>
	
	</section>



</body>
</html>