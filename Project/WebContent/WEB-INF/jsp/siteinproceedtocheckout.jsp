<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>決済確認ページ</title>
<jsp:include page="/baselayout/head.jsp" />
</head>
<body class="color-lightgreen">
	<jsp:include page="/baselayout/header.jsp" />


		<div class="container center">


	        <br>
	        <br>
	        <h3 class="text-center">決済確認ページ</h3>
	        <br>
	        <br>
	        <h3 class="text-center"></h3>


            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">イベント名</th>
                        <th scope="col">単価</th>
                        <th scope="col">小計</th>
                    </tr>
                </thead>
                <tbody>
					<c:forEach var="inCartBeansEventDetailInfoListOne" items="${inCartBeansEventDetailInfoList}"  begin="0">
	                    <tr>
	                        <th scope="row">
	                            ${inCartBeansEventDetailInfoListOne.title}
	                        </th>
	                        <td>${inCartBeansEventDetailInfoListOne.fees}円</td>
	                        <td>${inCartBeansEventDetailInfoListOne.fees}円</td>
	                    </tr>
	                </c:forEach>
	                    <tr>
	                        <th scope="row">
	                        </th>
	                        <td>合計</td>
	                        <td>${beansEventDetailInfo.total_fees}円</td>
	                    </tr>
	                </tbody>
            </table>

	        	<form action="SiteInPlaceUsersOrder" method="post">
	        		<p class="align-center ">
		                <button class="btn col btncolor1 " type="submit">
		                    <span class="a">決済確定</span>
		                </button>
	                </p>
	            </form>
        </div>


    <jsp:include page="/baselayout/footer.jsp" />
</body>

</html>