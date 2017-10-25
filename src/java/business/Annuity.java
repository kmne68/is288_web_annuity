package business;

import java.util.ArrayList;

public class Annuity {
   private double depositEarly, depositLate, depositTotal, rate;
   private double totalInterest = 0;
   private int term;
   private double[] bbal, iearn, ebal;
   private boolean built;
   
   
   public Annuity() {
       this.depositEarly = 0;
       this.depositLate = 0;
       this.depositTotal = 0;
    //   this.totalInterest = 0;
       this.rate = 0;
       this.term = 0;
       this.built = false;
   }

   public Annuity(double depositEarly, double depositLate, double rate, int term) {
       this.depositEarly = depositEarly;
       this.depositLate = depositLate;
  //     this.depositTotal = depositEarly + depositLate;
       this.rate = rate;
       this.term = term;
  //     this.totalInterest = 0;
       buildAnnuity();
   }

   public double getDepositEarly() {
       return this.depositEarly;
   }
   
   public double getDepositLate() {
       return this.depositLate;
   }
   
   
   public double getTotalInt() {
        return this.getFinalValue() - (this.getTotalDeposit() * this.term);
   }
   
   
   public double getTotalDeposit() {
       return (this.depositEarly + this.depositLate);
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
           iearn[i] = (bbal[i] + this.depositEarly) * (this.rate / 12.0);
           ebal[i] = (bbal[i] + this.depositEarly + iearn[i] + this.depositLate);
       }
       built = true;
       return ;
   }

    /**
     * @param deposit the deposit to set
     */
    public void setDepositEarly(double deposit) {
        this.depositEarly = deposit;
    }
    
    
    public void setDepositLate(double deposit) {
        this.depositLate = deposit;
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
            AnnuityMonth m = new AnnuityMonth((i + 1), this.bbal[i], this.depositEarly, this.depositLate, this.depositTotal, this.iearn[i], this.ebal[i]);
    //        this.totalInterest += iearn[i];
            mos.add(m);
        }        
        return mos;
    }
}
