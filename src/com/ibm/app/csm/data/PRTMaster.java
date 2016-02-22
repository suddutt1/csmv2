package com.ibm.app.csm.data;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PRTMaster {

	private ObjectId id;
	private String objType = "prt_master";
	private String prtNumber;
	private String prtType;
	private String description;
	private String unitOfMeasure;
	private double amountInCurrency;
	private String currency;
	private String plant;
	private double stockQty;
	private String storageLocation;
	private String[] catalogProfileList;
	

	public PRTMaster() {
		super();
	}

	public PRTMaster(PRTMaster otherObj)
	{
		super();
		this.id= otherObj.getId();
		this.objType= otherObj.getObjType();
		this.prtNumber= otherObj.getPrtNumber();
		this.prtType= otherObj.getPrtType();
		this.description= otherObj.getDescription();
		this.unitOfMeasure= otherObj.getUnitOfMeasure();
		this.amountInCurrency= otherObj.getAmountInCurrency();
		this.currency= otherObj.getCurrency();
		this.plant= otherObj.getPlant();
		this.stockQty= otherObj.getStockQty();
		this.storageLocation= otherObj.getStorageLocation();
		this.catalogProfileList= otherObj.getCatalogProfileList();

	}
	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the objType
	 */
	public String getObjType() {
		return objType;
	}

	/**
	 * @param objType
	 *            the objType to set
	 */
	public void setObjType(String objType) {
		this.objType = objType;
	}

	/**
	 * @return the prtNumber
	 */
	public String getPrtNumber() {
		return prtNumber;
	}

	/**
	 * @param prtNumber
	 *            the prtNumber to set
	 */
	public void setPrtNumber(String prtNumber) {
		this.prtNumber = prtNumber;
	}

	/**
	 * @return the prtType
	 */
	public String getPrtType() {
		return prtType;
	}

	/**
	 * @param prtType
	 *            the prtType to set
	 */
	public void setPrtType(String prtType) {
		this.prtType = prtType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure
	 *            the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return the amountInCurrency
	 */
	public double getAmountInCurrency() {
		return amountInCurrency;
	}

	/**
	 * @param amountInCurrency
	 *            the amountInCurrency to set
	 */
	public void setAmountInCurrency(double amountInCurrency) {
		this.amountInCurrency = amountInCurrency;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}

	/**
	 * @param plant
	 *            the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
	 * @return the stockQty
	 */
	public double getStockQty() {
		return stockQty;
	}

	/**
	 * @param stockQty
	 *            the stockQty to set
	 */
	public void setStockQty(double stockQty) {
		this.stockQty = stockQty;
	}

	/**
	 * @return the storageLocation
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * @param storageLocation
	 *            the storageLocation to set
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	/**
	 * @return the catalogProfileList
	 */
	public String[] getCatalogProfileList() {
		return catalogProfileList;
	}

	/**
	 * @param catalogProfileList
	 *            the catalogProfileList to set
	 */
	public void setCatalogProfileList(String[] catalogProfileList) {
		this.catalogProfileList = catalogProfileList;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("prtNumber", this.prtNumber);
		dbObject.put("prtType", this.prtType);
		dbObject.put("description", this.description);
		dbObject.put("unitOfMeasure", this.unitOfMeasure);
		dbObject.put("amountInCurrency", this.amountInCurrency);
		dbObject.put("currency", this.currency);
		dbObject.put("plant", this.plant);
		dbObject.put("stockQty", this.stockQty);
		dbObject.put("storageLocation", this.storageLocation);
		dbObject.put("catalogProfileList", this.catalogProfileList);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static PRTMaster parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			PRTMaster parsedObject = new PRTMaster();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setPrtNumber((String) dbObject.get("prtNumber"));
			parsedObject.setPrtType((String) dbObject.get("prtType"));
			parsedObject.setDescription((String) dbObject.get("description"));
			parsedObject.setUnitOfMeasure((String) dbObject
					.get("unitOfMeasure"));
			parsedObject.setAmountInCurrency((double) dbObject
					.get("amountInCurrency"));
			parsedObject.setCurrency((String) dbObject.get("currency"));
			parsedObject.setPlant((String) dbObject.get("plant"));
			parsedObject.setStockQty((double) dbObject.get("stockQty"));
			parsedObject.setStorageLocation((String) dbObject
					.get("storageLocation"));
			BasicDBList list =(BasicDBList) dbObject
					.get("catalogProfileList");
			if(list!=null)
			{
				String[] objArray = list.toArray(new String[list.size()]);
				parsedObject.setCatalogProfileList(objArray );
			}
			return parsedObject;
		}
		return null;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
