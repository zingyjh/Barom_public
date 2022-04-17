/**
 * 
 */

var user_info = [];

var case_info = {
	case_no: "",
	basicInfo_no: 0,
	plaintiff_count: 0,
	defendant_count: 0,
	purpose_no: 0,
	cause_no: 0
};

var noticeModal = null;

var savedMsg = [];

window.addEventListener("DOMContentLoaded", function () {

	checkSession();

	savedMsg = document.getElementsByClassName("savedMsg");
	var case_no = document.getElementById("case_code").value;
	console.log(case_no);
	if (case_no != "") {
		case_info.case_no = case_no;
		getCaseSavedData(case_no);
	}

	noticeModal = new bootstrap.Modal(document.getElementById("noticeModal"));
});

function checkSession() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = JSON.parse(xhr.responseText);

			if (data.result == 'fail') {
				alert("로그인 후 이용해주시기 바랍니다.");
				location.href = "http://barom.s001lec.com:8080/";
			} else {
				user_info = data.sessionUser;
			}

		}
	};

	xhr.open("get", "../user/checkSession", false);
	xhr.send();
}


//******************************************************//
//******************사건 입력**********
//******************************************************//
function addCase() {
	$.ajax({
		type: "POST",
		url: "./insertnewCase",
		data: case_info,
		dataType: "JSON",
		async: false,
		success: function (response) {
			case_info.case_no = response.case_no;
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

//******************************************************//
//******************사건기본정보 입력**********
//******************************************************//

function addCaseBasic() {
	if (case_info.case_no == "") {
		addCase();
	}

	let caseBasicInfo = {
		caseBasicInfo_no: case_info.basicInfo_no,
		case_no: case_info.case_no,
		min_sj_sgn_category_no: document.caseBasicForm.min_sj_sgn_category_no.value,
		min_sj_court_category_no: document.caseBasicForm.min_sj_court_category_no.value,
		caseBasicInfo_claim_method: document.caseBasicForm.caseBasicInfo_claim_method.value,
		caseBasicInfo_price_method: document.caseBasicForm.caseBasicInfo_price_method.value,
		caseBasicInfo_price: document.caseBasicForm.caseBasicInfo_price.value
	};


	if (case_info.basicInfo_no == 0) {
		insertCaseBasicInfo(caseBasicInfo);
	} else {
		updateCaseBasicInfo(caseBasicInfo);
	}

}

function insertCaseBasicInfo(caseBasicInfo) {
	$.ajax({
		type: "POST",
		url: "./insertBasicInfo",
		data: caseBasicInfo,
		dataType: "JSON",
		async: false,
		success: function (response) {
			case_info.basicInfo_no = response.basicInfo_no;
			document.caseBasicForm.caseBasicInfo_no.value = response.caseNo;
			console.log(case_info);
			savedMsg[0].style.display = "block";
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function updateCaseBasicInfo(caseBasicInfo) {
	$.ajax({
		type: "POST",
		url: "./updateBasicInfo",
		data: caseBasicInfo,
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

//******************************************************//
//******************당사자 입력**********
//******************************************************//

function getLoginedUserInfo() {

	document.concernedForm.name.value = user_info.user_name;
	document.concernedForm.zipcode.value = user_info.user_zipcode;
	document.concernedForm.address.value = user_info.user_address;
	document.concernedForm.send_address.value = user_info.user_send_address;
	document.concernedForm.phone.value = user_info.user_phone;
	document.concernedForm.email.value = user_info.user_email;
}

function showSelectAddress() {

	new daum.Postcode({
		oncomplete: function (data) {

			console.log(data);

			document.concernedForm.zipcode.value = data.zonecode;
			document.concernedForm.address.value = data.roadAddress;
			document.concernedForm.send_address.value = "";
		}
	}).open();
}

function addConcerned() {
	if (case_info.case_no == "") {
		addCase();
	}

	if (document.concernedForm.concernedKind.value == 0) {
		console.log("원고 입력");
		insertPlaintiff();
	} else {
		console.log("피고 입력");
		insertDefendant();
	}

	savedMsg[1].style.display = "block";

	document.getElementById("concernedKind_0").removeAttribute("onclick");
	document.getElementById("concernedKind_1").removeAttribute("onclick");

	document.concernedForm.concerned_no.value = 0;
	document.concernedForm.personal.value = "corporation";
	document.concernedForm.resident_num.value = "";
	document.concernedForm.name.value = "";
	document.concernedForm.zipcode.value = "";
	document.concernedForm.address.value = "";
	document.concernedForm.send_address.value = "";
	document.concernedForm.nation.value = "korea";
	document.concernedForm.phone.value = "";
	document.concernedForm.email.value = "";
}

function insertPlaintiff() {
	let data = {
		case_no: case_info.case_no,
		plaintiff_no: document.concernedForm.concerned_no.value,
		plaintiff_personal: document.concernedForm.personal.value,
		plaintiff_resident_num: document.concernedForm.resident_num.value,
		plaintiff_name: document.concernedForm.name.value,
		plaintiff_zipcode: document.concernedForm.zipcode.value,
		plaintiff_address: document.concernedForm.address.value,
		plaintiff_send_address: document.concernedForm.send_address.value,
		plaintiff_send_user_id: user_info.user_id,
		plaintiff_nationality: document.concernedForm.nation.value,
		plaintiff_phone: document.concernedForm.phone.value,
		plaintiff_email: document.concernedForm.email.value
	};


	if (document.concernedForm.concerned_no.value == 0) {
		$.ajax({
			type: "POST",
			url: "./insertPlaintif",
			data: data,
			dataType: "JSON",
			async: false,
			success: function (response) {
				console.log(response);
				case_info.plaintiff_count++;
				getConcernedList();
			},
			error: function (xhr, status, error) {
				alert("서버와 통신도중 오류가 발생했습니다.");
				console.log("xhr", xhr);
				console.log("status", status);
				console.log("error", error);
			}
		});
	} else {
		$.ajax({
			type: "POST",
			url: "./updatePlaintif",
			data: data,
			dataType: "JSON",
			async: false,
			success: function (response) {
				console.log(response);
				getConcernedList();
			},
			error: function (xhr, status, error) {
				alert("서버와 통신도중 오류가 발생했습니다.");
				console.log("xhr", xhr);
				console.log("status", status);
				console.log("error", error);
			}
		});
	}

}

function insertDefendant() {
	let data = {
		case_no: case_info.case_no,
		defendant_no: document.concernedForm.concerned_no.value,
		defendant_personal: document.concernedForm.personal.value,
		defendant_resident_num: document.concernedForm.resident_num.value,
		defendant_name: document.concernedForm.name.value,
		defendant_zipcode: document.concernedForm.zipcode.value,
		defendant_address: document.concernedForm.address.value,
		defendant_send_address: document.concernedForm.send_address.value,
		defendant_send_user_id: user_info.user_id,
		defendant_nationality: document.concernedForm.nation.value,
		defendant_phone: document.concernedForm.phone.value,
		defendant_email: document.concernedForm.email.value
	};

	if (document.concernedForm.concerned_no.value == 0) {
		$.ajax({
			type: "POST",
			url: "./insertDefendant",
			data: data,
			dataType: "JSON",
			async: false,
			success: function (response) {
				console.log(response);
				case_info.defendant_count++;
				getConcernedList();
			},
			error: function (xhr, status, error) {
				alert("서버와 통신도중 오류가 발생했습니다.");
				console.log("xhr", xhr);
				console.log("status", status);
				console.log("error", error);
			}
		});
	} else {
		$.ajax({
			type: "POST",
			url: "./updateDefendant",
			data: data,
			dataType: "JSON",
			async: false,
			success: function (response) {
				console.log(response);
				getConcernedList();
			},
			error: function (xhr, status, error) {
				alert("서버와 통신도중 오류가 발생했습니다.");
				console.log("xhr", xhr);
				console.log("status", status);
				console.log("error", error);
			}
		});
	}

}

function getConcernedList() {
	console.log("당사자 목록 업데이트");

	$.ajax({
		type: "GET",
		url: "./getConcernedList",
		data: {
			"case_no": case_info.case_no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
			$("#concernedList").empty();

			/*
            <tr>
				<td colspan="5" class="text-center">등록된 당사자 정보가 없습니다.</td>
			</tr>
             * */
			if ((response.plaintiffList.length == 0) && (response.defendantList.length == 0)) {
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				td.innerText = "등록된 당사자 정보가 없습니다.";
				td.setAttribute("colspan", "5");
				td.setAttribute("class", "text-center");

				$("#concernedList").appendChild(tr);
			} else {
				for (var i = 0; i < response.plaintiffList.length; i++) {
					setConcernedData_Plaintiff(response.plaintiffList[i]);
				}

				for (var i = 0; i < response.defendantList.length; i++) {
					setConcernedData_Defendant(response.defendantList[i]);
				}
			}

		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

/*
<tr>
 <th scope="row">원고</th>
 <td>이름</td>
 <td>Y</td>
 <td>
 	<div class="btn btn-primary">수정</div>
 </td>
 <td>
	<div class="btn btn-secondary">삭제</div>
 </td>
</tr>
* */

function setConcernedData_Plaintiff(data) {

	console.log(data);

	var concernedList = document.getElementById("concernedList");

	var tr = document.createElement("tr");

	var concernedKindBox = document.createElement("th");
	concernedKindBox.innerText = "원고";
	tr.appendChild(concernedKindBox);

	var concernedNameBox = document.createElement("td");
	concernedNameBox.innerText = data.plaintiff_name;
	tr.appendChild(concernedNameBox);

	var isSelectedBox = document.createElement("td");
	isSelectedBox.innerText = "";
	tr.appendChild(isSelectedBox);

	var modBox = document.createElement("td");
	var modBtn = document.createElement("div");
	modBtn.setAttribute("class", "btnBasic inputSubmit");
	modBtn.setAttribute("onclick", "modConcerned_Plaintiff(" + data.plaintiff_no + ")");
	modBtn.innerText = "수정";
	modBox.appendChild(modBtn);
	tr.appendChild(modBox);

	var delBox = document.createElement("td");
	var delBtn = document.createElement("div");
	delBtn.setAttribute("class", "btnGray inputSubmit");
	delBtn.setAttribute("onclick", "delConcerned_Plaintiff(" + data.plaintiff_no + ")");
	delBtn.innerText = "X";
	delBox.appendChild(delBtn);
	tr.appendChild(delBox);

	var delBox = document.createElement("td");

	concernedList.appendChild(tr);
}

function modConcerned_Plaintiff(no) {
	$.ajax({
		type: "GET",
		url: "./getPlaintiff",
		data: {
			"no": no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);

			document.getElementById("concernedKind_0").setAttribute("onclick", "return(false);");
			document.getElementById("concernedKind_1").setAttribute("onclick", "return(false);");

			document.concernedForm.concernedKind.value = 0;
			document.concernedForm.concerned_no.value = response.data.plaintiff_no;
			document.concernedForm.personal.value = response.data.plaintiff_personal;
			document.concernedForm.resident_num.value = response.data.plaintiff_resident_num;
			document.concernedForm.name.value = response.data.plaintiff_name;
			document.concernedForm.zipcode.value = response.data.plaintiff_zipcode;
			document.concernedForm.address.value = response.data.plaintiff_address;
			document.concernedForm.send_address.value = response.data.plaintiff_send_address;
			document.concernedForm.nation.value = response.data.plaintiff_nationality;
			document.concernedForm.phone.value = response.data.plaintiff_phone;
			document.concernedForm.email.value = response.data.plaintiff_email;
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function delConcerned_Plaintiff(no) {
	$.ajax({
		type: "GET",
		url: "./deletePlaintif",
		data: {
			"no": no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
			case_info.plaintiff_count--;
			getConcernedList();
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function setConcernedData_Defendant(data) {
	console.log(data);

	var concernedList = document.getElementById("concernedList");

	var tr = document.createElement("tr");

	var concernedKindBox = document.createElement("th");
	concernedKindBox.innerText = "피고";
	tr.appendChild(concernedKindBox);

	var concernedNameBox = document.createElement("td");
	concernedNameBox.innerText = data.defendant_name;
	tr.appendChild(concernedNameBox);

	var isSelectedBox = document.createElement("td");
	isSelectedBox.innerText = "";
	tr.appendChild(isSelectedBox);

	var modBox = document.createElement("td");
	var modBtn = document.createElement("div");
	modBtn.setAttribute("class", "btnBasic inputSubmit");
	modBtn.setAttribute("onclick", "modConcerned_Defendant(" + data.defendant_no + ")");
	modBtn.innerText = "수정";
	modBox.appendChild(modBtn);
	tr.appendChild(modBox);

	var delBox = document.createElement("td");
	var delBtn = document.createElement("div");
	delBtn.setAttribute("class", "btnGray inputSubmit");
	delBtn.setAttribute("onclick", "delConcerned_Defendant(" + data.defendant_no + ")");
	delBtn.innerText = "X";
	delBox.appendChild(delBtn);
	tr.appendChild(delBox);

	var delBox = document.createElement("td");

	concernedList.appendChild(tr);
}

function modConcerned_Defendant(no) {
	$.ajax({
		type: "GET",
		url: "./getDefendant",
		data: {
			"no": no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);

			document.getElementById("concernedKind_0").setAttribute("onclick", "return(false);");
			document.getElementById("concernedKind_1").setAttribute("onclick", "return(false);");

			document.concernedForm.concernedKind.value = 1;
			document.concernedForm.concerned_no.value = response.data.defendant_no;
			document.concernedForm.personal.value = response.data.defendant_personal;
			document.concernedForm.resident_num.value = response.data.defendant_resident_num;
			document.concernedForm.name.value = response.data.defendant_name;
			document.concernedForm.zipcode.value = response.data.defendant_zipcode;
			document.concernedForm.address.value = response.data.defendant_send_address;
			document.concernedForm.send_address.value = response.data.defendant_send_address;
			document.concernedForm.nation.value = response.data.defendant_nationality;
			document.concernedForm.phone.value = response.data.defendant_phone;
			document.concernedForm.email.value = response.data.defendant_email;
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function delConcerned_Defendant(no) {
	$.ajax({
		type: "GET",
		url: "./deleteDefendant",
		data: {
			"no": no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
			case_info.defendant_count--;
			getConcernedList();
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

//******************************************************//
//******************청구취지 입력**********
//******************************************************//

function addPurpose() {
	if (case_info.case_no == "") {
		addCase();
	}

	if (document.purposeForm.purpose_content.value == "") {
		showNoticeModal("청구취지 입력란이 공백입니다.");
		document.purposeForm.purpose_content.focus();
		return;
	}

	let purposeForm = {
		purpose_no: case_info.purpose_no,
		case_no: case_info.case_no,
		purpose_content: document.purposeForm.purpose_content.value,
		purpose_attach: "_"
	};

	if (case_info.purpose_no == 0) {
		insertPurpose(purposeForm);
	} else {
		modPurpose(purposeForm)
	}
}

function insertPurpose(purposeForm) {
	$.ajax({
		type: "POST",
		url: "./insertPurpose",
		data: purposeForm,
		dataType: "JSON",
		async: false,
		success: function (response) {
			case_info.purpose_no = response.purposeNo;
			console.log(case_info);
			savedMsg[2].style.display = "block";
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function modPurpose(purposeForm) {
	$.ajax({
		type: "POST",
		url: "./updatePurpose",
		data: purposeForm,
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}


//******************************************************//
//******************청구원인 입력**********
//******************************************************//
function addCause() {
	if (case_info.case_no == "") {
		addCase();
	}

	if (document.causeForm.cause_content.value == "") {
		showNoticeModal("청구원인 입력란이 공백입니다.");
		document.causeForm.cause_content.focus();
		return;
	}

	let causeForm = {
		cause_no: case_info.cause_no,
		case_no: case_info.case_no,
		cause_content: document.causeForm.cause_content.value,
		cause_attach: "_"
	};


	if (case_info.cause_no == 0) {
		insertCause(causeForm);
	} else {
		modCause(causeForm);
	}
}

function insertCause(causeForm) {
	$.ajax({
		type: "POST",
		url: "./insertCause",
		data: causeForm,
		dataType: "JSON",
		async: false,
		success: function (response) {
			case_info.cause_no = response.causeNo;
			console.log(case_info.cause_no);
			savedMsg[3].style.display = "block";
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function modCause(causeForm) {
	$.ajax({
		type: "POST",
		url: "./updateCause",
		data: causeForm,
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

//******************************************************//
//******************파일 첨부페이지로**********
//******************************************************//

/*
var case_info = {
	case_no : 0
	,plaintiff_count : 0
	,defendant_count : 0
	,purpose_no : 0
	,cause_no : 0
};
*/

function toNextPage() {
	console.log(case_info);

	var emptyStr = "";

	if (case_info.case_no == 0) {
		emptyStr += "사건기본정보";
	}

	if (case_info.plaintiff_count == 0) {
		if (emptyStr != "") {
			emptyStr += ", ";
		}
		emptyStr += "원고";
	}

	if (case_info.defendant_count == 0) {
		if (emptyStr != "") {
			emptyStr += ", ";
		}
		emptyStr += "피고";
	}

	if (case_info.purpose_no == 0) {
		if (emptyStr != "") {
			emptyStr += ", ";
		}
		emptyStr += "청구취지";
	}

	if (case_info.cause_no == 0) {
		if (emptyStr != "") {
			emptyStr += ", ";
		}
		emptyStr += "청구원인";
	}

	if (emptyStr != "") {
		showNoticeModal(emptyStr + "이 입력되지 않았습니다.");
	} else {

		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);

				if (data.result == 'success') {
					console.log(data);
					location.href = "./confFileInfo";
				}
			}
		};

		xhr.open("get", "./toFilePage?case_no=" + case_info.case_no, false);
		xhr.send();
	}
}

//******************************************************//
//******************알림 Modal**********
//******************************************************//

function showNoticeModal(message) {
	$("#noticeModal").find(".modal-dialog>.modal-content>.modal-body").html(message);

	noticeModal.show();
}

function closeNoticeModal() {

	noticeModal.hide();
}

//******************************************************//
//******************수정시 사건 데이터 불러오기**********
//******************************************************//

function getCaseSavedData(case_no) {
	$.ajax({
		type: "POST",
		url: "./getSavedCaseData",
		data: {
			"case_no": case_no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			//            console.log(response);
			case_info.case_no = case_no;
			setCaseSavedData(response.caseData);
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}

function setCaseSavedData(data) {

	if (data.caseBasicInfo != null) {
		case_info.basicInfo_no = data.caseBasicInfo.caseBasicInfo_no;
		savedMsg[0].style.display = "block";
		document.caseBasicForm.caseBasicInfo_no.value = data.caseBasicInfo.caseBasicInfo_no;
		document.caseBasicForm.min_sj_sgn_category_no.value = data.caseBasicInfo.min_sj_sgn_category_no;
		document.caseBasicForm.caseBasicInfo_claim_method.value = data.caseBasicInfo.caseBasicInfo_claim_method;
		document.caseBasicForm.caseBasicInfo_price_method.value = data.caseBasicInfo.caseBasicInfo_price_method;
		document.caseBasicForm.caseBasicInfo_price.value = data.caseBasicInfo.caseBasicInfo_price;
		document.caseBasicForm.min_sj_court_category_no.value = data.caseBasicInfo.min_sj_court_category_no;
	}

	if ((data.defendantList.length != null) || (data.plaintiffList.length != null)) {
		case_info.plaintiff_count = data.plaintiffList.length;
		case_info.defendant_count = data.defendantList.length;
		savedMsg[1].style.display = "block";
		getConcernedList();
	}

	if (data.purpose != null) {
		case_info.purpose_no = data.purpose.purpose_no;
		savedMsg[2].style.display = "block";
		document.purposeForm.purpose_content.value = data.purpose.purpose_content;
	}

	if (data.cause != null) {
		case_info.cause_no = data.cause.cause_no;
		savedMsg[3].style.display = "block";
		document.causeForm.cause_content.value = data.cause.cause_content;
	}

	console.log(case_info);
}