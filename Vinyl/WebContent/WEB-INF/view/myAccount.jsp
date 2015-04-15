<%@ include file="header.jsp" %>
<% //Affichage des produits %>

<h1><span class="glyphicon glyphicon-briefcase"> </span> Mon <span>compte</span></h1>
		<fieldset>
			<legend>Vos informations :</legend>
				<div>
				<c:if test="${ customer != null }">
				
        		<form action="updateCustom" method="post" class="map-form">
        			   <input id="IdCustomer" type="hidden" name="IdCustomer" value="${customer.customerId}" />	
					  <label for ="#emailId">Email :</label>
					  <input id="emailId" type="email" name="MAIL_ADDRESS" required="true" value="${customer.mail}" placeholder="Entrez votre email"/>
					 <br>
					  <label for ="#name">Nom :</label>
					  <input id="name" type="text" name="NAME" required="true" value="${customer.lastname}" placeholder="Entrez votre nom" />
					  <br>
					  <label for ="#firstname">Prénom :</label>
					  <input id="firstname" type="text" name="FIRSTNAME" required="true" value="${customer.firstname }" placeholder="Entrez votre prénom" />
					 <br>
					 <label for ="#date">Date de naissance :</label>
					  <input id="date" type="date" name="DATE" required="true" value="${customer.birthDate}" placeholder="Entrez votre date de naissance" /> (01/01/1901)
					  <br>
					  <label for ="#address">Adresse :</label>
					  <input id="addresss" type="text" name="ADDRESS" required="true" value="${customer.address}" placeholder="Entrez votre adresse" />
					  <br>
					  <div class="control-group no-margin">
					  <button id="loginB" type="submit" name="creation" class="btn" >Modifier les valeurs</button>
					  </div>
				</form>
				</c:if>
      		</div>
	</fieldset>
			
	




<%@include file="footer.jsp" %>
