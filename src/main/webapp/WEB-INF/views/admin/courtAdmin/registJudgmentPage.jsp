<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <!-- my css -->
    <link rel="stylesheet" type="text/css" href="../../resources/css/admin_commonCss.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/admin_frameCss.css">

    <link rel="stylesheet" type="text/css" href="../../resources/css/commonFormCss.css">
    <!-- font css -->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="../../resources/js/admin/registJudgmentPage.js?version=2"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

    <title>barom_admin</title>
</head>
<body>

    <!-- header part start -->
    <header class="header">
        <section class="d-flex align-items-center">
            <article class="header_logo">
                <img src="../../resources/img/logo_renew.png">
            </article>
            <article class="header_side d-flex flex-column align-items-end">
                <h5> 법원행정 관리자 <span>admincourt01</span>님 </h5>
            </article>
            <article>
                <div class="header_logout">로그아웃</div>
            </article>
        </section>
    </header>


    <section class="container-fluid">
        
        <div class="row mt-4">
            
            <!-- left Side -->
            <div class="col-2">
                <div class="row px-3 py-3">
                    <div class="siteIntroBox secBorder">
                        <h3 class="secTitle"><i class="bi bi-list"></i> 법정 관리자</h3>
                        <ul>
                           <li><a href="./courtCaseListPage">배당사건목록</a></li>
                           <li><a href="./registJudgmentPage">재판결과 등록</a></li>
                         
                        </ul>
                    </div>
                </div>
            </div>

            <!-- content -->
            
            <div class="col contentArea">

                <!-- page Title -->
                <div class="row mt-1 conTitleArea">
                    <h3 class="conTItle"><i class="bi bi-list"></i> 재판결과 등록</h3>
                </div>

                
                <!-- 페이지별 내용 시작-->
				<div class="col ps-3" style=""> <!-- 각 페이지 내용 여기에 들어가면 됩니다  -->
					<div class="row mt-4 fs-4 fw-bold"> <!-- subtitle -->
						사건기본정보

<!-- 						<div class="col my-auto fs-4 fw-bold">사건기본정보</div> -->

					</div>
					<div class="row mt-1 divisionLine"></div>
					<div class="row mt-1">
					 	<div class="col-2 my-auto">사건선택</div>
					 	<div class="col-4">
					 		<select class="form-select" id="statusSelect"aria-label="Default select example">
							  <option value="0" selected>진행상황</option>
							  <option value="2">소송합의</option>
							  <option value="4">재판중</option>
							</select>
					 	</div>
					 	<div class="col">
					 		<select class="form-select" id="caseList" aria-label="Default select example">
							  <option value="0" selected>사건번호</option>
							</select>
					 	</div>
					</div>
					<div class="row mt-3 border-bottom">
						 <div class="col-2 outline">사건명</div>
						 <div class="col-4" id="caseName"></div>
						 <div class="col-2 outline">등록날짜</div>	
						 <div class="col-4" id="caseDate"></div>
					</div>	
					<div class="row mt-3 border-bottom">
						 <div class="col-2 outline">원고</div>	
						 <div class="col-4" id="casePlaintiff"></div>
						 <div class="col-2 outline">피고</div>
						 <div class="col-4" id="caseDefendant"></div>
					</div>
					
					
					<div class="row mt-5 fs-4 fw-bold">종국결과</div>
						<div class="row mt-2">
					<div class="col-2 my-auto">판결선고</div>
						<div class="col-3">
							<input type="date" id="trialDate">
						</div>
						<div class="col-3">
					 		<select class="form-select" id="trialResult"aria-label="Default select example">
							  <option value="원고승" selected>원고승</option>
							  <option value="원고일부승">원고일부승</option>
							  <option value="원고패">원고패</option>
							  <option value="소각하">소각하</option>
							  <option value="소취하">소취하</option>
							  <option value="화해">화해</option>
							</select>
					 	</div>
					 	</div>
					
					<div class="row mt-5 fs-4 fw-bold">판결문 입력</div>
					<div class="row mt-3 border-top border-bottom">
						 <div class="col-2 outline">주 문</div>	<!-- 청구취지답변 -->
						 <div class="col d-grid">
						 <textarea id="resultOrder" name="purpose_answer_content" style="height: 150px;"></textarea>
						</div>				 
					</div>					 
					<div class="row mt-3 border-top border-bottom">
						<div class="col-2 outline">이 유</div>	<!-- 청구원인답변 -->
						<div class="col d-grid">
							<textarea id="resultReason" name="cause_answer_content" style="height: 200px;"></textarea>
					 	</div>				 
					 </div>	
					 
					 <div class="row mt-3 mb-4">
					 	<div class="col text-end">
					 		<button type="button" id="submitButton" class="btnBasic  btnMin me-3 ">등록</button>
				 			<button type="button" id="cancleButton" class="btnGray btnMin ">취소</button>
					 	</div>
					 </div>
					 
				</div>
                

                <!-- 페이지별 내용 끝 -->

            </div>

            <div class="col-1 ms-5">

            </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../../resources/js/frame/jquery-3.6.0.min.js"></script>   
</body>
</html>