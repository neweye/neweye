<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<title>NewEye</title>

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Lonely - Free bootstrap 3 one page template</title>

<script type="text/javascript" src="member/member01.js"></script>

<!-- CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=request.getContextPath()%>/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/nivo-lightbox.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/owl.carousel.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath()%>/css/owl.theme.css" rel="stylesheet" media="screen" />
<link href="<%=request.getContextPath()%>/css/animate.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/color/default.css" rel="stylesheet">
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
	<!-- Preloader -->
	<div id="preloader">
		<div id="load"></div>
	</div>
	<br/>
	<div class="slogan">
			<a href="<%=request.getContextPath() %>/"><img src="<%=request.getContextPath()%>/img/logo.png" alt="NewEye" /></a>
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
								<li class="active"><a href="<%=request.getContextPath() %>/">Go To The Product Page</a></li></li>
							</ul>
						</div>
						<!-- /.Navbar-collapse -->

					</div>
				</div>
			</div>
			<!-- /.container -->
		</nav>
	</div>
