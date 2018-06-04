<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<jsp:include page="/baselayout/head.jsp" />
<title>イベント新規登録ページ</title>
</head>

<body class="background-color1">
	<jsp:include page="/baselayout/header.jsp" />
	<div class="container">

		<br> <br> <br>
		<h1 class="text-center card">
			イベント新規登録
			<jsp:include page="/baselayout/actionMessage.jsp" />
		</h1>

		<div class="width100">

			<br>
			<div class="card grey lighten-5 ">
				<form action="MasterEventRegister" method="post"
					enctype="multipart/form-data">
					<h3 class="text-center">イベント表新規登録フォーム</h3>
					<br>
					画像
					<p>
						<input type="file" name="upLoadFileName" required>
					</p>
					トップtitle
					<div class="form-group">
						<textarea class="form-control" rows="3" name="title" required></textarea>
					</div>
					<br> 内容summary
					<div class="form-group">
						<textarea class="form-control" rows="8" name="summary" required></textarea>
					</div>
					<br> 募集分類event_category
					<div class="form-group">
						<textarea class="form-control" rows="1" name="event_category"
							required></textarea>
					</div>
					<br> スケジュールschedule
					<div class="form-group">
						<textarea class="form-control" rows="1" name="schedule" required></textarea>
					</div>
					<br> 地域local_region
					<div class="form-group">
						<textarea class="form-control" rows="1" name="local_region"
							required></textarea>
					</div>
					<br>
					参加費用fees
					<div class="row">
						<div class="form-group  col">
							<input type="number" class="form-control" name="fees" required>
							<%-- class="col"の修飾する位置に注意 --%>
						</div>
						<div class="col">円</div>
						<div class="col"></div>
					</div>
					<br> 交通access
					<div class="form-group">
						<textarea class="form-control" rows="3" name="access" required></textarea>
					</div>
					<br> 参加資格qualification
					<div class="form-group">
						<textarea class="form-control" rows="7" name="qualification"
							required></textarea>
					</div>
					<br> 講演者presenter
					<div class="form-group">
						<textarea class="form-control" rows="1" name="presenter" required></textarea>
					</div>
					<br> 主催organizer
					<div class="form-group">
						<textarea class="form-control" rows="1" name="organizer" required></textarea>
					</div>

					<button class="btn  col btncolor1" type="submit">新規登録する</button>
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