package kr.co.project.news;

import java.util.Map;

public interface NewsService {
	//목록
	Map index (NewsVO vo);
	
	//상세
	NewsVO view(int no);
	
	//수정폼 > 수정될 내용을 가져와야함, 
	NewsVO edit(int no);
	
	//수정 처리 > 
	boolean update(NewsVO vo);
	
	//삭제 처리
	boolean delete(int no);
	
	//등록 처리
	boolean insert(NewsVO vo);
	
}
