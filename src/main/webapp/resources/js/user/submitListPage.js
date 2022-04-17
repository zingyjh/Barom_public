var getMySubmitList = function () {
	alert("test");
};

var openPopup = function (target) {

	var target = target;
	var targetUrl = target.getAttribute("id");
	var popup = window.open(targetUrl, '서류확인', 'width=700px,height=800px,scrollbars=yes');

}

window.addEventListener("DOMContentLoaded", function () {

	var test12 = function (event) {

		var ptd = $(event.target).closest("td");
		var caseNo = $(ptd).attr("id");

		$.ajax({
			type: "get",
			url: "./getMyCaseRefuseReason",
			data: {
				caseNo: caseNo
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				var ptr = $(event.target).closest("tr");
				var ptrwidth = ptr.width();
				var dispear = ptrwidth - 99;
				ptr.after(
					"<div class='reasonRow' style='padding-left: 30px; width: 130px; height:50px; line-height:50px; font-weight: 700; white-space: nowrap;'>" +
					"반려사유 : " + data.reason + '<i class="bi bi-x-circle-fill reasonDelete"></i>' +
					"</div>"

				);
				$(".reasonDelete").click(deleteReason);

			}
		});
	}

	var deleteReason = function (event) {

		var reasonDiv = $(event.target).closest("div");
		reasonDiv.remove();

	}

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
					getMySubmitList();


				}
			}
		});
	}
	checkSession();

	getMySubmitList = function () {

		let dataJson = {

			docOption: $("#docOption").val(),
			courtOption: $("#courtOption").val(),
			minDate: $("#minDate").val(),
			maxDate: $("#maxDate").val(),
			caseNo: $("#caseNo").val()

		}

		console.log(dataJson);

		$.ajax({
			type: "post",
			url: "./getMyCaseListProcess",
			data: dataJson,
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				$("#listBody").html("");

				for (caseList of data.list) {
					var writeDate = moment(caseList.CASE_SAVE_DATE).format("YYYY-MM-DD");
					var tdNo = caseList.submitInfo.CASE_NO;

					$("#listBody").append(
						'<tr>' +
						'<td>' + caseList.submitInfo.CASE_NO + '</td>' +
						'<td>' + caseList.submitInfo.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
						'<td>' + caseList.submitInfo.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
						'<td>' + caseList.plaintiffName + '</td>' +
						'<td>' + caseList.defendantName + '</td>' +
						'<td>' + writeDate + '</td>' +
						'<td>' + '<a href="#" id="/upload/' + caseList.submitInfo.CONFIRMED_URL + '" target="_self" onclick="openPopup(this)"><img class="pdfImg" src="../resources/img/pdf.png"></a>' + '</td>' +
						'<td>' + '<a href="../document/modPetition?case_no=' + caseList.submitInfo.CASE_NO + '">' + caseList.submitInfo.STATUS_NAME + '</a></td>' +
						'<td id="' + tdNo + '">' + caseList.submitInfo.APPROVAL_NAME + ' ' + '</td>' +
						'</tr>'
					);
					console.log(caseList.submitInfo.APPROVAL_NO)
					if (caseList.submitInfo.APPROVAL_NO == "3") {

						$("#" + tdNo + "").append(

							'<button type="button" class="reasonButton" style="border-style: hidden; background-color: white;">' +
							'<i class="bi bi-question-circle-fill"></i>' +
							'</button>'

						);

					}
				}
				$(".reasonButton").click(test12);
			}
		});

	}

	$("#searchButton").on("click", getMySubmitList);

	var checker = 0;
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


});