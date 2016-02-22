package com.ibm.app.csm.watson.services;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

public abstract class WatsonServices {
	private static Logger logger = Logger.getLogger(WatsonServices.class.getName());
	protected  String serviceName;
	protected String baseURL;
	protected String username;
	protected String password;
	protected void processVCAP_Services() {
	  	  logger.info("Processing VCAP_SERVICES");
	      JSONObject sysEnv = getVcapServices();
	      if (sysEnv == null) return;
	      logger.info("Looking for: "+ serviceName );
	      
	      if (sysEnv.containsKey(serviceName)) {
				JSONArray services = (JSONArray)sysEnv.get(serviceName);
				JSONObject service = (JSONObject)services.get(0);
				JSONObject credentials = (JSONObject)service.get("credentials");
				baseURL = (String)credentials.get("url");
				username = (String)credentials.get("username");
				password = (String)credentials.get("password");
				logger.info("baseURL  = "+baseURL);
				logger.info("username   = "+username);
				logger.info("password = "+password);
	  	} else {
	      	logger.warning(serviceName + " is not available in VCAP_SERVICES, "
	      		+ "please bind the service to your application");
	      }
	  }
	protected JSONObject getVcapServices() {
	      String envServices = System.getenv("VCAP_SERVICES");
	      if (envServices == null) return null;
	      JSONObject sysEnv = null;
	      try {
	      	 sysEnv = JSONObject.parse(envServices);
	      } catch (IOException e) {
	      	// Do nothing, fall through to defaults
	      	logger.log(Level.SEVERE, "Error parsing VCAP_SERVICES: "+e.getMessage(), e);
	      }
	      return sysEnv;
	  }
	
}
