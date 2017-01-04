<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>

	<article>
	<div id="board_outside">
	    <h2> 1:1 문의 하기 </h2>
		<form name="formm" method="post" action="qnaWrite.ne">
				<!-- <legend>Board Info</legend> -->
				<table class="table_qna_form">		
			    <tr><td style="border-bottom:0;"><label>Title</label></td>
			    <td style="border-bottom:0;"><input type="text" name="subject" class="cls_qna_form" /></td></tr>
				<tr><td style="border-bottom:0;"><label>Content</label></td>
			    <td class="cls_qna_form" style="border-bottom:0;"><textarea name="content" class="cls_qna_form" wrap="hard" ></textarea></td></tr>
			    </table>
		<div class="clear"></div>
		 <div id="buttons">
			<input type="submit"  value="작성완료" class="submit btn_default_org">&nbsp;&nbsp;&nbsp;
			<a href="qnaList.ne" class="btn_default_org" >돌아가기</a>&nbsp;&nbsp;&nbsp;
			<input type="button" value="쇼핑 계속하기" class="submit btn_default_org"  onclick="location.href='index.ne'">
		  </div>
		</form>
		</div>
	</article>
<%-- <%@ include file="../footer.jsp" %> --%>