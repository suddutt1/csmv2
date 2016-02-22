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

public class Backup2DataLoaderUtilV2 {

	private static final DateFormat DT_FMT = new SimpleDateFormat("dd.MM.yyyy");
	private static final CSMCommonDAOImpl _daoInstance = new CSMCommonDAOImpl();

	public static void main(String[] args) {
//		loadEquipmentMaster();
//		loadProblemMaster();
//		loadOperationMaster();
//		loadEmployeeMaster();
//		loadPRTMaster();
//		loadSparesMaster();
//		loadOrderMain();
//		loadOrderMainHistory();
//		loadOrderEmployeeHistory();
//		loadOrderPRTHistory();
//		loadOrderSparesHistory();
//		loadOperationInstruction();
//		loadUsers();
//		System.out.println("Data laoding completed");
		

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
				{"ORDER NUMBER","EMPLOYEE ID","PROBLEM","OPERATION ID","Start Date","End Date","Actual Hours","STATUS","Create Date","no of emp"},
				{"H0000001","470008","PB0000019","OPR0000002","01.05.2014","01.05.2014","5","COMPLETED","01.05.2014","1"},
				{"H0000001","470008","PB0000019","OPR0000023","01.05.2014","01.05.2014","9","COMPLETED","01.05.2015","1"},
				{"H0000001","470008","PB0000019","OPR0000019","01.05.2014","01.05.2014","9","COMPLETED","01.05.2016","1"},
				{"H0000002","470007","PB0000005","OPR0000022","01.05.2014","01.05.2014","8","COMPLETED","01.05.2017","1"},
				{"H0000002","470007","PB0000005","OPR0000015","01.05.2014","01.05.2014","5","COMPLETED","01.05.2018","2"},
				{"H0000002","470015","PB0000005","OPR0000015","01.05.2014","01.05.2014","10","COMPLETED","01.05.2019"},
				{"H0000002","470007","PB0000005","OPR0000013","01.05.2014","01.05.2014","4","COMPLETED","01.05.2020","1"},
				{"H0000002","470007","PB0000005","OPR0000019","01.05.2014","01.05.2014","5","COMPLETED","01.05.2021","1"},
				{"H0000003","470008","PB0000005","OPR0000022","01.05.2014","01.05.2014","5","COMPLETED","01.05.2022","1"},
				{"H0000003","470008","PB0000005","OPR0000015","01.05.2014","01.05.2014","11","COMPLETED","01.05.2023","2"},
				{"H0000003","470016","PB0000005","OPR0000015","01.05.2014","01.05.2014","4","COMPLETED","01.05.2024"},
				{"H0000003","470008","PB0000005","OPR0000013","01.05.2014","01.05.2014","9","COMPLETED","01.05.2025","1"},
				{"H0000003","470016","PB0000005","OPR0000019","01.05.2014","01.05.2014","10","COMPLETED","01.05.2026","1"},
				{"H0000004","470008","PB0000019","OPR0000002","01.05.2014","01.05.2014","9","COMPLETED","01.05.2027","1"},
				{"H0000004","470008","PB0000019","OPR0000023","01.05.2014","01.05.2014","10","COMPLETED","01.05.2028","1"},
				{"H0000004","470008","PB0000019","OPR0000019","01.05.2014","01.05.2014","9","COMPLETED","01.05.2029","1"},
				{"H0000005","470023","PB0000002","OPR0000017","01.05.2014","01.05.2014","8","COMPLETED","01.05.2030","2"},
				{"H0000005","470007","PB0000002","OPR0000017","01.05.2014","01.05.2014","9","COMPLETED","01.05.2031"},
				{"H0000005","470007","PB0000002","OPR0000018","01.05.2014","01.05.2014","8","COMPLETED","01.05.2032","2"},
				{"H0000005","470023","PB0000002","OPR0000018","01.05.2014","01.05.2014","12","COMPLETED","01.05.2033"},
				{"H0000005","470007","PB0000002","OPR0000019","01.05.2014","01.05.2014","12","COMPLETED","01.05.2034","1"},
				{"H0000006","470016","PB0000019","OPR0000002","01.05.2014","01.05.2014","9","COMPLETED","01.05.2035","1"},
				{"H0000006","470016","PB0000019","OPR0000023","01.05.2014","01.05.2014","9","COMPLETED","01.05.2036","1"},
				{"H0000006","470016","PB0000019","OPR0000019","01.05.2014","01.05.2014","10","COMPLETED","01.05.2037","1"},
				{"H0000007","470007","PB0000018","OPR0000017","01.05.2014","01.05.2014","8","COMPLETED","01.05.2038","2"},
				{"H0000007","470015","PB0000018","OPR0000017","01.05.2014","01.05.2014","11","COMPLETED","01.05.2039"},
				{"H0000007","470007","PB0000018","OPR0000018","01.05.2014","01.05.2014","12","COMPLETED","01.05.2040","2"},
				{"H0000007","470015","PB0000018","OPR0000018","01.05.2014","01.05.2014","7","COMPLETED","01.05.2041"},
				{"H0000007","470007","PB0000018","OPR0000019","01.05.2014","01.05.2014","8","COMPLETED","01.05.2042","1"},
				{"H0000008","03869A","PB0000005","OPR0000022","01.05.2014","01.05.2014","6","COMPLETED","01.05.2043","1"},
				{"H0000008","03869A","PB0000005","OPR0000015","01.05.2014","01.05.2014","9","COMPLETED","01.05.2044","2"},
				{"H0000008","470016","PB0000005","OPR0000015","01.05.2014","01.05.2014","9","COMPLETED","01.05.2045"},
				{"H0000008","03869A","PB0000005","OPR0000013","01.05.2014","01.05.2014","7","COMPLETED","01.05.2046","1"},
				{"H0000008","03869A","PB0000005","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2047","1"},
				{"H0000009","470023","PB0000006","OPR0000002","01.05.2014","01.05.2014","6","COMPLETED","01.05.2048","1"},
				{"H0000009","470023","PB0000006","OPR0000010","01.05.2014","01.05.2014","7","COMPLETED","01.05.2049","2"},
				{"H0000009","470015","PB0000006","OPR0000010","01.05.2014","01.05.2014","10","COMPLETED","01.05.2050"},
				{"H0000009","470023","PB0000006","OPR0000017","01.05.2014","01.05.2014","6","COMPLETED","01.05.2051","2"},
				{"H0000009","470015","PB0000006","OPR0000017","01.05.2014","01.05.2014","9","COMPLETED","01.05.2052"},
				{"H0000009","470023","PB0000006","OPR0000018","01.05.2014","01.05.2014","12","COMPLETED","01.05.2053","2"},
				{"H0000009","470015","PB0000006","OPR0000018","01.05.2014","01.05.2014","9","COMPLETED","01.05.2054"},
				{"H0000009","470023","PB0000006","OPR0000019","01.05.2014","01.05.2014","7","COMPLETED","01.05.2055","1"},
				{"H0000010","470016","PB0000007","OPR0000021","01.05.2014","01.05.2014","7","COMPLETED","01.05.2056","1"},
				{"H0000010","03446G","PB0000007","OPR0000004","01.05.2014","01.05.2014","11","COMPLETED","01.05.2057","2"},
				{"H0000010","470030","PB0000007","OPR0000004","01.05.2014","01.05.2014","12","COMPLETED","01.05.2058"},
				{"H0000010","470016","PB0000007","OPR0000012","01.05.2014","01.05.2014","7","COMPLETED","01.05.2059","1"},
				{"H0000010","470016","PB0000007","OPR0000013","01.05.2014","01.05.2014","9","COMPLETED","01.05.2060","1"},
				{"H0000010","470016","PB0000007","OPR0000019","01.05.2014","01.05.2014","7","COMPLETED","01.05.2061","1"},
				{"H0000011","470031","PB0000004","OPR0000020","01.05.2014","01.05.2014","6","COMPLETED","01.05.2062","1"},
				{"H0000011","470031","PB0000004","OPR0000021","01.05.2014","01.05.2014","11","COMPLETED","01.05.2063","1"},
				{"H0000011","470031","PB0000004","OPR0000012","01.05.2014","01.05.2014","8","COMPLETED","01.05.2064","1"},
				{"H0000011","470031","PB0000004","OPR0000013","01.05.2014","01.05.2014","5","COMPLETED","01.05.2065","1"},
				{"H0000011","470031","PB0000004","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2066","1"},
				{"H0000012","470024","PB0000005","OPR0000022","01.05.2014","01.05.2014","9","COMPLETED","01.05.2067","1"},
				{"H0000012","470024","PB0000005","OPR0000015","01.05.2014","01.05.2014","5","COMPLETED","01.05.2068","2"},
				{"H0000012","470016","PB0000005","OPR0000015","01.05.2014","01.05.2014","7","COMPLETED","01.05.2069"},
				{"H0000012","470024","PB0000005","OPR0000013","01.05.2014","01.05.2014","11","COMPLETED","01.05.2070","1"},
				{"H0000012","470016","PB0000005","OPR0000019","01.05.2014","01.05.2014","7","COMPLETED","01.05.2071","1"},
				{"H0000013","470024","PB0000023","OPR0000007","01.05.2014","01.05.2014","4","COMPLETED","01.05.2072","1"},
				{"H0000013","470024","PB0000023","OPR0000019","01.05.2014","01.05.2014","5","COMPLETED","01.05.2073","1"},
				{"H0000014","470031","PB0000023","OPR0000007","01.05.2014","01.05.2014","10","COMPLETED","01.05.2074","1"},
				{"H0000014","470031","PB0000023","OPR0000019","01.05.2014","01.05.2014","7","COMPLETED","01.05.2075","1"},
				{"H0000015","470007","PB0000021","OPR0000002","01.05.2014","01.05.2014","7","COMPLETED","01.05.2076","1"},
				{"H0000015","470007","PB0000021","OPR0000023","01.05.2014","01.05.2014","6","COMPLETED","01.05.2077","1"},
				{"H0000015","470007","PB0000021","OPR0000022","01.05.2014","01.05.2014","10","COMPLETED","01.05.2078","1"},
				{"H0000015","470007","PB0000021","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2079","1"},
				{"H0000016","470023","PB0000023","OPR0000007","01.05.2014","01.05.2014","5","COMPLETED","01.05.2080","1"},
				{"H0000016","470023","PB0000023","OPR0000019","01.05.2014","01.05.2014","6","COMPLETED","01.05.2081","1"},
				{"H0000017","470007","PB0000016","OPR0000007","01.05.2014","01.05.2014","9","COMPLETED","01.05.2082","1"},
				{"H0000017","470007","PB0000016","OPR0000019","01.05.2014","01.05.2014","10","COMPLETED","01.05.2083","1"},
				{"H0000018","03869A","PB0000013","OPR0000002","01.05.2014","01.05.2014","10","COMPLETED","01.05.2084","1"},
				{"H0000018","03869A","PB0000013","OPR0000023","01.05.2014","01.05.2014","4","COMPLETED","01.05.2085","1"},
				{"H0000018","03869A","PB0000013","OPR0000022","01.05.2014","01.05.2014","12","COMPLETED","01.05.2086","1"},
				{"H0000018","03869A","PB0000013","OPR0000019","01.05.2014","01.05.2014","10","COMPLETED","01.05.2087","1"},
				{"H0000019","470015","PB0000012","OPR0000024","01.05.2014","01.05.2014","7","COMPLETED","01.05.2088","1"},
				{"H0000019","470015","PB0000012","OPR0000019","01.05.2014","01.05.2014","7","COMPLETED","01.05.2089","1"},
				{"H0000020","470023","PB0000016","OPR0000007","01.05.2014","01.05.2014","10","COMPLETED","01.05.2090","1"},
				{"H0000020","470023","PB0000016","OPR0000019","01.05.2014","01.05.2014","4","COMPLETED","01.05.2091","1"},
				{"H0000021","03869A","PB0000013","OPR0000002","01.05.2014","01.05.2014","9","COMPLETED","01.05.2092","1"},
				{"H0000021","03869A","PB0000013","OPR0000023","01.05.2014","01.05.2014","12","COMPLETED","01.05.2093","1"},
				{"H0000021","03869A","PB0000013","OPR0000022","01.05.2014","01.05.2014","10","COMPLETED","01.05.2094","1"},
				{"H0000021","03869A","PB0000013","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2095","1"},
				{"H0000022","470015","PB0000005","OPR0000022","01.05.2014","01.05.2014","10","COMPLETED","01.05.2096","1"},
				{"H0000022","470015","PB0000005","OPR0000015","01.05.2014","01.05.2014","8","COMPLETED","01.05.2097","2"},
				{"H0000022","470007","PB0000005","OPR0000015","01.05.2014","01.05.2014","11","COMPLETED","01.05.2098"},
				{"H0000022","470015","PB0000005","OPR0000013","01.05.2014","01.05.2014","7","COMPLETED","01.05.2099","1"},
				{"H0000022","470015","PB0000005","OPR0000019","01.05.2014","01.05.2014","12","COMPLETED","01.05.2100","1"},
				{"H0000023","470031","PB0000006","OPR0000002","01.05.2014","01.05.2014","9","COMPLETED","01.05.2101","1"},
				{"H0000023","470031","PB0000006","OPR0000010","01.05.2014","01.05.2014","12","COMPLETED","01.05.2102","2"},
				{"H0000023","470015","PB0000006","OPR0000010","01.05.2014","01.05.2014","4","COMPLETED","01.05.2103"},
				{"H0000023","470031","PB0000006","OPR0000017","01.05.2014","01.05.2014","12","COMPLETED","01.05.2104","2"},
				{"H0000023","470015","PB0000006","OPR0000017","01.05.2014","01.05.2014","11","COMPLETED","01.05.2105"},
				{"H0000023","470031","PB0000006","OPR0000018","01.05.2014","01.05.2014","8","COMPLETED","01.05.2106","2"},
				{"H0000023","470015","PB0000006","OPR0000018","01.05.2014","01.05.2014","11","COMPLETED","01.05.2107"},
				{"H0000023","470015","PB0000006","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2108","1"},
				{"H0000024","470008","PB0000005","OPR0000022","01.05.2014","01.05.2014","7","COMPLETED","01.05.2109","1"},
				{"H0000024","470008","PB0000005","OPR0000015","01.05.2014","01.05.2014","12","COMPLETED","01.05.2110","2"},
				{"H0000024","470016","PB0000005","OPR0000015","01.05.2014","01.05.2014","4","COMPLETED","01.05.2111"},
				{"H0000024","470016","PB0000005","OPR0000013","01.05.2014","01.05.2014","9","COMPLETED","01.05.2112","1"},
				{"H0000024","470008","PB0000005","OPR0000019","01.05.2014","01.05.2014","11","COMPLETED","01.05.2113","1"},
				{"H0000025","470024","PB0000003","OPR0000002","01.05.2014","01.05.2014","10","COMPLETED","01.05.2114","1"},
				{"H0000025","03446G","PB0000003","OPR0000016","01.05.2014","01.05.2014","8","COMPLETED","01.05.2115","2"},
				{"H0000025","470022","PB0000003","OPR0000016","01.05.2014","01.05.2014","12","COMPLETED","01.05.2116"},
				{"H0000025","470024","PB0000003","OPR0000010","01.05.2014","01.05.2014","9","COMPLETED","01.05.2117","2"},
				{"H0000025","470008","PB0000003","OPR0000010","01.05.2014","01.05.2014","10","COMPLETED","01.05.2118"},
				{"H0000025","470024","PB0000003","OPR0000017","01.05.2014","01.05.2014","5","COMPLETED","01.05.2119","2"},
				{"H0000025","470008","PB0000003","OPR0000017","01.05.2014","01.05.2014","4","COMPLETED","01.05.2120"},
				{"H0000025","470024","PB0000003","OPR0000018","01.05.2014","01.05.2014","11","COMPLETED","01.05.2121","2"},
				{"H0000025","470008","PB0000003","OPR0000018","01.05.2014","01.05.2014","5","COMPLETED","01.05.2122"},
				{"H0000025","470024","PB0000003","OPR0000019","01.05.2014","01.05.2014","6","COMPLETED","01.05.2123","1"},
				};
		
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
				{"Operation ID","Steps"},
				{"OPR0000001","Inspect equipment daily before starting."},
				{"OPR0000002","Make sure all control levers are in neutral position."},
				{"OPR0000003","Stop engine immediately, if engine oil pressure indicator glows ON while operating the eqpt."},
				{"OPR0000004","Drain water and deposits/sediments from fuel tank."},
				{"OPR0000005","Always keep attachment pedal locked with pedal lock when attachment pedal for Rock breaker is not in use."},
				{"OPR0000006","Operate the eqpt with the tracks positioned perpendicular to the eqpt which can more easily excavate if the cliff face collapses."},
				{"OPR0000007","When digging deeply, avoid hitting bottom of boom or bucket cylinder hoses against the ground."},
				{"OPR0000008","Use the bucket only for digging. Do not use bucket as a jack hammer or wrecking ball to avoid accident."},
				{"OPR0000009","Always lower the attachment or implement to the ground before work on the eqpt."},
				{"OPR0000010","Continuous operation of the engine with low or high coolant temp can damage the engine."},
				{"OPR0000011","Check for worn or frayed wires and loose connections."},
				{"OPR0000012","Check for leaks, kinked hoses and lines or hoses those which rub against each other or other parts."},
				{"OPR0000013","Check lubrication points on the periodic service chart."},
				{"OPR0000014","Grease in track adjuster is having more pressure and do not remove grease fitting or valve assy to avoid injury/damage."},
				{"OPR0000015","Always be familiar and well conversant with safety signs/symbols to avoid accident."},
				{"OPR0000016","Always park the eqpt on a level surface and lower the bucket to the ground."},
				{"OPR0000017","Extra care be taken when the cab is swung around so that it is facing the rear/track motor."},
				{"OPR0000018","When not traveling, do not place your feet on the travel pedals."},
				{"OPR0000019","Always stop the eqpt to select a different speed range and do not change the speed mode while traveling."},
				{"OPR0000020","Do not excavate on hard or rocky ground with the boom positioned diagonally across the under carriage. "},
				{"OPR0000021","Walking or working under raised boom is hazardous."},
				{"OPR0000022","Keep all the controls of the eqpt clean and dry."},
				{"OPR0000023","An incorrectly parking eqpt can move without an operator."},
				{"OPR0000024","When lowering the boom, avoid sudden stop that may cause shock load damage to the equipment."},
				{"OPR0000025","When operating the arm, avoid lowering the cylinder to prevent the cylinder damage."},
				{"OPR0000026","When digging at an angle, avoid striking the tracks with bucket teeth."},
				{"OPR0000027","Operate the equipment slowly with the Rock breaker attachment as the breaker is heavier than bucket."},
				{"OPR0000028","Avoid using the Rock breaker for hammering operation."},
				{"OPR0000028","To prevent the cylinder damage, do not operate the Rock breaker with hydraulic cylinder fully retracted or fully extended."},
				{"OPR0000028","Stop operation if Rock breaker hydraulic hoses jump up abnormally due to change in accumulator pressure or damaged accumulator."},
				{"OPR0000001","Drain water and deposits/sediments from fuel tank."},
				{"OPR0000002","Always keep attachment pedal locked with pedal lock when attachment pedal for Rock breaker is not in use."},
				{"OPR0000003","Operate the eqpt with the tracks positioned perpendicular to the eqpt which can more easily excavate if the cliff face collapses."},
				{"OPR0000004","When digging deeply, avoid hitting bottom of boom or bucket cylinder hoses against the ground."},
				{"OPR0000005","Use the bucket only for digging. Do not use bucket as a jack hammer or wrecking ball to avoid accident."},
				{"OPR0000006","Always lower the attachment or implement to the ground before work on the eqpt."},
				{"OPR0000007","Continuous operation of the engine with low or high coolant temp can damage the engine."},
				{"OPR0000008","Check for worn or frayed wires and loose connections."},
				{"OPR0000009","Check for leaks, kinked hoses and lines or hoses those which rub against each other or other parts."},
				{"OPR0000010","Check lubrication points on the periodic service chart."},
				{"OPR0000011","Grease in track adjuster is having more pressure and do not remove grease fitting or valve assy to avoid injury/damage."},
				{"OPR0000012","Always be familiar and well conversant with safety signs/symbols to avoid accident."},
				{"OPR0000013","Always park the eqpt on a level surface and lower the bucket to the ground."},
				{"OPR0000014","Extra care be taken when the cab is swung around so that it is facing the rear/track motor."},
				{"OPR0000015","When not traveling, do not place your feet on the travel pedals."},
				{"OPR0000016","An incorrectly parking eqpt can move without an operator."},
				{"OPR0000017","When lowering the boom, avoid sudden stop that may cause shock load damage to the equipment."},
				{"OPR0000018","When operating the arm, avoid lowering the cylinder to prevent the cylinder damage."},
				{"OPR0000019","When digging at an angle, avoid striking the tracks with bucket teeth."},
				{"OPR0000020","Operate the equipment slowly with the Rock breaker attachment as the breaker is heavier than bucket."},
				{"OPR0000021","Avoid using the Rock breaker for hammering operation."},
				{"OPR0000022","Drain water and deposits/sediments from fuel tank."},
				{"OPR0000023","Always keep attachment pedal locked with pedal lock when attachment pedal for Rock breaker is not in use."},
				{"OPR0000024","Operate the eqpt with the tracks positioned perpendicular to the eqpt which can more easily excavate if the cliff face collapses."},
				{"OPR0000025","When digging deeply, avoid hitting bottom of boom or bucket cylinder hoses against the ground."},
				{"OPR0000026","Use the bucket only for digging. Do not use bucket as a jack hammer or wrecking ball to avoid accident."},
				{"OPR0000027","Always lower the attachment or implement to the ground before work on the eqpt."},
				{"OPR0000028","Continuous operation of the engine with low or high coolant temp can damage the engine."},
				{"OPR0000028","Check for worn or frayed wires and loose connections."},
				{"OPR0000028","Check for leaks, kinked hoses and lines or hoses those which rub against each other or other parts."},
				};
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
				{"ORDER NUMBER","OPERATION","MATERIAL NUMBER","UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY","PLANT","Required QTY","STORAGE LOCATION","Used Qty","CreateDate"},
				{"H0000001","0010","BEARING3","EA","584","USD","BPM1","2","MAIN","9","04.03,2014"},
				{"H0000001","0011","BEARING4","EA","1016","USD","BPM1","3","MAIN","6","04.03,2014"},
				{"H0000001","0012","BEARING5","EA","696","USD","BPM1","9","MAIN","6","04.03,2014"},
				{"H0000001","0013","BEARING6","EA","716","USD","BPM1","5","MAIN","5","04.03,2014"},
				{"H0000002","0010","BEARING7","EA","327","USD","BPM2","11","MAIN","6","04.03,2015"},
				{"H0000002","0011","OILFILTER3","EA","1183","USD","BPM3","4","MAIN","4","04.03,2016"},
				{"H0000002","0012","OILFILTER4","EA","362","USD","BPM4","10","MAIN","9","04.03,2017"},
				{"H0000002","0013","PLANETARYGEAR","EA","863","USD","BPM5","1","MAIN","4","04.03,2018"},
				{"H0000003","0010","BEARING2","EA","243","USD","BPM6","8","MAIN","8","04.03,2019"},
				{"H0000003","0011","BEARING3","EA","585","USD","BPM7","5","MAIN","5","04.03,2020"},
				{"H0000003","0012","BEARING4","EA","268","USD","BPM8","10","MAIN","8","04.03,2021"},
				{"H0000003","0013","BEARING5","EA","589","USD","BPM9","1","MAIN","6","04.03,2022"},
				{"H0000004","0010","BEARING7","EA","251","USD","BPM10","6","MAIN","9","04.03,2023"},
				{"H0000004","0011","OILFILTER2","EA","545","USD","BPM11","6","MAIN","4","04.03,2024"},
				{"H0000004","0012","BEARING5","EA","446","USD","BPM12","9","MAIN","8","04.03,2025"},
				{"H0000004","0013","BEARING6","EA","428","USD","BPM13","4","MAIN","8","04.03,2026"},
				{"H0000005","0010","BEARING2","EA","435","USD","BPM14","9","MAIN","9","04.03,2027"},
				{"H0000005","0011","BEARING3","EA","367","USD","BPM15","3","MAIN","4","04.03,2028"},
				{"H0000005","0012","BEARING4","EA","744","USD","BPM16","7","MAIN","6","04.03,2029"},
				{"H0000005","0013","BEARING5","EA","989","USD","BPM17","5","MAIN","6","04.03,2030"},
				{"H0000006","0010","BEARING7","EA","788","USD","BPM18","12","MAIN","9","04.03,2031"},
				{"H0000006","0011","BEARING2","EA","690","USD","BPM19","1","MAIN","4","04.03,2032"},
				{"H0000006","0012","BEARING3","EA","1028","USD","BPM20","6","MAIN","9","04.03,2033"},
				{"H0000006","0013","BEARING4","EA","545","USD","BPM21","3","MAIN","6","04.03,2034"},
				{"H0000007","0010","BEARING5","EA","359","USD","BPM22","2","MAIN","5","04.03,2035"},
				{"H0000007","0011","BEARING7","EA","434","USD","BPM23","8","MAIN","7","04.03,2036"},
				{"H0000007","0012","OILFILTER2","EA","1160","USD","BPM24","6","MAIN","5","04.03,2037"},
				{"H0000007","0013","BEARING6","EA","233","USD","BPM25","1","MAIN","5","04.03,2038"},
				{"H0000008","0010","BEARING7","EA","426","USD","BPM26","10","MAIN","9","04.03,2039"},
				{"H0000008","0011","OILFILTER3","EA","879","USD","BPM27","11","MAIN","8","04.03,2040"},
				{"H0000008","0012","OILFILTER4","EA","554","USD","BPM28","12","MAIN","9","04.03,2041"},
				{"H0000008","0013","PLANETARYGEAR","EA","725","USD","BPM29","1","MAIN","5","04.03,2042"},
				{"H0000009","0010","DIFFERENTIAL","EA","415","USD","BPM30","2","MAIN","6","04.03,2043"},
				{"H0000009","0011","BEARING3","EA","611","USD","BPM31","4","MAIN","5","04.03,2044"},
				{"H0000009","0012","BEARING4","EA","550","USD","BPM32","5","MAIN","7","04.03,2045"},
				{"H0000009","0013","BEARING5","EA","316","USD","BPM33","4","MAIN","9","04.03,2046"},
				{"H0000010","0010","BEARING6","EA","681","USD","BPM34","12","MAIN","4","04.03,2047"},
				{"H0000010","0011","BEARING7","EA","260","USD","BPM35","1","MAIN","7","04.03,2048"},
				{"H0000010","0012","OILFILTER3","EA","479","USD","BPM36","3","MAIN","8","04.03,2049"},
				{"H0000010","0013","OILFILTER4","EA","778","USD","BPM37","2","MAIN","6","04.03,2050"},
				{"H0000011","0010","PLANETARYGEAR","EA","293","USD","BPM38","7","MAIN","6","04.03,2051"},
				{"H0000011","0011","DIFFERENTIAL","EA","1088","USD","BPM39","9","MAIN","8","04.03,2052"},
				{"H0000011","0012","BEARING3","EA","401","USD","BPM40","8","MAIN","8","04.03,2053"},
				{"H0000011","0013","BEARING4","EA","1111","USD","BPM41","5","MAIN","4","04.03,2054"},
				{"H0000012","0010","BEARING5","EA","863","USD","BPM42","6","MAIN","9","04.03,2055"},
				{"H0000012","0011","BEARING6","EA","784","USD","BPM43","12","MAIN","5","04.03,2056"},
				{"H0000012","0012","BEARING7","EA","948","USD","BPM44","7","MAIN","8","04.03,2057"},
				{"H0000012","0013","OILFILTER3","EA","843","USD","BPM45","10","MAIN","7","04.03,2058"},
				{"H0000013","0010","OILFILTER4","EA","1107","USD","BPM46","12","MAIN","7","04.03,2059"},
				{"H0000013","0011","PLANETARYGEAR","EA","479","USD","BPM47","12","MAIN","8","04.03,2060"},
				{"H0000013","0012","DIFFERENTIAL","EA","1132","USD","BPM48","5","MAIN","6","04.03,2061"},
				{"H0000013","0013","BEARING2","EA","935","USD","BPM49","9","MAIN","8","04.03,2062"},
				{"H0000014","0010","BEARING3","EA","998","USD","BPM50","8","MAIN","8","04.03,2063"},
				{"H0000014","0011","BEARING4","EA","1031","USD","BPM51","4","MAIN","7","04.03,2064"},
				{"H0000014","0012","BEARING5","EA","253","USD","BPM52","7","MAIN","6","04.03,2065"},
				{"H0000014","0013","BEARING7","EA","547","USD","BPM53","6","MAIN","8","04.03,2066"},
				{"H0000015","0010","OILFILTER2","EA","611","USD","BPM54","9","MAIN","9","04.03,2067"},
				{"H0000015","0011","BEARING2","EA","511","USD","BPM55","6","MAIN","4","04.03,2068"},
				{"H0000015","0012","BEARING3","EA","287","USD","BPM56","10","MAIN","7","04.03,2069"},
				{"H0000015","0013","BEARING4","EA","728","USD","BPM57","6","MAIN","4","04.03,2070"},
				{"H0000016","0010","BEARING5","EA","667","USD","BPM58","10","MAIN","9","04.03,2071"},
				{"H0000016","0011","BEARING7","EA","957","USD","BPM59","10","MAIN","9","04.03,2072"},
				{"H0000016","0012","OILFILTER2","EA","825","USD","BPM60","2","MAIN","4","04.03,2073"},
				{"H0000016","0013","BEARING6","EA","786","USD","BPM61","5","MAIN","4","04.03,2074"},
				{"H0000017","0010","OILFILTER1","EA","908","USD","BPM62","7","MAIN","5","04.03,2075"},
				{"H0000017","0011","BEARING1","EA","1155","USD","BPM63","10","MAIN","6","04.03,2076"},
				{"H0000017","0012","BEARING3","EA","1073","USD","BPM64","5","MAIN","6","04.03,2077"},
				{"H0000017","0013","BEARING4","EA","607","USD","BPM65","7","MAIN","5","04.03,2078"},
				{"H0000018","0010","BEARING6","EA","765","USD","BPM66","5","MAIN","5","04.03,2079"},
				{"H0000018","0011","OILFILTER1","EA","569","USD","BPM67","9","MAIN","8","04.03,2080"},
				{"H0000018","0012","BEARING1","EA","622","USD","BPM68","11","MAIN","5","04.03,2081"},
				{"H0000018","0013","BEARING3","EA","478","USD","BPM69","7","MAIN","7","04.03,2082"},
				{"H0000019","0010","BEARING4","EA","1047","USD","BPM70","7","MAIN","9","04.03,2083"},
				{"H0000019","0011","BEARING6","EA","432","USD","BPM71","9","MAIN","4","04.03,2084"},
				{"H0000019","0012","OILFILTER1","EA","1178","USD","BPM72","3","MAIN","4","04.03,2085"},
				{"H0000019","0013","BEARING1","EA","831","USD","BPM73","3","MAIN","8","04.03,2086"},
				{"H0000020","0010","BEARING3","EA","957","USD","BPM74","4","MAIN","5","04.03,2087"},
				{"H0000020","0011","BEARING4","EA","810","USD","BPM75","7","MAIN","5","04.03,2088"},
				{"H0000020","0012","BEARING6","EA","329","USD","BPM76","5","MAIN","4","04.03,2089"},
				{"H0000020","0013","OILFILTER1","EA","317","USD","BPM77","2","MAIN","5","04.03,2090"},
				{"H0000021","0010","BEARING3","EA","861","USD","BPM78","5","MAIN","7","04.03,2091"},
				{"H0000021","0011","BEARING4","EA","764","USD","BPM79","11","MAIN","4","04.03,2092"},
				{"H0000021","0012","BEARING5","EA","378","USD","BPM80","2","MAIN","4","04.03,2093"},
				{"H0000021","0013","BEARING6","EA","927","USD","BPM81","12","MAIN","8","04.03,2094"},
				{"H0000022","0010","BEARING7","EA","226","USD","BPM82","8","MAIN","6","04.03,2095"},
				{"H0000022","0011","OILFILTER3","EA","376","USD","BPM83","8","MAIN","6","04.03,2096"},
				{"H0000022","0012","OILFILTER4","EA","623","USD","BPM84","5","MAIN","8","04.03,2097"},
				{"H0000022","0013","PLANETARYGEAR","EA","1037","USD","BPM85","8","MAIN","4","04.03,2098"},
				{"H0000023","0010","DIFFERENTIAL","EA","952","USD","BPM86","8","MAIN","8","04.03,2099"},
				{"H0000023","0011","BEARING3","EA","1017","USD","BPM87","6","MAIN","5","04.03,2100"},
				{"H0000023","0012","BEARING4","EA","330","USD","BPM88","10","MAIN","5","04.03,2101"},
				{"H0000023","0013","BEARING5","EA","511","USD","BPM89","4","MAIN","8","04.03,2102"},
				{"H0000024","0010","BEARING6","EA","680","USD","BPM90","5","MAIN","6","04.03,2103"},
				{"H0000024","0011","BEARING7","EA","1199","USD","BPM91","1","MAIN","5","04.03,2104"},
				{"H0000024","0012","OILFILTER3","EA","846","USD","BPM92","4","MAIN","4","04.03,2105"},
				{"H0000024","0013","OILFILTER4","EA","519","USD","BPM93","3","MAIN","7","04.03,2106"},
				{"H0000025","0010","PLANETARYGEAR","EA","1104","USD","BPM94","11","MAIN","4","04.03,2107"},
				{"H0000025","0011","DIFFERENTIAL","EA","852","USD","BPM95","7","MAIN","5","04.03,2108"},
				{"H0000025","0012","OILFILTER3","EA","1056","USD","BPM96","5","MAIN","9","04.03,2109"},
				{"H0000025","0013","OILFILTER4","EA","1035","USD","BPM97","2","MAIN","6","04.03,2110"},
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
		String[][] data = new String[][] {
				{"ORDER NUMBER","OPERATION","PRT TYPE","Item number","PRT NUMBER","Usage start date","Usage end dtae","Duration","QtyAssigned","QuantityUsed","CATALOG PROFILE"},
				{"H0000001","0010","MAT","0001","PRT0001","01.03.2014","01.03.2014","9","1","1","HAUL"},
				{"H0000002","0011","MAT","0002","PRT0002","01.03.2014","01.03.2014","6","2","2","EXCA"},
				{"H0000003","0012","MAT","0003","PRT0003","01.03.2014","01.03.2014","7","1","1","EXCA"},
				{"H0000004","0013","MAT","0004","PRT0004","01.03.2014","01.03.2014","10","3","3","HAUL"},
				{"H0000005","0014","MAT","0005","PRT0005","01.03.2014","01.03.2014","8","1","1","EXCA"},
				{"H0000006","0015","MAT","0006","PRT0006","01.03.2014","01.03.2014","9","2","2","HAUL"},
				{"H0000007","0016","MAT","0007","PRT0007","01.03.2014","01.03.2014","5","1","1","HAUL"},
				{"H0000008","0017","MAT","0008","PRT0005","01.03.2014","01.03.2014","5","4","4","EXCA"},
				{"H0000009","0018","MAT","0009","PRT0006","01.03.2014","01.03.2014","5","1","1","EXCA"},
				{"H0000010","0019","MAT","0010","PRT0007","01.03.2014","01.03.2014","9","1","1","EXCA"},
				{"H0000011","0020","MAT","0011","PRT0002","01.03.2014","01.03.2014","3","2","2","EXCA"},
				{"H0000012","0021","MAT","0012","PRT0003","01.03.2014","01.03.2014","6","1","1","EXCA"},
				{"H0000013","0022","MAT","0013","PRT0004","01.03.2014","01.03.2014","9","1","1","HAUL"},
				{"H0000014","0023","MAT","0014","PRT0005","01.03.2014","01.03.2014","1","3","3","HAUL"},
				{"H0000015","0024","MAT","0015","PRT0006","01.03.2014","01.03.2014","10","1","1","HAUL"},
				{"H0000016","0025","MAT","0016","PRT0007","01.03.2014","01.03.2014","1","2","2","HAUL"},
				{"H0000017","0026","MAT","0017","PRT0001","01.03.2014","01.03.2014","9","1","1","DUMP"},
				{"H0000018","0027","MAT","0018","PRT0002","01.03.2014","01.03.2014","2","1","1","DUMP"},
				{"H0000019","0028","MAT","0019","PRT0006","01.03.2014","01.03.2014","7","1","1","DUMP"},
				{"H0000020","0029","MAT","0020","PRT0006","01.03.2014","01.03.2014","8","2","2","DUMP"},
				{"H0000021","0030","MAT","0021","PRT0004","01.03.2014","01.03.2014","7","1","1","DUMP"},
				{"H0000022","0031","MAT","0022","PRT0006","01.03.2014","01.03.2014","3","4","4","EXCA"},
				{"H0000023","0032","MAT","0023","PRT0002","01.03.2014","01.03.2014","1","1","1","EXCA"},
				{"H0000024","0033","MAT","0024","PRT0003","01.03.2014","01.03.2014","6","3","3","EXCA"},
				{"H0000025","0034","MAT","0025","PRT0004","01.03.2014","01.03.2014","1","1","1","EXCA"},
				};
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
		String[][] data = new String[][] {
				{"Order Number","Order Type","Finish by","Created on","CATALOG PROFILE","Description","Problem","Equipment Number","MODEL","Plant","Responsible cost center","Order Currency","Order status","PRIORITY","Work Start","End of Work","Total Hours"},
				{"H0000001","BREK","05.03.2014","02.01.2014","HAUL","Noise from engine form Hauler 21","PB0000019","1000303","25","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","51"},
				{"H0000002","BREK","05.03.2014","02.01.2015","EXCA","Engine Not starting for Excavator 40","PB0000002","1000304","EX200","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","12"},
				{"H0000003","BREK","05.03.2014","02.01.2016","HAUL","Noise from engine form Hauler 21","PB0000019","1000316","25","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","32"},
				{"H0000004","BREK","05.03.2014","02.01.2017","HAUL","Engine Not starting for Hauler  90","PB0000018","1000317","20","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","46"},
				{"H0000005","PRED","05.03.2014","02.01.2018","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000305","EX60","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","56"},
				{"H0000006","PRED","05.03.2014","02.01.2019","EXCA","Excavator - component Replacement","PB0000006","1000306","EX200","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","15"},
				{"H0000007","PRED","05.03.2014","02.01.2020","EXCA","Excavator - component Replacement","PB0000007","1000308","EX60","BPM1","MECH","USD","CLSD","3","01.03.2014","11.03.2014","53"},
				{"H0000008","PRED","05.03.2014","02.01.2021","EXCA","Excavator - component Replacement","PB0000004","1000309","EX200","BPM1","MECH","USD","CLSD","4","01.03.2014","11.03.2014","47"},
				{"H0000009","PRED","05.03.2014","02.01.2022","EXCA","Excavator 3M scheduled Maintenance","PB0000005","1000310","EX60","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","30"},
				{"H0000010","PRED","05.03.2014","02.01.2023","EXCA","Excavator - component Replacement","PB0000007","1000311","EX200","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","14"},
				{"H0000011","PRED","05.03.2014","02.01.2024","EXCA","Excavator - component Replacement","PB0000003","1000312","EX60","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","27"},
				{"H0000012","PRED","05.03.2014","02.01.2025","EXCA","Excavator - component Replacement","PB0000006","1000313","EX200","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","24"},
				{"H0000013","PRED","05.03.2014","02.01.2026","HAUL","Hauler 2M scheduled Maintenance","PB0000023","1000318","25","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","51"},
				{"H0000014","PRED","05.03.2014","02.01.2027","HAUL","Hauler - component Replacement","PB0000023","1000319","20","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","31"},
				{"H0000015","PRED","05.03.2014","02.01.2028","HAUL","Hauler - component Replacement","PB0000021","1000320","20","BPM1","MECH","USD","CLSD","3","01.03.2014","11.03.2014","14"},
				{"H0000016","PRED","05.03.2014","02.01.2029","HAUL","Hauler - component Replacement","PB0000023","1000321","32","BPM1","MECH","USD","CLSD","3","01.03.2014","11.03.2014","10"},
				{"H0000017","PRED","05.03.2014","02.01.2030","DUMP","Dumper - component Replacement","PB0000016","1000322","35T","BPM1","MECH","USD","CLSD","4","01.03.2014","11.03.2014","17"},
				{"H0000018","PRED","05.03.2014","02.01.2031","DUMP","Dumper - component Replacement","PB0000013","1000323","40T","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","34"},
				{"H0000019","PRED","05.03.2014","02.01.2032","DUMP","Dumper - component Replacement","PB0000012","1000324","35T","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","44"},
				{"H0000020","PRED","05.03.2014","02.01.2033","DUMP","Dumper - component Replacement","PB0000016","1000325","32T","BPM1","MECH","USD","CLSD","2","01.03.2014","11.03.2014","33"},
				{"H0000021","PRED","05.03.2014","02.01.2034","DUMP","Dumper - component Replacement","PB0000013","1000326","22T","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","42"},
				{"H0000022","PREV","05.03.2014","02.01.2035","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000301","EX60","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","44"},
				{"H0000023","PREV","05.03.2014","02.01.2036","EXCA","Excavator 3M scheduled Maintenance","PB0000006","1000302","EX200","BPM1","ELEC","USD","CLSD","2","01.03.2014","11.03.2014","53"},
				{"H0000024","PREV","05.03.2014","02.01.2037","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000314","EX60","BPM1","MECH","USD","CLSD","1","01.03.2014","11.03.2014","43"},
				{"H0000025","PREV","05.03.2014","02.01.2038","EXCA","Excavator 3M scheduled Maintenance","PB0000007","1000315","EX200","BPM1","ELEC","USD","CLSD","2","01.03.2014","11.03.2014","53"},
				};

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
		String[][] data = new String[][] {
				{"Order Number","Order Type","Finish by","Created on","CATALOG PROFILE","Description","Problem","Equipment Number","MODEL","Plant","Responsible cost center","Order Currency","Order status","PRIORITY"},
				{"10000103","BREK","08.03.2015","08.03.2015","HAUL","Noise from engine form Hauler 21","PB0000019","1000310","20","BPM1","MECH","USD","CRTD","2"},
				{"10000104","BREK","08.03.2015","08.03.2015","EXCA","Engine Not starting for Excavator 40","PB0000002","1000301","EX60","BPM1","MECH","USD","REL","1"},
				{"10000116","BREK","08.03.2015","08.03.2015","HAUL","Noise from engine form Hauler 21","PB0000019","1000316","20","BPM1","MECH","USD","CRTD","2"},
				{"10000117","BREK","08.03.2015","08.03.2015","HAUL","Engine Not starting for Hauler  90","PB0000018","1000317","25","BPM1","MECH","USD","REL","1"},
				{"10000105","PRED","15.03.2015","08.03.2015","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000302","EX200","BPM1","MECH","USD","REL","1"},
				{"10000106","PRED","15.03.2015","08.03.2015","EXCA","Excavator - component Replacement","PB0000006","1000303","EX200LC","BPM1","MECH","USD","REL","2"},
				{"10000108","PRED","15.03.2015","08.03.2015","EXCA","Excavator - component Replacement","PB0000007","1000304","EX600","BPM1","MECH","USD","REL","3"},
				{"10000109","PRED","15.04.2015","08.03.2015","EXCA","Excavator - component Replacement","PB0000004","1000314","EX200","BPM1","MECH","USD","REL","4"},
				{"10000110","PRED","15.03.2015","08.03.2015","EXCA","Excavator 3M scheduled Maintenance","PB0000005","1000315","EX200LC","BPM1","MECH","USD","REL","2"},
				{"10000118","PRED","15.04.2015","08.03.2015","HAUL","Hauler 2M scheduled Maintenance","PB0000023","1000318","20","BPM1","MECH","USD","REL","1"},
				{"10000119","PRED","15.03.2015","08.03.2015","HAUL","Hauler - component Replacement","PB0000023","1000319","20","BPM1","MECH","USD","REL","2"},
				{"10000120","PRED","15.02.2015","08.03.2015","HAUL","Hauler - component Replacement","PB0000021","1000320","32","BPM1","MECH","USD","REL","3"},
				{"10000121","PRED","15.03.2015","08.03.2015","HAUL","Hauler - component Replacement","PB0000023","1000321","32","BPM1","MECH","USD","REL","3"},
				{"10000122","PRED","15.03.2015","08.03.2015","DUMP","Dumper - component Replacement","PB0000016","1000305","35T","BPM1","MECH","USD","REL","4"},
				{"10000123","PRED","14.03.2015","08.03.2015","DUMP","Dumper - component Replacement","PB0000013","1000306","40T","BPM1","MECH","USD","REL","2"},
				{"10000124","PRED","15.04.2015","08.03.2015","DUMP","Dumper - component Replacement","PB0000012","1000307","35T","BPM1","MECH","USD","REL","1"},
				{"10000125","PRED","15.03.2015","08.03.2015","DUMP","Dumper - component Replacement","PB0000016","1000308","32T","BPM1","MECH","USD","REL","2"},
				{"10000126","PRED","15.03.2015","08.03.2015","DUMP","Dumper - component Replacement","PB0000013","1000309","22T","BPM1","MECH","USD","REL","1"},
				{"10000101","PREV","23.03.2015","08.03.2015","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000301","EX60","BPM1","MECH","USD","REL","1"},
				{"10000102","PREV","23.03.2015","08.03.2015","EXCA","Excavator 3M scheduled Maintenance","PB0000006","1000302","EX200","BPM1","ELEC","USD","REL","2"},
				{"10000114","PREV","23.03.2015","08.03.2015","EXCA","Excavator 2M scheduled Maintenance","PB0000005","1000303","EX200LC","BPM1","MECH","USD","REL","1"},
				{"10000115","PREV","23.03.2015","08.03.2015","EXCA","Excavator 3M scheduled Maintenance","PB0000007","1000304","EX600","BPM1","ELEC","USD","REL","2"},
				 };
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

		String[][] equipmentMaster = new String[][] {
				{"EQUIPMENT NUMBER","PLANT","DESCRIPTION","MODEL NUMBER","SERIAL NUMBER","MANUFACTURER","INSTALLATION DATE","RATE/HOUR","CURRENCY","PDF Doc","CATALOG PROFILE","Standard Operating Proceedure"},
				{"1000301","BPM1","Excavator EX60 TATA HITACHI","EX60","1","HITACHI","01.01.2010","10000","USD","PDFExcavatorEX60TATAHITACHI.pdf","EXCA","PDF - Excavator EX60 TATA HITACHI"},
				{"1000302","BPM1","Excavator EX 200 TATA HITACHI","EX200","2","HITACHI","01.01.2011","120000","USD","PDFExcavatorEX200TATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 TATA HITACHI"},
				{"1000303","BPM1","Excavator EX 200 LC TATA HITACHI","EX200LC","3","HITACHI","01.01.2012","130000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000304","BPM1","Excavator Ex 600 TATA HITACHI","EX600","4","HITACHI","01.01.2013","200000","USD","PDFExcavatorEx600TATAHITACHI.pdf","EXCA","PDF- Excavator Ex 600 TATA HITACHI"},
				{"1000305","BPM1","EUCLID DUMPER 35 T","35T","1","EUCLID","01.01.2014","10000","USD","PDFEUCLIDDUMPER60T.pdf","DUMP","PDF- EUCLID DUMPER 60 T"},
				{"1000306","BPM1","EUCLID DUMPER 40 T","40T","2","EUCLID","01.01.2015","9000","USD","PDFEUCLIDDUMPER40T.pdf","DUMP","PDF- EUCLID DUMPER 40 T"},
				{"1000307","BPM1","EUCLID DUMPER 35 T","35T","3","EUCLID","01.01.2016","10000","USD","PDFEUCLIDDUMPER60T.pdf","DUMP","PDF- EUCLID DUMPER 60 T"},
				{"1000308","BPM1","EUCLID DUMPER 32 T","32T","4","EUCLID","01.01.2017","9000","USD","PDFEUCLIDDUMPER40T.pdf","DUMP","PDF- EUCLID DUMPER 40 T"},
				{"1000309","BPM1","EUCLID DUMPER 22 T","22T","5","EUCLID","01.01.2018","11000","USD","PDFEUCLIDDUMPER62T.pdf","DUMP","PDF- EUCLID DUMPER 62 T"},
				{"1000310","BPM1","HAULER 20T","20","1","CAT","01.01.2019","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000311","BPM1","HAULER 20T","20","2","CAT","01.01.2020","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000312","BPM1","HAULER 25T","25","3","CAT","01.01.2021","4000","USD","PDFHAULER25T.pdf","HAUL","PDF- HAULER 25T"},
				{"1000313","BPM1","HAULER 20T","20","4","CAT","01.01.2022","4000","USD","PDFHAULER20T.pdf","HAUL","PDF- HAULER 20T"},
				{"1000314","BPM1","Excavator EX 200 TATA HITACHI","EX200","23","HITACHI","01.01.2023","120000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000315","BPM1","Excavator EX 200 LC TATA HITACHI","EX200LC","24","HITACHI","01.01.2024","130000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","EXCA","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000316","BPM1","HAULER 20T","20","25","CAT","01.01.2025","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000317","BPM1","HAULER 25T","25","26","CAT","01.01.2026","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000318","BPM1","HAULER 20T","20","27","CAT","01.01.2027","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000319","BPM1","HAULER 20T","20","28","CAT","01.01.2028","4000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000320","BPM1","HAULER 32T","32","29","CAT","01.01.2029","5000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000321","BPM1","HAULER 32T","32","30","CAT","01.01.2030","5000","USD","PDFExcavatorEX200LCTATAHITACHI.pdf","HAUL","PDF- Excavator EX 200 LC TATA HITACHI"},
				{"1000322","BPM1","EUCLID DUMPER 35 T","35T","31","EUCLID","01.01.2031","9000","USD","PDFEuclid35T.pdf","DUMP","PDF- Euclid 35T"},
				{"1000323","BPM1","EUCLID DUMPER 40 T","40T","32","EUCLID","01.01.2032","10000","USD","PDFEuclid40T.pdf","DUMP","PDF- Euclid 40T"},
				{"1000324","BPM1","EUCLID DUMPER 35 T","35T","33","EUCLID","01.01.2033","9000","USD","PDFEuclid35T.pdf","DUMP","PDF- Euclid 35T "},
				{"1000325","BPM1","EUCLID DUMPER 32 T","32T","34","EUCLID","01.01.2034","11000","USD","PDFEuclid32T.pdf","DUMP","PDF- Euclid 32T "},
				{"1000326","BPM1","EUCLID DUMPER 22 T","22T","35","EUCLID","01.01.2035","9000","USD","PDFEuclid22T.pdf","DUMP","PDF- Euclid 22T "},
				}
