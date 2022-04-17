<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Date"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Full CRUD</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
      
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    	<h1>Create Ninja!</h1>
    	<br>
    		  	<a class="btn btn-outline-primary" href ="/dashboard">Dashboard</a> <br>
    		  	<br>
    	
    	
    
    	  

<form:form action="/processNinja" method="post" modelAttribute="ninja">

		<form:label path="dojo">Location:</form:label>
     	 <form:select path="dojo">
    	<c:forEach var="i" items="${allDojos}">
    		
			<form:option value="${i.id }">${i.name}</form:option> 
    	</c:forEach>
    	
    </form:select>
    
    <p>
        <form:label path="firstname">First Name:</form:label>
        <form:errors class="alert-danger" path="firstname"/>
        <form:input path="firstname"/>
    </p>
     <p>
        <form:label path="lastname">Last Name:</form:label>
        <form:errors class="alert-danger" path="lastname"/>
        <form:input path="lastname"/>
    </p>
    <p>
        <form:label path="age">Age:</form:label>
        <form:errors class="alert-danger" path="age"/>
        <form:input type="number" path="age"/>
    </p>
     
    	

    	

    <input type="submit" value="Create"/>
</form:form>    

    	
    	
    	

    	
    </div> <!-- End of Container -->
</body>
</html>