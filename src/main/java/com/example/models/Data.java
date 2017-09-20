package com.example.models;

import org.apache.commons.collections4.map.MultiValueMap;

public class Data {
	private MultiValueMap<String, String> counties;
    private MultiValueMap <String,String> subcountyid;
    private MultiValueMap<String, String> subcounties;
	private MultiValueMap<String, String> ward;
	
	public MultiValueMap<String, String> getSubcountyid() {
		return subcountyid;
	}

	public MultiValueMap<String, String> getCounties() {
		return counties;
	}
	
	
	public MultiValueMap<String, String> getSubcounties() {
		return subcounties;
	}
	
	public MultiValueMap<String,String> getWard() {
		return ward;
	}
	
	public void setSubcounties(MultiValueMap<String, String> d) {
		this.subcounties = d;
	}
	
	public void setWard(MultiValueMap<String, String> e) {
		this.ward = e;
	}
	public void setCounties(MultiValueMap<String, String> counties) {
		// TODO Auto-generated method stub
		this.counties = counties;
	}
	public void setSubcountyid(MultiValueMap<String, String> subcountyid) {
		// TODO Auto-generated method stub
		this.subcountyid = subcountyid;

	}
	
}
