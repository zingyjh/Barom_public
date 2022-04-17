/**
 * 
 */

var user_info = [];

var case_info = {
	case_no: "",
	basicInfo_no: 0,
	plaintiff_count: 0,
	defendant_count: 0,
	purpose_no: 0,
	cause_no: 0
};


window.addEventListener("DOMContentLoaded", function () {

	checkSession();

	var case_no = document.getElementById("case_code").value;
	console.log(case_no);
	if (case_no != "") {
		case_info.case_no = case_no;
	}

});

function checkSession() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = JSON.parse(xhr.responseText);

			if (data.result == 'fail') {
				alert("로그인 후 이용해주시기 바랍니다.");
				location.href = "http://barom.s001lec.com:8080/";
			} else {
				user_info = data.sessionUser;
			}

		}
	};

	xhr.open("get", "../user/checkSession", false);
	xhr.send();
}


function trykakaoPay() {

	$.ajax({
		url: "../pay/kakaopay",
		data: {
			"case_no": case_info.case_no
		},
		success: function (response) {
			console.log(response);
			var data = JSON.parse(response);
			console.log(data);
			if (data.status === 500) {
				console.log("failed");
				showNoticeModal("결제 api 불러오기에 실패했습니다.");
			} else {
				location.href = data.next_redirect_pc_url;
				//				var url = data.next_redirect_pc_url;
				//	            var name = "kakao pay";
				//	            var option = "width = 500, height = 500, top = 100, left = 200, location = no"
				//	            window.open(url, name, option);
			}
		},
		error: function (xhr, status, error) {
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}