<%-- 
    Document   : showContacts
    Created on : Apr 18, 2013, 9:12:50 AM
    Author     : Rolan Burykin
--%>

<%@include file="../fragments/import.jspf"%>
<html>
    <c:set var="title" value="viewContacts.title" />
    <%@include file="../fragments/header.jspf" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery_custom.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />" />

    <body>
        <c:choose>
            <c:when test="${not empty contacts}">                
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
                            <td><a href="contactDetail?id=<c:out value="${contact.id}"/>"><spring:message code="button.edit"/></a></td>
                            <td><a href="deleteContact?id=<c:out value="${contact.id}"/>"><spring:message code="button.delete"/></a></td>
                        </tr>                        
                    </c:forEach>            
                </table>
            </c:when>
            <c:otherwise>
                <div class="title">Contacts data is empty</div>
            </c:otherwise>
        </c:choose>
        <a href="contactDetail">Add contact</a>
        <a href="showUsers">Show users</a>
</body>
</html>