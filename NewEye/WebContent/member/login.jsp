<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>
<%-- <%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>   --%>


<article>
	<br> <br>
	<div id="contract">
	
	<h2>로그인</h2>
		<h4>Login</h4>
		
	</div>

	<div class="row">
		<div class="col-lg-8 col-md-offset-2">
			<div class="form-wrapper marginbot-50">
				<form method="post" action="login.ne" class="contactForm"
					name="formm">
					<input name="id" type="text" value="${id}" class="form-control"
						placeholder="Your Id"><br>
					<div class="validation"></div>
					<input name="password" type="password" class="form-control"
						placeholder="Your Password"><br>
					<div class="validation"></div>
					<div class="clear"></div>


					<div id="buttons">
						<input type="submit" value="로그인" class="submit"> 
						<input type="button" value="회원가입" class="cancel" onclick="location='joinForm.ne'"> 
						<input type="button" value="아이디 비밀번호 찾기" class="submit" onclick="location='findIdForm.ne'">
					</div>
				</form>
			</div>
		</div>
	</div>

	<%-- 
	<form method="post" action="login.ne">
        <fieldset>
        <legend></legend>
          <label>User ID</label>
          <input name="id" type="text" value="${id}" ><br> 
          <label>Password</label> 
          <input name="password" type="password"><br> 
        </fieldset>
        <div class="clear"></div>
        
        
        <div id="buttons">
            <input type="submit" value="로그인" class="submit">
            <input type="button" value="회원가입" class="cancel"
                 onclick="location='joinForm.ne'">
            <input type="button" value="아이디 비밀번호 찾기" class="submit"
                 onclick="location='findIdForm.ne'">     
        </div>
    </form>   
 --%>
</article>
<%-- <%@ include file="../footer.jsp" %> --%>
