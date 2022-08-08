package kr.co.project.news;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class NewsVO {
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;//util
	private int viewcount;
	private int memberno;
	private String filename_org;
	private String filename_real;
	
	//페이지 및 검색
	private int page;
	private String stype;
	private String sword;
	
	private int startIdx;
	private int pageRow;
	
	private String tableName;
	
	public NewsVO() {
//		this.page = 1;
//		this.pageRow = 10;
		this(1, 10);
	}
	
	public NewsVO(int page, int pageRow) {
		this.page = page;
		this.pageRow = pageRow;
		this.tableName= "news";
	}
	
	
	

}
