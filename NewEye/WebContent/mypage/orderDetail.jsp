<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>
<article>
	<h2>My Page(주문 상세 정보)</h2>
	<form name="formm" method="post">
		<h3>주문자 정보</h3>
		<table id="cartList" class="table">
			<tr>
				<th>주문일자</th>
				<th>주문번호</th>
				<th>주문자</th>
				<th>주문 총액</th>
				<td>처리 상태</td>
			</tr>
			<tr>
				<td><fmt:formatDate value="${orderDetail.indate}" type="date" /></td>
				<td>${orderDetail.oseq}<input type="hidden" name="oseq" value="${orderDetail.oseq}"/></td>
				<td>${orderDetail.mname}</td>
				<td><fmt:formatNumber type="currency" value="${totalPrice}" />
				</td>
				<td><c:choose>
							<c:when test='${orderDetail.result=="1"}'> 입금대기<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="2"}'> 입금확인<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="3"}'> 배송중<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="4"}'> 배송완료<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="5"}'> 주문취소<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="6"}'> 반품중<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:when test='${orderDetail.result=="7"}'> 환불완료<input type="hidden" name="result" value="${orderDetail.result}"/> </c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
		</table>
		<h3>주문 상품 정보</h3>
		<table id="cartList" class="table">
			<tr>
				<th>상품명</th>
				<th>상품별주문번호</th>
				<th>수량</th>
				<th>가격</th>
				<th>처리 상태</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td>${orderVO.pname}</td>
					<td>${orderVO.odseq}<input type="hidden" name="odseqVO" value="${orderVO.odseq}"/></td>
					<td>${orderVO.quantity}</td>
					<td><fmt:formatNumber type="currency"
							value="${orderVO.price*orderVO.quantity}" /></td>
					<td><c:choose>
							<c:when test='${orderVO.result=="1"}'> 입금대기<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="2"}'> 입금확인<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="3"}'> 배송중<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="4"}'> 배송완료<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="5"}'> 주문취소<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="6"}'> 반품중<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:when test='${orderVO.result=="7"}'> 환불완료<input type="hidden" name="resultVO" value="${orderVO.result}"/> </c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear">
		</div>
		<div id="buttons" style="float: right">
			<span id="delBack" class="deliveryBackProduct">
			<select name="deliveryBack">
				<option value="dae">대한통운</option>
				<option value="hyu">현대택배</option>
			</select>
			<input type="text" name="deliveryBackNum" placeholder="운송장번호를 입력하세요."/>
			<input type="button" value="반품신청" onclick="go_order_back()"/>
			&nbsp;&nbsp;&nbsp;
			</span>
			<c:choose>
			<c:when test='${orderDetail.result<3}'>
				<input type="button" value="취소하기" class="cancel" onclick="go_order_delete()"/>
			</c:when>
			<c:when test='${orderDetail.result<5}'>
				<input type="button" value="반품하기" class="cancel" onclick="go_order_back()"/>
			</c:when>
			</c:choose>
			<input type="button" value="목록으로" class="cancel" onclick="location.href='orderAll.ne'"/>
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index.ne'">
		</div>
	</form>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>