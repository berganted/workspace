<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>로그인</title>
</head>
<script type="text/javascript">
function loginCheck() {
	if($('#id').val().trim() == '' ){
		alert('아이디를 입력해주세요');
		$('#id').focus();
		return false;
	};
	if($('#pwd').val().trim() == ''){
		alert('비밀번호를 입력해주세요');
		$('#pwd').focus();
		return false;
	}
};
$(function(){
		var cookie_user_id = getLogin();
		if(cookie_user_id != "") {
			$("#id").val(cookie_user_id);
			$("#reg1").attr("checked", true);
		};
	// 아이디 저장 체크시
		$("#reg1").on("click", function(){
				var _this = this;
				var isRemember;
			if($(_this).is(":checked")) {
				isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
				if(!isRemember) $(_this).attr("checked", false);
		}
	});
	// 로그인 버튼 클릭시
		$("#btn_login").on("click", function(){
			
			if($("#reg1").is(":checked")){ // 저장 체크시
				saveLogin($("#id").val());
			}else{ // 체크 해제시는 공백
				saveLogin("");
				}
			});
		});
	/**
	* saveLogin
	* 로그인 정보 저장
	* @param id
	*/
	function saveLogin(id) {
		if(id != "") {
	// userid 쿠키에 id 값을 7일간 저장
			setSave("userid", id, 7);
		}else{
	// userid 쿠키 삭제
			setSave("userid", id, -1);
		}
	}
	/**
	* setSave
	* Cookie에 user_id를 저장
	* @param name
	* @param value
	* @param expiredays
	*/
	function setSave(name, value, expiredays) {
		var today = new Date();
		today.setDate( today.getDate() + expiredays );
		document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + today.toGMTString() + ";"
	}
	/**
	* getLogin
	* 쿠키값을 가져온다.
	* @returns {String}
	*/
	function getLogin() {
	// userid 쿠키에서 id 값을 가져온다.
		var cook = document.cookie + ";";
		var idx = cook.indexOf("userid", 0);
		var val = "";
		if(idx != -1) {
			cook = cook.substring(idx, cook.length);
			begin = cook.indexOf("=", 0) + 1;
			end = cook.indexOf(";", begin);
			val = unescape(cook.substring(begin, end));
		}
	return val;
	}
</script>

<body>
    <div class="wrap">
        <jsp:include page="../include/header.jsp" flush="true"/> 
        <form action="/project/user/login.do" method="post" id="board1" name="board1" onsubmit="return loginCheck();"><!-- header에서 id="board"이미 사용중이라서 board2로 함 -->
            <div class="sub">
                <div class="size">
                    <h3 class="sub_title">로그인</h3>
                    
                    <div class="member">
                        <div class="box">
                            <fieldset class="login_form">
                                <ul>
                                    <li><input type="text" id="id" name="id" placeholder="아이디" value="${userVo.id }"></li>
                                    <li><input type="password" id="pwd" name="pwd" placeholder="비밀번호"></li>
                                    <li><label><input type="checkbox" name="reg1" id="reg1" > 아이디저장</label></li>
                                </ul>
                                <div class="login_btn"><input type="submit"  id ="btn_login" value="로그인" alt="로그인" /></div>
                            </fieldset>
                            <div class="btnSet clear">
                                <div>
                                    <a href="join.do" class="btn">회원가입</a> 
                                    <a href="idsearch.do" class="btn">이메일/비밀번호 찾기</a>
                                </div>
                            </div>
                        </div>
                    </div>
        
                </div>
            </div>
            </form>
       <jsp:include page="../include/footer.jsp"></jsp:include>
       <jsp:include page="../include/quick.jsp"></jsp:include>
    </div>
</body>
</html>