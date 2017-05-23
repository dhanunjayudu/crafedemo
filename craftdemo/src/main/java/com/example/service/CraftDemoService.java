package com.example.service;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.dao.CraftDao;

@Service
public class CraftDemoService {
   private static final Logger logger = LoggerFactory.getLogger(CraftDemoService.class);
   
   @Autowired
   private CraftDao craftDao;
 
   public void createSubscription(String customerHandle, String tierName){
//      referenceData = craftDao.saveCustomerSubscriptionOrder(customerHandle, tierName);

}
}