package com.example.sf_lab_2.service;

import com.example.sf_lab_2.models.Account;
import com.example.sf_lab_2.models.Doctor;
import com.example.sf_lab_2.models.User;
import com.example.sf_lab_2.repository.AccountDAO;
import com.example.sf_lab_2.repository.DoctorDAO;
import com.example.sf_lab_2.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;
    private DoctorDAO doctorDAO;
    private AccountDAO accountDAO;

    @Autowired
    public UserService(UserDAO userDAO, DoctorDAO doctorDAO, AccountDAO accountDAO) {
        this.userDAO = userDAO;
        this.doctorDAO = doctorDAO;
        this.accountDAO = accountDAO;
    }

    public void createUser(User user){
        int userID = this.userDAO.createUser(user);
        this.accountDAO.createAccount(new Account(userID));
    }

    public <T> User getUser(T value){
        User user;
        if (isNumber((String) value)) {
            user = this.userDAO.getUserByID(Integer.parseInt(((String) value).trim()));
        }
        else{
            user =  this.userDAO.getUserByName((String) value);
        }
        return user;
    }

    public boolean transferFromHere(int userID, double amount){
        Account account = this.accountDAO.getAccount(userID);
        double balance = account.getBalance();
        if(balance > amount){
            balance -= amount;
            account.setBalance(balance);
            return true;
        }
        return false;
    }

    public void updateUser(int id, User updatedUser){
        this.userDAO.updateUser(id, updatedUser);
    }

    public void deleteUser(int id){
        this.accountDAO.delAccount(id);
        this.userDAO.delUser(id);
    }

    public <T> Doctor getDoctor(T value){
        Doctor doctor = null;
        if (isNumber((String) value)) {
            doctor = this.doctorDAO.getDoctorByID(Integer.parseInt(((String) value).trim()));
        }
        else{
            doctor =  this.doctorDAO.getDoctorByName((String) value);
        }
        return doctor;
    }

    public List<Doctor> allDoctors(){
        return this.doctorDAO.allDoctors();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
