<%-- 
    Document   : salesmanForm
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
        <c:if test="${salesmanToEdit==null}">
            <c:url value="/salesman/create" var="link"/>
            <c:set value="Create your salesman" var="UpdateOrCreate"></c:set>   
        </c:if>
        <c:if test="${salesmanToEdit!=null}">
            <c:url value="/salesman/update" var="link"/>
            <c:set value="Update your salesman" var="UpdateOrCreate"></c:set>
        </c:if>
        <h1>${UpdateOrCreate}</h1>
        <form action="${link}" method="POST">
            <label for="scode">Code:</label>
            <input id="scode" type="number" name="scode" value="${salesmanToEdit.scode}" readonly/>
            <br>
            <label for="sname">Name:</label>
            <input  id="sname" type="text" name="sname" value="${salesmanToEdit.sname}"/>
            <br>
            <label for="scity">City:</label>
            <select id="scity" name="scity" value="${salesmanToEdit.scity}">
                <c:forEach items="${listOfCities}" var="city">
                    <option value="${city}">${city}</option>
                </c:forEach>
            </select>
            <br>
            <label for="scomm">Commission:</label>
            <input  id="scomm" type="number" step= "0.01" name="scomm" value="${salesmanToEdit.scomm}"/>
            <br>
            <input type="submit" value="Submit"/>
        </form>

    </body>
</html>
