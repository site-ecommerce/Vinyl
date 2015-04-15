<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<% //Affichage des produits %>

<!DOCTYPE html>
	<html>
		<head>
		</head>
		<body>


<c:if test="${ AllOrdersCustomer != null }">

<h1><span class="glyphicon glyphicon-inbox"> </span> Vos <span>commandes</span></h1>
		
	<ul class="thumbnails">
		<c:forEach items="${ AllOrdersCustomer }" var="order">
			<h4><c:out value="${order}"/> &euro;</h4>
			
			<h4>Frais de PORT : <c:out value="${1 + 0.02 * order.price}"/> &euro;</h4>
			<br>
	  	
	  		<c:if test="${ AllOrdersCustomer != null && CommandProducts != null }">
	  			<c:forEach items="${ CommandProducts }" var="CmdProd">
	  			
		  			<c:if test="${ CommandProducts != null && AllProducts != null }">
		  				
		  				<c:forEach items="${ AllProducts }" var="Prod">
		  				
		  					<c:if test="${CmdProd == Prod.id }">
			  					<ul class="thumbnails">
									<li class="span3"> 
										 <div class="thumbnail">		
												    
												    	<a href="<c:url value="/product">
															  <c:param name="productID" value="${ Prod.id }"/>
															</c:url>" class="thumb">
															<img src="./img/logo.png" alt="${Prod.label}">
															</a>
												      <div class="caption">
												        <h3><c:out value="${Prod.label}"></c:out></h3>
												        <p><c:out value="${Prod.label}"></c:out></p>  	
												        	<div id="nbEtoiles">
												        		Note du produit :
												        		<c:forEach var="etoile" begin="1" end="${Prod.stars}">
												        			<h6 class="glyphicon glyphicon-star"></h6>
												        		</c:forEach>
															</div>			
											
												        	<h4>Prix : <c:out value="${Prod.PRIX}"></c:out> <i class="glyphicon glyphicon-euro"></i> </h4>
												      <br>
												      <br>
												      </div>
												    </div>	     
												</li>
								  </ul>
		  					</c:if>
		  				</c:forEach>
		  			</c:if>
	  			
	  			</c:forEach>
	  		</c:if>
	  	
	  		<div style='margin-top:30px;'></div>
	 
		</c:forEach>
</ul>		
</c:if>

<c:if test="${ AllOrdersCustomer == null }">
	<h3> Vous n'avez toujours pas fait de commande chez nous :'(</h3>
</c:if>

<%@include file="footer.jsp" %>
</body>
</html>
