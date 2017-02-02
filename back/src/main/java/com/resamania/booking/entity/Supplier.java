package com.resamania.booking.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Supplier {
	
	@JsonProperty
	private int id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String description;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String shortDescription;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private boolean disable;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String address;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String postcode;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String city;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String phone;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String mail;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String website;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String payeeSocialName;
    
    public Supplier() {}

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

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPayeeSocialName() {
		return payeeSocialName;
	}

	public void setPayeeSocialName(String payeeSocialName) {
		this.payeeSocialName = payeeSocialName;
	}
    
}
