/*function go_save() {
  if (document.formm.id.value == "") {
    alert("아이디를 입력하여 주세요.");
    document.formm.id.focus();
  } else if (document.formm.id.value != document.formm.reid.value) {
    alert("중복확인을 클릭하여 주세요.");
    document.formm.id.focus();
  } else if (document.formm.password.value == "") {
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
}*/

/*function idcheck() {
  if (document.formm.id.value == "") {
    alert('아이디를 입력하여 주십시오.');
    document.formm.id.focus();
    return;
  }
  var url = "idCheckForm?id="+ document.formm.id.value;
  window.open( url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=200");
}
*/
function post_zip() {
  var url = "findZipNum1";
  window.open( url, "_blank_1",
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



