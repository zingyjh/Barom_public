/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {

	var confirmedNo = null;

	var search = location.search

	var params = new URLSearchParams(search);

	confirmedNo = params.get('confirmedNo');

	let getWriteAnswerList = function () {

		$.ajax({
			type: "get",
			url: "./getWriteAnswerList",
			data: {

			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				if (data.result == 'success') {

					for (datalist of data.list) {

						if (datalist == confirmedNo) {

							$("#selectCase").append(
								'<option value="' + datalist + '" selected>' + datalist + '</option>'
							);

						} else {

							$("#selectCase").append(
								'<option value="' + datalist + '">' + datalist + '</option>'
							);
						}
					}
				}
			}
		});
	}
	getWriteAnswerList();

	let getCaseConfirmed = function () {
		
		$.ajax({
			type: "get",
			url: "./getCaseConfirmedInfo",
			data: {
				confirmedNo: $("#selectCase").val()
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				var writeDate = moment(data.info.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

				$("#court").text(data.info.MIN_SJ_COURT_CATEGORY_NAME);
				$("#caseNo").text(data.info.CASE_CONFIRMED_NO);
				$("#caseName").text(data.info.MIN_SJ_SGN_CATEGORY_NAME);
				$("#caseDate").text(writeDate); // 추후수정
				$("#casePlaintiff").text(data.info.PLAINTIFF_NAME);
				$("#caseDefendant").text(data.info.DEFENDANT_NAME);

			}
		});
	}



	if (confirmedNo != null) {
		let getCaseConfirmedByNo = function () {

			$.ajax({
				type: "get",
				url: "./getCaseConfirmedInfo",
				data: {
					confirmedNo: confirmedNo
				},
				dataType: "json",
				// contentType : "application/x-www-form-urlencoded", // post
				success: function (data) {

					var writeDate = moment(data.info.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

					$("#court").text(data.info.MIN_SJ_COURT_CATEGORY_NAME);
					$("#caseNo").text(data.info.CASE_CONFIRMED_NO);
					$("#caseName").text(data.info.MIN_SJ_SGN_CATEGORY_NAME);
					$("#caseDate").text(writeDate); // 추후수정
					$("#casePlaintiff").text(data.info.PLAINTIFF_NAME);
					$("#caseDefendant").text(data.info.DEFENDANT_NAME);
				}
			});
		}
		getCaseConfirmedByNo();
	}
	$("#selectCase").change(getCaseConfirmed);

	$("#cancleButton").click(function () {
		history.back();
	});






});