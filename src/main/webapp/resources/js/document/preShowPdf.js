window.addEventListener("DOMContentLoaded", function () {

	var showPrePdf = function () {

		$.ajax({
			type: "get",
			url: "./getPrePdfUrl",
			data: {

			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {

				if (data.result == 'success') {

					var pdfUrl = data.pdfUrl;

					$("#pdfBox").attr('src', '/upload/' + pdfUrl);
				}
			}
		});
	};
	showPrePdf();

	$("#backButton").click(function () {

		$.ajax({
			type: "post",
			url: "./deletePrePdf",
			data: {

			},
			dataType: "json",
			contentType: "application/x-www-form-urlencoded", // post
			success: function (data) {

			}
		});
		location.href = "./confFileInfo";
	});

	$("#nextButton").click(function () {

		$.ajax({
			type: "post",
			url: "./updatePrePdf",
			data: {

			},
			dataType: "json",
			contentType: "application/x-www-form-urlencoded", // post
			success: function (data) {

			}
		});
		location.href = "./payConf";
	});

});