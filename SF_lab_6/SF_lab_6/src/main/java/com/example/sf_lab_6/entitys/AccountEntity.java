package com.example.sf_lab_6.entitys;

public class AccountEntity {
    private int userID;
    private double balance;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", userID=" + userID +
                ", balance=" + balance +
                '}';
    }
}
