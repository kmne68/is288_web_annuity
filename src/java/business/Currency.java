/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author kmne6
 */
public class Currency {

    private Locale locale;
    private double amount;

    public Currency() {
        locale = null;
        amount = 0.0;
    }

    public void setLocale(Locale l) {
        locale = l;
    }

    public void setAmount(double a) {
        amount = a;
    }

    public String getFormat() {
        NumberFormat nf
                = NumberFormat.getCurrencyInstance(locale);
        return nf.format(amount);
    }
}
