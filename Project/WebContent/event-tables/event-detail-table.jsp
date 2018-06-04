<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


	<div class="class-table width2 border-radius ">
		<div class="class-table-row ">
			<div class="class-table-cell class-table-cell-left2">
				<img src="img/${beansEventDetailInfo.img_name}" alt="写真" width="152" height="119">
			</div>
			<div class="class-table-cell class-table-cell-right1">
				<h5>${beansEventDetailInfo.title}</h5>
			</div>
		</div>
		<div class="class-table-row">
			<div class="class-table-cell class-table-cell-left1">内容</div>
			<div class="class-table-cell class-table-cell-right1">${beansEventDetailInfo.summary}</div>
		</div>
		<div class="class-table-row">
			<div class=" class-table-cell class-table-cell-left1">募集分類</div>
			<div class="class-table-cell class-table-cell-right1">${beansEventDetailInfo.event_category}</div>
		</div>
		<div class="class-table-row ">
			<div class="class-table-cell class-table-cell-left1">日程</div>
			<div class="class-table-cell class-table-cell-right1">${beansEventDetailInfo.schedule}</div>
		</div>
		<div class="class-table-row">
			<div class="class-table-cell class-table-cell-left1">地域</div>
			<div class="class-table-cell class-table-cell-right1">
				${beansEventDetailInfo.local_region}</div>
		</div>
		<div class="class-table-row">
			<div class="class-table-cell class-table-cell-left1">参加費用</div>
			<div class="class-table-cell class-table-cell-right1">
				${beansEventDetailInfo.fees}円</div>
		</div>

		<div class="class-table-row">
			<div class="class-table-cell class-table-cell-left1">参加資格</div>
			<div class="class-table-cell class-table-cell-right1">
				${beansEventDetailInfo.qualification}</div>
		</div>
		<div class="class-table-row">
			<div class="class-table-cell class-table-cell-left1">主催</div>
			<div class="class-table-cell class-table-cell-right1">
				${beansEventDetailInfo.organizer}</div>
		</div>
		<div class="class-table-row">
			<div class=" class-table-cell class-table-cell-left1"></div>
			<div class="class-table-cell class-table-cell-right1">
				<div class="text-center row">
					<form class="col" action="SiteAddToCart" method="post">
						<button class="btn btncolor1" type="submit" name="event_id" value="${beansEventDetailInfo.id}">カートに入れる</button>
					</form>
					<c:if test="${beansUserInfoAccount.login_id == 'admin'}">
						<a href="MasterEventUpdate?event_id=${beansEventDetailInfo.id}" class="btn col btn2">イベントを更新する</a>
						<a href="MasterEventDelete?event_id=${beansEventDetailInfo.id}" class="btn col btn-danger">イベントを削除する</a>
					</c:if>
				</div>
			</div>
		</div>


	</div>
