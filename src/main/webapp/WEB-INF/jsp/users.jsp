<%-- 
    Document   : users
    Created on : Jun 4, 2013, 9:16:45 PM
    Author     : rol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../jspf/import.jspf"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../jspf/jquery.jspf" %>
        <style type="text/css">
            .tableHeader {font-weight: bold;}
        </style>
    </head>
    <body>
        <c:if test="${not empty users}">
            <table border="0" cellpadding="5" cellspacing="0">
                <tr class="tableHeader">
                    <td>
                        User name
                    </td>
                    <td>
                        Status
                    </td>
                    <td>
                        Priority
                    </td>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>
                            <c:out value="${user.name}"/>
                        </td>
                        <td>
                            <c:out value="${user.status.name}"/>
                        </td>
                        <td>
                            <c:out value="${user.priority}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
