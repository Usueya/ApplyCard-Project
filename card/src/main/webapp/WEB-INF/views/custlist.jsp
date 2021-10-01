<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/scripts.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
<head>
<meta charset="UTF-8">
<title>회원 색인 조회</title>
</head>
<body>
	<div class="flex h-screen bg-gray-50 dark:bg-gray-900" :class="{ 'overflow-hidden': isSideMenuOpen }">
	<%@ include file="./include/sidebar.jsp" %>
	
		<div class="flex flex-col flex-1 w-full">
		<%@ include file="./include/header.jsp" %>
		
		<main class="h-full overflow-y-auto">
        <div class="container px-6 mx-auto grid">
        	<h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" >회원색인조회</h2>
			
			<fieldset>
				<form action="${path}/custlist" method="post">
				 	성명 <input type="text" name="hg_nm" id="hg_nm" value="${param.hg_nm }">
					생년월일 <input type="text" name="birth_d" id="birth_d" value="${param.birth_d }">
					핸드폰번호 <input type="text" name=hdp_no id="hdp_no" value="${param.hdp_no }" style="margin-right: 10px;">
					<button 
					class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
					type="submit" id="findList">조회</button>
				</form>
			</fieldset>
			<hr>
			
			<table class="w-full whitespace-no-wrap" style="width: 1000px; margin-top: 30px;">
				<tr align="left"><th colspan="8">조회결과</th></tr>
				<tr>
					<th>*</th>
					<th>주민번호</th>
					<th>성명(한글)</th>
					<th>생년월일</th>
					<th>핸드폰번호</th>
					<th>결제은행</th>
					<th>결제계좌</th>
					<th>주소</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td style="width: 40px;">
							<a href="${path}/cardlist?ssn=${list.SSN}">
								<i class="fas fa-search"></i>
							</a>
						</td>
						<td>${list.SSN}</td>
						<td>${list.HG_NM}</td>
						<td>${list.BIRTH_D}</td>
						<td>${list.HDP_NO}</td>
						<td>${list.CODE_NM}</td>
						<td>${list.STL_ACT}</td>
						<td>${list.BILL_ADR2}</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
        </main>
		</div>
	
	</div>
</body>
</html>