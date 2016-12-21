<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<style>
* {
 margin: 0;
 padding: 0;
}


div.div_all {
 padding: 5px auto; 
 width: 300px;
 height: 360px;
 border: 1px solid blue;
 disply:inline; /* 여기 왜 적용이 안되는가 */
 /* folat:left; */
}

div#product_list {
 margin:10px;
 width: 280px;
 height: 340px;
 border: 1px dashed #999999;
 /* overflow: hidden; */
}

img {
 width: 240px;
}

div.bottom {
 clear: both;
}

ul.plist {
 float: middle;
 text-align: center;
}

li {
 list-style: none;
 text-align:center;
}

li#product_list_icon {
 font-size: 12px;
 color: blue;
}

li#product_list_name {
 margin: 0 0 15px 0;
 font-size: 18px;
 font-famliy: 돋음;
 color: #555555;
}

li#product_list_price {
 
 font-size: 16px;
 font-famliy: '돋음';
 color: #999999;
}
</style>
</head>

<body>
 <!-- <body id="page-top" data-spy="scroll" data-target=".navbar-custom"> -->
 <article>
  <%-- <c:forEach items="${productKindList}" var="productVO">  --%>

  <div class="div_all">
   <div id="product_list">
    <ul class="plist">
     <li><a href="productDetail.ne?pseq=${productVO.pseq}">
            <img src="<%=request.getContextPath() %>/productimg/${productVO.img_List}"/></a></li>
     
     <%-- <li><a href="product_detailjsp.jsp"> <img
       src="<%=request.getContextPath()%>/productimg/D500.png" /></a></li> --%>
       
       
    </ul>
    <ul>
     <li id="product_list_icon">&nbsp;new&nbsp; &nbsp;best&nbsp;
      &nbsp;sold out&nbsp; <%-- <c:if test="${productVO.indate > 0}">
            &nbsp;new&nbsp;
            </c:if>
            <c:if test="${productVO.read_count > 10}">
            &nbsp;best&nbsp;
            </c:if>
            <c:if test="${productVO.quantity == 0}">
            &nbsp;sold out&nbsp;
            </c:if> --%>
     </li>
    </ul>
    <ul>
     <li id="product_list_name">AF-P DX NIKKOR 70-300mm f/4.5-6.3G
      ED VR</li>
     <li id="product_list_price">￦3,340,000</li>

    </ul>
   </div>
  </div>





  <div class="div_all">
   <div id="product_list">
    <ul class="plist">
     <li><a href="productDetail.ne?pseq=${productVO.pseq}">
            <img src="<%=request.getContextPath() %>/productimg/${productVO.img_List}"/></a></li>
     
     <%-- <li><a href="product_detailjsp.jsp"> <img
       src="<%=request.getContextPath()%>/productimg/D500.png" /></a></li> --%>
       
       
    </ul>
    <ul>
     <li id="product_list_icon">&nbsp;new&nbsp; &nbsp;best&nbsp;
      &nbsp;sold out&nbsp; <%-- <c:if test="${productVO.indate > 0}">
            &nbsp;new&nbsp;
            </c:if>
            <c:if test="${productVO.read_count > 10}">
            &nbsp;best&nbsp;
            </c:if>
            <c:if test="${productVO.quantity == 0}">
            &nbsp;sold out&nbsp;
            </c:if> --%>
     </li>
    </ul>
    <ul>
     <li id="product_list_name">AF-P DX NIKKOR 70-300mm f/4.5-6.3G
      ED VR</li>
     <li id="product_list_price">￦3,340,000</li>

    </ul>
   </div>
  </div>




  <div class="div_all">
   <div id="product_list">
    <ul class="plist">
     <li><a href="productDetail.ne?pseq=${productVO.pseq}">
            <img src="<%=request.getContextPath() %>/productimg/${productVO.img_List}"/></a></li>
     
     <%-- <li><a href="product_detailjsp.jsp"> <img
       src="<%=request.getContextPath()%>/productimg/D500.png" /></a></li> --%>
       
       
    </ul>
    <ul>
     <li id="product_list_icon">&nbsp;new&nbsp; &nbsp;best&nbsp;
      &nbsp;sold out&nbsp; <%-- <c:if test="${productVO.indate > 0}">
            &nbsp;new&nbsp;
            </c:if>
            <c:if test="${productVO.read_count > 10}">
            &nbsp;best&nbsp;
            </c:if>
            <c:if test="${productVO.quantity == 0}">
            &nbsp;sold out&nbsp;
            </c:if> --%>
     </li>
    </ul>
    <ul>
     <li id="product_list_name">AF-P DX NIKKOR 70-300mm f/4.5-6.3G
      ED VR</li>
     <li id="product_list_price">￦3,340,000</li>

    </ul>
   </div>
  </div>


  <div class="bottom"></div>
  <%-- </c:forEach> --%>
 </article>
</body>
</html>