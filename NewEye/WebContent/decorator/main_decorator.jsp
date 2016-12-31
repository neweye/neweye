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
	<div class="slogan">
			<a href="<%=request.getContextPath() %>/index.ne"><img src="<%=request.getContextPath()%>/img/logo.png" alt="NewEye" /></a>
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
										<a href="<%=request.getContextPath() %>/index.ne">Home</a>
								</li>
								<li>
									|&nbsp;&nbsp;&nbsp;
									<div class="dropdown">
									<a href="product.ne">PRODUCT</a>
									</div>&nbsp;&nbsp;&nbsp;
								</li>
								<li>
									<div class="dropdown">
									<a href="product.ne?category=DSLR"><span>DSLR</span></a>
									<div class="dropdown-content">
										    <p><a href="product.ne?kind=1">FX</a></p>
										    <p><a href="product.ne?kind=2">DX</a></p>
										</div>
									</div>&nbsp;&nbsp;&nbsp;
								</li>
								<li>
									<div class="dropdown">
									<a href="product.ne?category=LENDS"><span>LENDS</span></a>
									<div class="dropdown-content">
										    <p><a href="product.ne?kind=3">DX 단렌즈</a></p>
										    <p><a href="product.ne?kind=4">DX 줌렌즈</a></p>
										    <p><a href="product.ne?kind=5">FX 단렌즈</a></p>
										    <p><a href="product.ne?kind=6">FX 줌렌즈</a></p>
										</div>
									</div>&nbsp;&nbsp;&nbsp;
								</li>
								<li>
									<div class="dropdown">
									<a href="product.ne?category=ACCESSORY"><span>ACCESSORY</span></a>
									<div class="dropdown-content">
										    <p><a href="product.ne?kind=7">DSLR</a></p>
										    <p><a href="product.ne?kind=8">ETC</a></p>
										    <p><a href="product.ne?kind=9">LENDS</a></p>
										</div>
									</div>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
								</li>
								<li>
									<div class="dropdown">
									<a href="mypageForm.ne">MYPAGE</a>
									<div class="dropdown-content">
										    <p><a href="cartList.ne">장바구니</a></p>
										    <p><a href="orderAll.ne">주문조회</a></p>
										    <p><a href="mypageMember.ne">회원정보</a></p>
										    <p><a href="qnaList.ne">Q&A</a></p>
										</div>
									</div>&nbsp;&nbsp;&nbsp;
								</li>
								<c:choose>
									<c:when test="${empty sessionScope.loginUser}">
										<li>
											<div class="dropdown">
											<a href="loginForm.ne">LOGIN</a>
											</div>&nbsp;&nbsp;&nbsp;
										</li>
										<li>
											<div class="dropdown">
											<a href="contract.ne">JOIN</a>
											</div>&nbsp;&nbsp;&nbsp;
										</li>
									</c:when>
									<c:otherwise>
										<li style="color: orange">
											${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</li>
										<li>
											<div class="dropdown">
											<a href="logout.ne">LOGOUT</a>
											</div>&nbsp;&nbsp;&nbsp;
										</li>
									</c:otherwise>
								</c:choose>
								<li>
									<div class="dropdown">
									<a href="admin/adminLoginForm.ne"><span>ADMIN</span></a>
									</div>&nbsp;&nbsp;&nbsp;
								</li>
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
               <p>&copy; Neweye.All Rights Reserved</p>
               <div class="credits">
                  <!-- 
                            All the links in the footer should remain intact. 
                            You can delete the links only if you purchased the pro version.
                            Licensing information: https://bootstrapmade.com/license/
                            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Lonely
                        -->
                  상호명 : 주식회사 뉴아이코리아 / 대표이사 : JSP / TEL : 080-000-0000 / FAX : 042-0000-0000<br>
주소 : 대전광역시 중구 중앙로 76 영민빌딩 2층

사업자등록번호 : 000-00-12345 / 통신판매업신고 : 중구 제12345호 / 콜센터 운영시간 : 평일 09:00 ~ 18:00 (토·일·공휴일 휴무)
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
   <script src="<%=request.getContextPath()%>/contactform/contactform.js"></script>
   <script src="<%=request.getContextPath()%>/product/products.js"></script>
   <script src="<%=request.getContextPath()%>/mypage/mypage01.js"></script>
   <script src="<%=request.getContextPath()%>/member/member01.js"></script>
   
</body>

</html>