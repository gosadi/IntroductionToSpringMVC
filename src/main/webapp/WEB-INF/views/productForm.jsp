<%-- 
    Document   : productForm
    Created on : Feb 4, 2021, 12:11:24 PM
    Author     : alkinoos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create Page</title>
    </head>
    <body>
        <h1>create your own product</h1>
        <form action="${pageContext.request.contextPath}/product/create" method="POST">
            <label for="pcode">Code:</label>
            <input id="pcode" type="number" name="pcode">
            <br>
            <label for="pdescr">Description:</label>
            <input id="pdescr" type="text" name="pdescr">
            <br>
            <label  for="pprice" >Price:</label>
            <input id="pprice" type="number" name="pprice" step="0.1">
            <br>
            
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
