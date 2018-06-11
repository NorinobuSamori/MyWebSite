<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<input type="hidden" value="test actionMessage">
<c:if test="${errorMessage != null}" >
   	<div class="text-center alert alert-danger" role="alert">
  		${errorMessage}
	</div>
</c:if>

<c:if test="${actionMessage != null}" >
   	<div class="text-center alert alert-success" role="alert">
  		${actionMessage}
	</div>
</c:if>

<c:if test="${smallActionMessage != null}" >
   	<div class="text-center" role="alert">
  		${smallActionMessage}
	</div>
</c:if>
