<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>
<%-- <%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>  --%>






<article>
	<br> <br>
	<div id="contract">
		<h2>회원가입</h2>
		<h4>Join Us</h4>
	</div>
	<div class="row">
		<div class="col-lg-8 col-md-offset-2">
			<div class="form-wrapper marginbot-50">
				<div id="sendmessage">Your message has been sent. Thank you!</div>
				<div id="errormessage"></div>
				<form id="contact-form" action="join.ne" method="post" role="form"
					class="contactForm" name="formm">

					
					<div class="form-group">
						<input type="text" name="id" class="form-control" id="id"
							placeholder="Your Id" data-rule="minlen:4"
							data-msg="Please enter at least 4 chars" />
						<div class="validation"></div>
					</div>

					<div class="form-group">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Your Password" data-rule="email"
							data-msg="Please enter a valid email" />
						<div class="validation"></div>
					</div>

					<div class="form-group">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Retype Password" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>

					<div class="form-group">
						<input type="text" class="form-control" name="name"
							id="name" placeholder="Your Name" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>

					<div class="form-group">
						<input type="text" class="form-control" name="email"
							id="email" placeholder="Your Email" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>
					
					
					
					
					
					<div class="form-group">
						<input type="text" class="form-control" name="zipNum"
							id="zipNum" placeholder="Your zipNum" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control" name="addr1"
							id="addr1" placeholder="Your addr1" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control" name="addr2"
							id="addr2" placeholder="Your addr2" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control" name="phone"
							id="phone" placeholder="Your phone" data-rule="minlen:4"
							data-msg="Please enter at least 8 chars of subject" />
						<div class="validation"></div>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-skin btn-block"
							id="btnContactUs">회원가입</button>
							<button type="submit" class="btn btn-skin btn-block"
							id="btnContactUs">취소</button>
							
					</div>
				</form>
			</div>

		</div>
	</div>
</article>



<!-- //////////////////////////////////////////////////////////////////// -->

<!-- <article>
    <h2>Join Us</h2>
    <form id="join" action="join.ne" method="post" name="formm">
      <fieldset>
        <legend>Basic Info</legend>
        <label>User ID</label>
        <input type="text"      name="id"        size="12"  >
        <input type="hidden"    name="reid">
        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br>
        <label>Password</label>  
        <input type="password"  name="password"><br> 
        <label>Retype Password</label> 
        <input type="password"  name="pwdCheck"><br> 
        <label>Name</label>
        <input type="text"      name="name"><br> 
        <label>E-Mail</label>
        <input type="text"      name="email"><br>
        
      </fieldset>
      <fieldset>
        <legend>Optional</legend>
        <label>Zip Code</label> 
        <input type="text"       name="zipNum"   size="10" >      
        <input type="button"     value="주소 찾기" class="dup" onclick="post_zip()"><br>
        <label>Address</label> 
        <input type="text"        name="addr1"   size="50">
        <input type="text"        name="addr2"   size="25"> <br>
        <label>Phone Number</label> 
        <input  type="text"       name="phone"><br>
      </fieldset>
      <div class="clear"></div>
      <div id="buttons">
        <input type="button"    value="회원가입"   class="submit" onclick="go_save()"> 
        <input type="reset"      value="취소"     class="cancel">
      </div>
    </form>
  </article> -->
<%-- <%@ include file="../footer.jsp" %> --%>


