<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>

<body>

	<div class="row" id="container">
		<div class="col-1" style="width:5%;"></div>
		<div class="col">
			<jsp:include page="../commons/mainNav.jsp"></jsp:include>
			<div class="row mt-3">
				<div class="col-1" style="width:13%;">
					<jsp:include page="../commons/loginBox.jsp"></jsp:include>
					<div class="row">
						<div class="col"></div>
					</div>
				</div>
				<div class="col ps-5" style="">
					<!-- 각 페이지 내용 여기에 들어가면 됩니다  -->
					<div class="row mt-2">
						<!-- subtitle -->
						<div class="col fs-2">
							답변서 제출 목록
						</div>
					</div>
					<div class="row mt-3 divisionLine"></div>
					<div class="row mt-2" id="submitOptionBox">
						<!-- 옵션박스 -->
						<div class="col">
							<div class="row mt-3">
								<!-- 사건 유형 및 법원 선택 -->
								<div class="col-2 my-auto">소송유형</div>
								<div class="col-3">
									<select class="form-select" aria-label="Default select example">
										<option value="1">민사</option>
									</select>
								</div>
								<div class="col-2"></div>
								<div class="col-2 my-auto">법원</div>
								<div class="col-3 my-auto">
									<select class="form-select" aria-label="Default select example"
										id="courtCategoryNo">
										<option selected>법원선택</option>
										<c:forEach items="${courtList }" var="list">
											<option value="${list.min_sj_court_category_no }">
												${list.min_sj_court_category_name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row mt-4">
								<!-- 날짜선택 -->
								<div class="col-2 my-auto">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="checkForm" id="dateRadio"
											value="1" checked>
										<label class="form-check-label" for="flexRadioDefault1">
											접수일자
										</label>
									</div>
								</div>
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
											<button type="button" class="btn btn-dark dateButton" value='1'>당일</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btn btn-dark dateButton" value='2'>3일</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btn btn-dark dateButton" value='3'>7일</button>
										</div>
										<div class="col my-auto d-grid">
											<button type="button" class="btn btn-dark dateButton" value='4'>30일</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row mt-4">
								<!-- 사건번호 -->
								<div class="col-2 my-auto">
									<input class="form-check-input" type="radio" name="checkForm" id="numberRadio"
										value="2">
									<label class="form-check-label" for="flexRadioDefault1">
										사건번호
									</label>
								</div>
								<div class="col-2 my-auto">
									<select class="form-select accident" aria-label="Default select example"
										id="accidentYear">
										<option selected>기본</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
								<div class="col-3 my-auto">
									<select class="form-select accident" aria-label="Default select example"
										id="accidentName">
										<option selected>기본</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
								<div class="col">
									<input class="form-control accident" type="text" placeholder="사건번호를 입력해 주세요."
										name="myCaseNo" aria-label="default input example" id="accidentNumber">
								</div>
							</div>
							<div class="row mt-3">
								<div class="col d-grid">
									<button type="button" class="btn btn-dark" id="searchButton">검색하기</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-4 divisionLine"></div>
					<div class="row mt-4">
						<!-- ListBox -->
						<div class="col text-center my-auto">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th scope="col">법 원</th>
										<th scope="col">사건번호</th>
										<th scope="col">재판부</th>
										<th scope="col">제출일자</th>
										<th scope="col">원 고</th>
										<th scope="col">피 고</th>
										<th scope="col">사건기록</th>
										<th scope="col">진행상황</th>
									</tr>
								</thead>
								<tbody id="listBody">

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-2" style="width:13%;"></div>
			</div>
		</div>
		<div class="col-1" style="width:5%;"></div>
	</div>




	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>
</body>

</html>