<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<script type="text/javascript">
	function go_order_save() {
		var count = 0;
		if (document.frm.result.length == undefined) {
			if (document.frm.result.checked == true) {
				count++;
			}
		} else {
			for (var i = 0; i < document.frm.result.length; i++) {
				if (document.frm.result[i].checked == true) {
					count++;
				}
			}
		}
		if (count == 0) {
			alert("주문처리할 항목을 선택해 주세요.");
		} else {
			document.frm.action = "adminOrderSave.ne";
			document.frm.submit();
		}
	}

	function go_order_search() {
		var theForm = document.frm;
		var key = document.frm.key.value;
		theForm.action = "adminOrderSearch.ne?key=" + key;
		theForm.submit();
	}
</script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form name="frm" method="post">
		<div class="container">
			<h2>주문리스트</h2>
			<table class="table">
				<thead>
					<tr>
						<th>주문자이름 <input type="text" name="key">
						<button type="submit" class="btn btn-skin btn-block"
								onclick="go_order_search()">검색</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<th>주문번호(처리여부)</th>
						<th>주문자</th>
						<th>상품명</th>
						<th>수량</th>
						<th>우편번호</th>
						<th>배송지</th>
						<th>전화</th>
						<th>주문일</th>
					</tr>
				</tbody>
				<c:forEach items="${orderList}" var="orderVO">
					<tr>
						<td>
                  		   ${orderVO.odseq} &nbsp;
							<c:choose>
								<c:when test='${orderVO.result=="1"}'>
									<span style="font-weight: bold; color: red"> 입금대기 </span>
								</c:when>
								<c:when test='${orderVO.result=="2"}'>
									<span style="font-weight: bold; color: blue"> 입금확인 </span>
								</c:when>
								<c:when test='${orderVO.result=="3"}'>
									<span style="font-weight: bold; color: green"> 배송중 </span>
								</c:when>
								<c:when test='${orderVO.result=="4"}'>
									<span style="font-weight: bold; color: purple"> 배송완료 </span>
								</c:when>
								<c:when test='${orderVO.result=="0"}'>
									<span style="font-weight: bold; color: grey"> 주문취소 </span>
								</c:when>
								<c:otherwise>
									<span style="font-weight: bold; color: red"> 오류 </span>
								</c:otherwise>
							</c:choose>
							<%-- <input type="checkbox" name="result" value="${orderVO.odseq}"> --%>
						</td>
						<td>${orderVO.mname}</td>
						<td>${orderVO.pname}</td>
						<td>${orderVO.quantity}</td>
						<td>${orderVO.zipNum}</td>
						<td>${orderVO.address}</td>
						<td>${orderVO.phone}</td>
						<td><fmt:formatDate value="${orderVO.indate}" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="button" class="btn" style="width: 200px"
				value="주문처리(입금확인)" onClick="go_order_save()">
		</div>
	</form>
</body>
</html>
<%-- <article>
<h1>주문리스트</h1>
<form name="frm" method="post">
  <table style="float: right;">
    <tr>
      <td>주문자 이름 <input type="text" name="key"> 
      <input class="btn" type="button" value="검색" onclick="go_order_search()">
      </td>
    </tr>
  </table>
  <br>
  <table id="orderList">
  <tr>
    <th>주문번호(처리여부)</th><th>주문자</th><th>상품명</th><th>수량</th>
    <th>우편번호</th><th>배송지</th><th>전화</th><th>주문일</th>
  </tr>
  <c:forEach items="${orderList}" var="orderVO">
  <tr>
    <td>
      <c:choose>
        <c:when test='${orderVO.result=="1"}'>
        <span style="font-weight: bold; color: blue">${orderVO.odseq}</span>
        (<input type="checkbox" name="result" value="${orderVO.odseq}"> 미처리)
        </c:when>
        <c:otherwise>
          <span style="font-weight: bold; color: red">${orderVO.odseq}</span>
          (<input type="checkbox" checked="checked" disabled="disabled">처리완료)
        </c:otherwise>
      </c:choose>
    </td>
    <td>${orderVO.mname}</td> <td>${orderVO.pname}</td>
    <td>${orderVO.quantity}</td> <td>${orderVO.zipNum}</td>
    <td>${orderVO.address}</td>  <td>${orderVO.phone}</td>
    <td><fmt:formatDate value="${orderVO.indate}" /></td>
  </tr>
  </c:forEach>
  </table>
  <input type="button" class="btn" style="width: 200px"
      value="주문처리(입금확인)" onClick="go_order_save()">
</form>
</article>
<%@ include file="/admin/footer.jsp"%>
</body>
</html> --%>