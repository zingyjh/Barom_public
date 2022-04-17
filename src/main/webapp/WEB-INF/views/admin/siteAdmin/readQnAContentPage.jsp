<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<title>barom_admin</title>
</head>

<body>

	<!-- header part start -->
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
                        <h3 class="secTitle"><i class="bi bi-list"></i> 고객지원센터</h3>
                        <ul>
                            <li><a href="./adAnncmList">공지사항 관리</a></li>
                            <li><a href="./adminFaqPage">자주하는질문 관리</a></li>
                            <li><a href="./mainQnAList">Q&A 관리</a></li>
                        </ul>
                    </div>
                </div>
            </div>

			<!-- content -->

			<div class="col contentArea">

				<!-- page Title -->
				<div class="row mt-1 conTitleArea">
					<h3 class="conTItle"><i class="bi bi-list"></i> Q&A 상세</h3>
				</div>


				<!-- 페이지별 내용 시작-->
				<div class="row mt-3">
					<div class="col">
						<h5>${data.questionVo.cus_question_title }</h5>
						<div class="row">
							<div class="col">
								<hr>
								<div class="row mt-2">
									<div class="col">
										글쓴이 : ${date.userVo.user_name }
										<fmt:formatDate value="${data.questionVo.cus_question_writedate }"
											pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />
									</div>
									<div class="col"></div>
									<div class="col">
										조회수 : ${date.questionVo.cus_question_readcount }
										좋아요 : ${totalLikeCount }
										댓글 : ${totalReppleCount }
									</div>
								</div>

								<div class="row">
									<div class="col">
										<hr>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="row mt-2">
					<div class="col">
						${date.questionVo.cus_question_content }
						<hr>
					</div>
				</div>

				<div class="row mt-2">
					<div class="row mt-5">
						<div class="col">
							<div class="wrap">
								<table class="">
									<thead>
										<tr>
											<th scope="col">답글번호</th>
											<th scope="col">답글내용</th>
											<th scope="col">답글작성자</th>
											<th scope="col">작성일</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${dataList }" var="data">
											<tr>
												<c:if
													test="${date.questionVo.cus_question_no == data.reppleVo.cus_question_no }">
													<th scope="row">${data.reppleVo.repple_no } </th>
													<td> ${data.reppleVo.repple_content }</td>
													<td> 관리자님</td>
													<td>
														<fmt:formatDate value="${data.reppleVo.repple_writedate }"
															pattern="yyyy년 MM월 dd일" />
														<c:if test="${!empty adminSession }">
															<c:if
																test="${adminSession.admin_no == data.reppleVo.user_no }">
																&ensp;<a
																	href="./deleteReppleContentProcess?repple_no=${data.reppleVo.repple_no }&cus_question_no=${data.reppleVo.cus_question_no } ">답글삭제</a>
																&ensp;<a
																	href="./updateReppleContentPage?repple_no=${data.reppleVo.repple_no }">답글수정</a>
															</c:if>
														</c:if>
													</td>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col">
						<form action="reppleContentProcess?cus_question_no=${date.questionVo.cus_question_no }"
							method="post">
							<div class="row mt-5">
								<div class="col-6">
									<div class="form-floating">
										<c:if test="${!empty adminSession}">
											<textarea class="form-control" id="floatingTextarea2"
												style="height: 100px" "width: 300px" ; name="repple_content"></textarea>
											<label for="floatingTextarea2">답글내용</label>
										</c:if>
									</div>
								</div>
								<div class="col">
									<c:if test="${!empty adminSession}">
										<div class="d-grid gap-3 d-md-block">
											<button class="btn btn-dark" type="button"
												onclick="location.href='./mainQnAList'">목록으로</button>
											<input type="submit" class="btn btn-dark" value="댓글작성">
										</div>
									</c:if>
								</div>
								<div class="col">
									<div class="d-grid gap-2 d-md-block">
										<c:if test="${!empty adminSession }">
											<button class="btn btn-dark" type="button"
												onclick="location.href='./deleteContentProcess?cus_question_no=${date.questionVo.cus_question_no}' ">삭제</button>
									</div>
									</c:if>
								</div>
							</div>
						</form>
					</div>
				</div>

				<!-- 페이지별 내용 끝 -->

			</div>

			<div class="col-1 ms-5">

			</div>

			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
				crossorigin="anonymous"></script>
			<script type="text/javascript" src="../resources/js/frame/jquery-3.6.0.min.js"></script>
</body>

</html>