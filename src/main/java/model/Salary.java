package model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Salary{

    public Salary(int salaryID,double amount, Date dateOfPayment){
        if (salaryID != 0 && amount != 0 && dateOfPayment != null) {
            this.salaryID = salaryID;
            this.amount = amount;
            this.dateOfPayment = dateOfPayment;
        }
    }

    private int salaryID;
    private double amount;
    private Date dateOfPayment;

    public int getSalaryID(){return salaryID;}
    public double getAmount(){return amount;}
    public Date getDateOfPayment(){return dateOfPayment;}

}