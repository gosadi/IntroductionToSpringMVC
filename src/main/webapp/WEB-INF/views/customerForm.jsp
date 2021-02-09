<%-- 
    Document   : customerForm
    Created on : Feb 3, 2021, 8:42:14 PM
    Author     : alkinoos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create Page</title>
    </head>
    <body>
        <c:if test="${customerToEdit==null}">
            <c:url value="/customer/create" var="link"/>
            <c:set value="Create your customer" var="UpdateOrCreate"></c:set>   
        </c:if>
        <c:if test="${customerToEdit!=null}">
            <c:url value="/customer/update" var="link"/>
            <c:set value="Update your customer" var="UpdateOrCreate"></c:set>
        </c:if>
        <h1>${UpdateOrCreate}</h1>
        <form action="${link}" method="POST">
            <label for="ccode">Code:</label>
                <input id="ccode" type="number" name="ccode" value="${customerToEdit.ccode}" readonly/>
            <br>
            <label for="cname">Name:</label>
                <input  id="cname" type="text" name="cname" value="${customerToEdit.cname}"/>
            <br>
            <input type="submit" value="Submit"/>
        </form>
            
    </body>
</html>
