package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.constants.CraftConstants;
import com.example.model.TierDetails;
import com.example.util.LoggerUtility;

/**
 *
 * @author Dhanu
 *
 */
@Repository
public class CraftDaoImpl implements CraftDao {

   private static final Logger logger = LoggerUtility.getLogger(CraftDaoImpl.class);
   
   @Autowired
   protected JdbcTemplate jdbc;
   
   public int saveCustomerSubscriptionOrder(String customerHandle, String tierName) {
	   String tier_name = getCustomerSubscriptionOrderDetails(customerHandle);
	   if(null == tier_name || tier_name.equalsIgnoreCase("")){
		   return jdbc.update(CraftConstants.SQL_INSERT_SUBSCRIPTION_PER_CUSTOMER, new Object[] {customerHandle, tierName});
	   } else {
		   return 0;
	   }
  }
   public String getCustomerSubscriptionOrderDetails(String customerHandle){
     return jdbc.queryForObject(CraftConstants.SQL_FETCH_CUSTOMER_DATA, new Object[] {customerHandle }, String.class);
  }
   public List<TierDetails> fetchTiersInfo() {       
     String sqlQuery = CraftConstants.SQL_FETCH_TIERS_DATA;
     List<TierDetails> tierDetailsList = jdbc.query(sqlQuery, new String[] { },new RowMapper<TierDetails>() {
              @Override
              public TierDetails mapRow(ResultSet rs, int rownumber) throws SQLException {
            	  TierDetails tierDetails = new TierDetails();
            	  tierDetails.setTierDesc(rs.getString("TIER_NAME"));
            	  tierDetails.setTierCost(rs.getFloat("TIER_COST"));
                 return tierDetails;                
              }
           });
     return tierDetailsList;
  }
   public int deleteCustomerSubscriptionOrder(String customerHandle){
     return jdbc.update(CraftConstants.SQL_DELETE_SUBSCRIPTION, new Object[] {customerHandle});
  }
   public int updateCustomerSubscriptionOrder(String tierName, String customerHandle){
	   return jdbc.update(CraftConstants.SQL_UPDATE_SUBSCRIPTION, new Object[] {tierName, customerHandle});
   }
}
