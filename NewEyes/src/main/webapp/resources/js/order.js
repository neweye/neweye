function go_order_save() {
	document.frm.action = "adminOrderSave.ne"; 
	document.frm.submit();
}

function go_order_search() {
	var theForm = document.frm;
	var key = document.frm.key.value;
	theForm.action = "adminOrderSearch.ne?key=" + key;
	theForm.submit();
}
function go_order_admin(){
	document.formm.action = "adminOrderUpdate.ne";
	document.formm.submit();
}