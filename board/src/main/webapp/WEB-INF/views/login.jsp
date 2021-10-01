<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/include.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
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
			$('#login').on('click', function () {
				var userId = $('#userId').val();
				var userPw = $('#userPw').val();
				if(userId == ''){
					alert('아이디를 입력하세요.');
					$('#userId').focus();
				}else if(userPw == ''){
					alert('비밀번호를 입력하세요.');
					$('#userPw').focus();
				}else{
					$('#loginForm').submit();
				}
			});
			if('${msg}' != ''){
				alert('${msg}');
			}
		});
	</script>
  </head>
  
  
  
  <body>
  <form id="loginForm" action="${path}/login" method="post">
    <div class="flex items-center min-h-screen p-6 bg-gray-50 dark:bg-gray-900">
      <div
        class="flex-1 h-full max-w-4xl mx-auto overflow-hidden bg-white rounded-lg shadow-xl dark:bg-gray-800"
      >
        <div class="flex flex-col overflow-y-auto md:flex-row">
          <div class="h-32 md:h-auto md:w-1/2">
            <img
              aria-hidden="true"
              class="object-cover w-full h-full dark:hidden"
              src="${path}/resources/assets/img/login-office.jpeg"
              alt="Office"
            />
            <img
              aria-hidden="true"
              class="hidden object-cover w-full h-full dark:block"
              src="${path}/resources/assets/img/login-office-dark.jpeg"
              alt="Office"
            />
          </div>
          
          
          <div class="flex items-center justify-center p-6 sm:p-12 md:w-1/2">
            <div class="w-full">
              <h1
                class="mb-4 text-xl font-semibold text-gray-700 dark:text-gray-200"
              >
                Login
              </h1>
              
              <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">ID</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  placeholder="Jane Doe"
                  id="userId"
                  name="userId"
                />
              </label>
              
              <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">Password</span>
                <input
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  placeholder="***************"
                  type="password"
                  id="userPw"
                  name="userPw"
                />
              </label>

              <!-- You should use a button here, as the anchor is only used for the example  -->
              <a
                class="block w-full px-4 py-2 mt-4 text-sm font-medium leading-5 text-center text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                id="login"
              >
                Log in
              </a>

            </div>
          </div>
        </div>
      </div>
    </div>
  </form>  
  </body>
</html>
