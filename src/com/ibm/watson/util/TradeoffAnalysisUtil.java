package com.ibm.watson.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;


/**
 * Utility class to run trade off analytics
 * @author SUDDUTT1
 *
 */
public class TradeoffAnalysisUtil {

	private static Logger LOGGER = Logger.getLogger(TradeoffAnalysisUtil.class.getName());
	private static String _baseURL = "https://gateway.watsonplatform.net/tradeoff-analytics-beta/api";
	private static String _userName = "19105c2b-d22b-4806-823c-dba38366f5dd";
	private static String _password = "KGpFlEyPZ08L";
	private static String _serviceName = "tradeoff_analytics";

	/**
	 * Call the tradeoff analytics service and returns the result.
	 * @param inputJSON
	 * @return
	 */
	public static String applyTradeoffAnalytics(String inputJSON) {
		StringBuilder retrunStrBldr = null;
		String line;
		try {
			processVCAP_Services();
			String url = _baseURL + "/v1/dilemmas";
			Request newRequest = Request.Post(url);
			newRequest.body(new StringEntity(inputJSON,
					ContentType.APPLICATION_JSON));
			Executor executor = Executor.newInstance().auth(_userName,
					_password);

			Response resp = executor.execute(newRequest);
			HttpResponse newResponse = resp.returnResponse();

			int retStatus = newResponse.getStatusLine().getStatusCode();
			if (retStatus == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						newResponse.getEntity().getContent()));

				retrunStrBldr = new StringBuilder();
				while ((line = br.readLine()) != null) {
					retrunStrBldr.append(line);
				}
				br.close();
				LOGGER.log(Level.INFO,"|TRADEOFF_ALAYTIC_UTIL| Retured response from WATSON: "+ retrunStrBldr);
			} else {
				retrunStrBldr = new StringBuilder();
			}
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING,"|TRADEOFF_ALAYTIC_UTIL| Exception in reading from WATSON",ex);
			retrunStrBldr = new StringBuilder();
		}
		return retrunStrBldr.toString();
	}
	
	/**
	 * Gets the <b>VCAP_SERVICES</b> environment variable and return it
	 *  as a JSONObject.
	 *
	 * @return the VCAP_SERVICES as Json
	 */
	private static JSONObject getVcapServices() {
		String envServices = System.getenv("VCAP_SERVICES");
		if (envServices == null) return null;
		JSONObject sysEnv = null;
		try {
			sysEnv = JSONObject.parse(envServices);
		} catch (IOException e) {
			// Do nothing, fall through to defaults
			LOGGER.log(Level.SEVERE, "|TRADEOFF_ALAYTIC_UTIL|Error parsing VCAP_SERVICES: ", e);
		}
		return sysEnv;
	}

	
	
	/**
	 * If exists, process the VCAP_SERVICES environment variable in order to get the
	 * username, password and baseURL
	 */
	private static void processVCAP_Services() {
		LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|Processing VCAP_SERVICES");
		JSONObject sysEnv = getVcapServices();
		if (sysEnv == null) return;
		LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|Looking for: "+ _serviceName );

		for (Object key : sysEnv.keySet()) {
			String keyString = (String) key;
			LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|found key: " + key);
			if (keyString.startsWith(_serviceName)) {
				JSONArray services = (JSONArray)sysEnv.get(key);
				JSONObject service = (JSONObject)services.get(0);
				JSONObject credentials = (JSONObject)service.get("credentials");
				_baseURL  = (String)credentials.get("url");
				_userName = (String)credentials.get("username");
				_password = (String)credentials.get("password");
				LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|baseURL  = "+_baseURL);
				LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|username = "+_userName);
				LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|password = "+_password);
			} else {
				LOGGER.info("|TRADEOFF_ALAYTIC_UTIL|Doesn't match /^"+_serviceName+"/");
			}
		}
	}
}
