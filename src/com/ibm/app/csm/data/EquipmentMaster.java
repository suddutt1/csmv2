package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class EquipmentMaster {

	private ObjectId id;
	private String objType = "equipment_master";
	private String equipmentNumber;
	private String plant;
	private String description;
	private String modelNumber;
	private String serialNumber;
	private String manufacturer;
	private Date installationDate;
	private double ratePerHour;
	private String currency;
	private String pdfDoc;
	private String catalogProfile;
	private String standardOperatingProcedure;

	public EquipmentMaster() {

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
	 * @return the equipmentNumber
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	/**
	 * @param equipmentNumber
	 *            the equipmentNumber to set
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
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
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	/**
	 * @param modelNumber
	 *            the modelNumber to set
	 */
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the installationDate
	 */
	public Date getInstallationDate() {
		return installationDate;
	}

	/**
	 * @param installationDate
	 *            the installationDate to set
	 */
	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	/**
	 * @return the ratePerHour
	 */
	public double getRatePerHour() {
		return ratePerHour;
	}

	/**
	 * @param ratePerHour
	 *            the ratePerHour to set
	 */
	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
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
	 * @return the pdfDoc
	 */
	public String getPdfDoc() {
		return pdfDoc;
	}

	/**
	 * @param pdfDoc
	 *            the pdfDoc to set
	 */
	public void setPdfDoc(String pdfDoc) {
		this.pdfDoc = pdfDoc;
	}

	/**
	 * @return the catalogProfile
	 */
	public String getCatalogProfile() {
		return catalogProfile;
	}

	/**
	 * @param catalogProfile
	 *            the catalogProfile to set
	 */
	public void setCatalogProfile(String catalogProfile) {
		this.catalogProfile = catalogProfile;
	}

	/**
	 * @return the standardOperatingProcedure
	 */
	public String getStandardOperatingProcedure() {
		return standardOperatingProcedure;
	}

	/**
	 * @param standardOperatingProcedure
	 *            the standardOperatingProcedure to set
	 */
	public void setStandardOperatingProcedure(String standardOperatingProcedure) {
		this.standardOperatingProcedure = standardOperatingProcedure;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("equipmentNumber", this.equipmentNumber);
		dbObject.put("plant", this.plant);
		dbObject.put("description", this.description);
		dbObject.put("modelNumber", this.modelNumber);
		dbObject.put("serialNumber", this.serialNumber);
		dbObject.put("manufacturer", this.manufacturer);
		dbObject.put("installationDate", this.installationDate);
		dbObject.put("ratePerHour", this.ratePerHour);
		dbObject.put("currency", this.currency);
		dbObject.put("pdfDoc", this.pdfDoc);
		dbObject.put("catalogProfile", this.catalogProfile);
		dbObject.put("standardOperatingProcedure",
				this.standardOperatingProcedure);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static EquipmentMaster parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			EquipmentMaster parsedObject = new EquipmentMaster();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setEquipmentNumber((String) dbObject
					.get("equipmentNumber"));
			parsedObject.setPlant((String) dbObject.get("plant"));
			parsedObject.setDescription((String) dbObject.get("description"));
			parsedObject.setModelNumber((String) dbObject.get("modelNumber"));
			parsedObject.setSerialNumber((String) dbObject.get("serialNumber"));
			parsedObject.setManufacturer((String) dbObject.get("manufacturer"));
			parsedObject.setInstallationDate((Date) dbObject
					.get("installationDate"));
			parsedObject.setRatePerHour((Double) dbObject.get("ratePerHour"));
			parsedObject.setCurrency((String) dbObject.get("currency"));
			parsedObject.setPdfDoc((String) dbObject.get("pdfDoc"));
			parsedObject.setCatalogProfile((String) dbObject
					.get("catalogProfile"));
			parsedObject.setStandardOperatingProcedure((String) dbObject
					.get("standardOperatingProcedure"));
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
