package kr.co.project.reply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public int count(ReplyVO vo);
	
	public List<ReplyVO> list(ReplyVO vo);
	
	public ReplyVO view(int no);

	public void updateViewcount(int no);
	
	public int reply (ReplyVO vo);
	
	public int update (ReplyVO vo);

	public int onoUpdate (ReplyVO vo);
	
	public int gnoUpdate (int gno);
	
	public int delete (int no);
	
	
	
	
}
