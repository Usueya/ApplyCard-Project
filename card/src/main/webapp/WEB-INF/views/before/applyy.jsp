<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 입회신청</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script type="text/javascript">
	$(function () {
		
		$('#ssn').on('change', function () {
			var ssn = $('#ssn').val();
			ssn = ssn.substr(0, 6);
			$('#birth_d').val(ssn);
		});
		
		$('#applyBtn').on('click', function () {
			var ssn = $('#ssn').val();
			var ssnlength = $('#ssn').val().length;
			var rcv_d = $('#rcv_d').val();
			var brd = $('#brd').val();
			var appl_clas = $('#appl_clas').val();
			var scrt_no = $('#scrt_no').val();
			var hdp_no = $('#hdp_no').val();
			var birth_d = $('#hdp_no').val();
			
			if(ssnlength < 13){
				alert('주민번호 자릿수 확인');
			}else{
				
	  			$.ajax({
					url: '${path}/unable',
					type: 'post',
					data: {ssn, rcv_d, brd, appl_clas, scrt_no, hdp_no, birth_d},
					datatype: 'json',
					success : function(data) {
						if(data != ''){
							$('#code').val(data.code);
							$('#code_nm').val(data.code_nm);
							alert('불능');
						}else{
							$('#applyForm').submit();
						}
					},
					error: function(err) {
						console.log(err);
						alert('실패');
					}
				});
				
			}

  			
		});
		
		$('#findApply').on('click', function () {
			var ssn = $('#ssn').val();
			var rcv_d = $('#rcv_d').val();
			var rcv_seq_no = $('#rcv_seq_no').val();
			
			if(ssn == ''){
				$('#ssn').focus();
			}else if(rcv_d == ''){
				$('#rcv_d').focus();
			}else if(rcv_seq_no == ''){
				$('#rcv_seq_no').focus();
			}else{
				
	  			$.ajax({
					url: '${path}/findApply',
					type: 'post',
					data: { ssn, rcv_d, rcv_seq_no},
					datatype: 'json',
					success : function(data) {
						if(data != ''){
							$('#appl_d').val(data.appl_d);
							$('#birth_d').val(data.birth_d);
							$('#hg_nm').val(data.hg_nm);
							$('#eng_nm').val(data.eng_nm);
							$('#stl_mtd').val(data.stl_mtd);
							$('#stl_act').val(data.stl_act);
							$('#bnk_cd').val(data.bnk_cd);
							$('#stl_dd').val(data.stl_dd);
							$('#appl_clas').val(data.appl_clas);
							$('#stmt_snd_mtd').val(data.stmt_snd_mtd);
							$('#billadr_adr1').val(data.billadr_adr1);
							$('#billadr_adr2').val(data.billadr_adr2);
							$('#billadr_zip').val(data.billadr_zip);
							$('#hdp_no').val(data.hdp_no);
							$('#brd').val(data.brd);
							$('#scrt_no').val(data.scrt_no);
							$('#email_adr').val(data.email_adr);
							alert('조회완료');
						}else{
							alert('미등록데이터');
						}
					},
					error: function(err) {
						console.log(err);
						alert('실패');
					}
				});
				
			}

			
		});
		
/* 		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		var dateString = year+month+day;
		$('#rcv_d').val(dateString); */
		
	});
