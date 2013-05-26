<%-- 
    Document   : showContacts
    Created on : Apr 18, 2013, 9:12:50 AM
    Author     : Rolan Burykin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../jspf/import.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="viewContacts.title"/></title>
        <style type="text/css">
            .tableHeader {font-weight: bold;}
        </style>
        <%@include file="../jspf/jQueryImport.jspf" %>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty contacts}">
                <h2>Contacts data: </h2>
                <table border="0" cellpadding="5" cellspacing="0">            
                    <tr class="tableHeader">
                        <td>
                            Number
                        </td>
                        <td>
                            User name
                        </td>
                        <td>
                            Address
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach var="contact" items="${contacts}" varStatus="index">
                        <tr>
                            <td>
                                <c:out value="${index.index  + 1}"/>
                            </td>
                            <td>
                                <c:out value="${contact.name}"/>
                            </td>
                            <td>
                                <c:out value="${contact.address}"/>
                            </td>
                            <td><a href="updateContact?id=<c:out value="${contact.id}"/>">update</a></td>
                            <td><a href="deleteContact?id=<c:out value="${contact.id}"/>">delete</a></td>
                        </tr>
                    </c:forEach>            
                </table>
            </c:when>
            <c:otherwise>
                <h2>Contacts data is empty</h2> 
            </c:otherwise>
        </c:choose>
        <a href="createContact">Add contact</a>
    </body>
</html>