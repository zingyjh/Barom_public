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

	<script type="text/javascript" src="../resources/js/user/userAgree.js"></script>

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
					<h3 class="conTItle"><i class="bi bi-list"></i>사용자등록 진행 동의</h3>
				</div>
				<div class="row fs-6 deepblue fw-bold ps-5">
					<h5>◎ 이용약관</h5>
				</div>
				<div class="row formTable">
					<div class="card">
						<div class="card-body" style="overflow:auto; height:200px;">
							<h6 class="text-primary">제 1 장 총 칙<br></h6>
							<div class="deepblue">제 1 조 (목적)<br></div>
							이 약관은 {Barom_project}(이하 "http://barom.s001lec.com:8080/"라 합니다)에서 제공하는 인터넷서비스(이하
							"이의제기서비스"라 합니다)의 이용 조건 및 절차에 관한 기본적인 사항을 규정함을 목적으로 합니다.
							<br>
							<div class="deepblue">제 2 조 (약관의 효력 및 변경)<br></div>
							① 이 약관은 서비스 화면이나 기타의 방법으로 이용고객에게 공지함으로써 효력을 발생합니다.<br>
							② 사이트는 이 약관의 내용을 변경할 수 있으며, 변경된 약관은 제1항과 같은 방법으로 공지 또는 통지함으로써 효력을 발생합니다.<br>
							<div class="deepblue">제 3 조 (용어의 정의)<br></div>
							이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
							① 회원 : 사이트와 서비스 이용계약을 체결하거나 이용자 아이디(ID)를 부여받은 개인 또는 단체를 말합니다.<br>
							② 신청자 : 회원가입을 신청하는 개인 또는 단체를 말합니다.<br>
							③ 아이디(ID) : 회원의 식별과 서비스 이용을 위하여 회원이 정하고 사이트가 승인하는 문자와 숫자의 조합을 말합니다.<br>
							④ 비밀번호 : 회원이 부여 받은 아이디(ID)와 일치된 회원임을 확인하고, 회원 자신의 비밀을 보호하기 위하여 회원이 정한 문자와 숫자의 조합을 말합니다.<br>
							⑤ 해지 : 사이트 또는 회원이 서비스 이용계약을 취소하는 것을 말합니다.<br>
							<h6 class="text-primary">제 2 장 서비스 이용계약<br></h6>
							<div class="deepblue">제 4 조 (이용계약의 성립)<br></div>
							① 이용약관 하단의 동의 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.<br>
							② 이용계약은 서비스 이용희망자의 이용약관 동의 후 이용 신청에 대하여 사이트가 승낙함으로써 성립합니다.<br>
							<div class="deepblue">제 5 조 (이용신청)<br></div>
							① 신청자가 본 서비스를 이용하기 위해서는 사이트 소정의 가입신청 양식에서 요구하는 이용자 정보를 기록하여 제출해야 합니다.<br>
							② 가입신청 양식에 기재하는 모든 이용자 정보는 모두 실제 데이터인 것으로 간주됩니다. 실명이나 실제 정보를 입력하지 않은 사용자는 법적인 보호를 받을 수 없으며,
							서비스의 제한을 받을 수 있습니다.<br>
							<div class="deepblue">제 6 조 (이용신청의 승낙)<br></div>
							① 사이트는 신청자에 대하여 제2항, 제3항의 경우를 예외로 하여 서비스 이용신청을 승낙합니다.<br>
							② 사이트는 다음에 해당하는 경우에 그 신청에 대한 승낙 제한사유가 해소될 때까지 승낙을 유보할 수 있습니다.<br>
							가. 서비스 관련 설비에 여유가 없는 경우<br>
							나. 기술상 지장이 있는 경우<br>
							다. 기타 사이트가 필요하다고 인정되는 경우<br>
							③ 사이트는 신청자가 다음에 해당하는 경우에는 승낙을 거부할 수 있습니다.<br>
							가. 다른 개인(사이트)의 명의를 사용하여 신청한 경우<br>
							나. 이용자 정보를 허위로 기재하여 신청한 경우<br>
							다. 사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청한 경우<br>
							라. 기타 사이트 소정의 이용신청요건을 충족하지 못하는 경우<br>
							<div class="deepblue">제 7 조 (이용자정보의 변경)<br></div>
							회원은 이용 신청시에 기재했던 회원정보가 변경되었을 경우에는, 온라인으로 수정하여야 하며 변경하지 않음으로 인하여 발생되는 모든 문제의 책임은 회원에게
							있습니다.<br>
							<h6 class="text-primary">제 3 장 계약 당사자의 의무<br></h6>
							<div class="deepblue">제 8 조 (사이트의 의무)<br></div>
							① 사이트는 서비스 제공과 관련하여 취득한 회원의 개인정보를 회원의 동의없이 타인에게 누설, 공개 또는 배포할 수 없으며, 서비스관련 업무 이외의 상업적 목적으로
							사용할 수 없습니다. 단, 다음 각 호의 1에 해당하는 경우는 예외입니다.<br>
							가. 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우<br>
							나. 범죄에 대한 수사상의 목적이 있거나 정보통신윤리 위원회의 요청이 있는 경우<br>
							다. 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우<br>
							② 사이트는 이 약관에서 정한 바에 따라 지속적, 안정적으로 서비스를 제공할 의무가 있습니다.<br>
							<div class="deepblue">제 9 조 (회원의 의무)<br></div>
							① 회원은 서비스 이용 시 다음 각 호의 행위를 하지 않아야 합니다.<br>
							가. 다른 회원의 ID를 부정하게 사용하는 행위<br>
							나. 서비스에서 얻은 정보를 사이트의 사전승낙 없이 회원의 이용 이외의 목적으로 복제하거나 이를 변경, 출판 및 방송 등에 사용하거나 타인에게 제공하는 행위<br>
							다. 사이트의 저작권, 타인의 저작권 등 기타 권리를 침해하는 행위<br>
							라. 공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위<br>
							마. 범죄와 결부된다고 객관적으로 판단되는 행위<br>
							바. 기타 관계법령에 위배되는 행위<br>
							② 회원은 관계법령, 이 약관에서 규정하는 사항, 서비스 이용 안내 및 주의 사항을 준수하여야 합니다.<br>
							③ 회원은 내용별로 사이트가 서비스 공지사항에 게시하거나 별도로 공지한 이용 제한 사항을 준수하여야 합니다.<br>
							<h6 class="text-primary">제 4 장 서비스 제공 및 이용<br></h6>
							<div class="deepblue">제 10 조 (회원 아이디(ID)와 비밀번호 관리에 대한 회원의 의무)<br></div>
							① 아이디(ID)와 비밀번호에 대한 모든 관리는 회원에게 책임이 있습니다. 회원에게 부여된 아이디(ID)와 비밀번호의 관리소홀, 부정사용에 의하여 발생하는 모든
							결과에 대한 전적인 책임은 회원에게 있습니다.<br>
							② 자신의 아이디(ID)가 부정하게 사용된 경우 또는 기타 보안 위반에 대하여, 회원은 반드시 사이트에 그 사실을 통보해야 합니다.<br>
							<div class="deepblue">제 11 조 (서비스 제한 및 정지)<br></div>
							① 사이트는 전시, 사변, 천재지변 또는 이에 준하는 국가비상사태가 발생하거나 발생할 우려가 있는 경우와 전기통신사업법에 의한 기간통신 사업자가 전기통신서비스를
							중지하는 등 기타 불가항력적 사유가 있는 경우에는 서비스의 전부 또는 일부를 제한하거나 정지할 수 있습니다.<br>
							② 사이트는 제1항의 규정에 의하여 서비스의 이용을 제한하거나 정지할 때에는 그 사유 및 제한기간 등을 지체없이 회원에게 알려야 합니다.<br>
							<div class="text-primary">제5장 계약사항의 변경, 해지<br></div>
							<div class="deepblue">제 12 조 (정보의 변경)<br></div>
							회원이 주소, 비밀번호 등 고객정보를 변경하고자 하는 경우에는 홈페이지의 회원정보 변경 서비스를 이용하여 변경할 수 있습니다.<br>
							<div class="text-primary">제6장 손해배상<br></div>
							<div class="deepblue">제 14 조 (면책조항)<br></div>
							① 사이트는 회원이 서비스 제공으로부터 기대되는 이익을 얻지 못하였거나 서비스 자료에 대한 취사선택 또는 이용으로 발생하는 손해 등에 대해서는 책임이
							면제됩니다.<br>
							② 사이트는 회원의 귀책사유나 제3자의 고의로 인하여 서비스에 장애가 발생하거나 회원의 데이터가 훼손된 경우에 책임이 면제됩니다.<br>
							③ 사이트는 회원이 게시 또는 전송한 자료의 내용에 대해서는 책임이 면제됩니다.<br>
							④ 상표권이 있는 도메인의 경우, 이로 인해 발생할 수도 있는 손해나 배상에 대한 책임은 구매한 회원 당사자에게 있으며, 사이트는 이에 대한 일체의 책임을 지지
							않습니다.<br>
							<div class="deepblue">제 15 조 (관할법원)<br></div>
							서비스와 관련하여 사이트와 회원간에 분쟁이 발생할 경우 사이트의 본사 소재지를 관할하는 법원을 관할법원으로 합니다.<br>
							[부칙]<br>
							(시행일) 이 약관은 2022년 04월부터 시행합니다.<br>
						</div>
					</div>
					<div class="row text-end mt-1 pb-3">
						<div style="float:right;">
							<input type="checkbox" name="agree" id="agreed">
							<label>이용약관에 동의합니다. </label>
						</div>
					</div>
					<div class="row fs-6 deepblue fw-bold ps-4 mt-3">
						<h5>◎ 개인정보 수집 및 이용에 대한 동의</h5>
					</div>
					<div class="card mt-2">
						<div class="card-body" style="overflow:auto; height:200px;">
							<div class="deepblue">가. 개인정보의 수집/이용 목적</div>
							전자소송의 서비스 제공을 위한 계약의 성립(본인식별 및 본인의사 확인 등)과 그 이행(이의제기시스템의 제공과 이용 등)을
							위한 자료로 활용하기 위하여 귀하의 개인정보를 수집 및 이용하고 있습니다.
							<div class="deepblue">나. 수집하려는 개인정보의 항목</div>
							- 항목 : 아이디, 고유식별정보(주민등록번호) 성명, 주소, 휴대전화번호, 전자우편주소(이메일)
							<div class="deepblue">다. 개인정보의 보유 및 이용 기간</div>
							귀하의 개인정보는 사용자등록을 탈퇴하거나 사용자자격을 상실할 때와 같이 개인정보의 처리 목적 달성 등 그 개인정보가
							불필요하게 되었을 때 파기하는 것을 원칙으로 합니다.
							<div class="deepblue">라. 동의를 거부할 권리가 있다는 사실과 동의 거부에 따른 불이익 내용</div>
							귀하는 개인정보의 수집·이용에 동의하지 않으실 수 있습니다. 다만 동의 거부 시에는 이의제기시스템
							사용자등록이 공지사항, 바로가기(이용안내 및 부가기능) 등 제한된 일부 서비스만 이용 가능합니다.
						</div>
					</div>
					<div class="row text-end mt-1">
						<div style="float:right;">
							<input type="checkbox" name="agree" id="agreed2">
							<label>개인정보 수집 및 이용에 동의합니다. </label>
						</div>
					</div>
					<div class="row formEndBorder mt-3">
						<div class="col-1">
							<button type="button" onclick="" class="btn btn-outline-success">취소</button>
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
								이용약관에 동의하지 않으면
								등록 진행이 불가능합니다.
							</div>
							<div class="modal-footer">
								<!--  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>-->
								<button onclick="closeNoticeModal()" type="button" class="btn btn-primary">돌아가기</button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="noticeModal2" tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								개인정보 수집 및 이용방침에 동의하지 않으면
								등록 진행이 불가능합니다.
							</div>
							<div class="modal-footer">
								<!--  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>-->
								<button onclick="closeNoticeModal2()" type="button"
									class="btn btn-primary">돌아가기</button>
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