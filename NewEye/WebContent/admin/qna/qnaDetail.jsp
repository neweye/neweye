<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%@ include file="/admin/sub_menu.jsp"%>
<script type="text/javascript">
   function go_list() {
      var theForm = document.frm;
      theForm.action = "adminQnaList.ne";
      theForm.submit();
   }

   function go_rep(qseq) {
      var theForm = document.frm;
      theForm.qseq.value = qseq;
      theForm.action = "adminQnaRepsave.ne";
      theForm.submit();
   }
</script>
<article>
   <h1>Q%amp;A 게시판</h1>
   <form name="frm" method="post">
      <input type="hidden" name="qseq">
      <table id="orderList">
         <tr>
            <td class="sm_qna_view"><label>제목</label></td>
            <td class="md_qna_view">${qnaVO.subject} ${qnaVO.rep}</td>
         </tr>
         <tr>
           <td class="lg_qna_view"><td class="sm_qna_view"><label>등록일</label></td>
           <td class="md_qna_view"><td class="md_qna_view"><fmt:formatDate value="${qnaVO.indate}" /></td>
         </tr>
         <tr>
            <td class="lg_qna_view"><th>내용</th>
            <td class="md_qna_view"><td>${qnaVO.content}</td>
         </tr>
      </table>
      <c:choose>
         <c:when test='${qnaVO.rep=="1"}'>
            <table id="orderList">
               <tr>
                  <td style="border-bottom:0;"><label>작성</label>
                  </td>
               </tr>
               <tr>
                  <td colspan="2"><textarea name="reply" rows="3" cols="50"></textarea>
                     <input type="button" class="btn" value="저장"
                     onClick="go_rep('${qnaVO.qseq}')"></td>
               </tr>
            </table>
            <br>
         </c:when>
         <c:otherwise>
            <table id="orderList">
               <tr>
                  <th>댓글</th>
                  <td>${qnaVO.reply}</td>
               </tr>
            </table>
         </c:otherwise>
      </c:choose>
      <input type="button" class="btn" value="목록" onClick="go_list()">
   </form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>