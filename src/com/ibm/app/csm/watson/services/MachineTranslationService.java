package com.ibm.app.csm.watson.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.ibm.json.java.JSONObject;

public class MachineTranslationService extends WatsonServices {

	public static String _returntext="text";
	public static String _returnjson="json";
	public MachineTranslationService(){
		baseURL="https://gateway.watsonplatform.net/machine-translation-beta/api";
		username="0eb261e9-72d2-47dc-95e3-05f570f1a6be";
		password="WYGW6Cvv5xti";
		serviceName="machine_translation";
	}
	public String translate(String text,String sid,String rt){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		  list.add(new BasicNameValuePair("sid", sid));
		  list.add(new BasicNameValuePair("txt",text));
		  list.add(new BasicNameValuePair("rt",rt));
		  Request rqst=Request.Post(baseURL+"/v1/smt/0");
		  rqst.body(new StringEntity(URLEncodedUtils.format(list, "utf-8"), ContentType.APPLICATION_FORM_URLENCODED));
		  Executor executor=Executor.newInstance().auth(username, password);
		  String returnText="";
		  String tempText="";
			Response rsp;
			try {
				rsp = executor.execute(rqst);
				HttpResponse response=rsp.returnResponse();
				BufferedReader br=new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
				while((tempText=br.readLine())!=null){
					returnText+=tempText;
				}
				return returnText;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
	}
	@Override
	public void processVCAP_Services() {
		// TODO Auto-generated method stub
		super.processVCAP_Services();
	}
	@Override
	public JSONObject getVcapServices() {
		// TODO Auto-generated method stub
		return super.getVcapServices();
	}
	
}
