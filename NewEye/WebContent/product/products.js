function go_list() { 
 document.formm.action = "catagory.ne";
 document.formm.submit();
}

function go_buynow() { 
	if (document.formm.quantity.value == "") {
		  alert("수량을 입력하여 주세요.");
		  document.formm.quantity.focus();
		 } else {
 document.formm.action = "orderDirectInsert.ne";
 document.formm.submit();
		 }
}


function go_addcart() {
 if (document.formm.quantity.value == "") {
  alert("수량을 입력하여 주세요.");
  document.formm.quantity.focus();
 } else {
  document.formm.action = "cartInsert.ne";
  document.formm.submit();
 }
}

function go_cart_delete() {
 var count = 0;
 for (var i = 0; i < document.formm.cseq.length; i++) {
  if (document.formm.cseq[i].checked == true) {
   count++;
  }
 }
 if (count == 0) {
  alert("삭제할 항목을 선택해 주세요.");

 } else {
  document.formm.action = "cartDelete.ne";
  document.formm.submit();
 }
}

function go_order_insert() {
 var count = 0;
 for (var i = 0; i < document.formm.oseq.length; i++) {
  if (document.formm.oseq[i].checked == true) {
   count++;
  }
 }
 if (count == 0) {
  alert("주문할 항목을 선택해 주세요.");

 } else {
  document.formm.action = "orderInsert.ne";
  document.formm.submit();
 } 
}

function go_order_delete() {
 var count = 0;
 for (var i = 0; i < document.formm.oseq.length; i++) {
  if (document.formm.oseq[i].checked == true) {
   count++;
  }
 }
 if (count == 0) {
  alert("삭제할 항목을 선택해 주세요.");

 } else {
  document.formm.action = "orderDelete.ne";
  document.formm.submit();
 }
}
function go_search() {
	var theForm = document.frm;
	var key=document.frm.key.value;
	theForm.action = "ProductSearch.ne?key="+key;
	theForm.submit();
}

/*function go_detailsearch(){
   var url ="/NewEye/product/product_search_detail.jsp"; 
   var options = "toolbar=yes,scrollbars=yes,resizable=no,top=500,left=500,width=900,height=800";
		   
   window.open(url, "상세검색", options);
}*/



/*$(function(){
	$('#btn_search_detail').click(function(){
		   var url ="/NewEye/product/product_search_detail.jsp"; 
		   var options = "toolbar=yes,scrollbars=yes,resizable=no,top=500,left=500,width=900,height=800";
		   
		   window.open(url, "상세검색", options);
	   })
	/////////////////////////////
	   
	   $('#btn_submit_dsearch').click(function(){
		   var theForm = document.frm;
			var key=document.frm.key.value;
			theForm.action = "ProductSearch.ne?key="+key;
			theForm.submit();
	   })
	/////////////////////////////   
	    $('#btn_cancel_dsearch').click(function(){
	    	window.close();
	   })
	
})*/



/*
function do_submit_dsearch() {
	var theForm = document.frm;
	var key=document.frm.key.value;
	theForm.action = "ProductSearch.ne?key="+key;
	theForm.submit();
}

function go_cancle() {
	window.close();
}*/


