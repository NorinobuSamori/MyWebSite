<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<nav class="header1 navbar">
	<a href="Index" class="header-fonts2 display-inline">
		ECE
	</a>
	<div class="margin1"></div>
	<a href="UserInfoManagementTop"
		class="header-fonts2 display-inline">
		ユーザー管理システム
	</a>

	<div class="margin1"></div>

	<div class="header-fonts2">
		<c:if test="${beansUserInfoAccount != null}">
			${beansUserInfoAccount.login_id}さん
		</c:if>
	</div>
	<c:if test="${beansUserInfoAccount == null}">
		<a href="SiteLogin" class="header-fonts2 display-inline">ログイン</a>
	</c:if>
	<c:if test="${beansUserInfoAccount != null}">
		<a href="SiteLogout" class="header-fonts2 display-inline">ログアウト</a>
	</c:if>
	<a href="SiteEventHistory" class="header-fonts2 display-inline">SiteEventHistory</a>


	<form  class="display-inline" action="SiteEventSearchResult">
		<div class="form-group ">
		<input type="text" class="  display-inline form-control22 " placeholder="AllSearch"
			required name="search_word">
		<button  class="header-fonts2"> <i class="fas fa-search"></i></button>
		</div>
	</form>
	<div class="margin1"></div>



	<a href="SiteInCart" class="header-fonts2">
		<i class="fas fa-shopping-cart"></i>
	</a>
	<div class="margin2"></div>




</nav>


<%--
<nav class="red darken-4" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="Index" class="brand-logo">EC</a>
		<ul class="right">
			<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>

			<%if(isLogin){ %>
			<li><a href="UserData"><i class="material-icons">account_circle</i></a></li>
			<%}else{ %>
			<li><a href="Regist"><i class="material-icons">add</i></a></li>
			<%} %>

			<li><a href="Cart"><i class="material-icons">shopping_cart</i></a></li>

			<%if(isLogin){ %>
			<li><a href="Logout"><i class="material-icons">exit_to_app</i></a></li>
			<%}else{ %>
			<li><a href="Login"><i class="material-icons">vpn_key</i></a></li>
			<%} %>
		</ul>
		</div>
</nav>
--%>

