<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<article>
   <br> <br>
   <div id="contract">
      <h2>회원정보수정</h2>
      <h4>Modyfy</h4>
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
                     data-rule="minlen:4" readonly="readonly"
                     data-msg="Please enter at least 4 chars" value="${loginUser.id}"/>
                  <div class="validation"></div>
               </div>
               <div class="form-group">
                  <input type="password" class="form-control" name="password"
                     id="password" placeholder="Your Password" data-rule="email"
                     data-msg="Please enter a valid email" value="${loginUser.password}"/>
                  <div class="validation"></div>
               </div>

               <div class="form-group">
                  <input type="password" class="form-control" name="Retypepassword"
                     id="password" placeholder="Retype Password" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject"  "/>
                  <div class="validation"></div>
               </div>

               <div class="form-group">
                  <input type="text" class="form-control" name="name"
                     id="name" placeholder="Your Name" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.name}"  />
                  <div class="validation"></div>
               </div>

               <div class="form-group">
                  <input type="text" class="form-control" name="email"
                     id="email" placeholder="Your Email" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.email}" />
                  <div class="validation"></div>
               </div>
               
               
               
               
               
               <div class="form-group">
                  <input type="text" class="form-control" name="zipNum"
                     id="zipNum" placeholder="Your zipNum" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.zipNum}"/>
                  <div class="validation"></div>
               </div>
               
               <div class="form-group">
                  <input type="text" class="form-control" name="address"
                     id="addr1" placeholder="Your addr1" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.address}"/>
                  <div class="validation"></div>
               </div>
               
               <%-- <div class="form-group">
                  <input type="text" class="form-control" name="addr2"
                     id="addr2" placeholder="Your addr2" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.address}"/>
                  <div class="validation"></div>
               </div> --%>
               
               <div class="form-group">
                  <input type="text" class="form-control" name="phone"
                     id="phone" placeholder="Your phone" data-rule="minlen:4"
                     data-msg="Please enter at least 8 chars of subject" value="${loginUser.phone}"/>
                  <div class="validation"></div>
               </div>
               
               
               
               
               
               
               
               
               





               <div id="buttons">
                  <input type="button" value="수정" class="submit" onclick="go_update(this.form)">
                  <input type="button" value="탈퇴" class="cancel" onclick="go_delete(this.form)"> 
                  <input type="button" value="뒤로가기" class="submit" onclick="history.go(-1);">
               </div>
            </form>
         </div>

      </div>  
   </div>
</article>
<script>
function go_update(form){
   form.action="mypageMemberUpdate.ne";
   form.method="post";
   form.submit();
}

function go_delete(form){
	form.action="mypageMemberDelete.ne";
	form.method="post";
	form.submit();
}
</script>