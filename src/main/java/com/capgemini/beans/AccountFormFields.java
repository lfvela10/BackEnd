package com.capgemini.beans;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
public class AccountFormFields {
	
//	@Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;
	
	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	private String email;
	private String mobileNumber;

	private String homeAddress;
	private String mailingAddress;

	private AccountType accountType;

	private double balance;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountFormFields [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", ssn=" + ssn
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", homeAddress=" + homeAddress
				+ ", mailingAddress=" + mailingAddress + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
	
}
