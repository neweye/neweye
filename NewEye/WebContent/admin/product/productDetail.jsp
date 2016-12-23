<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>

<style>
article.productDetail_jsp{
   margin: auto;
   padding : 10px;
   text-align:center;
   
}
table.admin_product_write{
   margin: 10px  auto;
   /* border: 1px dashed #999999; */
   width:800px;
   

}

input.p_input_common{
   width: 120px ;
   maxlength:100;
}


input.th_admin_product_input{
   
   text-align:center;
}
th.th_product_add{
   width:100px;
   height:50px;
   text-indent: 0.5em;
   text-align:left;
   vartical-align:middle;
}

th#product_add_kind{
   background: #dddddd;
   vartical-align:middle;
   text-align: center;
   height:35px;
   font-size:16px;
}

td.td_product_add{
   width:100px;
   height:50px;
   text-indent: 0.5em;
   text-align:left;
   vartical-align:middle;
}


</style>

<article class="productDetail_jsp">
<h1 style="margin:20px 0">상품 상세 보기</h1> 
<form name="frm" method="post">

<table class="admin_product_write" id="list">
<tr>
  <th class="th_product_add" id="product_add_kind" colspan="6">상품분류</th>

<%--   <td colspan="5">
  <select name="kind">
  <option value="">선택</option>
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${status.count}">${kind}</option>

   </c:forEach>
  </select></td> --%>

  <!-- //////////////////////////////////////// -->
  
  
  
  <tr>
     <th class="th_product_add">상품이미지</th>
     <td class="td_product_add" colspan="5">
  <!--[7] 상품 이미지를 출력하기 -->     
     <img src="<c:url value="/productimg"/>/${productVO.img_list}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'" width="200pt" />    
     </td>
    </tr>
  
       
<tr>
   <th class="th_product_add">대분류</th>
   <td class="td_product_add">${productVO.first_level}</td>
   <th class="th_product_add">중분류</th>
   <td class="td_product_add" colspan="3">${productVO.second_level}</td>
   
   
</tr> 
<tr>
  <th class="th_product_add">상품명</th>
  <td class="td_product_add">
       ${productVO.name}
  </td>
  <th class="th_product_add">분류코드</th>
  <td class="td_product_add" colspan="3">${productVO.kind}</td>
</tr>

<tr>
<th class="th_product_add">가격</th>
  <td class="td_product_add">${productVO.price}</td>
  <th class="th_product_add">수량</th>
  <td class="td_product_add">
     ${productVO.quantity}
  </td>
   
<th  class="th_product_add">판매 여부</th>
  <td  class="td_product_add">
     ${productVO.useyn}
  
 <%--  이건 상품디테일에서<c:if test="${productVO.useyn=='Y'||'y'}">
     <input type="radio" name="useyn" checked="checked"> 판매
     <input type="radio" name="useyn" > 판매중단
    </c:if>
    <c:if test="${productVO.useyn=='N'||'n'}">
     <input type="radio" name="useyn" > 판매
     <input type="radio" name="useyn" checked="checked"> 판매중단
    </c:if>  --%> 
  </td>   
</tr>

<tr>
  <th class="th_product_add">이미지명</th>
  <td class="td_product_add">
       ${productVO.img_list}
  </td>
  <th class="th_product_add">상세이미지명</th>
  <td class="td_product_add" colspan="3">${productVO.img_detail}</td>
</tr>


<%-- dslr 부분////////////////////////////////////////////////////////
<c:if test="${status.count=='1'}"> --%>

<tr>
<th class="th_product_add" id="product_add_kind" colspan="6">DSLR</th>
</tr>
<tr>
  <th class="th_product_add">크기</th>
  <td class="td_product_add">${productVO.sizee}</td>
  <th class="th_product_add">무게</th>
  <td class="td_product_add">${productVO.weight}</td>
  <th class="th_product_add">센서크기</th>
    <td class="td_product_add">${productVO.ratio}</td>
  </tr>
  
  
  <tr>
  <th class="th_product_add">화소</th>
  <td class="td_product_add">${productVO.pixel}</td>
  <th class="th_product_add">ISO</th>
  <td class="td_product_add">${productVO.iso}</td>
  <th class="th_product_add">셔터스피드</th>
    <td class="td_product_add">${productVO.speed}</td>
  </tr>
  
    <tr>
  <th class="th_product_add">화면크기</th>
  <td class="td_product_add">${productVO.screen}</td>
  <th class="th_product_add">동영상프레임</th>
  <td class="td_product_add">${productVO.movframe}</td>
  <th class="th_product_add">연속촬영속도</th>
  <td class="td_product_add">${productVO.seqpictures}</td>
  </tr>
  
  
  
<%-- </c:if> /////////////////////////////////////////////////////////////

렌즈///////////////////////////////////////////////////////////////////////
  <c:if test="${status.count=='2'}">--%>
  
  <tr>
<th class="th_product_add" id="product_add_kind" colspan="6">렌즈</th>
</tr>


  <tr>
  <th class="th_product_add">무게</th>
  <td class="td_product_add">${productVO.weight}</td>
  <th class="th_product_add">포맷형태</th>
    <td class="td_product_add" colspan="3">${productVO.format}</td>
  </tr>
  
    <tr>
  <th class="th_product_add">필터 구경</th>
  <td class="td_product_add">${productVO.filter}</td>
  <th class="th_product_add">렌즈 기능</th>
  <td class="td_product_add">
     ${productVO.functions}
  </td>
  <th class="th_product_add">줌 여부</th>
    <td class="td_product_add">${productVO.zoomyn}</td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 초점거리</th>
  <td class="td_product_add">
    ${productVO.minfocus}
  </td>
  <th class="th_product_add">최대 초점거리</th>
  <td class="td_product_add">
     ${productVO.maxfocus}
  </td>
  <th class="th_product_add">최소 촬영거리</th>
    <td class="td_product_add">${productVO.distance}
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 조리개</th>
  <td class="td_product_add">
    ${productVO.minaperture}
  </td>
  <th class="th_product_add">최대 조리개</th>
  <td class="td_product_add">
     ${productVO.maxaperture}
  </td>
  <th class="th_product_add"></th>
    <td class="td_product_add">
    </td>
  </tr>
  
  
  
  
  
<%-- </c:if>  

악세사리/////////////////////////////////////////////////////////////////////////
  <c:if test="${status.count=='3'}"> --%>
  
  <tr>
<th class="th_product_add" id="product_add_kind" colspan="6">악세사리</th>
</tr>


  <tr>
  <th class="th_product_add">분류</th>
  <td class="td_product_add" colspan="5">
    ${productVO.types}
  </td>
</tr>
  
  
<%-- </c:if>   --%>

  
   <!-- //////////////////////////////////////// --> 
   <tr>
<th class="th_product_add" id="product_add_kind" colspan="6" style="height:5px"></th>
</tr>
 
</table>
<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. --> 
<input class="btn"  type="button" value="수정" onClick="go_mod('${tpage}','${productVO.pseq}')">
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list('${tpage}')">           
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>