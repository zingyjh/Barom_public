<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <!-- my css -->
    <link rel="stylesheet" type="text/css" href="../resources/css/frameCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/commonCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/commonFormCss.css">
    
    <!-- font css -->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">
    
    <!-- script -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
      
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
                    <h3 class="conTItle"><i class="bi bi-list"></i> Q&A ?????????</h3>
                </div>

                <!-- ???????????? ?????? ??????-->
                <div class="row formTable">
					<table>
						<thead>
						<tr>
							<th scope="col">??????</th>
							<th scope="col">??????</th>
							<th scope="col">?????????</th>
							<th scope="col">?????????</th>
							<th scope="col">?????????</th>
							<th scope="col">?????????</th>
						</tr>
						<tbody>
						<c:forEach items="${dataList }" var="data">
							    <tr>
							      <th scope="row">${data.questionVo.cus_question_no }</th>
									<c:choose>
										<c:when test="${sessionUser.user_no == data.questionVo.user_no }">
										  		<td class="text-center"><a href="./readContentPage?cus_question_no=${data.questionVo.cus_question_no }">${data.questionVo.cus_question_title }</a>
										      	</td>										
										</c:when>
										<c:when test="${data.questionVo.cus_question_secret == 'Y' }">
											<c:if test="${sessionUser.user_no == data.questionVo.user_no }">
										  		<td class="text-center"><a href="./readContentPage?cus_question_no=${data.questionVo.cus_question_no }">${data.questionVo.cus_question_title }</a>
										      	</td>											
										    </c:if>
										    <c:if test="${sessionUser.user_no != data.questionVo.user_no }">
										    	<td class="text-center">??????????????????.</td>
										    </c:if>
									     </c:when>
									     <c:otherwise>
									     	<td class="text-center"><a href="./readContentPage?cus_question_no=${data.questionVo.cus_question_no }">${data.questionVo.cus_question_title }</a>
									     	</td>
									     </c:otherwise>										    										
									</c:choose>
							      <td class="text-center">${data.userVo.user_name}</td>
							      <td class="text-center">${data.questionVo.cus_question_secret }</td>			      							      
							      <td class="text-center"><fmt:formatDate value="${data.questionVo.cus_question_writedate }" pattern="yyyy???MM???dd???" /></td>
							      <td class="text-center">${data.questionVo.cus_question_readcount }</td>
							    </tr>
						  </c:forEach>				
						</tbody>
					</thead>
					</table>
					<div class="row-3">
					<div align="right">
						<div class="col-2 d-grid">
							<c:if test="${!empty sessionUser }">
								<a href="./writeContentPage" class="btn btnBasic">?????????</a>
							</c:if>
						</div>
					</div>
				</div>					
				</div>

				

                <!-- ???????????? ?????? ??? -->
            </div>

            <jsp:include page="../commons/screenLeft.jsp"></jsp:include>

        </div>
    </section>

    <jsp:include page="../commons/footer.jsp"></jsp:include>
    
</body>
</html>