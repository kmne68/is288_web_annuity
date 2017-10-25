<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity</title>
    </head>
    <body  OnLoad="document.adata.amt1.focus();">
        <h1>Annuity Calculator</h1>

        <form action="AnnuityCalc" name="adata" id="adata" method="post">
            Deposit at Beginning of Month:
            <input type="text" name="amt1" id="amt1" value="${annuity.depositEarly}"/><br><br>
            
            Deposit at End of Month:
            <input tyep="text" name="amt2" id="amt2" value="${annuity.depositLate}"/><br><br>
            
            Annual Interest Rate (as a decimal):
            <input type="text" name="irt" id="irt" value="${annuity.rate}"/><br><br>
            
            Term (in mos):
            <input type="text" name="term" id="term" value="${annuity.term}"/><br><br>
            
            <input type="submit" value="Calculate"/>
        </form> 
            <br>
            ${emsg}
    </body>
</html>