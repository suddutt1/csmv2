package com.ibm.app.csm.helper;


import com.google.gson.Gson;

public class JsonUtilityClass {
	public static String toJSON(Object object){
		Gson gson=new Gson();
		return gson.toJson(object);
	}
	public static String toJSON(Object[]array){
		return new Gson().toJson(array);
	}
	public static <T> T fromJSON(String jsonText,Class<T> cls) {
		return new Gson().fromJson(jsonText, cls);
		
	}
}
