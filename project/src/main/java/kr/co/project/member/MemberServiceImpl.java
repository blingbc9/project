package kr.co.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.SendMail;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public int insert(MemberVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int emailDupCheck(String email) {
		return mapper.emailDupCheck(email);
	}

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession sess) {
		boolean r= false;
		MemberVO loginInfo = mapper.loginCheck(vo);
		if(loginInfo != null) {
			r = true;
			//로그인 성공시 세션에 저장
			sess.setAttribute("loginInfo", loginInfo);
			
		}
		return r;
		//마이 바티스에서 select가 안된면 아예 객체 생성을 안하기 때문에 null이 반환된다
		//세션 객체는 request에 있다, tomcat에서 이미 session을 생성해 논다
	}

	@Override
	public MemberVO findEmail(MemberVO vo) {
		
		return mapper.findEmail(vo);
	}

	@Override
	public MemberVO findPwd(MemberVO vo) {
		
		// update
		MemberVO mv = mapper.findEmail(vo);
		if(mv != null) {
			//임시 비밀번호
			//영문 2자리, 숫자 2자리
			String temp = "";
			for(int i=0; i<2; i++) {
				temp += (char)(Math.random()*26+65);
			}
			for(int i=0; i<2; i++) {
				temp += (int)(Math.random()*9);
			}
			
			
			//임시 비밀번호 update
			vo.setPwd(temp);
			int r =mapper.updateTempPwd(vo);
			if(r==1) {				
			System.out.println("비밀번호 업데이트 성공");
			}
			
			// email 발송
			SendMail.sendMail("qlc9@naver.com", vo.getEmail(), "[더조은]임시비밀번호", "임시 비밀번호 : "+ temp );
			
			return mv;
		}else {
			return null;
		}
		
		
	}
	
	

}