;

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
		String[][] prtMaster = new String[][] {
				{"PRT NUMBER","PRT TYPE","DESCRIPTION","UNIT OF MEASURE","AMOUNT IN CURRENCY","CURRENCY","PLANT","STOCK QTY","STORAGE LOCATION","CATALOG PROFILE","CATALOG PROFILE"},
				{"PRT0001","MAT","TORQUE WRENCH 11.4 Nm","EA","20000","INR","BPM1","2","PRT1","DUMP","HAUL"},
				{"PRT0002","MAT","TORQUE WRENCH 2.3 Nm","EA","30001","INR","BPM1","3","PRT1","DUMP","EXCA"},
				{"PRT0003","MAT","TORQUE WRENCH 5.6 Nm","EA","40002","INR","BPM1","4","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0004","MAT","TORQUE WRENCH 135.6 Nm","EA","50003","INR","BPM1","2","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0005","MAT","HYDRAULIC JACK 2 TON","EA","50004","INR","BPM1","3","PRT1","HAUL","EXCA"},
				{"PRT0006","MAT","TORQUE WRENCH 150 Nm","EA","100000","INR","BPM1","4","PRT1","DUMP","HAUL,EXCA"},
				{"PRT0007","MAT","HYDRAULIC JACK 6 TON","EA","100000","INR","BPM1","5","PRT1","HAUL","EXCA"},
			};
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
		String[][] employeeMaster = new String[][] {
				{"EMPLOYEE ID","EMPLOYEE NAME","DATE OF JOINING","SKILL NUMBER","SKILL DESCRIPTION","WORK CENTER","Dept Id","Shift Grouping","Shift definition","Skill Level"},
				{"03446G","Niraj R Sharma","01.10.2010","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470007","Abhijit C Saha","01.09.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470008","Sudip Dutta","01.07.2011","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","3"},
				{"470009","Raju Parashar","01.10.2012","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470010","Suman Mandal","01.10.2011","I","Instrumentation","MECH","DPT00018","G","07:00 - 17:30","1"},
				{"470011","Jean","01.04.2012","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470012","John","01.01.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470013","Lee","01.12.2011","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"03869A","Subha","01.10.2007","S","Fitter","MECH","DPT00018","A","06:00 - 14:30","1"},
				{"875092","Probal","01.09.2007","S","Supervisor","SUP","SUP00001","B","14:00 - 22:30","1"},
				{"905678","Arnab","01.10.2008","S","Supervisor","SUP","SUP00001","C","22:00 - 06:30","1"},
				{"470015","Santosh","01.05.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470016","Debi","01.12.2012","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","3"},
				{"470017","Niraj Kumar","01.11.2014","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470018","Sankar","01.02.2005","S","Supervisor","SUP","SUP00001","A","06:00 - 14:30","1"},
				{"470019","Terence","01.12.2008","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470020","Jack","01.10.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470021","Jill","01.06.2009","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"470022","Miller","07.11.2014","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470023","Darwin","01.10.2013","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470024","Jackson","01.03.2011","F","Fitter","MECH","DPT00018","A","06:00 - 14:30","3"},
				{"470025","Darwin","01.04.2011","E","Electrician","ELEC","DPT00019","B","14:00 - 22:30","1"},
				{"470026","Roopey","01.03.2011","I","Instrumentation","MECH","DPT00018","G","07:00 - 17:30","1"},
				{"470027","Heli","01.05.2013","E","Electrician","ELEC","DPT00019","C","22:00 - 06:30","1"},
				{"470028","Maija","01.10.2011","F","Fitter","MECH","DPT00018","C","22:00 - 06:30","1"},
				{"470029","Ranjan","16.10.2011","I","Instrumentation","MECH","DPT00018","C","22:00 - 06:30","3"},
				{"470030","Prashant","01.10.2011","E","Electrician","ELEC","DPT00019","A","06:00 - 14:30","2"},
				{"470031","Subha","12.10.2011","F","Fitter","MECH","DPT00018","B","14:00 - 22:30","2"},
				{"470032","Vishwa","11.10.2012","S","Supervisor","SUP","SUP00001","A","06:00 - 14:30","3"},
				{"470033","Peter","21.10.2011","S","Supervisor","SUP","SUP00001","B","14:00 - 22:30","1"},
					};

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
		String[][] problemMaster = new String[][] {
				{"CATALOG PROFILE","Problem ID","Problem Description","Default Dept Id","Default Dept Desc","Operation 1"},
				{"EXCA","PB0000001","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000002","Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000003","MG Set /Engine noise","DPT00018","Mechanical","OPR0000002,OPR0000015,OPR0000016,OPR0000010,OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000004","Tilting","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000012,OPR0000013,OPR0000019"},
				{"EXCA","PB0000005","Swinging Boom","DPT00018","Mechanical","OPR0000022,OPR0000015,OPR0000016,OPR0000013,OPR0000019"},
				{"EXCA","PB0000006","Engine Cooling","DPT00018","Mechanical","OPR0000002,OPR0000010,OPR0000017,OPR0000018,OPR0000019"},
				{"EXCA","PB0000007","Pump Noise","DPT00018","Mechanical","OPR0000021,OPR0000004,OPR0000012,OPR0000013,OPR0000019"},
				{"EXCA","PB0000008","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000010,OPR0000017,OPR0000018,OPR0000019"},
				{"DUMP","PB0000008","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000018,OPR0000019"},
				{"DUMP","PB0000009","Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000018,OPR0000019"},
				{"DUMP","PB0000010","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000019,OPR0000015,OPR0000016"},
				{"DUMP","PB0000011","Tyre Burst","DPT00018","Mechanical","OPR0000006,OPR0000019,"},
				{"DUMP","PB0000012","Engine Cooling","DPT00018","Mechanical","OPR0000024,OPR0000019"},
				{"DUMP","PB0000013","Over Heating","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000022,OPR0000019"},
				{"DUMP","PB0000014","Hyd Leakage","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000011,OPR0000012,OPR0000013,OPR0000019"},
				{"DUMP","PB0000015","Tyre inflation","DPT00018","Mechanical","OPR0000008,OPR0000006,OPR0000019"},
				{"DUMP","PB0000016","Brake Problem","DPT00018","Mechanical","OPR0000007,OPR0000019"},
				{"HAUL","PB0000017","Smoke around Engine area","DPT00018","Mechanical","OPR0000002,OPR0000001,OPR0000010,OPR0000005,OPR0000017,OPR0000018,OPR0000019"},
				{"HAUL","PB0000018","Not Starting","DPT00018","Mechanical","OPR0000017,OPR0000018,OPR0000019"},
				{"HAUL","PB0000019","Engine Noise","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000019"},
				{"HAUL","PB0000020","Engine Cooling","DPT00018","Mechanical","OPR0000024,OPR0000019"},
				{"HAUL","PB0000021","Over Heating","DPT00018","Mechanical","OPR0000002,OPR0000023,OPR0000022,OPR0000019"},
				{"HAUL","PB0000022","Hyd Leakage","DPT00018","Mechanical","OPR0000020,OPR0000021,OPR0000011,OPR0000012,OPR0000013,OPR0000019"},
				{"HAUL","PB0000023","Brake Problem","DPT00018","Mechanical","OPR0000007,OPR0000019"},
				{"HAUL","PB0000024","Tyre inflation","DPT00018","Mechanical","OPR0000008,OPR0000006,OPR0000019"},
				{"HAUL","PB0000025","Axle Problem","DPT00018","Mechanical","OPR0000025,OPR0000026,OPR0000027,OPR0000028,OPR0000019"},
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

		String[][] operationMaster = new String[][] {
				{"Operation ID","Dept Id","Dept Desc","Operation short text","No of Emp","Avg Duration (hrs)","Rate per hr","Task Manual"},
				{"OPR0000001","DPT00018","Mechanical","Dismantle from the Equipment","2","2","1000","OpProc_OPR0000001.pdf"},
				{"OPR0000002","DPT00018","Mechanical","Check the Engine / MGSET parameters","1","3","2389","OpProc_OPR0000002.pdf"},
				{"OPR0000003","DPT00018","Mechanical","Check the oil Filter","1","1","6086","OpProc_OPR0000003.pdf"},
				{"OPR0000004","DPT00019","Electrical","Check the Electricals/motor","2","3","4800","OpProc_OPR0000004.pdf"},
				{"OPR0000005","DPT00018","Mechanical","Install back","2","2","6254","OpProc_OPR0000005.pdf"},
				{"OPR0000006","DPT00018","Mechanical","Replace Trye","2","2","3405","OpProc_OPR0000006.pdf"},
				{"OPR0000007","DPT00018","Mechanical","Replace Brake","1","3","2741","OpProc_OPR0000007.pdf"},
				{"OPR0000008","DPT00018","Mechanical","Check Inflation & inflate","1","1","4329","OpProc_OPR0000008.pdf"},
				{"OPR0000009","DPT00018","Mechanical","Check cooling system","2","3","2806","OpProc_OPR0000009.pdf"},
				{"OPR0000010","DPT00018","Mechanical","Replace engine/ MG set","2","2","2001","OpProc_OPR0000010.pdf"},
				{"OPR0000011","DPT00018","Mechanical","Replace hydraulic valves","2","2","4575","OpProc_OPR0000011.pdf"},
				{"OPR0000012","DPT00018","Mechanical","Replace Pump","1","3","2972","OpProc_OPR0000012.pdf"},
				{"OPR0000013","DPT00018","Mechanical","Replace hydraulic circuit","1","1","3831","OpProc_OPR0000013.pdf"},
				{"OPR0000014","DPT00018","Mechanical","change bucket teeth","2","3","3675","OpProc_OPR0000014.pdf"},
				{"OPR0000015","DPT00018","Mechanical","check bucket alignment","2","2","4953","OpProc_OPR0000015.pdf"},
				{"OPR0000016","DPT00019","Electrical","Check the MG Set","2","1","6453","OpProc_OPR0000016.pdf"},
				{"OPR0000017","DPT00018","Mechanical","check ignition","2","2","3932","OpProc_OPR0000017.pdf"},
				{"OPR0000018","DPT00018","Mechanical","Replace ignition switch","2","2","6473","OpProc_OPR0000018.pdf"},
				{"OPR0000019","DPT00018","Mechanical","Handover of euqipment - trial","1","2","6414","OpProc_OPR0000019.pdf"},
				{"OPR0000020","DPT00018","Mechanical","Chech HYD circuits","1","2","3679","OpProc_OPR0000020.pdf"},
				{"OPR0000021","DPT00018","Mechanical","Check Hyd Pump","1","2","2681","OpProc_OPR0000021.pdf"},
				{"OPR0000022","DPT00018","Mechanical","Chech Alignment","1","2","5437","OpProc_OPR0000022.pdf"},
				{"OPR0000023","DPT00018","Mechanical","Check for engine / drive coupling","1","2","4474","OpProc_OPR0000023.pdf"},
				{"OPR0000024","DPT00018","Mechanical","Check engine cooling system","1","2","6333","OpProc_OPR0000024.pdf"},
				{"OPR0000025","DPT00018","Mechanical","Check crown wheel/ alignment","2","2","4117","OpProc_OPR0000025.pdf"},
				{"OPR0000026","DPT00018","Mechanical","Dismantle axle","1","2","4937","OpProc_OPR0000026.pdf"},
				{"OPR0000027","DPT00018","Mechanical","Check greasing","0","2","5037","OpProc_OPR0000027.pdf"},
				{"OPR0000028","DPT00018","Mechanical","Assemble Axle","0","2","4508","OpProc_OPR0000028.pdf"},
		};

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
