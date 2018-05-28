<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>TOPページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen">
	<jsp:include page="/baselayout/header.jsp" />


    <br>
    <br>
    <h1 class="text-center"></h1>
    ${searchWord}での検索結果${eventCount}件
    <br>

	<div class="container ">
		<jsp:include page="/event-tables/event-summary-table-list.jsp" />
	</div>





	<div class="row center">
			<ul class="pagination">
				<!-- １ページ戻るボタン  -->
				<c:if test="${pageNum == 1}">
					<li class="disabled"><a><i class="material-icons">chevron_left</i></a></li>
				</c:if>
				<c:if test="${pageNum != 1}">
					<li class="waves-effect"><a href="ItemSearchResult?search_word=${searchWord & page_num}=${pageNum - 1}"><i class="material-icons">chevron_left</i></a></li>
				</c:if>
				<!-- ページインデックス -->
				<%
					for (int j = pageNum - 5; j <= pageNum + 5; j++) {
				%>
				<!-- マイナスページが生成されないように -->
				<%
					if (j <= 0) {
							j = 1;
						}
				%>
				<li <%if (pageNum == j) {%> class="active" <%}%>><a href="ItemSearchResult?search_word=${searchWord & page_num}=${pageNum=" + j%>"><%=j%></a></li>
				<!-- MAXを越さないように -->
				<%
					if (pageMax <= j) {
							break;
						}
				%>
				<%
					}
				%>
				<!-- 1ページ送るボタン -->

				<c:if test=" pageNum == pageMax || pageMax == 0) ">
					<li class="disabled"><a><i class="material-icons">chevron_right</i></a></li>
				</c:if>
				<c:if test="pageNum != pageMax || pageMax != 0) ">
					<li class="waves-effect"><a href="<%="ItemSearchResult?search_word=" + searchWord + "&page_num=" + (pageNum + 1)%>"><i class="material-icons">chevron_right</i></a></li>
				</c:if>
			</ul>
		</div>









    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>