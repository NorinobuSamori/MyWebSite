<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<c:forEach var="beansEventDetailInfoListOne"
	items="${beansEventDetailInfoList}" begin="0">
	<div class="card grey lighten-5 width100">
		<div class="class-table width2 border-radius ">
			<div class="class-table-row ">
				<div class="class-table-cell class-table-cell-left2">
					<img src="img/${beansEventDetailInfoListOne.img_name}" alt="写真" width="152" height="119">
				</div>
				<div class="class-table-cell class-table-cell-right1">
					<h5>${beansEventDetailInfoListOne.title}</h5>
				</div>
			</div>
			<div class="class-table-row">
				<div class=" class-table-cell class-table-cell-left1">募集分類</div>
				<div class="class-table-cell class-table-cell-right1">${beansEventDetailInfoListOne.event_category}</div>
			</div>
			<div class="class-table-row ">
				<div class="class-table-cell class-table-cell-left1">日程</div>
				<div class="class-table-cell class-table-cell-right1">${beansEventDetailInfoListOne.schedule}</div>
			</div>
			<div class="class-table-row">
				<div class="class-table-cell class-table-cell-left1">参加費用</div>
				<div class="class-table-cell class-table-cell-right1">
					${beansEventDetailInfoListOne.fees}円</div>
			</div>
			<div class="class-table-row">
				<div class="class-table-cell class-table-cell-left1">参加資格</div>
				<div class="class-table-cell class-table-cell-right1">
					${beansEventDetailInfoListOne.qualification}</div>
			</div>
			<div class="class-table-row">
				<div class="class-table-cell class-table-cell-left1">主催</div>
				<div class="class-table-cell class-table-cell-right1">
					${beansEventDetailInfoListOne.organizer}</div>
			</div>
			<div class="class-table-row">
				<div class=" class-table-cell class-table-cell-left1"></div>
				<div class="class-table-cell class-table-cell-right1">
					<div class="text-center">
						<a href="SiteEventDetailInfo?event_id=${beansEventDetailInfoListOne.id}" class="btn col btncolor1 ">イベント詳細へ</a>
						<c:if test="${cartAction != null}">
							<a href="SiteDeleteFromCart?event_id=${beansEventDetailInfoListOne.id}" class="btn col btncolor1 ">カートから削除する</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>