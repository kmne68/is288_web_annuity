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
    private double bbal, deposit, iearn, ebal;
    private NumberFormat curr = NumberFormat.getCurrencyInstance();
    
    public AnnuityMonth() {
        month = 0;
        bbal = 0;
        deposit = 0;
        iearn = 0;
        ebal = 0;
    }
    
    public AnnuityMonth(int m, double bb, double dep, double ie, double eb) {
        month = m;
        bbal = bb;
        deposit = dep;
        iearn = ie;
        ebal = eb;        
        
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getBbal() {
        return bbal;
    }

    public void setBbal(double bbal) {
        this.bbal = bbal;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getIearn() {
        return iearn;
    }

    public void setIearn(double iearn) {
        this.iearn = iearn;
    }

    public double getEbal() {
        return ebal;
    }

    public void setEbal(double ebal) {
        this.ebal = ebal;
    }
}
