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
	<script type="text/javascript" src="../resources/js/suit/deliveryConfirmPage.js?v=3"></script>
	<link rel="stylesheet" type="text/css" href="../resources/css/suit/deliveryConfirmPage.css?v=2">
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
							송달확인
						</div>
					</div>
					<div class="row mt-3 divisionLine"></div>
					<div class="row mt-5">
						<div class="col fs-3 my-auto">
							사건정보
						</div>
					</div>
					<div class="row mt-2 semiDivisionLine"></div>
					<div class="row mt-3">
						<div class="col-1 fs-5 my-auto listTitle">
							사건번호
						</div>
						<div class="col my-auto text-center">
							1859948
						</div>
						<div class="col-1 fs-5 my-auto listTitle">
							접수일자
						</div>
						<div class="col my-auto text-center">
							2022-03-20
						</div>
						<div class="col-1 fs-5 my-auto listTitle">
							원고
						</div>
						<div class="col my-auto text-center">
							박현우
						</div>
					</div>
					<div class="row mt-4">
						<div class="col fs-3 my-auto">
							피고정보
						</div>
					</div>
					<div class="row mt-2 semiDivisionLine"></div>
					<div class="row mt-3">
						<div class="col-1 fs-5 my-auto listTitle">
							피고
						</div>
						<div class="col-2 my-auto text-center">
							김세아
						</div>
						<div class="col-1 fs-5 my-auto listTitle">
							주소
						</div>
						<div class="col-1 my-auto text-center">
							65148
						</div>
						<div class="col my-auto text-center">
							서울특별시 강남구 도곡동 951-22
						</div>
						<div class="col-2 my-auto text-center">
							101동 2201호
						</div>
					</div>
					<div class="row mt-4">
						<div class="col fs-3 my-auto">
							동봉서류
						</div>
					</div>
					<div class="row mt-2 semiDivisionLine"></div>
					<div class="row mt-3">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">번호</th>
									<th scope="col">구분</th>
									<th scope="col">서류명</th>
									<th scope="col">파일명</th>
								</tr>
							</thead>
							<tbody>
								<tr class="caseList">
									<th scope="row">1</th>
									<td>소송문서</td>
									<td>소장</td>
									<td>소장(보증채무금 청구의 소)</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="row mt-5">
						<div class="col my-auto"></div>
						<div class="col-2 pe-0 my-auto text-end">
							<button type="button" class="btn btn-secondary">송달하기</button>
							<button type="button" class="btn btn-secondary">취소</button>
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