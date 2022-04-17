DROP TABLE Barom_user;
CREATE TABLE Barom_user (
	user_no NUMBER,
	findQuestion_no NUMBER,
	user_id VARCHAR2(20),
	user_pw VARCHAR2(500),
	user_name VARCHAR2(100),
	user_jumin1 VARCHAR2(6),
	user_jumin2 VARCHAR2(7),
	user_zipcode NUMBER,
	user_address VARCHAR2(500),
	user_send_address VARCHAR2(500),
	user_phone VARCHAR2(50),
	user_email VARCHAR2(500),
	user_state VARCHAR2(10),
	user_latestAccess DATE,
	user_findAnswer VARCHAR2(50)
);

DROP SEQUENCE Barom_user_sequence;
CREATE SEQUENCE Barom_user_sequence;

-- 회원정보 찾기 질문 T
DROP TABLE Barom_findQuestion;
CREATE TABLE Barom_findQuestion (
	findQuestion_no NUMBER,
	findQuestion_content VARCHAR2(50)
);

DROP SEQUENCE Barom_findQuestion_sequence;
CREATE SEQUENCE Barom_findQuestion_sequence;

DROP TABLE Barom_case;
CREATE TABLE Barom_case(
	case_no VARCHAR2(20),
	user_no NUMBER,
	status_no NUMBER,
	approval_no NUMBER,
	case_save_date DATE,
	case_refuse_reason VARCHAR2(2000)
);

DROP SEQUENCE Barom_case_seq;
CREATE SEQUENCE Barom_case_seq;

-- 소장 승인 상태
DROP TABLE Barom_approval_status;
CREATE TABLE Barom_approval_status (
	approval_no NUMBER,
	approval_name VARCHAR2(50)
);

DROP SEQUENCE Barom_approval_status_seq;
CREATE SEQUENCE Barom_approval_status_seq;


SELECT 'S' || TO_CHAR(SYSDATE,'yymmdd') || Barom_case_seq.nextval FROM Dual;

-- 1. 사건기본정보
DROP TABLE Barom_CaseBasicInfo;
CREATE TABLE Barom_CaseBasicInfo(
	caseBasicInfo_no NUMBER,
	case_no VARCHAR2(20),
	min_sj_sgn_category_no NUMBER,
	min_sj_court_category_no NUMBER,
	caseBasicInfo_claim_method VARCHAR2(20),
	caseBasicInfo_price_method VARCHAR2(30),
	caseBasicInfo_price NUMBER
);

DROP SEQUENCE Barom_CaseBasicInfo_seq;
CREATE SEQUENCE Barom_CaseBasicInfo_seq;


-- 1. 민사 - 소장 - 사건명 카테고리

DROP TABLE BR_Min_Sj_Sgn_Category;
CREATE TABLE BR_Min_Sj_Sgn_Category(
		min_sj_sgn_category_no NUMBER,
		min_sj_sgn_category_name VARCHAR2(150)
);

DROP SEQUENCE BR_Min_Sj_Sgn_Category_seq; 
CREATE SEQUENCE BR_Min_Sj_Sgn_Category_seq;

SELECT * FROM BR_Min_Sj_Sgn_Category ORDER BY min_sj_sgn_category_no ASC;

-- 2. 민사-소장-법원(Court)명 카테고리


DROP TABLE BR_Min_Sj_Court_Category;
CREATE TABLE BR_Min_Sj_Court_Category(
		min_sj_court_category_no NUMBER,
		min_sj_court_category_name VARCHAR2(150)
);

DROP SEQUENCE BR_Min_Sj_Court_Category_seq; 
CREATE SEQUENCE BR_Min_Sj_Court_Category_seq;

SELECT * FROM BR_Min_Sj_Court_Category ORDER BY min_sj_court_category_no ASC;


-- 2. 당사자(원고)
DROP TABLE Barom_Plaintiff;
CREATE TABLE Barom_Plaintiff(
	plaintiff_no NUMBER,
	case_no VARCHAR2(20),
	plaintiff_personal VARCHAR2(30),
	plaintiff_selected VARCHAR2(10),
	plaintiff_resident_num VARCHAR2(20),
	plaintiff_name VARCHAR2(100),
	plaintiff_zipcode NUMBER,
	plaintiff_address VARCHAR2(500),
	plaintiff_send_address VARCHAR2(500),
	plaintiff_nationality VARCHAR2(20),
	plaintiff_phone VARCHAR2(50),
	plaintiff_email VARCHAR2(500)
);

DROP SEQUENCE Barom_Plaintiff_seq;
CREATE SEQUENCE Barom_Plaintiff_seq;

