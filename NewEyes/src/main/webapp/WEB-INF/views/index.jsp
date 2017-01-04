<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">



<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

	<!-- ///////////Carousel 시작/////////// -->
	<section id="picCarousel" class="home-section">
		<div style="width:1200px;margin:auto;"><!-- 크기 조절 -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="<%=request.getContextPath()%>/img/carousel06.png"
						alt="dlsr01">
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/img/carousel04.png"
						alt="dlsr02">
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/img/carousel05.png"
						alt="dlsr03">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"> 
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"> 
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		</div>
	</section>
	<!-- ///////////Carousel 끝/////////// -->
	
	<!-- ///////////최근 상품 시작/////////// -->
	<section id="newGoods" class="home-section parallax text-center">
		<%@include file="product/product_list_new.jsp" %>
	</section>
	<!-- ///////////최근 상품 끝/////////// -->
	
	<!-- ///////////베스트 상품 시작/////////// -->
	<section id="bestGoods" class="home-section parallax text-center">
		<%@include file="product/product_list_best.jsp" %>
	</section>
	<!-- ///////////베스트 상품 끝/////////// -->
	<br/>
	<table border="1">
	<tr>
	<%-- <%
		String cp = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		
		//쿠키 가져오기
		Cookie[] ck = request.getCookies();
		
		 if(ck!=null){
			 
			 for(int i=0; i<ck.length; i++){
				 if(ck[i].getName().equals("itemID")){
					 //String strCookie = URLDecoder.decode(ck[i].getValue(), "utf-8");					 
					 out.print("<th><a href='productDetail.ne?pseq="+java.net.URLDecoder.decode(ck[i].getValue(), "utf-8")+"'/>a</a></th></tr>");
				 }
				/*  if(ck[i].getName().equals("sname2")){
					 out.println("<tr><th>"+java.net.URLDecoder.decode(ck[i].getValue(), "utf-8")+"</th></tr><br/>");					 					
				 }
				 if(ck[i].getName().equals("sname3")){
					 out.println("<tr><th><img src='"+request.getContextPath()+"/productimg/"+java.net.URLDecoder.decode(ck[i].getValue(), "utf-8")+"'/></tr></th>");
				 } */
			 }
			 
			/* for(Cookie c : ck){
				if(c.getName().indexOf("sname1")!= -1){
					out.print("<th><a href='productDetail.ne?pseq="+java.net.URLDecoder.decode(c.getValue(), "utf-8")+"'/>a</a></th></tr>");
				}
				if(c.getName().indexOf("sname2")!= -1){
					out.println("<tr><th>"+java.net.URLDecoder.decode(c.getValue(), "utf-8")+"</th></tr><br/>");
				}
				if(c.getName().indexOf("sname3")!= -1){
					out.println("<tr><th><img src='"+request.getContextPath()+"/productimg/"+java.net.URLDecoder.decode(c.getValue(), "utf-8")+"'/></tr></th>");
				}
			} */
		} 
	%> --%>
	</tr>
	</table>
	<!-- Section: separator -->
    <!-- <section id="separator" class="home-section parallax text-center" data-stellar-background-ratio="0.5">
		
		<div class="container">
			<div class="row">
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="align-center txt-shadow">
							<div class="icon">
								<i class="fa fa-graduation-cap fa-5x"></i>
							</div>
						<span class="color-white">Bachelor of Design</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="align-center txt-shadow">
							<div class="icon">
								<i class="fa fa-heart fa-5x"></i>
							</div>
						<span class="color-white">10x failed in love</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="align-center txt-shadow">
							<div class="icon">
								<i class="fa fa-plane fa-5x"></i>
							</div>
						<span class="color-white">I love traveling</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 col-md-3">
						<div class="align-center txt-shadow">
							<div class="icon">
								<i class="fa fa-camera fa-5x"></i>
							</div>
						<span class="color-white">I'm photographer</span>
						</div>
					</div>
			</div>		
		</div>
	</section> -->
	<!-- /Section: separator -->
	<!-- <div id="rightSide">
	<div id="right_zzim">
		<div  class="recTit">최근본상품 <span id=recentCnt></span></div>
			<ul></ul>    본 상품이 뿌려질 부분 
		<div id="paging"><a class="btn_prev" style="cursor:pointer" >이전</a><span  id="currentPage"></span><span id="totalPageCount"></span><a class="btn_next" style="cursor:pointer" >다음</a></div>
	</div>

</div> -->
	
	<!-- ///////////여백 시작/////////// -->
	<section id="blanck" class="home-section parallax text-center">
		<div></div>
	</section>
	<!-- ///////////여백 끝/////////// -->
	
</body>

</html>
