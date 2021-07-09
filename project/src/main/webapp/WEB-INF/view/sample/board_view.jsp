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
    <jsp:include page="../include/head.jsp"/>
    <title>게시판 상세</title>
    
</head>
<body>
    <div class="wrap">
       <jsp:include page="../include/header.jsp"></jsp:include>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
                <div class="bbs">
                    <div class="view">
                        <div class="title">
                            <dl>
                                <dt>게시글 제목 </dt>
                                <dd class="date">작성일 : 2021-01-01 17:51:58.0 </dd>
                            </dl>
                        </div>
                        <div class="cont"><p>게시판 내용</p> </div>
                        <dl class="file">
                            <dt>첨부파일 </dt>
                            <dd>
                            <a href="#" 
                            target="_blank">첨부파일.pptx [38.07KB] </a></dd>
                        </dl>
                                    
                        <div class="btnSet clear">
                            <div class="fl_l"><a href="board_list.html" class="btn">목록으로</a></div>
                        </div>
                
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../include/footer.jsp"></jsp:include>
       	<jsp:include page="../include/quick.jsp"></jsp:include>
    </div>
</body>
</html>