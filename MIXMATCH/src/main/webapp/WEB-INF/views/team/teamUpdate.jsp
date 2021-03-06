<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	ul{list-style: none;}
.file_input label {
    position:relative;
    cursor:pointer;
    display:inline-block;
    vertical-align:middle;
    overflow:hidden;
    width:70px;
    height:30px;
    background:#777;
    color:#fff;
    text-align:center;
    line-height:30px;
}
.file_input label input {
    position:absolute;
    width:0;
    height:0;
    overflow:hidden;
}
.file_input input[type=text] {
    vertical-align:middle;
    display:inline-block;
    width:120px;
    height:28px;
    line-height:28px;
    font-size:11px;
    padding:0;
    border:0;
    border:1px solid #777;
}
</style>
<link href="${pageContext.request.contextPath}/resources/css/layout222.css" rel="stylesheet">
<div class="page-main-style">
	<form:form class="style" id="teamUpdate" commandName="teamCommand" action="${pageContext.request.contextPath}/team/teamUpdate.do" enctype="multipart/form-data">
	<form:errors element="div" cssClass="error-color"/>
	<input type="hidden" id="id" name="id" value="${user_id}">
	<br>
	<br>
	<ul>
		<li>
			<label for="t_name">팀명</label>
			<input type="text" readonly="readonly" id="t_name"name="t_name" value="${teamCommand.t_name}">
		</li>
		<li>
			<label for="t_type">팀종목</label>
			<form:select path="t_type">
				<form:option value="야구" >야구</form:option>
				<form:option value="축구" >축구</form:option>
				<form:option value="농구" >농구</form:option>
			</form:select>
			<form:errors path="t_type" cssClass="error-color"/>
		</li>
		<li>
			<label for="t_address">팀연고지</label>
			<form:select path="t_address">
				<form:option value="서울" >서울</form:option>
				<form:option value="경기도" >경기도</form:option>
				<form:option value="강원도" >강원도</form:option>
				<form:option value="전라도" >전라도</form:option>
				<form:option value="경상도" >경상도</form:option>
				<form:option value="충청도" >충청도</form:option>
				<form:option value="제주도" >제주도</form:option>
				<form:option value="해외" >해외</form:option>
			</form:select>
			<form:errors path="t_address" cssClass="error-color"/>
		</li>
		<li>
			<label for="t_logo_upload">팀로고</label>
			<!-- <input type="file" name="t_logo_upload" id="t_logo_upload" > -->
			<div class="file_input" style="width: 100%;">
			    <label>
			        File
			        <input type="file" name="t_logo_upload" id="t_logo_upload" onchange="javascript:document.getElementById('file_route').value=this.value">
			    </label>
			    <input type="text" readonly="readonly" title="File Route" id="file_route">
			</div>
			<c:if test="${!empty teamCommand.t_logo_name}">
				<br>
				<span>(${teamCommand.t_logo_name}이 등록되어있습니다. 재업로드하면 기존 파일은 삭제됩니다.)</span>
			</c:if>
		</li>
	</ul>
	<div class="align-center">
		<input type="submit" class="btn" value="수정">
		<input type="button" class="btn" value="취소" onclick="location.href='${pageContext.request.contextPath}/team/teamInfo.do?t_name=${teamCommand.t_name}'">
	</div>
	<br>
	<br>
	</form:form>
</div>