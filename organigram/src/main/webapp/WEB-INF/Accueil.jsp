<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/style.css"/>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.type}">
			<c:import url="Header.jsp"></c:import>
		</c:when>
		<c:otherwise>
			<c:import url="HeaderAdmin.jsp"></c:import>
		</c:otherwise>
	</c:choose>
		<fieldset>
			<p>
			Nom de l'entreprise : Omnishore <br>
			Secteur : Informatique <br>
			Description :
			
			Entreprise de service leader au Maroc dans le domaine <br>des Technologies de l’Information, Omnishore groupe MEDTECH est spécialisée dans le développement de logiciels : <br>Nous intervenons aussi bien sur le marché Marocain qu'à l'international.<br>
			Omnishore c’est aujourd’hui :  Une expérience probante  <br> de conception et de développement de systèmes d’informations bâtis sur les nouvelles architectures  <br>(SOA, Java J2EE, Framework, .Net, etc…) Un acteur Majeur dans les projets  <br>de l’Administration et dans le secteur de la finance Des expériences significatives  <br>dans l’offshoring IT et à l’international  <br>
			L'Offre de services d'Omnishore est organisée autour de 5 axes :  <br>Software Factory (Développement de logiciels) Java J2EE / Microsoft .Net /  <br>Open Source : étude et conception, développement d’applications, tests et recettes  <br>Centre de service Offshore / Nearshore Tierce Maintenance Applicative et  <br>Tierce Recette Applicative Assistance Technique et Mise à  <br>disposition de consultants (Régie) Expertise, Architecture et Conseils en SI.
		</fieldset>
	</div>
	
</body>
</html>