-- 3. 당사자(피고)
DROP TABLE Barom_Defendant;
CREATE TABLE Barom_Defendant (
	defendant_no NUMBER,
	case_no VARCHAR2(20),
	defendant_personal VARCHAR2(30),
	defendant_resident_num VARCHAR2(20),
	defendant_name VARCHAR2(100),
	defendant_zipcode NUMBER,
	defendant_address VARCHAR2(500),
	defendant_send_address VARCHAR2(500),
	defendant_nationality VARCHAR2(20),
	defendant_phone VARCHAR2(50),
	defendant_email VARCHAR2(500)
);

DROP SEQUENCE Barom_Defendant_seq;
CREATE SEQUENCE Barom_Defendant_seq;

-- 4. 청구취지
DROP TABLE Barom_Purpose;
CREATE TABLE Barom_Purpose (
	purpose_no NUMBER,
	case_no VARCHAR2(20),
	purpose_content VARCHAR2(4000),
	purpose_attach VARCHAR2(100)
);

DROP SEQUENCE Barom_Purpose_seq;
CREATE SEQUENCE Barom_Purpose_seq;

-- 5. 청구원인
DROP TABLE Barom_Cause;
CREATE TABLE Barom_Cause (
	cause_no NUMBER,
	case_no VARCHAR2(20),
	cause_content VARCHAR2(4000),
	cause_attach VARCHAR2(100)
);

DROP SEQUENCE Barom_Cause_seq;
CREATE SEQUENCE Barom_Cause_seq;

-- 6. 입증서류
DROP TABLE Barom_ProofFile;
CREATE TABLE Barom_ProofFile(
	file_no NUMBER
	,case_no VARCHAR2(20)
	,file_name VARCHAR2(500)
	,file_original_name VARCHAR2(500)
	,file_extension VARCHAR2(10)
	,file_date DATE
);

DROP SEQUENCE Barom_ProofFile_seq;
CREATE SEQUENCE Barom_ProofFile_seq;


-- 7. 작성문서 확인
DROP TABLE Barom_DocumentConfirmed;
CREATE TABLE Barom_DocumentConfirmed(
	confirmed_no NUMBER,
	case_no VARCHAR2(20),
	confirmed_url VARCHAR2(100),
	confirmed_status VARCHAR2(1)
);

DROP SEQUENCE Barom_DocumentConfirmed_seq;
CREATE SEQUENCE Barom_DocumentConfirmed_seq;



--12. 소장 제출 상태 
DROP TABLE Barom_submit_status;
CREATE TABLE Barom_submit_status (
   status_no NUMBER,
   status_name VARCHAR2(50)
);

DROP SEQUENCE Barom_submit_status_seq;
CREATE SEQUENCE Barom_submit_status_seq;


--13. 배당사건
DROP TABLE Barom_Case_Confirmed;
CREATE TABLE Barom_Case_Confirmed (
   Case_Confirmed_no VARCHAR2(50),
   case_no VARCHAR2(20),
   min_sj_sgn_category_no NUMBER,
   min_sj_court_category_no NUMBER,
   caseconfirmed_status_no NUMBER,
   case_confirmed_date DATE,
   case_status_reason VARCHAR2(4000)
);

DROP SEQUENCE Barom_Case_Confirmed_seq;
CREATE SEQUENCE Barom_Case_Confirmed_seq;

--14. 승인 사건 뱅당 상황 
DROP TABLE BR_Case_confirmed_Status;
CREATE TABLE BR_Case_confirmed_Status (
   caseconfirmed_status_no NUMBER,
   caseconfirmed_status_name VARCHAR2(500)
);

DROP SEQUENCE BR_Case_confirmed_Status_seq;
CREATE SEQUENCE BR_Case_confirmed_Status_seq;

--15. 피고 사건등록 
DROP TABLE Barom_defendant_case;
CREATE TABLE Barom_defendant_case (
   defendant_case_no NUMBER,
   Case_Confirmed_no VARCHAR2(50),
   user_no NUMBER
);

DROP SEQUENCE Barom_defendant_case_seq;
CREATE SEQUENCE Barom_defendant_case_seq;

-- 16. 답변서
DROP TABLE Barom_Defense;
CREATE TABLE Barom_Defense (
   Defense_no NUMBER,
   Case_Confirmed_no VARCHAR2(50),
   user_no NUMBER,
   cause_answer_content VARCHAR2(4000),
   purpose_answer_content VARCHAR2(4000),
   defense_date DATE
);

