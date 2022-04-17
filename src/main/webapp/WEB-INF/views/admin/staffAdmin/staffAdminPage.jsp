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
                    <h3 class="conTItle"><i class="bi bi-list"></i> 헹정관리자 페이지입니다</h3>
                </div>


                <!-- 페이지별 내용 시작-->

                <!-- 페이지별 내용 끝 -->

            </div>

            <div class="col-1 ms-5">
            </div>

        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
    <script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
</body>

</html>