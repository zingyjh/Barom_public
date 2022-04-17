<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row formTable">
	<div class="row formTitleArea">
		<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 사건기본정보</span></div>
	</div>
	<form name="caseBasicForm" onsubmit="addCaseBasic(this); return false">

		<input type="hidden" name="caseBasicInfo_no" value="">
		<div class="row divBorder">
			<div class="inputTitle">사건명</div>
			<div class="inputSec">
				<select name="min_sj_sgn_category_no">
					<c:forEach items="#{sgn_list }" var="sgn">
						<option value="${sgn.min_sj_sgn_category_no }">${sgn.min_sj_sgn_category_name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">청구구분</div>
			<div class="inputSec">
				<input type="radio" name="caseBasicInfo_claim_method" value="Y_property" checked>
				<label>재산권상 청구</label>
				<input type="radio" name="caseBasicInfo_claim_method" value="N_property">
				<label>비재산권상 청구</label>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">소가구분</div>
			<div class="inputSec">
				<input type="radio" name="caseBasicInfo_price_method" value="amount" checked>
				<label>금액</label>
				<input type="radio" name="caseBasicInfo_price_method" value="appraisal">
				<label>토지 등의 평가액</label>
				<input type="radio" name="caseBasicInfo_price_method" value="none">
				<label>소가를 산출할 수 없는 경우</label>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">비용</div>
			<div class="inputSec">
				<input type="text" name="caseBasicInfo_price" value="1000">
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">법원</div>
			<div class="inputSec">
				<select name="min_sj_court_category_no">
					<c:forEach items="#{court_list }" var="court">
						<option value="${court.min_sj_court_category_no }">${court.min_sj_court_category_name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-1 text-center"></div>
			<div class="col">
				<h5 class="text-center text-success savedMsg">데이터가 저장되었습니다.</h5>
			</div>
			<div class="col-2">
				<input type="submit" class="btnBasic inputSubmit" value="저장">
			</div>
		</div>
	</form>
</div>