<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/scripts.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <title>Rising Sun</title>
  </head>
  <body>
  
    <div class="flex h-screen bg-gray-50 dark:bg-gray-900" :class="{ 'overflow-hidden': isSideMenuOpen }">
      <%@ include file="./include/sidebar.jsp" %>
      
      <div class="flex flex-col flex-1 w-full">
      <%@ include file="./include/header.jsp" %>
        <main class="h-full overflow-y-auto">
          <div class="container px-6 mx-auto grid">
            <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" > Home </h2>
            <img style="width: 1300px; height: 500px;" alt="" src="${path}/resources/image/credit-cards.jpg">
          </div>
        </main>
      </div>
    </div>
    
  </body>
</html>