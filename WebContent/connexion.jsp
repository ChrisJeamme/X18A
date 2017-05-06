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
<title>Connexion</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<i>${ erreur }</i>
<form method="post" action="connexion">
	<label for="pseudo">Entrez votre pseudo :</label>
	<br/>
	<input type="text" name="pseudo" id="pseudo" />
	
	<br/>
	<label for="pass">Entrez votre mot de passe :</label>
	<br/>
	<input type="password" name="pass" id="pass" />
	<br/>
	<input class="bouton" value="Connexion" type="submit">
</form>

</body>
</html>