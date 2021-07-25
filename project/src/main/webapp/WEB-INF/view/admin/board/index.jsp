<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/view/admin/include/headHtml.jsp"%>
</head>
<script type="text/javascript">
	function groupDel() {
			var cnt = 0;
		for(var i=0; i<$('input[name=nos]').length;i++){
			if($('input[name=nos]').eq(i).prop('checked')){
				cnt++;
				break;
			}
		}
		if( cnt == 0 ){
			alert('하나 이상 체크해 주세요');
		}else{
			if(confirm('삭제하시겠습니까?')){
				$('#frm').submit();
			}
		}
	}
	function selectAll(selectAll)  {
		  const checkboxes 
		     = document.getElementsByName('nos');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked
		  })
		}
	function checkSelectAll()  {
		  // 전체 체크박스
		  const checkboxes 
		    = document.querySelectorAll('input[name="nos"]');
		  // 선택된 체크박스
		  const checked 
		    = document.querySelectorAll('input[name="nos"]:checked');
		  // select all 체크박스
		  const selectAll 
		    = document.querySelector('input[name="allChk"]');
		  
		  if(checkboxes.length === checked.length)  {
		    selectAll.checked = true;
		  }else {
		    selectAll.checked = false;
		  }

		}
</script>
<body>
	<div id="wrap">
		<!-- canvas -->
		<div id="canvas">
			<!-- S T A R T :: headerArea-->
			<%@ include file="/WEB-INF/view/admin/include/top.jsp"%>
			<!-- E N D :: headerArea-->

			<!-- S T A R T :: containerArea-->
			<div id="container">
				<div id="content">
					<div class="con_tit">
						<h2>공지사항 - [목록]</h2>
					</div>
					<!-- //con_tit -->
					<div class="con">
						<!-- 내용 : s -->
						<div id="bbs">
							<div id="blist">
								<span><strong>총 ${boardVo.totCount }개</strong> |
									${boardVo.reqPage }/${boardVo.totPage }</span>
								<form name="frm" id="frm" action="grouDelete2.do" method="post">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										summary="관리자 관리목록입니다.">
										<colgroup>
											<col class="w3" />
											<col class="w4" />
											<col class="" />
											<col class="w10" />
											<col class="w5" />
											<col class="w6" />
										</colgroup>
										<thead>
											<tr>
												<th scope="col" class="first"><input type="checkbox"
													name="allChk" id="allChk"
													onClick="selectAll(this);" /></th>
												<th scope="col">번호</th>
												<th scope="col">제목</th>
												<th scope="col">작성일</th>
												<th scope="col">작성자</th>
												<th scope="col" class="last">조회수</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="list" items="${list }">
												<tr>
													<td class="frist"><input type="checkbox" name="nos"
														value="${list.no }" onclick="checkSelectAll()"/></td>
													<td>${list.no }</td>
													<td><a
														href="detail.do?no=${list.no }&reqPage=${boardVo.reqPage}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}">${list.title }</a><span
														style="font-size: 10px">[${list.rcnt }]</span></td>
													<td>${list.date2 }</td>
													<td>${list.name }</td>
													<td>${list.readcount }</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</form>
								<div class="btn">
									<div class="btnLeft">
										<a class="btns" href="#" onclick="groupDel();"><strong>삭제</strong> </a>
									</div>
									<div class="btnRight">
										<a class="wbtn" href="write.do"><strong>등록</strong> </a>
									</div>
								</div>
								<!--//btn-->
								<!-- 페이징 처리 -->
								<div class='page'>
									<c:if test="${boardVo.strPage > boardVo.pageRange}">
										<li><a href="index.do?reqPage=${boardVo.strPage-1 }&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}"></a>
									</c:if>
									<c:forEach var="rp" begin="${boardVo.strPage }"
										end="${boardVo.endPage }">
										<c:if test="${rp==boardVo.reqPage }"><strong>${rp }</strong></c:if>
										<c:if test="${rp!=boardVo.reqPage }">
                                  	<a href='index.do?reqPage=${rp}&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}' class='current'>${rp }</a></c:if>

									</c:forEach>
									<c:if test="${boardVo.totPage > boardVo.endPage}">
										<a
											href="index.do?reqPage=${boardVo.endPage+1 }&stype=${param.stype}&sval=${param.sval}&orderby=${param.orderby}&direct=${param.direct}">></a></c:if>
								</div>
								<!-- //페이징 처리 -->
								<form name="searchForm" id="searchForm" action="index.do"
									method="post">
									<div class="search">
										<select name="stype" title="검색을 선택해주세요">
											<option value="all">전체</option>
											<option value="title"
												<c:if test="${param.stype=='title'}"> selected</c:if>>제목</option>
											<option value="content"
												<c:if test="${param.stype=='content'}"> selected</c:if>>내용</option>
										</select> <input type="text" name="sval" value=""
											title="검색할 내용을 입력해주세요" /> <input type="image"
											src="<%=request.getContextPath()%>/img/admin/btn_search.gif"
											class="sbtn" alt="검색" />
									</div>
								</form>
								<!-- //search -->
							</div>
							<!-- //blist -->
						</div>
						<!-- //bbs -->
						<!-- 내용 : e -->
					</div>
					<!--//con -->
				</div>
				<!--//content -->
			</div>
			<!--//container -->
			<!-- E N D :: containerArea-->
		</div>
		<!--//canvas -->
	</div>
	<!--//wrap -->

</body>
</html>