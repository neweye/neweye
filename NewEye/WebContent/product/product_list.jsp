<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>nav</title>
<style>
* {
   margin: 0;
   padding: 0;
}

div.div_all{
   margin: 10px;
   width: 290px;
   height: 330px;
}

div#product_list {
   color: lightblue;
   width: 280px;
   height: 320px;
   margin: 5 10px;
   border: 1px solid #000000;
   text-align: center;
   float: left;
   box-sizing: border-box;
}

img{
   width: 240px;
}

div.bottom {
   clear: both;
}
</style>
</head>

<body>
   <!-- <body id="page-top" data-spy="scroll" data-target=".navbar-custom"> -->
   <article>
      <%-- <c:forEach items="${ }" var=""> 여기 나중에 반복 돌려야함 --%>
      <div class="div_all">
            <div id="product_list">
         <ul>
            <li><a href="productDetail.ne?pseq=${productVO.pseq}">
            <img src="<%=request.getContextPath() %>/productimg/D500.png"/></a></li>
         </ul>
         <ul>
            <li>new</li>
            <li>best</li>
            <li>sold out</li>
         </ul>
         <ul>
            <li>상품명</li>
            <li>가격</li>

         </ul>
      </div>
      </div>
      <div class="bottom"></div>
      <%-- </c:forEach> --%>
   </article>
</body>
</html>