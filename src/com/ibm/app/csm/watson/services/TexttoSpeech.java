package com.ibm.app.csm.watson.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.ibm.json.java.JSONObject;

public class TexttoSpeech extends WatsonServices {
	public static String _oggFormat="audio/ogg; codecs=opus";
	public static String _wavFormat="audio/wav";
	public TexttoSpeech(){
		baseURL="https://stream.watsonplatform.net/text-to-speech-beta/api";
		username="b41d8ef8-7da6-48b8-8e89-5e709c23d2fb";//"8e8ece0e-3a20-4eaf-9aae-aa8572f30fa2";
		password="FXPbTEOJujG9" ; //"b7dE131gzksa"; 
		serviceName="text_to_speech";
	}
	
	
	public HttpResponse texttoSpeech(String text, String voiceType,String acceptHeader){
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("text",text));
		list.add(new BasicNameValuePair("voice",voiceType));
		Request request=Request.Get(baseURL+"/v1/synthesize?"+URLEncodedUtils.format(list, "utf-8"));
		request.setHeader("accept",acceptHeader);
		Executor executor=Executor.newInstance().auth(username, password);
		try {
			Response response=executor.execute(request);
			return response.returnResponse();
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
