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
article.product_list_jsp{
	padding : 0px 10%;
		/* width: 1000px; */
	
}

div.div_all {
 folat:left;
 padding: 5px auto; 
 width: 300px;
 height: 360px;
 border: 1px solid blue;
 text-align: left;
	vertical-align: top;
	display: table-cell;
 /* disply:inline; */ /* 여기 왜 적용이 안되는가 */
  /* text-align:center; */
}

div#product_list {
 margin:10px;
 width: 280px;
 height: 340px;
 border: 1px dashed #999999;
 display: inline-block;
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
  상세검색: 넌버튼<br/>
 
 
 상품비교 : 여기 대분류 선택하게 할거임 <input type="textfield" name="" value=""/>&nbsp;<input type="textfield" name="" value=""/> 
 드롭다운식으로 바꿀거임
 <input type="button" name="" value="비교하기"/>
 
 </article>
 
 
 <article class="product_list_jsp">
  <%-- <c:forEach items="${productKindList}" var="productVO">  --%>
	<%-- <c:forEach var="i" items="" begin="0" varStatus="status" end="20"> --%>
	<c:forEach items="${productKindList}" var="productVO">	
	
	
  <div class="div_all">
<c:if test="${productVO.useyn=='Y'}">  
   <div id="product_list">
    <ul class="plist">
     <li><a href="productDetail.ne?pseq=${productVO.pseq}">
            <img src="<%=request.getContextPath() %>/productimg/${productVO.img_list}"/>
            
            </a></li>
     
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
     <li id="product_list_name">${productVO.name}</li>
     <li id="product_list_price">${productVO.price}</li>
	<li id="product_list_price">${productVO.read_count}</li>
    </ul>
   </div>
   
   </c:if>
   
  </div>


  </c:forEach>
  <div class="bottom"></div>
 </article>
</body>
</html>