<%@page import="java.net.URLEncoder"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String saveDirectory = application.getRealPath("/upload");// 실제 파일이 저장된 경로
String saveFilename = request.getParameter("sName");
String pre_originalFilename = request.getParameter("oName");
String originalFilename = URLEncoder.encode(pre_originalFilename, "UTF-8");

try{
	//파일 찾아 입력 스트립 생성
	File file = new File(saveDirectory, saveFilename);// 경로와 서버의 파일명으로 File객체 생성
	InputStream inStream = new FileInputStream(file);//입력스트립 객체 생성
	
	//한글 파일명 깨짐 방지
	String client =request.getHeader("User-Agent"); // 사용자의 브라우저 정보
	if(client.indexOf("WOW64") == -1){// WOW64 문자열이 포함 안된 경우 -> IE제외 브라우저
		originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
	}else{//포함된 경우-> IE
		originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
	}
	
	//파일 다운로드용 응답 헤더 설정// 브라우저 헤더 정보 저장 by minguT
	response.reset();
	response.setContentType("application/octet-stream");
	response.setHeader("content-Disposition", "attachment; filename=\"" + originalFilename + "\"");
	response.setHeader("Content-Length", "" + file.length());//파일의 용량
	
	//출력 스트림 초기화
	out.clear();
	
	//response 내장 객체로부터 새로운 출력 스트림 생성
	OutputStream outStream = response.getOutputStream();
	
	byte b[] = new byte[(int)file.length()];
	int readBuffer =0;
	while((readBuffer = inStream.read(b)) >0){
		outStream.write(b, 0, readBuffer);
	}
	
	inStream.close();
	outStream.close();

}
catch(FileNotFoundException e){
	System.out.println(e.toString());
}
catch(Exception e){
	System.out.println(e.toString());
}

%>
