<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/member/member.js"></script>
<style>
form div{
	width: 20%; 
	margin: 0 auto; 
	margin-bottom: 20px;
}
</style>
<div class="page-main-style">
	<h1>회원 로그인</h1>
	<form:form commandName="memberCommand" id="login_form">
		<div class="form-group">
			<label for="id">아이디</label>
			<form:input path="id" name="id" cssClass="form-control"/>
			<form:errors path="id" cssClass="error-color"/>
			<input type="checkbox" id="idSaveCheck" name="idSaveCheck">아이디 저장
		</div>
		<div class="form-group">
			<label for="pw">비밀번호</label>
			<form:password path="pw" cssClass="form-control"/>
			<form:errors path="pw" cssClass="error-color"/>		
		</div>
		<div class="align-center">
			<input type="submit" value="로그인">
			<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main.do'">
		</div>
	</form:form>
</div>
