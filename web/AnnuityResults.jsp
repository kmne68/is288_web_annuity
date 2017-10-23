<%-- 
    Document   : AnnuityResults
    Created on : Sep 19, 2017, 9:10:14 PM
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
            <jsp:getProperty name="annuity" property="totalDeposit" />
            each month, <br>
            earning <jsp:getProperty name="annuity" property="rate" />
            % per year <br>
            for <jsp:getProperty name="annuity" property="term" />
            months <br>
            Will have a final value of:
            <jsp:getProperty name = "annuity" property="finalValue" />
            at the end of the term<br>
            
            Including 
            <jsp:getProperty name = "annuity" property="totalInt" />
             of interest earned.
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
