package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CraftDao;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/")
public class CraftDemoEndPoint {

   private static final Logger logger = Logger.getLogger(CraftDemoEndPoint.class);

   @Autowired
   private CraftDao craftDao;
   
   @ApiOperation(value = "createSubscription", nickname = "createSubscription")
   @ApiResponses(value = { 
           @ApiResponse(code = 200, message = "Success", response = String.class),
           @ApiResponse(code = 401, message = "Unauthorized"),
           @ApiResponse(code = 403, message = "Forbidden"),
           @ApiResponse(code = 404, message = "Not Found"),
           @ApiResponse(code = 500, message = "Failure")}) 
  @RequestMapping(value = "subscriptions/{twitterHandleId}",  method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public ResponseEntity<java.lang.String> createSubscription(@PathVariable String twitterHandle,
        @PathVariable String twitterHandleId,  
        @ApiParam(name = "tierName", value = "tierName", defaultValue = "") @RequestParam
        ("tierName") String tierName) throws Exception { 
     String output = "Data has been inserted into subscriptions_t table.";
     JSONObject outputJsonObject = new JSONObject();
     craftDao.saveCustomerSubscriptionOrder(twitterHandle, tierName);
     outputJsonObject.put("successmessage", "Success"); 
     outputJsonObject.put("output", output);
     return ResponseEntity.ok(outputJsonObject.toString(4));
  }
}

