
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>
<c:if test="${ productSelected != null }">
<div class="container">
  <div class="row"> 
    
    <!-- Products List -->
    <div class="span9"> 
      
      <!-- Breadcrumb -->
      <ul class="breadcrumb">
        <li><a href="#">Accueil</a> <span class="divider">/</span></li>
        <li><a href="#">
        <c:forEach items="${ categoryList }" var="category" varStatus="status">
        <c:if test="${ product.categoryId == category.categoryId }">
        	<c:out value="${category.label}"/>
        </c:if>
        </c:forEach>
        </a> <span class="divider">/</span></li>
        <li class="active"><c:out value="${productSelected.label}"/></li>
      </ul>
      <h1><c:out value="${productSelected.label}"/></h1>
   
      <!-- Price -->
      <p class="main-price"><strong><c:out value="${productSelected.PRIX}"/> &euro;</strong></p>
      
      <!-- Add Buttons --> 
      
        <c:choose>
          <c:when test="${ customer != null }">
		      <a class="btn btn-add-cart" href="<c:url value="/myCart">
				  <c:param name="transaction" value="add"/>
				  <c:param name="productId" value="${ productSelected.id }"/>
				</c:url>"  ><div class="addTocart" >Ajouter au panier</div></a>
	     </c:when>
	     <c:otherwise>
		     <a class="btn btn-add-cart" href="<c:url value="/login">
				</c:url>">Ajouter au panier</a>
	     </c:otherwise>
	     </c:choose>
      <div class="clearfix"></div>
      
      <!-- Product Description -->
      <div class="accordion" id="accordion2">
        <div class="accordion-group">
          <div class="accordion-heading"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> Description </a> </div>
          <div id="collapseOne" class="accordion-body collapse in">
            <div class="accordion-inner"> <c:out value="${productSelected.description}"/> </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</c:if>
<%@include file="footer.jsp" %>
</body>
</html>