<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row formTable">
	<div class="row formTitleArea">
		<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 청구 원인</span></div>
	</div>
	<form name="causeForm" onsubmit="addCause(this); return false">

		<div class="row divBorder">
			<div class="inputTitle">청구 원인</div>
			<div class="inputSec">
				<textarea name="cause_content" cols="100"></textarea>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-1"></div>
			<div class="col">
				<h5 class="text-center text-success savedMsg">데이터가 저장되었습니다.</h5>
			</div>
			<div class="col-2">
				<input type="submit" class="btnBasic inputSubmit" value="저장">
			</div>
		</div>
	</form>
</div>