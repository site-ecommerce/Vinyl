<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>
<!DOCTYPE html>
	<html>
		<head>
		</head>
		<body>
<div class="products-list">
<div class="container">
  <div class="row">
    <div class="span12">
    <c:if test="${ categorySelected != null }">
		<h1><c:out value="${categorySelected.label}"/></h1>
		<p>
		<c:out value="${categorySelected.description}"/>
		</p>
		      <c:forEach items="${ productList }" var="product" varStatus="status">
		       <c:if test="${ categorySelected.categoryId == product.categoryId}">
				<li class="span3"> 
				    <div class="thumbnail">		
				    
				    	<a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>" class="thumb">
							<img src="./img/logo.png" alt="${product.label}">
							</a>
				      <div class="caption">
				        <h3><c:out value="${product.label}"></c:out></h3>
				        <p><c:out value="${product.label}"></c:out></p>
				        <p>
				        	     	
				        	<div id="nbEtoiles">
				        		Note du produit :
				        		<c:forEach var="etoile" begin="1" end="${product.stars}">
				        			<h6 class="glyphicon glyphicon-star"></h6>
				        		</c:forEach>
							</div>			
			
				        	<h5>Quantité :
				        		 <c:set var="quantite" value="1"/>
				        		 <input type="number" name="quantite" id="quantite" min="1" value="${quantite}"/ readonly>
				        	</h5>
				        	
				        	<h4>Prix : <c:out value="${product.PRIX}"></c:out> <i class="glyphicon glyphicon-euro"></i> </h4>
				        	 <a href="<c:url value="/myCart">
							  <c:param name="transaction" value="add"/>
							  <c:param name="productId" value="${product.id }"/>
							  <c:param name="quantite" value="${quantite}"/>
							</c:url>" class="btn btn-primary" role="submit">Ajouter au panier</a>
				       </p>
				      </div>
				    </div>	     
				</li>
				</c:if>
	  </c:forEach>
	</c:if>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>