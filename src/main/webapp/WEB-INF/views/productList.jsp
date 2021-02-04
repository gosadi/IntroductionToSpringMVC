<%-- 
    Document   : productList
    Created on : Feb 4, 2021, 11:44:35 AM
    Author     : alkinoos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <h1>This is my list with products</h1>
        <div>
            <h3>Products</h3>
            <a href="${pageContext.request.contextPath}/product/create">Add product</a>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Description</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfProducts}" var="product">
                    <tr>
                        <td>${product.pcode}</td>
                        <td>${product.pdescr}</td>
                        <td>${product.pprice}</td>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
