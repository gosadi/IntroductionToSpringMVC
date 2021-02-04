<%-- 
    Document   : customerList
    Created on : Feb 3, 2021, 8:04:36 PM
    Author     : alkinoos
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <h1>This is my list with customers</h1>
        <div>
            <h3>Customers</h3>
            <a href="${pageContext.request.contextPath}/customer/create">Add customer</a>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfCustomers}" var = "customer">
                    <tr>
                        <td>${customer.ccode}</td>
                        <td>${customer.cname}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
