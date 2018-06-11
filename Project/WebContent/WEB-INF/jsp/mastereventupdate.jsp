<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<jsp:include page="/baselayout/head.jsp" />
<title>イベント更新ページ</title>
</head>

<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<br>
		<br>
		<br>
		<div class="card">
			<h1 class="text-center">イベント更新</h1>
			<jsp:include page="/baselayout/actionMessage.jsp" />
		</div>

		<div class="width100">

			<br>
			<div class="card grey lighten-5 ">
				<form action="MasterEventUpdate" method="post"
					enctype="multipart/form-data">
					<h3 class="text-center">イベント更新フォーム</h3>
					<br> 画像（入力必須）
					<p>
						<input type="file" name="upLoadFileName" required>
					</p>
					トップ
					<div class="form-group">
						<textarea class="form-control" rows="3" name="title"  required>${beansEventDetailInfo.title}</textarea>
					</div>
					<br> 内容
					<div class="form-group">
						<textarea class="form-control" rows="8" name="summary" required>${beansEventDetailInfo.summary}</textarea>
					</div>
					<br> 募集分類
					<div class="form-group">
						<textarea class="form-control" rows="3" name="event_category"
							required>${beansEventDetailInfo.event_category}</textarea>
					</div>
					<br> スケジュール
					<div class="form-group">
						<textarea class="form-control" rows="3" name="schedule" required>${beansEventDetailInfo.schedule}</textarea>
					</div>
					<br> 地域
					<div class="form-group">
						<textarea class="form-control" rows="3" name="local_region"
							required>${beansEventDetailInfo.local_region}</textarea>
					</div>
					<br> 参加費用
					<div class="row">
						<div class="form-group  col">
							<input type="number" class="form-control" name="fees" value="${beansEventDetailInfo.fees}" required>
						</div>
						<div class="col">円</div>
						<div class="col"></div>
					</div>
					<br> 交通access
					<div class="form-group">
						<textarea class="form-control" rows="3" name="access" required>${beansEventDetailInfo.access}</textarea>
					</div>
					<br> 参加資格qualification
					<div class="form-group">
						<textarea class="form-control" rows="7" name="qualification"
							required>${beansEventDetailInfo.qualification}</textarea>
					</div>
					<br> 講演者presenter
					<div class="form-group">
						<textarea class="form-control" rows="3" name="presenter" required>${beansEventDetailInfo.presenter}</textarea>
					</div>
					<br> 主催organizer
					<div class="form-group">
						<textarea class="form-control" rows="3" name="organizer" required>${beansEventDetailInfo.organizer}</textarea>
					</div>

					<input type="hidden" name="event_id" value="${beansEventDetailInfo.id}">

					<button class="btn  col btncolor1" type="submit">イベント更新する</button>
				</form>
				<form action="Index" method="get">
					<button class="btn col btn2" type="submit">取りやめる</button>
				</form>
			</div>



		</div>






	</div>



	<jsp:include page="/baselayout/footer.jsp" />
</body>

</html>