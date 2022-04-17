/**
 * 
 */
var user_info = [];

var case_no = "";

window.addEventListener("DOMContentLoaded", function () {

	checkSession();

	case_no = document.getElementById("case_code").value;
	console.log(case_no);

	getFileSavedData(case_no);
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

/*
<div class="row">
	<div class="col-1">서류 1</div>
	<div class="col">
		<input type="file" class="form-control" name="uploadFiles">
	</div>
	<div class="col-1">
		<div class="btn btn-outline-primary" onclick="addFiles();"> + </div>
	</div>
</div>
*/

let rowCount = 0;

function addFiles() {

	var inputFiles = document.getElementById("inputFiles");

	rowCount++;

	var rowBox = document.createElement("div");
	rowBox.setAttribute("class", "row mt-1");
	rowBox.setAttribute("id", "file_" + rowCount);

	var countBox = document.createElement("div");
	countBox.setAttribute("class", "col-1");
	countBox.innerText = "서류" + rowCount;
	rowBox.appendChild(countBox);

	var inputBox = document.createElement("div");
	inputBox.setAttribute("class", "col");
	var uploadFile = document.createElement("input");
	uploadFile.setAttribute("type", "file");
	uploadFile.setAttribute("class", "form-control uploadFiles");
	uploadFile.setAttribute("name", "uploadFiles");
	inputBox.appendChild(uploadFile);
	rowBox.appendChild(inputBox);

	var delOptBox = document.createElement("div");
	delOptBox.setAttribute("class", "col-1");
	var delOptBtn = document.createElement("div");
	delOptBtn.setAttribute("class", "btn btn-secondary");
	delOptBtn.setAttribute("onclick", "delFiles(" + rowCount + ")");
	delOptBtn.innerText = "X";
	delOptBox.appendChild(delOptBtn);
	rowBox.appendChild(delOptBox);

	inputFiles.appendChild(rowBox);
}


function delFiles(rownum) {
	//	console.log(rownum);
	const row = document.getElementById("file_" + rownum);
	row.remove();
}

function getFileSavedData(case_no) {
	$.ajax({
		type: "POST",
		url: "./getSavedProofFile",
		data: {
			"case_no": case_no
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);
			for (var i = 0; i < response.fileData.length; i++) {
				setCaseSavedData(response.fileData[i]);
			}
		},
		error: function (xhr, status, error) {
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}


function setCaseSavedData(data) {

	rowCount++;
	var inputFiles = document.getElementById("inputFiles");

	var rowBox = document.createElement("div");
	rowBox.setAttribute("class", "row mt-1");
	rowBox.setAttribute("id", "file_" + rowCount);

	var countBox = document.createElement("div");
	countBox.setAttribute("class", "col-1");
	countBox.innerText = "서류" + rowCount;
	rowBox.appendChild(countBox);

	var inputBox = document.createElement("div");
	inputBox.setAttribute("class", "col");
	var savedFile = document.createElement("h6");
	savedFile.innerText = data.file_original_name;
	inputBox.appendChild(savedFile);
	rowBox.appendChild(inputBox);

	var delOptBox = document.createElement("div");
	delOptBox.setAttribute("class", "col-1");
	var delOptBtn = document.createElement("div");
	delOptBtn.setAttribute("class", "btn btn-secondary");
	delOptBtn.setAttribute("onclick", "delSavedFile('" + data.file_name + "', '" + rowCount + "')");
	delOptBtn.innerText = "X";
	delOptBox.appendChild(delOptBtn);
	rowBox.appendChild(delOptBox);

	inputFiles.appendChild(rowBox);
}

function delSavedFile(filename, rownum) {
	$.ajax({
		type: "POST",
		url: "./delSavedProofFile",
		data: {
			"file_name": filename
		},
		dataType: "JSON",
		async: false,
		success: function (response) {
			console.log(response);

			delFiles(rownum);
		},
		error: function (xhr, status, error) {
			console.log("xhr", xhr);
			console.log("status", status);
			console.log("error", error);
		}
	});
}