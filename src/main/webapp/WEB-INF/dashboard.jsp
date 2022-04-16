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
    
    	<h1 class="text-center">Welcome to the Candy Carnivale</h1>
    	<br>
    	<!-- <a class="btn btn-outline-primary" href ="/dashboard">Dashboard</a> -->
    	<a class="btn btn-outline-primary" href ="/newCandy">Create Candy</a>
 
    	<a class="btn btn-outline-primary" href ="/newOwner">Create Owner</a><br>
    	<!-- <a class="btn btn-outline-primary" href ="/updateCandy">Update Candy</a><br> -->
    	<br>

    	
    	<table class ="table table-dark table-striped table-hover">
    	<thead>
    		<tr>
    			<th class"align-middle">Name</th>
    			<th class"align-middle">Brand</th>
    			<th class"align-middle">Price</th>
    			<th class"align-middle">Rating</th>
    			<th class"align-middle">Owner</th>
    			<th class"align-middle">Action</th>
    		</tr>
    	</thead>
    			<tbody>
    			<c:forEach var="i" items="${allCands}">
    			<tr>
    				<td>
    					<a href="oneCandy/${i.id }">
    				<c:out value="${i.name}"></c:out> 
    				</a>
    				</td>
    				
    				
    				<td> <c:out value="${i.brand}"></c:out> </td>
    				<td> <c:out value="${i.price}"></c:out> </td>
    				<td> <c:out value="${i.rating}"></c:out></td>
    				<td> <c:out value="${i.owner.firstname} ${i.owner.lastname}"></c:out></td>
    				
    				
    				<td>
    				<a class="btn btn-primary" href="/updateCandy/${i.id}"> Update Candy</a>
    				<a class="btn btn-danger" href="/delete/${i.id}">Delete</a>
    			</tr>
    			</c:forEach>
    			</tbody>
    	
    	
    	</table>

    	
    </div> <!-- End of Container -->
</body>
</html>