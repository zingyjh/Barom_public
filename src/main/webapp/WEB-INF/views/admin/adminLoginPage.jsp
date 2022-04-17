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
    <link rel="stylesheet" type="text/css" href="../resources/css/admin_commonCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/admin_frameCss.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/admin_commonFormCss.css">
    <!-- font css -->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>

    <script type="text/javascript" src="../resources/js/admin/adminLoginPage.js"></script>
    <script type="text/javascript" src="../resources/js/frame/jquery-3.6.0.min.js"></script>
    <title>barom_admin</title>
</head>

<body>

    <!-- header part start -->
    <header class="header">
        <section class="d-flex align-items-center">
            <article class="header_logo">

            </article>
            <article class="header_side d-flex flex-column align-items-end">

            </article>
            <article>

            </article>
        </section>
    </header>


    <section class="container-fluid">

        <div class="row mt-4">

            <!-- left Side -->

            <div class="col-2">
                <!-- 
                <div class="row px-3 py-3">
                    <div class="siteIntroBox secBorder">
                        <h3 class="secTitle"><i class="bi bi-list"></i> 담당자</h3>
                        <ul>
                           <li>사이트 관리자</li>
                           <li>소장심사 관리자</li>
                           <li>법원행정 관리자</li>
                        </ul>
                    </div>
                </div>
                -->
            </div>


            <!-- content -->

            <div class="col contentArea">

                <!-- page Title -->
                <div class="row mt-1 conTitleArea">
                    <h3 class="conTItle"><i class="bi bi-list"></i> JB이의제출시스템 관리자를 위한 페이지입니다</h3>
                </div>


                <!-- 페이지별 내용 시작-->
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-4 text-center">
                        <!-- 각 페이지 내용 여기에 들어가면 됩니다  -->
                        <form>
                            <div class="row">
                                <div class=" mt-5 fs-2 fw-bold text-center" style="color:#C65D7B;">관리자로그인</div>
                            </div>
                            <div class="row mt-3 text-end">
                                <div class="col" style="font-size:15px;">
                                    <a href="http://barom.s001lec.com:8080/">#메인페이지이동</a>
                                </div>
                            </div>
                            <div class="row mt-1">
                                <div class="col d-grid formTitle">
                                    <input type="text" placeholder="아이디를 입력해주세요." id="idInput" style="height:40px;">
                                </div>
                            </div>
                            <div class="row mt-1">
                                <div class="col d-grid formTitle">
                                    <input type="password" placeholder="비밀번호를 입력해주세요." id="pwInput"
                                        style="height:40px;">
                                </div>
                            </div>
                            <div class="row mt-1">
                                <div class="col d-grid ">
                                    <button type="button" class="btnBasic" id="loginButton"
                                        style="height:40px;">로그인</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-4"></div>
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