<meta charset="utf-8">
<%@ include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ include file="../header.jsp" %> --%>
<%-- <%@ include file="sub_img.jsp"%> 
<%@ include file="sub_menu.jsp" %>  --%>

<article>
	<br> <br>
	<div id="contract">
		<h2>로그인</h2>
		<h4>Login</h4>
	</div>
	<form name="frm" method="post" action="adminLogin.ne">
		<div class="row">
			<div class="col-lg-8 col-md-offset-2">
				<div class="form-wrapper marginbot-50">
					<div id="sendmessage">Log IN</div>
					<div id="errormessage"></div>
					<form id="contact-form" action="adminLogin" method="post" role="form"
						class="contactForm" name="formm">


						<div class="form-group">
							<input type="text" name="workerId" class="form-control"
								placeholder="Your Id" data-rule="minlen:4" />
							<div class="validation"></div>
						</div>

						<div class="form-group">
							<input type="password" class="form-control" name="workerPassword"
								placeholder="Your Password" data-rule="email" />
							<div class="validation"></div>
						</div>

						<button type="submit" class="btn btn-skin btn-block"
							onclick="return worker_check()">로그인</button>
					</form>
				</div>
	</div>

	</div>
	</div>
</article>


<%-- <div id="wrap">
    <div class="contract"></div>
      <div class="" id="loginform">
      <form name="frm" method="post" action="adminLogin.ne">
      <table>
        <tr>
          <td> ID </td>
          <td> <input type="text" name="workerId" size="10" value="admin"></td>
        </tr>
        <tr>
          <td> Password </td>
          <td> 
            <input type="password" name="workerPassword" size="10" value="admin">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">          
            <input class="btn" type="submit" value="admin login" onclick="return worker_check()"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
      </div>
  </div> --%>
<%@ include file="footer.jsp"%>
</body>
</html>