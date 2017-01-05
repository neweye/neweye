<meta charset="utf-8">
<%@ include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<article>
	<br> <br>
	<div id="contract">
		<h2>로그인</h2>
		<h4>Login</h4>
	</div>
	<form id="contact-form" action="adminLogin" method="post" role="form"
		class="contactForm" name="formm">
		<div class="row">
			<div class="col-lg-8 col-md-offset-2">
				<div class="form-wrapper marginbot-50">
					<div id="sendmessage">Log IN</div>
					<div id="errormessage"></div>


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
				</div>
			</div>

		</div>
	</form>
</article>

<%@ include file="footer.jsp"%>
</body>
</html>