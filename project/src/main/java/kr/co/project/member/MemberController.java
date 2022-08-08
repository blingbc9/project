package kr.co.project.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MemberController {

	@Autowired
	MemberService service;

	@GetMapping("/member/join.do")
	public String join() {
		return "/member/join";
	}

	@PostMapping("/member/join.do")
	public String join(MemberVO vo, Model model) {
		if (service.insert(vo) > 0) {
			model.addAttribute("msg", "정상적으로 가입되었습니다.");
			model.addAttribute("url", "login.do");

			return "common/alert";
		} else {
			model.addAttribute("msg", "회원가입 오류");
			return "common/alert";
		}

	}

	@GetMapping("/member/emailDupCheck.do")
	public void emailDupCheck(@RequestParam String email, HttpServletResponse res) throws Exception {
		int count = service.emailDupCheck(email);
		boolean r = false;
		if (count == 1)
			r = true;

		// ????????
		PrintWriter out = res.getWriter();
		out.print(r);
		out.flush();// ????????
	}

	@GetMapping("/member/login.do")
	public String login() {

		return "member/login";
	}

	@PostMapping("/member/login.do")
	public String login(MemberVO vo, HttpSession sess, Model model) {
		if (service.loginCheck(vo, sess)) {
			return "redirect:/board/index.do";

		} else {
			model.addAttribute("msg", "이메일 비밀번호를 확인해주세요");
			return "common/alert";
		}
	}

	@GetMapping("/member/logout.do")
	public String logout(Model model, HttpServletRequest req) {
		// session은 httpsession으로도 그리고 httpsevletRequest로도 받을 수 있다
		HttpSession sess = req.getSession();
		sess.invalidate();// 세션 초기화 함수(세션 객체에 있는 모든 값들이 삭제)
		// sess.removeAttribute("loginInfo");//세션 객체의 해당 값만 삭제//세션은 서버 메모리에 저장된다. 서버비용
		// 낭비 감소를 위해 줄인다

		model.addAttribute("msg", "LOGOUT");
		model.addAttribute("url", "/board/index.do");
		return "common/alert";

	}

	// 이메일 찾기
	@GetMapping("/member/findEmail.do")
	public String findEmail() {
		return "member/findEmail";
	}

	// 이메일 찾기
	@PostMapping("/member/findEmail.do")
	public String findEmail(Model model, MemberVO param) {

		MemberVO vo = service.findEmail(param);
		if (vo != null) {
			model.addAttribute("result", vo.getEmail());
		}

		return "common/return";
	}

	// 비밀번호 찾기
	@GetMapping("/member/findPwd.do")
	public String findPwd() {
		return "member/findPwd";
	}

	// 비밀번호 찾기
	@PostMapping("/member/findPwd.do")
	public String findPwd(Model model, MemberVO param) {

		MemberVO vo = service.findPwd(param);
		if (vo != null) {
			model.addAttribute("result", vo.getEmail());
		}

		return "common/return";
	}

}