DROP SEQUENCE Barom_Defense_seq;
CREATE SEQUENCE Barom_Defense_seq;

-- 16.1 답변서 첨부서류
DROP TABLE Barom_Defense_ProofFile;
CREATE TABLE Barom_Defense_ProofFile (
   file_no NUMBER,
   Defense_no VARCHAR2(50),
   file_name VARCHAR2(1000),
   file_original_name VARCHAR2(1000),
   file_extension VARCHAR2(10),
   file_date DATE
);

DROP SEQUENCE Barom_Defense_ProofFile_seq;
CREATE SEQUENCE Barom_Defense_ProofFile_seq;

-- 16.2 답변서 PDF 
DROP TABLE Barom_Defense_Document;
CREATE TABLE Barom_Defense_Document (
	document_no NUMBER,
	Defense_no NUMBER,
	document_url VARCHAR2(400)
);

DROP SEQUENCE Barom_Defense_Document_seq;
CREATE SEQUENCE Barom_Defense_Document_seq;

--17. 사건입증서류
DROP TABLE Barom_Confirmed_ProofFile;
CREATE TABLE Barom_Confirmed_ProofFile (
   file_no NUMBER,
   Case_Confirmed_no VARCHAR2(50),
   file_name VARCHAR2(20),
   file_original_name VARCHAR2(500),
   file_extension VARCHAR2(10),
   file_date DATE
);

DROP SEQUENCE Barom_Confirmed_ProofFile_seq;
CREATE SEQUENCE Barom_Confirmed_ProofFile_seq;

--18. 재판 결과
DROP TABLE Barom_trial;
CREATE TABLE Barom_trial (
   trial_no VARCHAR2(50),
   Case_Confirmed_no VARCHAR2(50),
   trial_date DATE,
   trial_result_status VARCHAR2(50),
   trial_result_order VARCHAR2(4000),
   trial_result_reason VARCHAR2(4000),
   trial_regist_date DATE
);


DROP SEQUENCE Barom_trial_seq;
CREATE SEQUENCE Barom_trial_seq;

--18-1. 판결문
DROP TABLE Barom_trial_document;
CREATE TABLE Barom_trial_document (
	trial_document_no NUMBER,
	trial_no NUMBER,
	trial_document_url VARCHAR2(500)
);

DROP SEQUENCE Barom_trial_document_seq;
CREATE SEQUENCE Barom_trial_document_seq;

--19. 관리자 테이블
DROP TABLE Barom_admin;
CREATE TABLE Barom_admin (
   admin_no NUMBER,
   min_sj_court_category_no NUMBER,
   admin_category_no NUMBER,
   admin_id VARCHAR2(20),
   admin_pw VARCHAR2(500)
);

DROP SEQUENCE Barom_admin_seq;
CREATE SEQUENCE Barom_admin_seq;

--20. 관리자 카테고리 
DROP TABLE admin_category;
CREATE TABLE admin_category (
   admin_category_no NUMBER,
   admin_category_name VARCHAR2(200)
);

DROP SEQUENCE admin_category_seq;
CREATE SEQUENCE admin_category_seq;

--21. 대리인 관계
DROP TABLE BR_attorney_realted;
CREATE TABLE BR_attorney_realted (
   attorney_related_no NUMBER,
   concerned_no NUMBER,
   attorney_no NUMBER,
   attorney_related_for VARCHAR2(1)
);

DROP SEQUENCE BR_attorney_realted_seq;
CREATE SEQUENCE BR_attorney_realted_seq;

--22. 대리인 정보
DROP TABLE Barom_attorney;
CREATE TABLE Barom_attorney (
   attorney_no NUMBER,
   attorney_personal VARCHAR2(30),
   attorney_resident_num VARCHAR2(20),
   attorney_name VARCHAR2(100),
   attorney_zipcode NUMBER,
   attorney_address VARCHAR2(500),
   attorney_send_address VARCHAR2(500),
   attorney_nationality VARCHAR2(20),
   attorney_phone VARCHAR2(50),
   attorney_email VARCHAR2(500)
);

DROP SEQUENCE Barom_attorney_seq;
CREATE SEQUENCE Barom_attorney_seq;

--23. 결제 테이블
DROP TABLE Barom_DocumentPay;
CREATE TABLE Barom_DocumentPay(
documentpay_no NUMBER
,case_no VARCHAR2(20)
,pay_name VARCHAR2(500)
,pay_user_id VARCHAR2(50)
,pay_method VARCHAR2(50)
,pay_price NUMBER
,pg_token VARCHAR2(150)
,pay_date DATE
);

