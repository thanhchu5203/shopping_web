/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Lewis
 */
public class Account {
    
    private int accountID;
    private String accountUser;
    private String accountPassword;
    private String accountName;
    private String accountEmail;
    private String accountDob;
    private String accountMobile;
    private String accountAddress;
    private Role role;

    public Account() {
    }

    public Account(String accountUser, String accountPassword, String accountName, String accountEmail, String accountDob, String accountMobile, String accountAddress, Role role) {
        this.accountUser = accountUser;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
        this.accountDob = accountDob;
        this.accountMobile = accountMobile;
        this.accountAddress = accountAddress;
        this.role = role;
    }
    
    public Account(int accountID, String accountUser, String accountPassword, String accountName, String accountEmail, String accountDob, String accountMobile, String accountAddress, Role role) {
        this.accountID = accountID;
        this.accountUser = accountUser;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
        this.accountDob = accountDob;
        this.accountMobile = accountMobile;
        this.accountAddress = accountAddress;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountDob() {
        return accountDob;
    }

    public void setAccountDob(String accountDob) {
        this.accountDob = accountDob;
    }

    public String getAccountMobile() {
        return accountMobile;
    }

    public void setAccountMobile(String accountMobile) {
        this.accountMobile = accountMobile;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
