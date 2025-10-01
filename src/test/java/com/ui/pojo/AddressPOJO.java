package com.ui.pojo;




// sourse constructor getters no setters
public class AddressPOJO {
		private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homephoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String addressAlis;
    private String state;
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode,
			String homephoneNumber, String mobileNumber, String otherInformation, String addressAlis, String state) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homephoneNumber = homephoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.addressAlis = addressAlis;
		this.state = state;
	}
	public String getCompany() {
		return company;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", postCode=" + postCode + ", homephoneNumber=" + homephoneNumber
				+ ", mobileNumber=" + mobileNumber + ", otherInformation=" + otherInformation + ", addressAlis="
				+ addressAlis + ", state=" + state + "]";
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomephoneNumber() {
		return homephoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public String getAddressAlis() {
		return addressAlis;
	}
	public String getState() {
		return state;
	}
}