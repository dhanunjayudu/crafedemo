package com.example.model;

public class TierDetails implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8720014604993968411L;
	private String tierDesc;
	private Float tierCost;

	public TierDetails() {
	}

	public TierDetails(String tierDesc, Float tierCost) {
		this.tierDesc = tierDesc;
		this.tierCost = tierCost;
	}

	public String getTierDesc() {
		return tierDesc;
	}

	public void setTierDesc(String tierDesc) {
		this.tierDesc = tierDesc;
	}


	public Float getTierCost() {
		return tierCost;
	}


	public void setTierCost(Float tierCost) {
		this.tierCost = tierCost;
	}
}
