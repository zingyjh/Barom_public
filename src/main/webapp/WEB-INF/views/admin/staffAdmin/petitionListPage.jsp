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
	<link rel="stylesheet" type="text/css" href="../../resources/css/admin_commonCss.css">
	<link rel="stylesheet" type="text/css" href="../../resources/css/admin_frameCss.css">
	<link rel="stylesheet" type="text/css" href="../../resources/css/admin_commonFormCss.css">
	<!-- font css -->
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>

	<script type="text/javascript" src="../../resources/js/admin/petitionListPage.js?version=2"></script>
	<script type="text/javascript" src="../../resources/js/admin/jquery-3.6.0.min.js"></script>
	<title>barom_admin</title>
</head>

<body>

	<c:choose>
		<c:when test="${adminSession != null }">
			<header class="header">
				<section class="d-flex align-items-center">
					<article class="header_logo">

					</article>
					<article class="header_side d-flex flex-column align-items-end">
						<h5> ${adminSession.admin_id }님 환영합니다. </h5>
					</article>
					<article>
						<div class="header_logout"><a href="../../admin/adminLogoutProcess">로그아웃</a></div>
					</article>
				</section>
			</header>
		</c:when>
		<c:otherwise>
			<header class="header">
				<section class="d-flex align-items-center">
					<article class="header_logo">

					</article>
					<article class="header_side d-flex flex-column align-items-end">
						<h5> 세션이 만료되었습니다. </h5>
					</article>
					<article>
						<div class="header_logout"><a href="../../admin/adminLoginPage">로그인페이지로</a></div>
					</article>
				</section>
			</header>
		</c:otherwise>
	</c:choose>


	<section class="container-fluid">

		<div class="row mt-4">

			<!-- left Side -->
			<div class="col-2">
				<div class="row px-3 py-3">
					<div class="siteIntroBox secBorder">
						<h3 class="secTitle"><i class="bi bi-list"></i> 행정관리자</h3>
						<ul>
							<li><a href="../staffAdmin/petitionListPage">소장심사</a></li>
						</ul>
					</div>
				</div>
			</div>

			<!-- content -->

			<div class="col contentArea">

				<!-- page Title -->
				<div class="row mt-1 conTitleArea">
					<h3 class="conTItle"><i class="bi bi-list"></i> 소장 심사</h3>
				</div>


				<!-- 페이지별 내용 시작-->
				<div class="row mt-2 formTable">
					<div class="row formTitleArea">
						<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 소장 검색</span></div>
					</div>
					<div class="row divBorder">
					<div class="inputTitle">유형선택</div>
					<div class="inputSec">
						<div class="row">
							<div class="col-3">
								<select class="form-select" aria-label="Default select example">
									<option value="1">민사</option>
								</select>
							</div>
							<div class="col">
								<select class="form-select" aria-label="Default select example" id="docOption">
									<option value="0">모든 소장</option>
									<option value="1">승인전 소장</option>
									<option value="2">승인 소장</option>
									<option value="3">반려 소장</option>
								</select>
							</div>
							<div class="col my-auto">
								<select class="form-select" aria-label="Default select example" id="courtOption">
									<option value="0" selected>법원선택</option>
									<c:forEach items="${courtList }" var="list">
										<option value="${list.min_sj_court_category_no }">
											${list.min_sj_court_category_name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="row divBorder">
					<div class="inputTitle">
						<input type="radio" name="checkForm" id="dateRadio" value="1" style="padding:1px;" checked="checked">
						<label
							style="font-size: 1em; font-weight: 700; color: #C65D7B; padding: 0.1em 0.9em 0.7em 1em;">접수일자</label>
					</div>
					<div class="inputSec">
						<div class="row">
							<div class="col-2 my-auto">
								<input type="date" class="Date" name="minDate" id="minDate">
							</div>
							<div class="col-1 fs-4 text-center my-auto">~</div>
							<div class="col-2 my-auto">
								<input type="date" class="Date" name="maxDate" id="maxDate">
							</div>
							<div class="col">
								<div class="row my-auto">
									<div class="col my-auto d-grid">
										<button type="button" class="btnBasic inputSubmit" value='1'>당일</button>
									</div>
									<div class="col my-auto d-grid">
										<button type="button" class="btnBasic inputSubmit" value='2'>3일</button>
									</div>
									<div class="col my-auto d-grid">
										<button type="button" class="btnBasic inputSubmit" value='3'>7일</button>
									</div>
									<div class="col my-auto d-grid">
										<button type="button" class="btnBasic inputSubmit" value='4'>30일</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row divBorder">
					<div class="inputTitle">
						<input type="radio" name="checkForm" id="numberRadio" value="2" style="padding:1px;">
						<label
							style="font-size: 1em;font-weight: 700; color: #C65D7B; padding: 0.1em 0.9em 0.7em 1em;">사건검색</label>
					</div>
					<div class="inputSec d-grid">
						<input type="text" id="caseNo" placeholder="소징번호를 입력해 주세요.">
					</div>
				</div>
				<div class="row divBorder">
					<div class="col my-2">
						<button type="button" id="searchButton" class="btnBasic inputSubmit">소장 검색</button>
					</div>
				</div>
				</div>
				
				<div class="row mt-5 formTable">
					<div class="row formTitleArea">
						<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 소장 목록</span></div>
					</div>
					<div class="row divBorder">
					<div class="col text-center my-auto">
						<table class="table-bordered">
							<thead>
								<tr>
									<th scope="col">문서번호</th>
									<th scope="col">접수일자</th>
									<th scope="col">법원</th>
									<th scope="col">사건명</th>
									<th scope="col">원고</th>
									<th scope="col">피고</th>
									<th scope="col">사건기록</th>
									<th scope="col" style="width:150px;">승인/ 보정명령</th>
								</tr>
							</thead>
							<tbody id="listBody">

							</tbody>
						</table>
					</div>
				</div>
				</div>
				
				<!-- 페이지별 내용 끝 -->
			</div>

			<div class="col-1 ms-5">
			</div>
		</div>
	</section>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>
</body>

</html>