DROP SEQUENCE Barom_DocumentPay_seq;
CREATE SEQUENCE Barom_DocumentPay_seq;




-------- customer

-- 24. Q&A 게시판
DROP TABLE Br_customre_question;
CREATE TABLE Br_customre_question(
	cus_question_no NUMBER,
	user_no NUMBER,
	cus_question_title VARCHAR2(200),
	cus_question_content VARCHAR2(4000),
	cus_question_readcount NUMBER,
	cus_question_secret VARCHAR2(2),
	cus_question_writedate DATE
);

DROP SEQUENCE Br_customer_question_seq;
CREATE  SEQUENCE Br_customer_question_seq;

SELECT * FROM BR_CUSTOMRE_QUESTION;

-- 25. 댓글 쿼리
DROP TABLE Br_Repple;
CREATE TABLE Br_Repple(
	repple_no NUMBER,
	user_no NUMBER,
	cus_question_no NUMBER,
	repple_content VARCHAR2(4000),
	repple_writedate DATE
);

DROP SEQUENCE Br_Repple_seq;
CREATE SEQUENCE Br_Repple_seq;

SELECT * FROM Br_Repple;

-- 26. 게시글 좋아요 쿼리
DROP TABLE BR_CUSTOMRE_QUESTION_LIKE;
CREATE TABLE BR_CUSTOMRE_QUESTION_LIKE(
	like_no NUMBER,
	user_no NUMBER,
	cus_question_no NUMBER,
	like_date DATE 
);

SELECT * FROM BR_CUSTOMRE_QUESTION_LIKE;

DROP SEQUENCE Br_Like_seq;
CREATE SEQUENCE Br_Like_seq;


-- 27. 댓글 좋아요 쿼리
DROP TABLE BR_Repple_like;
CREATE TABLE BR_Repple_like(
	like_no NUMBER,
	user_no NUMBER,
	repple_no NUMBER,
	like_date DATE
);

DROP SEQUENCE BR_Repple_like_seq;
CREATE SEQUENCE BR_Repple_like_seq;

-- 28. FAQ 게시판
DROP TABLE BR_FAQ;
CREATE TABLE BR_FAQ (
   faq_no NUMBER, 
   admin_no NUMBER,
   faq_category_no NUMBER, 
   faq_title VARCHAR2 (200),
   faq_content VARCHAR2 (4000),
   faq_readcount NUMBER 
);

DROP SEQUENCE BR_FAQ_seq;
CREATE SEQUENCE BR_FAQ_seq;

-- 관리자_FAQ Insert 데이터

-- 관리자_FAQ Insert 데이터


INSERT INTO BR_FAQ VALUES (
	BR_FAQ_seq.nextval,
	1,
	1,
	'전자소송으로 진행되고 있는 사건에 대해 전자소송 홈페이지에서 어떻게 기록을 전자적으로 열람할 수 있나요?',
	'전자소송으로 진행되고 있는 사건에 대해 전자소송 홈페이지에서 전자적으로 기록을 열람하기 위하여는 먼저 전자소송 홈페이지 회원가입을 하고 ‘나의 전자소송 > 전자소송사건등록’ 메뉴에서 ‘전자소송 절차진행에 대한 동의’와 ‘전자소송사건등록’을 하여야 합니다.


	전자소송 절차진행에 대한 동의는 전자소송사건등록시 [전자소송동의 박스]에 체크하는 방식으로 하며, 당사자나 사건관계인이 전자소송사건등록을 하기 위하여는 ‘전자소송인증번호’가 필요합니다.

	전자소송인증번호란 전자소송 이용 시에 본인이 해당 사건의 당사자 또는 대리인인지를 식별하는 고유번호로써 법원에서는 종이소송을 진행하는 당사자에게 ‘전자소송인증번호’를 발급한 후 피고에게는 소장 부본을 송달할 때, 원고에게는 답변서 부본을 송달할 때 ‘전자소송 안내서’에 전자소송 인증번호를 기재하여 송달하여 드리고 있습니다.

	당사자나 사건관계인으로서 법원으로부터 부여받은 전자소송인증번호가 있는 경우 전자소송사건등록에서 ‘전자소송인증번호가 있는 경우’탭을 선택하고 소송유형, 법원, 사건번호, 소송관계인 유형, 전자소송인증번호를 입력하여 전자소송사건등록을 합니다.


	만일 당사자나 사건관계인으로서 법원으로부터 부여받은 전자소송인증번호가 없는 경우에는 법원(담당재판부)에 인증번호의 부여를 요청할 수 있으며, 이미 인증번호가 부여되었으나 받지 못하거나 이를 분실한 경우에는 법원에 직접 방문하거나 또는 담당재판부에 유선연락 후 신분증 등을 팩스로 전송하는 방법으로 전자소송인증번호를 확인한 후 전자소송사건등록을 할 수 있습니다.


	또한 소장이나 신청서에 원고(신청인)와 피고(피신청인)의 주민등록번호가 기재된 채로 제출이 되어, 원고(신청인)와 피고(피신청인)의 주민등록번호가 사건정보에 등록되어 있는 경우에는 ‘전자소송인증번호가 없는 경우’를 선택하여 전자소송인증번호를 입력하지 않더라도 전자소송사건등록을 할 수 있습니다.


	전자소송사건등록을 마친 후에는 ‘나의전자소송 > 나의사건관리’의 진행중 사건으로 등록이 되며, 이후 ‘열람/발급 > 나의사건열람’에서 조회가 되므로 사건기록란의 [열람]버튼을 클릭하여 기록을 전자적으로 열람할 수 있습니다.',
	0
);


