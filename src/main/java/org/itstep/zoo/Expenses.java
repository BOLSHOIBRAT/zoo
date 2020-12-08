package org.itstep.zoo;

import java.util.Date;

public class Expenses {
   final private double money;
   final private java.util.Date date;

    public Expenses(double money, java.util.Date  date) {
        this.money = money;
        this.date = date;
    }



    public double getMoney() {
        return money;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Expense for " + date + " is $" + money;
    }
}
