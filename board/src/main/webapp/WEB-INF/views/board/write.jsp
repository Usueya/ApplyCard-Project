<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html :class="{ 'theme-dark': dark }" x-data="data()" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Write</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="${path}/resources/assets/css/tailwind.output.css" />
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer ></script>
    <script src="${path}/resources/assets/js/init-alpine.js"></script>
    <script type="text/javascript">
		$(function () {
			
			$('#write').on('click', function () {
				$('#writeForm').submit();
			});
			
		});
    </script>
    
  </head>
  
  <body>
    <div class="flex h-screen bg-gray-50 dark:bg-gray-900" :class="{ 'overflow-hidden': isSideMenuOpen}" >
      <div class="flex flex-col flex-1 w-full">
        <main class="h-full pb-16 overflow-y-auto">
          <div class="container grid px-6 mx-auto">
            <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200" >
              Board Write
            </h2>
            
            <div class="w-full overflow-hidden rounded-lg shadow-xs">
              <div class="w-full overflow-x-auto">
              <form id="writeForm" action="${path}/board/write" method="post">
                <table class="w-full whitespace-no-wrap">
                	<tr>
						<th colspan="2" align="right">
						 <div>
			                <button 
			                  type="button" id="write"
			                   class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                			>
			                작성
			                </button>
			                <button 
			                   class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                			>
			                행추가
			                </button>
			              </div>
						</th>
					</tr>
					
					<tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                      
                      <th style="width: 100px" class="px-4 py-3">Type</th>
                      <td class="px-4 py-3 text-sm">
						<!-- com_code -->
						<select name="boardType">
							<c:forEach var="list" items="${comCodeList}">
								<option value="${list.codeId}">${list.codeName}</option>
							</c:forEach>
						</select>
                      </td>
                    </tr>
					
                    <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                      <th style="width: 100px" class="px-4 py-3">Title</th>
                      <td class="px-4 py-3 text-sm">
					    <input type="text" name="boardTitle">
                      </td>
                    </tr>
                    
                    <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                      <th class="px-4 py-3">Comment</th>
                      <td style="height: 300px" class="px-4 py-3 text-sm">
                      	<textarea rows="20" cols="100%" name="boardComment"></textarea>
                      </td>
                    </tr>
                    
                    <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                      <th class="px-4 py-3">Writer</th>
                      <td class="px-4 py-3 text-sm">
                      	<input type="text" name="creator" value="${sessionScope.userId}" readonly>
                      </td>
                    </tr>
                  
                </table>
               </form> 
              </div>
              <div class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800">
                <span class="flex items-center col-span-3">
                </span>
                <span class="col-span-2"></span>
                <!-- Pagination -->
                <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
                  <nav aria-label="Table navigation">
                    <ul class="inline-flex items-center">
                      <li>
                      	<a href="${path}/board/list">List</a>
                      </li>
                    </ul>
                  </nav>
                </span>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
  </body>
</html>
