<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<c:if test="${beansUserInfoAccount.login_id != null}" >
   	<div class="text-center" role="alert">
  		${beansUserInfoAccount.login_id}
	</div>
</c:if>


