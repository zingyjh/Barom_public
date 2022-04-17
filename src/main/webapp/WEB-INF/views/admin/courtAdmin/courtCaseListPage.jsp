<!-- courtCaseListPage -->
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
    <link rel="stylesheet" type="text/css" href="../../resources/css/admin_commonFormCss.css">
    <!-- font css -->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="../../resources/js/admin/courtCaseListPage.js?version=3"></script>


    <title>renew_frame</title>
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
                 <h5> ${court.min_sj_court_category_name } 관리자 ${adminSession.admin_id }님 환영합니다. </h5>
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
                        <h3 class="secTitle fs-5"><i class="bi bi-list"></i> ${courtName } 관리자</h3>
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
                    <h3 class="conTItle"><i class="bi bi-list"></i> 배당사건 목록</h3>
                </div>

                
                <!-- 페이지별 내용 시작-->
                <div class="col contentArea">                           
               <div class="row mt-4">               
             <div class="row mt-2 formTable">
               <div class="row formTitleArea">
                  <div class="col formTitle"><span> <i class="bi bi-building"></i>  ${courtName }</span></div>
               </div>
            </div>       
               
                  
               </div>
               <div class="row divBorder">              
                  <div class="inputTitle">진행상황</div>   
                  <div class="col" style="padding:0px;">              
                   <div class="inputSec">					                                               
                     <select class="form-select" id="statusOption" aria-label="Default select example">
                        <option selected value="0">선택안함</option>
                        <c:forEach items="${list }" var="list">
                           <option value="${list.caseconfirmed_status_no }">${list.caseconfirmed_status_name }</option>
                        </c:forEach>
                     </select>   
                      </div>               
                  </div>              
                  <div class="inputTitle">판결문 여부</div>                   
                   <div class="col">                                
                     <select class="form-select" id="trialOption" aria-label="Default select example">
                        <option selected value="0">선택안함</option>
                        <option value="1">미작성</option>
                        <option value="2">작성완료</option>
                     </select>                                                                                                
                  </div>
               </div>
               <div class="row divBorder">
                  <div class="inputTitle">
                     <input type="radio" name="checkForm" value="1" checked>
                     <label style="vertical-align: text-bottom; color: #C65D7B;">등록일자</label>
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
                                 <button type="button" class="btnBasic inputSubmit dateButton" value='1'>당일</button>
                              </div>
                              <div class="col my-auto d-grid">
                                 <button type="button" class="btnBasic inputSubmit dateButton" value='2'>3일</button>
                              </div>
                              <div class="col my-auto d-grid">
                                 <button type="button" class="btnBasic inputSubmit dateButton" value='3'>7일</button>
                              </div>
                              <div class="col my-auto d-grid">
                                 <button type="button" class="btnBasic inputSubmit dateButton" value='4'>30일</button>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row divBorder">
                  <div class="inputTitle">
                     <input type="radio" name="checkForm" value="2">
                     <label style="vertical-align: text-bottom; color: #C65D7B;">사건검색</label>
                  </div>
                  <div class="inputSec">
                     <input type="text" id="confirmedNo" placeholder="소징번호를 입력해 주세요.">
                  </div>
               </div>
               <div class="row divborder">
                  <div class="col my-2">
                     <button type="button" class="btnBasic inputSubmit" id="searchButton">검색하기</button>
                  </div>
               </div>
               <div class="row mt-4">
                  <div class="col text-center my-auto">
                     <table class=" table-bordered">
                       <thead>
                         <tr>
                           <th scope="col">사건번호</th>
                           <th scope="col">사건유형</th>
                           <th scope="col">배당날짜</th>
                           <th scope="col">소 장</th>
                           <th scope="col">답변서</th>
                           <th scope="col">진행상황</th>
                           <th scope="col">판결문 작성</th>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="../../resources/js/frame/jquery-3.6.0.min.js"></script>   
</body>
</html>