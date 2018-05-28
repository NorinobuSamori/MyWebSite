<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<c:if test="${errorMessage != null}" >
   	<div class="alert alert-danger" role="alert">
  		${errorMessage}
	</div>
</c:if>

<c:if test="${actionMessage != null}" >
   	<div class="text-center" role="alert">
  		${actionMessage}
	</div>
</c:if>

<c:if test="${smallActionMessage != null}" >
   	<div class="text-center" role="alert">
  		${smallActionMessage}
	</div>
</c:if>


<%-- actionをifにして、errorMessageをelseにしないと、セッションスコープが常に呼び出されてしまう --%>
