<%-- 
    Document   : salesmanList
    Created on : Feb 10, 2021
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
                        <th>Relationship</th>
                        <th>Date Of Birth</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${listOfFamilies}" var = "families"><!-- edo tsimpame ton salesman apo tin lista -->
                    <tr>
                        <td>${families.fid}</td>
                        <td>${families.fname}</td>
                        <td>${families.frelationship}</td>
                        <td>${families.dob}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/update/${families.fid}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/salesman/delete?id=${families.fid}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
