package com.javaeetest.entity;

public class Address {
	private String addressId;
	private String receiverName;
	private String receiverPhone;
	private String province;
	private String city;
	private String detailedAddress;
	/**
	 * @param detailedAddress the detailedAddress to set
	 */
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	/**
	 * @return the detailedAddress
	 */
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvince() {
		return province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressId() {
		return addressId;
	}
	

}
