function go_cart() {
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

	if (document.formm.cseq.length == undefined) {
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}

	for (var i = 0; i < document.formm.cseq.length; i++) {
		/* alert("" + document.formm.cseq[i].checked); */
		if (document.formm.cseq[i].checked == true) {
			count++;
			/* alert("" + count); */
		}
	}
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요.");

	} else {
		document.formm.action = "cartDelete";
		document.formm.submit();
	}
}

function go_order_insert() {
	var count = 0;	

	if (document.formm.cseq.length == undefined) {
		if (document.formm.cseq.checked == true) {
			count++;
		}
	}

	for (var i = 0; i < document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("주문할 항목을 선택해 주세요.");

	} else {
		document.formm.action = "orderInsert";
		document.formm.submit();
	}
}

function go_order_delete() {
	document.formm.action = "orderDelete";
	document.formm.submit();
}

function go_order_back() {
	$('#delBack').toggle(
			function(){$('#delBack').removeClass('deliveryBackProduct');}
	);
	/*removeClass('deliveryBackProduct');*/
}
function go_order_back_fin() {
	document.formm.action = "orderDelete";
	document.formm.submit();
}

function go_order() {
	document.formm.action = "mypage";
	document.formm.submit();
}
function go_mypage(){
	document.formm.action = "mypageMember";
	document.formm.submit();
}
function go_order_perfect(){
	document.formm.action = "orderList";
	document.formm.submit();
}
function go_update(form){
	   form.action="mypageMember";
	   form.method="post";
	   form.submit();
	}

	function go_delete(form){
	   form.action="deleteuseMember";
	   form.method="post";
	   form.submit();
	}
	