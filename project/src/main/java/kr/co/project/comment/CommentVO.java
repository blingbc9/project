package kr.co.project.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//or @Data
public class CommentVO {
	private int no;
	private String content;
	private int memberno;//작성자
	private int board_no;
	private Timestamp regdate;
	private String table_name;
	
	private String member_name;//회원명 추가
	
	//페이징
	private int startIdx; //페이지의 row시작 번호
	private int pageRow; //페이지당 row갯수 //기본 10의로 설정
	private int page;
	
	
	
	public CommentVO() {
		this.pageRow = 10; //기본 10의로 설정
		this.page = 1;
		
	}
	

}
