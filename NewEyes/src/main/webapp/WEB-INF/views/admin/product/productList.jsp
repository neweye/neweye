<%@page import="kr.co.neweye.dto.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<article>
<div id="board_outside">
<h2>상품리스트</h2>   
<form name="frm" method="post">
<table class="table" id="table_board">
  <tr>
  <td id="td_table_board">
      상품명&nbsp;&nbsp;&nbsp;
     <input type="text" name="key">&nbsp;&nbsp;&nbsp;
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">&nbsp;&nbsp;
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">&nbsp;&nbsp;
     <input class="btn btn-skin" type="button" name="btn_write" value="상품등록" onClick="go_wrt()">&nbsp;&nbsp;
  </td>
  </tr>
  </table>
<table class="table" id="table_board">
    <tr style="background-color: #e0e0e0">
        <th>번호</th>
        <th>상품명</th>
        <th>판매가</th>
        <th>수량</th>
        <th>판매여부</th>
        <th>등록일</th>
        <th>구분</th>
    </tr>
     <c:choose>
    <c:when test="${productListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 상품이 없습니다.
      </td>      
    </tr>
    </c:when>
   <c:otherwise>
   <c:forEach items="${productList}" var="productVO">
    <tr>
      <td height="23" align="center" >${productVO.pseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" onClick="go_detail('${tpage}', '${productVO.pseq}')">
        ${productVO.name}     
         </a>
        </td>
      <td><fmt:formatNumber value="${productVO.price}"/></td>
      <td>${productVO.quantity}</td>
      <td>
         <c:choose>
             <c:when test='${productVO.useyn=="Y"||productVO.useyn=="y"}'>
             <c:if test='${productVO.kind!="0"}'>판매</c:if></c:when>
             <c:otherwise>판매중단</c:otherwise>             
          </c:choose>
          <c:if test='${productVO.kind=="0"}'>(삭제)</c:if>
        </td> 
      <td><fmt:formatDate value="${productVO.indate }" pattern="yyyy-MM-dd" /></td>
      <th><a href="adminProductUpdateForm?pseq=${productVO.pseq}">수정</a>/<a href="adminDelete?pseq=${productVO.pseq}">삭제</a></th>
    </tr>
    </c:forEach>
    <tr style="border-bottom:0;"><td colspan="7" style="border-bottom:0;text-align:center;"> ${paging}</td></tr>
   </c:otherwise>   
</c:choose>  
</table>
</form> 
</div>
</article>
