<%-- 
    Document   : showContacts
    Created on : Apr 18, 2013, 9:12:50 AM
    Author     : Rolan Burykin
--%>

<%@include file="../fragments/import.jspf"%>
<html>
    <c:set var="title" value="title.contactsList" />
    <%@include file="../fragments/header.jspf" %>
    <spring:url value="/contacts" var="contactsRoot"/>
    <spring:url value="/users" var="usersRoot"/>
    <body>
        <c:choose>
            <c:when test="${not empty contacts}">                
                <table border="0" cellpadding="5" cellspacing="0">
                    <tr class="tableHeader">
                        <td>
                            <spring:message code="contacts.number"/>
                        </td>
                        <td>
                            <spring:message code="contacts.userName"/>
                        </td>
                        <td>
                            <spring:message code="contacts.address"/>
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
                            <td><a href="${contactsRoot}/contactDetail?id=<c:out value="${contact.id}"/>"><spring:message code="button.edit"/></a></td>
                            <td><a href="${contactsRoot}/deleteContact?id=<c:out value="${contact.id}"/>"><spring:message code="button.delete"/></a></td>
                        </tr>                        
                    </c:forEach>            
                </table>
            </c:when>
            <c:otherwise>                
                <div class="title"><spring:message code="contacts.msgEmptyList"/></div>
            </c:otherwise>
        </c:choose>
        
        <a href="${contactsRoot}/contactDetail"><spring:message code="button.addContact"/></a>
        <a href="${usersRoot}/showUsers"><spring:message code="button.showUsers"/></a>
</body>
</html>