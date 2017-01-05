<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="../header.jsp" %> --%>


<article>
<!-- <div style="height: 500px;" id="board_outside"> -->
<div id="board_outside">
	<h2>Q&amp;A List</h2>
	<h4>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h4>
	<form name="formm" method="post">
		<table class="table" id="table_board">
			<tr style="background-color: #e0e0e0">
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
				<th>답변 여부</th>
			</tr>
			<c:forEach items="${qnaList}" var="qnaVO">
				<tr>
					<td>${qnaVO.qseq}</td>
					<td><a href="qnaView.ne?qseq=${qnaVO.qseq}">
							${qnaVO.subject}</a></td>
					<td><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
					<td><c:choose>
							<c:when test="${qnaVO.rep==1}"> no </c:when>
							<c:when test="${qnaVO.rep==2}"> yes </c:when>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
		<br><br><br>
		<div id="buttons">
			<input type="button" value="1:1 질문하기" class="submit btn_default_org"
				onclick="location.href='qnaWriteForm.ne'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="쇼핑 계속하기" class="cancel btn_default_org" onclick="location.href='index'">&nbsp;&nbsp;&nbsp;
				<a href="mypageForm.ne" class="btn_default_org">마이페이지</a>
		</div>
	</form>
	</div>
</article>
<%-- <%@ include file="../footer.jsp"%> --%>