<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%-- <%@ include file="../header.jsp" %> --%>
<!-- <script src="//code.jquery.com/jquery.min.js"></script>
<script>
$(function() {
	  $("textarea.cls_qna_form").keyup(function () {
	    $(this).css("height","30px").css("height",(20+$(this).prop("scrollHeight"))+"px");
	  });
	});

</script> -->
   
  <article>
  <div id="board_outside">
      <h2> 1:1 고객 게시판 </h2>
    <form name="formm" method="post">
    <table id="notice" class="table_qna_form">
      <tr>
              <td class="sm_qna_view"><label>제목</label></td>
              <td class="md_qna_view">${qnaVO.subject}</td> 
      </tr>
      <tr>
        <td class="sm_qna_view"><label>등록일</label></td>
        <td class="md_qna_view"><fmt:formatDate value="${qnaVO.indate}" type="date" /></td>
      </tr>
      <tr>
        <td class="lg_qna_view"><label>질문내용</label></td>
        <td class="md_qna_view"><textarea class="cls_qna_form" readonly >${qnaVO.content}</textarea></td>
        <%-- <td class="md_qna_view"><textarea class="cls_qna_form" readonly onkeyup="resize(this)">${qnaVO.content}</textarea></td>  --%> 
      </tr>
      <tr>
        <td style="border-bottom:0;"><label>답변내용</label></td>
        <td class="lg_qna_view" style="border-bottom:0;"><textarea class="cls_qna_form" readonly onkeyup="resize(this)">${qnaVO.reply}</textarea></td>
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons">
      <input type="button"  value="목록보기"     class="submit"  onclick="location.href='qnaList.ne'"> 
      <input type="button"  value="쇼핑 계속하기"  class="cancel"  onclick="location.href='index.ne'">  
      </div>
    </form>
    </div>
  </article>
<%-- <%@ include file="../footer.jsp" %> --%>