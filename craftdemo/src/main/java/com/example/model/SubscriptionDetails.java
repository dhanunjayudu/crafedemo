package com.example.model;

public class SubscriptionDetails implements java.io.Serializable {

	private static final long serialVersionUID = -1468318187379399473L;
	private String customerTwitterHandle;
	private String tierName;

	public SubscriptionDetails() {
	}

	public SubscriptionDetails(String customerTwitterHandle, String tierName) {
		this.customerTwitterHandle = customerTwitterHandle;
		this.tierName = tierName;
	}

	public String getCustomerTwitterHandle() {
		return customerTwitterHandle;
	}

	public void setCustomerTwitterHandle(String customerTwitterHandle) {
		this.customerTwitterHandle = customerTwitterHandle;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}


}

