<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<table class="admin_product_write" id="list">
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
    <input type="text" class="p_input_common2" name="min_price" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_price" onKeyUp='NumFormat(this)'>
    
  </td>
  
   
<th  class="th_product_add">판매 여부</th>
  <td  class="td_product_add">
     <input type="radio" name="useyn" value="" checked="checked"> 전부
     <input type="radio" name="useyn" value="Y"> 판매
     <input type="radio" value="N" name="useyn" > 품절
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
     <input type="text" class="p_input_common2" name="min_weight" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_weight" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">센서크기</th>
    <td class="td_product_add">
     <input type="radio" value="" name="ratio" checked="checked" > 전부
     <input type="radio" value="1"  name="ratio" > 1:1
     <input type="radio" value="1.5"  name="ratio"> 1:1.5
    </td>
  </tr>
  
  
  <tr>
  <th class="th_product_add">화소</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_pixel" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_pixel" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">ISO</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="min_iso" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_iso" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">셔터스피드</th>
    <td class="td_product_add">
      1/<input type="text" class="p_input_common2" name="min_speed" onKeyUp='NumFormat(this)'> ~ 
    1/<input type="text" class="p_input_common2" name="max_speed" onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">화면크기</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_screen" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_screen" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">동영상프레임</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="min_movframe" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_movframe" onKeyUp='NumFormat(this)'> 매
  </td>
  <th class="th_product_add">연속촬영속도</th>
    <td class="td_product_add">
      <input type="text" class="p_input_common2" name="min_seqpictures" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_seqpictures" onKeyUp='NumFormat(this)'> 매
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
     <input type="text" class="p_input_common2" name="min_weight" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name=max_weight onKeyUp='NumFormat(this)'>g 
      </td>
  <th class="th_product_add">포맷형태</th>
    <td class="td_product_add" colspan="3">
      <input type="radio" value="" name="format"  checked="checked"> 전부
      <input type="radio" value="FX" name="format" > FX
     <input type="radio" value="DX" name="format"> DX
    </td>
  </tr>
  
    <tr>
  <th class="th_product_add">필터 구경</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_filter" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_filter" onKeyUp='NumFormat(this)'>mm
  </td>
  <th class="th_product_add">렌즈 기능</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common" name="functions" onBlur="go_ab()" >
  </td>
  <th class="th_product_add">줌 여부</th>
    <td class="td_product_add">
      <input type="radio" value="" name="zoomyn" checked="checked"> 전부
      <input type="radio" value="Y" name="zoomyn"> 가능
     <input type="radio" value="N" name="zoomyn" > 불가능
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 초점거리</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_minfocus" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_minfocus" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최대 초점거리</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="min_maxfocus" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_maxfocus" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최소 촬영거리</th>
    <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_distance" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_distance" onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  
      <tr>
  <th class="th_product_add">최소 조리개</th>
  <td class="td_product_add">
    <input type="text" class="p_input_common2" name="min_minaperture" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_minaperture" onKeyUp='NumFormat(this)'>
  </td>
  <th class="th_product_add">최대 조리개</th>
  <td class="td_product_add">
     <input type="text" class="p_input_common2" name="min_maxaperture" onKeyUp='NumFormat(this)'> ~ 
    <input type="text" class="p_input_common2" name="max_maxaperture" onKeyUp='NumFormat(this)'>
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
<input class="btn" type="button" value="상세검색" onClick="go_search_detail(this.form)"/>
<input class="btn" type="button" id="detailBtn" value="▲" onClick="go_detail()"/><br />