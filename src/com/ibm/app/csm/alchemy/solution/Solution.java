package com.ibm.app.csm.alchemy.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
private List<ImageKeyWords> imageKeywords;

public Solution(){
	imageKeywords=new ArrayList<ImageKeyWords>();
}

public List<ImageKeyWords> getImageKeywords() {
	return imageKeywords;
}

public void setImageKeywords(List<ImageKeyWords> imageKeywords) {
	this.imageKeywords = imageKeywords;
}



}
