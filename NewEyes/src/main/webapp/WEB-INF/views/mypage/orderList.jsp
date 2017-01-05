<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>


	<article>
<div id="board_outside">
   <div id="contract">
      <h2>Order List</h2>
      <h4>구매 해주셔서 감사합니다.</h4>
   </div>
	<form name="formm" method="post">
		<!-- <table  style="margin: auto; text-align: center;" id="table_board"> -->
		<table class="table" id="table_board">
			<tr style="background-color: #e0e0e0">
				<th>상품명</th>
				<th>수 량</th>
				<th>가 격</th>
				<th>주문일</th>
				<th>진행 상태</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td style="font-size: 20px"><a href="productDetail?pseq=${cartVO.pseq}">
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
		<a href="mypageForm" class="btn_default_org">마이페이지</a>&nbsp;&nbsp;&nbsp;
		<a href="/" class="btn_default_org">쇼핑계속하기</a>
			<!-- <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index'"> -->
		</div>
	</form>
</div>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>