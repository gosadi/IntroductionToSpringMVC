<%-- 
    Document   : familyList
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
        <title>Family</title>
    </head>
    <body>
        <div>
            <h3>${message}</h3>
            <a href="${pageContext.request.contextPath}/family/create">Add family</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Relationship</th>
                        <th>Date of Birth</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:forEach items="${family}" var = "member"><!-- edo tsimpame ton family apo tin lista -->
                    <tr>
                        <td>${member.fid}</td>
                        <td>${member.fname}</td>
                        <td>${member.frelationship}</td>
                        <td>${member.dob}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/family/update/${member.fid}">Update</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/family/delete?id=${member.fid}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
