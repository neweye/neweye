<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>


<style>
table#cartList {
	border-collapse: collapse; /* border 사이의 간격 없앰 */
	border-top: 2px solid #8c8c8c;
	border-bottom: 1px solid #8c8c8c;
	width: 1500px; /* 전체 테이블 길이 설정 */
	margin-bottom: 20px;
}

table#cartList th, td {
	border-bottom: 1px solid #d8d8d8;
	text-align: center;
}

div#ceeeee {
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




<div style="height: 500px;" id="ceeeee">

	<article>
   <br> <br>
   <div id="contract">
      <h2>주문하기</h2>
      <h4>Order List</h4>
   </div>
	<form name="formm" method="post">
		<table  style="margin: auto; text-align: center;" id="cartList">
			<tr style="background-color: #e0e0e0">
				<th>상품명</th>
				<th>수 량</th>
				<th>가 격</th>
				<th>주문일</th>
				<th>진행 상태</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td style="font-size: 20px"><a href="productDetail.ne?pseq=${cartVO.pseq}">
							${orderVO.pname}
					</a></td>
					<td>${orderVO.quantity}</td>
					<td><fmt:formatNumber
							value="${orderVO.price*orderVO.quantity}" type="currency" /></td>
					<td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
					<td>처리 진행 중</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">총 액</th>
				<th colspan="2"><fmt:formatNumber value="${totalPrice}"
						type="currency" /><br></th>
				<th>주문 처리가 완료되었습니다.</th>
			</tr>
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