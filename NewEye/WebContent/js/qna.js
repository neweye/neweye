   function go_rep(qseq) {
      var theForm = document.frm;
      theForm.qseq.value = qseq;
      theForm.action = "adminQnaRepsave.ne";
      theForm.submit();
   }