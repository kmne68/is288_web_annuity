<%-- 
    Document   : AnnuitySchedule
    Created on : Sep 19, 2017, 9:32:14 PM
    Author     : Keith Emery
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--%@page import="business.*"%-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Schedule</title>
    </head>
    <body>
        <h1>Annuity Schedule</h1>
        <table border="1">
            <tr>
                <th>Month</th>
                <th>Beginning Balance</th>
                <th>Deposit</th>
                <th>Interest Earned</th>
                <th>Ending Balance</th>
            </tr>
            <c:forEach var="anmo" items="${annuity.months}">
                <tr>
                    <td align="right">${anmo.month}</td>
                    <td align="right">${anmo.bbal}}</td>
                    <td align="right">${anmo.deposit}</td>
                    <td align="right">${anmo.iearn}</td>
                    <td align="right">${anmo.ebal}</td>
                </tr>
            </c:forEach>
            
        </table>
        <br>
    </body>
</html>
