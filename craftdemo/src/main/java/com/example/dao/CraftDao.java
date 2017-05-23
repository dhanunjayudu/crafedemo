package com.example.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.SubscriptionDetails;
import com.example.model.TierDetails;

@Transactional
public interface CraftDao {

	public int saveCustomerSubscriptionOrder(String customerHandle, String tierName);

	public String getCustomerSubscriptionOrderDetails(String customerHandle);
	
	public int deleteCustomerSubscriptionOrder(String customerHandle);
	
	public List<TierDetails> fetchTiersInfo();

	public int updateCustomerSubscriptionOrder(String tierName, String customerHandle);

}