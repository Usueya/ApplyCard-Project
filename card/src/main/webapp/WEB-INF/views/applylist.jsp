<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/scripts.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
<head>
<meta charset="UTF-8">
<title>기간별 입회신청 내역조회</title>
</head>
<body>
	<div class="flex h-screen bg-gray-50 dark:bg-gray-900" :class="{ 'overflow-hidden': isSideMenuOpen }">
      <%@ include file="./include/sidebar.jsp" %>
      
      <div class="flex flex-col flex-1 w-full">
      <%@ include file="./include/header.jsp" %>
        <main class="h-full overflow-y-auto">
          <div class="container px-6 mx-auto grid">
            <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" > 기간별 입회신청 내역조회 </h2>
            
            
            	<form action="${path}/applylist" method="get">
					기간 <input type="date" name="startDate" value="${condition.startDate}"> 
					~    <input type="date" name="endDate" value="${condition.endDate}">
					
					신청구분
					<select name="appl_clas" id="appl_clas">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C007' }">
								<option ${condition.appl_clas eq list.code? 'selected':''}
								value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
					
					주민번호 
					<input type="text" name="ssn" id="ssn"  value="${condition.ssn}">
					<button 
					class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
					type="submit">조회</button>
					<hr>
				</form>
				
				<table 
				 class="w-full whitespace-no-wrap"
				 border="1" style="width: 1000px; text-align: center; margin-top: 30px;">
				 
					<tr style="text-align: left;"><th colspan="11">조회결과</th></tr>
					<tr>
						<th>*</th>
						<th>접수일자</th>
						<th>접수일련번호</th>
						<th>주민번호</th>
						<th>성명(한글)</th>
						<th>성명(영문)</th>
						<th>신청구분</th>
						<th>브랜드</th>
						<th>핸드폰번호</th>
						<th>불능구분</th>
						<th>불능사유명</th>
					</tr>
					<c:forEach var="list" items="${appllist}">
						<tr>
							<td style="width: 40px;">
								<a href="${path}/findApply?rcv_d=${list.rcv_d}&rcv_seq_no=${list.rcv_seq_no}&ssn=${list.ssn}">
									<i class="fas fa-search"></i>
								</a>
							</td>
							<td>${list.rcv_d}</td>
							<td>${list.rcv_seq_no}</td>
							<td>${list.ssn}</td>
							<td>${list.hg_nm}</td>
							<td>${list.eng_nm}</td>
							<td>${list.appl_name}</td>
							<td>${list.code_nm}</td>
							<td>${list.hdp_no}</td>
							<td>${list.impsb_cd}</td>
							<td>${list.impsb_cd}</td>
						</tr>
					</c:forEach>
				</table>
            
            
            
          </div>
        </main>
      </div>
    </div>

	


</body>
</html>