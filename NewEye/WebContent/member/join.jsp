<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript" src="member/member01.js"></script>


<article>
	<br> <br>
	<div id="contract">
		<h2>회원가입</h2>
		<h4>Join Us</h4>
	</div>
	<form id="join"  method="post" name="formm">
		<fieldset>
			<legend>Basic Info</legend>
			<label>User ID</label> <input type="text" name="id" size="12">
			<input type="hidden" name="reid"> <input type="button"
				value="중복 체크" class="dup" onclick="idcheck()"><br> <label>Password</label>
			<input type="password" name="pwd"><br> <label>Retype
				Password</label> <input type="password" name="pwdCheck"><br> <label>Name</label>
			<input type="text" name="name"><br> <label>E-Mail</label>
			<input type="text" name="email"><br>

		</fieldset>
		<fieldset>
			<legend>Optional</legend>
			<label>Zip Code</label> <input type="text" name="zipNum" size="10">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			<label>Address</label> <input type="text" name="addr1" size="50">
			<input type="text" name="addr2" size="25"> <br> <label>Phone
				Number</label> <input type="text" name="phone"><br>
		</fieldset>
		<div class="clear"></div>
		<div class="text-center">
			<button type="submit" id="btnContactUs" onclick="go_save()">회원가입</button>
			<button type="submit" id="btnContactUs">취소</button>

		</div>
	</form>
</article>

