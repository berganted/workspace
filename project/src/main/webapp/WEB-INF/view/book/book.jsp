<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>책 검색 사이트</title>
</head>
 
<body>
 
    <input type="text" id="query">
 	페이지수<input type="text" id="pageNum" value="1">
    <button id="search">검색</button>
    <div></div>
 
    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
 
    <script>
        $(document).ready(function () {
            var pageNum = 1;
           
            $("#search").click(function () {
                $("div").html("");
                
 
                $.ajax({
                    method: "GET",
                    url: "https://dapi.kakao.com/v3/search/book?target=title&size=10",
                    data: { query: $("#query").val(), page: $('#pageNum').val()},
                    headers: {Authorization: "KakaoAK e06289fd4e96bff3cbd031fe234ba23e"} // ########부분에 본인의 REST API 키를 넣어주세요.
 
                })
                .done(function (msg) {
                    console.log(msg);
                    for (var i = 0; i < 10; i++){
                        $("<form action='bookapi.do' method='post'><div><span>제목</span><span><input type='text' id='title' name='title'value='"+ msg.documents[i].title  + "'></span>"
                        +"<span>저자</span><span><input type='text' id='authors'name='authors'value='"+ msg.documents[i].authors  + "'></span>"
                        +"<span>출판사</span><span><input type='text' id='publisher'name='publisher'value='"+ msg.documents[i].publisher  + "'></span>"
                        +"<span>요약</span><span><input type='text' id='contents'name='contents'value='"+ msg.documents[i].contents +"..." + "'></span>"
                        +"<span>isbn</span><span><input type='text' id='isbn'name='isbn'value='"+ msg.documents[i].isbn + "'></span>"
                        +"<span>출판일</span><span><input type='text' id='datetime'name='datetime'value='"+ msg.documents[i].datetime + "'></span>"
                        +"<span>가격</span><span><input type='text' id='price'name='price'value='"+ msg.documents[i].price + "'></span>"
                        +"<span>이미지 url</span><span><input type='text' id='thumbnail'name='thumbnail'value='"+ msg.documents[i].thumbnail  + "'></span>"
                        +"<span><input type='submit' value='저장'></span></div></form>").appendTo('.c');
                    }
                });
            })
 
           
        })
 		 function gosubmit() {
				var gsWin = window.open("about:blank","winName")
				var frm = document.form;
				frm.action = "http://localhost:8080/project/book/bookapi.do";
				frm.target="winName";
				frm.submit();
			}
        
    </script>
    <div class="c"></div>
</body>
 
</html>