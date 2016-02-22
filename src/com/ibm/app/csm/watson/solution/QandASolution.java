package com.ibm.app.csm.watson.solution;

import java.util.ArrayList;
import java.util.List;

public class QandASolution {
private List<EvidenceList> evidencelist;

public QandASolution(){
	this.evidencelist=new ArrayList<EvidenceList>();
}

public QandASolution(List<EvidenceList> evidencelist) {
	this.evidencelist = evidencelist;
}

public List<EvidenceList> getEvidenceList() {
	return evidencelist;
}

public void setEvidenceList(List<EvidenceList> evidenceList) {
	this.evidencelist = evidenceList;
}

}
