
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="span6">
				<h3>Se connecter</h3>
				<c:if test="${ errorMessage != null }">
				    <c:out value="${errorMessage}"/>
				</c:if>
				 <form action="loginServlet" method="post" class="map-form">
					 <label for ="#emailId" class="control-label">Email</label>
					  <input id="emailId" type="text" name="MAIL_ADDRESS" required="true" 
					  placeholder="Entrez votre email" />
					  <label for ="passwordId" class="control-label">Mot de passe</label>
					  <input id="passwordId" type="text" name="PASSWORD" type="password" required="true" 
					  placeholder="Mot de passe" />
					  <div class="control-group no-margin">
					  <button id="loginB" type="submit" name="connection" class="btn">Se connecter</button>
					  </div>
				</form>
			</div>
			<div class="span6">
				<h3>Créer un compte</h3>
				<form action="login" method="post" class="map-form">
					  <label for ="#login">Login* :</label>
					  <input id="login" type="text" name="LOGIN" required="true" 
					  placeholder="Entrer votre login" />
					  <label for ="#emailId">Email* :</label>
					  <input id="emailId" type="email" name="MAIL_ADDRESS" required="true" 
					  placeholder="Entrez votre email"/>
					  <label for ="passwordId">Mot de passe* :</label>
					  <input id="passwordId" type="text" name="PASSWORD" type="password" required="true" 
					  placeholder="Mot de passe" />
					  <label for ="passwordConf">Confirmation* :</label>
					  <input id="passwordConf" type="text" name="PASSWORD_CONF" type="password" required="true" 
					  placeholder="Confirmez votre mdp" />
					    <label for ="#name">Nom* :</label>
					  <input id="name" type="text" name="NAME" required="true" 
					  placeholder="Entrez votre nom" />
					  <label for ="#firstname">Prénom* :</label>
					  <input id="firstname" type="text" name=FIRSTNAME required="true" 
					  placeholder="Entrez votre prénom" />
					  <label for ="#date">Prénom* :</label>
					  <input id="date" type="text" name=DATE required="true" 
					  placeholder="Entrez votre date de naissance" /> (01/01/1901)
					  <label for ="#address">Adresse* :</label>
					  <input id="addresss" type="text" name="ADDRESS" required="true" 
					  placeholder="Entrez votre adresse" />
					  <div class="control-group no-margin">
					  <button id="loginB" type="submit" name="creation" class="btn">Créer mon compte</button>
					  </div>
				</form>
				<p>* Champs obligatoires</p>
			</div>
		</div>
	</div>
<%@include file="footer.jsp" %>
	</body>
</html>