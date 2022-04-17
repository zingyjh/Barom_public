/**
 * 
 */


window.addEventListener("DOMContentLoaded", function () {

	$('#idInput').keypress(function (e) {

		if (e.keyCode == 13) {
			$("#loginButton").click();
		}

	});

	$('#pwInput').keypress(function (e) {

		if (e.keyCode == 13) {
			$("#loginButton").click();
		}

	});

	$("#loginButton").click(function () {

		$.ajax({
			type: "get",
			url: "./adminLoginProcess",
			data: {
				admin_id: $("#idInput").val(),
				admin_pw: $("#pwInput").val()
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				if (data.result == "site") {
					location.href = "./siteAdmin/siteAdminPage";
				} else if (data.result == "staff") {
					location.href = "./staffAdmin/staffAdminPage";
				} else if (data.result == "court") {
					location.href = "./courtAdmin/courtAdminPage";
				} else if (data.result == "fail") {
					alert("로그인에 실패하였습니다. 아이디와 비밀번호를 확인해 주세요.");
				}
			}


		});
	});
});