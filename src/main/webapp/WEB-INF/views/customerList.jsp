<%-- 
    Document   : customerList
    Created on : Feb 3, 2021, 8:04:36 PM
    Author     : alkinoos
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/style.css" var="styleCSS" />
        <link href="${styleCSS}" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <h1>This is my list with customers</h1>
        <div>
            <h3>Customers</h3>
            <p>${message}</p>
            <a href="${pageContext.request.contextPath}/customer/create">Add customer</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfCustomers}" var = "customer">
                    <tr>
                        <td>${customer.ccode}</td>
                        <td>${customer.cname}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/customer/update/${customer.ccode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/customer/delete?id=${customer.ccode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
