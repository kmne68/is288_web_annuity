<%-- 
    Document   : AnnuitySchedule
    Created on : Sep 19, 2017, 9:32:14 PM
    Author     : Keith Emery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="annuity" scope="session" class="business.Annuity"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Result</title>
    </head>
    <body>
        <h1>Annuity Results:</h1>
        <p>An annuity with deposit of:<br>
            <jsp:getProperty name="annuity" property="deposit" />
            each month, <br>
            earning <jsp:getProperty name="annuity" property="rate" />
            % per year <br>
            for <jsp:getProperty name="annuity" property="term" />
            months <br>

        </p>
        <br>

    </body>
</html>
