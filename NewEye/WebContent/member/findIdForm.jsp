<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<h1>아이디.비밀번호 찾기</h1>
<form>
 이름 : <input type="text" id=id>
 전화번호 : <input type="text" id=phone>
 <input type="submit" value="전송">
</form>

</body>
</html>




 -->


<article>
	<br> <br>
	<div id="contract">
	
	<h2>아이디·비밀번호 찾기</h2>
		<h4>Find Id·Password</h4>
		
	</div>

	<div class="row">
		<div class="col-lg-8 col-md-offset-2">
			<div class="form-wrapper marginbot-50">
				<form method="post" action="findId.ne" class="contactForm"
					name="formm">
					<input name="name" type="text" class="form-control"
						placeholder="Your name"><br>
					<div class="validation"></div>
					
					<input name="phone" type="text" class="form-control"
						placeholder="Your Email"><br>
					<div class="validation"></div>
					<div class="clear"></div>


					<div id="buttons">
						<input type="submit" value="찾기" class="submit"> 
						<c:choose>
						<c:when test="${!empty member}">
						<br><br>
							<h3>아이디 : ${member.id}</h3>
							<h3>패스워드 : ${member.password}</h3>
						</c:when>
						</c:choose>
						<p></p>
						
					</div>
				</form>
			</div>
		</div>
	</div>
	</article>