</script>
</head>
<body>
	<form id="applyForm" action="${path}/apply" method="post">
		<table style="width: 1000px">
			<tr style="height: 50px">
				<th>주민번호</th>
				<td>
					<input type="text" name="ssn" id="ssn" value="${rcvappl.ssn}" maxlength="13">
				</td>
				<th>접수일자</th>
				<td>
					<input type="text" name="rcv_d" id="rcv_d" value="${rcvappl.rcv_d}" maxlength="8">
				</td>
				<th>접수일련번호</th>
				<td>
					<input type="text" name="rcv_seq_no" id="rcv_seq_no" value="${rcvappl.rcv_seq_no}">
					<button type="button" id="findApply">조회</button>
				</td>
			</tr>
			<tr>
				<th>신청일자</th>
				<td>
					<input type="text" name="appl_d" id="appl_d" value="${rcvappl.appl_d}" maxlength="8">
					<button type="button">...</button>
				</td>
				<th>신청구분</th>
				<td>
					<select name="appl_clas" id="appl_clas">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C007' }">
								<option 
									${rcvappl.appl_clas eq list.code? 'selected':''} 
									value="${list.code}">${list.code_nm}
								</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<th>브랜드</th>
				<td>
					<select name="brd" id = "brd">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C004' }">
								<option 
								${rcvappl.brd eq list.code? 'selected':''} 
								value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>성명(한글)</th>
				<td>
					<input type="text" name="hg_nm" id="hg_nm" value="${rcvappl.hg_nm}">
				</td>
				<th>성명(영문)</th>
				<td>
					<input type="text" name="eng_nm" id="eng_nm" value="${rcvappl.eng_nm}">
				</td>
				<th>생년월일</th>
				<td>
					<input type="text" name="birth_d" id="birth_d" value="${rcvappl.birth_d}">
				</td>
			</tr>
			<tr>
				<th>결제일자</th>
				<td>
					<select name="stl_dd" id="stl_dd">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C009'}">
								<option 
								${rcvappl.stl_dd eq list.code? 'selected':''} 
								value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<th>결제방법</th>
				<td>
					<select name="stl_mtd" id="stl_mtd">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C002'}">
								<option 
									${rcvappl.stl_mtd eq list.code? 'selected':''} 
									value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<th>결제은행</th>
				<td>
					<select name="bnk_cd" id="bnk_cd">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C003'}">
								<option 
									${rcvappl.bnk_cd eq list.code? 'selected':''} 
									value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>결제계좌</th>
				<td>
					<input type="text" name="stl_act" id="stl_act" value="${rcvappl.stl_act}">
					<button type="button">...</button>
				</td>
				<th>결제계좌확인여부</th>
				<td colspan="3">
					<input type="text" 
					style="background-color: grey;"
					size="51"
					disabled>
				</td>
			</tr>
			<tr>
				<th>청구서발송방법</th>
				<td>
					<select name="stmt_snd_mtd" id="stmt_snd_mtd">
						<c:forEach var="list" items="${commCodelist}">
							<c:if test="${list.group_cd eq 'C006'}">
								<option 
									${rcvappl.stmt_snd_mtd eq list.code? 'selected':''} 
									value="${list.code}">${list.code_nm}</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
				<th>우편번호</th>
				<td colspan="3">
					<input type="text" 
					name="billadr_zip"
					id="billadr_zip"
					value="${rcvappl.billadr_zip}"
					maxlength="5">
					<button type="button">...</button>
					<input type="text" 
					name="billadr_adr1"
					id="billadr_adr1"
					style="background-color: grey;" 
					disabled
					value="${rcvappl.billadr_adr1}">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right"></td>
				<td colspan="4" align="left">
					<input type="text" 
					name="billadr_adr2"
					id="billadr_adr2"
					value="${rcvappl.billadr_adr2}"
					size="51">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email_adr" id="email_adr" value="${rcvappl.email_adr }">
				</td>
				<th>핸드폰번호</th>
				<td>
					<input type="text" name="hdp_no" id="hdp_no" maxlength="11" value="${rcvappl.hdp_no }">
				</td>
				<th>비밀번호</th>
				<td>
					<input type="text" name="scrt_no" id="scrt_no" maxlength="8" value="${rcvappl.scrt_no }">
				</td>
			</tr>
			<tr>
				<th>불능구분</th>
				<td>
					<input type="text" 
					name="impsb_clas"
					id="code"
					style="background-color: grey;
						   color: white;" 
					readonly="readonly">
				</td>
				<th>불능사유명</th>
				<td colspan="3">
					<input type="text" 
					id="code_nm"
					style="background-color: grey;
						  color: white;" 
					readonly="readonly">
				</td>
			</tr>
		</table>
		<p align="center" style="width: 100%">
			<button type="button" id="applyBtn">등록</button>
			<button type="button" id="updateBtn">수정</button>
			<button type="reset">초기화</button>
		</p>
	</form>
</body>
</html>