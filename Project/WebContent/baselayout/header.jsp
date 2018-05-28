<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<nav class="header1 navbar">

	<a href="MasterEventDelete" class="header-fonts2 display-inline">
		MEDelete
	</a>
	<span class="margin1"></span>
	<a href="MasterEventRegister" class="header-fonts2 display-inline">
		MERegister
	</a>
	<span class="margin1"></span>
	<a href="UserInfoManagementTop"
		class="header-fonts2 display-inline">
		UserList
	</a>
	<a href="SiteEventDetailInfo"
		class="header-fonts2 display-inline">
		UserList
	</a>
	<a href="SiteLogin" class="header-fonts2 display-inline">
		ログインページ
	</a> <span class="margin1"></span>
	<a href="Index" class="header-fonts2 display-inline">
		ロゴ
	</a>
	<span class="white">
                    ${beansUserInfoAccount.login_id}
	</span>



	<form  class="display-inline" action="SiteEventSearchResult">
		<div class="form-group ">
		<input type="text" class="  display-inline form-control22 " placeholder="AllSearch"
			required name="search_word">
		<button  class="header-fonts2"> <i class="fas fa-search"></i></button>
		</div>
	</form>
	<span class="margin1"></span>



	<a href="???????" class="header-fonts2">
		<i class="fas fa-shopping-cart"></i>
	</a>
	<span class="margin2"></span>
	<a href="???????" class="header-fonts2">
		<i class="fas fa-sign-in-alt"></i>
	</a>
	<span class="margin2"></span>
	<a href="UserInfoRegister" class="header-fonts2">
		<i class="fas fa-user-plus"></i>
	</a>
	<span class="margin2"></span>
	<a href="???????" class="header-fonts2">
		E
	</a>
	<a href="???????" class="header-fonts2 display-inline">
		ER
	</a>



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

