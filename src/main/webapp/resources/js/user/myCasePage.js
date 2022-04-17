var getMyConfirmed = function () {
	alert("tes123445315314t");
};

var openPopup = function (target) {

	var target = target;
	var targetUrl = target.getAttribute("id");
	var popup = window.open(targetUrl, '서류확인', 'width=700px,height=800px,scrollbars=yes');

}


window.addEventListener("DOMContentLoaded", function () {
	var checker = 1;
	var personOption = 1;

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
					history.back();
				} else {
					user_no = data.sessionUser.USER_NO;
					getMyConfirmed();
				}
			}
		});
	}
	checkSession();

	var registCase = function () {

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
					getMyConfirmed();
				}
			}
		});
	};

	var changPersonOption = function () {

		if (personOption == 1) {

			$("#defenSpan").css("background", "#eee").css("color", "#c0c0c0").css("border", "none");
			$("#priffSpan").css("background", "").css("color", "").css("border", "");

			$("#caseRegistBox").html("");

		} else {

			$("#priffSpan").css("background", "#eee").css("color", "#c0c0c0").css("border", "none");
			$("#defenSpan").css("background", "").css("color", "").css("border", "");


			$("#caseRegistBox").append(
				'<div class="row formTable">' +
				'<div class="row formTitleArea">' +
				'<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 사건등록</span></div>' +
				'</div>' +
				'<div class="row divBorder">' +
				'<div class="inputTitle">사건번호</div>' +
				'<div class="inputSec">' +
				'<input type="text"  id="caseNo" >' +
				'</div>' +
				'</div>' +
				'<div class="row divBorder">' +
				'<div class="inputTitle">이름</div>' +
				'<div class="inputSec">' +
				'<input type="text" id="userName" >' +
				'</div>' +
				'</div>' +
				'<div class="row divBorder">' +
				'<div class="inputTitle">주소</div>' +
				'<div class="inputSec">' +
				'<div class="row">' +
				'<div class="col">' +
				'<input type="button" class="btnBasic inputSubmit" id="jipcodeButton" value="주소찾기">' +
				'</div>' +
				'</div>' +
				'<div class="row mt-2">' +
				'<div class="col">' +
				'<input type="text" id="userJipcode" placeholder="우편번호">' +
				'</div>' +
				'<div class="col-8">' +
				'<input type="text" id="userAddress" placeholder="기본주소">' +
				'</div>' +
				'<div class="col">' +
				'<input type="text" id="userSendAddress" placeholder="상세주소">' +
				'</div>' +
				'</div>' +
				'</div>' +
				'</div>' +
				'<div class="row divBorder">' +
				'<div class="col my-2">' +
				'<button type="button" id="registButton" class="btnBasic inputSubmit">사건 등록</button>' +
				'</div>' +
				'</div>' +
				'</div>'
			);
			$("#jipcodeButton").on("click", findAddress);
			$("#registButton").on("click", registCase);

		}
	}
	changPersonOption();

	let getMyConfirmed = function () {

		if (personOption == 1) {
			let dataJson = {

				statusOption: $("#statusOption").val(),
				answerOption: $("#answerOption").val(),
				courtOption: $("#courtOption").val(),
				minDate: $("#minDate").val(),
				maxDate: $("#maxDate").val(),
				confirmedNo: $("#confirmedNo").val()

			}

			$.ajax({
				type: "post",
				url: "./getMyAllCasePrif",
				data: dataJson,
				dataType: "json",
				// contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {

					$("#listBody").html("");

					for (caseList of data.list) {
						var writeDate = moment(caseList.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");
						var status = caseList.CASECONFIRMED_STATUS_NO;

						if (status == 4) {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td></td>' +
								'<td>' + caseList.CASECONFIRMED_STATUS_NAME + '</td>' +
								'</tr>'
							);

						} else if (status == 5) {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.TRIAL_DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + caseList.CASECONFIRMED_STATUS_NAME + '</td>' +
								'</tr>'
							);

						} else {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td></td>' +
								'<td></td>' +
								'<td>' + '<a href="./writeAnswerPage?confirmedNo=' + caseList.CASE_CONFIRMED_NO + '">' + caseList.CASECONFIRMED_STATUS_NAME + '</a></td>' +
								'</tr>'
							);

						}
					}
				}
			});

		} else if (personOption == 2) {

			let dataJson = {

				statusOption: $("#statusOption").val(),
				answerOption: $("#answerOption").val(),
				courtOption: $("#courtOption").val(),
				minDate: $("#minDate").val(),
				maxDate: $("#maxDate").val(),
				confirmedNo: $("#confirmedNo").val()

			}

			$.ajax({
				type: "post",
				url: "./getMyAllCaseDef",
				data: dataJson,
				dataType: "json",
				// contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {

					$("#listBody").html("");


					for (caseList of data.list) {
						var writeDate = moment(caseList.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");
						var status = caseList.CASECONFIRMED_STATUS_NO;

						if (status == 4) {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td></td>' +
								'<td>' + caseList.CASECONFIRMED_STATUS_NAME + '</td>' +
								'</tr>'
							);

						} else if (status == 5) {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.TRIAL_DOCUMENT_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td>' + caseList.CASECONFIRMED_STATUS_NAME + '</td>' +
								'</tr>'
							);

						} else {

							$("#listBody").append(
								'<tr class="text-center">' +
								'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
								'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
								'<td>' + caseList.PLAINTIFF_NAME + '</td>' +
								'<td>' + caseList.DEFENDANT_NAME + '</td>' +
								'<td>' + writeDate + '</td>' +
								'<td>' + '<a href="#" id="/upload/' + caseList.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)" ><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
								'<td></td>' +
								'<td></td>' +
								'<td>' + '<a href="./writeAnswerPage?confirmedNo=' + caseList.CASE_CONFIRMED_NO + '">' + caseList.CASECONFIRMED_STATUS_NAME + '</a></td>' +
								'</tr>'
							);

						}



					}
				}
			});

		};
	};


	$("#priffSpan").on("click", function () {

		personOption = 1;
		changPersonOption();
		getMyConfirmed();

	});

	$("#defenSpan").on("click", function () {

		personOption = 2;
		changPersonOption();
		getMyConfirmed();

	});

	$("#searchButton").click(getMyConfirmed);

	var changeRadio = function () {
		if ($("input:radio[name=checkForm]:checked").val() == 1) {
			$(".accident").attr('disabled', '');
			$(".Date").removeAttr('disabled', '');
			$(".dateButton").removeAttr('disabled', '');
			checker = 1;
		} else {
			$("#minDate").val("");
			$("#maxDate").val("");
			$(".accident").removeAttr('disabled', '');
			$(".Date").attr('disabled', '');
			$(".dateButton").attr('disabled', '');
			checker = 2;
		}
	}
	changeRadio();

	$("input:radio[name=checkForm]").click(changeRadio);

	$(".dateButton:button").click(function (event) {


		let value = $(event.target).val();
		let day = new Date();
		day = moment(day);

		let minDate = "";
		let maxDate = day.add(1, 'days');
		maxDate = maxDate.format('YYYY-MM-DD');

		if (value == 1) {
			minDate = day.subtract(1, 'days');
			minDate = minDate.format('YYYY-MM-DD');

			$("#minDate").val(minDate);
			$("#maxDate").val(maxDate);

		} else if (value == 2) {
			minDate = day.subtract(3, 'days');
			minDate = minDate.format('YYYY-MM-DD');

			$("#minDate").val(minDate);
			$("#maxDate").val(maxDate);
		} else if (value == 3) {
			minDate = day.subtract(7, 'days');
			minDate = minDate.format('YYYY-MM-DD');

			$("#minDate").val(minDate);
			$("#maxDate").val(maxDate);
		} else {
			minDate = day.subtract(31, 'days');
			minDate = minDate.format('YYYY-MM-DD');

			$("#minDate").val(minDate);
			$("#maxDate").val(maxDate);
		}

	});


	// 답변서 관련 
	var findAddress = function () {
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
				document.getElementById('userJipcode').value = data.zonecode; //5자리 새우편번호 사용 
				document.getElementById('userAddress').value = fullAddr; // 커서를 상세주소 필드로 이동한다. 
				document.getElementById('userSendAddress').focus();
			}
		}).open();

	};




});