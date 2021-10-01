<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/scripts.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
<head>
<meta charset="UTF-8">
<title>카드 상세 내역조회</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<style type="text/css">
	<style type="text/css">
	th {
		height: 40px;
	}
	td {
		height: 40px;
	}
</style>
<script type="text/javascript">
	$(function () {
		
		$('#findCarddetail').on('click', function () {
			var ssn = $('#ssn').val();
			var crd_no = $('#crd_no').val();
			
			if(ssn == ''){
				alert('주민번호를 입력하세요');
				$('#ssn').focus();
			}else if(crd_no == ''){
				alert('카드번호를 입력하세요');
				$('#crd_no').focus();
			}else{
				$('#findCarddetailForm').submit();
			}
		});
		
		if ('${crd}' == ''){
			alert('조회값이 없습니다!');
		}
		
	});
	
</script>
</head>
<body>
	<div class="flex h-screen bg-gray-50 dark:bg-gray-900" :class="{ 'overflow-hidden': isSideMenuOpen }">
      <%@ include file="./include/sidebar.jsp" %>
      
      <div class="flex flex-col flex-1 w-full">
      <%@ include file="./include/header.jsp" %>
        <main class="h-full overflow-y-auto">
          <div class="container px-6 mx-auto grid">
            <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" > 카드 상세 내역조회 </h2>
            	<form id="findCarddetailForm" action="${path}/carddetail">
            	    <table>
            			<tr>
            				<th style="padding-right: 20px;">주민번호</th>
            				<td style="padding-right: 20px;"><input type="text" name="ssn" id="ssn" value="${crd.ssn}"></td>
            				<th style="padding-right: 20px;">카드번호</th>
            				<td style="padding-right: 20px;"><input type="text" name="crd_no" id="crd_no" value="${crd.crd_no}"></td>
            				<td style="padding-right: 20px;">
            					<button 
            					class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
            					type="button" id="findCarddetail">조회</button>
           					</td>
            			</tr>
            		</table>
				</form>
				
				<hr>
				<table border="1" style="text-align: center; margin-top: 30px;" class="w-full whitespace-no-wrap" >
					<tr align="left"><th colspan="4">조회결과</th></tr>
					<tr>
						<th>성명(한글)</th>
						<td><input type="text" value="${crd.hg_nm}" disabled></td>
						<th>성명(영문)</th>
						<td><input type="text" value="${crd.eng_nm}" disabled></td>
					</tr>
					<tr>
						<th>등록일자</th>
						<td><input type="text" value="${crd.reg_d}" disabled></td>
						<th>유효기간</th>
						<td><input type="text" value="${crd.vld_dur}" disabled></td>
					</tr>
					<tr>
						<th>브랜드</th>
						<td><input type="text" value="${crd.brd_nm}" disabled></td>
						<th>카드등급</th>
						<td><input type="text" value="${crd.grd_nm}" disabled></td>
					</tr>
					<tr>
						<th>전 카드번호</th>
						<td><input type="text" value="${crd.bf_crd_no}" disabled></td>
						<th>고객번호</th>
						<td><input type="text" value="${crd.cust_no}" disabled></td>
					</tr>
					<tr>
						<th>관리 영업점</th>
						<td><input type="text" value="${crd.mgt_bbrn}" disabled></td>
						<th>최종 카드여부</th>
						<td><input type="text" value="${crd.lst_crd_f eq '1'? '최종':''}" disabled></td>
					</tr>
					<tr>
						<th>최종등록일자</th>
						<td><input type="text" value="${crd.reg_d}" disabled></td>
						<th></th>
						<td></td>
					</tr>
				</table>
          </div>
        </main>
      </div>
    </div>

</body>
</html>