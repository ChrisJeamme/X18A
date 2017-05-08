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
<title>Inscription</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h1>Inscription</h1>

<i>${ message }</i>
<form method="post" action="inscription">
	<label for="nom">Nom :</label>
	<br/>
	<input type="text" name="nom" id="nom" />
	<br/>
	
	<label for="prenom">Prénom :</label>
	<br/>
	<input type="text" name="prenom" id="prenom" />
	<br/>
	
	<label for="email">email :</label>
	<br/>
	<input type="text" name="email" id="email" />
	<br/>
	
	<label for="pseudo">Choisissez un pseudo :</label>
	<br/>
	<input type="text" name="pseudo" id="pseudo" />
	<br/>
	
	<label for="pass">Entrez un mot de passe :</label>
	<br/>
	<input type="password" name="pass" id="pass" />
	<br/>
	
	<input class="bouton" value="Inscription" type="submit">
</form>

</body>
</html>