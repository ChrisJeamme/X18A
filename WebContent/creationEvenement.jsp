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

<h1>Création d'un événement</h1>

<form method="post" action="creerEvenement">
	<label for="nom">Nom de l'événement :</label>
	<br/>
	<input type="text" name="nom" id="nom" />
	<br/>
	
	<input class="bouton" value="Créer l'événement" type="submit">
	
</form>

</body>
</html>