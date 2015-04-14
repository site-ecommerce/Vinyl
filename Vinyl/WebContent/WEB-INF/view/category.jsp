
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>
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
					<div class="thumbnail"><a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>" class="thumb">
							<img src="http://placehold.it/350x150">
							</a>
			          <p><a href="<c:url value="/product">
							  <c:param name="productID" value="${ product.id }"/>
							</c:url>" class="thumb">
							<c:out value="${product.label}"></c:out>
							</a>
						</p>
			          <p class="price">&euro; <c:out value="${product.PRIX}" /> </p>
			          <c:choose>
			          <c:when test="${ customer != null }">
					      <a class="buyLink" href="<c:url value="/myCart">
							  <c:param name="transaction" value="add"/>
							  <c:param name="productId" value="${ product.id }"/>
							</c:url>">
							<div class="addTocart" >Ajouter au panier</div>
							</a>
				     </c:when>
				     <c:otherwise>
					     <a  class="buyLink" href="<c:url value="/login">
							</c:url>">Ajouter au panier</a>
				     </c:otherwise>
				     </c:choose>
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