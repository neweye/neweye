<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>	 
<%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>   
	<article>
	    <h2> 1:1 고객 게시판 </h2>
	    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
		<form name="formm" method="post" 
		action="qnaWrite.ne">
			<fieldset>	
				<legend>Board Info</legend>		
			    <label>Title</label>
			    <input type="text" name="subject"  size="64" ><br>
				<label>Content</label>
			    <textarea rows="8" cols="65" name="content"></textarea><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="submit"  value="글쓰기"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='index.ne'">	
		  </div>
		</form>
	</article>
<%-- <%@ include file="../footer.jsp" %> --%>