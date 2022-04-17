/**
 * 
 */

window.addEventListener("DOMContentLoaded", function () {

	$(".resultRadio").click(function (event) {

		let value = $(event.target).val();

		if (value == 1) {

			$(".inputBox").html("");
			$(".inputBox").append(
				'<div class="row mt-3">' +
				'<div class="col-2 fs-4 my-auto">사건번호</div>' +
				'<div class="col fs-5 my-auto">1949881817</div>' +
				'<div class="col-2 fs-4 my-auto">법원 배당</div>' +
				'<div class="col my-auto">' +
				'<select class="form-select" aria-label="Default select example">' +
				'<option selected>법원 선택</option>' +
				'<option value="1">One</option>' +
				'<option value="2">Two</option>' +
				'<option value="3">Three</option>' +
				'</select>' +
				'</div>' +
				'<div class="col my-auto text-end">' +
				'<button type="button" class="btn btn-secondary agree">승인</button>' +
				'</div>' +
				'</div>'
			)

		} else {

			$(".inputBox").html("");
			$(".inputBox").append(
				'<div class="row mt-3">' +
				'<div class="col-2 fs-4 my-auto">거절사유</div>' +
				'<div class="col-8 my-auto d-grid"><input type="text"></div>' +
				'<div class="col-2 my-auto text-end">' +
				'<button type="button" class="btn btn-secondary">거절</button>' +
				'</div>' +
				'</div>'
			);

		}

	});


});