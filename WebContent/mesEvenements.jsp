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
<title>Mes Evénements</title>
<link rel="stylesheet" href="style.css">
</head>

<body>

<h1>Mes événements</h1>

<jsp:useBean id="tmp" class="donnees.Evenement"></jsp:useBean>

<c:forEach var="event" items="${  evenements  }">
	<div id="evenement">
		<a href="evenement?ev=${ event.id }">	
			    <span>${ event.nomEvenement }</span>
			    <br/>
			    <span>${ event.budget }</span>
			    <br/>
			    <br/>
		</a>
	</div>
</c:forEach>


</body>
</html>