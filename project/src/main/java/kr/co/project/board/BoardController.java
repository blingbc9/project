package kr.co.project.board;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.project.comment.CommentService;
import kr.co.project.comment.CommentVO;
import kr.co.project.member.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@Autowired
	CommentService cService;
	
	@GetMapping("/board/index.do")
	public String index(Model model, BoardVO vo) {
		model.addAttribute("data", service.index(vo));
		return "board/index";//검색...포함?
	}
	
	@GetMapping("/board/write.do")
	public String write() {
		//로그인세션이 없으면 들어갈 수 없도록 처리
		
		return"/board/write";
	}
	
	@PostMapping("/board/insert.do")
	public String insert(BoardVO vo, Model model, @RequestParam MultipartFile filename, HttpServletRequest req ) {
		//첨부파일 처뤼, 객체 안에 이름에서 확장자를 자르고, 임의의 날짜와 lastindex로 확장자와 결합하여 저장, filename_org, filename_real로 vo에 저장
		if(!filename.isEmpty()) {//filename이 비어있는지 확인
			//파일명 구하기
			String org= filename.getOriginalFilename();//사용자가 첨부한 원본 파일명을 가져옴
			String ext = org.substring(org.lastIndexOf("."));//확장자
			String real = new Date().getTime()+ext;//변경된 filename "1314131"+".확장자명"

			//파일저장
			String path	= req.getRealPath("/upload/");//경로불러오기
			try {
				
				filename.transferTo(new File(path+real));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("업로드 중 예외 발생");
			}
			vo.setFilename_org(org);
			vo.setFilename_real(real);
		}
		
		
		//memberno 저장
		HttpSession sess = req.getSession();
		MemberVO mv = (MemberVO)sess.getAttribute("loginInfo");
		vo.setMemberno(mv.getNo());
		
		if(service.insert(vo)) {
			model.addAttribute("msg", "정상적으로 저장되었습니다");
			model.addAttribute("url", "index.do");
			return "common/alert";
		}else {
			model.addAttribute("msg", "저장 실패하였습니다.");
			return "common/alert";
		}
		
	}
	
	
	@GetMapping("/board/view.do")
	public String view(BoardVO vo, Model model ) {
		BoardVO data = service.view(vo.getNo());
		model.addAttribute("data", data);
		
		return "board/view";
		
	}
	
	
	@GetMapping("/board/edit.do")
	public String edit(BoardVO vo, Model model) {
		BoardVO data = service.edit(vo.getNo());
		model.addAttribute("data", data);
		return "board/edit";
		

	}
	
	 @PostMapping("/board/update.do")	
	 public String update(BoardVO vo, Model model) {
		 if(service.update(vo)) {
			 model.addAttribute("msg","정상적으로 수정되었습니다");
			 model.addAttribute("url","view.do?no="+vo.getNo());
			 return"common/alert";
		 }else {
			 model.addAttribute("msg","수정 실패");
			 return"common/alert";
		 }
	 }
	 
	 @GetMapping("/board/delete.do")	
	 public String delete(BoardVO vo, Model model) {
		 if(service.delete(vo.getNo())) {
			 model.addAttribute("msg","정상적으로 삭제되었습니다");
			 model.addAttribute("url","index.do");
			 return"common/alert";
		 }else {
			 model.addAttribute("msg","삭제 실패");
			 return"common/alert";
		 }
	 }
	
	
}
