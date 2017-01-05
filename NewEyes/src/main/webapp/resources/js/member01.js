/*function go_save(){
	$('#userCheck').click(function(){
		id= $('#id').val().trim(); //아이디에 입력한 값을 가져와
		if(id.length == 0){ //입력값이 없으면 
			$('#change').addClass('spancolor'); //span태그 컬러변경'아이디를 입력해주세요'
		return;/////////////////////////////////////////////??????????return
		}
		
		$.ajax({
			url :'idCheck.jsp',
			type : 'post',
			data : {"id" : id},
			success : function(res){
				$('#change').addClass('spancolor');
				if(res.sw=="NO"){
					$('#change').text("사용불가능");
				}else{
					$('#change').text("사용가능");
				}
			},
			dataType: 'json'
			
		})
		
	})
	////////////////////////////////////////////////////
	$('#id').focus(function(){
		$('#change').removeClass('spancolor');
		$('#change').text("아이디를입력해주세요");
		$('#id').val("");
	})
	////////////////////////////////////////////////////
	$('#codeBtn').click(function(){
		var url = "zipSearch.html";
		var options = "toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400";
		window.open(url, "우편번호검색", options);
		
	})
	////////////////////////////////////////////////////
	
	//입력한 모든 값을 가져온다. val
	
	
	$('#userBtn').click(function(){

		$.ajax({
			url : 'join.jsp',
			type : 'post',
			data : $('#ff').serialize(),
			success : function(res){
				if(res.sw=="OK"){
					$('#userok').text("성공")
				}else{
					$('#userok').text("실패")
				}
			},
			dataType : 'json'
			
		
		
		
	})
	////////////////////////////////////////////////////
	})
	document.formm.action = "join";
    document.formm.submit();
}
 */

/* 아이디 중복체크 창 */
/*function idok() {
 opener.formm.id.value = "${id}";
 opener.formm.reid.value = "${id}";
 self.close();
 }*/

function post_zip() {
	var url = "findZipNum";
	window
			.open(
					url,
					"_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}

function go_save() {
	if (document.formm.id.value == "") {
		alert("아이디를 입력하여 주세요.");
		document.formm.id.focus();
	} /*else if (document.formm.id.value != document.formm.reid.value) {
		alert("중복확인을 클릭하여 주세요.");
		document.formm.id.focus();
	}*/ else if (document.formm.password.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.formm.password.focus();
	} else if ((document.formm.password.value != document.formm.pwdCheck.value)) {
		alert("비밀번호가 일치하지 않습니다.");
		document.formm.password.focus();
	} else if (document.formm.name.value == "") {
		alert("이름을 입력해 주세요.");
		document.formm.name.focus();
	} else if (document.formm.email.value == "") {
		alert("이메일을 입력해 주세요.");
		document.formm.email.focus();
	} else {
		document.formm.action = "join";
		document.formm.submit();
	}
}

function idcheck() {
	if (document.formm.id.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.id.focus();
		return;
	}
	var url = "idCheckForm?id=" + document.formm.id.value;
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=200");
}

function post_zip() {
	var url = "findZipNum";
	window
			.open(
					url,
					"_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}

function go_next() {
	if (document.formm.okon1[0].checked == true) {
		document.formm.action = "joinForm";
		document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
		alert('약관에 동의하셔야만 합니다.');
	}
}

function go_update_admin(form) {
	form.action = "adminUpdate";
	form.method = "post";
	form.submit();
}

function go_delete_admin(form) {
	form.action = "admindeleteuseMember";
	form.method = "post";
	form.submit();
}
