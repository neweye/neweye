<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>
<script type="text/javascript">
    function go_rep(qseq) {
      var theForm = document.frm;
      theForm.qseq.value = qseq;
      theForm.action = "adminQnaRepsave";
      theForm.submit();
   } 
</script>
<article>
<div id="board_outside">
   <h2>Q&amp;A 관리</h2>
   <form name="frm" method="post">
      <input type="hidden" name="qseq">
      <table class="table_qna_form">
         <tr>
            <td class="sm_qna_view"><label>제목</label></td>
            <td class="md_qna_view">${qnaVO.subject} ${qnaVO.rep}</td>
         </tr>
         <tr>
         	<td class="sm_qna_view"><label>등록일</label></td>
           <td class="md_qna_view"><fmt:formatDate value="${qnaVO.indate}" /></td>
         </tr>
         <tr>
            <td class="lg_qna_view" style="border-bottom:0;"><label>내용</label></td>
            <td class="md_qna_view" style="border-bottom:0;"><textarea class="cls_qna_form" readonly >${qnaVO.content}</textarea></td>
         </tr> 
      </table>
            <table class="table_qna_form">
               <tr>
                  <td class="lg_qna_view" style="border-bottom:0;"><label>댓글</label>
                  <td class="md_qna_view" style="border-bottom:0;"><textarea name="reply" class="cls_qna_form" >${qnaVO.reply}</textarea></td></tr>
                  <tr><td colspan="2" style="border-bottom:0;">
                     <a href="adminQnaList.ne" class="btn_default_org" >목록</a>&nbsp;&nbsp;&nbsp;
                     <input type="button" class="btn btn_default_org" style="vertical-align:middle;float:middle;" value="저장" onClick="go_rep('${qnaVO.qseq}')"></td>
               
            </table>
            <br>
      
   </form>
   </div>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>
