/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;

/**
 *
 * @author kmne6
 */
public class AnnuityMonth {
    
    private int month; // month this instance represents
    private double bbal, depositEarly, depositLate, iearn, ebal;
    private NumberFormat curr = NumberFormat.getCurrencyInstance();
    
    public AnnuityMonth() {
        month = 0;
        bbal = 0;
        depositEarly = 0;
        depositLate = 0;
        iearn = 0;
        ebal = 0;
    }
    
    public AnnuityMonth(int m, double bb, double depEarly, double depLate, double ie, double eb) {
        month = m;
        bbal = bb;
        depositEarly = depEarly;
        depositLate = depLate;
        iearn = ie;
        ebal = eb;        
        
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getBbal() {
        return curr.format(bbal);
    }

    public void setBbal(double bbal) {
        this.bbal = bbal;
    }

    public double getDepositEarly() {
        return depositEarly;
    }
    
    
    public double getDepositLate() {
        return depositLate;
    }
    

    public void setDeposit(double deposit) {
        this.depositEarly = deposit;
    }
    
    public String getIearn() {
        return curr.format(iearn);
    }
/*
    public double getIearn() {
        return iearn;
    }
*/
    public void setIearn(double iearn) {
        this.iearn = iearn;
    }
    
    
    public String getEbal() {
        return curr.format(ebal);
    }

/*
    public double getEbal() {
        return ebal;
    }
*/
    public void setEbal(double ebal) {
        this.ebal = ebal;
    }
}
