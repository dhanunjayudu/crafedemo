package com.example.constants;

public interface CraftConstants {
	   public static final String ORACLE_URL_THIN_PREFIX = "jdbc:oracle:thin:@";
	   public static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	   public static final String DB2_URL = "jdbc:db2://";
	   public static final String DB2_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	   public static final String SQL_FETCH_CUSTOMER_DATA = "SELECT TIER_NAME "
	   		+ "FROM SUBSCRIPTIONS_T WHERE CUSTOMER_TWITTER_HANDLE = ?";
	   public static final String SQL_INSERT_SUBSCRIPTION_PER_CUSTOMER = "INSERT INTO SUBSCRIPTIONS_T(CUSTOMER_TWITTER_HANDLE, TIER_NAME)  VALUES(?,?)";
	   public static final String SQL_UPDATE_SUBSCRIPTION = "Update SUBSCRIPTIONS_T set TIER_NAME = ? WHERE CUSTOMER_TWITTER_HANDLE=?";
	   public static final String SQL_FETCH_TIERS_DATA = "SELECT TIER_NAME, TIER_COST from TIERS_T";
	   public static final String SQL_DELETE_SUBSCRIPTION = "DELETE FROM SUBSCRIPTIONS_T where CUSTOMER_TWITTER_HANDLE=?";
	}