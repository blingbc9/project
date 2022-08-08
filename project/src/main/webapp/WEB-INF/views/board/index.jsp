<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>게시판목록</title>
    <link rel="stylesheet" href="/css/reset.css"/>
    <link rel="stylesheet" href="/css/contents.css"/>
</head>

	<script type="text/javascript">
		function goWrite(){
			<c:if test="${empty loginInfo}">
				alert("로그인 후 작성 가능합니다.(목록에서)");
			</c:if>
			<c:if test="${!empty loginInfo}">
				location.href="write.do";
			</c:if>
		}		
	
	
	</script>

<body>
    
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
                <p class="sub_title">로그인 정보 : ${loginInfo.email }님 안녕하세요</p>
    
                <div class="bbs">
                    <table class="list">
                    <p><span><strong>총 ${data.totalCount}개</strong>  |  ${boardVO.page}/${data.totalPage}페이지</span></p>
                        <caption>게시판 목록</caption>
                        <colgroup>
                            <col width="80px" />
                            <col width="*" />
                            <col width="100px" />
                            <col width="100px" />
                            <col width="200px" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>조회수</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
							
							<c:if test="${empty data.list}">
	                            <tr>
	                                <td class="first" colspan="5">등록된 글이 없습니다.</td>
	                            </tr>
							</c:if>
							
								
							<c:forEach items="${data.list}" var="row" varStatus="loop">
	                            <tr><!-- 글번호 총갯수 - 인덱스 -(현재페이지 번호 - 1)*페이지당 갯수///다시보자-->
	                                <td>${data.totalCount - loop.index -(boardVO.page-1)*boardVO.pageRow}</td>
	                                
	                                <td class="txt_l">
	                                   <a href="view.do?no=${row.no} ">${row.title} [${row.comment_count }]</a>
	                                </td>
	                                
	                                <td>
	                                    ${row.viewcount}
	                                </td>
	                                <td class="writer">
	                                    ${row.member_name}
	                                </td>
	                                <td class="date"><fmt:formatDate value="${row.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td><!-- 시간 포멧 -->
	                            </tr>
							</c:forEach>
					
							
						
                        </tbody>
                    </table>
                    <!-- 로그인한 사람만 글쓰기 버튼을 눌를 수 있도록 -->
                    
                    <div class="btnSet"  style="text-align:right;">
	                  
	                        <a class="btn" href="javaScript:goWrite();">글작성 </a>
	                 
                    </div>
                     <div class="pagenate clear">
		               <ul class='paging'>
			               <c:if test="${data.prev ==true }">
			               		<li><a href ="index.do?page=${data.startPage-1}&stype=${param.stype}&sword=${param.sword}"><</a>
			               </c:if>
			               
			               	<c:forEach var="page" begin="${data.startPage}" end="${data.endPage}">
			               		<li><a href ='index.do?page=${page}&stype=${param.stype}&sword=${param.sword}' <c:if test="${boardVO.page == page}">class='current'</c:if>>${page}</a></li></a>
			               	</c:forEach>
			               	
			               	<c:if test="${data.next ==true }">
			               		<li><a href = "index.do?page=${data.endPage+1}&stype=${param.stype}&sword=${param.sword}">></a></li>
			               	</c:if>
		               </ul>
		            </div>
                
                    <!-- 페이지처리 -->
                    
                    <div class="bbsSearch">
                        <form method="get" name="searchForm" id="searchForm" action="">
                            <span class="srchSelect">
                                <select id="stype" name="stype" class="dSelect" title="검색분류 선택">
                                    <option value="all">전체</option>
                                    <option value="title">제목</option>
                                    <option value="content">내용</option>
                                </select>
                            </span>
                            <span class="searchWord">
                                <input type="text" id="sval" name="sword" value="${param.sword }"  title="검색어 입력">
                                <input type="button" id="" value="검색" title="검색">
                                
                                
                            </span>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
        
</body>
</html>