INSERT INTO BR_FAQ VALUES (
	BR_FAQ_seq.nextval,
	1,
	4,
	'주말에는 소송비용납부를 할 수 없나요?',
	'전자소송 홈페이지를 통한 소송비용납부의 납부는
	1) 신용카드, 계좌이체, 휴대폰소액결제의 경우 평일(월~금) 오전 9시부터 오후 10시까지, 휴일 및 법정공휴일에는 오전 9시부터 오후 8시 까지 납부할 수 있으며,
	2) 가상계좌번호를 이용한 각 은행의 납부 이용시간은 평일(월~금) 오전 1시부터 오후 10시까지 가능하고, 일부 은행은 휴일 거래가 불가능합니다.
	결제 가능시간은 해당금융기관의 서비스시간을 기준으로 하므로 휴일 거래 시 해당 은행의 서비스 이용 시간을 직접 문의하신 후 진행해 주시기 바랍니다.',
	0
);


INSERT INTO BR_FAQ VALUES (
	BR_FAQ_seq.nextval,
	1,
	9,
	'파일첨부가 정상적으로 실행되지 않습니다. 어떻게 해야 하나요?',
	'파일첨부 또는 다운이 되지 않을 경우에는 사용자 PC의 ‘컴퓨터 > 프로그램 제거 또는 변경’에서 이노릭스 프로그램을 제거한 후 ‘전자소송 홈페이지 > 전체메뉴보기 > 프로그램 설치 > 선택프로그램 설치목록’에서 [파일송수신 프로그램 다운로드]를 클릭하여 프로그램을 재설치한 후 다시 시도해 주시기 바랍니다.

 
	1) ‘제어판 > 프로그램 제거 또는 변경’에서 이노릭스 프로그램 제거

	2) ‘전자소송 홈페이지 > 전체메뉴보기 > 프로그램 설치 > 선택프로그램 설치목록’에서 [파일송수신 프로그램 다운로드]를 클릭하여 프로그램 재설치

 
	다시 시도한 경우에도 문제가 해결되지 않는다면 개인사용자 PC환경, 운영체제 등 여러 가지 원인이 있을 수 있으므로 법원 사용자지원센터 00-0000-0000(평일 9시~18시)로 연락 주시면 원격처리 등을 이용하여 직접 도움을 드리도록 하겠습니다.',
	0
);


INSERT INTO BR_FAQ VALUES (
   BR_FAQ_seq.nextval,
   1,
   5,
   '소송을 취하하였습니다. 인지대와 송달료는 어떻게 환급받나요?',
   '1. 인지대

   소장 등이 각하, 소 취하, 청구 포기·인낙, 조정·화해로 종결된 사건에 대해서는 인지액 환급 청구가 가능하고, 납부한 인지액의 1/2에 해당하는 금액을 환급하여 드리고 있습니다. 그러나 납부한 인지액의 1/2에 해당하는 금액이 10만원 미만인 경우에는 인지액에서 10만 원을 공제하고 남은 금액이 환급되며, 소취하 등으로 인지대 환급 사유가 발생하면 별도의 신청없이 재판부에서 인지환급통지서를 납부자에게 송부하여 주므로 위 인지환급통지서를 수령한 후 ‘전자소송 홈페이지’ → ‘납부/환급’ → ‘인지액납부환급청구’에서 청구서를 작성하고 제출하시면 남은 인지액의 환급을 받으실 수 있습니다.

 
   2. 송달료

   사건이 종결되면(소취하, 판결선고 등) 남은 송달료는 별도의 신청없이 재판부에서 송달료 종결처리 절차를 거쳐 송달료 납부시 기재한 환급계좌로 환급하여 드리고 있으며, 환급계좌를 기재하지 않은 경우에는 은행에서 납부인 주소로 환급통지서를 보내 드리고 있습니다.',
   0
);


