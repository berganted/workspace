<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<table class="list">
	<span><strong>총 ${commentVo.totCount }개</strong> |
		${commentVo.reqPage }/${commentVo.totPage }</span>
	<colgroup>
		<col width="*" />
		<col width="100px" />
		<col width="100px" />
		<col width="100px" />
	</colgroup>
	<tbody>
		<c:if test="${empty list }">
			<tr>
				<td class="first" colspan="5">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="list" items="${list }">
			<tr>
				<td class="comment_c">${list.content }</td>
				<td> <c:if test="${userInfo.no==list.user_no }">
						<a href='javascript:isDelc(${list.no})' >[X]</a>
					</c:if> </td>
				<td>${list.name }</td>
				<td><fmt:formatDate value="${list.regdate }"
						pattern="yyyy-MM-dd" /></td>


			</tr>
		</c:forEach>

	</tbody>
</table>
<div class="pagenate clear">
	<ul class='paging'>
		<c:if test="${commentVo.strPage > commentVo.pageRange}">
			<li><a href="javascript:getComment(${commentVo.strPage-1 })"><</a></li>
		</c:if>
		<c:forEach var="rp" begin="${commentVo.strPage }"
			end="${commentVo.endPage }">
			<li><a href='javascript:getComment(${rp })'
				<c:if test="${rp==commentVo.reqPage }">class='current'</c:if>>${rp}</a></li>
		</c:forEach>
		<c:if test="${commentVo.totPage > commentVo.endPage}">
			<li><a href="javascript:getComment(${commentVo.endPage+1 })">></a></li>
				;
		</c:if>
	</ul>
</div>
