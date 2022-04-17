/**
 * 
 */
window.addEventListener("DOMContentLoaded", function () {

	var user_no = null;
	var questionValue = null;
	var Email = null;
	var checkSession = function () {

		$.ajax({
			type: "get",
			url: "./checkSession",
			data: {

			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				if (data.result == 'fail') {
					alert("로그인 후 이용해주시기 바랍니다.");
					location.href = "http://barom.s001lec.com:8080/";
				} else {
					user_no = data.sessionUser.user_no;
				}
			}
		});
	}
	checkSession();

	var getUsnerInfo = function () {
		$.ajax({
			type: "get",
			url: "./getUserInfoByUserNo",
			data: {
				userNo: user_no
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				$("#userId").text(data.userData.USER_ID);
				$("#userName").attr('value', data.userData.USER_NAME);
				$("#userZipcode").attr('value', data.userData.USER_ZIPCODE);
				$("#userAddress").attr('value', data.userData.USER_ADDRESS);
				$("#userSendAddress").attr('value', data.userData.USER_SEND_ADDRESS);
				var userPhone = (data.userData.USER_PHONE).slice(-8);
				console.log(userPhone);
				$("#userPhone").attr('value', userPhone);
				$("#userQuestion").attr('value', data.userData.FINDQUESTION_NO);
				$("#userEmail").attr('value', data.userData.USER_EMAIL);
				$("#userfindAnswer").attr('value', data.userData.USER_FINDANSWER);
				questionValue = data.userData.FINDQUESTION_NO;
				Email = data.userData.USER_EMAIL;
			}
		});
	};

	var showDrop = function () {
		$("#modifyDiv").removeClass('rounded border border-bottom-0 border-2 border-info');
		$("#modifyDiv").addClass('border-bottom border-2 border-info');
		$("#division").addClass('border-bottom border-2 border-info');
		$("#dropDiv").addClass("rounded border border-bottom-0 border-2 border-info")
		$("input:radio[id=modifyDivRadio]").prop('checked', false);


		$("#infoBox").html("");
		$("#infoBox").append(
			'<div class="col">' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">비밀번호</div>' +
			'<div class="col-3 my-auto text-center" ><input class="form-control" id="user_Pw" type="password" placeholder="비밀번호를 입력해 주세요." aria-label="default input example" > </div>' +
			'<div class="col-2 d-grid my-auto" style="margin:0px;"><button type="button" id="inactiveButton" class="btnBasic bi bi-check2-square" style="height:36px;">&nbsp;탈퇴하기</button></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle"></div>' +
			'<div class="col bi bi-exclamation-square-fill deepblue" >&nbsp;탈퇴 후에는 홈페이지 이용이 제한됩니다. 다시 로그인하실 경우 계정 활성화페이지로 이동하실 수 있습니다.</div>' +
			'</div>' +
			'</div>'
		);

		var deleteUserProcess = function () {

			$.ajax({
				type: "post",
				url: "./deleteUserInfoByUserNo",
				data: {
					user_pw: $("#user_Pw").val()
				},
				dataType: "json",
				contentType: "application/x-www-form-urlencoded", // post
				success: function (data) {
					if (data.result == 'fail') {
						alert("비밀번호가 일치하지 않습니다.");
					} else {
						alert("탈퇴가 완료되었습니다.");
						location.href = "http://barom.s001lec.com:8080/";
					}
				}
			});
		};

		$("#inactiveButton").click(deleteUserProcess);
	};

	var showModify = function () {
		$("#dropDiv").removeClass('rounded border border-bottom-0 border-2 border-info');
		$("#dropDiv").addClass('border-bottom border-2 border-info');
		$("#division").addClass('border-bottom border-2 border-info');
		$("#modifyDiv").addClass("rounded border border-bottom-0 border-2 border-info")
		$("input:radio[id=dropDivRadio]").prop('checked', false);

		$("#infoBox").html("");
		$("#infoBox").append(
			'<div class="col">' +
			'<div class="row mt-3">' +
			'<div class="inputTitle" style="padding:4px;">아이디</div>' +
			'<div class="inputTitle" fs-4 id="userId" style="padding:0px;">원래아이디</div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">비밀번호</div>' +
			'<div class="col fs-5"><input class="form-control" id="changePassword" type="password" placeholder="비밀번호를 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-6 my-auto" id="alterPassword"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">비밀번호 확인</div>' +
			'<div class="col fs-5"><input class="form-control" id="confirmPassword" type="password" placeholder="비밀번호를 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-6 my-auto" id="alterPassword2"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle"></div>' +
			'<div class="col bi bi-exclamation-square-fill deepblue">&nbsp;계정 보안을 위하여 비밀번호를 변경하지 않으시더라도 비밀번호 입력이 필요합니다.</div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-1">' +
			'<div class="inputTitle">이름</div>' +
			'<div class="col fs-5"><input class="form-control" id="userName" type="text" placeholder="이름을 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">우편번호</div>' +
			'<div class="col fs-5"><input class="form-control" id="userZipcode"  type="text" placeholder="" aria-label="default input example"></div>' +
			'<div class="col-3 d-grid"><button type="button" id="zipcodeButton" class="btnBasic bi bi-house-heart-fill" style="height:36px;">&nbsp;우편번호 찾기</button></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">주소</div>' +
			'<div class="col fs-5"><input class="form-control" id="userAddress"  type="text" placeholder="주소를 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">상세주소</div>' +
			'<div class="col fs-5"><input class="form-control" id="userSendAddress" type="text" placeholder="상세주소를 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">핸드폰</div>' +
			'<div class="col-2">' +
			'<select class="form-select" id="firstPhone" aria-label="Default select example">' +
			'<option value="010">010</option>' +
			'<option value="019">019</option>' +
			'<option value="02">02</option>' +
			'</select>' +
			'</div>' +
			'<div class="col fs-5"><input class="form-control" id="userPhone" type="text" placeholder="" aria-label="default input example"></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">이메일</div>' +
			'<div class="col-4 fs-5"><input class="form-control" id="userEmail" type="text" placeholder="이메일을 입력해 주세요." aria-label="default input example"></div>' +
			'<div class="col-3 d-grid"><button type="button" id="checkEmailButton" class="btnBasic" style="height:36px;">인증번호 발송</button></div>' +
			'<div class="col-2"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">인증확인</div>' +
			'<div class="col-3 fs-5"><input class="form-control" id="checkEmail" type="text" placeholder="인증번호를 입력해주세요." aria-label="default input example" disabled="disabled"></div>' +
			'<div class="col-2 d-grid"><button type="button" id="confirmEmailButton" class="btnBasic" style="height:36px;">인증확인</button></div>' +
			'<div class="col my-auto" id="alertEmail"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">비밀번호 찾기 질문</div>' +
			'<div class="col fs-5">' +
			'<select class="form-select" id="userQuestion" aria-label="Default select example">' +
			'</select>' +
			'</div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3">' +
			'<div class="inputTitle">비밀번호 찾기 정답</div>' +
			'<div class="col fs-5"><input class="form-control" id="userfindAnswer" type="text" placeholder="" aria-label="default input example"></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'<div class="row mt-3 mb-3">' +
			'<div class="inputTitle"></div>' +
			'<div class="col bi bi-exclamation-square-fill deepblue">&nbsp;제출 전 정보가 올바르게 기입되었는지 다시 한번 확인해주세요.</div>' +
			'<div class="col-2 d-grid"><button type="button" id="updateButton" class="btnBasic bi bi-check2-square" style="height:36px;">&nbsp;수정하기</button></div>' +
			'<div class="col-3"></div>' +
			'</div>' +
			'</div>'
		);

		$("#zipcodeButton").click(function () {
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
						$("#alertEmail").text("인증번호를 입력한 뒤 인증 확인을 눌러주세요.")
						$("#alertEmail").css({
							"color": "green"
						});
						code = data;


					}
				}
			});

		});



		$("#confirmEmailButton").click(function () {
			if ($("#checkEmail").val().length != 6) {
				$("#alertEmail").text("인증번호가 일치하지 않습니다. 다시 확인해주시기 바랍니다.")
				$("#alertEmail").css({
					"color": "red"
				});
				$("#checkEmail").attr("autofocus", true);
			} else if ($("#checkEmail").val() == code) {
				$("#alertEmail").text("메일인증이 완료되었습니다.")
				$("#alertEmail").css({
					"color": "green"
				});
				$("#checkEmail").attr("disabled", true);
			} else {

			}
		});


		var getQuestionList = function () {

			$.ajax({
				type: "get",
				url: "./getQuestionList",
				data: {

				},
				dataType: "json",
				// contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {
					for (list of data.questionList) {

						if (questionValue == list.findQuestion_no) {
							$("#userQuestion").append('<option value="' + questionValue + '">' + list.findQuestion_content + '</option>');
						} else {
							$("#userQuestion").append('<option selected value="' + list.findQuestion_no + '">' + list.findQuestion_content + '</option>');
						}


					}

				}
			});
		}
		getQuestionList();
		getUsnerInfo();

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

		var updateUserInfoProcess = function () {

			var password = $("#confirmPassword").val();
			var confirmpassword = $("#changePassword").val();
			var name = $("#userName").val();
			var firstPhone = $("#firstPhone").val();
			var userPhone = $("#userPhone").val();
			var userEmail = $("#userEmail").val();
			var answer = $("#userfindAnswer").val();
			var juso = $("#userAddress").val();
			var juso2 = $("#userSendAddress").val();

			if ($("#alterPassword").text() != "✔  사용가능한 비밀번호입니다." || $("#alterPassword2").text() != "✔  비밀번호가 일치합니다.") {
				alert("비밀번호를 확인해 주세요");
				return;
			} else if (name.replace(/\s|　/gi, "").length == 0) {
				alert("이름을 확인해 주세요");
				return;
			} else if ($("#userZipcode").val().length != 5 || juso.replace(/\s|　/gi, "").length == 0 || juso2.replace(/\s|　/gi, "").length == 0) {
				alert("주소를 확인해주세요.");
				return;
			} else if (firstPhone.replace(/\s|　/gi, "").length == 0 || userPhone.replace(/\s|　/gi, "").length == 0) {
				alert("전화번호를 확인해 주세요");
				return;
			} else if (userEmail.replace(/\s|　/gi, "").length == 0) {
				alert("이메일을 확인해 주세요.");
				return;
			} else if (userEmail != Email) {
				if ($("#alertEmail").text() != "메일인증이 완료되었습니다.") {
					alert("수정한 이메일을 인증해주세요.");
					return;
				}
			} else if (answer.replace(/\s|　/gi, "").length == 0) {
				alert("비밀번호 찾기 답변을 확인해 주세요.")
				return;
			} else {

			};

			$.ajax({
				type: "post",
				url: "./updateUserInfoByUserNo",
				data: {
					findQuestion_no: $("#userQuestion").val(),
					user_pw: $("#confirmPassword").val(),
					user_name: $("#userName").val(),
					user_zipcode: $("#userZipcode").val(),
					user_address: $("#userAddress").val(),
					user_send_address: $("#userSendAddress").val(),
					user_phone: $("#firstPhone").val() + $("#userPhone").val(),
					user_email: $("#userEmail").val(),
					user_findAnswer: $("#userfindAnswer").val()
				},
				dataType: "json",
				contentType: "application/x-www-form-urlencoded", // post
				success: function (data) {
					alert("수정이 완료되었습니다.");
					location.href = "./userInfoPage";
				}
			});
		};

		$("#updateButton").click(updateUserInfoProcess);
	};

	$("input:radio[id=modifyDivRadio]").click(showModify);
	$("input:radio[id=dropDivRadio]").click(showDrop);

});