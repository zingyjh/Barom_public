<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<!-- my css -->
	<link rel="stylesheet" type="text/css" href="../resources/css/frameCss.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/commonCss.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/commonFormCss.css">

	<!-- font css -->
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

	<!-- script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

	<script type="text/javascript" src="../resources/js/commons/loginBox.js"></script>
	<script type="text/javascript" src="../resources/js/frame/dropdown.js"></script>
	<script type="text/javascript" src="../resources/js/frame/jquery-3.6.0.min.js"></script>

	<title>barom</title>
</head>

<body>

	<jsp:include page="../commons/mainNav.jsp"></jsp:include>

	<!-- header part end-->

	<!-- body part start -->

	<section class="container-fluid">

		<div class="row mt-4">

			<jsp:include page="../commons/loginBox.jsp"></jsp:include>

			<div class="col">
				<!-- page Title -->
				<div class="row mt-1 conTitleArea">
					<h3 class="conTItle"><i class="bi bi-list"></i> ?????? ?????? ??????</h3>
				</div>

				<!-- ???????????? ?????? ??????-->
				<div class="row mt-2 formTable">
					<div class="row formTitleArea">
						<div class="col formTitle">
							<span id="priffSpan"><i class="bi bi-clipboard-fill"></i> ??????</span>
							<span id="defenSpan" style="margin-left: 20px;"><i
									class="bi bi-clipboard-fill"></i>??????</span>
						</div>
					</div>
					<div class="row divBorder">
						<div class="inputTitle">????????????</div>
						<div class="inputSec">
							<div class="row">
								<div class="col-2">
									<select class="form-select" aria-label="Default select example">
										<option value="0">????????????</option>
										<option value="1">??????</option>
									</select>
								</div>
								<div class="col">
									<select class="form-select" aria-label="Default select example" id="statusOption">
										<option value="0">????????????</option>
										<option value="1">????????????</option>
										<option value="2">????????????</option>
										<option value="3">????????? ?????????</option>
										<option value="4">?????????</option>
										<option value="5">????????????</option>
									</select>
								</div>
								<div class="col">
									<select class="form-select" aria-label="Default select example" id="answerOption">
										<option value="0">????????? ????????????</option>
										<option value="1">????????????</option>
										<option value="2">?????????</option>
									</select>
								</div>
								<div class="col my-auto">
									<select class="form-select" aria-label="Default select example" id="courtOption">
										<option value="0" selected>????????????</option>
										<c:forEach items="${courtList }" var="list">
											<option value="${list.min_sj_court_category_no }">
												${list.min_sj_court_category_name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row divBorder">
						<div class="inputTitle">
							<input type="radio" name="checkForm" value="1" checked>
							<label style="vertical-align: text-bottom; color: #5B7DB1;">????????????</label>
						</div>
						<div class="inputSec">
							<div class="row">
								<div class="col-2 my-auto">
									<input type="date" class="Date" name="minDate" id="minDate">
								</div>
								<div class="col-1 fs-4 text-center my-auto">~</div>
								<div class="col-2 my-auto">
									<input type="date" class="Date" name="maxDate" id="maxDate">
								</div>
								<div class="col">
									<div class="row my-auto">
										<div class="col my-auto d-grid">
											<button type="button" class="btnBasic inputSubmit dateButton"
												value='1'>??????</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btnBasic inputSubmit dateButton"
												value='2'>3???</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btnBasic inputSubmit dateButton"
												value='3'>7???</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btnBasic inputSubmit dateButton"
												value='4'>30???</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row divBorder">
						<div class="inputTitle">
							<input type="radio" name="checkForm" value="2">
							<label style="vertical-align: text-bottom; color: #5B7DB1;">????????????</label>
						</div>
						<div class="inputSec">
							<input type="text" id="confirmedNo" placeholder="??????????????? ????????? ?????????.">
						</div>
					</div>
					<div class="row divBorder">
						<div class="col my-2">
							<button type="button" id="searchButton" class="btnBasic inputSubmit">?????? ??????</button>
						</div>
					</div>
				</div>


				<div class="row formTable">
					<div class="row divBorder">
						<div class="col text-center my-auto">
							<table>
								<thead>
									<tr>
										<th scope="col">????????????</th>
										<th scope="col">??? ???</th>
										<th scope="col">????????????</th>
										<th scope="col">??? ???</th>
										<th scope="col">??? ???</th>
										<th scope="col">????????????</th>
										<th scope="col">??????</th>
										<th scope="col">?????????</th>
										<th scope="col">?????????</th>
										<th scope="col">????????????</th>
									</tr>
								</thead>
								<tbody id="listBody">

								</tbody>
							</table>
						</div>
					</div>
					<div class="row mt-5" id="caseRegistBox">

					</div>
				</div>
				<!-- ???????????? ?????? ??? -->
			</div>

			<jsp:include page="../commons/screenLeft.jsp"></jsp:include>

		</div>
	</section>

	<jsp:include page="../commons/footer.jsp"></jsp:include>

	<script type="text/javascript" src="../resources/js/user/myCasePage.js"></script>
</body>

</html>