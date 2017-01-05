<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script>
function go_search_detail(){
   var theForm = document.frm;
   var url ="/NewEye/product/product_search_detail.jsp";
   var options = "toolbar=yes,scrollbars=yes,resizable=no,top=200,left=300,width=900,height=800";
   //theForm.action="product/product_search_detail.jsp";
   window.open(url, "상세검색", options);
   theForm.submit();
}
</script>
<style>
* {
   margin: 0;
   padding: 0;
}

article.product_list_jsp {
	padding: 0px 10%;
}

span.div_areasize {
	width: 650px;
	text-align: center;
	vertical-align: top;
}

div.div_all {
	folat: left;
	padding: 5px auto;
	width: 300px;
	height: 360px;
	text-align: center;
	vertical-align: top;
	display: table-cell;
}

div#product_list {
	margin: 10px;
	padding: 20px 20px 10px;
	width: 280px;
	height: 340px;
	border: 1px dashed #999999;
	display: inline-block;
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
   text-align: center;
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
div.top_search_tb{
   margin:10px auto;
   padding:10px;
   width : 1000px;
   text-align:right;
   /* border:1px solid black; */
}
div.invisibleClass{
	display : none;
}
</style>
</head>

<body>
   <!-- <body id="page-top" data-spy="scroll" data-target=".navbar-custom"> -->
   <article>

<form name="frm" method="post">
   <div class="top_search_tb">
   
   <c:if test="${order=='pseq'}">
   	<select name="column" id="orderToList" size="1">
   		<option value="pseq" selected>신상품 순</option>
   		<option value="read_count">베스트 순</option>
   	</select>
   	</c:if>
   	<c:if test="${order=='read_count'}">
   	<select name="column" id="orderToList" size="1">
   		<option value="pseq">신상품 순</option>
   		<option value="read_count" selected>베스트 순</option>
   	</select>
   	</c:if>
      <input type="text" name="key" onkeydown="javascipt:if(event.keyCode == 13)go_search(this.form);"/>
      <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search(this.form)">&nbsp;
      <input class="btn" type="button" id="detailBtn" value="▼" onClick="go_detail()"/><br />
      
      <div id="searchDetailBtn" class="invisibleClass">
      <jsp:include page="product_search_detail.jsp" />
      </div>
	</div>
<br/>
</form>
   </article>

   <article class="product_list_jsp">
      <%-- <c:forEach items="${productKindList}" var="productVO">  --%>
      <%-- <c:forEach var="i" items="" begin="0" varStatus="status" end="20"> --%>
      <c:forEach items="${productList}" var="productVO">
         <span class="div_areasize">
            <div class="div_all">
                  <div id="product_list">
                     <ul class="plist">
                        <li><a href="productDetail?pseq=${productVO.pseq}">
                              <img src="<%=request.getContextPath() %>/productimg/${productVO.img_list}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>
                        </a></li>
                     </ul>
                     <ul>
                        <li id="product_list_icon">
            <c:if test="${productVO.read_count > 5}">
            &nbsp;best&nbsp;
            </c:if>
            <c:if test="${productVO.quantity==0||productVO.useyn=='N'}">
            &nbsp;<font color="red">sold out</font>&nbsp;
            </c:if>
                        </li>
                     </ul>
                     <ul>
                        <li id="product_list_name">${productVO.name}</li>
                        <li id="product_list_price"><fmt:formatNumber value="${productVO.price}" type="number"/> 원</li>
                        <%-- <li id="product_list_price">${productVO.read_count}</li> --%>
                     </ul>
                  </div>
            </div>
         </span>
      </c:forEach>
      <div class="bottom">${paging}</div>
   </article>
</body>


</html>
