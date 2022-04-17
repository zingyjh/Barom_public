/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {

	var concrete = 1;

	var getConfirmedList = function () {

		$.ajax({
			type: "get",
			url: "./getConfirmedList",
			data: {

			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				
				$("#selectConfirmedNo").html("");
				$("#selectConfirmedNo").append(
						'<option value="0">사건선택</option>'
				);		
				

				for (caseList of data.list) {

					
					$("#selectConfirmedNo").append(
							'<option value="' + caseList + '">' + caseList + '</option>'
							
					)
				}
			}
		});
	};

	var getCaseConfirmedInfo = function () {
		
		
		
		$.ajax({
			type : "get" ,
			url : "./getCaseConfirmedInfo" ,
			data : {
				confirmedNo : $("#selectConfirmedNo").val()
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				
				var writeDate = moment(data.info.CASE_CONFIRMED_DATE).format("YYYY-MM-DD");

				$("#court").text(data.info.MIN_SJ_COURT_CATEGORY_NAME);
				$("#confirmedNo").text(data.info.CASE_CONFIRMED_NO);
				$("#caseName").text(data.info.MIN_SJ_SGN_CATEGORY_NAME);
				$("#caseDate").text(writeDate); // 추후수정
				$("#casePlaintiff").text(data.info.PLAINTIFF_NAME);
				$("#caseDefendant").text(data.info.DEFENDANT_NAME);
			}
		});
	}
	
	$("#selectConfirmedNo").on("change", function(){
		
		if ( $("#selectConfirmedNo").val() == 0 ) {
			return;
		}
		
		getCaseConfirmedInfo();
		
	});
		
	$("#selectConcrete").change(function(){
		
		if ( $("#selectConcrete").val() == 1 ) {
			concrete = 1;
			$("#reasonTitle").html("");
			$("#reasonTitle").append(
				'<i class="bi bi-clipboard-fill"></i> 소송취하사유 입력</span>'
			);
			$("#reasonSubTitle").text("");
			$("#reasonSubTitle").text("소송취하사유");
			getConfirmedList();
		} else if ($("#selectConcrete").val() == 2) {
			concrete = 2;
			$("#reasonTitle").html("");
			$("#reasonTitle").append(
				'<i class="bi bi-clipboard-fill"></i> 소송합의사유 입력</span>'
			);
			$("#reasonSubTitle").text("");
			$("#reasonSubTitle").text("소송합의사유");
			getConfirmedList();
		} else {
			
			return ;
		}

	});

	var updateConfirmedStatus = function () {

		$.ajax({
			type: "get",
			url: "./updateConfirmedStatus",
			data: {
				confirmedNo: $("#selectConfirmedNo").val(),
				concreteOption: concrete
			},
			dataType: "json",
			// contentType : "application/x-www-form-urlencoded", // post
			success: function (data) {
				
				window.location.href = "./writeAnswerSucessPage";

			}
		});
	}

	$("#submitButton").on("click", function () {

		updateConfirmedStatus();

	});

});