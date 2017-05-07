<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="donnees.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deal With It !</title>
<link rel="stylesheet" href="style.css">
</head>

<body>

<jsp:useBean id="tmp" class="donnees.Evenement"></jsp:useBean>

<!--  Afficher les dépenses et tout le bordel ici -->

<h1>${ evenement.nomEvenement }</h1>

<c:forEach var="util" items="${  utilisateurs  }">
	<div id="utilisateurs">
	    <span>${ util.pseudo }</span>
	    <br/>
	</div>
</c:forEach>

<c:forEach var="dep" items="${  depenses  }">
	<div id="evenement">
	    <span>${ dep.key.date }</span>
	    <br/>
	    <span>${ dep.key.montant }</span>
	    <br/>
	    <span>${ dep.value.pseudo }</span>
	</div>
</c:forEach>

Ajouter une dépense
<br/>
${ erreurMontant }
<form method="post" action="ajoutDepense">
	<label for="description">Description :</label>
	<br/>
	<input type="text" name="description" id="description" />
	<br/>
	
	<label for="montant">Montant :</label>
	<br/>
	<input type="text" name="montant" id="montant" />
	<br/>
	
	<input class="bouton" value="Ajouter la dépense" type="submit">
	
</form>


<i>${ erreur }</i>

<form method="post" action="ajoutParticipant">
	<label for="nom">Ajouter un participant :</label>
	<br/>
	<input type="text" name="nom" id="nom" />
	<br/>
	
	<input class="bouton" value="Ajouter" type="submit">
	
</form>





</body>
</html>