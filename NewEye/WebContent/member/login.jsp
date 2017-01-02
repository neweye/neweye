<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>
input {
  margin: 40px 25px;

  width: 200px;

  display: block;

  border: none;

  padding: 10px 0;

  border-bottom: solid 1px #1abc9c;

  -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);

  transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);

  background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);

  background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);

  background-position: -200px 0;

  background-size: 200px 100%;

  background-repeat: no-repeat;

  color: #0e6252;

}

 

input:focus, input:valid {

 box-shadow: none;

 outline: none;

 background-position: 0 0;

}

input::-webkit-input-placeholder {

 font-family: 'roboto', sans-serif;

 -webkit-transition: all 0.3s ease-in-out;

 transition: all 0.3s ease-in-out;

}

 

input:focus::-webkit-input-placeholder, input:valid::-webkit-input-placeholder {

 color: #1abc9c;

 font-size: 15px;

 -webkit-transform: translateY(-20px);

 transform: translateY(-20px);

 visibility: visible !important;

}


</style>


<article>
	<br> <br>
	<!-- <div id="contract">
	<br>
	 <img src="img/memberimage.png"/>
	<br>
	<h2>로그인</h2>
		<h4>Login</h4>
	  
		
	</div> -->
	
	

	<%-- <div class="row">
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


					<div style="text-align:center;">
						<input type="submit" class="submit btn btn-skin" value="로그인" style="width:80px;">&nbsp;&nbsp;&nbsp;
						<input type="button" class="cancel btn btn-skin" onclick="location='joinForm.ne'" value="회원가입" style="width:90px;"><br/>
						<input type="button" class="submit btn btn-skin btn-block" onclick="location='findIdForm.ne'" value="아이디 비밀번호 찾기" style="width:188px;margin:10px auto;">
					</div>
				</form>
			</div>
		</div>
	</div> --%>
	
	
	<table style="margin: auto; text-align: center;">
	<tr>
	 <td>
	   <img src="img/memberimage.png"/>
	 </td>
	
	 <td>
	
	   <form method="post" action="login.ne" class="contactForm" name="formm">
	   <input name="id" value="${id}" placeholder="Username" type="text" required>
       <input name="password" placeholder="Password" type="password" required>
       
     </td>
    
				</table>
				<div id="contract">
				<input type="submit" class="submit btn btn-skin" value="로그인" style="width:80px;">
				<input type="button" class="cancel btn btn-skin" onclick="location='joinForm.ne'" value="회원가입" style="width:90px;">
				<input type="button" class="submit btn btn-skin" onclick="location='findIdForm.ne'" value="아이디 비밀번호 찾기" style="width:188px;">
				</div>
				</form>

	

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
<br><br><br><br>
	
<%-- <%@ include file="../footer.jsp" %> --%>