INSERT INTO BR_FAQ VALUES (
   BR_FAQ_seq.nextval,
   1,
   8,
   '종이소송을 진행 중입니다. 전자소송에 동의하지 않고 판결문만을 전자송달로 받을 수 있습니까?',
   '전자소송 홈페이지의 "송달문서확인>판결문전자송달신청" 메뉴에서 사건번호를 입력하고 판결문 전자송달을 신청하시면 판결문(판결에 갈음하는 결정, 조서 포함)을 전자송달 받을 수 있습니다.

   전자소송 진행에 동의한 사건이거나 송달 대상자가 아닌 경우에는 신청이 불가능합니다.',
   0
);



-- 29. FAQ  카테고리
DROP TABLE BR_FAQ_Category;
CREATE TABLE BR_FAQ_Category(
		faq_category_no NUMBER,
		faq_category_name VARCHAR2(60)
);

DROP SEQUENCE BR_FAQ_Category_seq;
CREATE SEQUENCE BR_FAQ_Category_seq;


-- 30. 공지사항 게시판
DROP TABLE BR_Announcement;
CREATE TABLE BR_Announcement(
		anncm_no NUMBER,
		admin_no NUMBER,
		anncm_title VARCHAR2(100),
		anncm_content VARCHAR2(2000),
		anncm_writedate DATE,
		anncm_readcount NUMBER 
);

DROP SEQUENCE BR_Announcement_seq;
CREATE SEQUENCE BR_Announcement_seq;

-- 관리자_공지사항 Insert 데이터


-- (관리자) 공지사항 1
INSERT INTO BR_Announcement VALUES (
		BR_Announcement_seq.nextval,
		1,
		'신용카드 결제오류시 조치 안내',
		'안녕하십니까. 전자소송홈페이지를 이용해 주셔서 감사드립니다.
		신용카드 결제 관련하여 Non-Active X 방침으로 인해 시스템이 변경되었습니다.
		
		이로 인해 오류 발생 시 조치방법에 대하여 안내하여 드립니다.
		
		[주요 오류현상]
		1. 신용카드 결제창 자체가 나오지 않음
		2. 신용카드 결제창에서 결제정보 입력 후, 다음 단계로 넘어가지 않음
		3. 신용카드 결제창에서 결제 완료 후, 완료 페이지가 나오지 않음
		4. 신용카드 결제창이 팝업으로 나오지 않고 메인 화면에 표시됨
		
		[조치방법]
		1. 인터넷 익스플로러 보안설정에서 해당 신용카드사의 사이트 주소를 신뢰할 수 있는 사이트로 등록하여 조치함
		2. 각 카드사별로 신뢰할 수 있는 사이트를 등록하는 세부방법은 첨부를 참조하여 주시기 바랍니다.
		
		
		* 신뢰할 수 있는 사이트 등록 후에도 신용카드 결제 오류 발생 시 전자지급결제 대행사(02-2099-1286)로 문의주시면 상세히 안내하여 드리겠습니다.
		
		감사합니다.',
		SYSDATE,
		0
);

