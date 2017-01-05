<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<!-- 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
<article>
<div id="board_outside">
			<h2>주문 관리</h2>
	<form name="frm" method="post">
		<table class="table" id="table_board">
  <tr>
  <td><input type="button" class="btn order_admin" style="float:left;" value="주문처리" onClick="go_order_save(this.form)"></td>
  <td id="td_table_board">주문자이름 <input type="text" name="key">&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn" onclick="go_order_search()">검색</button></td>
					</tr>
		  </table>
<table class="table" id="table_board">
    <tr class="active" style="background-color: #e0e0e0">			
						<th>주문번호(처리여부)</th>
						<th>주문자</th>
						<th>상품명</th>
						<th>수량</th>
						<th>배송지</th>
						<th>전화</th>
						<th>주문일</th>
					</tr>
				<c:forEach items="${orderList}" var="orderVO">
					<tr>
						<td>
                  		   ${orderVO.oseq} &nbsp;
                  		   <input type="hidden" name="code" value="${orderVO.oseq}"/>
							<c:choose>
								<c:when test='${orderVO.result=="1"}'>
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
								<c:when test='${orderVO.result=="2"}'>
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
								<c:when test='${orderVO.result=="3"}'>
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
								<c:when test='${orderVO.result=="4"}'>
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
								<c:when test='${orderVO.result=="5"}'>
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
								<c:when test='${orderVO.result=="6"}'>
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
								<c:when test='${orderVO.result=="7"}'>
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
							<%-- <input type="checkbox" name="result" value="${orderVO.odseq}"> --%>
						</td>
						<td>${orderVO.name}</td>
						<td><a href="adminOrderDetail?oseq=${orderVO.oseq}">${orderVO.pname}</a></td>
						<td>${orderVO.quantity}</td>
						<td>${orderVO.address}</td>
						<td>${orderVO.phone}</td>
						<%-- <td><fmt:formatDate value="${orderVO.indate }" type="date" /></td> --%>
						<td><fmt:formatDate value="${orderVO.indate}" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</table>
	</form>
	</div>
</article>