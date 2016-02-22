package com.ibm.app.csm.action;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.domain.model.JobDetailsWorker;
import com.ibm.app.csm.helper.StringSearch;
import com.ibm.app.csm.helper.TextExtractionBean;
import com.ibm.app.web.frmwk.WebActionHandler;
import com.ibm.app.web.frmwk.annotations.RequestMapping;
import com.ibm.app.web.frmwk.bean.ModelAndView;
import com.ibm.app.web.frmwk.bean.ViewType;

/**
 * Action class for Alchemy Api . Public method of this class implements
 * actions related to Alchemy Api
 * 
 * @author Suman Mandal
 * 
 */

public class AlchemyApiAction implements WebActionHandler {
	
	private static Logger logger = Logger.getLogger(AlchemyApiAction.class.getName());
	private static String urlGetText = "http://access.alchemyapi.com/calls/url/URLGetText";
	private static String urlGetImage = "http://access.alchemyapi.com/calls/image/ImageGetRankedImageKeywords";
	private static String apiKey = "ea58aeb43c6d5141d32a521177493559ca1c97ef";
	
	
	
	
	
	/**
	 * Load View online help material Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("getInfo.wss")
	public ModelAndView getInfo(HttpServletRequest request,HttpServletResponse resp){
		ModelAndView mvObject =new ModelAndView(ViewType.JSP_VIEW);
		Map<String,String> mapOfTexts=new HashMap<String,String>();
		String baseUrl="http://testpages.eu-gb.mybluemix.net/html/";
		String pageSet[]=new String[]{"dumpptrack.html","hauler.html","aircleaner.html"};
		mvObject.setView("app/ViewOnlineHelpMeterial.jsp");
		try{
			String questionText=request.getParameter("questionText");
			for(String page:pageSet){
			String urlLink=baseUrl+page;	
			List<NameValuePair> list=new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("url",urlLink));
			list.add(new BasicNameValuePair("apikey", "ea58aeb43c6d5141d32a521177493559ca1c97ef"));
			list.add(new BasicNameValuePair("outputMode","json"));
			Request req=Request.Get(urlGetText +"?"+URLEncodedUtils.format(list, "utf-8"));
			Executor executor=Executor.newInstance();
			Response res=executor.execute(req);
			HttpResponse respon=res.returnResponse();
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new InputStreamReader(respon.getEntity().getContent(), "UTF-8"));
			TextExtractionBean text = gson.fromJson(br,  TextExtractionBean.class);
			String responseText=text.getText();
			String searchedText=StringSearch.searchString(responseText, questionText);
			if(searchedText.length()!=0){
				mapOfTexts.put(urlLink, searchedText);
			}
			//mvObject.addModel("helpContent", );
			}
			if(mapOfTexts.isEmpty()){
				mapOfTexts.put("","Search Result is Empty");
			}
			mvObject.addModel("mapOfTexts", mapOfTexts);
			HttpSession session=request.getSession(); 
			Integer	positionOfOperation=(Integer) session.getAttribute("positionOfOperation");
			@SuppressWarnings("unchecked")
			List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
			Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
			JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
			List<OrderOperation> operations=jobDetails.getOperations();
			OrderOperation operation=operations.get(positionOfOperation);
			mvObject.addModel("currentOperation", operation);
			mvObject.addModel("jobDetails",jobDetails);
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return mvObject;
		
	}
	
}
