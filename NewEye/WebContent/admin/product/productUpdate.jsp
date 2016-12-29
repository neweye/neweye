<%@page import="com.neweye.dto.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>


<style>
article.productUpdate_jsp{
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



<article class="productUpdate_jsp">
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="pseq" value="${productVO.pseq}">
<input type="hidden" name="read_count" value="${productVO.read_count}">
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg" value="${productVO.img_list}">
<h1 style="margin:20px 0">상품수정</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
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
   <th class="th_product_add">대분류</th>
   <td class="td_product_add"><input type="text" name="first_level" class="p_input_common" value="${productVO.first_level}"></td>
   <th class="th_product_add">중분류</th>
   <td class="td_product_add" colspan="3"><input type="text" name="second_level" class="p_input_common" value="${productVO.second_level}"></td>
   
   
</tr> 
<tr>
  <th class="th_product_add">상품명</th>
  <td class="td_product_add">
       <input type="text" name="name" class="p_input_common" value="${productVO.name }">
  </td>
  <th class="th_product_add">분류코드</th>
  <td class="td_product_add"><input type="text" name="kind" class="p_input_common" onKeyUp='NumFormat(this)' value="${productVO.kind }"></td>
  <th class="th_product_add">발매일</th>
  <td class="td_product_add"><input type="text" name="indate" class="p_input_common" onKeyUp='NumFormat(this)' value="<fmt:formatDate value="${productVO.indate }" pattern="yyyy-MM-dd" />"></td>
</tr>

<tr>
<th class="th_product_add">가격</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="price" onKeyUp='NumFormat(this)' value="${productVO.price}">
  </td>
  <th class="th_product_add">수량</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="quantity" onKeyUp='NumFormat(this)' value="${productVO.quantity}">
  </td>
   
<th  class="th_product_add">판매 여부</th>
  <td  class="td_product_add">
  <c:if test="${productVO.useyn=='Y'||'y'}">
     <input type="radio" name="useyn" value="Y" checked="checked"> 판매
     <input type="radio" name="useyn" value="N"> 판매중단
    </c:if>
    <c:if test="${productVO.useyn=='N'||'n'}">
     <input type="radio" name="useyn" value="Y"> 판매
     <input type="radio" name="useyn" value="N" checked="checked"> 판매중단
    </c:if>
  
  </td>   
</tr>


<%-- dslr 부분////////////////////////////////////////////////////////
<c:if test="${status.count=='1'}"> --%>

<tr>
<th class="th_product_add" id="product_add_kind" colspan="6">DSLR</th>
</tr>
<tr>
  <th class="th_product_add">크기</th>
  <td class="td_product_add" >
    <input type="text" class="p_input_common" name="sizee" value="${productVO.sizee}">
  </td>
  <th class="th_product_add">무게</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="weight" onKeyUp='NumFormat(this)' value="${productVO.weight}">
  </td>
  <th class="th_product_add">센서크기</th>
    <td class="td_product_add">
    <c:if test="${productVO.ratio=='1'}">
     <input type="radio" name="ratio" value="1" checked="checked"> 1:1
     <input type="radio" name="ratio" value="1.5"> 1:1.5
    </c:if>
    <c:if test="${productVO.ratio=='1.5'}">
     <input type="radio" name="ratio" value="1"> 1:1
     <input type="radio" name="ratio" value="1.5" checked="checked"> 1:1.5
    </c:if>
    </td>
  </tr>
  
  
  <tr>
  <th class="th_product_add">화소</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="pixel" onKeyUp='NumFormat(this)' value="${productVO.pixel}">
  </td>
  <th class="th_product_add">ISO</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="iso" onKeyUp='NumFormat(this)' value="${productVO.iso}">
  </td>
  <th class="th_product_add">셔터스피드</th>
    <td class="td_product_add">
      <input type="text" class="p_input_common" name="speed" onKeyUp='NumFormat(this)' value="${productVO.speed}">
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">화면크기</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="screen" value="${productVO.screen}">
  </td>
  <th class="th_product_add">동영상프레임</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="movframe" onKeyUp='NumFormat(this)' value="${productVO.movframe}">
  </td>
  <th class="th_product_add">연속촬영속도</th>
    <td class="td_product_add">
      <input type="text" class="p_input_common" name="seqpictures" onKeyUp='NumFormat(this)' value="${productVO.seqpictures}">
    </td>
  </tr>
  
  
  
<%-- </c:if> /////////////////////////////////////////////////////////////

렌즈///////////////////////////////////////////////////////////////////////
  <c:if test="${status.count=='2'}">--%>
  
  <tr>
<th class="th_product_add" id="product_add_kind" colspan="6">렌즈</th>
</tr>


  <tr>
  <th class="th_product_add">무게</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="weight" onKeyUp='NumFormat(this)' value="${productVO.weight}">
  </td>
  <th class="th_product_add">포맷형태</th>
    <td class="td_product_add" colspan="3">
    <c:if test="${productVO.format=='FX'}">
     <input type="radio" name="format" value="FX" checked="checked"> FX
     <input type="radio" name="format" value="DX"> DX
    </c:if>
    <c:if test="${productVO.format=='DX'}">
     <input type="radio" name="format" value="FX"> FX
     <input type="radio" name="format" value="DX" checked="checked"> DX
    </c:if>
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">필터 구경</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="filter" onKeyUp='NumFormat(this)' value="${productVO.filter}">
  </td>
  <th class="th_product_add">렌즈 기능</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="functions" value="${productVO.functions}">
  </td>
  <th class="th_product_add">줌 여부</th>
    <td class="td_product_add">
    <c:if test="${productVO.zoomyn=='Y'||'y'}">
     <input type="radio" name="zoomyn" value="Y" checked="checked"> 가능
     <input type="radio" name="zoomyn" value="N"> 불가능
    </c:if>
    <c:if test="${productVO.zoomyn=='N'||'n'}">
     <input type="radio" name="zoomyn" value="Y"> 가능
     <input type="radio" name="zoomyn" value="N" checked="checked"> 불가능
    </c:if>
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 초점거리</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="minfocus" onKeyUp='NumFormat(this)' value="${productVO.minfocus}">
  </td>
  <th class="th_product_add">최대 초점거리</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="maxfocus" onKeyUp='NumFormat(this)' value="${productVO.maxfocus}">
  </td>
  <th class="th_product_add">최소 촬영거리</th>
    <td class="td_product_add">
    <input type="text"class="p_input_common"  name="distance" onKeyUp='NumFormat(this)' value="${productVO.distance}">
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 조리개</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common" name="minaperture" onKeyUp='NumFormat(this)' value="${productVO.minaperture}">
  </td>
  <th class="th_product_add">최대 조리개</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="maxaperture" onKeyUp='NumFormat(this)' value="${productVO.maxaperture}">
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
    <input type="text" class="p_input_common" name="types" value="${productVO.types}">
  </td>
</tr>
  
  
<%-- </c:if>   --%>

  
   <!-- //////////////////////////////////////// --> 
   <tr>
<th class="th_product_add" id="product_add_kind" colspan="6" style="height:5px"></th>
</tr>
   
   <tr><td style="height:10px"></td></tr>
  <tr>
    <th class="th_product_add">상세설명</th>
    <td class="td_product_add" colspan="5">
      <textarea name="content" rows="8" cols="70" value="${productVO.content}"></textarea>
    </td>
  </tr>
  <tr>
    <th class="th_product_add">상품이미지</th>
    <td class="td_product_add" colspan="5">
<img src="<%=request.getContextPath() %>/productimg/${productVO.img_list}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>    
      <br>
      <input type="file" name="img_list">
    </td>
</tr>    
<tr>    
    <th class="th_product_add">상세이미지</th>
    <td class="td_product_add" colspan="5">
<img src="<%=request.getContextPath() %>/productimg/${productVO.img_detail}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>    
      <br>
      <input type="file" name="img_list">
    </td>
    
  </tr>
  <tr>
  <th class="th_product_add" id="product_add_kind" colspan="6" style="height:5px"></th>
</tr>
   <tr><td colspan="6" style="height:10px;"></td></tr>
   <tr><td style="height:10px"></td></tr>
  
</table>
<input class="btn" type="button" value="수정" onClick="go_mod_save('${tpage}','${productVO.pseq}')">           
<input class="btn" type="button" value="취소" onClick="go_mov()">
</form> 
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>