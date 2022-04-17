<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row formTable">
	<div class="row formTitleArea">
		<div class="col formTitle"><span><i class="bi bi-clipboard-fill"></i> 당사자정보</span></div>
	</div>
	<form name="concernedForm" onsubmit="addConcerned(this); return false">

		<div class="row divBorder">
			<table>
				<thead>
					<tr>
						<th>당사자구분</th>
						<th>당사자명</th>
						<th>대표자</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody id="concernedList">
					<tr>
						<td colspan="5" class="text-center">등록된 당사자 정보가 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
		<input type="hidden" name="concerned_no" value="0">
		<div class="row divBorder">
			<div class="inputTitle">당사자구분</div>
			<div class="inputSec">
				<input type="radio" name="concernedKind" value="0" checked id="concernedKind_0">
				<label>원고</label>
				<input type="radio" name="concernedKind" value="1" id="concernedKind_1">
				<label>피고</label>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">인격</div>
			<div class="inputSec">
				<select name="personal">
					<option value="corporation" selected>법인</option>
					<option value="individual">개인</option>
				</select>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">사업자등록번호</div>
			<div class="inputSec">
				<input type="text" name="resident_num">
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">당사자명</div>
			<div class="inputSec">
				<input type="text" name="name" style="float: left; width: 70%;">
				<div class="btnBasic inputSubmit" onclick="getLoginedUserInfo()"
					style="float: left; width: 25%; margin-left: 3%;">로그인정보</div>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">주소</div>
			<div class="inputSec">
				<input type="text" placeholder="번지" name="zipcode" style="float: left; width: 70%;">
				<div class="btnBasic inputSubmit" onclick="showSelectAddress()"
					style="float: left; width: 25%; margin-left: 3%;">주소찾기</div>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle"></div>
			<div class="inputSec">
				<input type="text" placeholder="지번 혹은 도로명 주소" name="address">
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle"></div>
			<div class="inputSec">
				<input type="text" placeholder="나머지 주소를 입력해 주세요" name="send_address">
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">국적</div>
			<div class="inputSec">
				<select name="nation">
					<option value="korea" selected>한국</option>
				</select>
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">전화번호</div>
			<div class="inputSec">
				<input type="text" placeholder="-를 제외한 번호 입력" name="phone">
			</div>
		</div>
		<div class="row divBorder">
			<div class="inputTitle">이메일</div>
			<div class="inputSec">
				<input type="text" name="email">
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