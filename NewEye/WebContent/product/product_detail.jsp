<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<title></title>

<style>
*{
 margin: 0;
 padding: 0;
 
}
div#detail_table_outline{
	margin:30px auto;
	width: 604px;
	border : 1px dashed #888888;
}
table.product_detail{
 margin:50px auto;
 width: 800px;
 height: 600px;
 border: 1px solid #999999;
}

table.table_detail_content{
 margin: 20px auto;
 width: 600px;
}
th#th_detail_table{
	height:40px;
	text-align:center;
	vatical-align: top;
	font-size: 18px;
}

td#td_img_detail{
 width:600px;  /* 여기 왜 적용이 안되는가... */
 text-align:center;
}

td{text-indent: 1em;}
td.content_td{
text-indent: 2em;
 font-family: 'Rockwe', Monospace ;
 width: 160px;
 height: 30px;
 font-size:15px;
 
}

table.product_img_detail{
 margin: auto;
}

input.btn_product_detail {
 -moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
 -webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
 box-shadow:inset 0px 1px 0px 0px #ffffff;
 background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f9f9f9), color-stop(1, #e9e9e9));
 background:-moz-linear-gradient(top, #f9f9f9 5%, #e9e9e9 100%);
 background:-webkit-linear-gradient(top, #f9f9f9 5%, #e9e9e9 100%);
 background:-o-linear-gradient(top, #f9f9f9 5%, #e9e9e9 100%);
 background:-ms-linear-gradient(top, #f9f9f9 5%, #e9e9e9 100%);
 background:linear-gradient(to bottom, #f9f9f9 5%, #e9e9e9 100%);
 filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f9f9f9', endColorstr='#e9e9e9',GradientType=0);
 background-color:#f9f9f9;
 -moz-border-radius:6px;
 -webkit-border-radius:6px;
 border-radius:6px;
 border:1px solid #dcdcdc;
 display:inline-block;
 cursor:pointer;
 color:#666666;
 font-family:Arial;
 font-size:15px;
 font-weight:bold;
 padding:6px 24px;
 text-decoration:none;
 text-shadow:0px 1px 0px #ffffff;
}
input.btn_product_detail:hover {
 background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #e9e9e9), color-stop(1, #f9f9f9));
 background:-moz-linear-gradient(top, #e9e9e9 5%, #f9f9f9 100%);
 background:-webkit-linear-gradient(top, #e9e9e9 5%, #f9f9f9 100%);
 background:-o-linear-gradient(top, #e9e9e9 5%, #f9f9f9 100%);
 background:-ms-linear-gradient(top, #e9e9e9 5%, #f9f9f9 100%);
 background:linear-gradient(to bottom, #e9e9e9 5%, #f9f9f9 100%);
 filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e9e9e9', endColorstr='#f9f9f9',GradientType=0);
 background-color:#e9e9e9;
}
input.btn_product_detail:active {
 position:relative;
 top:1px;
}



</style>

</head>
<body>

 <!-- 상품 상세 상단 영역 시작 -->
 <article>
 <form method="post" name="formm">
  <table class="product_detail">
  	<tr><td colspan="3"></td></tr>
   <tr>
    <td rowspan="3" id="td_img_detail">
    <img src="<%=request.getContextPath() %>/productimg/${productVO.img_list}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>
    </td>
    <td style="background:#cccccc; width:2px;" rowspan="3" ></td>
    <td colspan="2">${productVO.name}</td>
   </tr>
   <tr>
    <td>가격 :</td>
    <td>| ${productVO.price}</td>
   </tr>
   <tr>
    <td>수랑 :</td>
    <td><input type="text" name="quantity" style="width:30px"/> &nbsp;
    (잔여수량 : ${productVO.quantity})</td>
   </tr>
   <tr>
    <td colspan="3" style="text-align:center;">
     <input type="hidden" name="pseq" value="${productVO.pseq}"/>
     <input type="button" class="btn_product_detail" value="ADD TO CART" class="submit" onclick="go_addcart()"/>&nbsp;&nbsp;
     <input type="button" class="btn_product_detail" value="BUY NOW" class="submit" onclick="go_buynow()" />&nbsp;&nbsp;
     <input type="button" class="btn_product_detail" value="LIST" onclick="go_list()"/>
    </td>
    
   </tr>
  </table>
  </form>
 </article>
 <!-- 상품 상세 상단 영역 끝 -->


 <!-- 상품상세 테이블 시작 -->
 <article>
  <table class="product_img_detail"><tr><td>
  <img src="<%=request.getContextPath() %>/productimg/${productVO.img_detail}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>
  <%-- <img src="<%=request.getContextPath()%>/productimg/D500_2.jpg"/> --%>
  </td></tr></table>
  
  <div id="detail_table_outline">
  <table class="table_detail_content" >
   <tr><th id="th_detail_table" colspan="2">상품 상세 정보</th></tr>
   
   <tr style="background:#999999; height:5px;"><td colspan="6"></td></tr>
   
   <c:if test="${!empty productVO.pseq}">
   <tr>
    <td class="content_td">상품번호</td>
    <td>| ${productVO.pseq}</td>
   </tr>
   </c:if>
   <tr>
    <td  class="content_td">대분류</td>
    <td>| ${productVO.first_level}</td>
   </tr>
   <tr>
    <td  class="content_td">중분류</td>
    <td>| ${productVO.second_level}</td>
   </tr>
   <tr>
    <td  class="content_td">상품명</td>
    <td>| ${productVO.name}</td>
   </tr>
   <tr>
    <td  class="content_td">가격</td>
    <td>| ${productVO.price}원</td>
   </tr>
   <tr>
    <td  class="content_td">출시일</td>
    <td>| ${productVO.indate}</td>
   </tr>
   <tr>
   
   <c:if test="${!empty productVO.sizee}">
   <tr>
    <td  class="content_td">크기</td>
    <td>| ${productVO.sizee}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.weight}">
   <tr>
    <td  class="content_td">무게</td>
    <td>| ${productVO.weight}g</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.ratio}">
   <tr>
    <td  class="content_td">센서크기</td>
    <td>| ${productVO.ratio}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.pixel}">
   <tr>
    <td  class="content_td">화소</td>
    <td>| ${productVO.pixel}만 화소</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.speed}">
   <tr>
    <td  class="content_td">최소셔터스피드</td>
    <td>| 1/${productVO.speed}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.seqpictures}">
   <tr>
    <td  class="content_td">연속촬영</td>
    <td>| ${productVO.seqpictures}매</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.screen}">
   <tr>
    <td  class="content_td">화면크기</td>
    <td>| ${productVO.screen}cm</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.iso}">
   <tr>
    <td  class="content_td">ISO</td>
    <td>| ${productVO.iso}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.movframe}">
   <tr>
    <td  class="content_td">동영상프레임</td>
    <td>| ${productVO.movframe}장</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.format}">
   <tr>
    <td  class="content_td">렌즈호환</td>
    <td>| ${productVO.format}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.filter}">
   <tr>
    <td  class="content_td">필터구경</td>
    <td>| ${productVO.filter}mm</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.functions}">
   <tr>
    <td  class="content_td">렌즈기능</td>
    <td>| ${productVO.functions}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.zoomyn}">
   <tr>
    <td  class="content_td">줌</td>
    <td>| 
    <c:if test="${productVO.zoomyn=='Y'||'y'}">
    가능
    </c:if>
    <c:if test="${productVO.zoomyn=='N'||'n'}">
    불가능
    </c:if>
    </td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.minfocus}">
   <tr>
    <td class="content_td">최소초점거리</td>
    <td>| ${productVO.minfocus}mm</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.maxfocus}">
   <tr>
    <td class="content_td">최대초첨거리</td>
    <td>| ${productVO.maxfocus}mm</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.minaperture}">
   <tr>
    <td class="content_td">최소조리개</td>
    <td>| f/${productVO.minaperture}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.maxaperture}">
   <tr>
    <td class="content_td">최대조리개</td>
    <td>| f/${productVO.maxaperture}</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.distance}">
   <tr>
    <td class="content_td">최소촬영거리</td>
    <td>| ${productVO.distance}cm</td>
   </tr>
   </c:if>
   <c:if test="${!empty productVO.types}">
   <tr>
    <td class="content_td">액세서리 분류</td>
    <td>| ${productVO.types}</td>
   </tr>
	</c:if>
	 <tr>
    <td class="content_td">상품설명</td>
    <td>| ${productVO.content}</td>
   </tr>

  </table>
  </div>
 </article>
 <!-- 상품상세 테이블 끝 -->
 
 <!-- 상품 구매 주의사항 시작 -->
 
 <!-- 상품 구매 주의사항 끝 -->

</body>
</html>