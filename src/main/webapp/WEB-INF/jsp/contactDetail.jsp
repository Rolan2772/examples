<%-- 
Document   : createContact
Created on : Apr 17, 2013, 3:20:01 PM
Author     : Rolan Burykin
--%>

<%@include file="../fragments/import.jspf"%>
<html>
    <c:set var="title" value="update.title" />
    <%@include file="../fragments/header.jspf" %>
    <body>
        <form:form method="POST" commandName="contact" action="/contactDetail">
            <form:hidden path="id"/>
            <table border="0">
                <tr>
                    <td colspan="3" class="title">Contact data:</td>
                </tr>
                <tr>                    
                    <td>
                        <form:label path="name">User name:</form:label>
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
                        <form:label path="address">Address:</form:label>
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
                                    <input class="ui-button-text" type="submit" value="Save"/>
                                </td>                
                                <td>
                                    <a href="viewAllContacts">Return</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form:form>        
    </body>
</html>
