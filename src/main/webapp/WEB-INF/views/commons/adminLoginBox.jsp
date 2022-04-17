<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../resources/css/commons/loginBox.css?=v8">

<c:choose>
	<c:when test="${adminSession != null }">
		<div class="row mt-3 pb-2 border border-3 rounded-3">
			<!-- Login Box -->
			<div class="col" style="">
				<div class="row mt-2">
					<div class="col my-auto text-center">
						${adminSession.admin_id }님 환영합니다.
					</div>
				</div>
				<div class="row pt-2">
					<div class="col text-center">
						<a href="../../admin/adminLogoutProcess"><button type="button">로그아웃</button></a>
					</div>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="row mt-3 pb-2 border border-3 rounded-3">
			<!-- Login Box -->
			<div class="col" style="">
				<div class="row mt-2">
					<div class="col my-auto text-center">
						세션이 만료되었습니다.
					</div>
				</div>
				<div class="row pt-2">
					<div class="col text-center">
						<a href="../adminLoginPage">관리자 로그인 페이지로 돌아가기</a>
					</div>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>