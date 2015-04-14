<%@include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="span6">
				<h3>Créer un compte</h3>
				<form action="InscriptionServlet" method="post" class="map-form">
					  <label for ="#emailId">Email* :</label>
					  <input id="emailId" type="email" name="MAIL_ADDRESS" required="true" placeholder="Entrez votre email"/>
					 <br>
					  <label for ="#name">Nom* :</label>
					  <input id="name" type="text" name="NAME" required="true" placeholder="Entrez votre nom" />
					  <br>
					  <label for ="#firstname">Prénom* :</label>
					  <input id="firstname" type="text" name="FIRSTNAME" required="true" placeholder="Entrez votre prénom" />
					 <br>
					 <label for ="#date">Date de naissance* :</label>
					  <input id="date" type="date" name="DATE" required="true" placeholder="Entrez votre date de naissance" /> (01/01/1901)
					  <br>
					  <label for ="#address">Adresse* :</label>
					  <input id="addresss" type="text" name="ADDRESS" required="true" placeholder="Entrez votre adresse" />
					  <br>
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