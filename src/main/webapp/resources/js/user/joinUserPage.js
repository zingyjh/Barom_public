/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {



	$("#changePassword").keyup(function () {
		var value = $(event.target).val();

		var num = value.search(/[0-9]/g);
		var eng = value.search(/[a-z]/ig);
		var spe = value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		if (value.length < 8 || value.length > 30) {
			$("#alterPassword").css({
				"color": "red"
			});
			$("#alterPassword").text("!  비밀번호는 8자리이상 30자리 이하여야 합니다.")
		} else if (value.replace(/\s|　/gi, "").length == 0) {
			$("#alterPassword").css({
				"color": "red"
			});
			$("#alterPassword").text("!  비밀번호에 공백은 사용할 수 없습니다.")
		} else if (num < 0 || eng < 0 || spe < 0) {
			$("#alterPassword").css({
				"color": "red"
			});
			$("#alterPassword").text("!  비밀번호는 영어+숫자+특수문자로 이루어져야 합니다.")
		} else {
			$("#alterPassword").css({
				"color": "black"
			});
			$("#alterPassword").text("✔  사용가능한 비밀번호입니다.");
		}
	});

	$("#confirmPassword").keyup(function () {
		var value = $("#confirmPassword").val();


		if (value != $("#changePassword").val()) {
			$("#alterPassword2").css({
				"color": "red"
			});
			$("#alterPassword2").text("!  비밀번호가 일치하지 않습니다.")
			return;
		};
		$("#alterPassword2").css({
			"color": "black"
		});
		$("#alterPassword2").text("✔  비밀번호가 일치합니다.");
	});

	$("#checkIdButton").click(function () {
		var value = $("#joinIdInput").val();

		if (value.replace(/\s|　/gi, "").length == 0) {
			$("#alertId").css({
				"color": "red"
			});
			$("#alertId").text("!  아이디를 입력해주세요.")
			return;
		}



		$.ajax({
			type: "get",
			url: "./checkId",
			data: {
				user_id: $("#joinIdInput").val()
			},
			dataType: "json",
			//contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				if (data.result == "fail") {
					$("#alertId").css({
						"color": "red"
					});
					$("#alertId").text("! 이미 사용중인 아이디입니다.")
				} else {
					$("#alertId").css({
						"color": "black"
					});
					$("#alertId").text("✔  사용 가능한 아이디입니다.")
				}
			}
		});
	});

	$("#jipcodeButton").click(function () {
		new daum.Postcode({
			oncomplete: function (data) {

				var fullAddr = '';
				var extraAddr = '';

				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우 
					fullAddr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J) 
					fullAddr = data.jibunAddress;
				}
				if (data.userSelectedType === 'R') {
					if (data.bname !== '') {
						extraAddr += data.bname;
					}
					if (data.buildingName !== '') {
						extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다. 
				document.getElementById('userZipcode').value = data.zonecode; //5자리 새우편번호 사용 
				document.getElementById('userAddress').value = fullAddr; // 커서를 상세주소 필드로 이동한다. 
				document.getElementById('userSendAddress').focus();
			}
		}).open();

	});


	/*이메일 a@a.m불가능  a@a.mm 가능*/
	var code = "";
	$("#checkEmailButton").click(function () {
		var userEmail = $("#userEmail").val();
		if (userEmail == '') {
			alert('이메일주소를 입력하세요');
			userEmail.focus();
			return false;
		} else {
			var emailRegex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			if (!emailRegex.test(userEmail)) {
				alert('이메일 주소가 유효하지 않습니다. ex)abc@gmail.com');
				userEmail.focus();
				return false;
			}
		}


		$.ajax({
			type: "GET",
			url: "mailCheck?userEmail=" + userEmail,
			success: function (data) {
				if (data == "error") {
					alert("서버와 통신중 에러가 발생했습니다.");
					$("#userEmail").attr("autofocus", true);
					$("#alertEmail").text("서버와 통신중 에러가 발생했습니다.")
					$("#alertEmail").css({
						"color": "red"
					});
				} else {
					alert("인증번호 발송이 완료되었습니다. 입력한 이메일에서 인증번호 확인을 해주세요.");
					$("#checkEmail").attr("disabled", false);
					$("#alertEmail").text("! 인증번호를 입력한 뒤 인증 확인을 눌러주세요.")
					$("#alertEmail").css({
						"color": "red"
					});
					code = data;


				}
			}
		});

	});


	$("#confirmEmailButton").click(function () {
		if ($("#checkEmail").val().length != 6) {
			$("#alertEmail").text("! 인증번호가 일치하지 않습니다. 다시 확인해주시기 바랍니다.")
			$("#alertEmail").css({
				"color": "red"
			});
			$("#checkEmail").attr("autofocus", true);
		} else if ($("#checkEmail").val() == code) {
			$("#alertEmail").text("✔ 메일인증이 완료되었습니다.")
			$("#alertEmail").css({
				"color": "green"
			});
			$("#checkEmail").attr("disabled", true);
		} else {

		}
	});



	$("#joinButton").click(function () {

		var name = $("#userName").val();
		var jumin1 = $("#userJumin1").val();
		var jumin2 = $("#userJumin2").val();
		var phone = $("#userPhone").val();
		var email = $("#userEmail").val();
		var answer = $("#userfindAnswer").val();
		var juso = $("#userAddress").val();
		var juso2 = $("#userSendAddress").val();

		if ($("#alertId").text() != "✔  사용 가능한 아이디입니다.") {
			alert("아이디 중복확인이 필요합니다.");
			return;
		} else if ($("#alterPassword").text() != "✔  사용가능한 비밀번호입니다." || $("#alterPassword2").text() != "✔  비밀번호가 일치합니다.") {
			alert("비밀번호를 확인해 주세요");
			return;
		} else if (name.replace(/\s|　/gi, "").length == 0) {
			alert("이름을 확인해 주세요");
			return;
		} else if (jumin1.replace(/\s|　/gi, "").length == 0 || jumin1.length != 6) {
			alert("주민번호 앞자리를 확인해주세요.");
			return;
		} else if (jumin2.replace(/\s|　/gi, "").length == 0 || jumin2.length != 7) {
			alert("주민번호 뒷자리를 확인해주세요.");
			return;
		} else if ($("#userZipcode").val() == "" || $("#userZipcode").val().length != 5) {
			alert("올바른 우편번호를 입력해주세요. 우편번호 찾기 버튼을 통해 입력이 가능합니다.");
			return;
		} else if (juso.replace(/\s|　/gi, "").length == 0 || juso2.replace(/\s|　/gi, "").length == 0) {
			alert("주소를 입력해주세요.");
			return;
		} else if (phone.replace(/\s|　/gi, "").length == 0) {
			alert("전화번호를 확인해 주세요");
			return;
		} else if (email.replace(/\s|　/gi, "").length == 0) {
			alert("이메일을 확인해 주세요.");
			return;
		} else if (answer.replace(/\s|　/gi, "").length == 0) {
			alert("비밀번호 찾기 답변을 확인해 주세요.");
			return;
		} else {
			$("#insertForm").submit();
		};

		alert("회원가입이 완료되었습니다. 로그인 후 이용해주세요.");
	});
});