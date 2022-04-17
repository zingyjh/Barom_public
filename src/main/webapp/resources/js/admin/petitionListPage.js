function addreason() {


};


window.addEventListener("DOMContentLoaded", function () {

	var getStaffCaseList = function () {

		let dataJson = {

			docOption: $("#docOption").val(),
			courtOption: $("#courtOption").val(),
			minDate: $("#minDate").val(),
			maxDate: $("#maxDate").val(),
			caseNo: $("#caseNo").val()

		}

		$.ajax({
			type: "post",
			url: "./getStaffCaseList",
			data: dataJson,
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				$("#listBody").html("");
				var listNo = 1;

				for (caseList of data.list) {
					var writeDate = moment(caseList.CASE_SAVE_DATE).format("YYYY-MM-DD");
					var approvalNo = caseList.APPROVAL_NO;

					$("#listBody").append(
						'<tr>' +
						'<td>' + caseList.CASE_NO + '</td>' +
						'<td>' + writeDate + '</td>' +
						'<td>' + caseList.MIN_SJ_COURT_CATEGORY_NAME + '</td>' +
						'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
						'<td>' + caseList.plaintiffName + '</td>' +
						'<td>' + caseList.defendantName + '</td>' +
						'<td>' + '<a href="/upload/' + caseList.CONFIRMED_URL + '" target="_blank" ><img class="pdfImg" src="../../resources/img/pdf.png"></a>' + '</td>' +
						'<td id="statusTd' + listNo + '"></td>' +
						'</tr>'
					);

					if (caseList.APPROVAL_NO == 1) {

						$("#statusTd" + listNo + "").append(
							'<a href="./approvePage?case_no=' + caseList.CASE_NO + '"><button type="button" style="width:50px;" class="btnBasic">승인</button></a>' +
							'  <a href="./refusePage?case_no=' + caseList.CASE_NO + '"><button type="button" style="width:70px;" class="btnBasic">보정명령</button></a>'
						);

					} else if (caseList.APPROVAL_NO == 2) {

						$("#statusTd" + listNo + "").text("승인완료");

					} else if (caseList.APPROVAL_NO == 3) {

						$("#statusTd" + listNo + "").text("반려됨");

					}

					listNo = listNo + 1;
				}
			}
		});

	}
	getStaffCaseList();



	$("#searchButton").on("click", getStaffCaseList);
	$(".reasonButton").on("click", function () {
		alert("123")
	});

	var checker = 1;
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

	$(".btnBasic:button").click(function (event) {


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