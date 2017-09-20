package com.example.service;

import java.util.List;


public class JsonResponse {

	private Data info;

	public Data getData() {
	    return info;
	}

	public void setData(Data info) {
	    this.info = info;
	}

	public class Data {

	    private String response;
	    private String county;
	    private String name;

	    private List<String> subcounty;
	    private List<List<String>> wards;
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getCounty() {
			return county;
		}
		public void setCounty(String countyname) {
			this.county = countyname;
		}
		public List<String> getSubcounty() {
			return subcounty;
		}
		public void setSubcounty(List<String> subcounty) {
			this.subcounty = subcounty;
		}
		public List<List<String>> getWards() {
			return wards;
		}
		public void setWards(List<List<String>> parentList) {
			this.wards = parentList;
		}
	   
	    
	}
    
   
}
