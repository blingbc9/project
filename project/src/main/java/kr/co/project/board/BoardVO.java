package kr.co.project.board;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;//util
	private int viewcount;
	private int memberno;
	private String filename_org;
	private String filename_real;
	
	private String member_name;
	private int comment_count;
	
	//페이지 및 검색
	private int page;
	private String stype;
	private String sword;
	
	private int startIdx;
	private int pageRow;
	
	public BoardVO() {
//		this.page = 1;
//		this.pageRow = 10;
		this(1, 10);
	}
	
	public BoardVO(int page, int pageRow) {
		this.page = page;
		this.pageRow = pageRow;
	}
	
	
	

}
