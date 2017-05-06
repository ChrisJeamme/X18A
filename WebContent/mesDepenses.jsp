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
<title>Mes opérations</title>
<link rel="stylesheet" href="style.css">
</head>

<body>

<jsp:useBean id="tmp1" class="donnees.Depense"></jsp:useBean>
<jsp:useBean id="tmp2" class="donnees.Evenement"></jsp:useBean>

<c:forEach var="dep" items="${  depenses  }">
	<div id="evenement">
	    <span>${ dep.key.date }</span>
	    <br/>
	    <span>${ dep.key.montant }</span>
	    <br/>
	    <span>${ dep.value.nomEvenement }</span>
	</div>
</c:forEach>


</body>
</html>