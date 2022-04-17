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
          <h3 class="conTItle"><i class="bi bi-list"></i> 공지사항 </h3>
        </div>

        <!-- 페이지별 내용 시작-->
        <div class="row formTable">
          <div class="row">
            <table class="text-center">
              <thead>
                <tr>
                  <th scope="col">번호</th>
                  <th scope="col">제목</th>
                  <th scope="col">첨부</th>
                  <th scope="col">등록일자</th>
                  <th scope="col">조회</th>
                </tr>
              </thead>

              <tbody>
                <c:forEach items="${AnncmLines}" var="AnncmLine" varStatus="status">
                  <tr>
                    <td>
                      <c:out value="${status.count}"></c:out> <!-- sequence : 최신 글이 1번 시작 -->
                    </td>
                    <td>
                      <a href="./cusReadAnncm?anncm_no=${AnncmLine.announcementVo.anncm_no}">${AnncmLine.announcementVo.anncm_title
                        }</a>
                    </td>
                    <td>
                      <c:if test="${AnncmLine.isExistFiles > 0}"><i class="bi bi-download"></i></c:if>
                    </td>
                    <td>${AnncmLine.announcementVo.anncm_writedate }</td>
                    <td>${AnncmLine.announcementVo.anncm_readcount }</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
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