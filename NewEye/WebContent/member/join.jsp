<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript" src="member/member01.js"></script>


<style>
td.td_mem_form{
float:left;
text-align:left;
width:350px;
}
tr{
height:50px;
}
</style>
<article>
	   
	<div id="board_outside">
		<h2>Join Us</h2>
		<h4>회원가입</h4>
	</div>
	<div class="row">
		<div class="col-lg-8 col-md-offset-2">
			<div class="form-wrapper marginbot-50">
				<form id="join" method="post" action="login.ne" class="contactForm"
					name="formm">
					<table  style="margin:auto; text-align:left;">
					
						<tr>
							<td style="border-bottom:0;">ID: </td><td class="td_mem_form" style="border-bottom:0;"><input name="id" type="text" class="form-control">
								<!-- <div class="validation"></div> <input name="reid" type="hidden"> 
								<div class="validation"></div>  -->
								</td><td style="border-bottom:0;">
								<input type="button"
								value="중복 체크" class="btn btn-skin" onclick="idcheck()"> 
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">PASSWORD: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="pwd" type="password"
								class="form-control"> 
								<!-- <div class="validation"></div>  -->
								</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">
								PASSWORD: 
								</td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="pwdCheck"
								type="password" class="form-control"> 
								<!-- <div class="validation"></div> -->
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">NAME: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="name" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">EMAIL: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="email" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">ZIPNUM: </td><td  class="td_mem_form" style="border-bottom:0;"><input name="zipNum" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->
								</td><td style="border-bottom:0;">
								<input type="button"
								value="주소 찾기" class="btn btn-skin" onclick="post_zip()"> 
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">ADRESS: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="addr1" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">ADRESS: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="addr2" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->
							</td>
						</tr>
						<tr>
							<td style="border-bottom:0;">PHONE: </td><td class="td_mem_form" colspan="2" style="border-bottom:0;"><input name="phone" type="text"
								class="form-control"> 
								<!-- <div class="validation"></div> -->

					</table>

								<div class="clear"></div>

								<div class="text-center">
									<button type="submit" class="btn btn_default_org" onclick="go_save()">회원가입</button>&nbsp;&nbsp;&nbsp;
									<button type="submit" class="btn btn_default_org"
										onclick="history.go(-1);">취소</button>
								</div>
				</form>
			</div>
		</div>
	</div>

	<!-- <form id="join"  method="post" name="formm">
		

			<label>User ID</label> 
			<input type="text" name="id" size="12">
			<input type="hidden" name="reid"> 
			<input type="button" value="중복 체크" class="dup" onclick="idcheck()">  <label>Password</label>
			<input type="password" name="pwd">  <label>Retype
				Password</label> <input type="password" name="pwdCheck">  <label>Name</label>
			<input type="text" name="name">  <label>E-Mail</label>
			<input type="text" name="email"> 

			<label>Zip Code</label> <input type="text" name="zipNum" size="10">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"> 
			<label>Address</label> <input type="text" name="addr1" size="50">
			<input type="text" name="addr2" size="25">   <label>Phone
				Number</label> <input type="text" name="phone"> 

		<div class="clear"></div>
		<div class="text-center">
			<button type="submit" id="btnContactUs" onclick="go_save()">회원가입</button>
			<button type="submit" id="btnContactUs">취소</button>

		</div>
	</form> -->

</article>

