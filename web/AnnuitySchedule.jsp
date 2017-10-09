<%-- 
    Document   : AnnuitySchedule
    Created on : Sep 19, 2017, 9:32:14 PM
    Author     : Keith Emery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Result</title>
    </head>
    <body>
        <h1>Annuity Results:</h1>
        <p>An annuity with deposit of:<br>
            ${annuity.deposit} each month, <br>
            and earning ${annuity.rate} % per year <br>
            for ${annuity.finalValue} months <br>
        </p>
        <br>
        
        <form action="NewAnnuity" method="post">
            <input 
        </form>

    </body>
</html>
