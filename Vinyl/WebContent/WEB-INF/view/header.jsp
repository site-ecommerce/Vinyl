<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<title>VintageVinyle</title>
		
		<!-- Stylesheet -->
		<link href="/Vinyl/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/style.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap-theme.css.map" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="/Vinyl/css/bootstrap.css.map" rel="stylesheet" type="text/css" />
		
		
		<!--<link href="/Vinyl/css/color/multicolor.css" rel="stylesheet" type="text/css" id="changeColor" />-->
		
		
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet" type="text/css" />
		
		<link rel="shortcut icon" href="/MyMagicPetShop666/img/favicon.ico" />
		<!-- Scripts -->
		<script type="text/javascript" src="../../code.jquery.com/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="/Vinyl/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/Vinyl/js/functions.js"></script>
		<script type="text/javascript" src="/Vinyl/js/bootstrap.js"></script>
		<script type="text/javascript" src="/Vinyl/js/npm.js"></script>
		<script type="text/javascript" src="/Vinyl/js/carousel.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	</head>
	
	<body>
	<div class="header navbar-fixed-top">
  <div class="container">
    <div class="row"> 
      <ul class="nav nav-pills span6">
        <li class="active"><a href="<c:url value="/init" />">Accueil</a></li>
        <li class="dropdown">
         <a href="#" class="dropdown-toggle" data-toggle="dropdown">Catégories</a> 
                    <!-- Liste des catégories -->
                    <ul class="dropdown-menu">
                     <c:forEach items="${ categoryList }" var="category" varStatus="status">
                      <li><a href="<c:url value="/category">
              <c:param name="categoryID" value="${ category.categoryId }"/>
             </c:url>"><c:out value="${category.label}"/></a></li>
                     </c:forEach>
                    </ul>
        </li>
        <li>
	        	<form action="searchServlet" method="post" class="header-search">      
	      			 <input id="searchId" type="text" name="searchString" required="true" placeholder="Rechercher" />
	      			 <button id="searchB" type="submit" value="search" class="glyphicon glyphicon-search"></button>
	   			</form>
        </li>
      </ul>
      <c:choose>
<c:when test="${ customer != null }">
</c:when>
<c:otherwise>     

    <!-- Button trigger modal -->
<button type="button" class="btn-lg cart" data-backdrop="false" data-toggle="modal" data-target="#myModal">
  Se connecter
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">Se connecter</h4>
      </div>
      <div class="modal-body">
        <div class="span6">
        <br>
				<c:if test="${ errorMessage != null }">
				    <c:out value="${errorMessage}"/>
				</c:if>
				 <form action="loginServlet" method="post" class="map-form">
					 <label for ="#emailId" class="control-label">Email : </label>
					 <br>
					 <input id="emailId" type="text" name="MAIL_ADDRESS" required="true" placeholder="Entrez votre email" />
					 <br>
					 <label for ="passwordId" class="control-label">Mot de passe: </label>
					 <br>
					 <input id="passwordId" name="PASSWORD" type="password" required="true" placeholder="Mot de passe" />
					 	<div class="control-group no-margin">
					    	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button id="loginB" type="submit" name="connection" class="btn">Se connecter</button>
					  	</div>
				</form>
			</div>
      </div>
      <div class="modal-footer">

      </div>
    </div>
  </div>
