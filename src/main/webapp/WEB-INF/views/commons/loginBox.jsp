<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- left Side -->
<div class="col-2 ms-5">

	<!-- loginBox -->

	<div class="row px-3 py-2">
		<div class="loginBox secBorder col">
			<c:choose>
				<c:when test="${empty sessionUser }">
					<!-- not logined-->
					<h3 class="secTitle"><i class="bi bi-file-lock2-fill"></i> 로그인</h3>
					<form>
						<div class="loginForm">
							<input type="text" id="idInput" placeholder="아이디" required class="frm_input required "
								maxLength="20">
							<input type="password" id="pwInput" placeholder="비밀번호" required class="frm_input required "
								maxLength="20">

							<div>
								<div class="chk_box">
									<input type="checkbox" id="saveIdBox" name="">
									<label>ID저장</label>
								</div>
								<div class="login_btn_box">
									<button type="button" id="loginButton" class="btnBasic btn_submit">로그인</button>
								</div>
								<div class="login_etcBox">
									<a href="../user/userAgree">회원가입</a>
									<a href="../user/findUserInfoPage">ID/PW찾기</a>
								</div>
							</div>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<h3 class="secTitle"><i class="bi bi-file-lock2-fill"></i> 로그인</h3>
					<div class="loginForm">
						${sessionUser.user_name }님 환영합니다.
						<div>
							<div class="chk_box"></div>
							<div class="login_etcBox">
								<button type="button" id="logoutButton" class="btnBasic btn_submit">로그아웃</button>
							</div>
						</div>
					</div>

				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- etcList  -->
	<div class="row px-3 py-3">
		<div class="siteIntroBox secBorder">
			<h3 class="secTitle"><i class="bi bi-patch-question-fill"></i> 처음 오셨나요?</h3>
			<ul>
				<li><a href="">전자소송 안내</a></li>
				<li><a href="">전자소송 체험하기</a></li>
				<li><a href="">인증서 안내</a></li>
				<li><a href="">매뉴얼/동영상</a></li>
			</ul>
		</div>
	</div>

</div>