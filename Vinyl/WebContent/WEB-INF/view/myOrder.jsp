
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp" %>
<div class="products-list">
<div class="container">
  <div class="row">
    <div class="span12">
    <c:if test="${ order != null }">
	Commande :
	<c:out value="${order.orderDate}"/>
	Total : 
	<c:out value="${order.price}"/>
</c:if>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>