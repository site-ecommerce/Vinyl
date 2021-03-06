<%@ include file="header.jsp" %>
<% //Affichage des produits %>

<c:choose>
<c:when test="${ productFoundList != null }">
<div class="products-list">
  <div class="container">
<h1> Produits recherch�s :</h1>
<ul class="thumbnails">
<c:forEach items="${ productFoundList }" var="product" varStatus="status">
				<li class="span3"> 
				    <div class="thumbnail">		
				    
				    	<a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>" class="thumb">
							<img src="./img/miniature.jpg" alt="${product.label}">
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
			
				        	<h5>Quantit� :
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
</c:forEach>
</ul>
</div>
</div>
<%
session.removeAttribute("productFoundList");
%>
</c:when>
<c:otherwise>
<div class="products-list">
  <div class="container">
    <h3><span class="glyphicon glyphicon-thumbs-up"> </span>  Notre <span>S�lection</span></h3>
    <ul class="thumbnails">
      <c:forEach items="${ productList }" var="product" varStatus="status">
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
			
				        	<h5>Quantit� :
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
	  </c:forEach>
    </ul>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="span12">
      
      <!-- Portfolio Columns -->
      <div class="products-list products-list-simple">
        <h2 class="text-center margin-top margin-bottom">Derniers <span>Produits</span></h2>
        <ul class="thumbnails">
          
          <!-- Products Single Box -->
           <c:forEach items="${ productList }" var="product" varStatus="status">
				<li class="span3"> 
					<div class="thumbnail"><a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>" class="thumb">
							<img src="http://placehold.it/350x150">
							</a>
			          <p><a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>"><c:out value="${product.label}"></c:out></a></p>
			          <p class="price">&euro; <c:out value="${product.PRIX}" /> </p>
		            </div>	    				     
				</li>
			</c:forEach>
        </ul>
      </div>
    </div>
  </div>
</div>
</c:otherwise>
</c:choose>
<br>
<br>
<br>
<br>




<%@include file="footer.jsp" %>
<%@include file="footer.jsp" %>
</body>
</html>