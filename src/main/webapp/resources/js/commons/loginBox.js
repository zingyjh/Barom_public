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




	var userInputId = getCookie("userInputId");
	var setCookieYN = getCookie("setCookieYN");

	if (setCookieYN == 'Y') {
		$("#saveIdBox").prop("checked", true);
	} else {
		$("#saveIdBox").prop("checked", false);
	}

	$("#idInput").val(userInputId);





	$("#loginButton").click(function () {

		if ($("#saveIdBox").is(":checked")) {
			var userInputId = $("#idInput").val();
			setCookie("userInputId", userInputId, 30);
			setCookie("setCookieYN", "Y", 30);
		} else {
			deleteCookie("userInputId");
			deleteCookie("setCookieYN");
		}



		$.ajax({
			type: "get",
			url: "../user/userLoginProcess",
			data: {
				user_id: $("#idInput").val(),
				user_pw: $("#pwInput").val(),
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				if (data.result == "success") {
					location.reload();
				} else if (data.result == "out") {

					if (confirm("비활성화된 계정입니다. 계정 활성화 페이지로 이동하시겠습니까?") == true) {
						location.href = "../user/logoutUserPorcess";
						location.href = "../user/userRecoveryPage";
					} else {
						return;
					}
				} else {
					alert("로그인에 실패하였습니다. 아이디와 비밀번호를 확인해 주세요.");
				}
			}
		});
	});


	$("#logoutButton").click(function () {

		$.ajax({
			type: "post",
			url: "../user/logoutUserPorcess",
			data: {

			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post			
			success: function (data) {
				if (confirm("정말 로그아웃하시겠습니까?") == true) {
					location.reload();
				} else {
					return;
				}
			}
		});
	});
});

//쿠키값 Set
function setCookie(cookieName, value, exdays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var cookieValue = escape(value) + ((exdays == null) ? "" : "; expires=" +
		exdate.toGMTString());
	document.cookie = cookieName + "=" + cookieValue;
}

//쿠키값 Delete
function deleteCookie(cookieName) {
	var expireDate = new Date();
	expireDate.setDate(expireDate.getDate() - 1);
	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

//쿠키값 가져오기
function getCookie(cookie_name) {
	var x, y;
	var val = document.cookie.split(';');

	for (var i = 0; i < val.length; i++) {
		x = val[i].substr(0, val[i].indexOf('='));
		y = val[i].substr(val[i].indexOf('=') + 1);
		x = x.replace(/^\s+|\s+$/g, ''); // 공백 제거

		if (x == cookie_name) {
			return unescape(y);
		}
	}
}