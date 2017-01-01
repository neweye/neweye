<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator"
   uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%
   response.setHeader("Pragma", "No-cache");
   response.setHeader("Cache-Control", "no-cache");
   response.addHeader("Cache-Control", "no-store");
   response.setDateHeader("Expires", 1L);
%>
<!DOCTYPE html>
<html>
<title>NewEye<decorator:title /></title>
<decorator:head />

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Lonely - Free bootstrap 3 one page template</title>

<!-- CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/nivo-lightbox.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/owl.carousel.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath()%>/css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath()%>/css/animate.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/color/default.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/shopping.css" rel="stylesheet">
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
   <!-- Preloader -->
   <div id="preloader">
      <div id="load"></div>
   </div>

   <!-- /Section: intro -->
   <br/>
   <div class="slogan">
         <a href="<%=request.getContextPath() %>/index.ne"><img src="<%=request.getContextPath()%>/img/logo.png" alt="NewEye" /></a>
   </div>
   <div class="page-scroll">
   <!-- <a href="#about"> <i class="fa fa-angle-down fa-5x animated"></i></a> -->
   </div>

   <!-- Navigation -->
   <div id="navigation">
      <nav class="navbar navbar-custom" role="navigation">
         <div class="container">
            <div class="row">
               <div class="col-md-12">

                  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                     <button type="button" class="navbar-toggle"
                        data-toggle="collapse" data-target="#menu">
                        <i class="fa fa-bars"></i>
                     </button>
                  </div>
                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse" id="menu">
                     <ul class="nav navbar-nav">
                        <li class="active">
                        <a href="adminProductList.ne">상품리스트</a></li>
                        <li><a href="adminOrderList.ne">주문리스트</a></li>
                        <li><a href="adminMemberList.ne">회원리스트</a></li>
                        <li><a href="adminQnaList.ne">Q&amp;A리스트</a></li>
                        <!-- <li><a href="adminQnaList.ne">Q&amp;A리스트</a></li> -->
                        <li><a href="adminLogout.ne">LOGOUT</a></li>
                     </ul>
                  </div>
                  <!-- /.Navbar-collapse -->

               </div>
            </div>
         </div>
         <!-- /.container -->
      </nav>
   </div>
   <!-- /Navigation -->

   <decorator:body />

   <footer>
      <div class="container">
         <div class="row">
            <div class="col-md-12 col-lg-12">
               <p>&copy; Lonely Theme. All Rights Reserved</p>
               <div class="credits">
                  <!-- 
                            All the links in the footer should remain intact. 
                            You can delete the links only if you purchased the pro version.
                            Licensing information: https://bootstrapmade.com/license/
                            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Lonely
                        -->
                  <a href="https://bootstrapmade.com/">Free Bootstrap Themes</a> by
                  <a href="https://bootstrapmade.com/">BootstrapMade</a>
               </div>
            </div>
         </div>
      </div>
   </footer>


   <!-- Core JavaScript Files -->
   <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/jquery.easing.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/jquery.sticky.js"></script>
   <script src="<%=request.getContextPath()%>/js/jquery.scrollTo.js"></script>
   <script src="<%=request.getContextPath()%>/js/stellar.js"></script>
   <script src="<%=request.getContextPath()%>/js/wow.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/nivo-lightbox.min.js"></script>
   <!-- Custom Theme JavaScript -->
   <script src="<%=request.getContextPath()%>/js/custom.js"></script>
   <script src="<%=request.getContextPath()%>/product/products.js"></script>
   <script src="<%=request.getContextPath()%>/mypage/mypage01.js"></script>
   <script src="<%=request.getContextPath()%>/member/member01.js"></script>
   <script src="<%=request.getContextPath()%>/admin/product/product01.js"></script>
   <script src="<%=request.getContextPath()%>/js/order.js"></script>

</body>

</html>
