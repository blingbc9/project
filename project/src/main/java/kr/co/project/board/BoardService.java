package kr.co.project.board;

import java.util.Map;

public interface BoardService {
	//목록
	Map index (BoardVO vo);
	
	//상세
	BoardVO view(int no);
	
	//수정폼 > 수정될 내용을 가져와야함, 
	BoardVO edit(int no);
	
	//수정 처리 > 
	boolean update(BoardVO vo);
	
	//삭제 처리
	boolean delete(int no);
	
	//등록 처리
	boolean insert(BoardVO vo);
	
}
