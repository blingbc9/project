package kr.co.project.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.project.board.BoardMapper;
import kr.co.project.board.BoardVO;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/servlet-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	
	//@Test
	public void testObj() {
		BoardVO vo = new BoardVO();
		vo.setTitle("게시물 제목");
		vo.setContent("게시물 내용");
		int r = 0;
		for(int i=0; i<20; i++) {
			r+= mapper.insert(vo);
		}
		log.info("등록갯수 : "+ r);
	}
	
	//@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test 1");
		vo.setContent("blah blah blah");
		
		int result = mapper.insert(vo);
		
		log.info(vo);
		log.info("등록갯수 : "+ result);
	}
	
	//@Test
//	public void count() {
//		Map map = new HashMap();
//		map.put("stype", "title");
//		map.put("sword", "test");
//		int totalCount = mapper.count(map);
//		System.out.println("총카운트 : "+ totalCount);
//	}
	
	//@Test
//	public void list() {
//		Map map = new HashMap();
//		map.put("startIdx", 10);
//		map.put("pageRow", 10);
//		map.put("stype", "content");
//		map.put("sword", "게");
//		List<BoardVO> list = mapper.list(map);
//		list.forEach(vo->log.info(vo));
//		//log.info(list);
//	}
	
	//@Test
	public void view() {
		
		log.info(mapper.view(10));
	}
	
	//@Test
	public void viewcount() {
		mapper.updateViewcount(1);
		
		log.info(mapper.view(1));
	}
	
	//@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setNo(1);
		vo.setTitle("modify test");
		vo.setContent("modify test");
		
		log.info("update : " + mapper.update(vo));
	}
	
	//@Test
	public void delete() {
			
		log.info("delete : " + mapper.delete(33));
	}
	
	
	
	/*
	 * @Test public void register() { vo.setEmail("test@test.com");
	 * vo.setPwd("pwdaaa"); vo.setName("test"); vo.setGender(1); vo.setBirth(19019);
	 * vo.setPhone(010010010); mapper.insert1(vo); }
	 */
	
	
	
	
	
	
	
	
	
	
}
