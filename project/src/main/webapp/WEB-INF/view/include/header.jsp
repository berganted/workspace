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
    <title>게시판목록</title>
   
</head>
<body>
    
        <div class="header">
            <div class="size">
                <div><img src="/project/img/logo.png"></div>
                <div class="login">
	                <c:if test="${empty userInfo}">
	                    	<a href="/project/user/login.do">로그인</a> |
	                    	<a href="">회원가입</a>
	                  </c:if>
	                  <c:if test="${!empty userInfo}">
					 		${ memberInfo.name}
							<button onclick="location.href='/project/user/logout.do'">로그아웃</button> 
							<button onclick="location.href='/project/user/mypage.do?${userInfo.no}'">내가 쓴 글</button> 
					</c:if>
                </div>
            </div>
        </div>
        
        
        <div class="menu">
            <ul class="depth1">
                <li><a href="">MENU1</a>
                    <ul class="depth2">
                        <li><a href="">MENU1-1</a></li>
                        <li><a href="">MENU1-2</a></li>
                        <li><a href="">MENU1-3</a></li>
                    </ul>
                </li>
                <li><a href="">MENU2</a>
                    <ul class="depth2">
                        <li><a href="">MENU2-1</a></li>
                        <li><a href="">MENU2-2</a></li>
                        <li><a href="">MENU2-3</a></li>
                    </ul>
                </li>
                <li><a href="">MENU3</a>
                    <ul class="depth2">
                        <li><a href="">MENU3-1</a></li>
                        <li><a href="">MENU3-2</a></li>
                        <li><a href="">MENU3-3</a></li>
                    </ul>
                </li>
                <li><a href="">MENU4</a>
                    <ul class="depth2">
                        <li><a href="">MENU4-1</a></li>
                        <li><a href="">MENU4-2</a></li>
                        <li><a href="">MENU4-3</a></li>
                    </ul>
                </li>
                <li><a href="">게시판</a>
                    <ul class="depth2">
                        <li><a href="/project/board/index.do">게시판</a></li>
                        <li><a href="/project/news/index.do">뉴스</a></li>
                        <li><a href="">MENU5-3</a></li>
                    </ul>
                </li>
            </ul>
        </div>