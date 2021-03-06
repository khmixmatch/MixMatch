<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="match-div">
	<h3 style="text-align:left;font-weight:bold;">리그</h3>
	<hr class="match-hr"><br>
	
	<div class="match-form">
		<form action="leagueList.do" method="get">
		<input type="submit" value="축구" name="type" 
		<c:if test="${type eq '축구'}">class="select-btn" disabled</c:if>
		<c:if test="${type ne '축구'}">class="match-btn"</c:if>>
			
		<input type="submit" value="야구" name="type"  
		<c:if test="${type eq '야구'}">class="select-btn"</c:if>
		<c:if test="${type ne '야구'}">class="match-btn"</c:if>>
		
		<input type="submit" value="농구" name="type"  
		<c:if test="${type eq '농구'}">class="select-btn"</c:if>
		<c:if test="${type ne '농구'}">class="match-btn"</c:if>>
		</form><br>
		
		<table class="match-table">
			<tr>
				<th>리그이름</th>
				<th>지역</th>
				<th>날짜</th>
				<th>시간</th>
				<th>모집현황</th>
				<th>참가신청</th>
			</tr>
			
			<c:if test="${count == 0}">
				<tr><td colspan="6">등록된 리그가 없습니다.</td></tr>
			</c:if>
			
			<c:if test="${count > 0}">
				<c:forEach var="league" items="${list}">
					<tr>
						<td>${league.l_title}</td>
						<td>${league.l_area}</td>
						<td>${league.l_date}</td>
						<td>${league.l_time}</td>
						<td>${league.l_team}/${league.l_number}</td>
						<td><input type="button" value="상세보기" class="match-btn" onclick="location.href='leagueDetail.do?l_seq=${league.l_seq}'"></td>
					</tr>
				</c:forEach>	
			</c:if>
		</table>
		<div>${pagingHtml}</div>
	</div>
	<c:if test="${!empty user_id}">
			<div>
				<input type="button" value="리그등록" class="match-btn" id="delete_btn" style="margin-top:20px;" onclick="location.href='leagueInsert.do'">
			</div>
		</c:if>
</div>