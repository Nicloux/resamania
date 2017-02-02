package com.resamania.booking.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Activity {
	
	@JsonProperty
	private int id;
	
	@JsonProperty
    private String name;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String description;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String shortDescription;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int nbMaxLockOnlineInscription;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int maxOnlineInscription;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String duration;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private boolean disabled;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String subname;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String beginDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String endDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int supplierId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String colorCode;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int storedFileId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int onlineToolTipStoredFileId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private int defaultNbPlace;
    
    public Activity() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getNbMaxLockOnlineInscription() {
		return nbMaxLockOnlineInscription;
	}

	public void setNbMaxLockOnlineInscription(int nbMaxLockOnlineInscription) {
		this.nbMaxLockOnlineInscription = nbMaxLockOnlineInscription;
	}

	public int getMaxOnlineInscription() {
		return maxOnlineInscription;
	}

	public void setMaxOnlineInscription(int maxOnlineInscription) {
		this.maxOnlineInscription = maxOnlineInscription;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public int getStoredFileId() {
		return storedFileId;
	}

	public void setStoredFileId(int storedFileId) {
		this.storedFileId = storedFileId;
	}

	public int getOnlineToolTipStoredFileId() {
		return onlineToolTipStoredFileId;
	}

	public void setOnlineToolTipStoredFileId(int onlineToolTipStoredFileId) {
		this.onlineToolTipStoredFileId = onlineToolTipStoredFileId;
	}

	public int getDefaultNbPlace() {
		return defaultNbPlace;
	}

	public void setDefaultNbPlace(int defaultNbPlace) {
		this.defaultNbPlace = defaultNbPlace;
	}
}
