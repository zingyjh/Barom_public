/**
 * 
 */


window.addEventListener("DOMContentLoaded", function () {

	var checker = null;

	let getCaseConfirmedAndAnsweredList = function () {

		var trialOption = $("#trialOption").val();

		let dataJson = {

			statusOption: $("#statusOption").val(),
			trialOption: trialOption,
			minDate: $("#minDate").val(),
			maxDate: $("#maxDate").val(),
			confirmedNo: $("#confirmedNo").val()

		}

		console.log(dataJson);

		$.ajax({
			type: "post",
			url: "./getCaseConfirmedAndAnsweredList",
			data: dataJson,
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				$("#listBody").html("");
				for (caseList of data.list) {
					var writeDate = moment(caseList.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");
					$("#listBody").append(
						'<tr>' +
						'<td>' + caseList.CASE_CONFIRMED_NO + '</td>' +
						'<td>' + caseList.MIN_SJ_SGN_CATEGORY_NAME + '</td>' +
						'<td>' + writeDate + '</td>' +
						'<td>' + '<a href="/upload/' + caseList.CONFIRMED_URL + '" target="_blank" ><img class="pdfImg" src="../../resources/img/pdf.png"></a>' + '</td>' +
						'<td>' + '<a href="/upload/' + caseList.DOCUMENT_URL + '" target="_blank" ><img class="pdfImg" src="../../resources/img/pdf.png"></a>' + '</td>' +
						'<td>' + caseList.CASECONFIRMED_STATUS_NAME + '</td>' +
						'<td id="' + caseList.CASE_CONFIRMED_NO + '"></td>' +
						'</tr>'
					);

					if (caseList.CASECONFIRMED_STATUS_NO != 5) {

						$("#" + caseList.CASE_CONFIRMED_NO + "").text("미작성");

					} else {

						$("#" + caseList.CASE_CONFIRMED_NO + "").text("등록");

					}


				}
			}
		});

	};
	getCaseConfirmedAndAnsweredList();
	$("#searchButton").click(getCaseConfirmedAndAnsweredList);

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