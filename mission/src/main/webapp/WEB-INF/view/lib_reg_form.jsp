<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

</head>
<body>
<h2>등록하기</h2>
<h2>도서정보관리-도서추가</h2>
<form:form commandName="formData" enctype="multipart/form-data">
    <table border="1">
       <tr>
          <td rowspan="6"><img id="image" height="300" width="300"/></td>
       </tr>
       <tr>
           <td>BOOKISBN</td>
           <td><form:input path="bookisbn" /><form:errors path="bookisbn" /> </td>
       </tr>
       <tr>
           <td>도서명</td>
           <td><form:input path="bookname" />
           <form:errors path="bookname" /></td>
        </tr>
        <tr>
            <td>저자</td>
            <td><form:input path="writer" /> 
            <form:errors path="writer" /></td>
         </tr>
         
         <tr>
             <td>출판사</td>
             <td><form:input path="publisher" />
             <form:errors path="publisher" /></td>
         </tr>
         
         <tr>
             <td>도서 가격</td>
             <td><form:input path="money" />
                  <form:errors path="money" /></td>
              
         <tr>
              <td>이미지</td>
              <td><form:input path="image" id="img" type="file" accept="image/*"/>
              <form:errors path="image" />
              </td>
         </tr>
        
         <tr>
              <td>책 소개</td>
              <td><form:textarea path="contents" />
                   <form:errors path="contents" />
               </td>
         </tr>
    
    </table>
	
    <input type="submit" value="제출정보추가" />
    <a href="<c:url value='/list' />"><input type="button" value="도서정보목록"/></a>
</form:form>
  <!--  
    <input type="button" value="도서정보목록" onclick="location.href='<c:url value='/list' />'"/>
-->
    <script>
    document.getElementById("img").onchange=function(){
		var reader = new FileReader();
		reader.onload = function(e){
			document.getElementById("image").src = e.target.result;
		};
		reader.readAsDataURL(this.files[0]);
	};
    </script>

</body>
</html>