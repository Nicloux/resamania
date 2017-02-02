package com.resamania.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Coach {
	
	@JsonProperty
	private int id;
	
	@JsonIgnore
	private int defaultNbPlace;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String name;
    
    @JsonProperty
    private String surname;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String description;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String shortDescription;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String beginDate;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String endDate;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String mail;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String phone;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private boolean disabled = false;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String subname;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private int supplierId;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private int storedFileId;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private int onlineToolTipStoredFileId;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private int userId;
    
    public Coach() {}

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDefaultNbPlace() {
		return defaultNbPlace;
	}

	public void setDefaultNbPlace(int defaultNbPlace) {
		this.defaultNbPlace = defaultNbPlace;
	} 
}
