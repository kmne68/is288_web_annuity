package business;

import java.util.ArrayList;

public class Annuity {
   private double deposit, rate;
   private int term;
   private double[] bbal, iearn, ebal;
   private boolean built;
   
   
   public Annuity() {
       this.deposit = 0;
       this.rate = 0;
       this.term = 0;
       this.built = false;
   }

   public Annuity(double deposit, double rate, int term) {
       this.deposit = deposit;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }

   public double getDeposit() {
       return this.deposit;
   }

   public double getRate() {
       return this.rate;
   }

   public int getTerm() {
       return this.term;
   }
   public double getFinalValue() {
       if (!built) {
           buildAnnuity();
       }
       return ebal[term-1];
   }
   public double getBegBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.bbal[m-1];
   }
   public double getIntEarn(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.iearn[m-1];
   }
   public double getEndBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.ebal[m-1];
   }
   private void buildAnnuity() {
       bbal = new double[term];
       iearn = new double[term];
       ebal = new double[term];

       bbal[0] = 0;
       for (int i=0; i < this.term; i++) {
           if (i > 0) {
               bbal[i] = ebal[i-1];
           }
           iearn[i] = (bbal[i] + this.deposit) * (this.rate / 12.0);
           ebal[i] = (bbal[i] + this.deposit + iearn[i]);
       }
       built = true;
       return ;
   }

    /**
     * @param deposit the deposit to set
     */
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(int term) {
        this.term = term;
    }
    
    
    public ArrayList<AnnuityMonth> getMonths() {
        
        ArrayList<AnnuityMonth> mos = new ArrayList<>();
        
        if(!built) {
            buildAnnuity();
        }
        for(int i = 0; i < this.term; i++) {
            AnnuityMonth m = new AnnuityMonth((i + 1), this.bbal[i], this.deposit, this.iearn[i], this.ebal[i]);
            mos.add(m);
        }
        
        return mos;
    }
}
