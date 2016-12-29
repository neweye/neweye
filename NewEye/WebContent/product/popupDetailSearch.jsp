<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<title></title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(function(){
   $('#btn_search_detail').click(function(){
         var url ="/NewEye/product/popupDetailSearch.jsp"; 
         var options = "toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400";
         
         window.open(url, "상세검색", options);
      })
   
   
})
</script>

</head>
<body>
test
</body>
</html>