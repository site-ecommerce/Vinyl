<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<title>VintageVinyle</title>
		
		<!-- Stylesheet -->
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/style.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap-theme.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap-theme.css.map" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/bootstrap.css.map" rel="stylesheet" type="text/css" />
		
		
		<!--<link href="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/css/color/multicolor.css" rel="stylesheet" type="text/css" id="changeColor" />-->
		
		
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet" type="text/css" />
		
		<link rel="shortcut icon" href="/MyMagicPetShop666/img/favicon.ico" />
		<!-- Scripts -->
		<script type="text/javascript" src="../../code.jquery.com/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/js/functions.js"></script>
		<script type="text/javascript" src="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/js/bootstrap.js"></script>
		<script type="text/javascript" src="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/js/npm.js"></script>
		<script type="text/javascript" src="/B3_LILLE_J2EE_HAMY_DENEUVILLERS/js/carousel.js"></script>
	
	</head>
	
	<body>
	<div class="header navbar-fixed-top">
  <div class="container">
    <div class="row"> 
      
      <!-- Secondary Menu -->
      <ul class="nav nav-pills span6">
        <li class="active"><a href="<c:url value="/init" />">Accueil</a></li>
      </ul>
      
      <!-- Header Cart -->
      <div class="cart"><i class="glyphicon glyphicon-shopping-cart"></i>
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
			                  <em><c:out value="${cartLine.lineNumber}"/> exemplaire(s)</em>
			                  <p>&euro; <c:out value="${product.ATIP}"/> </p>
		                 </div>			    				     
					    </li>
					   <c:set var="total" value="${total = total + product.ATIP * cartLine.lineNumber}" scope="page" />
					</c:if>
				</c:forEach>
			</c:forEach>
			</ul>
          </div>
          
           <div class="mini-cart-total">
           
                   <c:if test="${total != null }">
                   	 <p class="total">Total 
                   	 <span>&euro;
                   	 	 <c:out value="${total}"></c:out>Euros
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
                   	 <p class="total"><c:out value="Vous n'avez pas d'articles :'("></c:out></p>
                   </c:if>
           	</div>
        </div>
      </div>
      
      <!-- Header Login -->
      <div class="cart"><i class="glyphicon glyphicon-off"></i>
      <p class="log-reg">
      	<c:choose>
			<c:when test="${ customer != null }">
				<a href="">Mon compte</a>
				<a href="<c:url value="/logout" />">Se déconnecter ( ${customer.firstname} ) &nbsp;</a>
			</c:when>
			<c:otherwise>
				<c:if test="${ errorMessage != null }">
				    <c:out value="${errorMessage}"/>
				</c:if>
				<c:if test="${ infoMessage != null }">
				    <c:out value="${infoMessage}"/>
				</c:if>	
					<a href="<c:url value="/login" />">Se connecter / S'enregistrer &nbsp;</a>  
					<!--<a onclick="connexion();">Se connecter / S'enregistrer &nbsp;</a>-->
			</c:otherwise>
		</c:choose>
      </p>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>



<div id="my_carousel" class="carousel slide" data-ride="carousel">
<!-- Bulles -->
<ol class="carousel-indicators">
<li data-target="#my_carousel" data-slide-to="0" class="active"></li>
<li data-target="#my_carousel" data-slide-to="1"></li>
<li data-target="#my_carousel" data-slide-to="2"></li>
</ol>
<!-- Slides -->
<div class="carousel-inner">
<!-- Page 1 -->
<div class="item active">  
<div class="carousel-page">
<img src="./img/logo.png" class="img-responsive" style="margin:0px auto;" />
</div> 
<div class="carousel-caption">Page 1 de présentation</div>
</div>   
<!-- Page 2 -->
<div class="item"> 
<div class="carousel-page"><img src="./img/logo.png" class="img-responsive img-rounded" 
style="margin:0px auto;"  /></div> 
<div class="carousel-caption">Page 2 de présentation</div>
</div>  
<!-- Page 3 -->
<div class="item">  
<div class="carousel-page">
<img src="./img/vinyl.jpg" class="img-responsive img-rounded" />
</div>  
<div class="carousel-caption">Page 2 de présentation</div>
</div>     
</div>
<!-- Contrôles -->
<a class="left carousel-control" href="#my_carousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#my_carousel" data-slide="next">
<span class="glyphicon glyphicon-chevron-right"></span>
</a>
</div>
</body>
</html>