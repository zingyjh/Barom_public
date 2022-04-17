<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>글쓰기 페이지</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>

	<div style="width:1200px;margin : 0 auto">
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<!-- 글로벌 nav -->
					<jsp:include page="../commons/mainNav.jsp"></jsp:include>
				</div>
			</div>
			<form action="./updateReppleContentProcess" method="post">
				<div class="row mt-5"></div>
				<div class="col"></div>
				<div class="col">
					<div class="row mt-3">
						<div class="col-6">
							<div class="form-floating">
								<textarea class="form-control" id="floatingTextarea2" style="height: 200px"
									name="repple_content">${data.reppleVo.repple_content }</textarea>
								<input type="hidden" name="repple_no" value="${data.reppleVo.repple_no }">
								<input type="hidden" name="cus_question_no" value="${data.reppleVo.cus_question_no }">
								<label for="floatingTextarea2">댓글내용</label>
							</div>
						</div>
						<div class="col"></div>
						<div class="row mt-3">
							<div class="col-4 d-grid">
								<input type="submit" value="댓글수정" class="btn btn-primary">
							</div>
						</div>
						<div class="col"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
	</script>
</body>

</html>