<%-- 
    Document   : createContact
    Created on : Apr 17, 2013, 3:20:01 PM
    Author     : Rolan Burykin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form method="POST" commandName="contact" action="/createContact">
            <table>
                <tr>
                    <td>
                        <form:label path="name">User name:</form:label>
                        <form:input path="name"/>
                        <form:errors path="name" cssStyle="color:red;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="address">Address:</form:label>
                        <form:input path="address"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Create"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
