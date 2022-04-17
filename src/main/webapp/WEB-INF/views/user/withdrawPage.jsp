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
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

    <script type="text/javascript" src="../resources/js/user/withdrawPage.js?v=2"></script>

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
                    <h3 class="conTItle"><i class="bi bi-list"></i> 소송합의 / 소송취하</h3>
                </div>

                <div class="row divBorder">
                    <div class="col">
                        <div class="inputTitle">유형선택</div>
                        <div class="inputSec">
                            <select id="selectConcrete" name="case_confirmed_no">
                            	<option value="0">유형선택</option>
                                <option value="2">소송합의</option>
                                <option value="1">소송취하</option>
                            </select>
                        </div>
                    </div>
                    <div class="col">
                        <div class="inputTitle">사건번호</div>
                        <div class="inputSec">
                            <select id="selectConfirmedNo">
                            	<option value="0">사건선택</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row divBorder">
                    <div class="col">
                        <div class="inputTitle">사건번호</div>
                        <div class="inputSec" id="confirmedNo">

                        </div>
                    </div>
                    <div class="col">
                        <div class="inputTitle">법원</div>
                        <div class="inputSec" id="court">

                        </div>
                    </div>
                </div>
                <div class="row divBorder">
                    <div class="col">
                        <div class="inputTitle">사건명</div>
                        <div class="inputSec" id="caseName">

                        </div>
                    </div>
                    <div class="col">
                        <div class="inputTitle">등록날짜</div>
                        <div class="inputSec" id="caseDate">

                        </div>
                    </div>
                </div>
                <div class="row divBorder">
                    <div class="col">
                        <div class="inputTitle">원고</div>
                        <div class="inputSec" id="casePlaintiff">

                        </div>
                    </div>
                    <div class="col">
                        <div class="inputTitle">피고</div>
                        <div class="inputSec" id="caseDefendant">

                        </div>
                    </div>
                </div>

                <div class="row formTable">
                    <form>
                        <div class="row formTitleArea">
                            <div class="col formTitle"><span id="reasonTitle"><i class="bi bi-clipboard-fill"></i>
                                    소송취하사유 입력</span></div>
                        </div>
                        <div class="row divBorder">
                            <div class="inputTitle" id="reasonSubTitle">소송취하사유</div>
                            <div class="inputSec">
                                <textarea cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="row formEndBorder">
                            <div class="col"></div>
                            <div class="col-2">
                                <button type="button" id="submitButton" class="btnBasic inputSubmit">제출</button>
                            </div>
                            <div class="col-2">
                                <button type="button" id="calncleButton" class="btnBasic inputSubmit">취소</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <jsp:include page="../commons/screenLeft.jsp"></jsp:include>

        </div>
    </section>

    <jsp:include page="../commons/footer.jsp"></jsp:include>

</body>

</html>