package com.ibm.app.csm.helper;

public class StringSearch {
public static String searchString(String para,String pattern){
	String []paragraph=para.split("\\|");
	String returnText="";
	for(int i=0;i<paragraph.length;i++){
		String tempPara=paragraph[i].toUpperCase();
		String tempPattern=pattern.toUpperCase();
		if(tempPara.contains(tempPattern))
		{
			returnText+=paragraph[i]+"<br/>";
		}
	}
	return returnText;
}
}
