<%-- 
    Document   : users
    Created on : Jun 4, 2013, 9:16:45 PM
    Author     : rol
--%>

<%@include file="../fragments/import.jspf"%>
<html>
    <c:set var="title" value="viewUsers.title" />
    <%@include file="../fragments/header.jspf" %>
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
                <tr>
                    <td>
                        <a href="viewAllContacts">Return</a>
                    </td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
