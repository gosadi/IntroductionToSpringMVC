<%-- 
    Document   : salesmanList
    Created on : Feb 3, 2021, 8:04:36 PM
    Author     : alkinoos
--%>


<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/style.css" var="styleCSS" />
        <link href="${styleCSS}" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman</title>
    </head>
    <body>
        <h1>This is my list with salesmen</h1>
        <div>
            <h3>Salesmen</h3>
            <p>${message}</p>
            <a href="${pageContext.request.contextPath}/salesman/create">Add salesman</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfSalesmen}" var = "salesman"><!-- edo tsimpame ton salesman apo tin lista -->
                    <tr>
                        <td>${salesman.scode}</td>
                        <td>${salesman.sname}</td>
                        <td>${salesman.scity}</td>
                        <td>${salesman.scomm}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/delete?id=${salesman.scode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
