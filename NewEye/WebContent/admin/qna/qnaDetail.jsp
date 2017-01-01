<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<script type="text/javascript">
	/* function go_QnAlist() {
		var theForm = document.frm;
		theForm.action = "adminQnaList.ne";
		theForm.submit();
	} */
	
	function go_QnAlist() { 
		 document.frm.action = "adminQnaList.ne";
		 document.frm.submit();
		}

	function go_rep(qseq) {
		var theForm = document.frm;
		theForm.qseq.value = qseq;
		theForm.action = "adminQnaRepsave.ne";
		theForm.submit();
	}
</script>
<article>
  <div id="board_outside">
	<h2>Q&amp;A 게시판</h2>
	<form name="frm" method="post">
		<input type="hidden" name="qseq">
		<table id="notice" class="table_qna_form">
			<tr>
				<td class="sm_qna_view"><label>제목</label></td>
				<td class="md_qna_view">${qnaVO.subject} ${qnaVO.rep}</td>
			</tr>
			<tr>
				<td class="sm_qna_view"><label>등록일</label></td>
				<td class="md_qna_view"><fmt:formatDate value="${qnaVO.indate}" /></td>
			</tr>
			<tr>
				<td class="lg_qna_view"><label>내용</label></td>
				<td class="md_qna_view"><textarea class="cls_qna_form" readonly >${qnaVO.content}</textarea></td>
			</tr>
		<c:choose>
			<c:when test='${qnaVO.rep=="1"}'>
					<tr>
					<td style="border-bottom:0;"><label>작성</label></td>
						<td colspan="2"><!-- <textarea name="reply" rows="3" cols="50"> -->
						<textarea class="cls_qna_form" >
						</textarea>
						</td></tr>
						</table>
							<input type="button" class="btn" value="저장"
							onClick="go_rep('${qnaVO.qseq}')">&nbsp;&nbsp;&nbsp;<input type="button" class="btn" value="목록" onClick="go_list()">

			</c:when>
			<c:otherwise>
					<tr>
						<td class="sm_qna_view"><label>답변</label></th>
						<td class="md_qna_view">${qnaVO.reply}</td>
					</tr>
				</table>
					<input type="button" class="btn" value="목록" onClick="go_QnAlist()">
			</c:otherwise>
		</c:choose>
		<!-- <input type="button" class="btn" value="목록" onClick="go_list()"> -->
	</form>
	</div>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
