/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {

	$("#statusSelect").change(function () {
		$("#caseList").html("");
		$("#caseList").append('<option value="0" selected>사건번호</option>');
		if ($("#statusSelect").val() == 0) {
			return;
		} else {

			$.ajax({
				type: "get",
				url: "./getCaseConfirmedByStatus",
				data: {
					statusNo: $("#statusSelect").val()
				},
				dataType: "json",
				//contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {

					for (list of data.list) {
						$("#caseList").append('<option value="' + list + '">' + list + '</option>"');
					}

				}
			});

		}
	});

	$("#caseList").change(function () {

		if ($("#caseList").val() == 0) {
			return;
		} else {

			$.ajax({
				type: "get",
				url: "./getCaseConfirmedByNo",
				data: {
					confirmedNo: $("#caseList").val()
				},
				dataType: "json",
				//contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {

					var registDate = moment(data.info.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

					$("#caseName").text(data.info.CASE_CONFIRMED_NO);
					$("#caseDate").text(registDate);
					$("#casePlaintiff").text(data.info.PLAINTIFF_NAME);
					$("#caseDefendant").text(data.info.DEFENDANT_NAME);
				}
			});

		}
	});

	var insertTrial = function () {

		var dataJson = {

			confirmedNo: $("#caseList").val(),
			trialDate: $("#trialDate").val(),
			trialResult: $("#trialResult").val(),
			trialOrder: $("#resultOrder").val(),
			trialReason: $("#resultReason").val()
		}

		$.ajax({
			type: "post",
			url: "./insertTrial",
			data: dataJson,
			dataType: "json",
			contentType: "application/x-www-form-urlencoded", // post
			success: function (data) {

				alert("판결 등록 완료");

			}
		});

	};

	$("#submitButton").on("click", insertTrial);


});