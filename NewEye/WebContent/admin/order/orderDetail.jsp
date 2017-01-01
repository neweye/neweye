<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>

<style>
div#board_outside{
/* border: 1px solid black;  */
margin: auto; 
text-align: center;
}

</style>

<article>
<!-- <div style="height: 500px;" id="board_outside"> -->
<div id="board_outside">
		<br> <br>
		<div id="contract">
			<h2>My Page(주문 상세 정보)</h2>
		</div>
		<br>
		<form name="formm" method="post">
		<div id="contract">
			<h4>주문자 정보</h4>
			</div>
			<table id="cartList" class="table">
				<tr>
					<th>주문일자</th>
					<th>주문번호</th>
					<th>주문자</th>
					<th>주문 총액</th>
					<th>처리 상태</th>
				</tr>
				<tr>
					<td><fmt:formatDate value="${orderDetail.indate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						${orderDetail.oseq}
						<input type="hidden" name="oseq" value="${orderDetail.oseq}" />
					</td>
					<td>${orderDetail.mname}</td>
					<td><fmt:formatNumber type="currency" value="${totalPrice}" />
					</td>
					<td>
						<c:choose>
								<c:when test='${orderDetail.result=="1"}'>
									<select name="result" size="1">
										<option value="1" selected> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="2"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2" selected> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="3"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3" selected> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="4"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4" selected> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="5"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5" selected> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="6"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6" selected> 반품중 </option>
										<option value="7"> 환불완료 </option>
									</select>
								</c:when>
								<c:when test='${orderDetail.result=="7"}'>
									<select name="result" size="1">
										<option value="1"> 입금대기 </option>
										<option value="2"> 입금확인 </option>
										<option value="3"> 배송중 </option>
										<option value="4"> 배송완료 </option>
										<option value="5"> 주문취소 </option>
										<option value="6"> 반품중 </option>
										<option value="7" selected> 환불완료 </option>
									</select>
								</c:when>
								<c:otherwise>
									<span style="font-weight: bold; color: redd"> 오류 </span>
								</c:otherwise>
							</c:choose>
					</td>
				</tr>
				<tr>
					<th>보낸 사람</th>
					<th>연락처</th>
					<th>받는 사람</th>
					<th>연락처</th>
					<th>입금여부</th>
				</tr>
				<tr>
					<td><input type="text" name="sname" value="${orderDetail.sname}"/></td>
					<td><input type="text" name="sphone" value="${orderDetail.sphone}"/></td>
					<td><input type="text" name="name" value="${orderDetail.name}"/></td>
					<td><input type="text" name="phone" value="${orderDetail.phone}"/></td>
					<td>
					<c:choose>
						<c:when test="${orderDetail.payyn=='y'}">
							<select name="payyn" id="payyn">
								<option value="n">입금대기</option>
								<option value="y" selected>입금완료</option>
								<option value="b">환불완료</option>
								<option value="r">환불대기</option>
							</select>
						</c:when>
						<c:when test="${orderDetail.payyn=='b'}">
							<select name="payyn" id="payyn">
								<option value="n">입금대기</option>
								<option value="y">입금완료</option>
								<option value="b" selected>환불완료</option>
								<option value="r">환불대기</option>
							</select>
						</c:when>
						<c:when test="${orderDetail.payyn=='r'}">
							<select name="payyn" id="payyn">
								<option value="n">입금대기</option>
								<option value="y">입금완료</option>
								<option value="b">환불완료</option>
								<option value="r" selected>환불대기</option>
							</select>
						</c:when>
						<c:when test="${orderDetail.payyn=='n'}">
							<select name="payyn" id="payyn">
								<option value="n" selected>입금대기</option>
								<option value="y">입금완료</option>
								<option value="b">환불완료</option>
								<option value="r">환불대기</option>
							</select>
						</c:when>
						<c:otherwise>
							오류
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="4">${orderDetail.address}</td>
				</tr>
			</table>
			
			<div id="contract">
			<h4>주문 상품 정보</h4>
			</div>
			<table id="cartList" class="table">
				<tr>
					<th>상품별<br/>주문번호</th>
					<th>상품명</th>
					<th>수량</th>
					<th>가격</th>
					<th>처리 상태</th>
					<th>배송</th>
				</tr>
				<c:forEach items="${orderList}" var="orderVO">
					<tr>
						<td>${orderVO.odseq}<input type="hidden" name="odseqVO" value="${orderVO.odseq}" /></td>
						<td>${orderVO.pname}</td>
						<td>${orderVO.quantity}</td>
						<td><fmt:formatNumber type="currency"
								value="${orderVO.price*orderVO.quantity}" /></td>
						<td>
							<c:choose>
								<c:when test='${orderVO.result=="1"}'> 입금대기<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="2"}'> 입금확인<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="3"}'> 배송중<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="4"}'> 배송완료<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="5"}'> 주문취소<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="6"}'> 반품중<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:when test='${orderVO.result=="7"}'> 환불완료<input
										type="hidden" name="resultVO" value="${orderVO.result}" />
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
						<c:choose>
							<c:when test="${orderVO.delivery=='대한통운'}">
							<select name="delivery">
								<option value="대한통운" selected>대한통운</option>
								<option value="로젠택배">로젠택배</option>
							</select>
							<input type="text" name="deliverynum" value="${orderVO.deliverynum}"/>
							</c:when>
							<c:when test="${orderVO.deliback=='로젠택배'}">
							<select name="delivery">
								<option value="대한통운">대한통운</option>
								<option value="로젠택배" selected>로젠택배</option>
							</select>
							<input type="text" name="deliverynum" value="${orderVO.deliverynum}"/>
							</c:when>
							<c:otherwise>
							<select name="delivery">
								<option value="대한통운">대한통운</option>
								<option value="로젠택배">로젠택배</option>
							</select>
							<input type="text" name="deliverynum" value="${orderVO.deliverynum}"/>
							</c:otherwise>
						</c:choose>
						
						<c:if test="${!empty orderVO.deliback}">
						<br/> 반송 : 
						<c:choose>
							<c:when test="${orderVO.deliback=='대한통운'}">
							<select name="delibck">
								<option value="대한통운" selected>대한통운</option>
								<option value="로젠택배">로젠택배</option>
							</select>
							<input type="text" name="delibacknum" value="${orderVO.delibacknum}"/>
							</c:when>
							<c:when test="${orderVO.deliback=='로젠택배'}">
							<select name="delibck">
								<option value="대한통운">대한통운</option>
								<option value="로젠택배" selected>로젠택배</option>
							</select>
							<input type="text" name="delibacknum" value="${orderVO.delibacknum}"/>
							</c:when>
							<c:otherwise>
							<select name="delibck">
								<option value="대한통운">대한통운</option>
								<option value="로젠택배">로젠택배</option>
							</select>
							<input type="text" name="delibacknum" value="${orderVO.delibacknum}"/>
							</c:otherwise>
						</c:choose>
						</c:if>
					</td>
					</tr>
				</c:forEach>
			</table>
			<div class="clear"></div>
			<div id="buttons" style="float: right">
				<c:choose>
					<c:when test='${orderDetail.result<3}'>
						<input type="button" value="취소하기" class="cancel"
							onclick="go_order_back_fin()" />
					</c:when>
					<c:when test='${orderDetail.result<5}'>
						<input type="button" value="반품하기" class="cancel" onclick="go_order_back()" />
					</c:when>
				</c:choose>
				<input type="button" value="목록으로" class="cancel" onclick="location.href='adminOrderList.ne'" /> 
				<br/>
			</div>
			<br/>
			<div id="delBack" class="deliveryBackProduct">
				물품 반송 후 신청 바랍니다 <br/>
				환불계좌 <input type="text" name="payback"/><br/>
				<select name="deliveryBack">
						<option value="대한통운">대한통운</option>
						<option value="로젠택배">로젠택배</option>
				</select> 
				<input type="text" name="deliveryBackNum" placeholder="운송장번호를 입력하세요." /> <br/>
				<input type="button" value="반품신청" onclick="go_order_back_fin()" /> &nbsp;&nbsp;&nbsp;
			</div>
		</form>
	</article>
</div>
<%-- <%@ include file="../footer.jsp"%> --%>