</div>
</c:otherwise>
</c:choose>


      <!-- Header Cart -->
      <div class="cart">
      <i class="glyphicon glyphicon-shopping-cart"></i>
        <p>Panier</p> 
        <!-- Header Cart Content -->
        <div class="cart-content">
          <div class="mini-cart-info">
            <h3>Panier</h3>
            <ul>   
            <c:forEach items="${ cart.cartLineList }" var="cartLine" varStatus="status">
				<c:forEach items="${ productList }" var="product" varStatus="status">
					<c:if test="${ product.id == cartLine.productId }">
						<li> 
						<a href="#"><img src="" alt="Produit" /></a>
						 <div class="mini-cart-detail">
			                  <h5><a href="#"><c:out value="${product.label}"/></a></h5>
			                  <em><c:out value="${cartLine.getQuantite()}"/> exemplaire(s)</em>
			                  <p>&euro; <c:out value="${product.ATIP * cartLine.getQuantite()}"/> </p>
		                 </div>			    				     
					    </li>
					   <c:set var="total" value="${total = total + product.ATIP * cartLine.getQuantite()}" scope="page" />
					</c:if>
				</c:forEach>
			</c:forEach>
			</ul>
          </div>

           <div class="mini-cart-total">
           
                   <c:if test="${total != null }">
                   	 <p class="total">Total 
                   	 <span>&euro;
                   	 	 <c:out value="${total}"></c:out>
                   	 	 <div class="checkout"><a href="<c:url value="/myCart">
			 				 	<c:param name="transaction" value="print"/>
								</c:url>" class="btn">Voir le panier</a> 
								<a href="<c:url value="/order">
			  					</c:url>" class="btn btn-checkout">Payer</a><
			 			 </div>
                   	 </span>
                   	</p>
                   </c:if>
                   
                    <c:if test="${total == null }">
                   	 <p class="total"><c:out value="Vous n'avez pas d'articles."></c:out></p>
                   </c:if>
           	</div>
        </div>
      </div>
      
      <!-- Header Login -->
      <div class="cart">
      <p class="log-reg">
      	<c:choose>
			<c:when test="${ customer != null }">
				<div class="cart">
      			<i class="glyphicon glyphicon-home"></i>
        		<a class="dropdown-toggle" data-toggle="dropdown">
        			<p>${customer.firstname}</p>
        		</a>
        		<ul class="dropdown-menu">
                	<li><a href="<c:url value="/compte" />">Mon compte</a></li>
                    <li><a href="<c:url value="/commandes" />">Mes commandes</a></li>
                    <li><a href="<c:url value="/fidelite" />">Mon espace fidélité</a></li>
                    <li><a href="<c:url value="/avantages" />">Mes avantages</a></li>
                    <li><a href="<c:url value="/logout" />">Se déconnecter&nbsp;</a>
				</ul>
      		</div>
			</c:when>
			<c:otherwise>
  				<c:if test="${ errorMessage != null }">
				    <c:out value="${errorMessage}"/>
				</c:if>
				<c:if test="${ infoMessage != null }">
				    <c:out value="${infoMessage}"/>
				</c:if>
				<i class="glyphicon glyphicon-pencil"></i>
					<a href="<c:url value="/login" />">S'inscrire &nbsp;</a>
			</c:otherwise>
		</c:choose>
      </p>
      </div>
    </div>
  </div>
</div>



<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!-- Bulles -->
<ol class="carousel-indicators">
<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
<li data-target="#myCarousel" data-slide-to="1"></li>
<li data-target="#myCarousel" data-slide-to="2"></li>
</ol>
<!-- Slides -->
<div class="carousel-inner">
<!-- Page 1 -->
<div class="item active">  
<div class="carousel-page">
<img src="./img/vinyl.jpg" class="img-responsive" style="margin:0px auto;" />
</div> 
<div class="carousel-caption">Bienvenue</div>
</div>   
<!-- Page 2 -->
<div class="item"> 
<div class="carousel-page">
<img src="./img/livraison.jpg" class="img-responsive img-rounded" style="margin:0px auto;"  /></div> 
<div class="carousel-caption">L'été revient les frais de port sont offert. Offre limité.</div>
</div>  
<!-- Page 3 -->
<div class="item">  
<div class="carousel-page">
<img src="./img/vinyls.jpg" class="img-responsive img-rounded" 
style="margin:0px auto;max-height:100%;"  />
</div>  
<div class="carousel-caption">De nombreux avantages pour vous.</div>
</div>     
</div>
<!-- Contrôles -->
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>
</div>
</div>
</body>
</html>