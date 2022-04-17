package com.ja.barom.pay.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.DocumentPayVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.document.service.DocumentService;
import com.ja.barom.user.service.UserService;

@RestController
@RequestMapping("/pay/*")
public class RestPayController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("kakaopay")
	public String kakaopay(String case_no, HttpSession session) {
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		CaseVo caseInfo = documentService.getCaseByCaseNo(case_no);
		CaseBasicInfoVo caseBasicInfo = documentService.getCaseBasicInfo(case_no);
		
		String user_id = sessionUser.getUser_id();
		String sgnCategoryName = documentService.getSgnCateoryName(caseBasicInfo.getMin_sj_sgn_category_no());
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String strNowDate = simpleDateFormat.format(nowDate);
		String item_name = "[" + strNowDate + "]_" + user_id + "의" + sgnCategoryName + "소장";
		int total_amount = caseBasicInfo.getCaseBasicInfo_price();
		
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			
			try {
				HttpURLConnection connection = (HttpURLConnection) address.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Authorization", "KakaoAK 81a7d42fa650168b892271e581a16ea4");
				connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
				connection.setDoOutput(true);
				// 로컬 설정
				// String parameter = "cid=TC0ONETIME" // 테스트 결제코드
				// 		+ "&partner_order_id=" + case_no // 가맹점 주문번호
				// 		+ "&partner_user_id=partner_user_id" + user_id // 가맹점 회원 id
				// 		+ "&item_name=" + item_name  // 상품명
				// 		+ "&quantity=1" // 상품 수량
				// 		+ "&total_amount=" + total_amount// 총 금액
				// 		+ "&vat_amount=0"  // 부가세
				// 		+ "&tax_free_amount=0" // 상품 비과세 금액
				// 		+ "&approval_url=http://localhost:8181/document/uploadConf?payResult=1" // 결제 성공 시
				// 		+ "&fail_url=http://localhost:8181/document/uploadConf?payResult=2" // 결제 실패 시
				// 		+ "&cancel_url=http://localhost:8181/document/uploadConf?payResult=3"; // 결제 취소 시
				// 서버 설정
				String parameter = "cid=TC0ONETIME" // 테스트 결제코드
						+ "&partner_order_id=" + case_no // 가맹점 주문번호
						+ "&partner_user_id=partner_user_id" + user_id // 가맹점 회원 id
						+ "&item_name=" + item_name  // 상품명
						+ "&quantity=1" // 상품 수량
						+ "&total_amount=" + total_amount// 총 금액
						+ "&vat_amount=0"  // 부가세
						+ "&tax_free_amount=0" // 상품 비과세 금액
						+ "&approval_url=http://barom.s001lec.com:8080/document/uploadConf?payResult=1" // 결제 성공 시
						+ "&fail_url=http://barom.s001lec.com:8080/document/uploadConf?payResult=2" // 결제 실패 시
						+ "&cancel_url=http://barom.s001lec.com:8080/document/uploadConf?payResult=3"; // 결제 취소 시
				
				OutputStream send = connection.getOutputStream();
				DataOutputStream dataSend = new DataOutputStream(send);
				dataSend.writeBytes(parameter);
				dataSend.close();
				
				int result = connection.getResponseCode();
				InputStream receive;
				
				if(result == 200) {
					receive = connection.getInputStream();
				} else {
					receive = connection.getErrorStream();
				}
				
				InputStreamReader read = new InputStreamReader(receive);
				BufferedReader change = new BufferedReader(read);
				
				DocumentPayVo documentPayVo = new DocumentPayVo();
				documentPayVo.setCase_no(case_no);
				documentPayVo.setPay_name(item_name);
				documentPayVo.setPay_user_id(user_id);
				documentPayVo.setPay_method("kakaopay");
				documentPayVo.setPay_price(total_amount);
				documentService.insertDocumentPayInfo(documentPayVo);
				
				return change.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}

}
