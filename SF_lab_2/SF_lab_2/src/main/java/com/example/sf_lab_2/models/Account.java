package com.example.sf_lab_2.models;

public class Account {
    private int userID;
    private double balance;

    public Account(int userID) {
        this.userID = userID;
        double min = 100.0;
        double max = 20000.0;
        this.balance = min + (max - min) * Math.random();
    }

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
