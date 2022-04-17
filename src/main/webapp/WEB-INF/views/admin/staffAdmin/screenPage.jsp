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
	<script type="text/javascript" src="../resources/js/document/screenPage.js?v=3"></script>
	<link rel="stylesheet" type="text/css" href="../resources/css/document/screenPage.css?v=2">
	<link rel="stylesheet" type="text/css" href="../resources/css/commons/allPage.css?v=2">


</head>

<body>

	<div class="row" id="container">
		<div class="col-1" style="width:5%;"></div>
		<div class="col">
			<jsp:include page="../../commons/adminNav.jsp"></jsp:include>
			<div class="row mt-3">
				<div class="col-1" style="width:13%;">
					<jsp:include page="../../commons/adminLoginBox.jsp"></jsp:include>
					<div class="row">
						<div class="col"></div>
					</div>
				</div>
				<div class="col ps-5" style="">
					<!-- 각 페이지 내용 여기에 들어가면 됩니다  -->
					<div class="row mt-2">
						<!-- subtitle -->
						<div class="col fs-2 my-auto">
							소장 심사
						</div>
					</div>
					<div class="row mt-3 divisionLine"></div>
					<div class="row mt-3">
						<div class="col fs-4">
							소장 정보
						</div>
					</div>
					<div class="row mt-3">
						<!-- PDF 보여주기 -->
						<div class="col text-center my-auto">
							<iframe id="pdfBox" src="" style="width:780px;height:1050px;"></iframe>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col fs-5 my-auto">
							<input type="radio" class="resultRadio" name="result" value="1">승인
							<input type="radio" class="resultRadio" name="result" value="2">반려
						</div>
					</div>
					<div class="row mt-3 divisionLine"></div>
					<div class="row">
						<div class="col inputBox">

						</div>
					</div>
					<div class="row mt-5"></div>
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