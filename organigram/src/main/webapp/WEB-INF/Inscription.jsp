<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/style.css"/>
</head>
<body>
	<a href="home"><img alt="" src="${pageContext.request.contextPath}/assets/omnishore.png">
	</a>
	
	<br><br>
	<div id="nav">
		<ul type="none">
			<li><a name="acceuil" class="nav" href="home">Acceuil</a>
			<li><a name="organigramme" class="nav" href="organigramme">Organigramme</a>
		</ul>
	</div>
	<br><br>
		<center>
			<fieldset>
			<legend><h2>Inscription :</h2></legend>
			<br>
				<form name="frmInscription" action="inscription" method="post">
					<table cellpadding="8">
						<tr>
							<td>
								<label for="">Login :</label>
							</td>
							<td>
								<input type="text" value='<c:out value="${compte.login}"></c:out>' name="login"><span><font color="red"> *</font></span>
								<span class="erreur">${erreurs['login']}</span>
							</td>
						</tr>
						<tr>
							<td>
								<label for="">Email :</label>
							</td>
							<td>
								<input type="text" value='<c:out value="${compte.email}"></c:out>'  name="email"><span><font color="red"> *</font></span>
								<span class="erreur">${erreurs['email']}</span>
							</td>
						</tr>
						<tr>
							<td>
								<label for="">Mot de passe :</label>
								
							</td>
							<td>
								<input type="password" name="pass"><span><font color="red"> *</font></span>
								<span class="erreur">${erreurs['pass']}</span>
							</td>
						</tr>
						<tr>
							<td>
								<label for="">Confirmation :</label>
							</td>
							<td>
								<input type="password" name="confirmation"><span><font color="red"> *</font></span>
							</td>
						</tr>
						<tr>
							<td>
								<label for="">Nom :</label>
							</td>
							<td>
								<input type="text" value='<c:out value="${compte.nom}"></c:out>' name="nom">
								<span class="erreur">${erreurs['nom']}</span>
							</td>
						</tr>
						<tr>
							<td>
								<label for="">Prenom :</label>
							</td>
							<td>
								<input type="text" value='<c:out value="${compte.prenom}"></c:out>' name="prenom">
								<span class="erreur">${erreurs['prenom']}</span>
							</td>
						</tr>
						
					</table>
					<input class="btnInsc" type="submit" value="Valider" name="creerCompte">
					<input class="btnInsc" type="reset" value="Vider les champs" name="reset">
					<br><br>
				</form>
			</fieldset>
		</center>
		<br>
	</body>
</html>