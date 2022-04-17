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

	<script type="text/javascript" src="../resources/js/document/agree.js"></script>

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

				<!-- 페이지별 내용 시작-->
				<!-- 페이지 제목 -->
				<div class="row mt-1 conTitleArea">
					<h3 class="conTItle"><i class="bi bi-list"></i> 전자소송 진행 동의</h3>
				</div>

				<div class="row formTable">

					<div class="card">
						<div class="card-body">
							전자소송시스템을 이용하여 민사소송 등을 수행하고자 할 경우에는 반드시 해당 사건에 관하여 전자소송 동의를 하여야 합니다.<br>
							<br>
							전자소송 동의를 한 경우에는 법원에 제출할 서류를 전자소송시스템을 이용하여 전자문서로 제출하여야 합니다.<br>
							<br>
							전자소송 동의를 한 소송관계인에 대하여는 송달할 전자문서를 전자소송시스템에 등재하고 전자우편 또는 문자메시지로 그 사실을 통지함으로써 송달을 실시하고, 이때
							소송관계인이 전자문서를 확인한 때 또는 전자문서 등재사실을 통지한 날부터 1주가 지난 날에 송달된 것으로 보게 됩니다(다만, 후자의 경우 송달간주일은 1주가 지난 날
							0시가 되므로, 기간 계산에 유의하여야 합니다).<br>
							<br>
							공동의 이해관계를 가진 여러 소송관계인 중 1인이 전자소송 동의를 하면 다른 공동명의자 전원의 확인서를 전자문서로 변환하여 제출하는 방법으로 전자문서를 단독으로
							제출할 수 있습니다).<br>
							<br>
							<div style="float:right;">
								<input type="checkbox" name="agree" id="agreed">
								이 사건에 관하여 전자소송시스템을 이용한 진행에 동의합니다.
							</div>
						</div>
					</div>

					<div class="row formEndBorder">
						<div class="col-1">
							<a href="http://barom.s001lec.com:8080/" class="btn btn-outline-success">취소</a>
						</div>
						<div class="col"></div>
						<div class="col-2">
							<input type="submit" onclick="getCheckboxChecked()" class="btnBasic inputSubmit" value="제출">
						</div>
					</div>
				</div>


				<div class="modal fade" id="noticeModal" tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								전자소송시스템을 이용한 진행에 동의하지 않으면
								소송 진행이 불가능합니다.
							</div>
							<div class="modal-footer">
								<!--  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>-->
								<button onclick="closeNoticeModal()" type="button" class="btn btnBasic">Confirm</button>
							</div>
						</div>
					</div>
				</div>

				<!-- 페이지별 내용 끝 -->
			</div>

			<jsp:include page="../commons/screenLeft.jsp"></jsp:include>

		</div>
	</section>

	<jsp:include page="../commons/footer.jsp"></jsp:include>

</body>

</html>

</html>