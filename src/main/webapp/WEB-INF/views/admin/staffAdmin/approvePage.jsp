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
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
      
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
                        <h3 class="secTitle"><i class="bi bi-list"></i> 메뉴</h3>
                        <ul>
                            <li><a href="../staffAdmin/petitionListPage">소장심사</a></li>
                           <li><a href="">메뉴2</a></li>
                           <li><a href="">메뉴3</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- content -->
            
            <div class="col contentArea">

                <!-- page Title -->
                <div class="row mt-1 conTitleArea">
                    <h3 class="conTItle"><i class="bi bi-list"></i> 소장 승인</h3>
                </div>

                
                <!-- 페이지별 내용 시작-->
              <div class="col ps-5" style=""> <!-- 각 페이지 내용 여기에 들어가면 됩니다  -->
				 <form action="./insertCaseConfirmedProcess" method="post">
				 <div class="row">				 
				 <div class="col">
				 <input type="hidden" name="caseconfirmed_status_no" value="3">
				 <input type="hidden" name="min_sj_court_category_no" value="${data.cbiVo.min_sj_court_category_no }">
				 <input type="hidden" name="min_sj_sgn_category_no" value="${data.cbiVo.min_sj_sgn_category_no }">				 
				 <input type="hidden" name="case_no" value="${data.caseVo.case_no }">
                 <input type="hidden" name="price"	value="${data.cbiVo.caseBasicInfo_price }">		 		 
				 </div>
				 </div>
			     <div class="row mt-3"> <!-- PDF 보여주기 -->
				 <div class="col text-center my-auto">
				 <iframe id="pdfBox" src="/upload/${data.dcVo.confirmed_url }" style="width:780px;height:780px;"></iframe>
				 </div>
				 </div>
				 <div class="row mt-2 formTable">
					<div class="row formTitleArea">
						<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 기본 정보</span></div>
					</div>
				</div>
			     <div class="row divBorder" style="height:48px;">
				 <div class="inputTitle" >문서번호</div>	
				 <div class="col-3 fw-bold" style=" border-left:1px dotted #F68989; color:#C71585; font-weight: 700;  padding: 0.5em 0.9em 0.7em 1em;">${data.caseVo.case_no }</div>		
				 <div class="inputTitle">법원</div>	
				 <div class="col-3 fw-bold" style=" border-left:1px dotted #F68989; color:#C71585; font-weight: 700; padding: 0.5em 0.9em 0.7em 1em;">${data.courtVo.min_sj_court_category_name }</div>			 
				 </div>					     
			     <div class="row divBorder" style="height:48px;">
				 <div class="inputTitle">사건명</div>	
				 <div class="col-3 fw-bold" style=" border-left:1px dotted #F68989; color:#C71585; font-weight: 700;  padding: 0.5em 0.9em 0.7em 1em;">${data.sgnVo.min_sj_sgn_category_name }</div>	
				 <div class="inputTitle ">소가</div>	
				 <div class="col-3 fw-bold" style=" border-left:1px dotted #F68989; color:#C71585; font-weight: 700;  padding: 0.5em 0.9em 0.7em 1em;">${data.cbiVo.caseBasicInfo_price }</div>				 
				 </div>
				 <div class="row divBorder" style="height:48px;">
				 <div class="inputTitle ">원고</div>	
				 <div class="col-3 fw-bold" style="border-left:1px dotted #F68989; color:#C71585; font-weight: 700;  padding: 0.5em 0.9em 0.7em 1em;">${data.plaintiffName }</div>				 
				 <div class="inputTitle " >피고</div>	
				 <div class="col-3 fw-bold" style="border-left:1px dotted #F68989; color:#C71585; font-weight: 700;  padding: 0.5em 0.9em 0.7em 1em;">${data.defendantName }</div>	
				 </div>				 
				 <div class="row divBorder" style="height:48px;">
				 <div class="inputTitle">첨부파일</div>	
				 <div class="col-3 fw-bold" style="border-left:1px dotted #F68989; font-weight: 700; color:#C71585; padding: 0.5em 0.9em 0.7em 1em;">
				 <c:forEach items="${data.pfVo }" var="file">
				 	${file.file_original_name }<br>
				 </c:forEach>
				 </div>				 
				 </div>		
				 <div class="row mt-5 formTable">
					<div class="row formTitleArea">
						<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 승인 소견</span></div>
					</div>
				</div>		 
			     <div class="row mt-1 divBorder">
				 <div class="col-2 inputTitle">승인소견</div>	
				 <div class="col d-grid"><textarea name="case_status_reason" style="height: 150px;"></textarea></div>				 			
				 </div>				 
				 <div class="row mt-3">	
				 <div class="col-11"></div>			 
				 <div class="col-1 text-end mb-5">
				 <button type="submit" class="btnBasic inputSubmit bi bi-check2-square"> 승인</button>
				 </div>
				 </div>
				 </form>
				</div>
                <!-- 페이지별 내용 끝 -->
            </div>

            <div class="col-1 ms-5">
            </div>
             </div>
         </section>
    
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> 
</body>
</html>