-- 공지사항 2
INSERT INTO BR_Announcement VALUES (
		BR_Announcement_seq.nextval,
		1,
		'전자서명 인증서 관련 안내 말씀',
		'전자소송 홈페이지에서 사용 가능한 인증서(개인용/법인용)는 다음과 같습니다.

								- 다 음 -
								
								
			
			○ 아래 5개 기관이 발급한 공동인증서(구 공인인증서)
			
			
			
			 ① 한국정보인증 (https://www.signgate.com)

			 ② 코스콤 (https://www.koscom.co.kr)
			
			 ③ 한국전자인증 (https://www.crosscert.com)
			
			 ④ 한국무역정보통신 (https://www.tradesign.net)
			
			 ⑤ 금융결제원 (https://www.yessign.or.kr)

																							
																							
																			※ 추후 사용 가능한 인증서 지정이 추가되면 별도 공고해 드리겠습니다..',															
		SYSDATE,
		0
);

-- 공지사항 3
INSERT INTO BR_Announcement VALUES (
		BR_Announcement_seq.nextval,
		1,
		'[공고] 전자소송 시스템 이용에 관한 공고(법원행정처 공고 제2022-79호)',
		'법원행정처 공고 제2022-79호





		전자소송 시스템 이용에 관한 공고
		
		
		
		
		
		
		
		“민사소송 등에서의 전자문서 이용 등에 관한 규칙” 제7조, 제8조, 제11조, 제19조, 제25조, 제41조에
		
		의거하여 첨부파일의 내용과 같이 공고합니다. 상세한 내용은 첨부파일을 참고하시기 바랍니다.
		
		
		
		
		
		
		
		법 원 행 정 처 장',
		SYSDATE,
		0
);

-- 공지사항 4
INSERT INTO BR_Announcement VALUES (
		BR_Announcement_seq.nextval,
		1,
		'홈페이지 서비스 순단 안내[3. 31.(목) 23:30 ~ 4. 1.(금) 04:00]',
		'대한민국 법원 전자소송 홈페이지의 이용 제한과 관련한 안내 말씀드립니다.



		보다 안정적인 서비스를 제공하기 위해 시스템에 대한 점검 작업을 진행할 예정입니다.
		
		점검시간 동안 전자소송 홈페이지 서비스 이용이 순단(잠시 끊김 현상) 될 수 있음을 알려드리오니 양해하여 주시기 바랍니다.
		
		
		
		
		
		                                     -   아   래   -
		
		
		
		○ 점검일시 : 2022. 3. 31.(목) 23:30 ~ 4. 1.(금) 04:00 (전자소송체험 및 모바일앱 포함)
		
		
		
		
		
		앞으로도 더욱 안정적인 서비스의 제공을 위하여 최선을 다하겠습니다.
		
		
		
		감사합니다.',
		SYSDATE,
		0
);

-- 공지사항 5
INSERT INTO BR_Announcement VALUES (
		BR_Announcement_seq.nextval,
		1,
		'SKT 휴대폰 본인확인 서비스 일시 중단 안내[2022. 4. 2.(토) 01:00~06:00]',
		'안녕하십니까?

		대한민국 법원 전자소송 홈페이지의 이용 제한과 관련한 안내 말씀드립니다.
		
		SKT의 시스템 작업으로 인해 휴대폰 본인확인 서비스 이용이 중단될 예정입니다.
		
		아래와 같이 SKT 휴대폰 본인확인 서비스(알뜰폰 포함)가 중단될 예정이오니 양해하여 주시기 바랍니다.
		
		 
		                            -  아      래   -
		 
		1. 작업일시
		  - 2022년 4월 2일(토) 01:00 ~ 06:00
		
		2. 작업내용
		  -  SKT 휴대폰 본인확인 서비스 시스템 개선작업
		
		3. 영향범위
		  - 작업시간 동안 SKT 본인확인, 알뜰폰 본인확인 중단
		
		
		앞으로도 더욱 편리하고 안정적인 서비스의 제공을 위하여 최선을 다하겠습니다.
		
		감사합니다.',
		SYSDATE,
		0
);

-- 31. 공지사항 첨부파일
DROP TABLE BR_Anncm_Files;
CREATE TABLE BR_Anncm_Files (
		anncm_files_no NUMBER,
		anncm_no NUMBER,
		anncm_files_url VARCHAR2(300),
		anncm_original_filename VARCHAR2(400)
);

DROP SEQUENCE BR_Anncm_Files_seq;
CREATE SEQUENCE BR_Anncm_Files_seq;



--------------------------------------------------------------------- insert query ----------------------------------------

INSERT INTO Barom_findQuestion VALUES (Barom_findQuestion_sequence.nextval, '자신의 보물 제 1호는?');
INSERT INTO Barom_findQuestion VALUES (Barom_findQuestion_sequence.nextval, '자신이 졸업한 초등학교 이름은?');
INSERT INTO Barom_findQuestion VALUES (Barom_findQuestion_sequence.nextval, '자신의 좌우명은?');

INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '가등기말소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '강제집행에 관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '건물');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '건물등철거');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '건물인도');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '건축에관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '계금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '공사대금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '공유물분할');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '공탁금 출급청구권 확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '관리비');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '광고대금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '구상금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '근로에관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '근저당권말소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '기타(금전)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '대여금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '매매대금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '매매대금반환');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '면책확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '무역에관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '물품대금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '미곡');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '배당이의');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '보증금반환');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '보증채무금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '보험금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '보험에관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '부당이득금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '사용료');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '사해행위취소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '선박');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '소유권말소등기');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '소유권이전등기');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '소유권이전등록');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '소유권확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손실보상금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(건)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(국)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(기)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(산)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(언)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(의)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(자)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(저)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(지)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(해)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '손해배상(환)');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '수표,어음금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '수표금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '시효중단을 위한 재판상 청구 확인의 소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '신용카드이용대금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '약정금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '양수금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '어음금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '예금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '용역비');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '운송료');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '위자료');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '유익비');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '유체동산인도');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '유치권 부존재 확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '임금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '임대차보증금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '입목');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '저당권설정등기');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '전부금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '제3자이의');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '증권');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '증권관련집단소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '집행문부여에 대한 이의의 소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '집행문부여의 소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '집행판결');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '채권조사확정재판에 대한 이의의 소');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '채무부존재확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '청구이의');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '추심금');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '토지');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '토지인도');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '해고무효확인');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '회사에 관한 소송');
INSERT INTO BR_Min_Sj_Sgn_Category VALUES(BR_Min_Sj_Sgn_Category_seq.nextval, '기타');

