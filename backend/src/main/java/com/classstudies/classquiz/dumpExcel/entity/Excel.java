package com.classstudies.classquiz.dumpExcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "excel_data")
public class Excel {
	
	@Id
	private Double policyId;
	
	private String expiryMonth;
	private String location;
	private String state;
	private String region;
	private String insuredValue;
	private String construction;
	private String businessType;
	
	public Excel() {}

	public Excel(Double policyId, String expiryMonth, String location, String state, String region, String insuredValue,
			String construction, String businessType) {
		super();
		this.policyId = policyId;
		this.expiryMonth = expiryMonth;
		this.location = location;
		this.state = state;
		this.region = region;
		this.insuredValue = insuredValue;
		this.construction = construction;
		this.businessType = businessType;
	}

	public Double getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Double policyId) {
		this.policyId = policyId;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getInsuredValue() {
		return insuredValue;
	}

	public void setInsuredValue(String insuredValue) {
		this.insuredValue = insuredValue;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	
	
}
