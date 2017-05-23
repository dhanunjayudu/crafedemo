package com.example.controller;

import java.net.URL;
import java.util.Arrays;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetUserStatus {
	private static final String CONSUMER_KEY = "I7fTSD37PwMFRz46ayp09HWXb";
	private static final String CONSUMER_SECRET = "MzECl7MyqS8aFFVn1YXQxfSoCeMWZJL5DLe2rNTMMZHdhDGfu9";
	private static final String ACCESS_TOKEN = "272923501-lfNkiTBc7uoiTxnsXKWCq08FFSAG1a2GzlHX52w8";
	private static final String ACCESS_TOKEN_SECRET = "NlfGp0T7tIcEAzeHwfPgF5c61DZxTMdIuyyvJEf2pZsRg";
	
	public static void main(String[] args){
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));
		try{
			ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,5));
			for(Status b : a){
				System.out.println(b.getText());
			}
		// Post a Tweet using Twitter4j API
	      Status status = twitter.updateStatus("Hello");
	      System.out.println("Successfully updated the status to [" + status.getText() + "].");
		//Instantiate and initialize a new twitter status update
//        StatusUpdate statusUpdate = new StatusUpdate(
//                //your tweet or status message
//                "Hello World - Java + Twitter API");
//        //attach any media, if you want to
//        statusUpdate.setMedia(
//                //title of media
//                "http://accounts-musiclovers.net"
//                , new URL("https://si0.twimg.com/profile_images/1733613899/Published_Copy_Book.jpg").openStream());
// 
//        //tweet or update status
//        Status status = twitter.updateStatus(statusUpdate);
// 
//        //response from twitter server
//        System.out.println("status.toString() = " + status.toString());
//        System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
//        System.out.println("status.getSource() = " + status.getSource());
//        System.out.println("status.getText() = " + status.getText());
//        
//        System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
//        System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));
		} catch(Exception e){
					
				}
	}
}
