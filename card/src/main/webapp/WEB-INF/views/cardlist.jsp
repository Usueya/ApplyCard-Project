<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/scripts.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
<head>
<meta charset="UTF-8">
<title>소지 카드 내역조회</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
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
		$('#findCustCard').on('click', function () {
			var ssn = $('#ssn').val();
			var crd_no = $('#crd_no').val();
			
			if(ssn == ''){
				alert('주민번호를 입력하세요.');
				$('#ssn').focus();
			}else{
				$('#findCustCardForm').submit();
			}
			
		});
		
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
            <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" > 소지 카드 내역조회 </h2>
            
            	<form id="findCustCardForm" action="${path}/cardlist" method="get"  style="margin-bottom: 30px;">
            		<table>
            			<tr>
            				<th style="padding-right: 20px;">주민번호</th>
            				<td style="padding-right: 20px;"><input type="text" name="ssn" id="ssn" value="${cust.SSN}"></td>
            				<th style="padding-right: 20px;">카드번호</th>
            				<td style="padding-right: 20px;"><input type="text" name="crd_no" id="crd_no" value="${cust.CRD_NO}"></td>
            				<td style="padding-right: 20px;">
            					<button 
            					class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
            					type="button" id="findCustCard">조회</button>
           					</td>
            			</tr>
            		</table>
				</form>
				<hr>
				
				<table class="w-full whitespace-no-wrap" > 
					<tr align="left"><th colspan="6">조회</th></tr>
					<tr>
						<th>성명(한글)</th>
						<td><input type="text" name="hg_nm" value="${cust.HG_NM}" disabled></td>
						<th>핸드폰 번호</th>
						<td><input type="text" name="hdp_no" value="${cust.HDP_NO}" disabled></td>
						<th>등록일자</th>
						<td><input type="text" name="reg_d" value="${cust.REG_D}" disabled></td>
					</tr>
					<tr>
						<th>결제방법</th>
						<td><input type="text" value="${cust.STL_NM}"  disabled></td>
						<th>결제은행</th>
						<td><input type="text" value="${cust.BNK_NM}"  disabled></td>
						<th>결제계좌</th>
						<td><input type="text" value="${cust.STL_ACT}"  disabled></td>
					</tr>
					<tr>
						<th>결제일자</th>
						<td><input type="text" name="" value="${cust.STL_DD_NM}" disabled></td>
						<th>청구서발송방법</th>
						<td><input type="text" name="" value="${cust.STL_NM}" disabled></td>
						<th>E-MAIL</th>
						<td><input type="text" name="" value="${cust.EMAIL_ADR}" disabled></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td colspan="5">
							<input type="text" name="" value="${cust.BILL_ZIP}" disabled>
							<input type="text" name="" value="${cust.BILL_ADR1}" disabled>
							<input type="text" name="" value="${cust.BILL_ADR2}" disabled>
						</td>
					</tr>
				</table>
				<hr>
				
				<table border="1" style="text-align: center; margin-top: 30px;" class="w-full whitespace-no-wrap" >
					<tr>
						<th>*</th>
						<th>카드번호</th>
						<th>성명(영문)</th>
						<th>유효기간</th>
						<th>브랜드</th>
						<th>카드등급</th>
						<th>발행일자</th>
						<th>전카드번호</th>
						<th>최종카드여부</th>
						<th>관리영업점</th>
					</tr>
					<c:forEach var="list" items="${crdlist}">
						<tr>
							<td style="width: 40px;">
								<a 
								href="${path}/carddetail?crd_no=${list.crd_no}&ssn=${cust.SSN}">
								<i class="fas fa-search"></i>
								</a>
							</td>
							<td>${list.crd_no}</td>
							<td>${list.eng_nm}</td>
							<td>${list.vld_dur}</td>
							<td>${list.brd_nm}</td>
							<td>${list.grd_nm}</td>
							<td>${list.reg_d}</td>
							<td>${list.bf_crd_no}</td>
							<td>${list.lst_crd_f eq '1'? '최종':''}</td>
							<td>${list.mgt_bbrn}</td>
						</tr>
					</c:forEach>
				</table>
            
          </div>
        </main>
      </div>
    </div>



</body>
</html>