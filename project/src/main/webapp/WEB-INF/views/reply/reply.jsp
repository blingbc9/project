<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>�Խ��� ���</title>
    <link rel="stylesheet" href="/css/reset.css"/>
    <link rel="stylesheet" href="/css/contents.css"/>
    
    <script type="text/javascript">
    function goSave(){
    	frm.submit();
    }
    
    </script>
</head>
<body>
    
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">�Խ���</h3>
    
                <div class="bbs">
                	<form method="post" name="frm" id="frm" action="reply.do" enctype="multipart/form-data" > <!-- enctype="multipart/form-data" -->
                	<input type="hidden" name="gno" value="${data.gno }">
                	<input type="hidden" name="ono" value="${data.ono }">
                	<input type="hidden" name="nested" value="${data.nested }">
	                   <%--  <input type="hidden" name = "memberno" value="${loginInfo.no }"/> --%>
	                    <table class="board_write">
	                        <tbody>
	                        <tr>
	                            <th>����</th>
	                            <td>
	                                <input type="text" name="title" id="title" class="wid100" value=""/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>����</th>
	                            <td>
	                                <textarea name="content" id="content"></textarea>
	                            </td>
	                        </tr>
	                        <tr>
	                        	<th>÷������</th>
	                        	<td>
	                        		<input type="file" name="filename">
	                        	</td>
	                        </tr>
	                        </tbody>
	                    </table>
	                    
	                    <div class="btnSet"  style="text-align:right;">
	                        <a class="btn" href="javascript:goSave();">���� </a>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
        
</body>
</html>