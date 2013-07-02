<%@include file="../fragments/import.jspf"%>
<html>
    <c:choose>
        <c:when test="${not empty param.id}">
            <c:set var="title" value="title.updateContact" />
        </c:when>
        <c:otherwise>
            <c:set var="title" value="title.createContact" />
        </c:otherwise>
    </c:choose>
    <%@include file="../fragments/header.jspf" %>
    <body>
        <form:form method="POST" commandName="contact" action="/contacts/contactDetail">
            <form:hidden path="id"/>
            <table border="0">
                <tr>
                    <td colspan="3" class="title"><spring:message code="contacts.detail.dataTitle"/></td>
                </tr>
                <tr>                    
                    <td>
                        <form:label path="name"><spring:message code="contacts.detail.userName"/></form:label>
                        </td>
                        <td>
                        <form:input path="name"/>
                    </td>
                    <td>
                        <form:errors path="name" cssStyle="color:red;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="address"><spring:message code="contacts.detail.address"/></form:label>
                        </td>
                        <td>
                        <form:input path="address"/>
                    </td>
                    <td>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" >
                        <table border="0" style="position:relative; left:-5px;"> 
                            <tr>
                                <td>
                                    <input class="ui-button-text" type="submit" value="<spring:message code="button.save"/>"/>
                                </td>                
                                <td>
                                    <a href="viewAllContacts"><spring:message code="button.return"/></a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form:form>        
    </body>
</html>
