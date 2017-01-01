<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>
<style>
.table_qna_form{
margin: 10px 0 30px 0 auto;
margin-left:20%;
width:50%;
}
tr.cls_qna_form{
width:38%;
}
td.cls_qna_form{
	height:300px;
}

input.cls_qna_form{
	width:90%;
}

textarea.cls_qna_form{
	margin:auto;
	width:90%;
	height:90%;
}


</style>
	 
	<article>
	<div id="board_outside">
	    <h2> 1:1 문의 하기 </h2>
		<form name="formm" method="post" action="qnaWrite.ne">
				<!-- <legend>Board Info</legend> -->
				<table class="table_qna_form">		
			    <tr><td style="border-bottom:0;"><label>Title</label></td>
			    <td style="border-bottom:0;"><input type="text" name="subject" class="cls_qna_form" /></td></tr>
				<tr><td style="border-bottom:0;"><label>Content</label></td>
			    <td class="cls_qna_form" style="border-bottom:0;"><textarea name="content" class="cls_qna_form"></textarea></td></tr>
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