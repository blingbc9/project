package kr.co.project.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BoardMapper {
	
	public int insert(BoardVO vo);
	
	public int count(BoardVO vo);
	
	public List<BoardVO> list(BoardVO vo);
	
	public BoardVO view(int no);

	public void updateViewcount(int no);
	
	public int update (BoardVO vo);
	
	public int delete (int no);
	
	
}
