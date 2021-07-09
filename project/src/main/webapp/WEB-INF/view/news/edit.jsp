<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
    <meta name="format-detection" content="telephone=no, address=no, email=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <jsp:include page="../include/head.jsp"/>
    <title>게시판 등록</title>
    <script type="text/javascript">
    	function goSave() {
			$("#frm").submit();
		}
    </script>
</head>
<body>
    <div class="wrap">
       <jsp:include page="../include/header.jsp"/>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
    
                <div class="bbs">
                <form method="post" name="frm" id="frm" action="update.do" enctype="multipart/form-data" ><!-- 파일전송하려면 이폼이 꼭필요 method="post" enctype="multipart/form-data" -->
                    <table class="board_write">
                        <tbody>
                        <tr>
                            <th>제목</th>
                            <td>
                                <input type="text" name="title" id="title" class="wid100" value="${vo.title }"/>
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td>
                            
                            
                                <textarea name="content" id="content">${vo.content}</textarea>
                            </td>
                        </tr>
                        <tr>
                        	<th>파일첨부</th>
                        	<td>
                        		기존파일 : ${vo.filename_org } <input type="checkbox" name="isDel" value="1"><br>
                        		<input type="file" name="filename" id="filename">
                        	</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btnSet"  style="text-align:right;">
                        <a class="btn" href="javascript:goSave();">저장 </a>
                    </div>
                    <input type="hidden" name=no value="${vo.no }"><!-- 수정폼에 no 숨겨서 넘기기 -->
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="../include/footer.jsp"/>
       	<jsp:include page="../include/quick.jsp"/>
    </div>
</body>
</html>