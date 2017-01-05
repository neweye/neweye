function go_list() { 
 document.formm.action = "product.ne";
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
  document.formm.action = "cartInsert";
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
function go_search(form) {
	var theForm = document.frm;
	var lo = window.location;
	var param = "";
	var key = "";
	
	if(lo.search!=null) {
		param = lo.search.substring(1);
		key = "&"
	}else{
		param = lo.search;
	}
	
	var start = param.indexOf("name=");
	if(start!=-1) param = param.substring(0,start-1);
	
	key += "name="+document.frm.key.value;
	key = param+key;
	
	theForm.action = lo.pathname+"?"+key;
	theForm.submit();
}
function go_search_detail(form){
	document.frm.action = "product.ne";
	document.frm.submit();
}
function go_detail(){
	$('.invisibleClass').toggle();
	$('#detailBtn').toggle(
			);
}
$(function(){
	$('#orderToList').change(order);
	function order(){
		$('option:selected').each(function(i){
			document.frm.action = "product.ne";
			document.frm.submit();
		})
	}
})
