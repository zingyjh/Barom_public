<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="../resources/css/commons/mainNav.css?version=8">

<c:choose>
	<c:when test="${adminSession.admin_category_no == 1 }">
		<!-- siteadmin 네비입니다. -->
		<div class="row mt-4">
			<!-- Menu -->
			<div class="col-2 px-0 logoBox">
				<a href="../admin/siteAdminPage"><img src="../../resources/img/logo_renew.png" class="img-fluid"></a>
			</div>
			<div class="col px-0 mainNavbar">
				<ul class="navBar">
					<li>
						<a href="">고객지원센터</a>
						<ul class="subNavBar">
							<li><a href="./adAnncmList">공지사항 관리</a></li>
							<li><a href="./adminFaqPage">자주하는질문</a></li>
							<li><a href="./mainQnAList">QnA 답변하기</a></li>
						</ul>
					</li>
					<li>
						<a href=""></a>
						<ul class="subNavBar">
							<li><a href=""></a></li>
							<li><a href=""></a></li>
							<li><a href=""></a></li>
							<li><a href=""></a></li>
						</ul>
					</li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
				</ul>
			</div>
			<div class="col-2 sideBox">
			</div>
		</div>
	</c:when>

	<c:when test="${adminSession.admin_category_no == 2 }">
		<!-- staffadmin 네비입니다. -->
		<div class="row mt-4">
			<!-- Menu -->
			<div class="col-2 px-0 logoBox">
				<a href="../admin/staffAdminPage"><img src="../../resources/img/logo_renew.png" class="img-fluid"></a>
			</div>
			<div class="col px-0 mainNavbar">
				<ul class="navBar">
					<li>
						<a href="./petitionListPage">소장심사</a>
						<ul class="subNavBar">

						</ul>
					</li>
					
				</ul>
			</div>
			<div class="col-2 sideBox">
			</div>
		</div>
	</c:when>

	<c:when test="${adminSession.admin_category_no == 3 }">
		<!-- courtadmin 네비입니다. -->
		<div class="row mt-4">
			<!-- Menu -->
			<div class="col-2 px-0 logoBox">
				<a href="../courtAdmin/courtAdminPage"><img src="../../resources/img/logo_renew.png" class="img-fluid"></a>
			</div>
			<div class="col px-0 mainNavbar">
				<ul class="navBar">
					<li>
						<a href="">법원행정</a>
						<ul class="subNavBar">
							<li><a href="../courtAdmin/courtCaseListPage">배당사건 목록</a></li>
							<li><a href="../courtAdmin/registJudgmentPage">판결문 작성</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="col-2 sideBox">
			</div>
		</div>
	</c:when>
</c:choose>