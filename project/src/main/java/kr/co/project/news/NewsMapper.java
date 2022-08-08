package kr.co.project.news;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NewsMapper {
	
	public int insert(NewsVO vo);
	
	public int count(NewsVO vo);
	
	public List<NewsVO> list(NewsVO vo);
	
	public NewsVO view(int no);

	public void updateViewcount(int no);
	
	public int update (NewsVO vo);
	
	public int delete (int no);
	
	
}
