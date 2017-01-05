<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<article>
	<br> <br>
	<div id="contract">
		<h2>회원가입</h2>
		<h4>Join Us</h4>
	</div>

	<div class="row">
		<div class="col-lg-8 col-md-offset-2">
			<div class="form-wrapper marginbot-50">
				<form id="formm" name="formm" method="post" action="join" class="contactForm">
					${message}
					ID: <input name="id" type="text" class="form-control"><br>
					<div class="validation"></div>

					<input name="reid" type="hidden"><br>
					<div class="validation"></div>

					<input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>

					PASSWORD: <input name="pwd" type="password" class="form-control"><br>
					<div class="validation"></div>

					PASSWORD: <input name="pwdCheck" type="password"
						class="form-control"><br>
					<div class="validation"></div>

					NAME: <input name="name" type="text" class="form-control"><br>
					<div class="validation"></div>

					EMAIL: <input name="email" type="text" class="form-control"><br>
					<div class="validation"></div>

					ZIPNUM: <input name="zipNum" type="text" class="form-control"><br>
					<div class="validation"></div>

					<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>

					ADRESS: <input name="addr1" type="text" class="form-control"><br>
					<div class="validation"></div>

					ADRESS: <input name="addr2" type="text" class="form-control"><br>
					<div class="validation"></div>

					PHONE: <input name="phone" type="text" class="form-control"><br>
					<div class="validation"></div>


					<div class="clear"></div>


					<div class="text-center">
						<button type="submit" id="btnContactUs" onclick="go_save()">회원가입</button>
						<button type="submit" id="btnContactUs" onclick="history.go(-1);">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- <form id="join"  method="post" name="formm">
		

			<label>User ID</label> 
			<input type="text" name="id" size="12">
			<input type="hidden" name="reid"> 
			<input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br> <label>Password</label>
			<input type="password" name="pwd"><br> <label>Retype
				Password</label> <input type="password" name="pwdCheck"><br> <label>Name</label>
			<input type="text" name="name"><br> <label>E-Mail</label>
			<input type="text" name="email"><br>

			<label>Zip Code</label> <input type="text" name="zipNum" size="10">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			<label>Address</label> <input type="text" name="addr1" size="50">
			<input type="text" name="addr2" size="25"> <br> <label>Phone
				Number</label> <input type="text" name="phone"><br>

		<div class="clear"></div>
		<div class="text-center">
			<button type="submit" id="btnContactUs" onclick="go_save()">회원가입</button>
			<button type="submit" id="btnContactUs">취소</button>

		</div>
	</form> -->

</article>

