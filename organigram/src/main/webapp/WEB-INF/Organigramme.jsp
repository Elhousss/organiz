<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Organigramme</title>
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
	</c:choose>		<br><br>
		
		<c:choose>
			<c:when test="${empty sessionScope.compte}">
			
				<div id="connexion">
					<form action="organigramme" method="post">
						<fieldset>
							<legend>Connexion :</legend>
										<span>${msg }</span>
							<table>
								<tr>
									<td>Login :</td>
									<td><input type="text" name="login" placeholder=" Votre login"></td>
								</tr>
								<tr>
									<td>Mot de passe :</td>
									<td><input type="password" name="pass" placeholder=" *******"></td>
								</tr>
								<tr>
									<td>
										<input type="submit" value="Se connecter" name="btnSeconnecter">
									</td>
								</tr>
							</table>
							<br>
							<b>Vous n'avez pas un compte ? <a href="inscription">Inscrivez-vous</a>	</b>
						</fieldset>
					</form>
				</div>
			
			</c:when>
			<c:otherwise>
				<h2>Organigramme : </h2>
			</c:otherwise>
		</c:choose>
		
	</body>
</html>