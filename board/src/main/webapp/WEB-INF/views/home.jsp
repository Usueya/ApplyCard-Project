<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Join</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${path}/resources/assets/css/tailwind.output.css" />
    <script
      src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"
      defer
    ></script>
    <script src="${path}/resources/assets/js/init-alpine.js"></script>
    <script type="text/javascript">
		$(function () {
			
			//join버튼클릭(필수값체크)
			$('#join').on('click', function () {
				var userId = $('#userId').val();
				var idCheckYN = $('#idCheckYN').val();
				var userPw = $('#userPw').val();
				var pwCheck = $('#pwCheck').val();
				var userName = $('#userName').val();
				var userPhone2 = $('#userPhone2').val();
				var userPhone3 = $('#userPhone3').val();
				
				if(userId ==''){
					alert('아이디를 입력하세요');
				}else if(idCheckYN == 'N'){
					alert('아이디 중복확인을 하세요.');
				}else if(userPw == ''){
					alert('비밀번호를 입력하세요');
				}else if(userPw != pwCheck){
					alert('입력한 비밀번호가 일치하지 않습니다.');
				}else if(userName == ''){
					alert("이름을 입력하세요.");
				}else if(userPhone2 ==''){
					alert('연락처를 입력하세요');
					$('#userPhone2').focus();
				}else if(userPhone3 ==''){
					alert('연락처를 입력하세요');
					$('#userPhone3').focus();
				}else{
					$('#joinForm').submit();
				}
				
			});
			
			
			$('#userAddr1').on('change', function () {
				
			});
			
			
			//중복확인버튼클릭
			$('#idCheck').on('click', function () {
				var userId = $('#userId').val();
				console.log(userId);
				
				if(userId == ''){
					alert('아이디를 입력해주세요');
					$('#userId').focus();
				}else{
					$.ajax({
						url:'${path}/userinfo/idCheck/'+userId,
						type:'get',
						dataType:'text',
						success : function (data) {
							$('#idCheckYN').val(data);
							if(data == 'Y'){
								alert("사용가능한 ID");
							}else{
								alert("중복된 ID");
							}
						},
						error: function (err) {
							console.log(err);
							alert('실패');
						}
					});
				}
			});
			
			
			//아이디변경시 중복확인
			$('#userId').change(function() {
				$('#idCheckYN').val('N');
			});
			
			
			
		});
		
	</script>
  </head>
  
  <body>
  <form id="joinForm" action="${path}/userinfo/join" method="post">
    <div class="flex items-center min-h-screen p-6 bg-gray-50 dark:bg-gray-900">
      <div
        class="flex-1 h-full max-w-4xl mx-auto overflow-hidden bg-white rounded-lg shadow-xl dark:bg-gray-800"
      >
        <div class="flex flex-col overflow-y-auto md:flex-row">
          <div class="h-32 md:h-auto md:w-1/2">
            <img
              aria-hidden="true"
              class="object-cover w-full h-full dark:hidden"
              src="${path}/resources/assets/img/create-account-office.jpeg"
              alt="Office"
            />
            <img
              aria-hidden="true"
              class="hidden object-cover w-full h-full dark:block"
              src="${path}/resource/assets/img/create-account-office-dark.jpeg"
              alt="Office"
            />
          </div>
          <div class="flex items-center justify-center p-6 sm:p-12 md:w-1/2">
            <div class="w-full">
              <h1
                class="mb-4 text-xl font-semibold text-gray-700 dark:text-gray-200"
              >
                Create account
              </h1>
              
              <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">
	                ID
	                <button 
	                style="margin-left: 70%"
	                class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
	                type="button" name="idCheck" id="idCheck">중복확인</button>
                </span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="userId" 
                  id="userId"
                />
                <input type="hidden" name="idCheckYN" id="idCheckYN" value="N">
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">Password</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="password"
                  name="userPw" 
                  id="userPw"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">
                  Confirm password
                </span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="password"
                  name="pwCheck" 
                  id="pwCheck"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">name</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="text"
                   name="userName" id="userName"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">phone</span>
                <br>
				<select name="userPhone1">
						<!-- COM_CODE PHONE -->
 						<c:forEach var="list" items="${comCodeList}">
							<option value="${list.codeId}">${list.codeName}</option>
						</c:forEach>
					</select>
					-
					<input
					 maxlength="4" type="text" name="userPhone2" id="userPhone2" size="10">
					-
					<input maxlength="4" type="text" name="userPhone3" id="userPhone3" size="10">
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">postNo</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="text"
                  maxlength="5" name="userAddr1" id="userAddr1"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">address</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="password"
                  name="userAddr2" id="userAddr2"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">company</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  type="password"
                   name="userCompany" id="userCompany"
                />
              </label>

              <a
                class="block w-full px-4 py-2 mt-4 text-sm font-medium leading-5 text-center text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                id="join"
              >
                Create account
              </a>

            </div>
          </div>
        </div>
      </div>
    </div>
   </form>
  </body>
</html>
