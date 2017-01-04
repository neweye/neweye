<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>


<article>
<div id="board_outside">
	<h2>Order List</h2>
	<h4>${title}</h4>
	<form name="formm" method="post">
		<table class="table" id="table_board">
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
		<a href="index.ne" class="btn_default_org">쇼핑계속하기</a>&nbsp;&nbsp;&nbsp;
		<a href="mypage.ne" class="btn_default_org">진행중인 주문</a>&nbsp;&nbsp;&nbsp;
		<a href="orderAll.ne" class="btn_default_org">총 주문내역</a>&nbsp;&nbsp;&nbsp;
		<a href="mypageForm.ne" class="btn_default_org">마이페이지</a>
			<!-- <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index.ne'"> -->
		</div>
	</form>
</div>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>
