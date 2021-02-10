<%-- 
    Document   : familyForm
    Created on : Feb 3, 2021, 8:42:14 PM
    Author     : alkinoos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create Page</title>
    </head>
    <body>
        <c:if test="${family==null}">
            <c:url value="/family/create" var="link"/>
            <c:set value="Create your family" var="UpdateOrCreate"></c:set>   
        </c:if>
        <c:if test="${family!=null}">
            <c:url value="/family/update" var="link"/>
            <c:set value="Update your family" var="UpdateOrCreate"></c:set>
        </c:if>
        <h1>${UpdateOrCreate}</h1>
        <form:form action="${link}" method="POST" modelAttribute="family">
            <form:hidden path="fid" />
            <br>
            <label for="fname">Name:</label>
            <form:input  id="fname" path="fname" />
            <form:errors path="fname"></form:errors>
            <br>
            <label for="frelationship">Relationship:</label>
            <form:select id="scity" path="scity">
                <c:forEach items="${listOfCities}" var="city">
                    <form:option value="${city}">${city}</form:option>
                </c:forEach>
            </form:select>
            <br>
            <label for="scomm">Commission:</label>
            <form:input  id="scomm" type="number" step= "0.01" path="scomm" />
            <form:errors path="scomm"></form:errors>
            <br>
            <input type="submit" value="Submit"/>
        </form:form>

    </body>
</html>
