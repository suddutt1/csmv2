package com.ibm.app.csm.data;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class SparesMaster {

	private ObjectId id;
	private String objType = "spares_master";
	private String materialNumber;
	private String description;
	private String unitOfMeasure;
	private double amountInCurrency;
	private String currency;
	private String plant;
	private double stockQty;
	private String storageLocation;
	private String[] catalogProfileList;

	private double displayQuantityRequird;
	
	public SparesMaster() {

	}
	public SparesMaster(SparesMaster otherObj) {

		this.id= otherObj.getId();
		this.objType= otherObj.getObjType();
		this.materialNumber= otherObj.getMaterialNumber();
		this.description= otherObj.getDescription();
		this.unitOfMeasure= otherObj.getUnitOfMeasure();
		this.amountInCurrency= otherObj.getAmountInCurrency();
		this.currency= otherObj.getCurrency();
		this.plant= otherObj.getPlant();
		this.stockQty= otherObj.getStockQty();
		this.storageLocation= otherObj.getStorageLocation();
		this.catalogProfileList= otherObj.getCatalogProfileList();
		this.displayQuantityRequird= otherObj.getDisplayQuantityRequird();
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
	 * @return the materialNumber
	 */
	public String getMaterialNumber() {
		return materialNumber;
	}

	/**
	 * @param materialNumber
	 *            the materialNumber to set
	 */
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
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

	/**
	 * @return the displayQuantityRequird
	 */
	public double getDisplayQuantityRequird() {
		return displayQuantityRequird;
	}

	/**
	 * @param displayQuantityRequird the displayQuantityRequird to set
	 */
	public void setDisplayQuantityRequird(double displayQuantityRequird) {
		this.displayQuantityRequird = displayQuantityRequird;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("materialNumber", this.materialNumber);
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
	public static SparesMaster parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			SparesMaster parsedObject = new SparesMaster();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setMaterialNumber((String) dbObject
					.get("materialNumber"));
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
