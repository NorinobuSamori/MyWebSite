<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー管理画面</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
    <br>
    <h1 align="center">
        ユーザ一覧
    </h1>

    <span class="nav justify-content-end margin2">
            <a href="UserInfoRegister">新規登録</a>
    </span>
    	<form action="UserInfoManagementTop" method="post">
	        <div class="nav justify-content-center">
	            <table>
	                <tbody>
	                    <tr>
	                        <td><span class="marginright120">ログインID</span></td>
	                        <td>
	                            <div class="form-group">
	                                <label for="exampleInputEmail1"></label>
	                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter ID" name="login_id">
	                            </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><span class="marginright120">ユーザ名</span></td>
	                        <td>
	                            <div class="form-group">
	                                <label for="exampleInputEmail1"></label>
	                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter NAME" name="name">
	                            </div>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>生年月日</td>
	                        <td>
	                            <span class="form-group">
	                                    <input type="date" name="calendar1" max="9999-12-31" >
	                                    ～
	                                    <input type="date" name="calendar2" max="9999-12-31">
	                                </span>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
        <br>
        <br>
        <div class="text-right margin2">
            <button type="submit">
                    <span class="margin2">検索</span>
                </button>
        </div>
    </form>
    <hr>
    <!-- ------------------------------------------------------------------------  -->
    <div class="container"><!-- spanにするとエラーが発生した  -->
	        <table class="table table-striped ">
	            <thead class="thead-dark">
	                <tr>
	                    <th scope="col">login_id</th>
	                    <th scope="col">name</th>
	                    <th scope="col">birth_date</th>
	                    <th scope="col">リンクボタン</th>
	                </tr>
	            </thead>
	               <tbody>
	               	 <c:if test="${BeansUserInfoAccount.login_id == 'admin'}">
		                 <c:forEach var="BeansUserInfo" items="${BeansUserInfoList}" begin="0" >
		                   <tr>
		                     <td>${BeansUserInfo.login_id}</td>
		                     <td>${BeansUserInfo.name}</td>
		                     <td>${BeansUserInfo.birth_date}</td>
		                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
		                     <td>
		                       <a class="btn btn-primary" href="UserInfoDetail?id=${BeansUserInfo.id}">詳細</a>
		                       <a class="btn btn-success" href="UserInfoUpdate?id=${BeansUserInfo.id}">更新</a>
		                       <a class="btn btn-danger" href ="UserInfoDelete?id=${BeansUserInfo.id}">削除</a>
		                     </td>
		                   </tr>
		                 </c:forEach>
		             </c:if>

		             <c:if test="${BeansUserInfoAccount.login_id != 'admin'}">
		                 <c:forEach var="BeansUserInfo" items="${BeansUserInfoList}"  begin="0">
		                   <tr>
		                     <td>${BeansUserInfo.login_id}</td>
		                     <td>${BeansUserInfo.name}</td>
		                     <td>${BeansUserInfo.birth_date}</td>
		                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
		                     <td>
		                       <a class="btn btn-primary" href="UserInfoDetail?id=${BeansUserInfo.id}">詳細</a>
		                       		<c:if test="${BeansUserInfo.login_id == BeansUserInfoAccount.login_id}">
		                       			<a class="btn btn-success" href="UserInfoUpdate?id=${BeansUserInfo.id}">更新</a>
		                       		</c:if>
		                     </td>
		                   </tr>
		                 </c:forEach>
		             </c:if>
	               </tbody>
	        </table>
	    </div>
</body>

</html>