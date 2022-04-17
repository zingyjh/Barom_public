<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../resources/js/user/registCasePage.js?v=5"></script>
	<link rel="stylesheet" type="text/css" href="../resources/css/commons/allPage.css?v=2">


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
					<div class="row mt-3">
						<div class="col fs-2 my-auto">
							소송 사건 등록
						</div>
					</div>
					<div class="row mt-3 divisionLine"></div>
					<div class="row mt-5">
						<div class="col-1 fs-5 my-auto">
							사건번호
						</div>
						<div class="col-2 my-auto">
							<input class="form-control" id="caseNo" type="text" placeholder=""
								aria-label="default input example">
						</div>
						<div class="col-1 fs-5 text-center my-auto">
							이름
						</div>
						<div class="col-2 my-auto">
							<input class="form-control" id="userName" type="text" placeholder=""
								aria-label="default input example">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-1 my-auto fs-5 text-center">우편번호</div>
						<div class="col-1 my-auto fs-5"><input class="form-control" id="userJipcode" name="user_jipcode"
								type="text" placeholder="" aria-label="default input example"></div>
						<div class="col-1 my-auto text-center fs-5">주소</div>
						<div class="col my-auto"><input class="form-control" id="userAddress" name="user_address"
								type="text" placeholder="" aria-label="default input example"></div>
						<div class="col-1 my-auto text-center fs-5 text-center">상세주소</div>
						<div class="col-2 my-auto"><input class="form-control" id="userSendAddress"
								name="user_send_address" type="text" placeholder="" aria-label="default input example">
						</div>
						<div class="col-1 my-auto"><button type="button" id="jipcodeButton"
								class="btn btn-dark btn-sm">주소 찾기</button></div>
					</div>
					<div class="row mt-3">
						<div class="col my-auto d-grid">
							<button type="button" id="jipcodeButton" class="btn btn-dark registButton">사건 등록</button>
						</div>
					</div>
					<div class="row mt-5">
						<div class="col-2">
							<select class="form-select" aria-label="Default select example" id="answerSelect">
								<option value="0">모든 답변서</option>
								<option value="1">제출완료</option>
								<option value="2">미제출</option>
							</select>
						</div>
						<div class="col"></div>
					</div>
					<div class="row mt-2">
						<table class="table">
							<thead>
								<tr>
									<th scope="col" class="text-center">사건번호</th>
									<th scope="col" class="text-center">사건유형</th>
									<th scope="col" class="text-center">법원</th>
									<th scope="col" class="text-center">원고</th>
									<th scope="col" class="text-center">피고</th>
									<th scope="col" class="text-center">사건등록 날짜</th>
									<th scope="col" class="text-center">답변서 등록 여부</th>
								</tr>
							</thead>
							<tbody id="caseList">
							</tbody>
						</table>
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