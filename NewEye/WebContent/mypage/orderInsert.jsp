<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>


	<article>
<div id="board_outside">
   <div id="contract">
      <h2>주문하기</h2>
      <h4>Order List</h4>
   </div>
	<form name="formm" method="post">
		<!-- <table  style="margin: auto; text-align: center;" id="table_board"> -->
		<table class="table" id="table_board">
					<tr style="background-color: #e0e0e0">
						<th>상품명</th>
						<th>수 량</th>
						<th>가 격</th>
						<th>주문일</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td style="font-size: 20px"><a href="productDetail.ne?pseq=${cartVO.pseq}">
									${cartVO.pname}<input type="hidden" name="cseq" value="${cartVO.cseq}">
							</a></td>
							<td>${cartVO.quantity}</td>
							<td><fmt:formatNumber value="${cartVO.price*cartVO.quantity}" type="currency" /></td>
							<td><fmt:formatDate value="${cartVO.indate}" type="date" /></td>
						</tr>
					</c:forEach>

					<tr>
						<th colspan="2">총 액</th>
						<th colspan="2"><fmt:formatNumber value="${totalPrice}"
								type="currency" /><br></th>
					</tr>
				</table>
		<div id="orderInfo">
		<table class="table" id="table_board_left" style="text-align: left;">
		<tr>
			<th>보낸 사람 : <input type="text" name="sname" value="${loginUser.name}"/></td>
		</tr>
		<tr>
			<th>연락처 : <input type="text" name="sphone" value="${loginUser.phone}"/></th>
		</tr>
		<tr>	
			<th>받는 사람 : <input type="text" name="mname" value="${loginUser.name}"/></th>
		</tr>
		<tr>
			<th>연락처 : <input type="text" name="phone" value="${loginUser.phone}"/></th>
		</tr>
		<tr>
			<th>우편번호: <input name="zipNum" type="text" value="${loginUser.zipNum}" readonly/>&nbsp;&nbsp;<input type="button" value="주소 찾기" onclick="post_zip()"></th>
		</tr>
		<tr>
			<th>주소 : <input name="addr1" type="text" value="${loginUser.address}" readonly/> <input name="addr2" type="text"></th>
		</tr>
		<tr>
			<th>결제방법 : 
			<select name="pay" size="1">
				<option value="우체국">우체국 0123456789</option>
				<option value="농협">농협 9876543210</option>
			</select>
			</th>
		</tr>
			</table>
		</div>
		<div class="clear"></div>
		<br><br><br>
		<div id="buttons">
		
		<a href="index.ne" class="btn_default_org">쇼핑계속하기</a>
		<a class="btn_default_org" onclick="go_order_perfect()">주문하기</a>
			<!-- <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index.ne'"> -->
		</div>
	</form>
</div>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>