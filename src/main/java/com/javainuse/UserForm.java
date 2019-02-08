package com.javainuse;

import java.time.LocalDate;

public class UserForm {

	private Long userId;
	private String firstName;
	private String lastName;
	private LocalDate DOB; // java.util.Date is milliseconds
	private String encryptedSSN;
	private String email;
	private String mobileTelephone;
	private String homeAddress;
	private String mailAddress;
	private String accountType;
	private int minimumBalance;
	private boolean openAccount;
	
	public UserForm() {
		 
    }
 
    public UserForm(Long userId, String firstName, String lastName,
            LocalDate DOB, String encryptedSSN, String email, String mobileTelephone,
            String homeAddress, String mailAddress, String accountType, int minimumBalance,
            boolean openAccount) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.encryptedSSN = encryptedSSN;
        this.email = email;
        this.mobileTelephone = mobileTelephone;
        this.homeAddress = homeAddress;
        this.mailAddress = mailAddress;
        this.accountType = accountType;
        this.minimumBalance = minimumBalance;
        this.openAccount = openAccount;
    }
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDOB() {
		return DOB;
	}
	
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	
	public String getEncryptedSSN() {
		return encryptedSSN;
	}
	
	public void setEncryptedSSN(String encryptedSSN) {
		this.encryptedSSN = encryptedSSN;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	
	public String getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public String getMailAddress() {
		return mailAddress;
	}
	
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public int getMinimumBalance() {
		return minimumBalance;
	}
	
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	public boolean isOpenAccount() {
		return openAccount;
	}
	
	public void setOpenAccount(boolean openAccount) {
		this.openAccount = openAccount;
	}

}
