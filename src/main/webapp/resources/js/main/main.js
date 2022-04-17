/**
 * 
 */
var caseModal = null;

window.addEventListener("DOMContentLoaded", function () {

	const tabBtnList1 = document.getElementsByClassName('tabBtn1');
	for (var i = 0; i < tabBtnList1.length; i++) {
		tabBtnList1[i].addEventListener('click', function (e) {
			e.preventDefault();

			tabBtnList1[0].classList.remove("active_now");
			tabBtnList1[1].classList.remove("active_now");

			$(this).addClass("active_now");
			document.getElementById("noticeTab").classList.remove("active_now");
			document.getElementById("questionTab").classList.remove("active_now");

			var moreInfo_L = document.getElementById("more_info_L");
			if ($(this).attr("href") == "#noticeTab") {
				moreInfo_L.setAttribute("href", "http://barom.s001lec.com:8080/customer/cusAnncmList");
			} else {
				moreInfo_L.setAttribute("href", "http://barom.s001lec.com:8080/customer/faqPage");
			}

			$($(this).attr("href")).addClass("active_now");
		});
	}

	const tabBtnList2 = document.getElementsByClassName('tabBtn2');
	for (var i = 0; i < tabBtnList2.length; i++) {
		tabBtnList2[i].addEventListener('click', function (e) {
			e.preventDefault();

			tabBtnList2[0].classList.remove("active_now");
			tabBtnList2[1].classList.remove("active_now");

			$(this).addClass("active_now");
			document.getElementById("caseSearchTab").classList.remove("active_now");
			document.getElementById("documentSearchTab").classList.remove("active_now");

			$($(this).attr("href")).addClass("active_now");
		});
	}

	caseModal = new bootstrap.Modal(document.getElementById("caseModal"));
	
	getAnncm();
	getFaQ();
	getCourtList();
});

function getAnncm() {
	$.ajax({
		type: "POST",
		url: "http://barom.s001lec.com:8080/main/getMainAnncm",
		data: {},
		dataType: "JSON",
		async: false,
		success: function (response) {
			//			console.log(response);
			$("#anncmList").empty();
			for (i = 0; i < response.anncm.length; i++) {
				setAnncm(response.anncm[i]);
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

//<li><a href="">공지1</a><span>2022.03.28</span></li>

function setAnncm(data) {
	//	console.log(data);

	var anncmList = document.getElementById("anncmList");

	var li = document.createElement("li");

	var anncmName = document.createElement("a");
	var anncm = data.ANNCM_TITLE;
	if (anncm.length >= 20) {
		anncmName.innerText = anncm.substr(0, 25) + "...";
	} else {
		anncmName.innerText = anncm;
	}
	anncmName.setAttribute("href", "http://barom.s001lec.com:8080/customer/cusReadAnncm?anncm_no=" + data.ANNCM_NO);
	li.appendChild(anncmName);

	var anncmDate = document.createElement("span");
	var date = new Date(data.ANNCM_WRITEDATE);
	anncmDate.innerText = date.getFullYear() + "." + date.getMonth() + "." + date.getDate();
	li.appendChild(anncmDate);

	anncmList.appendChild(li);
}

function getFaQ() {
	$.ajax({
		type: "POST",
		url: "http://barom.s001lec.com:8080/main/getMainFaQ",
		data: {},
		dataType: "JSON",
		async: false,
		success: function (response) {
			//			console.log(response);
			$("#FaQList").empty();
			for (var i = 0; i < response.faq.length; i++) {
				setFaQ(response.faq[i]);
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

//<li><a href="">공지1</a><span>2022.03.28</span></li>

function setFaQ(data) {
	//	console.log(data);

	var FaQList = document.getElementById("FaQList");

	var li = document.createElement("li");

	var faqName = document.createElement("a");
	var faq = data.FAQ_TITLE;
	if (faq.length >= 20) {
		faqName.innerText = faq.substr(0, 20) + "...";
	} else {
		faqName.innerText = faq;
	}
	faqName.setAttribute("href", "http://barom.s001lec.com:8080/customer/faqContentPage?faq_no=" + data.FAQ_NO);
	li.appendChild(faqName);

	var faqDate = document.createElement("span");
	faqDate.innerText = data.FAQ_CATEGORY_NAME;
	li.appendChild(faqDate);

	FaQList.appendChild(li);
}

function getCourtList(){
	$.ajax({
		type: "POST",
		url: "http://barom.s001lec.com:8080/main/getCourtList",
		data: {},
		dataType: "JSON",
		async: false,
		success: function (response) {
//			console.log(response);
			setCourtList(response.courtList);
		},
		error: function (xhr, status, error) {
			alert("서버와 통신도중 오류가 발생했습니다.");
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});	
}


//<option value="${sgn.min_sj_sgn_category_no }">
//	${sgn.min_sj_sgn_category_name }</option>

function setCourtList(data){
//	console.log(data);
	
	var courtNames = document.getElementById("courtNames");
	
	for(var i=0; i<data.length; i++){
		
		var option = document.createElement("option");
		option.innerText = data[i].min_sj_court_category_name;
		option.setAttribute("value", data[i].min_sj_court_category_no);
		
		courtNames.appendChild(option);
	}
}


function getCaseAtMain(){
	
	var caseSearchMainData = {
		"min_sj_sgn_category_no": document.caseSearchMain.min_sj_sgn_category_no.value
		,"case_no": document.caseSearchMain.case_no.value
		,"concerned_name": document.caseSearchMain.case_concerned.value
	};
	
	console.log(caseSearchMainData);
	
	showCaseModal();
}

function showCaseModal(){
	caseModal.show();
}

function closeCaseModal(){
	caseModal.hide();
}



