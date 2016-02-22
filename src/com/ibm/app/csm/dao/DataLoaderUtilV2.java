package com.ibm.app.csm.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ibm.app.csm.data.CSMUser;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.EquipmentMaster;
import com.ibm.app.csm.data.OperationInstructon;
import com.ibm.app.csm.data.Operations;
import com.ibm.app.csm.data.OrderEmployeeHistory;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderMainHistory;
import com.ibm.app.csm.data.OrderPRTHistory;
import com.ibm.app.csm.data.OrderSparesHistory;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.Problem;
import com.ibm.app.csm.data.SparesMaster;

/**
 * Data loader utility
 * @author SUDDUTT1
 *
 */
public class DataLoaderUtilV2 {

	private static final DateFormat DT_FMT = new SimpleDateFormat("dd.MM.yyyy");
	private static final CSMCommonDAOImpl _daoInstance = new CSMCommonDAOImpl();

	/*public static void main(String[] args) {
		loadOrderPRTHistory();
		loadOrderSparesHistory();
		loadOrderEmployeeHistory();
		loadOrderMainHistory();
		loadProblemMaster();
		loadOperationMaster();
		loadOrderMain();
	}*/
	public static void main(String[] args) {
		loadEquipmentMaster();
		System.out.println("Data loading completed for Equipment Master");
		loadProblemMaster();
		System.out.println("Data loading completed for Problem Master");
		loadOperationMaster();
		System.out.println("Data loading completed for Operation Master");
		loadEmployeeMaster();
		System.out.println("Data loading completed for Employee Master");
		loadPRTMaster();
		System.out.println("Data loading completed for PRT Master");
		loadSparesMaster();
		System.out.println("Data loading completed for Spares Master");
		loadOrderMain();
		System.out.println("Data loading completed for Order Main");
		loadOrderMainHistory();
		System.out.println("Data loading completed for Order Main Hsitroy");
		loadOrderEmployeeHistory();
		System.out.println("Data loading completed for Employee History");
		loadOrderPRTHistory();
		System.out.println("Data loading completed for PRT History");
		loadOrderSparesHistory();
		System.out.println("Data loading completed for Spares History");
		loadOperationInstruction();
		System.out.println("Data loading completed for Operations Instuction");
		loadUsers();
		System.out.println("Data loading completed for User creadentials");
		System.out.println("Data loading completed");
		

	}
	public static void loadUsers()
	{
		String[][] data = new String[][]{
				{"niraj","abcde","03446G","ELEC","niraj@globalmining.com"},
				{"sudip","abcde","470008","MECH","sudip@globalmining.com"},
				{"subha","abcde","03869A","MECH","subha@globalmining.com"},
				{"debi","abcde","470016","MECH","debi@globalmining.com"},
				{"sankar","abcde","470018","SUP","sankar@globalmining.com"},
				{"miler","abcde","470022","ELEC","miler@globalmining.com"},
				{"jackson","abcde","470024","MECH","jackson@globalmining.com"},
				{"prashant","abcde","470030","ELEC","prashant@globalmining.com"},
				{"viswa","abcde","470032","SUP","viswa@globalmining.com"},
				{"peter","abcde","470033","SUP","peter@globalmining.com"},
				{"marie","abcde","470034","ELEC","marie@globalmining.com"},
				{"john","abcde","470035","MECH","john@globalmining.com"},
				{"probal","abcde","875092","SUP","probal@globalmining.com"},
				{"raju","abcde","470009","ELEC","raju@globalmining.com"},
				{"abhisaha","abcde","470007","MECH","abhisaha@globalmining.com"},
				{"nkumar","abcde","470017","ELEC","nkumar@globalmining.com"},
				{"santosh","abcde","470015","MECH","santosh@globalmining.com"},
				{"darwin1","abcde","470025","ELEC","darwin1@globalmining.com"},
				{"darwin2","abcde","470023","MECH","darwin2@globalmining.com"},
				
				}
		;
		for (int index = 0; index < data.length; index++) {
			String[] dataValue = data[index];
			CSMUser dataToSave = new CSMUser();
			dataToSave.setUserId(dataValue[0]);
			dataToSave.setPassword(dataValue[1]);
			dataToSave.setEmpId(dataValue[2]);
			dataToSave.setRole(dataValue[3]);
			dataToSave.setEmailId(dataValue[4]);
			
			_daoInstance.saveCSMUser(dataToSave);
			System.out.println("Load of User registration data "+index + " of "+data.length);
		}
	}
	public static void loadOrderEmployeeHistory()
	{
		String[][] data = new String[][] 
				{
				{"ORDER NUMBER","EMPLOYEE ID","PROBLEM","OPERATION ID","Start Date","End Date","Actual Hours","STATUS","Create Date","Shift","Dept","CATALOG PROFILE"},
				{"10000001","470035","PB0000021","OPR0000002","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000001","470035","PB0000021","OPR0000023","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000001","470035","PB0000021","OPR0000022","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000001","470034","PB0000021","OPR0000038","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000001","470034","PB0000021","OPR0000039","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000001","470035","PB0000021","OPR0000019","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000002","470023","PB0000002","OPR0000017","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000031","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000032","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000033","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000034","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000035","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000036","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470009","PB0000002","OPR0000039","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000002","470023","PB0000002","OPR0000018","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000002","470023","PB0000002","OPR0000019","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000002","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000001","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000010","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000005","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000017","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470022","PB0000001","OPR0000038","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000003","470022","PB0000001","OPR0000039","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000018","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000003","470035","PB0000001","OPR0000019","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000004","470012","PB0000018","OPR0000017","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000004","470012","PB0000018","OPR0000018","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000004","470011","PB0000018","OPR0000032","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000004","470011","PB0000018","OPR0000035","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000004","470011","PB0000018","OPR0000039","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000004","470012","PB0000018","OPR0000019","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000005","470024","PB0000001","OPR0000002","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000001","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000010","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000005","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000017","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","03446G","PB0000001","OPR0000038","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000005","03446G","PB0000001","OPR0000039","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000018","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000005","470024","PB0000001","OPR0000019","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000006","470007","PB0000020","OPR0000024","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000006","470007","PB0000020","OPR0000010","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000006","470017","PB0000020","OPR0000034","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000006","470017","PB0000020","OPR0000035","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000006","470017","PB0000020","OPR0000036","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000006","470007","PB0000020","OPR0000017","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000006","470007","PB0000020","OPR0000018","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000006","470007","PB0000020","OPR0000019","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000007","470015","PB0000021","OPR0000002","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000007","470015","PB0000021","OPR0000023","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000007","470015","PB0000021","OPR0000022","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000007","470009","PB0000021","OPR0000038","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000007","470009","PB0000021","OPR0000039","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000007","470015","PB0000021","OPR0000019","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000008","03869A","PB0000006","OPR0000002","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000010","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000024","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000010","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","470022","PB0000006","OPR0000034","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000008","470022","PB0000006","OPR0000035","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000008","470022","PB0000006","OPR0000036","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000017","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000018","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000008","03869A","PB0000006","OPR0000019","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000009","470024","PB0000027","OPR0000007","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000009","470024","PB0000027","OPR0000019","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000010","470024","PB0000027","OPR0000007","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000010","470024","PB0000027","OPR0000019","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000011","470024","PB0000027","OPR0000007","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000011","470024","PB0000027","OPR0000019","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000002","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000001","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000010","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000005","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000017","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470022","PB0000001","OPR0000038","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000012","470031","PB0000001","OPR0000039","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000018","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000012","470035","PB0000001","OPR0000019","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000013","470013","PB0000020","OPR0000024","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000013","470013","PB0000020","OPR0000010","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000013","470019","PB0000020","OPR0000034","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000013","470019","PB0000020","OPR0000035","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000013","470019","PB0000020","OPR0000036","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","C","Electrical","HAUL"},
				{"10000013","470013","PB0000020","OPR0000017","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000013","470013","PB0000020","OPR0000018","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000013","470013","PB0000020","OPR0000019","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","C","Mechanical","HAUL"},
				{"10000014","470023","PB0000018","OPR0000017","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000014","470023","PB0000018","OPR0000018","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000014","470025","PB0000018","OPR0000032","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000014","470025","PB0000018","OPR0000035","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000014","470025","PB0000018","OPR0000039","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Electrical","HAUL"},
				{"10000014","470023","PB0000018","OPR0000019","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","B","Mechanical","HAUL"},
				{"10000015","470024","PB0000021","OPR0000002","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000015","470024","PB0000021","OPR0000023","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000015","470024","PB0000021","OPR0000022","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000015","03446G","PB0000021","OPR0000038","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000015","03446G","PB0000021","OPR0000039","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000015","470024","PB0000021","OPR0000019","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000016","470016","PB0000018","OPR0000017","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000016","470016","PB0000018","OPR0000018","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000016","470034","PB0000018","OPR0000032","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000016","470034","PB0000018","OPR0000035","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000016","470034","PB0000018","OPR0000039","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Electrical","HAUL"},
				{"10000016","470016","PB0000018","OPR0000019","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","A","Mechanical","HAUL"},
				{"10000017","03869A","PB0000010","OPR0000002","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000017","03869A","PB0000010","OPR0000023","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000017","03869A","PB0000010","OPR0000018","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000017","03446G","PB0000010","OPR0000031","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000017","03869A","PB0000010","OPR0000019","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000018","470031","PB0000012","OPR0000024","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","B","Mechanical","DUMP"},
				{"10000018","470031","PB0000012","OPR0000010","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","B","Mechanical","DUMP"},
				{"10000018","470009","PB0000012","OPR0000034","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","B","Electrical","DUMP"},
				{"10000018","470009","PB0000012","OPR0000035","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","B","Electrical","DUMP"},
				{"10000018","470009","PB0000012","OPR0000036","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","B","Electrical","DUMP"},
				{"10000018","470031","PB0000012","OPR0000017","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","B","Mechanical","DUMP"},
				{"10000018","470031","PB0000012","OPR0000018","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","B","Mechanical","DUMP"},
				{"10000018","470031","PB0000012","OPR0000019","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","B","Mechanical","DUMP"},
				{"10000019","470008","PB0000013","OPR0000002","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000019","470008","PB0000013","OPR0000023","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000019","470008","PB0000013","OPR0000022","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000019","470034","PB0000013","OPR0000038","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000019","470034","PB0000013","OPR0000039","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000019","470008","PB0000013","OPR0000019","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000020","470035","PB0000009","OPR0000017","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000020","470035","PB0000009","OPR0000018","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000020","470034","PB0000009","OPR0000032","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000020","470034","PB0000009","OPR0000035","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000020","470034","PB0000009","OPR0000039","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000020","470035","PB0000009","OPR0000019","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000021","470016","PB0000012","OPR0000024","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000021","470016","PB0000012","OPR0000010","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000021","03446G","PB0000012","OPR0000034","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000021","03446G","PB0000012","OPR0000035","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000021","03446G","PB0000012","OPR0000036","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Electrical","DUMP"},
				{"10000021","470016","PB0000012","OPR0000017","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000021","470016","PB0000012","OPR0000018","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000021","470016","PB0000012","OPR0000019","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","DUMP"},
				{"10000022","470007","PB0000003","OPR0000002","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000022","470025","PB0000003","OPR0000016","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000022","470007","PB0000003","OPR0000024","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000022","470007","PB0000003","OPR0000010","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000022","470025","PB0000003","OPR0000034","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000022","470025","PB0000003","OPR0000035","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000022","470025","PB0000003","OPR0000036","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000022","470007","PB0000003","OPR0000017","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000022","470007","PB0000003","OPR0000018","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000022","470007","PB0000003","OPR0000019","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000023","470016","PB0000008","OPR0000002","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000023","470016","PB0000008","OPR0000010","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000023","470016","PB0000008","OPR0000017","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000023","470030","PB0000008","OPR0000016","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000023","470016","PB0000008","OPR0000018","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000023","470030","PB0000008","OPR0000031","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000023","470030","PB0000008","OPR0000039","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000023","470016","PB0000008","OPR0000019","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000002","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000024","470017","PB0000003","OPR0000016","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000024","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000010","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000024","470017","PB0000003","OPR0000034","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000024","470017","PB0000003","OPR0000035","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000024","470017","PB0000003","OPR0000036","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000017","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000018","01.02.2014","01.02.2014","15","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000024","470015","PB0000003","OPR0000019","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000025","03869A","PB0000008","OPR0000002","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000025","03869A","PB0000008","OPR0000010","01.02.2014","01.02.2014","16","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000025","03869A","PB0000008","OPR0000017","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000025","470034","PB0000008","OPR0000016","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000025","03869A","PB0000008","OPR0000018","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000025","470034","PB0000008","OPR0000031","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000025","470034","PB0000008","OPR0000039","01.02.2014","01.02.2014","11","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000025","03869A","PB0000008","OPR0000019","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","470035","PB0000003","OPR0000002","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","03446G","PB0000003","OPR0000016","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000026","470016","PB0000003","OPR0000024","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","470024","PB0000003","OPR0000010","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","03446G","PB0000003","OPR0000034","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000026","03446G","PB0000003","OPR0000035","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000026","03446G","PB0000003","OPR0000036","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000026","470024","PB0000003","OPR0000017","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","470016","PB0000003","OPR0000018","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000026","470016","PB0000003","OPR0000019","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000027","470016","PB0000008","OPR0000002","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000027","470016","PB0000008","OPR0000010","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000027","470016","PB0000008","OPR0000017","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000027","470030","PB0000008","OPR0000016","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000027","470016","PB0000008","OPR0000018","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000027","470030","PB0000008","OPR0000031","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000027","470030","PB0000008","OPR0000039","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000027","470016","PB0000008","OPR0000019","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000002","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000028","470017","PB0000003","OPR0000016","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000024","01.02.2014","01.02.2014","10","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000010","01.02.2014","01.02.2014","8","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000028","470017","PB0000003","OPR0000034","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000028","470017","PB0000003","OPR0000035","01.02.2014","01.02.2014","19","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000028","470017","PB0000003","OPR0000036","01.02.2014","01.02.2014","18","COMPLETED","01.02.2014","B","Electrical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000017","01.02.2014","01.02.2014","14","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000018","01.02.2014","01.02.2014","6","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000028","470031","PB0000003","OPR0000019","01.02.2014","01.02.2014","17","COMPLETED","01.02.2014","B","Mechanical","EXCA"},
				{"10000029","03869A","PB0000008","OPR0000002","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000029","03869A","PB0000008","OPR0000010","01.02.2014","01.02.2014","13","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000029","03869A","PB0000008","OPR0000017","01.02.2014","01.02.2014","5","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000029","470034","PB0000008","OPR0000016","01.02.2014","01.02.2014","9","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000029","470016","PB0000008","OPR0000018","01.02.2014","01.02.2014","12","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				{"10000029","470034","PB0000008","OPR0000031","01.02.2014","01.02.2014","4","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000029","470034","PB0000008","OPR0000039","01.02.2014","01.02.2014","20","COMPLETED","01.02.2014","A","Electrical","EXCA"},
				{"10000029","470016","PB0000008","OPR0000019","01.02.2014","01.02.2014","7","COMPLETED","01.02.2014","A","Mechanical","EXCA"},
				}
;
		
		for (int index = 1; index < data.length; index++) {
			
			String[] header = {"ORDER NUMBER","EMPLOYEE ID","PROBLEM","OPERATION ID",
					"Start Date","End Date","Actual Hours","STATUS","Create Date"};
			String[] dataValue = data[index];
			OrderEmployeeHistory dataToSave = new OrderEmployeeHistory();
			dataToSave.setOrderNumber(dataValue[0]);
			dataToSave.setEmployeeId(dataValue[1]);
			dataToSave.setProblem(dataValue[2]);
			dataToSave.setOperationId(dataValue[3]);
			dataToSave.setStartDate(getDate(dataValue[4]));
			dataToSave.setEndDate(getDate(dataValue[5]));
			dataToSave.setActualHours(getLong(dataValue[6]));
			dataToSave.setStatus(dataValue[7]);
			dataToSave.setAssignedDate(getDate(dataValue[8]));

			_daoInstance.saveOrderEmployeeHistory(dataToSave);
			System.out.println("Load of Order Employee History "+(index +1)+ " of "+data.length);
		}
		System.out.println("Load complete Order Employee history");
	}
	public static void loadOperationInstruction()
	{
		String[][] data = new String[][] 
				{
				{"Operation Id","Steps"},
				{"OPR0000001","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000001","Open the right side cover."},
				{"OPR0000001","Remove the hydraulic filter."},
				{"OPR0000001","Clean the housing where the filter gasket makes contact."},
				{"OPR0000001","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000001","Open the tailgate."},
				{"OPR0000001","Remove the filter."},
				{"OPR0000001","Clean the housing where the filter gasket makes contact."},
				{"OPR0000001","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000002","Open the tailgate."},
				{"OPR0000002","If it is necessary to use a booster battery to start the engine, BE CAREFUL! There must be one person in the operator’s seat and one person to connect and disconnect the battery cables."},
				{"OPR0000002","Be sure the key switch is OFF. The booster battery must be 12 volt."},
				{"OPR0000002","Connect one end of the first cable to the positive terminal of the booster battery. Connect the other end of the same cable to the positive terminal of the excavator starter."},
				{"OPR0000002","Connect one end of the second cable to the negative terminal of the booster battery. Connect the other end of the same cable to the negative excavator cable where it is attached to the frame."},
				{"OPR0000002","Start the engine. After the engine has started, remove the ground cable first"},
				{"OPR0000002","Disconnect the cable from the excavator starter"},
				{"OPR0000003","Open the right side cover."},
				{"OPR0000003","Disconnect the negative cable first."},
				{"OPR0000003","Disconnect the positive cable"},
				{"OPR0000003","Remove the bolts and remove the hold down clamp."},
				{"OPR0000003","Remove the battery."},
				{"OPR0000003","Always clean the terminals and the cable ends, even when installing a new battery."},
				{"OPR0000003","Install the battery. Install the hold down clamp and tighten"},
				{"OPR0000003","the bolts."},
				{"OPR0000003","Connect the battery cables. Connect the negative cable last to prevent sparks"},
				{"OPR0000004","Put the machine on a flat level surface."},
				{"OPR0000004","Retract the arm and bucket cylinders, put the bucket on the ground and lower the blade. Stop the engine."},
				{"OPR0000004","Open the tailgate."},
				{"OPR0000004","Check the hydraulic fluid level, it must be visible in the sight gauge."},
				{"OPR0000004","Clean the surface around the reservoir (breather) cap and remove the cap from the reservoir"},
				{"OPR0000004","Check the condition of the fill strainer screen. Clean or replace as necessary."},
				{"OPR0000004","Be sure the screen is installed before adding fluid."},
				{"OPR0000004","Add the correct fluid to the reservoir until it is visible in the sight gauge."},
				{"OPR0000004","Check the cap and clean as necessary. Replace the cap if damaged."},
				{"OPR0000004","Install the cap."},
				{"OPR0000004","Close the tailgate."},
				{"OPR0000005","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000005","Retract the arm and bucket cylinders, lower the bucket to the ground. Stop the engine."},
				{"OPR0000005","Open the tailgate."},
				{"OPR0000005","Remove the drain plug."},
				{"OPR0000005","Drain the fluid into a container."},
				{"OPR0000005","Recycle or dispose of the fluid in an environmentally safe manner."},
				{"OPR0000005","Install the drain plug."},
				{"OPR0000005","Add the correct fluid to the reservoir until it is visible in the sight gauge"},
				{"OPR0000005","Open the bleed valve or loosen the plug on the hydraulic pump. Close the valve or plug after a steady stream of hydraulic fluid free of any air bubbles drains from the valve. Tighten the bleed valve."},
				{"OPR0000005","DO NOT RUN THE MACHINE WITH THE BLEED VALVE OR PLUG OPEN."},
				{"OPR0000005","Run the machine through the hydraulic functions. Stop the engine. Check the fluid level and add as needed."},
				{"OPR0000006","See the SERVICE SCHEDULE for the correct service"},
				{"OPR0000006","interval."},
				{"OPR0000006","Do not operate the excavator with a defective exhaust"},
				{"OPR0000006","system."},
				{"OPR0000006","Stop the engine. Open the tailgate."},
				{"OPR0000006","Remove the plug from the bottom of the silencer.Start the engine and run for about 10 seconds while a second person, wearing safety glasses, holds a piece of wood over the outlet of the silencer. The carbon deposits will be forced out of the silencer plug hole."},
				{"OPR0000006","Stop the engine. Install and tighten the plug."},
				{"OPR0000006","Close the tailgate."},
				{"OPR0000006","Raise one side of the machine approximately 100 mm using the boom and arm"},
				{"OPR0000006","Raise the blade fully and install jackstands under the blade and track frame. Lower the boom until all machine weight is on the jackstands."},
				{"OPR0000007","Park the excavator on a level surface with the plugs in the position as shown."},
				{"OPR0000007","Remove the plug. The lube level must be at the bottom edge of the hole."},
				{"OPR0000007","Add lubricant through the hole if the lube level is low."},
				{"OPR0000007","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000007","Park the excavator on a level surface with plugs in the position shown. Remove both plugs and drain the lubricant into a container."},
				{"OPR0000007","Install the bottom plug. Add lubricant through the top plug hole until the lube level is at the bottom edge of the hole."},
				{"OPR0000007","Install the plug."},
				{"OPR0000008","Loosen the two bolts from the cover. "},
				{"OPR0000008","Pivot the cover downwards."},
				{"OPR0000008","Open the tailgate."},
				{"OPR0000008","Check the belt tension (Item 1) [Figure PM-48] midway between the alternator and belt tensioner. The belt deflection should be 13 mm."},
				{"OPR0000008","Loosen the belt tensioner bolt and move the tensioner away from the engine until the belt tension is correct."},
				{"OPR0000008","Tighten the bolt to 20-25 Nm torque."},
				{"OPR0000009","Position the bucket so the bucket teeth are at a 30° angle up from the ground for accessibility to the teeth."},
				{"OPR0000009","Lower the boom until the bucket is fully on the ground."},
				{"OPR0000009","Stop the engine and dismount from the excavator."},
				{"OPR0000009","Remove the retaining pin from the tooth point"},
				{"OPR0000009","Remove the tooth point from the shank"},
				{"OPR0000009","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000009","Remove the two nuts and bolts from the tooth shank. Remove the tooth shank."},
				{"OPR0000009","Tighten the nuts to 125 - 135 N•m torque."},
				{"OPR0000009","The removal and installation procedure for the later style tooth point and tooth shank is the same as the early style."},
				{"OPR0000009","The later style tooth has a unique retaining pin (Item 1)."},
				{"OPR0000009","The retaining pin must be installed as shown for proper fit and tooth retention. The side of the tooth point also shows the correct orientation of the retaining pin."},
				{"OPR0000009","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000010","Lubricate the hydraulic excavator as specified in the SERVICE SCHEDULE for the best performance of the machine."},
				{"OPR0000010","Always use a good quality lithium based multipurpose grease when lubricating the machine. "},
				{"OPR0000010","Apply the lubricant until extra grease shows."},
				{"OPR0000010","Lubricate the following locations on the Hydraulic Excavator EVERY 8-10 HOURS:"},
				{"OPR0000010","Install 3 to 4 pumps of grease then rotate the upperstructure 90°."},
				{"OPR0000010","Install 3 to 4 pumps of grease and again rotate the upperstructure 90°."},
				{"OPR0000010","Repeat this until the slew pinion has been greased at four positions."},
				{"OPR0000010","Stop the engine and dismount from the excavator."},
				{"OPR0000011","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000011","Open the right side cover."},
				{"OPR0000011","Remove the hydraulic filter."},
				{"OPR0000011","Clean the housing where the filter gasket makes contact."},
				{"OPR0000011","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000011","Open the tailgate."},
				{"OPR0000011","Remove the filter."},
				{"OPR0000011","Clean the housing where the filter gasket makes contact."},
				{"OPR0000011","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000012","Open the tailgate."},
				{"OPR0000012","If it is necessary to use a booster battery to start the engine, BE CAREFUL! There must be one person in the operator’s seat and one person to connect and disconnect the battery cables."},
				{"OPR0000012","Be sure the key switch is OFF. The booster battery must be 12 volt."},
				{"OPR0000012","Connect one end of the first cable to the positive terminal of the booster battery. Connect the other end of the same cable to the positive terminal of the excavator starter."},
				{"OPR0000012","Connect one end of the second cable to the negative terminal of the booster battery. Connect the other end of the same cable to the negative excavator cable where it is attached to the frame."},
				{"OPR0000012","Start the engine. After the engine has started, remove the ground cable first"},
				{"OPR0000012","Disconnect the cable from the excavator starter"},
				{"OPR0000013","Open the right side cover."},
				{"OPR0000013","Disconnect the negative cable first."},
				{"OPR0000013","Disconnect the positive cable"},
				{"OPR0000013","Remove the bolts and remove the hold down clamp."},
				{"OPR0000013","Remove the battery."},
				{"OPR0000013","Always clean the terminals and the cable ends, even when installing a new battery."},
				{"OPR0000013","Install the battery. Install the hold down clamp and tighten"},
				{"OPR0000013","the bolts."},
				{"OPR0000013","Connect the battery cables. Connect the negative cable last to prevent sparks"},
				{"OPR0000014","Put the machine on a flat level surface."},
				{"OPR0000014","Retract the arm and bucket cylinders, put the bucket on the ground and lower the blade. Stop the engine."},
				{"OPR0000014","Open the tailgate."},
				{"OPR0000014","Check the hydraulic fluid level, it must be visible in the sight gauge."},
				{"OPR0000014","Clean the surface around the reservoir (breather) cap and remove the cap from the reservoir"},
				{"OPR0000014","Check the condition of the fill strainer screen. Clean or replace as necessary."},
				{"OPR0000014","Be sure the screen is installed before adding fluid."},
				{"OPR0000014","Add the correct fluid to the reservoir until it is visible in the sight gauge."},
				{"OPR0000014","Check the cap and clean as necessary. Replace the cap if damaged."},
				{"OPR0000014","Install the cap."},
				{"OPR0000014","Close the tailgate."},
				{"OPR0000015","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000015","Retract the arm and bucket cylinders, lower the bucket to the ground. Stop the engine."},
				{"OPR0000015","Open the tailgate."},
				{"OPR0000015","Remove the drain plug."},
				{"OPR0000015","Drain the fluid into a container."},
				{"OPR0000015","Recycle or dispose of the fluid in an environmentally safe manner."},
				{"OPR0000015","Install the drain plug."},
				{"OPR0000015","Add the correct fluid to the reservoir until it is visible in the sight gauge"},
				{"OPR0000015","Open the bleed valve or loosen the plug on the hydraulic pump. Close the valve or plug after a steady stream of hydraulic fluid free of any air bubbles drains from the valve. Tighten the bleed valve."},
				{"OPR0000015","DO NOT RUN THE MACHINE WITH THE BLEED VALVE OR PLUG OPEN."},
				{"OPR0000015","Run the machine through the hydraulic functions. Stop the engine. Check the fluid level and add as needed."},
				{"OPR0000016","See the SERVICE SCHEDULE for the correct service"},
				{"OPR0000016","interval."},
				{"OPR0000016","Do not operate the excavator with a defective exhaust"},
				{"OPR0000016","system."},
				{"OPR0000016","Stop the engine. Open the tailgate."},
				{"OPR0000016","Remove the plug from the bottom of the silencer.Start the engine and run for about 10 seconds while a second person, wearing safety glasses, holds a piece of wood over the outlet of the silencer. The carbon deposits will be forced out of the silencer plug hole."},
				{"OPR0000016","Stop the engine. Install and tighten the plug."},
				{"OPR0000016","Close the tailgate."},
				{"OPR0000016","Raise one side of the machine approximately 100 mm using the boom and arm"},
				{"OPR0000016","Raise the blade fully and install jackstands under the blade and track frame. Lower the boom until all machine weight is on the jackstands."},
				{"OPR0000017","Park the excavator on a level surface with the plugs in the position as shown."},
				{"OPR0000017","Remove the plug. The lube level must be at the bottom edge of the hole."},
				{"OPR0000017","Add lubricant through the hole if the lube level is low."},
				{"OPR0000017","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000017","Park the excavator on a level surface with plugs in the position shown. Remove both plugs and drain the lubricant into a container."},
				{"OPR0000017","Install the bottom plug. Add lubricant through the top plug hole until the lube level is at the bottom edge of the hole."},
				{"OPR0000017","Install the plug."},
				{"OPR0000018","Loosen the two bolts from the cover. "},
				{"OPR0000018","Pivot the cover downwards."},
				{"OPR0000018","Open the tailgate."},
				{"OPR0000018","Check the belt tension (Item 1) [Figure PM-48] midway between the alternator and belt tensioner. The belt deflection should be 13 mm."},
				{"OPR0000018","Loosen the belt tensioner bolt and move the tensioner away from the engine until the belt tension is correct."},
				{"OPR0000018","Tighten the bolt to 20-25 Nm torque."},
				{"OPR0000019","Position the bucket so the bucket teeth are at a 30° angle up from the ground for accessibility to the teeth."},
				{"OPR0000019","Lower the boom until the bucket is fully on the ground."},
				{"OPR0000019","Stop the engine and dismount from the excavator."},
				{"OPR0000019","Remove the retaining pin from the tooth point"},
				{"OPR0000019","Remove the tooth point from the shank"},
				{"OPR0000019","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000019","Remove the two nuts and bolts from the tooth shank. Remove the tooth shank."},
				{"OPR0000019","Tighten the nuts to 125 - 135 N•m torque."},
				{"OPR0000019","The removal and installation procedure for the later style tooth point and tooth shank is the same as the early style."},
				{"OPR0000019","The later style tooth has a unique retaining pin (Item 1)."},
				{"OPR0000019","The retaining pin must be installed as shown for proper fit and tooth retention. The side of the tooth point also shows the correct orientation of the retaining pin."},
				{"OPR0000019","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000020","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000020","Open the right side cover."},
				{"OPR0000020","Remove the hydraulic filter."},
				{"OPR0000020","Clean the housing where the filter gasket makes contact."},
				{"OPR0000020","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000020","Open the tailgate."},
				{"OPR0000020","Remove the filter."},
				{"OPR0000020","Clean the housing where the filter gasket makes contact."},
				{"OPR0000020","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000021","Open the tailgate."},
				{"OPR0000021","If it is necessary to use a booster battery to start the engine, BE CAREFUL! There must be one person in the operator’s seat and one person to connect and disconnect the battery cables."},
				{"OPR0000021","Be sure the key switch is OFF. The booster battery must be 12 volt."},
				{"OPR0000021","Connect one end of the first cable to the positive terminal of the booster battery. Connect the other end of the same cable to the positive terminal of the excavator starter."},
				{"OPR0000021","Connect one end of the second cable to the negative terminal of the booster battery. Connect the other end of the same cable to the negative excavator cable where it is attached to the frame."},
				{"OPR0000021","Start the engine. After the engine has started, remove the ground cable first"},
				{"OPR0000021","Disconnect the cable from the excavator starter"},
				{"OPR0000022","Open the right side cover."},
				{"OPR0000022","Disconnect the negative cable first."},
				{"OPR0000022","Disconnect the positive cable"},
				{"OPR0000022","Remove the bolts and remove the hold down clamp."},
				{"OPR0000022","Remove the battery."},
				{"OPR0000022","Always clean the terminals and the cable ends, even when installing a new battery."},
				{"OPR0000022","Install the battery. Install the hold down clamp and tighten"},
				{"OPR0000022","the bolts."},
				{"OPR0000022","Connect the battery cables. Connect the negative cable last to prevent sparks"},
				{"OPR0000023","Put the machine on a flat level surface."},
				{"OPR0000023","Retract the arm and bucket cylinders, put the bucket on the ground and lower the blade. Stop the engine."},
				{"OPR0000023","Open the tailgate."},
				{"OPR0000023","Check the hydraulic fluid level, it must be visible in the sight gauge."},
				{"OPR0000023","Clean the surface around the reservoir (breather) cap and remove the cap from the reservoir"},
				{"OPR0000023","Check the condition of the fill strainer screen. Clean or replace as necessary."},
				{"OPR0000023","Be sure the screen is installed before adding fluid."},
				{"OPR0000023","Add the correct fluid to the reservoir until it is visible in the sight gauge."},
				{"OPR0000023","Check the cap and clean as necessary. Replace the cap if damaged."},
				{"OPR0000023","Install the cap."},
				{"OPR0000023","Close the tailgate."},
				{"OPR0000024","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000024","Retract the arm and bucket cylinders, lower the bucket to the ground. Stop the engine."},
				{"OPR0000024","Open the tailgate."},
				{"OPR0000024","Remove the drain plug."},
				{"OPR0000024","Drain the fluid into a container."},
				{"OPR0000024","Recycle or dispose of the fluid in an environmentally safe manner."},
				{"OPR0000024","Install the drain plug."},
				{"OPR0000024","Add the correct fluid to the reservoir until it is visible in the sight gauge"},
				{"OPR0000024","Open the bleed valve or loosen the plug on the hydraulic pump. Close the valve or plug after a steady stream of hydraulic fluid free of any air bubbles drains from the valve. Tighten the bleed valve."},
				{"OPR0000024","DO NOT RUN THE MACHINE WITH THE BLEED VALVE OR PLUG OPEN."},
				{"OPR0000024","Run the machine through the hydraulic functions. Stop the engine. Check the fluid level and add as needed."},
				{"OPR0000025","See the SERVICE SCHEDULE for the correct service"},
				{"OPR0000025","interval."},
				{"OPR0000025","Do not operate the excavator with a defective exhaust"},
				{"OPR0000025","system."},
				{"OPR0000025","Stop the engine. Open the tailgate."},
				{"OPR0000025","Remove the plug from the bottom of the silencer.Start the engine and run for about 10 seconds while a second person, wearing safety glasses, holds a piece of wood over the outlet of the silencer. The carbon deposits will be forced out of the silencer plug hole."},
				{"OPR0000025","Stop the engine. Install and tighten the plug."},
				{"OPR0000025","Close the tailgate."},
				{"OPR0000025","Raise one side of the machine approximately 100 mm using the boom and arm"},
				{"OPR0000025","Raise the blade fully and install jackstands under the blade and track frame. Lower the boom until all machine weight is on the jackstands."},
				{"OPR0000026","Park the excavator on a level surface with the plugs in the position as shown."},
				{"OPR0000026","Remove the plug. The lube level must be at the bottom edge of the hole."},
				{"OPR0000026","Add lubricant through the hole if the lube level is low."},
				{"OPR0000026","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000026","Park the excavator on a level surface with plugs in the position shown. Remove both plugs and drain the lubricant into a container."},
				{"OPR0000026","Install the bottom plug. Add lubricant through the top plug hole until the lube level is at the bottom edge of the hole."},
				{"OPR0000026","Install the plug."},
				{"OPR0000027","Loosen the two bolts from the cover. "},
				{"OPR0000027","Pivot the cover downwards."},
				{"OPR0000027","Open the tailgate."},
				{"OPR0000027","Check the belt tension (Item 1) [Figure PM-48] midway between the alternator and belt tensioner. The belt deflection should be 13 mm."},
				{"OPR0000027","Loosen the belt tensioner bolt and move the tensioner away from the engine until the belt tension is correct."},
				{"OPR0000027","Tighten the bolt to 20-25 Nm torque."},
				{"OPR0000028","Position the bucket so the bucket teeth are at a 30° angle up from the ground for accessibility to the teeth."},
				{"OPR0000028","Lower the boom until the bucket is fully on the ground."},
				{"OPR0000028","Stop the engine and dismount from the excavator."},
				{"OPR0000028","Remove the retaining pin from the tooth point"},
				{"OPR0000028","Remove the tooth point from the shank"},
				{"OPR0000028","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000028","Remove the two nuts and bolts from the tooth shank. Remove the tooth shank."},
				{"OPR0000028","Tighten the nuts to 125 - 135 N•m torque."},
				{"OPR0000028","The removal and installation procedure for the later style tooth point and tooth shank is the same as the early style."},
				{"OPR0000028","The later style tooth has a unique retaining pin (Item 1)."},
				{"OPR0000028","The retaining pin must be installed as shown for proper fit and tooth retention. The side of the tooth point also shows the correct orientation of the retaining pin."},
				{"OPR0000028","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000029","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000029","Open the right side cover."},
				{"OPR0000029","Remove the hydraulic filter."},
				{"OPR0000029","Clean the housing where the filter gasket makes contact."},
				{"OPR0000029","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000029","Open the tailgate."},
				{"OPR0000029","Remove the filter."},
				{"OPR0000029","Clean the housing where the filter gasket makes contact."},
				{"OPR0000029","Put clean hydraulic fluid on the gasket. Install the new filter and tighten by hand only."},
				{"OPR0000030","Open the tailgate."},
				{"OPR0000030","If it is necessary to use a booster battery to start the engine, BE CAREFUL! There must be one person in the operator’s seat and one person to connect and disconnect the battery cables."},
				{"OPR0000030","Be sure the key switch is OFF. The booster battery must be 12 volt."},
				{"OPR0000030","Connect one end of the first cable to the positive terminal of the booster battery. Connect the other end of the same cable to the positive terminal of the excavator starter."},
				{"OPR0000030","Connect one end of the second cable to the negative terminal of the booster battery. Connect the other end of the same cable to the negative excavator cable where it is attached to the frame."},
				{"OPR0000030","Start the engine. After the engine has started, remove the ground cable first"},
				{"OPR0000030","Disconnect the cable from the excavator starter"},
				{"OPR0000031","Open the right side cover."},
				{"OPR0000031","Disconnect the negative cable first."},
				{"OPR0000031","Disconnect the positive cable"},
				{"OPR0000031","Remove the bolts and remove the hold down clamp."},
				{"OPR0000031","Remove the battery."},
				{"OPR0000031","Always clean the terminals and the cable ends, even when installing a new battery."},
				{"OPR0000031","Install the battery. Install the hold down clamp and tighten"},
				{"OPR0000031","the bolts."},
				{"OPR0000031","Connect the battery cables. Connect the negative cable last to prevent sparks"},
				{"OPR0000032","Put the machine on a flat level surface."},
				{"OPR0000032","Retract the arm and bucket cylinders, put the bucket on the ground and lower the blade. Stop the engine."},
				{"OPR0000032","Open the tailgate."},
				{"OPR0000032","Check the hydraulic fluid level, it must be visible in the sight gauge."},
				{"OPR0000032","Clean the surface around the reservoir (breather) cap and remove the cap from the reservoir"},
				{"OPR0000032","Check the condition of the fill strainer screen. Clean or replace as necessary."},
				{"OPR0000032","Be sure the screen is installed before adding fluid."},
				{"OPR0000032","Add the correct fluid to the reservoir until it is visible in the sight gauge."},
				{"OPR0000032","Check the cap and clean as necessary. Replace the cap if damaged."},
				{"OPR0000032","Install the cap."},
				{"OPR0000032","Close the tailgate."},
				{"OPR0000033","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000033","Retract the arm and bucket cylinders, lower the bucket to the ground. Stop the engine."},
				{"OPR0000033","Open the tailgate."},
				{"OPR0000033","Remove the drain plug."},
				{"OPR0000033","Drain the fluid into a container."},
				{"OPR0000033","Recycle or dispose of the fluid in an environmentally safe manner."},
				{"OPR0000033","Install the drain plug."},
				{"OPR0000033","Add the correct fluid to the reservoir until it is visible in the sight gauge"},
				{"OPR0000033","Open the bleed valve or loosen the plug on the hydraulic pump. Close the valve or plug after a steady stream of hydraulic fluid free of any air bubbles drains from the valve. Tighten the bleed valve."},
				{"OPR0000033","DO NOT RUN THE MACHINE WITH THE BLEED VALVE OR PLUG OPEN."},
				{"OPR0000033","Run the machine through the hydraulic functions. Stop the engine. Check the fluid level and add as needed."},
				{"OPR0000034","See the SERVICE SCHEDULE for the correct service"},
				{"OPR0000034","interval."},
				{"OPR0000034","Do not operate the excavator with a defective exhaust"},
				{"OPR0000034","system."},
				{"OPR0000034","Stop the engine. Open the tailgate."},
				{"OPR0000034","Remove the plug from the bottom of the silencer.Start the engine and run for about 10 seconds while a second person, wearing safety glasses, holds a piece of wood over the outlet of the silencer. The carbon deposits will be forced out of the silencer plug hole."},
				{"OPR0000034","Stop the engine. Install and tighten the plug."},
				{"OPR0000034","Close the tailgate."},
				{"OPR0000034","Raise one side of the machine approximately 100 mm using the boom and arm"},
				{"OPR0000034","Raise the blade fully and install jackstands under the blade and track frame. Lower the boom until all machine weight is on the jackstands."},
				{"OPR0000035","Park the excavator on a level surface with the plugs in the position as shown."},
				{"OPR0000035","Remove the plug. The lube level must be at the bottom edge of the hole."},
				{"OPR0000035","Add lubricant through the hole if the lube level is low."},
				{"OPR0000035","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000035","Park the excavator on a level surface with plugs in the position shown. Remove both plugs and drain the lubricant into a container."},
				{"OPR0000035","Install the bottom plug. Add lubricant through the top plug hole until the lube level is at the bottom edge of the hole."},
				{"OPR0000035","Install the plug."},
				{"OPR0000036","Loosen the two bolts from the cover. "},
				{"OPR0000036","Pivot the cover downwards."},
				{"OPR0000036","Open the tailgate."},
				{"OPR0000036","Check the belt tension (Item 1) [Figure PM-48] midway between the alternator and belt tensioner. The belt deflection should be 13 mm."},
				{"OPR0000036","Loosen the belt tensioner bolt and move the tensioner away from the engine until the belt tension is correct."},
				{"OPR0000036","Tighten the bolt to 20-25 Nm torque."},
				{"OPR0000037","Position the bucket so the bucket teeth are at a 30° angle up from the ground for accessibility to the teeth."},
				{"OPR0000037","Lower the boom until the bucket is fully on the ground."},
				{"OPR0000037","Stop the engine and dismount from the excavator."},
				{"OPR0000037","Remove the retaining pin from the tooth point"},
				{"OPR0000037","Remove the tooth point from the shank"},
				{"OPR0000037","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000037","Remove the two nuts and bolts from the tooth shank. Remove the tooth shank."},
				{"OPR0000037","Tighten the nuts to 125 - 135 N•m torque."},
				{"OPR0000037","The removal and installation procedure for the later style tooth point and tooth shank is the same as the early style."},
				{"OPR0000037","The later style tooth has a unique retaining pin (Item 1)."},
				{"OPR0000037","The retaining pin must be installed as shown for proper fit and tooth retention. The side of the tooth point also shows the correct orientation of the retaining pin."},
				{"OPR0000037","Position the new tooth point on the shank and install a new retaining pin. Install the retaining pin until it is flush with the top of the point."},
				{"OPR0000038","See the SERVICE SCHEDULE for the correct service"},
				{"OPR0000038","interval."},
				{"OPR0000038","Do not operate the excavator with a defective exhaust"},
				{"OPR0000038","system."},
				{"OPR0000038","Stop the engine. Open the tailgate."},
				{"OPR0000038","Remove the plug from the bottom of the silencer.Start the engine and run for about 10 seconds while a second person, wearing safety glasses, holds a piece of wood over the outlet of the silencer. The carbon deposits will be forced out of the silencer plug hole."},
				{"OPR0000038","Stop the engine. Install and tighten the plug."},
				{"OPR0000038","Close the tailgate."},
				{"OPR0000038","Raise one side of the machine approximately 100 mm using the boom and arm"},
				{"OPR0000038","Raise the blade fully and install jackstands under the blade and track frame. Lower the boom until all machine weight is on the jackstands."},
				{"OPR0000039","Park the excavator on a level surface with the plugs in the position as shown."},
				{"OPR0000039","Remove the plug. The lube level must be at the bottom edge of the hole."},
				{"OPR0000039","Add lubricant through the hole if the lube level is low."},
				{"OPR0000039","See the SERVICE SCHEDULE for the correct service interval."},
				{"OPR0000039","Park the excavator on a level surface with plugs in the position shown. Remove both plugs and drain the lubricant into a container."},
				{"OPR0000039","Install the bottom plug. Add lubricant through the top plug hole until the lube level is at the bottom edge of the hole."},
				{"OPR0000039","Install the plug."},
				}

				;
		for (int index = 1; index < data.length; index++) {
			

			String[] dataValue = data[index];
			OperationInstructon dataToSave = new OperationInstructon();
			dataToSave.setOperationId(dataValue[0]);
			dataToSave.setStep(dataValue[1]);
			_daoInstance.saveOperationInstructon(dataToSave);
			System.out.println("Load of Operation Instructon "+index + " of "+data.length);
		}
	}
	public static void loadOrderSparesHistory()
	{
		String[][] data = new String[][] 
				{
				{"ORDER NUMBER","OPERATION","MATERIAL NUMBER","UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY","PLANT","Required QTY","STORAGE LOCATION","Used Qty","CreateDate","CATALOG PROFILE"},
				{"10000001","0010","BEARING2","EA","248","USD","BPM1","2","MAIN","2","01.03.2014","HAUL"},
				{"10000002","0011","BEARING2","EA","752","USD","BPM1","2","MAIN","2","01.03.2014","EXCA"},
				{"10000003","0012","BEARING7","EA","599","USD","BPM1","3","MAIN","2","01.03.2014","EXCA"},
				{"10000004","0013","OILFILTER2","EA","422","USD","BPM1","1","MAIN","1","01.03.2014","HAUL"},
				{"10000005","0014","OILFILTER3","EA","515","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000006","0015","OILFILTER2","EA","727","USD","BPM1","1","MAIN","1","01.03.2014","HAUL"},
				{"10000007","0016","BEARING7","EA","486","USD","BPM1","2","MAIN","2","01.03.2014","HAUL"},
				{"10000008","0017","DIFFERENTIAL","EA","604","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000009","0018","BEARING2","EA","456","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000010","0019","PLANETARYGEAR","EA","404","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000011","0020","BEARING7","EA","370","USD","BPM1","3","MAIN","2","01.03.2014","EXCA"},
				{"10000012","0021","BEARING2","EA","795","USD","BPM1","2","MAIN","2","01.03.2014","EXCA"},
				{"10000013","0022","OILFILTER2","EA","586","USD","BPM1","1","MAIN","1","01.03.2014","HAUL"},
				{"10000014","0023","BEARING2","EA","696","USD","BPM1","1","MAIN","1","01.03.2014","HAUL"},
				{"10000015","0024","BEARING7","EA","732","USD","BPM1","2","MAIN","2","01.03.2014","HAUL"},
				{"10000016","0025","BEARING2","EA","504","USD","BPM1","2","MAIN","2","01.03.2014","HAUL"},
				{"10000017","0026","BEARING1","EA","418","USD","BPM1","2","MAIN","7","01.03.2014","DUMP"},
				{"10000018","0027","OILFILTER1","EA","268","USD","BPM1","1","MAIN","1","01.03.2014","DUMP"},
				{"10000019","0028","BEARING6","EA","201","USD","BPM1","2","MAIN","2","01.03.2014","DUMP"},
				{"10000020","0029","OILFILTER1","EA","426","USD","BPM1","1","MAIN","1","01.03.2014","DUMP"},
				{"10000021","0030","BEARING6","EA","518","USD","BPM1","3","MAIN","2","01.03.2014","DUMP"},
				{"10000022","0031","OILFILTER3","EA","405","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000023","0032","OILFILTER4","EA","450","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000024","0033","OILFILTER3","EA","799","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000025","0034","DIFFERENTIAL","EA","647","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000026","0035","PLANETARYGEAR","EA","658","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000027","0036","PLANETARYGEAR","EA","533","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000028","0037","BEARING7","EA","748","USD","BPM1","1","MAIN","1","01.03.2014","EXCA"},
				{"10000029","0038","BEARING7","EA","557","USD","BPM1","2","MAIN","1","01.03.2014","EXCA"},
				};
		for (int index = 1; index < data.length; index++) {
			String header[] = {"ORDER NUMBER","OPERATION","MATERIAL NUMBER",
					"UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY",
					"PLANT","Required QTY","STORAGE LOCATION",
					"Used Qty","CreateDate"};

			String[] dataValue = data[index];
			
			OrderSparesHistory dataToSave = new OrderSparesHistory();
			
			dataToSave.setOrderNumber(dataValue[0]);
			dataToSave.setOperation(dataValue[1]);
			dataToSave.setMaterialNumber(dataValue[2]);
			dataToSave.setUnitOfMeasure(dataValue[3]);
			dataToSave.setAmountInCurrency(getDouble(dataValue[4]));
			dataToSave.setCurrency(dataValue[5]);
			dataToSave.setPlant(dataValue[6]);
			dataToSave.setRequiredQty(getDouble(dataValue[7]));
			dataToSave.setStorageLocation(dataValue[8]);
			dataToSave.setUsedQty(getDouble(dataValue[9]));
			dataToSave.setCreatedate(getDate(dataValue[10]));

			_daoInstance.saveOrderSparesHistory(dataToSave);
			System.out.println("Load of Order Spares history "+index + " of "+data.length);
		}
	}
	public static void loadOrderPRTHistory()
	{
		String[][] data = new String[][] 
				{
				{"ORDER NUMBER","OPERATION","PRT TYPE","Item number","PRT NUMBER","Usage start date","Usage end dtae","Duration","QtyAssigned","QuantityUsed","CATALOG PROFILE"},
				{"10000001","0010","MAT","0001","PRT0001","01.03.2014","01.03.2014","6","1","1","HAUL"},
				{"10000002","0011","MAT","0002","PRT0002","01.03.2014","01.03.2014","20","2","2","EXCA"},
				{"10000003","0012","MAT","0003","PRT0003","01.03.2014","01.03.2014","6","1","1","EXCA"},
				{"10000004","0013","MAT","0004","PRT0004","01.03.2014","01.03.2014","4","3","3","HAUL"},
				{"10000005","0014","MAT","0005","PRT0005","01.03.2014","01.03.2014","13","1","1","EXCA"},
				{"10000006","0015","MAT","0006","PRT0006","01.03.2014","01.03.2014","20","2","2","HAUL"},
				{"10000007","0016","MAT","0007","PRT0007","01.03.2014","01.03.2014","18","1","1","HAUL"},
				{"10000008","0017","MAT","0008","PRT0005","01.03.2014","01.03.2014","15","4","4","EXCA"},
				{"10000009","0018","MAT","0009","PRT0006","01.03.2014","01.03.2014","10","1","1","EXCA"},
				{"10000010","0019","MAT","0010","PRT0007","01.03.2014","01.03.2014","8","1","1","EXCA"},
				{"10000011","0020","MAT","0011","PRT0002","01.03.2014","01.03.2014","14","2","2","EXCA"},
				{"10000012","0021","MAT","0012","PRT0003","01.03.2014","01.03.2014","8","1","1","EXCA"},
				{"10000013","0022","MAT","0013","PRT0004","01.03.2014","01.03.2014","7","1","1","HAUL"},
				{"10000014","0023","MAT","0014","PRT0005","01.03.2014","01.03.2014","11","3","3","HAUL"},
				{"10000015","0024","MAT","0015","PRT0006","01.03.2014","01.03.2014","12","1","1","HAUL"},
				{"10000016","0025","MAT","0016","PRT0007","01.03.2014","01.03.2014","10","2","2","HAUL"},
				{"10000017","0026","MAT","0017","PRT0001","01.03.2014","01.03.2014","10","1","1","DUMP"},
				{"10000018","0027","MAT","0018","PRT0002","01.03.2014","01.03.2014","12","1","1","DUMP"},
				{"10000019","0028","MAT","0019","PRT0006","01.03.2014","01.03.2014","8","1","1","DUMP"},
				{"10000020","0029","MAT","0020","PRT0006","01.03.2014","01.03.2014","4","2","2","DUMP"},
				{"10000021","0030","MAT","0021","PRT0004","01.03.2014","01.03.2014","5","1","1","DUMP"},
				{"10000022","0031","MAT","0022","PRT0006","01.03.2014","01.03.2014","13","4","4","EXCA"},
				{"10000023","0032","MAT","0023","PRT0002","01.03.2014","01.03.2014","8","1","1","EXCA"},
				{"10000024","0033","MAT","0024","PRT0003","01.03.2014","01.03.2014","10","3","3","EXCA"},
				{"10000025","0034","MAT","0025","PRT0004","01.03.2014","01.03.2014","6","1","1","EXCA"},
				{"10000026","0035","MAT","0026","PRT0003","01.03.2014","01.03.2014","4","3","3","EXCA"},
				{"10000027","0036","MAT","0027","PRT0004","01.03.2014","01.03.2014","6","1","1","EXCA"},
				{"10000028","0037","MAT","0028","PRT0007","01.03.2014","01.03.2014","18","1","1","EXCA"},
				{"10000029","0038","MAT","0029","PRT0007","01.03.2014","01.03.2014","20","1","1","EXCA"},
				}
		;
		for (int index = 1; index < data.length; index++) {
			String header[] = {"ORDER NUMBER","OPERATION","PRT TYPE","Item number",
					"PRT NUMBER","Usage start date","Usage end dtae",
					"Duration","QtyAssigned","QuantityUsed"};

			String[] dataValue = data[index];
			OrderPRTHistory dataToSave = new OrderPRTHistory();
			

			dataToSave.setOrderNumber(dataValue[0]);
			dataToSave.setOperation(dataValue[1]);
			dataToSave.setPrtType(dataValue[2]);
			dataToSave.setItemNumber((int)getLong(dataValue[3]));
			dataToSave.setPrtNumber(dataValue[4]);
			dataToSave.setUsageStartDate(getDate(dataValue[5]));
			dataToSave.setUsageEndDtae(getDate(dataValue[6]));
			dataToSave.setDuration(getDouble(dataValue[7]));
			dataToSave.setQtyAssigned(getDouble(dataValue[8]));
			dataToSave.setQuantityUsed(getDouble(dataValue[9]));

			

			_daoInstance.saveOrderPRTHistory(dataToSave);
			System.out.println("Load of Order PRT history "+index + " of "+data.length);

		}
		
	}
	public static void loadOrderMainHistory() {
		String[][] data = new String[][] 
				{
				{"Order Number","Order Type","Finish by","Created on","CATALOG PROFILE","Description","Problem","Equipment Number","MODEL","Plant","Responsible cost center","Order Currency","Order status","PRIORITY","Work Start","End of Work","Total Hours"},
				{"10000001","BREK","02.01.2014","02.01.2014","HAUL","Over Heating","PB0000021","1000310","20","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","51"},
				{"10000002","PRED","05.03.2014","02.01.2018","EXCA","Engine Not Starting","PB0000002","1000301","EX60","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","56"},
				{"10000003","PREV","05.03.2014","02.01.2035","EXCA","Smoke around Engine area","PB0000001","1000314","EX60","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","44"},
				{"10000004","BREK","03.01.2014","03.01.2014","HAUL","Not Starting","PB0000018","1000317","25","BPM1","MECH","USD","CRTD","2","01.03.2014","11.03.2014","34"},
				{"10000005","BREK","03.01.2014","03.01.2014","EXCA","Smoke around Engine area","PB0000001","1000315","EX200LC","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","74"},
				{"10000006","BREK","03.01.2014","03.01.2014","HAUL","Engine Cooling","PB0000020","1000319","32","BPM1","MECH","USD","CRTD","2","01.03.2014","11.03.2014","69"},
				{"10000007","BREK","03.01.2014","03.01.2014","HAUL","Over Heating","PB0000021","1000320","32","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","22"},
				{"10000008","PRED","06.03.2014","03.01.2014","EXCA","Engine Cooling","PB0000006","1000301","EX200","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","31"},
				{"10000009","PRED","07.03.2014","04.01.2014","EXCA","Brake Problem","PB0000027","1000301","EX200","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","38"},
				{"10000010","PRED","07.03.2014","04.01.2014","EXCA","Brake Problem","PB0000027","1000302","EX600","BPM1","MECH","USD","REL","3","01.03.2014","11.03.2014","80"},
				{"10000011","PRED","07.03.2014","04.01.2014","EXCA","Brake Problem","PB0000027","1000304","EX200","BPM1","MECH","USD","REL","4","01.03.2014","11.03.2014","28"},
				{"10000012","PRED","08.03.2014","05.01.2014","EXCA","Smoke around Engine area","PB0000001","1000304","EX60","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","69"},
				{"10000013","PRED","08.03.2014","05.01.2014","HAUL","Engine Cooling","PB0000020","1000319","20","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","60"},
				{"10000014","PRED","08.03.2014","05.01.2014","HAUL","Not Starting","PB0000018","1000311","32","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","23"},
				{"10000015","PRED","08.03.2014","05.01.2014","HAUL","Over Heating","PB0000021","1000312","20","BPM1","MECH","USD","REL","3","01.03.2014","11.03.2014","33"},
				{"10000016","PRED","08.03.2014","05.01.2014","HAUL","Not Starting","PB0000018","1000313","25","BPM1","MECH","USD","REL","3","01.03.2014","11.03.2014","32"},
				{"10000017","PRED","09.03.2014","02.01.2014","DUMP","Engine Noise","PB0000010","1000305","35T","BPM1","MECH","USD","REL","4","01.03.2014","11.03.2014","51"},
				{"10000018","PRED","09.03.2014","02.01.2018","DUMP","Engine Cooling","PB0000012","1000306","40T","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","72"},
				{"10000019","PRED","10.03.2014","02.01.2035","DUMP","Over Heating","PB0000013","1000307","35T","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","65"},
				{"10000020","PRED","10.03.2014","03.01.2014","DUMP","Engine Not Starting","PB0000009","1000308","32T","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","66"},
				{"10000021","PRED","10.03.2014","02.01.2014","DUMP","Engine Cooling","PB0000012","1000309","32T","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","76"},
				{"10000022","PREV","15.03.2014","02.01.2018","EXCA","MG Set vibration","PB0000003","1000304","EX600","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","58"},
				{"10000023","PREV","15.03.2014","03.01.2014","EXCA","Engine noise","PB0000008","1000304","EX600","BPM1","ELEC","USD","REL","2","01.03.2014","11.03.2014","54"},
				{"10000024","PREV","16.03.2014","03.01.2014","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","MECH","USD","REL","1","01.03.2014","11.03.2014","48"},
				{"10000025","PREV","23.03.2014","08.01.2014","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","ELEC","USD","REL","2","01.03.2014","11.03.2014","34"},
				{"10000026","PRED","21.04.2015","08.03.2015","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","ELEC","USD","REL","2","01.03.2014","11.03.2014","71"},
				{"10000027","PRED","15.04.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","36"},
				{"10000028","PRED","16.03.2014","08.03.2015","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","ELEC","USD","REL","2","01.03.2014","11.03.2014","41"},
				{"10000029","PRED","23.03.2014","08.03.2015","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","MECH","USD","REL","2","01.03.2014","11.03.2014","34"},
				}
				;
		for (int index = 1; index < data.length; index++) {
			String header[] = {"Order Number","Order Type","Finish by",
					"Created on","CATALOG PROFILE","Description","Problem",
					"Equipment Number","MODEL","Plant","Responsible cost center",
					"Order Currency","Order status","PRIORITY","Work Start",
					"End of Work","Total Hours"};

			String[] dataValue = data[index];
			OrderMainHistory dataToSave = new OrderMainHistory();
			dataToSave.setOrderNumber(dataValue[0]);
			dataToSave.setOrderType(dataValue[1]);
			dataToSave.setFinishBy(getDate(dataValue[2]));
			dataToSave.setCreatedOn(getDate(dataValue[3]));
			dataToSave.setCatalogProfile(dataValue[4]);
			dataToSave.setDescription(dataValue[5]);
			dataToSave.setProblem(dataValue[6]);
			dataToSave.setEquipmentNumber(dataValue[7]);
			dataToSave.setModel(dataValue[8]);
			dataToSave.setPlant(dataValue[9]);
			dataToSave.setResponsibleCostCenter(dataValue[10]);
			dataToSave.setOrderCurrency(dataValue[11]);
			dataToSave.setOrderStatus(dataValue[12]);
			dataToSave.setPriority((int)getLong(dataValue[13]));
			dataToSave.setWorkStart(getDate(dataValue[14]));
			dataToSave.setEndOfWork(getDate(dataValue[15]));
			dataToSave.setTotalHours(getDouble(dataValue[16]));

			

			_daoInstance.saveOrderMainHistory(dataToSave);

			System.out.println("Load of Order main histor "+index + " of "+data.length);
		}
	}
	

	public static void loadOrderMain() {
		String[][] data = new String[][] 
				{
				{"Order Number","Order Type","Finish by","Created on","CATALOG PROFILE","Description","Problem","Equipment Number","MODEL","Plant","Responsible cost center","Order Currency","Order status","PRIORITY"},
				{"10000103","BREK","08.03.2015","08.03.2015","HAUL","Smoke around Engine area","PB0000017","1000310","20","BPM1","MECH","USD","CRTD","2"},
				{"10000104","BREK","08.03.2015","08.03.2015","EXCA","Engine Not Starting","PB0000002","1000301","EX60","BPM1","MECH","USD","CRTD","1"},
				{"10000116","BREK","08.03.2015","08.03.2015","HAUL","Hyd Leakage","PB0000022","1000316","20","BPM1","MECH","USD","CRTD","2"},
				{"10000117","BREK","08.03.2015","08.03.2015","HAUL","Not starting","PB0000018","1000317","25","BPM1","MECH","USD","CRTD","1"},
				{"10000118","PRED","15.04.2015","08.03.2015","HAUL","Engine Cooling","PB0000020","1000318","20","BPM1","MECH","USD","CRTD","1"},
				{"10000119","PRED","15.03.2015","08.03.2015","HAUL","Axle Problem","PB0000025","1000319","20","BPM1","MECH","USD","CRTD","2"},
				{"10000120","PRED","15.02.2015","08.03.2015","HAUL","Over Heating","PB0000021","1000320","32","BPM1","MECH","USD","CRTD","3"},
				{"10000121","PRED","15.03.2015","08.03.2015","HAUL","Engine Cooling","PB0000020","1000321","32","BPM1","MECH","USD","CRTD","3"},
				{"10000122","PRED","15.03.2015","08.03.2015","DUMP","Hyd Leakage","PB0000014","1000305","35T","BPM1","MECH","USD","CRTD","4"},
				{"10000123","PRED","14.03.2015","08.03.2015","DUMP","Brake Problem","PB0000016","1000306","40T","BPM1","MECH","USD","CRTD","2"},
				{"10000124","PRED","15.04.2015","08.03.2015","DUMP","Tyre inflation","PB0000015","1000307","35T","BPM1","MECH","USD","CRTD","1"},
				{"10000125","PRED","15.03.2015","08.03.2015","DUMP","Engine Noise","PB0000010","1000308","32T","BPM1","MECH","USD","CRTD","2"},
				{"10000126","PRED","15.03.2015","08.03.2015","DUMP","Over Heating","PB0000013","1000309","22T","BPM1","MECH","USD","CRTD","1"},
				{"10000101","PREV","23.03.2015","08.03.2015","EXCA","Engine Cooling","PB0000006","1000301","EX60","BPM1","MECH","USD","CRTD","1"},
				{"10000102","PREV","23.03.2015","08.03.2015","EXCA","MG Set /Engine noise","PB0000003","1000302","EX200","BPM1","ELEC","USD","CRTD","2"},
				{"10000114","PREV","23.03.2015","08.03.2015","EXCA","Smoke around Engine area","PB0000001","1000303","EX200LC","BPM1","MECH","USD","CRTD","1"},
				{"10000115","PREV","23.03.2015","08.03.2015","EXCA","Excavator 3M scheduled Maintenance","PB0000007","1000304","EX600","BPM1","ELEC","USD","CRTD","2"},
				{"10000199","PRED","21.04.2015","08.03.2015","EXCA","MG Set - Vibration ","PB0000003","1000304","EX600","BPM1","ELEC","USD","CRTD","1"},
				{"10000200","PRED","14.04.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000304","EX600","BPM1","MECH","USD","CRTD","2"},
				{"10000201","PRED","12.04.2015","08.03.2015","EXCA","MG Set Vibration","PB0000003","1000304","EX600","BPM1","ELEC","USD","CRTD","1"},
				{"10000202","PRED","15.05.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000304","EX600","BPM1","MECH","USD","CRTD","2"},
				{"10000203","PRED","21.06.2014","08.03.2015","EXCA","MG Set vibration","PB0000003","1000304","EX600","BPM1","ELEC","USD","CRTD","1"},
				{"10000204","PRED","15.05.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000304","EX600","BPM1","MECH","USD","CRTD","2"},
				{"10000205","PRED","11.05.2015","08.03.2015","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","ELEC","USD","CRTD","1"},
				{"10000206","PRED","16.05.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","MECH","USD","CRTD","2"},
				{"10000207","PRED","22.04.2015","08.03.2015","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","ELEC","USD","CRTD","1"},
				{"10000208","PRED","25.04.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","MECH","USD","CRTD","2"},
				{"10000209","PRED","22.05.2015","08.03.2015","EXCA","MG Set vibration","PB0000003","1000303","EX200LC","BPM1","ELEC","USD","CRTD","1"},
				{"10000210","PRED","27.05.2015","08.03.2015","EXCA","Engine noise","PB0000008","1000303","EX200LC","BPM1","MECH","USD","CRTD","2"},
				}
				;
		for (int index = 1; index < data.length; index++) {
			String header[] = { "Order Number", "Order Type", "Finish by",
					"Created on", "CATALOG PROFILE", "Description", "Problem",
					"Equipment Number", "MODEL", "Plant",
					"Responsible cost center", "Order Currency",
					"Order status", "PRIORITY" };

			String[] dataValue = data[index];
			OrderMain dataToSave = new OrderMain();
			dataToSave.setOrderNumber(dataValue[0]);
			dataToSave.setOrderType(dataValue[1]);
			dataToSave.setFinishBy(getDate(dataValue[2]));
			dataToSave.setCreatedOn(getDate(dataValue[3]));
			dataToSave.setCatalogProfile(dataValue[4]);
			dataToSave.setDescription(dataValue[5]);
			dataToSave.setProblem(dataValue[6]);
			dataToSave.setEquipmentNumber(dataValue[7]);
			dataToSave.setModel(dataValue[8]);
			dataToSave.setPlant(dataValue[9]);
			dataToSave.setResponsibleCostCenter(dataValue[10]);
			dataToSave.setOrderCurrency(dataValue[11]);
			dataToSave.setOrderStatus(dataValue[12]);
			dataToSave.setPriority((int)getLong(dataValue[13]));
			

			_daoInstance.saveOrderMain(dataToSave);
			System.out.println("Load of Order Main "+index + " of "+data.length);

		}
	}

	public static void loadEquipmentMaster() {

		String[][] equipmentMaster = new String[][] 
				{
				{"EQUIPMENT NUMBER","PLANT","DESCRIPTION","MODEL NUMBER","SERIAL NUMBER","MANUFACTURER","INSTALLATION DATE","RATE/HOUR","CURRENCY","PDF Doc","CATALOG PROFILE","Standard Operating Proceedure"},
				{"1000301","BPM1","Excavator EX60 TATA HITACHI","EX60","1","HITACHI","01.01.2014","10000","USD","PDFExcavatorEX60TATAHITACHI.pdf","EXCA","PDF - Excavator EX60 TATA HITACHI"},
				{"1000302","BPM1","Excavator EX 200 TATA HITACHI","EX200","2","HITACHI","01.01.2014","120000","USD","PDFExcavatorEX200TATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 TATA HITACHI"},
				{"1000303","BPM1","Excavator EX 200 LC TATA HITACHI","EX200LC","3","HITACHI","01.01.2014","130000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000304","BPM1","Excavator Ex 600 TATA HITACHI","EX600","4","HITACHI","01.01.2014","200000","USD","PDFExcavatorEx600TATAHITACHI.pdf","EXCA","PDF- Excavator Ex 600 TATA HITACHI"},
				{"1000305","BPM1","EUCLID DUMPER 35 T","35T","1","EUCLID","01.01.2014","10000","USD","PDFEUCLIDDUMPER60T.pdf","DUMP","PDF- EUCLID DUMPER 60 T"},
				{"1000306","BPM1","EUCLID DUMPER 40 T","40T","2","EUCLID","01.01.2014","9000","USD","PDFEUCLIDDUMPER40T.pdf","DUMP","PDF- EUCLID DUMPER 40 T"},
				{"1000307","BPM1","EUCLID DUMPER 35 T","35T","3","EUCLID","01.01.2014","10000","USD","PDFEUCLIDDUMPER60T.pdf","DUMP","PDF- EUCLID DUMPER 60 T"},
				{"1000308","BPM1","EUCLID DUMPER 32 T","32T","4","EUCLID","01.01.2014","9000","USD","PDFEUCLIDDUMPER40T.pdf","DUMP","PDF- EUCLID DUMPER 40 T"},
				{"1000309","BPM1","EUCLID DUMPER 22 T","22T","5","EUCLID","01.01.2014","11000","USD","PDFEUCLIDDUMPER62T.pdf","DUMP","PDF- EUCLID DUMPER 62 T"},
				{"1000310","BPM1","HAULER 20T","20","1","CAT","01.01.2014","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000311","BPM1","HAULER 20T","20","2","CAT","01.01.2014","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000312","BPM1","HAULER 25T","25","3","CAT","01.01.2014","4000","USD","PDFHAULER25T.pdf","HAUL","PDF- HAULER 25T"},
				{"1000313","BPM1","HAULER 20T","20","4","CAT","01.01.2014","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000314","BPM1","Excavator EX 200 TATA HITACHI","EX200","23","HITACHI","01.01.2014","120000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000315","BPM1","Excavator EX 200 LC TATA HITACHI","EX200LC","24","HITACHI","01.01.2014","130000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000316","BPM1","HAULER 20T","20","25","CAT","01.01.2014","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000317","BPM1","HAULER 25T","25","26","CAT","01.01.2014","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000318","BPM1","HAULER 20T","20","27","CAT","01.01.2014","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000319","BPM1","HAULER 20T","20","28","CAT","01.01.2014","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000320","BPM1","HAULER 32T","32","29","CAT","01.01.2014","5000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000321","BPM1","HAULER 32T","32","30","CAT","01.01.2014","5000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000322","BPM1","EUCLID DUMPER 35 T","35T","31","EUCLID","01.01.2014","9000","USD","PDFEuclid35T.pdf","DUMP","PDF- Euclid 35T"},
				{"1000323","BPM1","EUCLID DUMPER 40 T","40T","32","EUCLID","01.01.2014","10000","USD","PDFEuclid40T.pdf","DUMP","PDF- Euclid 40T"},
				{"1000324","BPM1","EUCLID DUMPER 35 T","35T","33","EUCLID","01.01.2014","9000","USD","PDFEuclid35T.pdf","DUMP","PDF- Euclid 35T "},
				{"1000325","BPM1","EUCLID DUMPER 32 T","32T","34","EUCLID","01.01.2014","11000","USD","PDFEuclid32T.pdf","DUMP","PDF- Euclid 32T "},
				{"1000326","BPM1","EUCLID DUMPER 22 T","22T","35","EUCLID","01.01.2014","9000","USD","PDFEuclid22T.pdf","DUMP","PDF- Euclid 22T "},
				};

		for (int index = 1; index < equipmentMaster.length; index++) {
			String header[] = { "EQUIPMENT NUMBER", "PLANT", "DESCRIPTION",
					"MODEL NUMBER", "SERIAL NUMBER", "MANUFACTURER",
					"RATE/HOUR", "CURRENCY", "PDF Doc", "CATALOG PROFILE",
					"Standard Operating Proceedure" };

			String[] dataValue = equipmentMaster[index];
			EquipmentMaster dataToSave = new EquipmentMaster();

			dataToSave.setEquipmentNumber(dataValue[0]);
			dataToSave.setPlant(dataValue[1]);
			dataToSave.setDescription(dataValue[2]);
			dataToSave.setModelNumber(dataValue[3]);
			dataToSave.setSerialNumber(dataValue[4]);
			dataToSave.setManufacturer(dataValue[5]);
			dataToSave.setInstallationDate(getDate(dataValue[6]));
			dataToSave.setRatePerHour(getDouble(dataValue[7]));
			dataToSave.setCurrency(dataValue[8]);
			dataToSave.setPdfDoc(dataValue[9]);
			dataToSave.setCatalogProfile(dataValue[10]);
			dataToSave.setStandardOperatingProcedure(dataValue[11]);
			_daoInstance.saveEquipmentMaster(dataToSave);
			System.out.println("Load of equipment master "+index + " of "+equipmentMaster.length);
		}
		System.out.println("Load of equipment master done");
		
	}

	public static void loadPRTMaster() {
		String[][] prtMaster = new String[][] 
				{
				{"PRT NUMBER","PRT TYPE","DESCRIPTION","UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY","PLANT","STOCK QTY","STORAGE LOCATION","CATALOG PROFILE","CATALOG PROFILE"},
				{"PRT0001","MAT","TORQUE WRENCH 11.4 Nm","EA","20000","INR","BPM1","2","PRT1","DUMP","HAUL"},
				{"PRT0002","MAT","TORQUE WRENCH 2.3 Nm","EA","30001","INR","BPM1","3","PRT1","DUMP","EXCA"},
				{"PRT0003","MAT","TORQUE WRENCH 5.6 Nm","EA","40002","INR","BPM1","4","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0004","MAT","TORQUE WRENCH 135.6 Nm","EA","50003","INR","BPM1","2","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0005","MAT","HYDRAULIC JACK 2 TON","EA","50004","INR","BPM1","3","PRT1","HAUL","EXCA"},
				{"PRT0006","MAT","TORQUE WRENCH 150 Nm","EA","100000","INR","BPM1","4","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0007","MAT","HYDRAULIC JACK 6 TON","EA","100000","INR","BPM1","5","PRT1","HAUL","EXCA"},
				}
				;
		for (int index = 1; index < prtMaster.length; index++) {
			String header[] = { "PRT NUMBER", "PRT TYPE", "DESCRIPTION",
					"UNIT OF MEASURE", "AMOUNT IN CURRENCY", "CURRENCY",
					"PLANT", "STOCK QTY", "STORAGE LOCATION", "CATALOG PROFILE" };
			String[] dataValue = prtMaster[index];
			PRTMaster dataToSave = new PRTMaster();

			dataToSave.setPrtNumber(dataValue[0]);
			dataToSave.setPrtType(dataValue[1]);
			dataToSave.setDescription(dataValue[2]);
			dataToSave.setUnitOfMeasure(dataValue[3]);
			dataToSave.setAmountInCurrency(getDouble(dataValue[4]));
			dataToSave.setCurrency(dataValue[5]);
			dataToSave.setPlant(dataValue[6]);
			dataToSave.setStockQty(getDouble(dataValue[7]));
			dataToSave.setStorageLocation(dataValue[8]);
			dataToSave.setCatalogProfileList(dataValue[9].split(","));
			_daoInstance.savePRTMaster(dataToSave);
			System.out.println("Load of equipment master "+index + " of "+prtMaster.length);
		}
	}

	public static void loadSparesMaster()

	{
		String[][] sparesMaster = new String[][] {
				{"MATERIAL NUMBER","DESCRIPTION","UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY","PLANT","STOCK QTY","STORAGE LOCATION","CATALOG PROFILE"},
				{"BEARING1","BEARING 6203 SKF","EA","200","USD","BPM1","10","MAIN","DUMP,HAUL"},
				{"BEARING2","BEARING 6205 SKF","EA","201","USD","BPM1","11","MAIN","HAUL,EXCA"},
				{"BEARING3","BEARING 6202 SKF","EA","202","USD","BPM1","12","MAIN","DUMP,HAUL,EXCA"},
				{"BEARING4","BEARING 6203 FAG","EA","203","USD","BPM1","13","MAIN","DUMP,HAUL,EXCA"},
				{"BEARING5","BEARING 6205 FAG","EA","204","USD","BPM1","14","MAIN","HAUL,EXCA"},
				{"BEARING6","BEARING 6202 FAG","EA","205","USD","BPM1","15","MAIN","DUMP,EXCA"},
				{"BEARING7","BEARING 6203 FAG","EA","206","USD","BPM1","16","MAIN","HAUL,EXCA"},
				{"OILFILTER1","OILFILTER1","EA","207","USD","BPM1","17","MAIN","DUMP"},
				{"OILFILTER2","OILFILTER2","EA","208","USD","BPM1","18","MAIN","HAUL"},
				{"OILFILTER3","OILFILTER3","EA","209","USD","BPM1","19","MAIN","EXCA"},
				{"OILFILTER4","OILFILTER4","EA","210","USD","BPM1","0","MAIN","EXCA"},
				{"PLANETARYGEAR","PLANETARY GEAR","EA","2000","USD","BPM1","2","MAIN","EXCA"},
				{"DIFFERENTIAL","DIFFERNTIAL","EA","2000","USD","BPM1","2","MAIN","EXCA"},
				};
		for (int index = 1; index < sparesMaster.length; index++) {
			String header[] = { "MATERIAL NUMBER", "DESCRIPTION",
					"UNIT OF MEASURE", "AMOUNT IN CURRENCY", "CURRENCY",
					"PLANT", "STOCK QTY", "STORAGE LOCATION", "CATALOG PROFILE" };
			String[] dataValue = sparesMaster[index];
			SparesMaster dataToSave = new SparesMaster();
			dataToSave.setMaterialNumber(dataValue[0]);
			dataToSave.setDescription(dataValue[1]);
			dataToSave.setUnitOfMeasure(dataValue[2]);
			dataToSave.setAmountInCurrency(getDouble(dataValue[3]));
			dataToSave.setCurrency(dataValue[4]);
			dataToSave.setPlant(dataValue[5]);
			dataToSave.setStockQty(getDouble(dataValue[6]));
			dataToSave.setStorageLocation(dataValue[7]);
			dataToSave.setCatalogProfileList(dataValue[8].split(","));

			_daoInstance.saveSparesMaster(dataToSave);
			System.out.println("Load of Spares master "+index + " of "+sparesMaster.length);
		}
	}

	public static void loadEmployeeMaster() {
		String[][] employeeMaster = new String[][] 
				{
				{"EMPLOYEE ID","EMPLOYEE NAME","DATE OF JOINING","SKILL NUMBER","SKILL DESCRIPTION","WORK CENTER","Dept Id","Shift Grouping","Shift definition","Skill Level"},
				{"03446G","Niraj R Sharma","01.10.2011","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470007","Abhijit C Saha","01.09.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470008","Sudip Dutta","01.07.2011","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","3"},
				{"470009","Raju Parashar","01.10.2012","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470010","Suman Mandal","01.10.2011","I","Instrumentation","MECH","DPT00018","G","07:00 - 17:30","1"},
				{"470011","Jean","01.04.2012","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470012","John","01.01.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470013","Lee","01.12.2011","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"03869A","Subha","01.10.2007","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","2"},
				{"875092","Probal","01.09.2007","S","Supervisor","SUP","SUP00001","B","14:00 - 22:30","1"},
				{"905678","Arnab","01.10.2008","S","Supervisor","SUP","SUP00001","C","22:00 - 06:30","1"},
				{"470015","Santosh","01.05.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470016","Debi","01.12.2012","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","3"},
				{"470017","Niraj Kumar","01.11.2014","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470018","Sankar","01.02.2005","S","Supervisor","SUP","SUP00001","G","06:00 - 14:30","1"},
				{"470019","Terence","01.12.2008","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470020","Jack","01.10.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470021","Jill","01.06.2009","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"470022","Miller","07.11.2011","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470023","Darwin","01.10.2013","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470024","Jackson","01.03.2011","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","2"},
				{"470025","Darwin","01.04.2011","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470026","Roopey","01.03.2011","I","Instrumentation","MECH","DPT00018","G","07:00 - 17:30","1"},
				{"470027","Heli","01.05.2013","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470028","Maija","01.10.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470029","Ranjan","16.10.2011","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"470030","Prashant","01.10.2011","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470031","Subha","12.10.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470032","Vishwa","11.10.2012","S","Supervisor","SUP","SUP00001","A","06:00 - 14:30","3"},
				{"470033","Peter","01.10.2010","S","Supervisor","SUP","SUP00001","A","14:00 - 22:30","1"},
				{"470034","Marie","01.06.2011","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470035","John","12.02.2010","F","Mechanical","MECH","DPT00018","A","06:00 - 14:30","2"},
				}
				;

		for (int index = 1; index < employeeMaster.length; index++) {
			String header[] = 	{"EMPLOYEE ID","EMPLOYEE NAME","DATE OF JOINING",
					"SKILL NUMBER","SKILL DESCRIPTION","WORK CENTER","Dept Id",
					"Shift Grouping","Shift definition","Skill Level"};
					;
			String[] dataValue = employeeMaster[index];
			EmployeeMaster dataToSave = new EmployeeMaster();
			dataToSave.setEmployeeId(dataValue[0]);
			dataToSave.setEmployeeName(dataValue[1]);
			dataToSave.setDateOfJoining(getDate(dataValue[2]));
			dataToSave.setSkillNumber(dataValue[3]);
			dataToSave.setSkillDescription(dataValue[4]);
			dataToSave.setWorkCenter(dataValue[5]);
			dataToSave.setDeptId(dataValue[6]);
			dataToSave.setShiftGrouping(dataValue[7]);
			dataToSave.setShiftDefinition(dataValue[8]);
			dataToSave.setSkillLevel(getLong(dataValue[9]));

			_daoInstance.saveEmployeeMaster(dataToSave);
			System.out.println("Load of equipment master "+index + " of "+employeeMaster.length);

		}
	}

	public static void loadProblemMaster() {
		String[][] problemMaster = new String[][] 
				{
				{"CATALOG PROFILE","Problem ID","Problem Description","Default Dept Id","Default Dept Desc","Operation 1"},
				{"EXCA","PB0000001","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000038,OPR0000039,OPR0000018,OPR0000019"},
				{"EXCA","PB0000002","Engine Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000031,OPR0000032,OPR0000033,OPR0000034,OPR0000035,OPR0000036,OPR0000039,OPR0000018,OPR0000019"},
				{"EXCA","PB0000003","MG Set /Engine noise","DPT00018","Mechanical","OPR0000002,OPR0000016,OPR0000024,OPR0000010,OPR0000034,OPR0000035,OPR0000036,OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000004","Tilting","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000012,OPR0000013,OPR0000019"},
				{"EXCA","PB0000005","Swinging Boom","DPT00018","Mechanical","OPR0000022,OPR0000015,OPR0000013,OPR0000019"},
				{"EXCA","PB0000006","Engine Cooling","DPT00018","Mechanical","OPR0000002,OPR0000010,OPR0000024,OPR0000010,OPR0000034,OPR0000035,OPR0000036,OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000007","Pump Noise","DPT00018","Mechanical","OPR0000021,OPR0000004,OPR0000012,OPR0000013,OPR0000019"},
				{"EXCA","PB0000008","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000010,OPR0000017,OPR0000016,OPR0000018,OPR0000031,OPR0000039,OPR0000019"},
				{"DUMP","PB0000026","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000018,OPR0000019"},
				{"DUMP","PB0000009","Engine Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000018,OPR0000032,OPR0000035,OPR0000039,OPR0000019"},
				{"DUMP","PB0000010","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000018,OPR0000031,OPR0000019"},
				{"DUMP","PB0000011","Tyre Burst","DPT00018","Mechanical","OPR0000006,OPR0000019"},
				{"DUMP","PB0000012","Engine Cooling","DPT00018","Mechanical","OPR0000024,OPR0000010,OPR0000034,OPR0000035,OPR0000036,OPR0000017,OPR0000018,OPR0000019,"},
				{"DUMP","PB0000013","Over Heating","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000022,OPR0000038,OPR0000039,OPR0000019"},
				{"DUMP","PB0000014","Hyd Leakage","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000011,OPR0000012,OPR0000013,OPR0000019"},
				{"DUMP","PB0000015","Tyre inflation","DPT00018","Mechanical","OPR0000008,OPR0000006,OPR0000019"},
				{"DUMP","PB0000016","Brake Problem","DPT00018","Mechanical","OPR0000007,OPR0000019"},
				{"HAUL","PB0000017","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000018,OPR0000019"},
				{"HAUL","PB0000018","Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000018,OPR0000032,OPR0000035,OPR0000039,OPR0000019"},
				{"HAUL","PB0000019","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000019"},
				{"HAUL","PB0000020","Engine Cooling","DPT00018","Mechanical","OPR0000024,OPR0000024,OPR0000010,OPR0000034,OPR0000035,OPR0000036,OPR0000017,OPR0000018,OPR0000019"},
				{"HAUL","PB0000021","Over Heating","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000022,OPR0000038,OPR0000039,OPR0000019"},
				{"HAUL","PB0000022","Hyd Leakage","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000011,OPR0000012,OPR0000013,OPR0000019"},
				{"HAUL","PB0000023","Brake Problem","DPT00018","Mechanical","OPR0000007,OPR0000019"},
				{"HAUL","PB0000024","Tyre inflation","DPT00018","Mechanical","OPR0000008,OPR0000006,OPR0000019"},
				{"HAUL","PB0000025","Axle Problem","DPT00018","Mechanical","OPR0000025,OPR0000026,OPR0000027,OPR0000028,OPR0000019"},
				{"EXCA","PB0000027","Brake Problem","DPT00018","Mechanical","OPR0000007,OPR0000019"},
				};
			
		for (int index = 1; index < problemMaster.length; index++) {
			String header[] = {};
			String[] dataValue = problemMaster[index];
			Problem dataToSave = new Problem();
			dataToSave.setCatalogProfile(dataValue[0]);
			dataToSave.setProblemId(dataValue[1]);
			dataToSave.setProblemDescription(dataValue[2]);
			dataToSave.setDefaultDeptId(dataValue[3]);
			dataToSave.setDefaultDeptDesc(dataValue[4]);
			dataToSave.setOperationList(dataValue[5].split(","));

			_daoInstance.saveProblem(dataToSave);
			System.out.println("Load of Problem master "+index + " of "+problemMaster.length);

		}
	}

	public static void loadOperationMaster() {

		String[][] operationMaster = new String[][]
				{
				{"Operation ID","Dept Id","Dept Desc","Operation short text","No of Emp","Avg Duration (hrs)","Rate per hr","Task Manual"},
				{"OPR0000001","DPT00018","Mechanical","Dismantle from the Equipment","1","2","1000","Vol _4-Sec_1.1.pdf"},
				{"OPR0000002","DPT00018","Mechanical","Check the Engine / MGSET parameters","1","3","2552","Vol_2-Sec_1.7.pdf"},
				{"OPR0000003","DPT00018","Mechanical","Check the oil Filter","1","1","4582","Vol_2-Sec_1.8.pdf"},
				{"OPR0000004","DPT00019","Electrical","Check the Electricals/motor","1","3","1613","Vol_3-Sec 2.2.pdf"},
				{"OPR0000005","DPT00018","Mechanical","Install back","1","2","2585","Vol_3-Sec_3.2.pdf"},
				{"OPR0000006","DPT00018","Mechanical","Replace Trye","1","2","2405","Vol_4-Sec_3.1.pdf"},
				{"OPR0000007","DPT00018","Mechanical","Replace Brake","1","3","1855","Vol_5-Sec_4.2.pdf"},
				{"OPR0000008","DPT00018","Mechanical","Check Inflation & inflate","1","1","5861","Vol_5-Sec_5.1.pdf"},
				{"OPR0000009","DPT00018","Mechanical","Check cooling system","1","3","6045","Vol_6-Sec_1.2.pdf"},
				{"OPR0000010","DPT00018","Mechanical","Replace engine/ MG set","1","2","1115","Vol_7-Sec_1.2.pdf"},
				{"OPR0000011","DPT00018","Mechanical","Replace hydraulic valves","1","2","2901","Vol _4-Sec_1.1.pdf"},
				{"OPR0000012","DPT00018","Mechanical","Replace Pump","1","3","3578","Vol_2-Sec_1.7.pdf"},
				{"OPR0000013","DPT00018","Mechanical","Replace hydraulic circuit","1","1","2889","Vol_2-Sec_1.8.pdf"},
				{"OPR0000014","DPT00018","Mechanical","Change bucket teeth","1","3","5709","Vol_3-Sec 2.2.pdf"},
				{"OPR0000015","DPT00018","Mechanical","Check bucket alignment","1","2","1867","Vol_3-Sec_3.2.pdf"},
				{"OPR0000016","DPT00019","Electrical","Check the MG Set","1","1","1735","Vol_4-Sec_3.1.pdf"},
				{"OPR0000017","DPT00018","Mechanical","Check ignition","1","2","3278","Vol_5-Sec_4.2.pdf"},
				{"OPR0000018","DPT00018","Mechanical","Replace ignition switch","1","2","6078","Vol_5-Sec_5.1.pdf"},
				{"OPR0000019","DPT00018","Mechanical","Handover of euqipment - trial","1","2","1985","Vol_6-Sec_1.2.pdf"},
				{"OPR0000020","DPT00018","Mechanical","Chech HYD circuits","1","2","3792","Vol _4-Sec_1.1.pdf"},
				{"OPR0000021","DPT00018","Mechanical","Check Hyd Pump","1","2","3309","Vol_2-Sec_1.7.pdf"},
				{"OPR0000022","DPT00018","Mechanical","Chech Alignment","1","2","6241","Vol_2-Sec_1.8.pdf"},
				{"OPR0000023","DPT00018","Mechanical","Check for engine / drive coupling","1","2","5646","Vol_3-Sec 2.2.pdf"},
				{"OPR0000024","DPT00018","Mechanical","Check engine cooling system","1","2","3742","Vol_3-Sec_3.2.pdf"},
				{"OPR0000025","DPT00018","Mechanical","Check crown wheel/ alignment","1","2","5328","Vol_4-Sec_3.1.pdf"},
				{"OPR0000026","DPT00018","Mechanical","Dismantle axle","1","2","3286","Vol_5-Sec_4.2.pdf"},
				{"OPR0000027","DPT00018","Mechanical","Check greasing","1","2","2555","Vol_5-Sec_5.1.pdf"},
				{"OPR0000028","DPT00018","Mechanical","Assemble Axle","1","2","4171","Vol_6-Sec_1.2.pdf"},
				{"OPR0000029","DPT00019","Electrical","Check the Power Module in Control Panel","1","1","4672","Vol _4-Sec_1.1.pdf"},
				{"OPR0000030","DPT00019","Electrical","Check the Input/ Output Card","1","1","5861","Vol_2-Sec_1.7.pdf"},
				{"OPR0000031","DPT00019","Electrical","Check the speed Governor","1","1","4755","Vol_2-Sec_1.8.pdf"},
				{"OPR0000032","DPT00019","Electrical","Check the CNC Drive","1","1","6250","Vol_3-Sec 2.2.pdf"},
				{"OPR0000033","DPT00019","Electrical","Check the DC Motor","1","1","4843","Vol_3-Sec_3.2.pdf"},
				{"OPR0000034","DPT00019","Electrical","Check the Carbon Brushes","1","1","1809","Vol_4-Sec_3.1.pdf"},
				{"OPR0000035","DPT00019","Electrical","Check Static switches MG","1","1","6117","Vol_5-Sec_4.2.pdf"},
				{"OPR0000036","DPT00019","Electrical","Check AC DC Converters","1","1","5709","Vol_5-Sec_5.1.pdf"},
				{"OPR0000037","DPT00019","Electrical","Check Common-bus DC rectifiers","1","1","5559","Vol_6-Sec_1.2.pdf"},
				{"OPR0000038","DPT00019","Electrical","Check Power Output","1","1","2247","Vol_4-Sec_3.1.pdf"},
				{"OPR0000039","DPT00019","Electrical","Check Electrical Insulations","1","1","2992","Vol_5-Sec_4.2.pdf"},
				}
				;

		for (int index = 1; index < operationMaster.length; index++) {
			String header[] = {};
			String[] dataValue = operationMaster[index];
			Operations dataToSave = new Operations();
			dataToSave.setOperationId(dataValue[0]);
			dataToSave.setDeptId(dataValue[1]);
			dataToSave.setDeptDesc(dataValue[2]);
			dataToSave.setOperationShortText(dataValue[3]);
			dataToSave.setNoofEmp((int) getLong(dataValue[4]));
			dataToSave.setAvgDuration(getDouble(dataValue[5]));
			dataToSave.setRatePerHr(getDouble(dataValue[6]));
			dataToSave.setTaskManual(dataValue[7]);
			_daoInstance.saveOperations(dataToSave);
			System.out.println("Load of Operatios Master "+index + " of "+operationMaster.length);
		}
	}

	private static Date getDate(String dateStr) {
		Date retDt = null;
		try {
			retDt = DT_FMT.parse(dateStr.trim());
		} catch (Exception ex) {
			retDt = null;
		}

		return retDt;
	}

	private static double getDouble(String dateStr) {
		try {
			return Double.parseDouble(dateStr.toString());
		} catch (Exception ex) {

		}
		return 0.0;
	}

	private static long getLong(String dateStr) {
		try {
			return Long.parseLong(dateStr.toString());
		} catch (Exception ex) {

		}
		return 0L;
	}
}
