package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yguan on 7/18/14.
 */
public class Employee {

    private String uid;
    private String uname;
    private double exp;
    @Autowired
    private ArrayList<Expense> expensesList;

    @Autowired
    public Employee(String uid, String uname, double exp) {
        this.uid = uid;
        this.uname = uname;
        this.exp = exp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public ArrayList<Expense> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(ArrayList<Expense> expensesList) {
        this.expensesList = expensesList;
    }

    public double getAvailableCost() {
        if (exp >= 1) {
            return 2000;
        }

        Calendar entryCalendar = rollToEntry(getExpMonth(), getExpDayOdd(getExpMonth()));

        if (entryCalendar.get(Calendar.YEAR) < getCurrentYear()) {
            return 2000;
        }
        return (double) (12 + 1 - (entryCalendar.get(Calendar.MONTH) + 1)) / 12 * 2000;
    }

    private int getExpDayOdd(int expMonth) {
        return (int) ((exp * 12 - expMonth) * 30);
    }

    private int getExpMonth() {
        return (int) (exp * 12);
    }

    private int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    private Calendar rollToEntry(int expMonth, int expDayOdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -expMonth);
        calendar.add(Calendar.DAY_OF_MONTH, -expDayOdd);
        return calendar;
    }


    public double getSpendedCost() {
        double spended = 0;
        for (Expense expense : expensesList) {
            spended += expense.getCost();
        }
        return spended;
    }

    public double getLeftCost() {
        return getAvailableCost() - getSpendedCost();
    }
}
