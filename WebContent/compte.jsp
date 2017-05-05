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
<title>Mon Compte</title>
</head>

<body>

<jsp:useBean id="utilisateur" class="donnees.Utilisateur"></jsp:useBean>

<h1>Mon Compte</h1>

<ul>
	<li>Pseudo : <b>${ u.pseudo }</b></li>
	<li>Prénom : <b>${ u.prenom }</b></li>
	<li>Nom : <b>${ u.nom }</b></li>
	<li>email : <b>${ u.email }</b></li>
</ul>


</body>
</html>