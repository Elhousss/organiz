<a href="home"><img alt="" src="${pageContext.request.contextPath}/assets/omnishore.png">
	</a>
	<span>${msg } &nbsp;&nbsp;&nbsp;</span>
	
	<c:choose>	
		<c:when test="${empty sessionScope.compte}">	
			
			<form action="home" method="post" name="frmConnexion">
				<div id="top">
					<table>
						<tr>
							<td>Login  </td>
							<td><input type="text" placeholder=" Nom d'utilisateur" name="login"/></td>
						</tr>
						<tr>
							<td>Mot de passe  </td>
							<td><input type="password" placeholder=" ********" name="pass"/></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn" type="submit" value="Se connecter" name="btnConnexion" />
								<input class="btn" type="submit" value="S'inscrire" name="btnInscription" />
							</td>
						</tr>
					</table>
					
				</div>
				
			</form>
			
		</c:when>
		<c:otherwise>
			<form action="deconnexion" method="post" name="frmConnexion">
				<div id="top">
					<table>
						<tr>
							Bienvenue <b>${sessionScope.compte.login }</b>
						</tr>
						<tr>
							<td>
								<input id="btnDeconnexion" type="submit" value="Déconnexion" name="btnDeconnexion" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	<div id="nav">
		<ul type="none">
			<li><a name="acceuil" class="nav" href="home">Acceuil</a>
			<li><a name="organigramme" class="nav" href="organigramme">Organigramme</a>
			<li><a name="acceuil" class="nav" href="home">MAJ Entité</a>
			<li><a name="organigramme" class="nav" href="organigramme">MAJ Responsable</a>
			<li><a name="organigramme" class="nav" href="organigramme">MAJ Collaborateur</a>
		</ul>
	</div>
	
	<br><br>
	<div>
	