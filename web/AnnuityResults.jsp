<%-- 
    Document   : AnnuityResults
    Created on : Sep 19, 2017, 9:10:14 PM
    Author     : Keith Emery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--%@page import="java.text.NumberFormat" %-->

<!-- added for formatting -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!--jsp:useBean id="annuity" scope="session" class="business.Annuity"/-->
<!--jsp:useBean id="currency" scope="session" class="business.Currency"/-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Result</title>
    </head>
    <body>

        <h1>Annuity Results:</h1>
        <p>An annuity with total deposits of:
            <fmt:formatNumber value="${annuity.totalDeposit}" type="currency"/>
            <!--jsp:getProperty name="annuity" property="totalDeposit" /-->
            each month, <br>
            with 
            <fmt:formatNumber value="${annuity.depositEarly}" type="currency"/>
            <!--jsp:getProperty name="annuity" property="depositEarly" /-->
             deposited at the beginning of the month, and 
            <fmt:formatNumber value="${annuity.depositLate}" type="currency"/>
            <!--jsp:getProperty name="annuity" property="depositLate" /-->
             deposited at the end of each month;
            <br>
            and earning  
            <fmt:formatNumber value="${annuity.rate}" type="percent" maxIntegerDigits="3"/>
            <!--jsp:getProperty name="annuity" property="rate" /-->
             per year for 
            ${annuity.term}
            <!--jsp:getProperty name="annuity" property="term" /-->
            months <br>
            Will have a final value of:
            <fmt:formatNumber value="${annuity.finalValue}" type="currency"/>
            <!--jsp:getProperty name = "annuity" property="finalValue" /-->
            at the end of the term<br>

            Including
            <fmt:formatNumber value="${annuity.totalInt}" type="currency"/>
            <!--jsp:getProperty name = "annuity" property="totalInt" /-->
            of interest earned.
        </p>

        <p>
            <fmt:setLocale value = "en_US"/>
            <fmt:formatNumber value = "${balance}" type = "currency"/>
        </p>
        <br>
        <form action="AnnuitySchedule.jsp" method="post">
            <input type="submit" value="Schedule">
        </form>
        <!--%
            HttpSession sess = request.getSession();
            sess.removeAttribute("annuity");
        %-->
        <br>
        <form action="AnnuityInput.jsp" method="post">
            <input type="submit" value="New Annuity">
        </form>
        <br>
        <!--a href="AnnuityInput.jsp">New Annuity</a-->
    </body>
</html>
