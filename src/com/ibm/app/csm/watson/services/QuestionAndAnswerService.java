package com.ibm.app.csm.watson.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import com.ibm.app.csm.helper.JsonUtilityClass;
import com.ibm.app.csm.helper.PropertyReader;
import com.ibm.json.java.JSONObject;

public class QuestionAndAnswerService extends WatsonServices {
	public static String _mimeType="application/json";
	public QuestionAndAnswerService(){
		baseURL="https://gateway.watsonplatform.net/question-and-answer-beta/api";
		serviceName="question_and_answer";
		username="053480a8-2182-41fe-affb-963fcea9a969";
		password="rxL67DNQIwbB";//"bTeSvI1VHFJP";
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
	public String QuestionToJSON(String questionText){
		Map<String,Map<String,Object>> problem=new HashMap<String,Map<String,Object>>();
		Map<String,Object> question=new HashMap<String,Object>();
		Map<String,Integer> evidenceRequest=new HashMap<String,Integer>();
		evidenceRequest.put("items", 5);
		question.put("questionText", questionText);
		//question.put("items", PropertyReader.propertyReader("props.properties", "solutionCount"));
		question.put("items",5);
		question.put("evidenceRequest", evidenceRequest);
		problem.put("question", question);
		return JsonUtilityClass.toJSON(problem);
	}
	
	public String AnswerToQuestion(String questionText,String dataSet){
		String problem=QuestionToJSON(questionText);
		Executor executor=Executor.newInstance().auth(username, password);
		Response response;
		Request request=Request.Post(baseURL+"/v1/question/"+dataSet);
		request.addHeader("Accept",_mimeType);
		request.body(new StringEntity(problem,ContentType.APPLICATION_JSON));
		try {
			response=executor.execute(request);
			return response.returnContent().asString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
