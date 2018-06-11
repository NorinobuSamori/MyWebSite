<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.BeansEventDetailInfo"%>
<%@page import=" java.util.ArrayList"%>



<!DOCTYPE html>
<html>
<head>
<title>TOPページ</title>
<jsp:include page="/baselayout/head.jsp" />
<%
	ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = (ArrayList<BeansEventDetailInfo>) session.getAttribute("beansEventDetailInfoList");
	String searchWord = (String) session.getAttribute("searchWord");
	int pageMax = (int) request.getAttribute("pageMax");
	int pageNum = (int) request.getAttribute("pageNum");
	int eventCount = (int) request.getAttribute("eventCount");
%>
</head>
<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container ">

	    <br>
	    <br>
	    <div class="card">
		    <h1 class="text-center">検索結果</h1>
		    "${searchWord}"での検索結果${eventCount}件 ${pageNum}ページ目
		</div>
	    <br>

			<jsp:include page="/event-tables/event-summary-table-list.jsp" />





		<div class="card">
			<div class="row justify-content-center page-index-size1">	<%-- cardの位置に注意 --%>
					<!-- １ページ戻るボタン  -->
					<c:if test="${pageNum == 1}">
						<i class="fas fa-chevron-left"></i>
					</c:if>
					<c:if test="${pageNum != 1}">
					<a href="SiteEventSearchResult?search_word=${searchWord}&page_num=${pageNum - 1}"><i class="fas fa-chevron-left"></i></a>
					</c:if>




					<%-- ----------------------------------------------------------------------------------------------------------------------- --%>



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
					<%if (pageNum == j) {%> <%}%><a class="color-lightgreen page-index-button1" href="<%="SiteEventSearchResult?search_word=" + searchWord + "&page_num=" + j%>"><%=j%></a>
					<!-- MAXを越さないように -->
					<%
						if (pageMax <= j) {
								break;
							}
					%>
					<%
						}
					%>




					<%-- ----------------------------------------------------------------------------------------------------------------------- --%>



					<!-- 1ページ送るボタン -->

					<c:if test="${pageNum == pageMax || pageMax == 0}">
						<i class="fas fa-chevron-right"></i>
					</c:if>
					<c:if test="${pageNum != pageMax && pageMax != 0}">
						<a href="SiteEventSearchResult?search_word=${searchWord}&page_num=${pageNum + 1}"><i class="fas fa-chevron-right"></i></a>
					</c:if>
			</div>
		</div>






	</div>

    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>