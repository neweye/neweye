<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

 setTimeout("move()",0);
 function move(){
 	location.href="<%=request.getContextPath() %>/index.jsp"
 }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<div>
	메인 페이지로 이동합니다...
</div>

</body>
</html>