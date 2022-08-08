package kr.co.project.reply;

import java.util.Map;

public interface ReplyService {
	//목록
	Map index (ReplyVO vo);
	
	//상세
	ReplyVO view(int no);
	
	//수정폼 > 수정될 내용을 가져와야함, 
	ReplyVO edit(int no);
	
	//수정 처리 > 
	boolean update(ReplyVO vo);
	
	//삭제 처리
	boolean delete(int no);
	
	//등록 처리
	boolean insert(ReplyVO vo);
	
	//답변등록
	boolean reply(ReplyVO vo);
	
}