INSERT INTO BR_Min_Sj_Court_Category VALUES(BR_Min_Sj_Court_Category_seq.nextval, '서울중앙지방법원');
INSERT INTO BR_Min_Sj_Court_Category VALUES(BR_Min_Sj_Court_Category_seq.nextval, '서울동부지방법원');
INSERT INTO BR_Min_Sj_Court_Category VALUES(BR_Min_Sj_Court_Category_seq.nextval, '서울남부지방법원');
INSERT INTO BR_Min_Sj_Court_Category VALUES(BR_Min_Sj_Court_Category_seq.nextval, '서울북부지방법원');
INSERT INTO BR_Min_Sj_Court_Category VALUES(BR_Min_Sj_Court_Category_seq.nextval, '서울서부지방법원');

-- 소장승인 상황
INSERT INTO Barom_approval_status VALUES(Barom_approval_status_seq.nextval, '심사중');
INSERT INTO Barom_approval_status VALUES(Barom_approval_status_seq.nextval, '승인');
INSERT INTO Barom_approval_status VALUES(Barom_approval_status_seq.nextval, '반려');
INSERT INTO Barom_approval_status VALUES(Barom_approval_status_seq.nextval, '미제출');

-- 소장작성 상황
INSERT INTO Barom_submit_status VALUES (
	Barom_submit_status_seq.nextval,
	'임시저장'
);
INSERT INTO Barom_submit_status VALUES (
	Barom_submit_status_seq.nextval,
	'작성완료'
);
INSERT INTO Barom_submit_status VALUES (
	Barom_submit_status_seq.nextval,
	'결제대기'
);
DELETE FROM Barom_submit_status WHERE status_no = 4;


-- 배당사건 상황 

INSERT INTO BR_Case_confirmed_Status VALUES (
	BR_Case_confirmed_Status_seq.nextval,
	'소송취하'
);
INSERT INTO BR_Case_confirmed_Status VALUES (
	BR_Case_confirmed_Status_seq.nextval,
	'소송합의'
);
INSERT INTO BR_Case_confirmed_Status VALUES (
	BR_Case_confirmed_Status_seq.nextval,
	'답변서 미작성'
);
INSERT INTO BR_Case_confirmed_Status VALUES (
	BR_Case_confirmed_Status_seq.nextval,
	'재판중'
);
INSERT INTO BR_Case_confirmed_Status VALUES (
	BR_Case_confirmed_Status_seq.nextval,
	'재판완료'
);

-- 관리자 등록
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	0,
	1,
	'adminsite01',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	0,
	2,
	'adminstaff01',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	1,
	3,
	'admincourt01',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	2,
	3,
	'admincourt02',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	3,
	3,
	'admincourt03',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	4,
	3,
	'admincourt04',
	'1234'
);
INSERT INTO Barom_admin VALUES (
	Barom_admin_seq.nextval,
	5,
	3,
	'admincourt05',
	'1234'
);

-- 관리자 카테고리
INSERT INTO admin_category VALUES (
	admin_category_seq.nextval,
	'사이트 관리자'
);
INSERT INTO admin_category VALUES (
	admin_category_seq.nextval,
	'사이트 행정직'
);
INSERT INTO admin_category VALUES (
	admin_category_seq.nextval,
	'법원 행정직'
);


-- 자주하는 질문 카테고리
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '기록열람');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '발급');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '사용자유형');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '소송비용납부');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '소송비용환급');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '인증서');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '전자소송일반');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '전자송달');
INSERT INTO BR_FAQ_Category VALUES(BR_FAQ_Category_seq.nextval, '전자제출');




-- 0412 법원 5개 / 소장 제출 상황 순서 수정