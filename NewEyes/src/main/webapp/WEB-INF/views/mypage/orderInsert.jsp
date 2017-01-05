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
							<td style="font-size: 20px"><a href="productDetail?pseq=${cartVO.pseq}">
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
			<th width="100px"><label>보낸 사람:</label></th>
			<td><input type="text" name="sname" value="${loginUser.name}"/></td>
		</tr>
		<tr>
			<th width="100px"><label>연  락  처 :</label></th>
			<td style="text-align:left;"><input type="text" name="sphone" value="${loginUser.phone}"/></td>
		</tr>
		<tr>	
			<th><label>받는사람:</label></th>
			<td><input type="text" name="mname" value="${loginUser.name}"/></td>
		</tr>
		<tr>
			<th><label>연 락 처  :</label></th>
			<td><input type="text" name="phone" value="${loginUser.phone}"/></td>
		</tr>
		<tr>
			<th><label>우편번호:</label></th>
			<td><input name="zipNum" type="text" value="${loginUser.zipNum}" readonly/>&nbsp;&nbsp;<input type="button" value="주소 찾기" onclick="post_zip()"></td>
		</tr>
		<tr>
			<th><label>주  소 :</label></th> 
			<td><input name="addr1" type="text" value="${loginUser.address}" readonly/> <input name="addr2" type="text"></td>
		</tr>
		<tr>
			<th><label>결제방법 :</label></th>
			<td>
			<select name="pay" size="1">
				<option value="우체국">우체국 0123456789</option>
				<option value="농협">농협 9876543210</option>
			</select>
			</td>
		</tr>
			</table>
		</div>
		<div class="clear"></div>
		<br><br><br>
		<div id="buttons">
		
		<a href="/" class="btn_default_org">쇼핑계속하기</a>
		<a class="btn_default_org" onclick="go_order_perfect()">주문하기</a>
			<!-- <input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index'"> -->
		</div>
	</form>
</div>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>