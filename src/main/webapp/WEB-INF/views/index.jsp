<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:form="http://java.sun.com/jsf/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Person Manager</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>personId</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        <c:forEach items="${listPerson}" var="person">
            <tr>
                <td>${person.personId}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.age}</td>
                <td>
                    <a href="/edit?id=${person.personId}">Edit</a>

                    <a href="/delete?id=${person.personId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3><a href="/newPerson">New Person</a></h3>
</div>
</body>
</html>
