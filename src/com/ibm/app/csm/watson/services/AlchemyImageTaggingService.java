package com.ibm.app.csm.watson.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;


public class AlchemyImageTaggingService {

private static String _apikey="5c13746edf9ce3fdc6b75af12c3760380e72a4cf" ;
//private static String _apikey="ab331befcd882c4e04269202e882aaf044306763";
private String baseURL="http://access.alchemyapi.com/calls/image/ImageGetRankedImageKeywords";
//private String baseURL="http://access.alchemyapi.com/calls/url/URLGetRankedImageKeywords";

public String getImageTag(byte[] imageByteArray){
	List<NameValuePair> list=new ArrayList<NameValuePair>();
	list.add(new BasicNameValuePair("apikey", _apikey));
	list.add(new BasicNameValuePair("imagePostMode", "raw"));
	list.add(new BasicNameValuePair("outputMode","json"));
	
	
	try {
		Request request=Request.Post(baseURL+"?"+URLEncodedUtils.format(list,"utf-8"));
		request.bodyByteArray(imageByteArray);
		request.setHeader("Accept", "application/json");
		Executor executor=Executor.newInstance();
		Response response=executor.execute(request);
		return response.returnContent().asString();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
		
}

@SuppressWarnings("resource")
public byte[] readContentsOfFile(String imageFile){
	try {
		RandomAccessFile raFile=new RandomAccessFile(new File(imageFile), "r");
		byte[] contentData=new byte[(int) raFile.length()];
		raFile.readFully(contentData);
		return contentData;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
}
