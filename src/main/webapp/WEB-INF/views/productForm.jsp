<%-- 
    Document   : productForm
    Created on : Feb 4, 2021, 12:11:24 PM
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
        <h1>create your own product</h1>
        <c:if test="${productToEdit==null}">
            <c:url value="/product/create" var="link"/>
        </c:if>
        <c:if test="${productToEdit!=null}">
            <c:url value="/product/update" var="link"/>
        </c:if>
        <form action="${link}" method="POST">
            <label for="pcode">Code:</label>
            <input id="pcode" type="number" name="pcode" value="${productToEdit.pcode}" readonly>
            <br>
            <label for="pdescr">Description:</label>
            <input id="pdescr" type="text" name="pdescr" value="${productToEdit.pdescr}">
            <br>
            <label  for="pprice" >Price:</label>
            <input id="pprice" type="number" name="pprice" step="0.1" value="${productToEdit.pprice}">
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
