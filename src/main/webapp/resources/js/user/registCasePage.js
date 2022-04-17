/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {

	$("#jipcodeButton").click(function () {
		new daum.Postcode({
			oncomplete: function (data) {

				var fullAddr = '';
				var extraAddr = '';

				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우 
					fullAddr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J) 
					fullAddr = data.jibunAddress;
					1
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
				document.getElementById('userJipcode').value = data.zonecode; //5자리 새우편번호 사용 
				document.getElementById('userAddress').value = fullAddr; // 커서를 상세주소 필드로 이동한다. 
				document.getElementById('userSendAddress').focus();
			}
		}).open();

	});

	$(".registButton").click(function () {

		$.ajax({
			type: "get",
			url: "./registCaseConfirmed",
			data: {
				case_confirmed_no: $("#caseNo").val(),
				defendant_name: $("#userName").val(),
				defendant_zipcode: $("#userJipcode").val(),
				defendant_address: $("#userAddress").val()
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				if (data.result == 'fail1') {
					alert("해당사건이 존재하지 않습니다.");
				} else if (data.result == 'fail2') {
					alert("이미 등록된 사건입니다.");
				} else {
					alert("등록이 완료되었습니다.")
					getCaseConfirmedList();
				}
			}
		});

	});

	let getCaseConfirmedList = function () {

		$.ajax({
			type: "get",
			url: "./getCaseConfirmedList",
			data: {
				searchOption: 0
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				$("#caseList").html("");
				for (list of data.caseConfirmedList) {
					var registDate = moment(list.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

					if (list.Answerd == 0) {
						$("#caseList").append(
							'<tr>' +
							'<th class="text-center" id="caseName" scope="row">' + list.CASE_CONFIRMED_NO + '</th>' +
							'<td class="text-center">' + list.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
							'<td class="text-center">' + list.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
							'<td class="text-center" id="casePlain">' + list.PLAINTIFF_NAME + '</td>' +
							'<td class="text-center">' + list.DEFENDANT_NAME + '</td>' +
							'<td class="text-center">' + registDate + '</td>' +
							'<td class="text-center"><a href="./writeAnswerPage">미제출</a></td>' +
							'</tr>'
						);
					} else {
						$("#caseList").append(
							'<tr>' +
							'<th class="text-center" id="caseName" scope="row">' + list.CASE_CONFIRMED_NO + '</th>' +
							'<td class="text-center">' + list.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
							'<td class="text-center">' + list.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
							'<td class="text-center" id="casePlain">' + list.PLAINTIFF_NAME + '</td>' +
							'<td class="text-center">' + list.DEFENDANT_NAME + '</td>' +
							'<td class="text-center">' + registDate + '</td>' +
							'<td class="text-center">제출완료</td>' +
							'</tr>'
						);
					}
				}
			}
		});
	};
	getCaseConfirmedList();

	$("#answerSelect").change(function () {



		$.ajax({

			type: "get",
			url: "./user/getCaseConfirmedList",
			data: {
				searchOption: $("#answerSelect").val()
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				$("#caseList").html("");
				for (list of data.caseConfirmedList) {
					var registDate = moment(list.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

					if (list.Answerd == 0) {
						$("#caseList").append(
							'<tr>' +
							'<th class="text-center" id="caseName" scope="row">' + list.CASE_CONFIRMED_NO + '</th>' +
							'<td class="text-center">' + list.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
							'<td class="text-center">' + list.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
							'<td class="text-center" id="casePlain">' + list.PLAINTIFF_NAME + '</td>' +
							'<td class="text-center">' + list.DEFENDANT_NAME + '</td>' +
							'<td class="text-center">' + registDate + '</td>' +
							'<td class="text-center"><a href="./writeAnswerPage">미제출</a></td>' +
							'</tr>'
						);
					} else {
						$("#caseList").append(
							'<tr>' +
							'<th class="text-center" id="caseName" scope="row">' + list.CASE_CONFIRMED_NO + '</th>' +
							'<td class="text-center">' + list.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
							'<td class="text-center">' + list.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
							'<td class="text-center" id="casePlain">' + list.PLAINTIFF_NAME + '</td>' +
							'<td class="text-center">' + list.DEFENDANT_NAME + '</td>' +
							'<td class="text-center">' + registDate + '</td>' +
							'<td class="text-center">제출완료</td>' +
							'</tr>'
						);
					}
				}
			}
		});


	});













});