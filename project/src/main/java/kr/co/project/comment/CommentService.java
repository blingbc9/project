package kr.co.project.comment;

import java.util.Map;

public interface CommentService {
	//목록
	Map index(CommentVO vo);
	//등록
	int insert(CommentVO vo);
	//삭제
	int delete(CommentVO vo);
}
