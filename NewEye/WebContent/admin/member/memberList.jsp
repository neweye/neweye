<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<script type="text/javascript">
	function go_search() {
		document.frm.action = "admin/MemberList.ne";
		document.frm.submit();
	}
</script>
<article>
<div id="board_outside">
<h2>MemberList</h2>
<form name="frm" method="post">
<table class="table" id="table_board">
	<thead>
		<tr>
			<th>주문자이름 <input type="text" name="key">
				<button type="submit" class="btn btn-skin btn-block"
					onclick="go_order_search()" >검색</th>
		</tr>
	</thead>
	<tbody>
		<tr class="active">
			<th>탈퇴여부</th>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화</th>
			<th>가입일</th>
		</tr>
	</tbody>
	<c:forEach items="${memberList}" var="memberVO">
		<tr>
			<td><c:choose>
					<c:when test='${memberVO.useyn=="y"}'>
						<select name="result" size="1">
							<option value="y" selected> 회원 </option>
							<option value="n"> 탈퇴회원 </option>
						</select>
					</c:when>
					<c:otherwise>
					<select name="result" size="1">
						<option value="y"> 회원 </option>
						<option value="n" selected> 탈퇴회원 </option>
					</select>
					</c:otherwise>
				</c:choose></td>
			<td>${memberVO.id}</td>
			<td>${memberVO.name}</td>
			<td>${memberVO.password}</td>
			<td>${memberVO.zipNum}</td>
			<td>${memberVO.email}</td>
			<td>${memberVO.address}</td>
			<td>${memberVO.phone}</td>
			<td><fmt:formatDate value="${memberVO.indate }" pattern="yyyy-MM-dd" /></td>
			<td><a href="adminUpdateForm.ne?id=${memberVO.id}">수정</a>/<a href="admindeleteuseMember.ne?id=${memberVO.id }">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</form>
</div>
</article>

<%-- <h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  회원 이름
  <input type="text" name="key">
  <input class="btn" type="button" value="검색" onclick="go_search()">
  </td>
  </tr>
</table>  
<br>
<table id="table">
  <tr>
    <th> 아디디(탈퇴여부) </th>
    <th> 이름 </th>
    <th> 이메일 </th>
    <th> 우편번호 </th>  
    <th> 주소 </th>
    <th> 전화 </th>
    <th> 가입일 </th>
  </tr>
  <c:forEach items="${memberList}" var="memberVO">  
  <tr>
    <td>${memberVO.id} 
    <c:choose>
      <c:when test='${memberVO.useyn=="y"}'>
        <input type="checkbox" name="useyn" disabled="disabled">
      </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" 
checked="checked" disabled="disabled">
      </c:otherwise>
    </c:choose>
    </td>
    <td> ${memberVO.name} </td>
    <td> ${memberVO.email} </td> 
    <td> ${memberVO.zipNum} </td>
    <td> ${memberVO.address} </td>
    <td> ${memberVO.phone} </td> 
    <td> <fmt:formatDate value="${memberVO.indate}"/></td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="/admin/footer.jsp"%>
</body>
</html> --%>