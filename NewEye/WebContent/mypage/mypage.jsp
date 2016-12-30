<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>



<style>
table#cartList {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */
    border-top: 2px solid  #8c8c8c;    
    border-bottom: 1px solid  #8c8c8c; 
     width:1500px;                  /* 전체 테이블 길이 설정 */ 
    margin-bottom: 20px;
}

 table#cartList th, td{	
    border-bottom: 1px solid  #d8d8d8; 
	text-align: center;
} 

div#ceeeee{
border: 1px solid white; 
margin: auto; 
text-align: center;
}




.classname {
	-moz-box-shadow:inset 0px 1px 8px 0px #fed897;
	-webkit-box-shadow:inset 0px 1px 8px 0px #fed897;
	box-shadow:inset 0px 1px 8px 0px #fed897;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e69215), color-stop(1, #e09626) );
	background:-moz-linear-gradient( center top, #e69215 5%, #e09626 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e69215', endColorstr='#e09626');
	background-color:#e69215;
	-webkit-border-top-left-radius:6px;
	-moz-border-radius-topleft:6px;
	border-top-left-radius:6px;
	-webkit-border-top-right-radius:6px;
	-moz-border-radius-topright:6px;
	border-top-right-radius:6px;
	-webkit-border-bottom-right-radius:6px;
	-moz-border-radius-bottomright:6px;
	border-bottom-right-radius:6px;
	-webkit-border-bottom-left-radius:6px;
	-moz-border-radius-bottomleft:6px;
	border-bottom-left-radius:6px;
	text-indent:0;
	display:inline-block;
	color:#ffffff;
	font-family:Arial;
	font-size:14px;
	font-weight:bold;
	font-style:normal;
	height:26px;
	line-height:26px;
	width:112px;
	text-decoration:none;
	text-align:center;
	text-shadow:1px 0px 0px #cd8a15;
}
.classname:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e09626), color-stop(1, #e69215) );
	background:-moz-linear-gradient( center top, #e09626 5%, #e69215 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e09626', endColorstr='#e69215');
	background-color:#e09626;
}.classname:active {
	position:relative;
	top:1px;
}




</style>







<div style="height: 700px;" id="ceeeee">
	<br>
	<br>
<article>
	<h2>My Page(${title})</h2>
	<form name="formm" method="post">
		<table  style="margin: auto; text-align: center;" id="cartList">
			<tr style="background-color: #e0e0e0">
				<th>주문일자</th>
				<th>주문번호</th>
				<th>상품명</th>
				<th>결제 금액</th>
				<th>주문 상세</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
					<td>${orderVO.oseq}</td>
					<td style="font-size: 18px">${orderVO.pname}</td>
					<td><fmt:formatNumber value="${orderVO.price}"
							type="currency" /></td>
					<td><c:choose>
							<c:when test='${orderVO.result=="1"}'> 입금대기 </c:when>
							<c:when test='${orderVO.result=="2"}'> 입금확인 </c:when>
							<c:when test='${orderVO.result=="3"}'> 배송중 </c:when>
							<c:when test='${orderVO.result=="4"}'> 배송완료 </c:when>
							<c:when test='${orderVO.result=="5"}'> 주문취소 </c:when>
							<c:when test='${orderVO.result=="6"}'> 반품중 </c:when>
							<c:when test='${orderVO.result=="7"}'> 환불완료 </c:when>
							<c:otherwise>
								<span style="color: red"> 처리완료 </span>
							</c:otherwise>
						</c:choose><a href="orderDetail.ne?oseq=${orderVO.oseq}"> [조회] </a></td>
				</tr>
			</c:forEach>
		</table>

		<div class="clear"></div>
		
		<br><br><br>
		<div id="buttons">
		<a href="index.ne" class="classname">쇼핑계속하기</a>
			<!-- <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index.ne'"> -->
		</div>
	</form>
</article>
</div>
<br>
<br>
<%-- <%@ include file="../footer.jsp"%> --%>
