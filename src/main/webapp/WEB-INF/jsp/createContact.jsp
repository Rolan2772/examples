<%-- 
Document   : createContact
Created on : Apr 17, 2013, 3:20:01 PM
Author     : Rolan Burykin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="createContact.title"/></title>
        <%@include file="../jspf/jQueryImport.jspf" %>
        <script>
            $(function() {
                $("input[type=submit]")
                        .button()
                        .click(function(event) {
                    event.preventDefault();
                });
            });
            $(function() {
                $("#progressbar").progressbar({
                    value: 37
                });
            });            
            </script>
    </head>
    <body>        
        <form:form method="POST" commandName="contact" action="/createContact">            
            <table>
                <tr>
                    <td colspan="10"><h2>Contact data:</h2></td>
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
                    <td>
                        <input type="submit" value="Create"/>
                    </td>
                </tr>
            </table>
        </form:form>
        <a href="viewAllContacts">return</a>
        <div id="progressbar"></div>
    </body>
</html>
