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
                    <h3 class="conTItle"><i class="bi bi-list"></i> 자주하는 질문</h3>
                </div>

                <!-- 페이지별 내용 시작-->

                <div class="formTable">
                    <div class="row formTitleArea"></div>

                    <table class="table">
                        <tr>
                            <th scope="row" width=100px align="center">구분</th>
                            <td width=>
                                ${faqdata.FAQ_CategoryVo.faq_category_name }
                            </td>
                            <th scope="row" width=100px align="center">조회</th>
                            <td width=100px align="center">
                                ${faqdata.faqVo.faq_readcount }
                            </td>
                        </tr>
    
                        <tr>
                            <th scope="row" width=100px align="center">질문</th>
                            <td colspan="3">
                                ${faqdata.faqVo.faq_title }
                            </td>
                        </tr>
    
                        <tr>
                            <td colspan="4">
                                <pre>${faqdata.faqVo.faq_content }</pre>
                            </td>
                        </tr>
                    </table>
    
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <a href="./faqPage" class="btn btnBasic" type="button">목록으로</a>
                    </div>
                </div>


                <!-- 페이지별 내용 끝 -->
            </div>

            <jsp:include page="../commons/screenLeft.jsp"></jsp:include>

        </div>
    </section>

    <jsp:include page="../commons/footer.jsp"></jsp:include>

</body>

</html>