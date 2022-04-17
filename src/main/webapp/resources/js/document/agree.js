/**
 * 
 */

var noticeModal = null;

window.addEventListener("DOMContentLoaded", function () {

	noticeModal = new bootstrap.Modal(document.getElementById("noticeModal"));

	checkSession();
});

function checkSession() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = JSON.parse(xhr.responseText);

			//			console.log(data);

			if (data.result == 'fail') {
				alert("로그인 후 이용해주시기 바랍니다.");
				location.href = "http://barom.s001lec.com:8080/";
			} else {

			}

		}
	};

	xhr.open("get", "../user/checkSession", false);
	xhr.send();
}


function getCheckboxChecked() {
	var checkBox = document.getElementById('agreed');
	var checked = checkBox.checked;

	console.log(checked);

	if (checked) {
		window.location.href = './petition'
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