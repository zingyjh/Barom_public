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

	<script type="text/javascript" src="../resources/js/pay/pay.js"></script>

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
					<h3 class="conTItle"><i class="bi bi-list"></i> 결제</h3>
				</div>

				<div class="row formTable">
					<div class="row formTitleArea">
						<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 결제정보</span></div>
					</div>
					<form>
						<input type="hidden" id="case_code" value="${case_code }">
						<div class="row divBorder">
							<div class="inputTitle">사건명</div>
							<div class="inputSec">
								${categoryName }
							</div>
						</div>
						<div class="row divBorder">
							<div class="inputTitle">관할법원</div>
							<div class="inputSec">
								${courtName }
							</div>
						</div>
						<div class="row divBorder">
							<div class="inputTitle">결제금액</div>
							<div class="inputSec">
								${caseBasicInfo.caseBasicInfo_price } 원
							</div>
						</div>
						<div class="row mt-3">
							<div class="btnBasic inputSubmit" onclick="trykakaoPay();">결제하기</div>
						</div>
					</form>
				</div>

				<div class="row formEndBorder">
					<div class="col-2 text-center">
						<a href="./preShowPdf" class="btnDirection btn"><i class="bi bi-arrow-left-circle-fill"></i>
							이전</a>
					</div>
					<div class="col"></div>
					<div class="col-2 text-center">
						<!-- <a href="" class="btnBasic inputSubmit">다음</a> -->
					</div>
				</div>
			</div>

			<jsp:include page="../commons/screenLeft.jsp"></jsp:include>

		</div>
	</section>

	<jsp:include page="../commons/footer.jsp"></jsp:include>

</body>

</html>