<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>nav</title>
<style>
ul{ list-style:none; margin:0; padding:0; background:#999; overflow:hidden;}
li { float:left;}
li a{padding:14px 16px; display:inline-block; text-decoration:none; color:#FFF;}
li a:hover{background:red;}
.content { background:#f9f9f9; position:absolute; min-width:160px; box-shadow:0 8px 15px #CCC; display:none;}
.content a{ display:block; color:#333;}
.content a:hover { background:#ccc;}
.dropdown:hover .content{ display:block;} 

</style>

</head>

<body>
  <ul>
  	<li><a href="#">HOME</a></li>
    <li><a href="#">NEWS</a></li>
    <li class="dropdown">
      <a href="#" class="dropbtn">DROPDOWN</a>
      <div class="content">
         <a href="#">링크1</a>
         <a href="#">링크2</a>
         <a href="#">링크3</a>
      </div>
</li>
      
  
  </ul>

<br>
<br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>
