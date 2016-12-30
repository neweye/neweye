<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>

<%-- <%@ include file="sub_img.jsp"%>
<%@ include file="sub_menu.jsp"%> --%>

<%-- css는 shopping.css로 나중에 옮길것! --%>

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




</style>


<div style="height: 500px;" id="ceeeee">
<article>
   <br> <br>
   <div id="contract">
      <h2>장바구니</h2>
      <h4>Cart List</h4>
   </div>

	<form name="formm" method="post">
		<c:choose>
			<c:when test="${cartList.size() == 0}">
				<h3 style="color: red; text-align: center;">장바구니가 비었습니다.</h3>
			</c:when>
			<c:otherwise>
				<table  style="margin: auto; text-align: center;" id="cartList">
					<tr style="background-color: #e0e0e0">
						<th>상품명</th>
						<th>수 량</th>
						<th>가 격</th>
						<th>주문일</th>
						<th>삭 제</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td style="font-size: 20px"><a href="productDetail.ne?pseq=${cartVO.pseq}">
									${cartVO.pname}
							</a></td>
							<td>${cartVO.quantity}</td>
							<td><fmt:formatNumber value="${cartVO.price*cartVO.quantity}" type="currency" /></td>
							<td><fmt:formatDate value="${cartVO.indate}" type="date" /></td>
							<td><input type="checkbox" name="cseq" value="${cartVO.cseq}"></td>
						</tr>
					</c:forEach>

					<tr>
						<th colspan="2">총 액</th>
						<th colspan="2"><fmt:formatNumber value="${totalPrice}"
								type="currency" /><br></th>
						<th><a href="#" onclick="go_cart_delete()" >삭제하기</a></th>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>

		<div class="clear"></div>
		<br><br><br>
		<div id="buttons">
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='index.ne'">
			<c:if test="${cartList.size() != 0}">
				<input type="button" value="주문하기" class="submit"
					onclick="go_order_insert()">
			</c:if>
		</div>
	</form>
</article>
</div>
<%-- <%@ include file="../footer.jsp"%> --%>