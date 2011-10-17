package com.ip.assign2.Beans;

public class UserBean implements java.io.Serializable{
	static final long serialVersionUID = 1L;
	
	private String mUsername;
	private String mPassword;
	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private String mPhone;
	private String mCreditCardNumber;
	private String mAddressId;
	private String mAddressNumber;
	private String mAddressStreet;
	private String mAddressSuburb;
	private String mAddressState;
	private String mAddressPostcode;
	
	private boolean mLoggedIn = false;
	
	public String getUsername() {
		return mUsername;
	}
	
	public void setUsername(String mUsername) {
		this.mUsername = mUsername;
	}
	
	public String getPassword() {
		return mPassword;
	}
	
	public void setPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	
	public String getFirstName() {
		return mFirstName;
	}
	
	public void setFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	
	public String getLastName() {
		return mLastName;
	}
	
	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	
	public String getEmail() {
		return mEmail;
	}
	
	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	
	public String getPhone() {
		return mPhone;
	}
	
	public void setPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	
	public String getCreditCardNumber() {
		return mCreditCardNumber;
	}
	
	public void setCreditCardNumber(String mCreditCardNumber) {
		this.mCreditCardNumber = mCreditCardNumber;
	}
	
	public String getAddressNumber() {
		return mAddressNumber;
	}
	
	public void setAddressNumber(String mAddressNumber) {
		this.mAddressNumber = mAddressNumber;
	}
	
	public String getAddressStreet() {
		return mAddressStreet;
	}
	
	public void setAddressStreet(String mAddressStreet) {
		this.mAddressStreet = mAddressStreet;
	}
	
	public String getAddressSuburb() {
		return mAddressSuburb;
	}
	
	public void setAddressSuburb(String mAddressSuburb) {
		this.mAddressSuburb = mAddressSuburb;
	}
	
	public String getAddressState() {
		return mAddressState;
	}
	
	public void setAddressState(String mAddressState) {
		this.mAddressState = mAddressState;
	}
	
	public String getAddressPostcode() {
		return mAddressPostcode;
	}
	
	public void setAddressPostcode(String mAddressPostcode) {
		this.mAddressPostcode = mAddressPostcode;
	}
	
	public String getAddressId() {
		return mAddressId;
	}
	
	public void setAddressId(String mAddressId) {
		this.mAddressId = mAddressId;
	}
	
	public void isLoggedIn(boolean mLoggedIn) {
		this.mLoggedIn = mLoggedIn;
	}
	
	public boolean isLoggedIn() {
		return mLoggedIn;
	}
}
