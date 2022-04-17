/**
 * 
 */

var noticeModal = null;

window.addEventListener("DOMContentLoaded", function () {

	noticeModal = new bootstrap.Modal(document.getElementById("noticeModal"));
	noticeModal2 = new bootstrap.Modal(document.getElementById("noticeModal2"));


});



function getCheckboxChecked() {
	var checkBox = document.getElementById('agreed');
	var checkBox2 = document.getElementById('agreed2');
	var checked = checkBox.checked;
	var checked2 = checkBox2.checked;

	console.log(checked);

	if (checked && checked2) {
		window.location.href = './joinUserPage'
	} else if (checked2) {
		noticeModal.show();
	} else if (checked) {
		noticeModal2.show();
	} else {
		noticeModal.show();
	}
}

function showNoticeModal() {

	noticeModal.show();
}

function closeNoticeModal() {

	noticeModal.hide();
}

function showNoticeModal2() {

	noticeModal2.show();
}

function closeNoticeModal2() {

	noticeModal2.hide();
}