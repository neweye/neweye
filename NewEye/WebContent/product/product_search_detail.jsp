<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%@ include file="/admin/header.jsp"%> --%>
<%-- <%@ include file="/admin/sub_menu.jsp"%> --%>

<script>
function do_submit_dsearch(){
		   var theForm = document.frm;
			var key=document.frm.key.value;
			theForm.action = "ProductSearch.ne?key="+key;
			theForm.submit();
	   }
function do_close_dsearch(){
	    	self.close();
	   }

</script>


<style>
article.productWrite_jsp{
   margin: auto;
   padding : 10px;
   text-align:center;
   
}
table.admin_product_write{
   margin: auto;
   /* border: 1px dashed #999999; */
   width:800px;
   

}

input.p_input_common{
   width: 120px ;
   maxlength:100;
}

input.p_input_common2{
   width: 40px ;
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



<article class="productWrite_jsp">

<h1 style="margin:20px 0">상품상세검색</h1>  

<form name="frm" method="post" enctype="multipart/form-data">

<table class="admin_product_write" id="list">
<tr><td colspan="6" style="text-align:right;">
  <select name="kind">
  <option value="">선택</option>
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${status.count}">${kind}</option>

   </c:forEach>
  </select>
</td></tr>
<tr>
  <th class="th_product_add" id="product_add_kind" colspan="6">상품분류</th></tr>

 

  <!-- //////////////////////////////////////// -->     
<tr>
  <th class="th_product_add">상품명</th>
  <td class="td_product_add">
       <input type="text" name="name" class="p_input_common">
  </td>
  
<th class="th_product_add">가격</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
    
  </td>
  
   
<th  class="th_product_add">판매 여부</th>
  <td  class="td_product_add">
     <input type="radio" name="useyn" value="Y" checked="checked"> 판매
     <input type="radio" value="N" name="useyn" > 품절
  
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


<%-- dslr 부분////////////////////////////////////////////////////////
<c:if test="${status.count=='1'}"> --%>

<tr>
<th class="th_product_add" id="product_add_kind" colspan="6">DSLR</th>
</tr>
<tr>
   <th class="th_product_add">무게</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">센서크기</th>
    <td class="td_product_add">
      <input type="radio" value="1:1"  name="ratio" > 1:1
     <input type="radio" value="1:1.5"  name="ratio" checked="checked"> 1:1.5
    </td>
  </tr>
  
  
  <tr>
  <th class="th_product_add">화소</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">ISO</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">셔터스피드</th>
    <td class="td_product_add">
      1/<input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    1/<input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">화면크기</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">동영상프레임</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> 매
  </td>
  <th class="th_product_add">연속촬영속도</th>
    <td class="td_product_add">
      <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> 매
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
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>g 
      </td>
  <th class="th_product_add">포맷형태</th>
    <td class="td_product_add" colspan="3">
      <input type="radio" value="FX" name="format" > FX
     <input type="radio" value="DX" name="format" checked="checked"> DX
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">필터 구경</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>mm
  </td>
  <th class="th_product_add">렌즈 기능</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="functions" onBlur="go_ab()" >
  </td>
  <th class="th_product_add">줌 여부</th>
    <td class="td_product_add">
      <input type="radio" value="Y" name="zoomyn" checked="checked"> 가능
     <input type="radio" value="N" name="zoomyn" > 불가능
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 초점거리</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최대 초점거리</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최소 촬영거리</th>
    <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 조리개</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최대 조리개</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="price" onKeyUp='NumFormat(this)'>
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
  <!-- 콤보박스로 선택가능하면 좋을듯 -->
  
    <input type="text" class="p_input_common" name="types">
  </td>
</tr>
  
  
<%-- </c:if>   --%>

  
   <!-- //////////////////////////////////////// --> 
   <tr>
<th class="th_product_add" id="product_add_kind" colspan="6" style="height:5px"></th>
</tr>
</table>
<input class="btn" type="button" value="검색" onClick="do_submit_dsearch()" id="btn_submit_dsearch"> &nbsp;&nbsp;          
<input class="btn" type="button" value="취소" onClick="do_close_dsearch()" id="btn_cancel_dsearch">
</form> 
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>