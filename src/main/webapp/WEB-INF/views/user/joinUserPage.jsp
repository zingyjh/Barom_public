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
	<script type="text/javascript" src="../resources/js/user/joinUserPage.js"></script>


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
					<h3 class="conTItle"><i class="bi bi-list"></i> 사용자 등록</h3>
				</div>

				<!-- 페이지별 내용 시작-->

				<div class="col">
					<form id="insertForm" method="post" action="./insertUserProcess">
						<div class="row mt-2" id="submitOptionBox">
							<!-- 옵션박스 -->
							<div class="col">
								<div class="row mt-3">
									<div class="inputTitle">아이디</div>
									<div class="col-3 fs-5"><input class="form-control" id="joinIdInput" name="user_id"
											type="text" placeholder="아이디를 입력해 주세요." aria-label="default input example">
									</div>
									<div class="col-2 d-grid"><button type="button" id="checkIdButton" class="btnBasic"
											style="height:36px;">중복확인</button></div>
									<div class="col my-auto" id="alertId"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">비밀번호</div>
									<div class="col-3 fs-5"><input class="form-control" id="changePassword"
											type="password" placeholder="비밀번호를 입력해주세요."
											aria-label="default input example"></div>
									<div class="col-6 my-auto" id="alterPassword"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">비밀번호 확인</div>
									<div class="col-3 fs-5"><input class="form-control" id="confirmPassword"
											name="user_pw" type="password" placeholder="비밀번호를 확인해주세요."
											aria-label="default input example"></div>
									<div class="col-6 my-auto" id="alterPassword2"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">이름</div>
									<div class="col fs-5"><input class="form-control" id="userName" name="user_name"
											type="text" placeholder="이름을 입력해 주세요." aria-label="default input example">
									</div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">주민등록번호</div>
									<div class="col fs-5"><input class="form-control" id="userJumin1" name="user_jumin1"
											type="text" placeholder="주민번호 앞자리를 입력해 주세요."
											aria-label="default input example"></div>-
									<div class="col fs-5"><input class="form-control" id="userJumin2" name="user_jumin2"
											type="password" placeholder="주민번호 뒷자리를 입력해 주세요."
											aria-label="default input example"></div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">우편번호</div>
									<div class="col fs-5"><input class="form-control" id="userZipcode"
											name="user_zipcode" type="text" placeholder="우편번호를 입력해 주세요."
											aria-label="default input example"></div>
									<div class="col-3 d-grid"><button type="button" id="jipcodeButton"
											class="btnBasic bi bi-house-heart-fill" style="height:36px;">&nbsp; 우편번호
											찾기</button></div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">주소</div>
									<div class="col fs-5"><input class="form-control" id="userAddress"
											name="user_address" type="text" placeholder="주소를 입력해 주세요."
											aria-label="default input example"></div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">상세주소</div>
									<div class="col fs-5"><input class="form-control" id="userSendAddress"
											name="user_send_address" type="text" placeholder="상세주소를 입력해 주세요."
											aria-label="default input example"></div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">전화번호</div>
									<div class="col fs-5"><input class="form-control" id="userPhone" name="user_phone"
											type="text" placeholder="전화번호를 입력해주세요." aria-label="default input example">
									</div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">이메일</div>
									<div class="col-4 fs-5"><input class="form-control" id="userEmail" name="user_email"
											type="text" placeholder="이메일을 입력해 주세요." aria-label="default input example">
									</div>
									<div class="col-3 d-grid"><button type="button" id="checkEmailButton"
											class="btnBasic" style="height:36px;">인증번호 발송</button></div>
									<div class="col-2"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle"></div>
									<div class="col-7 bi bi-exclamation-square-fill deepblue">
										인증번호 발송은 서버 상황에따라 5초에서 10초정도 시간이 걸릴 수 있습니다.
									</div>
								</div>
								<div class="row mt-1">
									<div class="inputTitle">인증확인</div>
									<div class="col-3 fs-5"><input class="form-control" id="checkEmail" type="text"
											placeholder="인증번호를 입력해주세요." aria-label="default input example"
											disabled="disabled"></div>
									<div class="col-2 d-grid"><button type="button" id="confirmEmailButton"
											class="btnBasic" style="height:36px;">인증확인</button></div>
									<div class="col my-auto" id="alertEmail"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">비밀번호 찾기 질문</div>
									<div class="col fs-5">
										<select class="form-select" name="findQuestion_no" id="userQuestion"
											aria-label="Default select example">
											<c:forEach items="${data.list }" var="question">
												<option value="${question.findQuestion_no }">
													${question.findQuestion_content}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle">비밀번호 찾기 정답</div>
									<div class="col fs-5"><input class="form-control" id="userfindAnswer"
											name="user_findAnswer" type="text" placeholder="비밀번호찾기 정답을 입력해주세요."
											aria-label="default input example"></div>
									<div class="col-3"></div>
								</div>
								<div class="row mt-3">
									<div class="inputTitle"></div>
									<div class="col-7 bi bi-exclamation-square-fill deepblue">
										비밀번호 찾기 답변은 고객님의 비밀번호 분실시 이용됩니다. 신중하게 기입해주시기 바랍니다.
									</div>
								</div>
								<div class="row mt-1">
									<div class="col"></div>
									<div class="col-2 d-grid mb-3 "><button type="button" id="joinButton"
											class="btnBasic inputSubmit bi bi-check2-square">&nbsp;가입하기</button></div>
									<div class="col-3"></div>
								</div>
							</div>
						</div>
					</form>
				</div>

				<!-- 페이지별 내용 끝 -->
			</div>

			<jsp:include page="../commons/screenLeft.jsp"></jsp:include>

		</div>
	</section>

	<jsp:include page="../commons/footer.jsp"></jsp:include>

</body>

</html>