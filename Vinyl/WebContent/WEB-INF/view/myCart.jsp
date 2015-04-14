<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>
<div class="products-list">
<div class="container">
  <div class="row">
    <div class="span12">

<c:forEach items="${ customerList }" var="customer" varStatus="status">
	  <c:if test="${ cart.customerID == customer.customerId }">
	   	<c:out value="${ customer.firstname }" />
	  </c:if>
	</c:forEach>
      <table class="table table-hover">
        <thead>
          <tr>
            <th></th>
            <th class="p-name">Nom produit</th>
            <th>Quantité</th>
            <th>Prix unitaire</th>
            <th>Total</th>
          </tr>
        </thead>
		<c:choose>
		<c:when test="${ customer != null }">
        <tbody>
		<c:forEach items="${ cart.cartLineList }" var="cartLine" varStatus="status">
			<c:forEach items="${ productList }" var="product" varStatus="status">
				<c:if test="${ product.id == cartLine.productId }">
				  <tr>
					<td class="thumb-cart"><a href="#"><img src="http://placehold.it/350x150"></a></td>
					<td class="p-name"><h5><a href="#"><c:out value="${product.label}"/></a></h5></td>
					<td> <c:out value="${cartLine.getQuantite()}"/></td>
					<td><c:out value="${product.PRIX}"/></td>
					<td><strong><c:out value="${product.PRIX * cartLine.getQuantite()}"/>&euro;</strong></td>
				  </tr>
				</c:if>
			</c:forEach>
		</c:forEach>
        </tbody>
		</c:when>
			<c:otherwise>
			Votre panier est vide			
			</c:otherwise>
		</c:choose>
      </table>
      <div class="main-checkout"><a href="<c:url value="/order">
		  </c:url>" class="btn btn-checkout">Commander</a></div>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>