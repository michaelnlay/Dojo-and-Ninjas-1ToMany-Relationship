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
    	<h1>Change Ninja</h1>
    	<br>
    		<a href ="/dashboard">Dashboard</a>
    		
<h4>MAKE CHANGE TO ${ninja.firstname} in the Form: Form Below! }</h4> 
    		
<form:form action="/updatingNinja/${ninja.id}" method="post" modelAttribute="ninja">
<input type="hidden" name="_method" value="put"/>
    <p>
        <form:label path="firstname">First Name</form:label>
        <form:errors class="alert-danger" path="firstname"/>
        <form:input path="firstname"/>
    </p>
    
      <p>
        <form:label path="lastname">Last Name</form:label>
        <form:errors class="alert-danger" path="lastname"/>
        <form:input path="lastname"/>
    </p>
   
    <p>
        <form:label path="age">Age</form:label>
        <form:errors class="alert-danger" path="age"/>
        <form:input type="number" path="age"/>
    </p>
   
    <input type="submit" value="Update"/>
</form:form>  
    	
    </div> <!-- End of Container -->
</body>
</html>