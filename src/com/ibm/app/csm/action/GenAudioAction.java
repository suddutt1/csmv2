package com.ibm.app.csm.action;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.http.HttpResponse;

import com.ibm.app.csm.alchemy.solution.ImageKeyWords;
import com.ibm.app.csm.alchemy.solution.Solution;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.domain.model.JobDetailsWorker;
import com.ibm.app.csm.helper.JsonUtilityClass;
import com.ibm.app.csm.watson.services.AlchemyImageTaggingService;
import com.ibm.app.csm.watson.services.QuestionAndAnswerService;
import com.ibm.app.csm.watson.services.TexttoSpeech;
import com.ibm.app.csm.watson.solution.EvidenceList;
import com.ibm.app.csm.watson.solution.Question;
import com.ibm.app.web.frmwk.WebActionHandler;
import com.ibm.app.web.frmwk.annotations.RequestMapping;
import com.ibm.app.web.frmwk.bean.ModelAndView;
import com.ibm.app.web.frmwk.bean.ViewType;
import com.ibm.nosql.json.util.Base64;


/**
 * Action class for Watson Api . Public method of this class implements
 * actions related to Watson api and Alchemy Image tag api
 * 
 * @author Raju Parashar
 * 
 * 
 */
public class GenAudioAction implements WebActionHandler {

	

	/**
	 * Play the Speech from the text
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( No VIEW)
	 * 
	 */
	@RequestMapping("genAudio.wss")
	public ModelAndView getAudioFromText(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mvObject= new ModelAndView(ViewType.NO_VIEW);
		String text=request.getParameter("text");
		TexttoSpeech textToSpeech=new TexttoSpeech();
		textToSpeech.processVCAP_Services();
		HttpResponse res;
		res=textToSpeech.texttoSpeech(text,"en-US_AllisonVoice", TexttoSpeech._wavFormat);
		try {
			ServletOutputStream outputStream=response.getOutputStream();
			res.getEntity().writeTo(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mvObject;
	}

	/**
	 * Load View Watson Answer Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("genQA.wss")
	public ModelAndView getAnswerFromQuestion(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mvObject= new ModelAndView(ViewType.JSP_VIEW);
		Map<String,Integer> solutionMap=new LinkedHashMap<String,Integer>();
		String jsonText="";
		String questionText=request.getParameter("questionText");
		String dataSet="healthcare";
		QuestionAndAnswerService qandaService=new QuestionAndAnswerService();
		jsonText=qandaService.AnswerToQuestion(questionText, dataSet);
		jsonText=jsonText.substring(jsonText.indexOf("[")+1,jsonText.lastIndexOf("]") );
		Question solution=JsonUtilityClass.fromJSON(jsonText, Question.class);
		for(EvidenceList e:solution.getQuestion().getEvidenceList())
		solutionMap.put(e.getText(),Math.round(Float.parseFloat(e.getValue())*100.0f));
		mvObject.addModel("solutionMap", solutionMap);
		mvObject.setView("app/viewWatsonAns.jsp");
		
		
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
		return mvObject;
	}

	/**
	 * Load Image Tag Result Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 * @author Suman Mandal , Raju Parashar
	 * 
	 */
	@RequestMapping("getImagefromAlchemy.wss")
	public ModelAndView getTaggedImage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mvObject=new ModelAndView(ViewType.JSP_VIEW);
		byte[] imageByteArray=null;
		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        imageByteArray=item.get();
                    }
                }
            
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }         
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
		AlchemyImageTaggingService alchemyService=new AlchemyImageTaggingService();
		String jsonText=alchemyService.getImageTag(imageByteArray);
		Solution solution= JsonUtilityClass.fromJSON(jsonText, Solution.class);
		Map<String,Integer> mapOfSolutions=new LinkedHashMap<String,Integer>(solution.getImageKeywords().size());
		for(ImageKeyWords imgKeyWords:solution.getImageKeywords()){
			int score=Math.round(Float.parseFloat(imgKeyWords.getScore())*100.0f);
			mapOfSolutions.put(imgKeyWords.getText(), score);
		}
		mvObject.addModel("mapOfSolutions", mapOfSolutions);
		mvObject.setView("app/viewResultOfImageTag.jsp");
		mvObject.addModel("uploadedImage",Base64.encode(imageByteArray));
		
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
		
		return mvObject;
	}
}
