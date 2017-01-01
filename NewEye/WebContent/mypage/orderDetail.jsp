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

<div id="board_outside">
	<article>
<!-- <div style="height: 500px;" id="board_outside"> -->
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
				<tr style="background-color: #e0e0e0">
					<th>주문일자</th>
					<th>주문번호</th>
					<th>주문자</th>
					<th>주문 총액</th>
					<th>처리 상태</th>
				</tr>
				<tr>
					<td><fmt:formatDate value="${orderDetail.indate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${orderDetail.oseq}<input type="hidden" name="oseq"
						value="${orderDetail.oseq}" /></td>
					<td>${orderDetail.mname}</td>
					<td><fmt:formatNumber type="currency" value="${totalPrice}" />
					</td>
					<td><c:choose>
							<c:when test='${orderDetail.result=="1"}'> 입금대기<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="2"}'> 입금확인<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="3"}'> 배송중<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="4"}'> 배송완료<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="5"}'> 주문취소<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="6"}'> 반품중<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:when test='${orderDetail.result=="7"}'> 환불완료<input
									type="hidden" name="result" value="${orderDetail.result}" />
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr style="background-color: #e0e0e0">
					<th>보낸 사람</th>
					<th>연락처</th>
					<th>받는 사람</th>
					<th>연락처</th>
					<th>입금여부</th>
				</tr>
				<tr>
					<td>${orderDetail.sname}</td>
					<td>${orderDetail.sphone}</td>
					<td>${orderDetail.name}</td>
					<td>${orderDetail.phone}</td>
					<td>
						<c:choose>
							<c:when test="${orderDetail.payyn=='y'}">
								입금완료
							</c:when>
							<c:when test="${orderDetail.payyn=='b'}">
								환불완료
							</c:when>
							<c:when test="${orderDetail.payyn=='r'}">
								환불대기
							</c:when>
							<c:otherwise>
								입금대기
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="4">${orderDetail.zipNum} ${orderDetail.address}</td>
				</tr>
			</table>
			
			<div id="contract">
			<h4>주문 상품 정보</h4>
			</div>
			<table id="cartList" class="table">
				<tr style="background-color: #e0e0e0">
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
								<a href="javascript:void(window.open('https://www.doortodoor.co.kr/parcel/doortodoor.do?fsp_action=PARC_ACT_002&fsp_cmd=retrieveInvNoACT&invc_no=${orderVO.deliverynum}','delivery','width=800,height=800'))">
								${orderVO.delivery} ${orderVO.deliverynum}</a>
								</c:when>
								<c:when test="${orderVO.delivery=='로젠택배'}">
								<a href="javascript:void(window.open('http://www.ilogen.com/iLOGEN.Web.New/TRACE/TraceNoView.aspx?slipno=${orderVO.deliverynum}&gubun=slipno','delivery','width=800,height=800'))">
								${orderVO.delivery} ${orderVO.deliverynum}</a>
								</c:when>
								<c:otherwise>
								배송준비중입니다.
								</c:otherwise>
							</c:choose>
							<c:if test="${!empty orderVO.deliback}">
							<br/> 반송 : 
							<c:choose>
								<c:when test="${orderVO.deliback=='대한통운'}">
								<a href="javascript:void(window.open('https://www.doortodoor.co.kr/parcel/doortodoor.do?fsp_action=PARC_ACT_002&fsp_cmd=retrieveInvNoACT&invc_no=${orderVO.delibacknum}','delivery','width=800,height=800'))">
								${orderVO.deliback} ${orderVO.delibacknum}</a>
								</c:when>
								<c:when test="${orderDetail.deliback=='로젠택배'}">
								<a href="javascript:void(window.open('http://www.ilogen.com/iLOGEN.Web.New/TRACE/TraceNoView.aspx?slipno=${orderVO.delibacknum}&gubun=slipno','delivery','width=800,height=800'))">
								${orderVO.deliback} ${orderVO.delibacknum}></a>
								</c:when>
								<c:otherwise>
								반송준비중입니다.
								</c:otherwise>
							</c:choose>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="clear"></div>
			<div id="buttons" style="float: center">
				<c:choose>
					<c:when test='${orderDetail.result<3}'>
						<input type="button" class="btn_default_org" value="취소하기" class="cancel"
							onclick="go_order_back_fin()" />
					</c:when>
					<c:when test='${orderDetail.result<5}'>
						<input type="button" class="btn_default_org" value="반품하기" class="cancel" onclick="go_order_back()" />
					</c:when>
				</c:choose>
				<input type="button" class="btn_default_org" value="목록으로" class="cancel" onclick="location.href='orderAll.ne'" /> 
				<input type="button" class="btn_default_org" value="쇼핑 계속하기" class="cancel" onclick="location.href='index.ne'">
				<br/>
			</div>
			<br/>
			<div id="delBack" class="deliveryBackProduct">
				<br/><b>물품 반송 후 신청 바랍니다 </b><br/><br/>
				<table class="table">
					<tr style="background-color: #e0e0e0">
						<th></th>
						<th>환불계좌</th>
						<th>택배사</th>
						<th>운송장번호</th>						
						<th></th>
					</tr>
					<tr>
						<td></td>
						<td><input type="text" name="payback"/></td>
						<td>
							<select name="deliveryBack">
									<option value="대한통운">대한통운</option>
									<option value="로젠택배">로젠택배</option>
							</select>
						</td>
						<td>
							<input type="text" name="deliveryBackNum" placeholder="운송장번호를 입력하세요." /> <br/>
						</td>
						<td></td>
					</tr>
				</table>
				<input type="button" class="btn_default_org" value="반품신청" onclick="go_order_back_fin()" /> &nbsp;&nbsp;&nbsp;
				<br/>
				<br/>
				<br/>
			</div>
		</form>
	</article>
</div>
<%-- <%@ include file="../footer.jsp"%> --%>