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
</style>




<div style="height: 500px;" id="ceeeee">
<article>
	<h2>Order List</h2>
	<form name="formm" method="post">
		<table id="cartList" class="table">
			<tr>
				<th>상품명</th>
				<th>수 량</th>
				<th>가 격</th>
				<th>주문일</th>
				<th>진행 상태</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td><a href="productDetail.ne?pseq=${cartVO.pseq}">
							<h3>${orderVO.pname}</h3>
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
		<div id="buttons" style="float: right">
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index.ne'">
		</div>
	</form>
</article>
</div>
<%-- <%@ include file="../footer.jsp"%> --%>