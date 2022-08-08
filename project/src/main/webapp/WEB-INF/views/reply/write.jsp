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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <script src="/smarteditor/js/HuskyEZCreator.js"></script>
    <script src="/js/function.js"></script>
    <script type="text/javascript">
    function goSave(){
    	editor.getById['content'].exec('UPDATE_CONTENTS_FIELD',[])//jindo�����ӿ�ũ ���� �Լ�
    	frm.submit();
    }
    
    var editor;
    $(function(){ //ȭ�� �ε�� �ٷ� ����
    	editor = setEditor('content');
    })
    
    </script>
</head>
<body>
    
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">�Խ���</h3>
    
                <div class="bbs">
                	<form method="post" name="frm" id="frm" action="insert.do" enctype="multipart/form-data" > <!-- enctype="multipart/form-data" -->
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
	                                <textarea name="content" id="content" style="width:90%"></textarea>
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